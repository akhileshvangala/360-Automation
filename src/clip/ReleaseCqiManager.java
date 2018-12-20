package clip;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ReleaseCqiManager {
	
	public static final String TABLE_NAME = "OPSBI_360_DTLS_RELEASE";
	public static final String API_URL = "http://wwwin-cqi.cisco.com/cqiservices/api/widget/";
	public static final String USER_ID = "akvangal";
	public static final String BU_NAME = "CSG";
	public static final String ID_DB_NAME = "ID";
	public static final String VIEW_ID_DB_NAME = "VIEW_ID";
	public static final String CD_DB_NAME = "CD";
	
	public static void run() {
		for (ViewData viewData : getViewData()) {
			
			updateDb(viewData.id, "COUNT", readSource(viewData.id, "COUNT"));
			updateDb(viewData.id, "MTTR", readSource(viewData.id, "MTTR"));
			
		}
	}
	
	private static List<ViewData> getViewData() {
		BufferedReader rd;
		List<ViewData> results = new ArrayList<>();
		rd = Util.httpGet(API_URL + "viewsMappedToUser?ViewType=Release&BuName=" + BU_NAME + "&UserID=" + USER_ID, true);
		try {
			JsonObject jObj = new Gson().fromJson(rd.readLine(), JsonObject.class);
			JsonArray viewArray = jObj.get("data").getAsJsonArray();
			System.out.println(viewArray);
			int len = viewArray.size();
			for (int i = 0; i < len; i++) {
				JsonObject view = viewArray.get(i).getAsJsonObject();
				ViewData viewData = new ViewData();
				viewData.name = view.get("ViewName").getAsString();
				viewData.id = view.get("ViewID").getAsInt();
				results.add(viewData);
			}
			return results;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static JsonObject readSource(int viewId, String cd) {
		Map<String, Object> params = new HashMap<>();
		params.put("ViewID", viewId);
		params.put("Metrics", ReleaseCqiField.getMetrics(cd));
		params.put("Primary", "Y");
		params.put("Weeks", 4);
		params.put("ViewType", "Release");
		
		BufferedReader rd = Util.httpJsonPost(API_URL+"viewIdDefectData", params, true);
		StringBuilder builder = new StringBuilder();
	    try {
	    	JsonObject data = null ;
	    	String line = null;
			while ((line = rd.readLine()) != null) {
				builder.append(line);
			}
			rd.close();

			JsonObject jObj = new Gson().fromJson(builder.toString(), JsonObject.class);			
			JsonArray array =  jObj.get("data").getAsJsonArray();
			if(array.size()<1){
			}
			else{
				 data = (JsonObject) array.get(0);
			}
			
			return data;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static void updateDb(int id, String cd, JsonObject jObj) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ").append(TABLE_NAME).append(" (");
		sb.append("VIEW_ID, CD");
		for (ReleaseCqiField field : ReleaseCqiField.values()) {
			if (field.cd != null && !field.cd.equalsIgnoreCase(cd)) continue;
			sb.append(", ").append(field.dbName);
		}
		sb.append(") VALUES (").append(id).append(", '").append(cd).append("'");
		for (ReleaseCqiField field : ReleaseCqiField.values()) {
			//System.out.println(field.cqiName);
		}
		for (ReleaseCqiField field : ReleaseCqiField.values()) {
			if (field.cd != null && !field.cd.equalsIgnoreCase(cd)) continue;
			//System.out.println(field.cqiName);
			JsonElement element = null;
			
			try{
			 element = jObj.get(field.cqiName);
			}catch(Exception e){
				element = new JsonObject();
			}
			sb.append(", ");
			if (field.dataType == DataType.INTEGER) {
				if (element != null && !element.isJsonNull() && !element.isJsonObject()) sb.append(element.getAsInt());
				else sb.append("0");
			} else if (field.dataType == DataType.NUMBER) {
				if (element != null && !element.isJsonNull() && !element.isJsonObject()) sb.append(element.getAsFloat());
				else sb.append("0");
			}
			else if (field.dataType == DataType.VARCHAR2) {
				if (element != null && !element.isJsonNull() && !element.isJsonObject()) sb.append(Util.formatJsonString(element));
				else if(!element.isJsonObject()) sb.append(", ").append("\'\'");
				else sb.append("\'\'");
			}  else throw new Error("Unknown datatype: " + field.dataType);
		}
		sb.append(")");
		//System.out.println(sb.toString());

		try {
			Util.query(sb.toString()).close();
		} catch (SQLException e) {
			//e.printStackTrace();
		}
	}
}
