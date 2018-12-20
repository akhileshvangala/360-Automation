package tacsr;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import clip.DataBaseConnection;
public class tacsr_Test {
public Connection conn;
	
	Properties prop = new Properties();
	public WebDriver driver;
	//A1
	ArrayList<String> MonthList = new ArrayList<String>();
	ArrayList<String> YearList = new ArrayList<String>();
	ArrayList<Integer> AggList = new ArrayList<Integer>();
	
	//A8
	ArrayList<String> A8_MonthOfSRClosedDateList = new ArrayList<String>();
	ArrayList<Integer> A8_SRinitialseverityList = new ArrayList<Integer>();
	ArrayList<Integer> A8_YearOfSRClosedDateList = new ArrayList<Integer>();
	ArrayList<Double> A8_AggInitialSevRateList = new ArrayList<Double>();
	ArrayList<Integer> A8_AggSRCountList = new ArrayList<Integer>();
	
	//A9
	ArrayList<String> A9_MonthOfSRClosedDateList = new ArrayList<String>();
	ArrayList<String> A9_outageFlagStatusList = new ArrayList<String>();
	ArrayList<Integer> A9_YearOfSRClosedDateList = new ArrayList<Integer>();
	ArrayList<Double> A9_AggOutageFlagRateList = new ArrayList<Double>();
	ArrayList<Integer> A9_AggSRCountList = new ArrayList<Integer>();
	
	
	//B1
	ArrayList<String> B1_bugLinkedList = new ArrayList<String>();
	ArrayList<String> B1_MonthOfSRClosedDateList = new ArrayList<String>();
	ArrayList<Integer> B1_YearOfSRClosedDateList = new ArrayList<Integer>();
	ArrayList<Double> B1_AggBugEncounterRateList = new ArrayList<Double>();
	ArrayList<Integer> B1_AggSRCountList = new ArrayList<Integer>();
	
	
	public void run(String environment) throws ClassNotFoundException, SQLException, IOException, InterruptedException{
		
		set_tAC_SR_A1(environment);
		set_tAC_SR_A8(environment);
		set_tAC_SR_A9(environment);
		set_tAC_SR_B1(environment);
	}
	
	public void set_tAC_SR_A1(String environment) throws InterruptedException, SQLException, ClassNotFoundException, IOException{
		//Setup
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
		prop.load(file);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(DataBaseConnection.getURLFromDataBase(environment,"TAC_SR_A1"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("userInput")).clear();
		driver.findElement(By.id("userInput")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.id("passwordInput")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).submit();
		//Thread.sleep(5000);
		explicitWait(By.xpath("//iframe[@title='data visualization']"));

		//Test case
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='data visualization']")));
		driver.findElement(By.name("FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_14774296688079962015_(All)")).click();		
		driver.findElement(By.name("FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_14774296688079962015_(All)")).click();		
		driver.findElement(By.name("FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_14774296688079962015_4")).click();
		driver.findElement(By.name("FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_14774296688079962015_5")).click();
		driver.findElement(By.name("FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_14774296688079962015_6")).click();
		driver.findElement(By.name("FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_14774296688079962015_9")).click();
		driver.findElement(By.name("FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_14774296688079962015_10")).click();
		driver.findElement(By.name("FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_14774296688079962015_14")).click();
		//Thread.sleep(2000);
		explicitWait(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_0']/div/div[3]/button[2]"));

		driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_0']/div/div[3]/button[2]")).click(); 
		//A1 INT BE Apply
		Thread.sleep(20000);
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_(All)']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_(All)']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_3']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_11']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_12']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_13']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_14']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_15']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_16']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_17']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_18']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_21']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_22']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_23']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_24']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_25']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_26']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_27']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_28']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_29']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_47']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_14774296688079962015_48']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]")).click();   
		//A1 Int sub Be apply
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='centeringContainer']/div[2]/div[1]/div[3]/div[4]/span[1]")).click(); 
		Thread.sleep(2000);
