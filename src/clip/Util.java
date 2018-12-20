package clip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Map;

//import com.google.gson.JsonElement;

public class Util {
	private Util() {}
	
	private static Connection conn = null;
	
	public static BufferedReader httpGet(String url, Boolean includeCredentials) {
		try {
			URL urlObj = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
			conn.setRequestMethod("GET");
			if (includeCredentials) {
				String auth = Credentials.USERNAME + ":" + Credentials.PASSWORD;
				String authEncoded = Base64.getEncoder().encodeToString(auth.getBytes());
				conn.setRequestProperty("Authorization", "Basic " + authEncoded);
			}
		    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			return rd;
		} catch (ProtocolException e) {
			e.printStackTrace();
		}catch(JsonSyntaxException e) {
				e.printStackTrace();	
			}
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void clearTable(String tableName){
		System.out.println("Clearing Table: " + tableName);
		try {
			Util.query("truncate table " + tableName).close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String formatJsonString(JsonElement jElement) {
		return ("'" + jElement.toString().substring(1, jElement.toString().length()-1).replaceAll("'", "''") + "'");
	}
	
	public static void resetSequence(String sequenceName) {
		try {
			Util.query("DROP SEQUENCE " + sequenceName).close();
			Util.query("CREATE SEQUENCE " + sequenceName + " START WITH 1").close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static BufferedReader httpJsonPost(String url, Map<String, Object> params, Boolean includeCredentials) {
		try {
			URL urlObj = new URL(url);
			
			StringBuilder postData = new StringBuilder();
			postData.append("{");
			boolean firstParam = true;
	        for (Map.Entry<String,Object> param : params.entrySet()) {
	        	if (!firstParam) postData.append(',');
	        	else firstParam = false;
	            postData.append("\"").append(URLEncoder.encode(param.getKey(), "UTF-8")).append("\"");
	            postData.append(':');
	            Object value = param.getValue();
	            if (value instanceof String) postData.append("\"").append(URLEncoder.encode(String.valueOf(value), "UTF-8")).append("\"");
	            else if (value instanceof String[]) {
	            	postData.append("[");
	            	String[] array = (String[]) value;
	            	boolean firstElement = true;
	            	for (String item : array) {
	            		if (firstElement) firstElement = false;
	            		else postData.append(",");
	            		postData.append("\"").append(item).append("\"");
	            	}
	            	postData.append("]");
	            } 
	            else if (value instanceof Integer) postData.append(URLEncoder.encode(String.valueOf(value), "UTF-8"));
	            else throw new Error("Unknown parameter value type for key: " + param.getKey());
	        }
	        postData.append("}");
	        byte[] postDataBytes = postData.toString().getBytes(StandardCharsets.UTF_8);

	        HttpURLConnection conn = (HttpURLConnection)urlObj.openConnection();
	        if (includeCredentials) {
				String auth = Credentials.USERNAME + ":" + Credentials.PASSWORD;
				String authEncoded = Base64.getEncoder().encodeToString(auth.getBytes());
				conn.setRequestProperty("Authorization", "Basic " + authEncoded);
			}
	        conn.setRequestMethod("POST");
	        conn.setUseCaches (false);
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setRequestProperty("charset", "utf-8");
	        conn.setDoOutput(true);
	        conn.getOutputStream().write(postDataBytes);
	        conn.getOutputStream().flush();
	        conn.getOutputStream().close();

	        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	        
	        return rd;
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Connection getConnection() {
		if (conn == null) {
			try {
				String url = "jdbc:oracle:thin:@" + ServerInfo.HOST + ":" + ServerInfo.PORT;
				if (ServerInfo.SID != null) url += ":" + ServerInfo.SID;
				else if (ServerInfo.SERVICE_NAME != null) url += "/" + ServerInfo.SERVICE_NAME;
				else throw new Error("Must specify server SID or SERVICE_NAME.");
				conn = DriverManager.getConnection(url, ServerInfo.USERNAME, ServerInfo.PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public static ResultSet query(String query) {
		if (conn == null) Util.getConnection();
		try {
			return conn.createStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void disposeConnection() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
