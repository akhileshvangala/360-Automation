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

public class A9_IOT {
	Properties prop = new Properties();
	public WebDriver driver;

	
	//A9
	ArrayList<String> A9_MonthOfSRClosedDateList = new ArrayList<String>();
	ArrayList<String> A9_outageFlagStatusList = new ArrayList<String>();
	ArrayList<Integer> A9_YearOfSRClosedDateList = new ArrayList<Integer>();
	ArrayList<String> A9_AggOutageFlagRateList = new ArrayList<String>();
	ArrayList<Integer> A9_AggSRCountList = new ArrayList<Integer>();
	
	
	
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
		driver.get("https://gtcbi.cisco.com/#/views/iSRV/A_9OutageFlagTrend?:iid=1&Int%20Be=Wireless&Int%20Sub%20Be=Ent.%20-%20Wireless");
		Thread.sleep(15000);
		//Test case
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='data visualization']")));
		System.out.println("1");
		
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//*[@name='FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:int_sub_be:nk17172440791263305633_15577160950903750791_(All)']")).click();	
		
		driver.findElement(By.xpath("//*[@id='dijit_form_Button_8']//*[@class='dijitReset dijitInline wcIconSearch']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_FilteringSearchWidget_1']//*[@title='Search (Enter)']")).sendKeys("IOT");
		
		
		
		Thread.sleep(2000);
		driver.findElement(By.name("SI_federated.149la7x0jupmum1fpqfe51s9do3m,none:int_sub_be:nk17172440791263305633_15577160950903750791_25")).click();
		
		
		System.out.println("2");
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/div[3]/button[2]/span[2]")).click();
	    
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
	   String deletequery = "DELETE FROM OPSBI_360_A9_IOT";
	   ResultSet delrs=  smt.executeQuery(deletequery);
	   
	   String A9_queryCD = DataBaseConnection.getQueryCodeFromDataBase("TAC_SR_A9");	

			
	   for(int i=0;i<A9_MonthOfSRClosedDateList.size();i++){	
			String query = "INSERT INTO OPSBI_360_A9_IOT (REC_ID,QUERY_CD,MONTH_OF_SR_CLOSED_DATE,YEAR_OF_SR_CLOSED_DATE,OUTAGE_FLAG_STATUS,SR_NUMBER,OUTAGE_FLAG_RATE) VALUES ('"+(i+1)+"','"+A9_queryCD+"','"+A9_MonthOfSRClosedDateList.get(i)+"','"+A9_YearOfSRClosedDateList.get(i)+"','"+A9_outageFlagStatusList.get(i)+"','"+A9_AggSRCountList.get(i)+"','"+A9_AggOutageFlagRateList.get(i)+"')";			
			System.out.println(query);
			smt.executeQuery(query).close();
		}
		
	
		System.out.println("--- ORACLE Data Table  Inserted into OPSBI_360_A9_IOT ---");
	

	}
	public static void main(String args[]) throws ClassNotFoundException, InterruptedException, SQLException, IOException {
		A9_IOT e= new A9_IOT();
		e.set_tAC_SR_A1();
	}
	


}
