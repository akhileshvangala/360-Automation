package tacsr;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import clip.DataBaseConnection;

//import com.cisco.app.DataBaseConnection;

public class TacSR_Tableau {
	
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
	ArrayList<String> A8_AggInitialSevRateList = new ArrayList<String>();
	ArrayList<Integer> A8_AggSRCountList = new ArrayList<Integer>();
	
	//A9
	ArrayList<String> A9_MonthOfSRClosedDateList = new ArrayList<String>();
	ArrayList<String> A9_outageFlagStatusList = new ArrayList<String>();
	ArrayList<Integer> A9_YearOfSRClosedDateList = new ArrayList<Integer>();
	ArrayList<String> A9_AggOutageFlagRateList = new ArrayList<String>();
	ArrayList<Integer> A9_AggSRCountList = new ArrayList<Integer>();
	
	
	//B1
	ArrayList<String> B1_bugLinkedList = new ArrayList<String>();
	ArrayList<String> B1_MonthOfSRClosedDateList = new ArrayList<String>();
	ArrayList<Integer> B1_YearOfSRClosedDateList = new ArrayList<Integer>();
	ArrayList<String> B1_AggBugEncounterRateList = new ArrayList<String>();
	ArrayList<String> B1_AggSRCountList = new ArrayList<String>();
	
