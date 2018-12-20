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

public class H1_IOT {
	Properties prop = new Properties();
	public WebDriver driver;
	//H1
		ArrayList<String> H1_MonthOfSRClosedDateList = new ArrayList<String>();
		ArrayList<String> H1_RMAissuedList = new ArrayList<String>();
		ArrayList<Integer> H1_YearOfSRClosedDateList = new ArrayList<Integer>();
		ArrayList<String> H1_AggRMAissuedrateList = new ArrayList<String>();
		ArrayList<Integer> H1_AggSRCountList = new ArrayList<Integer>();
	

	
	
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
		driver.get("https://gtcbi.cisco.com/#/views/iSRV/H_1RMARate?:iid=5&Int%20Be=Wireless&Int%20Sub%20Be=Ent.%20-%20Wireless");
		Thread.sleep(5000);
		//Test case
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='data visualization']")));
		System.out.println("1");
		
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//*[@name='FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:int_sub_be:nk1323420551047822048_1073905432757670420_(All)']")).click();	
		
		driver.findElement(By.xpath("//*[@id='dijit_form_Button_8']//*[@class='dijitReset dijitInline wcIconSearch']")).click();
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_FilteringSearchWidget_1']//*[@title='Search (Enter)']")).sendKeys("IOT");
		
		
		
		Thread.sleep(2000);
		driver.findElement(By.name("SI_federated.149la7x0jupmum1fpqfe51s9do3m,none:int_sub_be:nk1323420551047822048_1073905432757670420_25")).click();
		
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
		
		

		Thread.sleep(5000);
	//	driver.quit();
		    
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
	    
	   Statement smt = conn.createStatement();		
	   String deletequery = "DELETE FROM OPSBI_360_H1_IOT";
	   ResultSet delrs=  smt.executeQuery(deletequery);
	   
	   
	   String A1_queryCD = DataBaseConnection.getQueryCodeFromDataBase("TAC_SR_A1");	
	 

		for(int i=0;i<H1_MonthOfSRClosedDateList.size();i++){	
			String query = "INSERT INTO OPSBI_360_H1_IOT (REC_ID,QUERY_CD,MONTH_OF_SR_CLOSED_DATE,YEAR_OF_SR_CLOSED_DATE,AGG_SR_COUNT,RMA_ISSUED,AGG_RMA_ISSUED_RATE) VALUES ('"+(i+1)+"','A24','"+H1_MonthOfSRClosedDateList.get(i)+"','"+ H1_YearOfSRClosedDateList.get(i)+"','"+H1_AggSRCountList.get(i)+"','"+H1_RMAissuedList.get(i)+"','"+H1_AggRMAissuedrateList.get(i)+"')";			
		System.out.println(query);
		smt.executeQuery(query).close();
		}
		
	
		System.out.println("--- Data Inserted into OPSBI_360_H1_IOT---");

	}
	public static void main(String args[]) throws ClassNotFoundException, InterruptedException, SQLException, IOException {
		H1_IOT e= new H1_IOT();
		e.set_tAC_SR_A1();
	}


}
