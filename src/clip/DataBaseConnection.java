package clip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
	
	public static String URL;
	public static String queryCD;
	public static  String  getURLFromDataBase(String dataName) throws ClassNotFoundException, SQLException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
	    
	   Statement smt = conn.createStatement();		
	   String getQuery = "SELECT  SRC_DATA_QRY FROM OPSBI_360_SOURCE_DATA_QUERIES WHERE QUERY_CD = '"+dataName+"'";
	   ResultSet rs=  smt.executeQuery(getQuery);
	  
	while (rs.next()) {
		  URL =  rs.getString("SRC_DATA_QRY");
		 
		}
	
	return URL;
	}
	
public static String getQueryCodeFromDataBase(String dataName) throws ClassNotFoundException, SQLException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
	    
	   Statement smt = conn.createStatement();		
	   String getQuery = "SELECT  QUERY_CD FROM OPSBI_360_SOURCE_DATA_QUERIES WHERE SUBJ_AREA_NM = '"+dataName+"'";
	   ResultSet rs=  smt.executeQuery(getQuery);
	  
	while (rs.next()) {
		  queryCD =  rs.getString("QUERY_CD");
		  
		}
	
	return queryCD;
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		System.out.println(getQueryCodeFromDataBase("TAC_SR_B1"));
		
		
	}
	
	

	
	
	
	
	

}