/*		driver.findElement(By.xpath(".//*[@id='tab-menuItem47']/div/span")).click();
		driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/div[2]/div/span")).click();
*/		
		driver.findElement(By.xpath("(//span[@class='tabMenuItemName'])[2]")).click();

		
		for(String childWindow:driver.getWindowHandles()){
			driver.switchTo().window(childWindow).manage().window().maximize();;
			}
		
	
		List<WebElement> Month = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[1]"));
		List<WebElement> Year = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[2]"));
		List<WebElement> Agg = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[3]"));
		
		for(int i=0;i<Month.size();i++){
			MonthList.add(Month.get(i).getText());
			YearList.add(Year.get(i).getText());
			AggList.add(Integer.parseInt(Agg.get(i).getText().replaceAll(",", "")));
			
		    }
		Thread.sleep(5000);
		driver.quit();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	if(environment.equalsIgnoreCase("dev")){

		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	    conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
	}
	else if(environment.equalsIgnoreCase("prod")){
		String connectionURL = "jdbc:oracle:thin:@"+ "dbc-prd-vm-1014-vip.cisco.com" + ":"+ "1529"+"/NTGPRD.cisco.com";
		conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS$2036");
	}
	  /*  Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbc-prd-vm-1014-vip.cisco.com" + ":"+ "1529"+"/NTGPRD.cisco.com";
		Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS$2036");*/
	    
	    
	   Statement smt = conn.createStatement();		
	   String deletequery = "DELETE FROM OPSBI_360_DTLS_TAC_SR_A1";
	   smt.executeQuery(deletequery).close();
	   
	   
	   String A1_queryCD = DataBaseConnection.getQueryCodeFromDataBase(environment,"TAC_SR_A1");	
	 

		for(int i=0;i<AggList.size();i++){	
		String query = "INSERT INTO OPSBI_360_DTLS_TAC_SR_A1 (REC_ID,QUERY_CD,MONTH_OF_SR_CLOSED_DATE,YEAR_OF_SR_CLOSED_DATE,AGG_SR_COUNT) VALUES ('"+(i+1)+"','"+A1_queryCD+"','"+MonthList.get(i)+"','"+YearList.get(i)+"','"+AggList.get(i)+"')";			
		smt.executeQuery(query).close();
		}
		
	
		System.out.println("--- Data Inserted into A1---");

	}
	
	
	public void set_tAC_SR_A8(String environment) throws SQLException, IOException, ClassNotFoundException, InterruptedException{
		//setup
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
		prop.load(file);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(DataBaseConnection.getURLFromDataBase(environment,"TAC_SR_A8"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Test case
		driver.findElement(By.id("userInput")).clear();
		driver.findElement(By.id("userInput")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.id("login-button")).click();
		explicitWait(By.id("passwordInput"));
		driver.findElement(By.id("passwordInput")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).submit();
		explicitWait(By.xpath("//iframe[@title='data visualization']"));
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='data visualization']")));
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_(All)']/div[2]/input")).click();		
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_(All)']/div[2]/input")).click();		
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_4']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_5']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_6']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_9']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_10']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_14']/div[2]/input")).click();
		explicitWait(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_0']/div/div[3]/button[2]"));
		driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_0']/div/div[3]/button[2]")).click(); 
		//A8 INT BE Apply
		Thread.sleep(20000);

		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_(All)']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_(All)']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_3']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_11']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_12']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_13']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_14']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_15']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_16']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_17']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_18']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_21']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_22']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_23']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_24']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_25']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_26']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_27']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_28']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_29']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_47']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_17356598821223037470_48']/div[2]/input")).click();
		explicitWait(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]"));
	 	driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]")).click();	 	
	 	Thread.sleep(10000);
	//A8 Int sub Be apply

	 	driver.findElement(By.xpath(".//*[@id='centeringContainer']/div[2]/div[1]/div[3]/div[4]/span[1]")).click();
	 	Thread.sleep(2000);