	//H1
	ArrayList<String> H1_MonthOfSRClosedDateList = new ArrayList<String>();
	ArrayList<String> H1_RMAissuedList = new ArrayList<String>();
	ArrayList<Integer> H1_YearOfSRClosedDateList = new ArrayList<Integer>();
	ArrayList<String> H1_AggRMAissuedrateList = new ArrayList<String>();
	ArrayList<Integer> H1_AggSRCountList = new ArrayList<Integer>();
	
	
	public void run() {
		try {
			set_tAC_SR_A1();
			set_tAC_SR_A8();
			set_tAC_SR_A9();
			set_tAC_SR_B1();
		} catch (ClassNotFoundException | InterruptedException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	
	

	private void set_tAC_SR_A1() throws InterruptedException, SQLException, ClassNotFoundException, IOException{
		//Setup
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
		prop.load(file);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sso.cisco.com/autho/forms/maCECLogin.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userInput")).clear();
		driver.findElement(By.id("userInput")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("passwordInput")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).submit();
		Thread.sleep(5000);
		
		driver.get(DataBaseConnection.getURLFromDataBase("TAC_SR_A1"));
		Thread.sleep(5000);
		//Test case
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='data visualization']")));
		System.out.println("1");
		/*driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:int_be:nk4773958904600192927_3931871842746908174_(All)")).click();	
									
		driver.findElement(By.name("FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_14774296688079962015_(All)")).click();		
		driver.findElement(By.name("FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_14774296688079962015_4")).click();
		driver.findElement(By.name("FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_14774296688079962015_5")).click();
		driver.findElement(By.name("FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_14774296688079962015_6")).click();
		driver.findElement(By.name("FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_14774296688079962015_9")).click();
		driver.findElement(By.name("FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_14774296688079962015_10")).click();
		driver.findElement(By.name("FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_14774296688079962015_14")).click();
		*/Thread.sleep(3000);

		//driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_0']/div/div[3]/button[2]")).click(); 
		//A1 INT BE Apply
		/*Thread.sleep(20000);
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
		*/
		Thread.sleep(10000);
		//Product family
		//Window.scrollBy(0, 100);
		driver.findElement(By.xpath("//*[@name='FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk4773958904600192927_3931871842746908174_(All)']")).click();
//		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk4773958904600192927_3931871842746908174_(All)")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk4773958904600192927_3931871842746908174_150")).click();
		Thread.sleep(2000);
		driver.findElement( By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk4773958904600192927_3931871842746908174_486")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk4773958904600192927_3931871842746908174_645")).click();
		Thread.sleep(2000);
		System.out.println("2");
		//driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]")).click();   
//click on apply
	    driver.findElement(By.xpath("//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_4']/div/div[3]/div[3]/button[2]/span[2]")).click(); 
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@class='tabCanvas tab-widget']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@class='tabToolbarButton tab-widget download']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@data-tb-test-id='DownloadData-Button']")).click();
		Thread.sleep(4000);
		//driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/div[2]/div/span")).click();
		System.out.println("3");
		driver.switchTo().defaultContent();
		
		for(String childWindow:driver.getWindowHandles()){
			driver.switchTo().window(childWindow).manage().window().maximize();;
			}
		
	System.out.println("4");
		List<WebElement> Month = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[1]"));
		System.out.println("5");
		List<WebElement> Year = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[2]"));
		List<WebElement> Agg = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[3]"));
		System.out.println("6");
		System.out.println(Month.size());
		
		for(int i=0;i<Month.size();i++){
			System.out.println("7");
			MonthList.add(Month.get(i).getText());
			System.out.println(Month.get(i).getText());
			YearList.add(Year.get(i).getText());
			System.out.println(Year.get(i).getText());
			AggList.add(Integer.parseInt(Agg.get(i).getText().replaceAll(",", "")));
			System.out.println("9");
			
		    }
		Thread.sleep(5000);
		//driver.quit();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
	    
	   Statement smt = conn.createStatement();		
	   String deletequery = "DELETE FROM OPSBI_360_DTLS_TAC_SR_A1";
	   ResultSet delrs=  smt.executeQuery(deletequery);
	   
	   
	   String A1_queryCD = DataBaseConnection.getQueryCodeFromDataBase("TAC_SR_A1");	
	 

		for(int i=0;i<AggList.size();i++){	
		String query = "INSERT INTO OPSBI_360_DTLS_TAC_SR_A1 (REC_ID,QUERY_CD,MONTH_OF_SR_CLOSED_DATE,YEAR_OF_SR_CLOSED_DATE,AGG_SR_COUNT) VALUES ('"+(i+1)+"','"+A1_queryCD+"','"+MonthList.get(i)+"','"+YearList.get(i)+"','"+AggList.get(i)+"')";			
		System.out.println(query);
		//smt.executeQuery(query).close();
		}
		
	
		System.out.println("--- Data Inserted into AC_SR_A1---");

	}
	
	private void set_tAC_SR_A8() throws SQLException, IOException, ClassNotFoundException, InterruptedException{
		//setup
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
		prop.load(file);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sso.cisco.com/autho/forms/maCECLogin.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userInput")).clear();
		driver.findElement(By.id("userInput")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("passwordInput")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).submit();
		Thread.sleep(5000);
		
		driver.get(DataBaseConnection.getURLFromDataBase("TAC_SR_A8"));
		Thread.sleep(5000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='data visualization']")));
		/*driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_(All)']/div[2]/input")).click();		
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_(All)']/div[2]/input")).click();		
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_4']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_5']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_6']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_9']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_10']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_17356598821223037470_14']/div[2]/input")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_0']/div/div[3]/button[2]")).click(); 
		//A1 INT BE Apply
		Thread.sleep(5000);          
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
		Thread.sleep(5000);
	 	driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]")).click();	 	
	 	Thread.sleep(10000);
*///		//A8 Int sub Be apply

	 	Thread.sleep(6000);
		//Product family
		//Window.scrollBy(0, 100);
		driver.findElement(By.xpath("//*[@name='FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk3406081045800067867_16598193771552127451_(All)']")).click();
											
//		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk4773958904600192927_3931871842746908174_(All)")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk3406081045800067867_16598193771552127451_150")).click();
		Thread.sleep(2000);
		driver.findElement( By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk3406081045800067867_16598193771552127451_490")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk3406081045800067867_16598193771552127451_650")).click();
		Thread.sleep(2000);
		System.out.println("2");
		//driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]")).click();   
