package clip;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class EngDbManager {
	
	public final static String TABLE_NAME = "OPSBI_360_DTLS_CAP_ENG";
	
	private final static String START_STRING = "var cases = ";
	private final static String END_STRING = "];";
	
	private EngDbManager() {}
	
	public static void updateQuery(DataQuery query) {
		System.out.println("Updating Escalation Dashboard Query: " + query.queryCd);
		JsonArray records = fetchJsonRecords(query.srcDataQry);
		updateDb(query.queryCd, records);
	}
	
	private static JsonArray fetchJsonRecords(String url) {
		StringBuilder sb = new StringBuilder();
		BufferedReader rd = Util.httpGet(url, true);
		String line = null;
		try {
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			String result = sb.substring(sb.indexOf(START_STRING) + START_STRING.length());
			result = result.substring(0, result.indexOf(END_STRING)+1);
			JsonArray jArray = new Gson().fromJson(result, JsonArray.class);
			return jArray;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static void updateDb(String queryCd, JsonArray records) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT ALL");
		
		boolean recordsAdded = false;
		
		int len = records.size();
		for (int i = 0; i < len; i++) {
			JsonObject jObj = (JsonObject) records.get(i);
			
			int index = jObj.get(EngDbField.CAP_INDEX.escalationName).getAsInt();
			if (indexExists(index)) continue;
			recordsAdded = true;
			
			sb.append(" INTO ").append(TABLE_NAME).append(" (QUERY_CD");
			for (EngDbField field : EngDbField.values()) {
				sb.append(", ").append(field.dbName);
			}
			sb.append(") VALUES (").append("'").append(queryCd).append("'");
			for (EngDbField field : EngDbField.values()) {
				sb.append(", ");
				JsonElement jElement = jObj.get(field.escalationName);
				if (field.dataType == DataType.VARCHAR2) {
					sb.append(Util.formatJsonString(jElement));
				} else if (field.dataType == DataType.NUMBER) {
					sb.append(jElement);
				} else if (field.dataType == DataType.DATE) {
					sb.append("TO_DATE(").append(Util.formatJsonString(jElement)).append(",'yyyy-mm-dd')");
				} else if (field.dataType == DataType.DATE_OBJ) {
					if (jElement != null && !jElement.isJsonNull()) {
						JsonObject fObj = jElement.getAsJsonObject();
						int year = fObj.get("year").getAsInt() + 1900;
						int month = fObj.get("month").getAsInt() + 1;
						int day = fObj.get("day").getAsInt() + 1;
						sb
							.append("TO_DATE('")
							.append(year)
							.append("-")
							.append(month)
							.append("-")
							.append(day)
							.append(" ")
							.append(fObj.get("hours").getAsInt())
							.append(":")
							.append(fObj.get("minutes").getAsInt())
							.append(":")
							.append(fObj.get("seconds").getAsInt())
							.append("','yyyy-mm-dd HH24:MI:SS')");
					} else {
						sb.append(jElement);
					}
				}
			}
			sb.append(")");
		}
		
		if (!recordsAdded) return;
		
		sb.append(" SELECT * FROM dual");
		try {
			Util.query(sb.toString()).close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean indexExists(int value) {
		ResultSet set = Util.query("SELECT * FROM " + TABLE_NAME + " WHERE " + EngDbField.CAP_INDEX.dbName + " = " + value);
		try {
			boolean exists = set.next();
			set.close();
			return exists;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