//	 	driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/div[2]/div/span")).click();
	 	
		driver.findElement(By.xpath("(//span[@class='tabMenuItemName'])[2]")).click();

	 	for(String childWindow:driver.getWindowHandles()){
			driver.switchTo().window(childWindow).manage().window().maximize();;
	}

		List<WebElement> MonthOfSRClosedDate = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[1]"));
		List<WebElement> SRinitialseverity = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[2]"));
		List<WebElement> YearOfSRClosedDate = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[3]"));
		List<WebElement> AggInitialSevRate = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[4]"));
		List<WebElement> AggSRCount = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[5]"));
		
		
		
		for(int i=0;i<MonthOfSRClosedDate.size();i++){
			 A8_MonthOfSRClosedDateList.add(MonthOfSRClosedDate.get(i).getText());
			 
			 if(SRinitialseverity.get(i).getText().contains("Null")){
				 A8_SRinitialseverityList.add(0);
				 		
			 	}
			 else {
				 A8_SRinitialseverityList.add(Integer.parseInt(SRinitialseverity.get(i).getText()));
			 }
			 	
			 
			 A8_YearOfSRClosedDateList.add(Integer.parseInt(YearOfSRClosedDate.get(i).getText())); 
			 
			 if(AggInitialSevRate.get(i).getText().contains("Null")){
		 			
				 
				 A8_AggInitialSevRateList.add(0.0);
		 		}
			 else{
				 
					double num = Double.parseDouble(AggInitialSevRate.get(i).getText());
					A8_AggInitialSevRateList.add(num*100);
			 }
		 		
			 
			 String text = AggSRCount.get(i).getText().replaceAll(",", "");
			 if(text.contains("Null")){
				 A8_AggSRCountList.add(0);

			 }
			 else{
				 A8_AggSRCountList.add(Integer.parseInt(text));
			 }
			
		}
			 
		driver.quit();
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		if(environment.equalsIgnoreCase("dev")){

			String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
		    conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
		}
		else if(environment.equalsIgnoreCase("prod")){
			String connectionURL = "jdbc:oracle:thin:@"+ "dbc-prd-vm-1014-vip.cisco.com" + ":"+ "1529"+"/NTGPRD.cisco.com";
			conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS$2036");
		}
		
	    /*Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbc-prd-vm-1014-vip.cisco.com" + ":"+ "1529"+"/NTGPRD.cisco.com";
		Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS$2036");*/
	    
	   Statement smt = conn.createStatement();		
	   String deletequery = "DELETE FROM OPSBI_360_DTLS_TAC_SR_A8";
	   smt.executeQuery(deletequery).close();
	 
	   String A8_queryCD = DataBaseConnection.getQueryCodeFromDataBase(environment,"TAC_SR_A8");	
		for(int i=0;i< A8_MonthOfSRClosedDateList.size();i++){	
			String query = "INSERT INTO OPSBI_360_DTLS_TAC_SR_A8 (REC_ID,QUERY_CD,MONTH_OF_SR_CLOSED_DATE,YEAR_OF_SR_CLOSED_DATE,SR_INITIAL_SEVERITY,AGG_INITIAL_SEV1_RATE,AGG_SR_COUNT) VALUES ('"+(i+1)+"','"+A8_queryCD+"','"+A8_MonthOfSRClosedDateList.get(i)+"','"+ A8_YearOfSRClosedDateList.get(i)+"','"+A8_SRinitialseverityList.get(i)+"','"+A8_AggInitialSevRateList.get(i)+"','"+A8_AggSRCountList.get(i)+"')";			
		smt.executeQuery(query).close();
		}

		System.out.println("--- ORACLE Data Table  Inserted into A8---");
		
		
		
	}
	
	
	public void set_tAC_SR_A9(String environment) throws SQLException, IOException, InterruptedException, ClassNotFoundException{
		//setup
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
		prop.load(file);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(DataBaseConnection.getURLFromDataBase(environment,"TAC_SR_A9"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Testcase
		
		driver.findElement(By.id("userInput")).clear();
		driver.findElement(By.id("userInput")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.id("passwordInput")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).submit();
		explicitWait(By.xpath("//iframe[@title='data visualization']"));

		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='data visualization']")));
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_(All)']/div[2]/input")).click();		
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_(All)']/div[2]/input")).click();		
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_4']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_5']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_6']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_9']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_10']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_14']/div[2]/input")).click();
		explicitWait(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_0']/div/div[3]/button[2]"));
		driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_0']/div/div[3]/button[2]")).click(); 
		//A9 INT BE Apply
		Thread.sleep(15000);          
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_(All)']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_(All)']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_3']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_11']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_12']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_13']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_14']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_15']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_16']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_17']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_18']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_21']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_22']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_23']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_24']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_25']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_26']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_27']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_28']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_29']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_47']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_13898669209024021704_48']/div[2]/input")).click();
	 	explicitWait(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]"));
	 	driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]")).click();	 	
	 	Thread.sleep(10000);
	 	//A9 Int sub Be apply