//click on apply
	    driver.findElement(By.xpath("//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_2']/div/div[3]/div[3]/button[2]/span[2]")).click(); 
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@class='tabCanvas tab-widget']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@class='tabToolbarButton tab-widget download']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@data-tb-test-id='DownloadData-Button']")).click();
		Thread.sleep(4000);
		//driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/div[2]/div/span")).click();
		System.out.println("3");
		driver.switchTo().defaultContent();
	 	
	 	
	 	//driver.findElement(By.xpath(".//*[@id='centeringContainer']/div[2]/div[1]/div[3]/div[4]/span[1]")).click();
	 	//driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/div[2]/div/span")).click();
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
		 			
				 
				 A8_AggInitialSevRateList.add("0");
				 
		 		}
			 else{
				 
				 A8_AggInitialSevRateList.add(AggInitialSevRate.get(i).getText());
			 }
		 		
			 
			 String text = AggSRCount.get(i).getText().replaceAll(",", "");
			 if(text.contains("Null")){
				 A8_AggSRCountList.add(0);

			 }
			 else{
				 A8_AggSRCountList.add(Integer.parseInt(text));
			 }
			
		}
		
		
			 
		Thread.sleep(2000);
		//driver.quit();
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
	    System.out.println("3");
	   Statement smt = conn.createStatement();		
	   String deletequery = "DELETE FROM OPSBI_360_DTLS_TAC_SR_A8";
	   smt.executeQuery(deletequery).close();
	   
	   System.out.println("4");
	   String A8_queryCD = DataBaseConnection.getQueryCodeFromDataBase("TAC_SR_A8");	
	   System.out.println("5");
	 
		for(int i=0;i< A8_MonthOfSRClosedDateList.size();i++){	
			System.out.println("6");
			String query = "INSERT INTO OPSBI_360_DTLS_TAC_SR_A8 (REC_ID,QUERY_CD,MONTH_OF_SR_CLOSED_DATE,YEAR_OF_SR_CLOSED_DATE,SR_INITIAL_SEVERITY,AGG_INITIAL_SEV1_RATE,AGG_SR_COUNT) VALUES ('"+(i+1)+"','"+A8_queryCD+"','"+A8_MonthOfSRClosedDateList.get(i)+"','"+ A8_YearOfSRClosedDateList.get(i)+"','"+A8_SRinitialseverityList.get(i)+"','"+A8_AggInitialSevRateList.get(i)+"','"+A8_AggSRCountList.get(i)+"')";			
			System.out.println("");
			smt.executeQuery(query).close();
		}
		
	
		System.out.println("--- ORACLE Data Table  Inserted into A8---");
		
		
		
	}
	
	private void set_tAC_SR_A9() throws SQLException, IOException, InterruptedException, ClassNotFoundException{
		//setup
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
		prop.load(file);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sso.cisco.com/autho/forms/maCECLogin.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userInput")).clear();
		driver.findElement(By.id("userInput")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("passwordInput")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).submit();
		Thread.sleep(5000);
		
		driver.get(DataBaseConnection.getURLFromDataBase("TAC_SR_A9"));
		Thread.sleep(5000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='data visualization']")));
		/*driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_(All)']/div[2]/input")).click();		
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_(All)']/div[2]/input")).click();		
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_4']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_5']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_6']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_9']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_10']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_13898669209024021704_14']/div[2]/input")).click();
		Thread.sleep(5000);

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
		Thread.sleep(15000);
*/	 	
		
		driver.findElement(By.xpath("//*[@name='FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk17172440791263305633_15577160950903750791_(All)']")).click();
		
//		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk4773958904600192927_3931871842746908174_(All)")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk17172440791263305633_15577160950903750791_150")).click();
		Thread.sleep(2000);
		driver.findElement( By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk17172440791263305633_15577160950903750791_490")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk17172440791263305633_15577160950903750791_650")).click();
		Thread.sleep(2000);
		System.out.println("2");
		//driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]")).click();   
