package clip;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CapClipManager1 {
	
	public static final String TABLE_NAME = "OPSBI_360_DTLS_BEMS_RRR";
	
	private CapClipManager1() {}
	
	public static void updateQuery(DataQuery query) {
		System.out.println("Updating MyClip Query: " + query.queryCd);
		if (!query.srcAppNm.trim().toLowerCase().equals("clip")) throw new Error("srcAppNm must be \"CLIP\".");
		String csvUrl = generateCsvUrl(query.srcDataQry);
		//if (!csvUrl.equals(query.srcCsvPath)) updateCsvPath(query.queryCd, csvUrl);
		System.out.println("Csv URL : "+query.srcCsvPath);
		updateDatabase(query, readCsvTable(query.srcCsvPath));
	}
	
	private static void updateCsvPath(String queryCd, String csvPath) {
		StringBuilder sb = new StringBuilder()
			.append("UPDATE ")
			.append(App.DATA_QUERY_TABLE_NAME)
			.append(" SET SRC_CSV_PATH = '")
			.append(csvPath)
			.append("' WHERE QUERY_CD = '")
			.append(queryCd)
			.append("'");
		
		try {
			Util.query(sb.toString()).close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static String generateCsvUrl(String queryUrl) {
		String id = queryUrl.split("/")[7];
		return ("https://clpsvs.cloudapps.cisco.com/services/clip/main/myclip/exportTransactions?tab=ENGAGEMENT&filterId=" + id);
	}
	
	private static void updateDatabase(DataQuery query, List<HashMap<String, String>> table) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT ALL");
		boolean recordsAdded = false;
		for (HashMap<String, String> row : table) {
			if (engagementExists(row.get(CapClipField.ENGAGEMENT_ID.csvName), query.targetTable)) continue;
			recordsAdded = true;
			
			StringBuilder columns = new StringBuilder();
			StringBuilder values = new StringBuilder();
			
			columns.append("QUERY_CD, ");
			values.append("'").append(query.queryCd).append("', ");
			
			for (CapClipField field : CapClipField.values()) {
				
				String value = row.get(field.csvName);
				if (value == null) continue;
				value = value.replaceAll("'", "''"); // escaping single quote
				columns.append(field.dbName).append(", ");
				if (field.dataType == DataType.VARCHAR2) {
					values.append("'").append(value).append("', ");
				} else if (field.dataType == DataType.NUMBER) {
					values.append(value).append(", ");
				} else if (field.dataType == DataType.DATE) {
					values.append("TO_DATE('").append(value).append("'), ");
				} else {
					throw new Error("Unsupported DataType.");
				}
			}
			
			columns.setLength(columns.length() - 2); //remove trailing space and comma
			values.setLength(values.length() - 2); //remove trailing space and comma
			
			sb.append(" INTO ").append(query.targetTable).append(" (").append(columns).append(") VALUES (").append(values).append(") ");
		}
		
		
		if (!recordsAdded) return;
		
		sb.append("SELECT * FROM dual");
		try {
			System.out.println(sb.toString());
			Util.query(sb.toString()).close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean engagementExists(String value, String tableName) {
		if (value == null) return false;
		String q = "SELECT * FROM " + tableName + " WHERE " + CapClipField.ENGAGEMENT_ID.dbName + " = '" + value + "'";
		ResultSet set = Util.query(q);
		try {
			boolean exists = set.next();
			set.close();
			return exists;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static List<HashMap<String, String>> readCsvTable(String url) {
		try {
			BufferedReader rd = Util.httpGet(url, true);
		    String line = rd.readLine();
		    
		    System.out.println(line);
		    
		    ArrayList<HashMap<String, String>> table = new ArrayList<>();
		    
		    String[] headers = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); //remove commas not in quotes.
		    
		    int len = headers.length;
		    for (int i = 0; i < len; i++) {
		    	headers[i] = headers[i].replaceAll("[^()A-Za-z0-9_\\- ]", ""); //remove odd characters
		    }
		    
		    while ((line = rd.readLine()) != null) {
		    	System.out.println(line);
		    	HashMap<String, String> row = new HashMap<>();
		    	String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); //remove commas not in quotes.
		    	for (int i = 0; i < len; i++) {
		    		fields[i] = fields[i].replaceAll("\"", ""); //remove quotes
		    		if (fields.length >= i+1) row.put(headers[i], fields[i]);
		    	}
		    	table.add(row);
		    }
		    rd.close();
		    
		    return table;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