//	 	explicitWait(By.xpath(""))

	 	driver.findElement(By.xpath(".//*[@id='centeringContainer']/div[2]/div[1]/div[3]/div[4]/span[1]")).click();
	 	Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='tabMenuItemName'])[2]")).click();

	 	//	 	driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/div[2]/div/span")).click();
	 	for(String childWindow:driver.getWindowHandles()){
			driver.switchTo().window(childWindow).manage().window().maximize();;
	}

		List<WebElement> MonthOfSRClosedDate = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[1]"));
		List<WebElement> outageFlagStatus = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[2]"));
		List<WebElement> YearOfSRClosedDate = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[3]"));
		List<WebElement> AggOutageFlagRate = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[4]"));
		List<WebElement> AggSRCount = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[5]"));
		
		
		
		for(int i=0;i<MonthOfSRClosedDate.size();i++){
			 A9_MonthOfSRClosedDateList.add(MonthOfSRClosedDate.get(i).getText());
			 
			 
			 
			 if(outageFlagStatus.get(i).getText().contains("Null")){
				 A9_outageFlagStatusList.add("Null");
				 		
			 	}
			 else {
				 A9_outageFlagStatusList.add(outageFlagStatus.get(i).getText());
			 }
			 	
			 
			 A9_YearOfSRClosedDateList.add(Integer.parseInt(YearOfSRClosedDate.get(i).getText())); 
			 
			 if(AggOutageFlagRate.get(i).getText().contains("Null")){
		 			
				 
				 A9_AggOutageFlagRateList.add(0.0);
		 		}
			 else{
				 	String str = AggOutageFlagRate.get(i).getText();
				 	double num = Double.parseDouble(str);
				 	A9_AggOutageFlagRateList.add(num*100);
				 	System.out.println(num*100);
			 }
		 		
			 
			 String text = AggSRCount.get(i).getText().replaceAll(",", "");
			 if(text.contains("Null")){
				 A9_AggSRCountList.add(0);

			 }
			 else{
				 A9_AggSRCountList.add(Integer.parseInt(text));
			 }
			
		}
		
	
		driver.quit();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		if(environment.equalsIgnoreCase("dev")){

			String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
		    conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
		}
		else if(environment.equalsIgnoreCase("prod")){
			String connectionURL = "jdbc:oracle:thin:@"+ "dbc-prd-vm-1014-vip.cisco.com" + ":"+ "1529"+"/NTGPRD.cisco.com";
			conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS$2036");
		}
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");*/
	    
	    /*Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbc-prd-vm-1014-vip.cisco.com" + ":"+ "1529"+"/NTGPRD.cisco.com";
		Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS$2036");*/
	    
	   Statement smt = conn.createStatement();		
	   String deletequery = "DELETE FROM OPSBI_360_DTLS_TAC_SR_A9";