//click on apply
	    driver.findElement(By.xpath("//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_2']/div/div[3]/div[3]/button[2]/span[2]")).click(); 
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@class='tabCanvas tab-widget']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@class='tabToolbarButton tab-widget download']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@data-tb-test-id='DownloadData-Button']")).click();
		Thread.sleep(4000);
		//driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/div[2]/div/span")).click();
		System.out.println("3");
		driver.switchTo().defaultContent();
	 	
		
		//driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]")).click();	 	
	 	//Thread.sleep(10000);
	 	//A9 Int sub Be apply

	 	//driver.findElement(By.xpath(".//*[@id='centeringContainer']/div[2]/div[1]/div[3]/div[4]/span[1]")).click();
	 	//driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/div[2]/div/span")).click();
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
				 A9_outageFlagStatusList.add("0");
				 		
			 	}
			 else {
				 A9_outageFlagStatusList.add(outageFlagStatus.get(i).getText());
			 }
			 	
			 
			 A9_YearOfSRClosedDateList.add(Integer.parseInt(YearOfSRClosedDate.get(i).getText())); 
			 
			 if(AggOutageFlagRate.get(i).getText().contains("Null")){
		 			
				 
				 A9_AggOutageFlagRateList.add("0");
		 		}
			 else{
				 A9_AggOutageFlagRateList.add(AggOutageFlagRate.get(i).getText());
			 }
		 		
			 
			 String text = AggSRCount.get(i).getText().replaceAll(",", "");
			 if(text.contains("Null")){
				 A9_AggSRCountList.add(0);

			 }
			 else{
				 A9_AggSRCountList.add(Integer.parseInt(text));
			 }
			
		}
		
	
		Thread.sleep(5000);
		//driver.quit();
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
	    
	   Statement smt = conn.createStatement();		
	   String deletequery = "DELETE FROM OPSBI_360_DTLS_TAC_SR_A9";
	   ResultSet delrs=  smt.executeQuery(deletequery);
	   
	   String A9_queryCD = DataBaseConnection.getQueryCodeFromDataBase("TAC_SR_A9");	

			
	   for(int i=0;i<A9_MonthOfSRClosedDateList.size();i++){	
			String query = "INSERT INTO OPSBI_360_DTLS_TAC_SR_A9 (REC_ID,QUERY_CD,MONTH_OF_SR_CLOSED_DATE,YEAR_OF_SR_CLOSED_DATE,OUTAGE_FLAG_STATUS,SR_NUMBER,OUTAGE_FLAG_RATE) VALUES ('"+(i+1)+"','"+A9_queryCD+"','"+A9_MonthOfSRClosedDateList.get(i)+"','"+A9_YearOfSRClosedDateList.get(i)+"','"+A9_outageFlagStatusList.get(i)+"','"+A9_AggSRCountList.get(i)+"','"+A9_AggOutageFlagRateList.get(i)+"')";			
			System.out.println(query);
			smt.executeQuery(query).close();
		}
		
	
		System.out.println("--- ORACLE Data Table  Inserted into A9 ---");

}
	
	private void set_tAC_SR_B1() throws IOException, InterruptedException, ClassNotFoundException, SQLException{
		//setup
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
		prop.load(file);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sso.cisco.com/autho/forms/maCECLogin.html");
		//driver.get(DataBaseConnection.getURLFromDataBase("TAC_SR_B1"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userInput")).clear();
		driver.findElement(By.id("userInput")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("passwordInput")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).submit();
		Thread.sleep(5000);
		
		driver.get(DataBaseConnection.getURLFromDataBase("TAC_SR_B1"));
		Thread.sleep(5000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='data visualization']")));
		/*driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_(All)']/div[2]/input")).click();		
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_(All)']/div[2]/input")).click();		
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_4']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_5']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_6']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_9']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_10']/div[2]/input")).click();
		driver.findElement(By.xpath(".//*[@id='FI_sqlproxy.1090u7q0zm2szc17w4c330zwso3n,none:int_be:nk14425121001966086373_11634400326256150771_14']/div[2]/input")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_0']/div/div[3]/button[2]")).click(); 
		//A1 INT BE Apply
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
		Thread.sleep(5000);
	 	driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]")).click();	 	
	 	Thread.sleep(10000);
//		//A8 Int sub Be apply

	 	driver.findElement(By.xpath(".//*[@id='centeringContainer']/div[2]/div[1]/div[3]/div[4]/span[1]")).click();
	 	driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/div[2]/div/span")).click();
*/
		Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@name='FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk15161257996304009438_11459229880001888093_(All)']")).click();
		
//		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk4773958904600192927_3931871842746908174_(All)")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk15161257996304009438_11459229880001888093_148")).click();
		Thread.sleep(2000);
		driver.findElement( By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk15161257996304009438_11459229880001888093_485")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk15161257996304009438_11459229880001888093_642")).click();
		Thread.sleep(2000);
		System.out.println("2");
		//driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]")).click();   
