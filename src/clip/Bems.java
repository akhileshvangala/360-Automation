package clip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bems {
	static String count,count1,count3,count4,count5,count6,count7;
	static String access_Switching, core_Switching,Routing,Wireless,DNAC,SPA,IOT;

	static int count2;
	static WebDriver driver;
	static String qry_param;
	String connectionURL;
	Connection conn;
	Statement smt;
	
	// Switching-Access
	public static void main(String args[]) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");	
   driver =new ChromeDriver();
   Thread.sleep(3000);
	
	driver.manage().window().maximize();
	driver.get(DataBaseConnection.getURLFromDataBase("B1"));
	driver.findElement(By.id("userInput")).sendKeys("akvangal");
	driver.findElement(By.id("login-button")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("passwordInput")).sendKeys("Fcbarcelona!9");
	driver.findElement(By.id("login-button")).click();
	Thread.sleep(10000);
	count= driver.findElement(By.xpath("//*[@class='record-count']")).getText();
	System.out.println(count);
	access_Switching=count.substring(10,12);
	System.out.println(access_Switching);
	System.out.println(count);
	Thread.sleep(3000);

	Class.forName("oracle.jdbc.driver.OracleDriver");
	String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
	Statement smt = conn.createStatement();		
	Thread.sleep(3000);
	String queryparam = "SELECT QRY_PARAM FROM OPSBI_360_SOURCE_DATA_QUERIES WHERE QUERY_CD = 'B1'";
	smt.executeQuery(queryparam);
	System.out.println(queryparam);		
	//smt.executeQuery(query1).close();
	ResultSet rs=  smt.executeQuery(queryparam);

	while (rs.next()) {
	 qry_param =  rs.getString("QRY_PARAM");
	 
	}


	System.out.println(qry_param);
	int qry_param1=Integer.parseInt(qry_param);
	int access_Switching1=Integer.parseInt(access_Switching);
	int access_Switching2=qry_param1*access_Switching1;
	System.out.println(access_Switching2);
	driver.close();
	Thread.sleep(3000);

//Switching-Core
System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");	
driver =new ChromeDriver();
Thread.sleep(3000);

driver.manage().window().maximize();
driver.get(DataBaseConnection.getURLFromDataBase("B5"));
Thread.sleep(6000);
driver.findElement(By.id("userInput")).sendKeys("akvangal");
driver.findElement(By.id("login-button")).click();
Thread.sleep(2000);
driver.findElement(By.id("passwordInput")).sendKeys("Fcbarcelona!9");
driver.findElement(By.id("login-button")).click();
Thread.sleep(10000);
count1= driver.findElement(By.xpath("//*[@class='record-count']")).getText();
System.out.println(count1);

core_Switching=count1.substring(10,12);
System.out.println(core_Switching);
Class.forName("oracle.jdbc.driver.OracleDriver");
String connectionURL1= "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
Connection conn1 = DriverManager.getConnection(connectionURL1, "IOPS_APPS", "iOPS#123");
Statement smt1 = conn.createStatement();		

Thread.sleep(3000);
System.out.println("3");
 
String queryparam1 = "SELECT QRY_PARAM FROM OPSBI_360_SOURCE_DATA_QUERIES WHERE QUERY_CD = 'B5'";
smt.executeQuery(queryparam1);
System.out.println(queryparam1);		
ResultSet rs1=  smt1.executeQuery(queryparam1);

while (rs1.next()) {
	 qry_param =  rs1.getString("QRY_PARAM");
	 
	}
System.out.println(qry_param);
int qry_param2=Integer.parseInt(qry_param);
int core_Switching1=Integer.parseInt(core_Switching);
int core_Switching2=qry_param2*core_Switching1;
System.out.println(core_Switching2);
Thread.sleep(3000);
driver.quit();
Thread.sleep(3000);

//Routing
	System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");	
driver =new ChromeDriver();
Thread.sleep(3000);

driver.manage().window().maximize();
driver.get(DataBaseConnection.getURLFromDataBase("B6"));
driver.findElement(By.id("userInput")).sendKeys("akvangal");
driver.findElement(By.id("login-button")).click();
Thread.sleep(2000);
driver.findElement(By.id("passwordInput")).sendKeys("Fcbarcelona!9");
driver.findElement(By.id("login-button")).click();
Thread.sleep(10000);
count3= driver.findElement(By.xpath("//*[@class='record-count']")).getText();
System.out.println(count3);
Routing=count3.substring(10,13);
System.out.println(Routing);
Thread.sleep(3000);

Class.forName("oracle.jdbc.driver.OracleDriver");
String connectionURL2 = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
Connection conn2 = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
Statement smt2 = conn.createStatement();		
Thread.sleep(3000);
String queryparam3 = "SELECT QRY_PARAM FROM OPSBI_360_SOURCE_DATA_QUERIES WHERE QUERY_CD = 'B6'";
smt2.executeQuery(queryparam3);
//smt.executeQuery(query1).close();
ResultSet rs3=  smt.executeQuery(queryparam3);

while (rs3.next()) {
 qry_param =  rs3.getString("QRY_PARAM");
 
}


System.out.println(qry_param);
int qry_param3=Integer.parseInt(qry_param);
int Routing_1=Integer.parseInt(Routing);
int Routing_2=qry_param3*Routing_1;
System.out.println(Routing_2);
driver.close();
Thread.sleep(3000);
//driver.quit();

//Wireless
System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");	
driver =new ChromeDriver();
Thread.sleep(3000);

driver.manage().window().maximize();
driver.get(DataBaseConnection.getURLFromDataBase("B7"));
driver.findElement(By.id("userInput")).sendKeys("akvangal");
driver.findElement(By.id("login-button")).click();
Thread.sleep(2000);
driver.findElement(By.id("passwordInput")).sendKeys("Fcbarcelona!9");
driver.findElement(By.id("login-button")).click();
Thread.sleep(10000);
count4= driver.findElement(By.xpath("//*[@class='record-count']")).getText();
System.out.println(count4);

Wireless=count4.substring(10,13);
Thread.sleep(3000);

Class.forName("oracle.jdbc.driver.OracleDriver");
String connectionURL3 = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
Connection conn3 = DriverManager.getConnection(connectionURL3, "IOPS_APPS", "iOPS#123");
Statement smt3 = conn.createStatement();		
Thread.sleep(3000);
String queryparam4 = "SELECT QRY_PARAM FROM OPSBI_360_SOURCE_DATA_QUERIES WHERE QUERY_CD = 'B7'";
smt.executeQuery(queryparam);
System.out.println(queryparam);		
//smt.executeQuery(query1).close();
ResultSet rs4=  smt.executeQuery(queryparam3);

while (rs4.next()) {
 qry_param =  rs4.getString("QRY_PARAM");
 
}


System.out.println(qry_param);
int qry_param4=Integer.parseInt(qry_param);
int Wireless_1=Integer.parseInt(Wireless);
int Wireless_2=qry_param4*Wireless_1;
System.out.println(access_Switching2);
driver.close();
Thread.sleep(3000);
//driver.quit();


//IOT
System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");	
driver =new ChromeDriver();
Thread.sleep(3000);

driver.manage().window().maximize();
driver.get(DataBaseConnection.getURLFromDataBase("B8"));
driver.findElement(By.id("userInput")).sendKeys("akvangal");
driver.findElement(By.id("login-button")).click();
Thread.sleep(2000);
driver.findElement(By.id("passwordInput")).sendKeys("Fcbarcelona!9");
driver.findElement(By.id("login-button")).click();
Thread.sleep(10000);
count5= driver.findElement(By.xpath("//*[@class='record-count']")).getText();
System.out.println(count5);

IOT=count5.substring(10,12);
Thread.sleep(3000);

Class.forName("oracle.jdbc.driver.OracleDriver");
String connectionURL4 = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
Connection conn4 = DriverManager.getConnection(connectionURL4, "IOPS_APPS", "iOPS#123");
Statement smt4 = conn.createStatement();		
Thread.sleep(3000);
String queryparam5 = "SELECT QRY_PARAM FROM OPSBI_360_SOURCE_DATA_QUERIES WHERE QUERY_CD = 'B8'";
smt.executeQuery(queryparam);
System.out.println(queryparam);		
//smt.executeQuery(query1).close();
ResultSet rs5=  smt.executeQuery(queryparam3);

while (rs5.next()) {
 qry_param =  rs5.getString("QRY_PARAM");
 
}


System.out.println(qry_param);
int qry_param5=Integer.parseInt(qry_param);
int IOT_1=Integer.parseInt(IOT);
int IOT_2=qry_param5*IOT_1;
System.out.println(IOT_2);
driver.close();
Thread.sleep(3000);
//driver.quit();



//DNAC
System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");	
driver =new ChromeDriver();
Thread.sleep(3000);

driver.manage().window().maximize();
driver.get(DataBaseConnection.getURLFromDataBase("B9"));
driver.findElement(By.id("userInput")).sendKeys("akvangal");
driver.findElement(By.id("login-button")).click();
Thread.sleep(2000);
driver.findElement(By.id("passwordInput")).sendKeys("Fcbarcelona!9");
driver.findElement(By.id("login-button")).click();
Thread.sleep(10000);
count6= driver.findElement(By.xpath("//*[@class='record-count']")).getText();
System.out.println(count6);

DNAC=count6.substring(10,13);
Thread.sleep(3000);

Class.forName("oracle.jdbc.driver.OracleDriver");
String connectionURL5 = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
Connection conn5 = DriverManager.getConnection(connectionURL5, "IOPS_APPS", "iOPS#123");
Statement smt5 = conn.createStatement();		
Thread.sleep(3000);
String queryparam6 = "SELECT QRY_PARAM FROM OPSBI_360_SOURCE_DATA_QUERIES WHERE QUERY_CD = 'B9'";
smt.executeQuery(queryparam);
System.out.println(queryparam);		
//smt.executeQuery(query1).close();
ResultSet rs6=  smt.executeQuery(queryparam3);

while (rs6.next()) {
qry_param =  rs6.getString("QRY_PARAM");

}


System.out.println(qry_param);
int qry_param6=Integer.parseInt(qry_param);
int DNAC_1=Integer.parseInt(DNAC);
int DNAC_2=qry_param4*DNAC_1;
System.out.println(DNAC_2);
driver.close();
Thread.sleep(3000);
//driver.quit();



//SPA
System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");	
driver =new ChromeDriver();
Thread.sleep(3000);

driver.manage().window().maximize();
driver.get(DataBaseConnection.getURLFromDataBase("B10"));
driver.findElement(By.id("userInput")).sendKeys("akvangal");
driver.findElement(By.id("login-button")).click();
Thread.sleep(2000);
driver.findElement(By.id("passwordInput")).sendKeys("Fcbarcelona!9");
driver.findElement(By.id("login-button")).click();
Thread.sleep(10000);
count7= driver.findElement(By.xpath("//*[@class='record-count']")).getText();
System.out.println(count7);

SPA=count7.substring(10,12);
Thread.sleep(3000);

Class.forName("oracle.jdbc.driver.OracleDriver");
String connectionURL6 = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
Connection conn6 = DriverManager.getConnection(connectionURL6, "IOPS_APPS", "iOPS#123");
Statement smt6 = conn.createStatement();		
Thread.sleep(3000);
String queryparam7 = "SELECT QRY_PARAM FROM OPSBI_360_SOURCE_DATA_QUERIES WHERE QUERY_CD = 'B10'";
smt.executeQuery(queryparam);
System.out.println(queryparam);		
//smt.executeQuery(query1).close();
ResultSet rs7=  smt.executeQuery(queryparam3);

while (rs7.next()) {
qry_param =  rs7.getString("QRY_PARAM");

}


System.out.println(qry_param);
int qry_param7=Integer.parseInt(qry_param);
int SPA_1=Integer.parseInt(SPA);
int SPA_2=qry_param4*SPA_1;
System.out.println(DNAC_2);
driver.close();
Thread.sleep(3000);
//driver.quit();




Class.forName("oracle.jdbc.driver.OracleDriver");
connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
/*String connectionURL = "jdbc:oracle:thin:@"+ "dbc-prd-vm-1014-vip.cisco.com" + ":"+ "1529" + ":"+ "NTGPRD";
System.out.println("2");
Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS$2036");*/
System.out.println("4--");	
smt = conn.createStatement();		


Thread.sleep(3000);

String trunc= "truncate  table OPSBI_360_WEEKLY_CLIP_BEMS";
smt.executeQuery(trunc);
System.out.println("3");
String query= "INSERT INTO OPSBI_360_WEEKLY_CLIP_BEMS (REC_ID,QUERY_CD,PIN,TOTAL_COUNT,AMOUNT) VALUES (1,'B1','Access-Switching','"+access_Switching+"','"+access_Switching2+"')"; 
String query1= "INSERT INTO OPSBI_360_WEEKLY_CLIP_BEMS (REC_ID,QUERY_CD,PIN,TOTAL_COUNT,AMOUNT) VALUES (2,'B5','Core-Switching','"+core_Switching+"','"+core_Switching2+"')";
String query2= "INSERT INTO OPSBI_360_WEEKLY_CLIP_BEMS (REC_ID,QUERY_CD,PIN,TOTAL_COUNT,AMOUNT) VALUES (3,'B6','Routing','"+Routing+"','"+Routing_2+"')";
String query3= "INSERT INTO OPSBI_360_WEEKLY_CLIP_BEMS (REC_ID,QUERY_CD,PIN,TOTAL_COUNT,AMOUNT) VALUES (4,'B7','Wireless','"+Wireless+"','"+Wireless_2+"')";
String query4= "INSERT INTO OPSBI_360_WEEKLY_CLIP_BEMS (REC_ID,QUERY_CD,PIN,TOTAL_COUNT,AMOUNT) VALUES (5,'B8','IOT','"+IOT+"','"+IOT_2+"')";
String query5= "INSERT INTO OPSBI_360_WEEKLY_CLIP_BEMS (REC_ID,QUERY_CD,PIN,TOTAL_COUNT,AMOUNT) VALUES (6,'B9','DNAC','"+DNAC+"','"+DNAC_2+"')";
String query6= "INSERT INTO OPSBI_360_WEEKLY_CLIP_BEMS (REC_ID,QUERY_CD,PIN,TOTAL_COUNT,AMOUNT) VALUES (7,'B10','SPA','"+SPA+"','"+SPA_2+"')";

System.out.println(query);		
smt.executeQuery(query);
smt.executeQuery(query1);
smt.executeQuery(query2);
smt.executeQuery(query3);
smt.executeQuery(query4);
smt.executeQuery(query5);


smt.executeQuery(query6).close();
System.out.println("--- Data Inserted into AC_SR_A1---");




	
	}
	

}