//	   ResultSet delrs=  smt.executeQuery(deletequery);
	   smt.executeQuery(deletequery).close();;
	   
	   String A9_queryCD = DataBaseConnection.getQueryCodeFromDataBase(environment,"TAC_SR_A9");	

			
	   for(int i=0;i<A9_MonthOfSRClosedDateList.size();i++){	
			String query = "INSERT INTO OPSBI_360_DTLS_TAC_SR_A9 (REC_ID,QUERY_CD,MONTH_OF_SR_CLOSED_DATE,YEAR_OF_SR_CLOSED_DATE,OUTAGE_FLAG_STATUS,SR_NUMBER,OUTAGE_FLAG_RATE) VALUES ('"+(i+1)+"','"+A9_queryCD+"','"+A9_MonthOfSRClosedDateList.get(i)+"','"+A9_YearOfSRClosedDateList.get(i)+"','"+A9_outageFlagStatusList.get(i)+"','"+A9_AggSRCountList.get(i)+"','"+A9_AggOutageFlagRateList.get(i)+"')";			
			smt.executeQuery(query).close();
		}
		System.out.println("--- ORACLE Data Table  Inserted into A9---");

		
	

}
	
	
	public void set_tAC_SR_B1(String environment) throws IOException, InterruptedException, ClassNotFoundException, SQLException{
		//setup
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
		prop.load(file);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(DataBaseConnection.getURLFromDataBase(environment,"TAC_SR_B1"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userInput")).clear();
		driver.findElement(By.id("userInput")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.id("passwordInput")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).submit();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='data visualization']")));
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_(All)']/div[2]/input")).click();		
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_(All)']/div[2]/input")).click();		
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_4']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_5']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_6']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_9']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_10']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_14']/div[2]/input")).click();
		explicitWait(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_0']/div/div[3]/button[2]"));
		driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_0']/div/div[3]/button[2]")).click(); 
		//B1 INT BE Apply
		Thread.sleep(15000);          
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_(All)']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_(All)']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_3']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_11']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_12']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_13']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_14']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_15']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_16']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_17']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_18']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_21']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_22']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_23']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_24']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_25']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_26']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_27']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_28']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_29']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_47']/div[2]/input")).click();
	 	driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_sub_be:nk14425121001966086373_11634400326256150771_48']/div[2]/input")).click();
	 	explicitWait(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]"));
	 	driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]")).click();	 	
	 	Thread.sleep(10000);
		//B1 Int sub Be apply

	 	driver.findElement(By.xpath(".//*[@id='centeringContainer']/div[2]/div[1]/div[3]/div[4]/span[1]")).click();
	 	Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='tabMenuItemName'])[2]")).click();

	 	//driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/div[2]/div/span")).click();
	 	for(String childWindow:driver.getWindowHandles()){
			driver.switchTo().window(childWindow).manage().window().maximize();;
	}

		
		List<WebElement> bugLinked = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[1]"));
		List<WebElement> MonthOfSRClosedDate = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[2]"));
		List<WebElement> YearOfSRClosedDate = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[3]"));
		List<WebElement> AggBugEncounterRate = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[4]"));
		List<WebElement> AggSRCount = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[5]"));
		
		
		
		for(int i=0;i<MonthOfSRClosedDate.size();i++){
			B1_MonthOfSRClosedDateList.add(MonthOfSRClosedDate.get(i).getText());
			 
			 if(bugLinked.get(i).getText().contains("Null")){
				 B1_bugLinkedList.add("Null");
				 		
			 	}
			 else {
				 B1_bugLinkedList.add(bugLinked.get(i).getText());
			 }
			 	
			 
			 B1_YearOfSRClosedDateList.add(Integer.parseInt(YearOfSRClosedDate.get(i).getText())); 
			 
			if(AggBugEncounterRate.get(i).getText().contains("Null")){
		 			
				 
				B1_AggBugEncounterRateList.add(0.0);
		 		}
			 else{
				 
				String bugRate = AggBugEncounterRate.get(i).getText();
				//double dAggBugEncounterRate = Double.parseDouble(bugRate);
				 //B1_AggBugEncounterRateList.add(dAggBugEncounterRate);
					double num = Double.parseDouble(bugRate.split("%")[0]);
					B1_AggBugEncounterRateList.add(num);
				 
			 }
			 
			 String text = AggSRCount.get(i).getText().replaceAll(",", "");
			 if(text.contains("Null")){
				 B1_AggSRCountList.add(0);

			 }
			 else{
				 B1_AggSRCountList.add(Integer.parseInt(text));
			 }
			
		}
		

		driver.quit();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		if(environment.equalsIgnoreCase("dev")){

			String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
		    conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
		}
		else if(environment.equalsIgnoreCase("prod")){
			String connectionURL = "jdbc:oracle:thin:@"+ "dbc-prd-vm-1014-vip.cisco.com" + ":"+ "1529"+"/NTGPRD.cisco.com";
			conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS$2036");
		}
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");*/
	    
	 /*   
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String connectionURL = "jdbc:oracle:thin:@"+ "dbc-prd-vm-1014-vip.cisco.com" + ":"+ "1529"+"/NTGPRD.cisco.com";

		Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS$2036");
	    */
	   Statement smt = conn.createStatement();		
	   String deletequery = "DELETE FROM OPSBI_360_DTLS_TAC_SR_B1";
	   smt.executeQuery(deletequery).close();
	   
	   String B1_queryCD = DataBaseConnection.getQueryCodeFromDataBase(environment,"TAC_SR_B1");	

			
	   for(int i=0;i<B1_MonthOfSRClosedDateList.size();i++){	
			String query = "INSERT INTO OPSBI_360_DTLS_TAC_SR_B1 (REC_ID,QUERY_CD,MONTH_OF_SR_CLOSED_DATE,YEAR_OF_SR_CLOSED_DATE,BUG_LINKED,SR_NUMBER,BUG_ENCOUNTER_RATE) VALUES ('"+(i+1)+"','"+B1_queryCD+"','"+B1_MonthOfSRClosedDateList.get(i)+"','"+B1_YearOfSRClosedDateList.get(i)+"','"+B1_bugLinkedList.get(i)+"','"+B1_AggSRCountList.get(i)+"','"+B1_AggBugEncounterRateList.get(i)+"')";			
		smt.executeQuery(query).close();
		}
		
	
		System.out.println("--- ORACLE Data Table  Inserted into B1---");

	}
	
	public void explicitWait(By locator){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	


}