//click on apply
	    driver.findElement(By.xpath("//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_2']/div/div[3]/div[3]/button[2]/span[2]")).click(); 
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@class='tabCanvas tab-widget']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@class='tabToolbarButton tab-widget download']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@data-tb-test-id='DownloadData-Button']")).click();
		Thread.sleep(4000);
		//driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/div[2]/div/span")).click();
		System.out.println("3");
		driver.switchTo().defaultContent();

		
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
				 B1_bugLinkedList.add("0");
				 		
			 	}
			 else {
				 B1_bugLinkedList.add(bugLinked.get(i).getText());
			 }
			 	
			 
			 B1_YearOfSRClosedDateList.add(Integer.parseInt(YearOfSRClosedDate.get(i).getText())); 
			 
			 String text = AggSRCount.get(i).getText().replaceAll("%", "");
			 if(AggBugEncounterRate.get(i).getText().contains("Null")){
		 	 B1_AggBugEncounterRateList.add("0");
		 		}
			   else{
				B1_AggBugEncounterRateList.add(AggBugEncounterRate.get(i).getText());
				 
			 }
		 					 
			 String text1 = AggSRCount.get(i).getText().replaceAll(",", "");
			 if(text1.contains("Null")){
				 B1_AggSRCountList.add("0");

			 }
			 else{
				//B1_AggSRCountList.add(Integer.parseInt(text));
				 B1_AggSRCountList.add(text1);
			 }
			
		}
		

		Thread.sleep(5000);
	//	driver.quit();
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
	    
	   Statement smt = conn.createStatement();		
	   String deletequery = "DELETE FROM OPSBI_360_DTLS_TAC_SR_B1";
	   smt.executeQuery(deletequery).close();
	   
	   
	   String B1_queryCD = DataBaseConnection.getQueryCodeFromDataBase("TAC_SR_B1");	

			
	   for(int i=0;i<B1_MonthOfSRClosedDateList.size();i++){	
			String query = "INSERT INTO OPSBI_360_DTLS_TAC_SR_B1 (REC_ID,QUERY_CD,MONTH_OF_SR_CLOSED_DATE,YEAR_OF_SR_CLOSED_DATE,BUG_LINKED,SR_NUMBER,BUG_ENCOUNTER_RATE) VALUES ('"+(i+1)+"','"+B1_queryCD+"','"+B1_MonthOfSRClosedDateList.get(i)+"','"+B1_YearOfSRClosedDateList.get(i)+"','"+B1_bugLinkedList.get(i)+"','"+B1_AggSRCountList.get(i)+"','"+B1_AggBugEncounterRateList.get(i)+"')";			
		System.out.println(query);
		smt.executeQuery(query).close();
		}
		
	
		System.out.println("--- ORACLE Data Table  Inserted into B1---");

	}
	
	
	private void set_tAC_SR_H1() throws SQLException, IOException, ClassNotFoundException, InterruptedException{
		//setup
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
		prop.load(file);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gtcbi.cisco.com/#/views/iSRV/H_1RMARate?:iid=1&Int%20Be=Wireless&Int%20Sub%20Be=Ent.%20-%20Wireless");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userInput")).clear();
		driver.findElement(By.id("userInput")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("passwordInput")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("login-button")).submit();
		Thread.sleep(5000);
		
		//driver.get(DataBaseConnection.getURLFromDataBase("TAC_SR_H1"));
		Thread.sleep(5000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='data visualization']")));
		
	 	Thread.sleep(6000);
		//Product family
		//Click on all cehck box
		driver.findElement(By.xpath("//*[@name='FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk1323420551047822048_1073905432757670420_(All)']")).click();
											
//		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk4773958904600192927_3931871842746908174_(All)")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk1323420551047822048_1073905432757670420_148")).click();
		Thread.sleep(2000);
		driver.findElement( By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk1323420551047822048_1073905432757670420_485")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk1323420551047822048_1073905432757670420_642")).click();
		Thread.sleep(2000);
		System.out.println("2");
		//driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]")).click();   
       //click on apply
	    driver.findElement(By.xpath("//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_2']/div/div[3]/div[3]/button[2]/span[2]")).click(); 
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@class='tabCanvas tab-widget']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@class='tabToolbarButton tab-widget download']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@data-tb-test-id='DownloadData-Button']")).click();
		Thread.sleep(4000);
		//driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/div[2]/div/span")).click();
		System.out.println("3");
		driver.switchTo().defaultContent();
	 	
		System.out.println("31");
	 	//driver.findElement(By.xpath(".//*[@id='centeringContainer']/div[2]/div[1]/div[3]/div[4]/span[1]")).click();
	 	//driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/div[2]/div/span")).click();
	 	for(String childWindow:driver.getWindowHandles()){
			driver.switchTo().window(childWindow).manage().window().maximize();;
	}
	 	System.out.println("32");
		List<WebElement> MonthOfSRClosedDate = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[1]"));System.out.println("32");
		System.out.println("33");
		List<WebElement> SRinitialseverity = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[2]"));
		System.out.println("34");
		List<WebElement> YearOfSRClosedDate = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[3]"));
		System.out.println("35");
		List<WebElement> AggInitialSevRate = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[4]"));
		System.out.println("36");
		List<WebElement> AggSRCount = driver.findElements(By.xpath("//table[@class='datatable']/tbody/tr/td[5]"));
		System.out.println("37");
		
		
		for(int i=0;i<MonthOfSRClosedDate.size();i++){
			 H1_MonthOfSRClosedDateList.add(MonthOfSRClosedDate.get(i).getText());
			 System.out.println("38");
			 if(SRinitialseverity.get(i).getText().contains("Null")){
				 H1_RMAissuedList.add("0");
				 System.out.println("39");	
			 	}
			 else {
				 H1_RMAissuedList.add(SRinitialseverity.get(i).getText());
				 System.out.println("40");
			 }
			 	
			 System.out.println("41");
			 H1_YearOfSRClosedDateList.add(Integer.parseInt(YearOfSRClosedDate.get(i).getText())); 
			 System.out.println("42");
			 if(AggInitialSevRate.get(i).getText().contains("Null")){
				 System.out.println("42");	
				 
				 H1_AggRMAissuedrateList.add("0");
				 
		 		}
			 else{
				 System.out.println("43");
				 H1_AggRMAissuedrateList.add(AggInitialSevRate.get(i).getText());
			 }
		 		
			 System.out.println("44");
			 String text = AggSRCount.get(i).getText().replaceAll(",", "");
			 if(text.contains("Null")){
				 System.out.println("45");
				 H1_AggSRCountList.add(0);

			 }
			 else{
				 System.out.println("46");
				 H1_AggSRCountList.add(Integer.parseInt(text));
			 }
			
		}
		System.out.println("47");
		
			 
		Thread.sleep(2000);
		//driver.quit();
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
	    System.out.println("3*****HERE");
	   Statement smt = conn.createStatement();		
	   String deletequery = "DELETE FROM OPSBI_360_DTLS_TAC_SR_H1";
	   smt.executeQuery(deletequery).close();
	   
	   System.out.println("4");
	   String H1_queryCD = DataBaseConnection.getQueryCodeFromDataBase("TAC_SR_H1");	
	   System.out.println("5");
	 
		for(int i=0;i< H1_MonthOfSRClosedDateList.size();i++){	
			System.out.println("6");
			String query = "INSERT INTO OPSBI_360_DTLS_TAC_SR_H1 (REC_ID,QUERY_CD,MONTH_OF_SR_CLOSED_DATE,YEAR_OF_SR_CLOSED_DATE,AGG_SR_COUNT,RMA_ISSUED,AGG_RMA_ISSUED_RATE) VALUES ('"+(i+1)+"','"+H1_queryCD+"','"+H1_MonthOfSRClosedDateList.get(i)+"','"+ H1_YearOfSRClosedDateList.get(i)+"','"+H1_AggSRCountList.get(i)+"','"+H1_RMAissuedList.get(i)+"','"+H1_AggRMAissuedrateList.get(i)+"')";			
			System.out.println(query);
			smt.executeQuery(query).close();
		}
		
	
		System.out.println("--- ORACLE Data Table  Inserted into H1---");
		
		
		
	}

	
	
	public static void main(String args[]) throws ClassNotFoundException, InterruptedException, SQLException, IOException {
		TacSR_Tableau tacsr = new TacSR_Tableau();
		//tacsr.set_tAC_SR_A1();
		//tacsr.set_tAC_SR_A8();
		//tacsr.set_tAC_SR_A9();
		//tacsr.set_tAC_SR_B1();
		tacsr.set_tAC_SR_H1();
		
	}

	
}
