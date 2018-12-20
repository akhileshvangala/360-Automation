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

public class B1_Infra {
	Properties prop = new Properties();
	public WebDriver driver;
	//B1
	ArrayList<String> B1_bugLinkedList = new ArrayList<String>();
	ArrayList<String> B1_MonthOfSRClosedDateList = new ArrayList<String>();
	ArrayList<Integer> B1_YearOfSRClosedDateList = new ArrayList<Integer>();
	ArrayList<String> B1_AggBugEncounterRateList = new ArrayList<String>();
	ArrayList<String> B1_AggSRCountList = new ArrayList<String>();
	

	
	
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
		driver.get("https://gtcbi.cisco.com/#/views/iSRV/B_1BugEncounterRate?:iid=1&Int%20Be=Wireless&Int%20Sub%20Be=Ent.%20-%20Wireless");
		Thread.sleep(5000);
		//Test case
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='data visualization']")));
		System.out.println("1");
		
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//*[@name='FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk15161257996304009438_11459229880001888093_(All)']")).click();	
		
		driver.findElement(By.xpath("//*[@id='dijit_form_Button_12']//*[@class='dijitReset dijitInline wcIconSearch']")).click();
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_FilteringSearchWidget_2']//*[@title='Search (Enter)']")).sendKeys("INFRA");
		
		
		
		Thread.sleep(2000);
		driver.findElement(By.name("SI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk15161257996304009438_11459229880001888093_487")).click();
		Thread.sleep(3000);  
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_FilteringSearchWidget_2']//*[@title='Search (Enter)']")).clear();
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_FilteringSearchWidget_2']//*[@title='Search (Enter)']")).sendKeys("APIC");
		Thread.sleep(2000);
		driver.findElement(By.name("SI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk15161257996304009438_11459229880001888093_147")).click();
		Thread.sleep(3000);  
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_FilteringSearchWidget_2']//*[@title='Search (Enter)']")).clear();
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_FilteringSearchWidget_2']//*[@title='Search (Enter)']")).sendKeys("SDNMGMT");
		Thread.sleep(2000);
		driver.findElement(By.name("SI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk15161257996304009438_11459229880001888093_646")).click();
		
		
		System.out.println("2");
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_2']/div/div[3]/div[3]/button[2]/span[2]")).click();
	    
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
	   String deletequery = "DELETE FROM OPSBI_360_B1_INFRA";
	   ResultSet delrs=  smt.executeQuery(deletequery);
	   
	   
	   String A1_queryCD = DataBaseConnection.getQueryCodeFromDataBase("TAC_SR_A1");	
	 

		for(int i=0;i<B1_MonthOfSRClosedDateList.size();i++){	
			String query = "INSERT INTO OPSBI_360_B1_INFRA (REC_ID,QUERY_CD,MONTH_OF_SR_CLOSED_DATE,YEAR_OF_SR_CLOSED_DATE,BUG_LINKED,SR_NUMBER,BUG_ENCOUNTER_RATE) VALUES ('"+(i+1)+"','Test','"+B1_MonthOfSRClosedDateList.get(i)+"','"+B1_YearOfSRClosedDateList.get(i)+"','"+B1_bugLinkedList.get(i)+"','"+B1_AggSRCountList.get(i)+"','"+B1_AggBugEncounterRateList.get(i)+"')";			
		System.out.println(query);
		smt.executeQuery(query).close();
		}
		
	
		System.out.println("--- Data Inserted into OPSBI_360_B1_INFRA---");

	}
	public static void main(String args[]) throws ClassNotFoundException, InterruptedException, SQLException, IOException {
		B1_Infra e= new B1_Infra();
		e.set_tAC_SR_A1();
	}

}
