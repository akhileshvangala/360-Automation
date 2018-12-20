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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import clip.DataBaseConnection;

public class A8_Routing {
	Properties prop = new Properties();
	public WebDriver driver;

	
	//A8
	ArrayList<String> A8_MonthOfSRClosedDateList = new ArrayList<String>();
	ArrayList<Integer> A8_SRinitialseverityList = new ArrayList<Integer>();
	ArrayList<Integer> A8_YearOfSRClosedDateList = new ArrayList<Integer>();
	ArrayList<String> A8_AggInitialSevRateList = new ArrayList<String>();
	ArrayList<Integer> A8_AggSRCountList = new ArrayList<Integer>();
	
	
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
		
		//driver.get(DataBaseConnection.getURLFromDataBase("TAC_SR_A1"));
		driver.get("https://gtcbi.cisco.com/#/views/iSRV/A_8InitialSev1Trend?:iid=1&Int%20Be=Wireless&Int%20Sub%20Be=Ent.%20-%20Wireless");
		Thread.sleep(15000);
		//Test case
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='data visualization']")));
		System.out.println("1");
		
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//*[@name='FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:int_be:nk3406081045800067867_16598193771552127451_(All)']")).click();	
		
		/*driver.findElement(By.xpath("//*[@id='dijit_form_Button_12']//*[@class='dijitReset dijitInline wcIconSearch']")).click();
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_FilteringSearchWidget_2']//*[@title='Search (Enter)']")).sendKeys("CISE");
		
		
		
		Thread.sleep(2000);*/
		driver.findElement(By.name("FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:int_be:nk3406081045800067867_16598193771552127451_4")).click();
		/*Thread.sleep(3000);  
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_FilteringSearchWidget_2']//*[@title='Search (Enter)']")).clear();
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_FilteringSearchWidget_2']//*[@title='Search (Enter)']")).sendKeys("CSACS");
		Thread.sleep(2000);
		driver.findElement(By.name("SI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk4773958904600192927_3931871842746908174_324")).click();
		Thread.sleep(3000);  */
		/*driver.findElement(By.xpath("//*[@id='tableau_base_widget_FilteringSearchWidget_2']//*[@title='Search (Enter)']")).clear();
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_FilteringSearchWidget_2']//*[@title='Search (Enter)']")).sendKeys("SDNMGMT");
		Thread.sleep(2000);
		driver.findElement(By.name("SI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk3406081045800067867_16598193771552127451_646")).click();
		*/
		
		System.out.println("2");
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_0']/div/div[3]/div[3]/button[2]/span[2]")).click();
	    
	    //Done here
	    Thread.sleep(25000);
	    
	    
		//driver.findElement(By.xpath("//*[@class='tab-tvView tvimagesNS']")).click();

		driver.findElement(By.xpath("//*[@class='tabCanvas tab-widget']")).click();
		Thread.sleep(3000);
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
   String deletequery = "DELETE FROM OPSBI_360_A8_ROUTING";
   smt.executeQuery(deletequery).close();
   
   System.out.println("4");
   String A8_queryCD = DataBaseConnection.getQueryCodeFromDataBase("TAC_SR_A8");	
   System.out.println("5");
 
	for(int i=0;i< A8_MonthOfSRClosedDateList.size();i++){	
		System.out.println("6");
		String query = "INSERT INTO OPSBI_360_A8_ROUTING (REC_ID,QUERY_CD,MONTH_OF_SR_CLOSED_DATE,YEAR_OF_SR_CLOSED_DATE,SR_INITIAL_SEVERITY,AGG_INITIAL_SEV1_RATE,AGG_SR_COUNT) VALUES ('"+(i+1)+"','"+A8_queryCD+"','"+A8_MonthOfSRClosedDateList.get(i)+"','"+ A8_YearOfSRClosedDateList.get(i)+"','"+A8_SRinitialseverityList.get(i)+"','"+A8_AggInitialSevRateList.get(i)+"','"+A8_AggSRCountList.get(i)+"')";			
		System.out.println("");
		smt.executeQuery(query).close();
	}
	

	System.out.println("--- ORACLE Data Table  Inserted into OPSBI_360_A8_ROUTING---");
	
	

	}
	public static void main(String args[]) throws ClassNotFoundException, InterruptedException, SQLException, IOException {
		A8_Routing e= new A8_Routing();
		e.set_tAC_SR_A1();
	}
	


}
