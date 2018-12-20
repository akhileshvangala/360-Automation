package csone;

import java.awt.AWTException;
import java.io.File;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import clip.DataBaseConnection;

public class Campus_switching_100 {
	
	WebDriver driver;
	JavascriptExecutor js;
	File myFile;
	//Workbook wb = null;
	Properties prop = new Properties();
	static String Total,Total1,Total2;
	
	 
	private void ifd() throws InterruptedException, SQLException, ClassNotFoundException, IOException, AWTException{
		
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
		driver.get("https://csone.my.salesforce.com/console");
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.id("ext-comp-1005")));
		Thread.sleep(2000);
		driver.findElement(By.id("ext-comp-1013")).sendKeys("360-CAMPUS-SWITCHING-100");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='00O1C00000856g3_NAME']/div[2]/a")).click();
		Thread.sleep(4000);
		 driver.switchTo().defaultContent();
		// driver.findElement(By.xpath("//*[@class='hasMotif reportTab  reportRunPage sfdcBody brandQuaternaryBgr   ext-webkit ext-chrome']")).click();
		 	JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,500)", "");
			 driver.switchTo().frame(driver.findElement(By.id("ext-comp-1025")));
			 WebElement Total = driver.findElement(By.xpath("//*[@class='reportTable tabularReportTable']/tbody/tr[@class='grandTotal grandTotalTop']/td/strong"));
			 String grandTotal_switching = Total.getText();
			 System.out.println(grandTotal_switching);
			 String grandTotal2_switching = grandTotal_switching.substring(14, 17);
			 System.out.println(grandTotal2_switching);
			 //int grandTotal1 = Integer.parseInt(grandTotal);
			// System.out.println("integer value of grand total  "+grandTotal1);
			 
		 		
		
		Thread.sleep(5000);
		//driver.quit();
		
		//Routing
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
		driver.get("https://csone.my.salesforce.com/console");
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.id("ext-comp-1005")));
		Thread.sleep(2000);
		driver.findElement(By.id("ext-comp-1013")).sendKeys("360-ent-routing-100");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='00O1C000008570w_NAME']/div[2]/a")).click();
		Thread.sleep(4000);
		 driver.switchTo().defaultContent();
		// driver.findElement(By.xpath("//*[@class='hasMotif reportTab  reportRunPage sfdcBody brandQuaternaryBgr   ext-webkit ext-chrome']")).click();
		 	JavascriptExecutor js1 = (JavascriptExecutor) driver;
			 js1.executeScript("window.scrollBy(0,500)", "");
			 driver.switchTo().frame(driver.findElement(By.id("ext-comp-1025")));
			 WebElement Total1 = driver.findElement(By.xpath("//*[@class='reportTable tabularReportTable']/tbody/tr[@class='grandTotal grandTotalTop']/td/strong"));
			 String grandTota1_routing = Total1.getText();
			 System.out.println(grandTota1_routing);
			 String grandTotal2_routing = grandTota1_routing.substring(14, 17);
			 System.out.println(grandTotal2_routing);
			 //int grandTotal1 = Integer.parseInt(grandTotal);
			// System.out.println("integer value of grand total  "+grandTotal1);
			 
		 		
		
		Thread.sleep(5000);
		
		
		//Wireless
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
				driver.get("https://csone.my.salesforce.com/console");
				Thread.sleep(10000);
				driver.switchTo().frame(driver.findElement(By.id("ext-comp-1005")));
				Thread.sleep(2000);
				driver.findElement(By.id("ext-comp-1013")).sendKeys("360-wireless-100");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='00O1C00000856Yi_NAME']/div[2]/a")).click();
				Thread.sleep(4000);
				 driver.switchTo().defaultContent();
				// driver.findElement(By.xpath("//*[@class='hasMotif reportTab  reportRunPage sfdcBody brandQuaternaryBgr   ext-webkit ext-chrome']")).click();
				 	JavascriptExecutor js2 = (JavascriptExecutor) driver;
					 js2.executeScript("window.scrollBy(0,500)", "");
					 driver.switchTo().frame(driver.findElement(By.id("ext-comp-1025")));
					 WebElement Total2 = driver.findElement(By.xpath("//*[@class='reportTable tabularReportTable']/tbody/tr[@class='grandTotal grandTotalTop']/td/strong"));
					 String grandTota1_Wireless = Total2.getText();
					 System.out.println(grandTota1_Wireless);
					 String grandTotal2_Wireless = grandTota1_Wireless.substring(14, 17);
					 System.out.println(grandTotal2_Wireless);
					 //int grandTotal1 = Integer.parseInt(grandTotal);
					// System.out.println("integer value of grand total  "+grandTotal1);
					 
				 		
				
				Thread.sleep(5000);
				
				//DNA
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
				driver.get("https://csone.my.salesforce.com/console");
				Thread.sleep(10000);
				driver.switchTo().frame(driver.findElement(By.id("ext-comp-1005")));
				Thread.sleep(2000);
				driver.findElement(By.id("ext-comp-1013")).sendKeys("360-DNAC-100");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='00O1C0000080vKS_NAME']/div[2]/a")).click();
				Thread.sleep(4000);
				 driver.switchTo().defaultContent();
				// driver.findElement(By.xpath("//*[@class='hasMotif reportTab  reportRunPage sfdcBody brandQuaternaryBgr   ext-webkit ext-chrome']")).click();
				 	JavascriptExecutor js3 = (JavascriptExecutor) driver;
					 js3.executeScript("window.scrollBy(0,500)", "");
					 driver.switchTo().frame(driver.findElement(By.id("ext-comp-1025")));
					 WebElement Total3 = driver.findElement(By.xpath("//*[@class='reportTable tabularReportTable']/tbody/tr[@class='grandTotal grandTotalTop']/td/strong"));
					 String grandTota1_DNA = Total3.getText();
					 System.out.println(grandTota1_DNA);
					 String grandTotal2_DNA = grandTota1_DNA.substring(14, 17);
					 System.out.println(grandTotal2_DNA);
					 //int grandTotal1 = Integer.parseInt(grandTotal);
					// System.out.println("integer value of grand total  "+grandTotal1);
					 
				 		
				
				Thread.sleep(5000);
				
				
				//SPA(ISE)
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
				driver.get("https://csone.my.salesforce.com/console");
				Thread.sleep(10000);
				driver.switchTo().frame(driver.findElement(By.id("ext-comp-1005")));
				Thread.sleep(2000);
				driver.findElement(By.id("ext-comp-1013")).sendKeys("360-ise/acs-100");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='00O1C00000856ck_NAME']/div[2]/a")).click();
				Thread.sleep(4000);
				 driver.switchTo().defaultContent();
				// driver.findElement(By.xpath("//*[@class='hasMotif reportTab  reportRunPage sfdcBody brandQuaternaryBgr   ext-webkit ext-chrome']")).click();
				 	JavascriptExecutor js4 = (JavascriptExecutor) driver;
					 js4.executeScript("window.scrollBy(0,500)", "");
					 driver.switchTo().frame(driver.findElement(By.id("ext-comp-1025")));
					 WebElement Total4 = driver.findElement(By.xpath("//*[@class='reportTable tabularReportTable']/tbody/tr[@class='grandTotal grandTotalTop']/td/strong"));
					 String grandTota1_SPA = Total4.getText();
					 System.out.println(grandTota1_SPA);
					 String grandTotal2_SPA = grandTota1_SPA.substring(14, 17);
					 System.out.println(grandTotal2_SPA);
					 //int grandTotal1 = Integer.parseInt(grandTotal);
					// System.out.println("integer value of grand total  "+grandTotal1);
					 
				 		
				
				Thread.sleep(5000);
				
				
				

				//INFRA
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
				driver.get("https://csone.my.salesforce.com/console");
				Thread.sleep(10000);
				driver.switchTo().frame(driver.findElement(By.id("ext-comp-1005")));
				Thread.sleep(2000);
				driver.findElement(By.id("ext-comp-1013")).sendKeys("360-nscg-100");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='00O1C00000856ZM_NAME']/div[2]/a")).click();
				Thread.sleep(4000);
				 driver.switchTo().defaultContent();
				// driver.findElement(By.xpath("//*[@class='hasMotif reportTab  reportRunPage sfdcBody brandQuaternaryBgr   ext-webkit ext-chrome']")).click();
				 	JavascriptExecutor js5 = (JavascriptExecutor) driver;
					 js5.executeScript("window.scrollBy(0,500)", "");
					 driver.switchTo().frame(driver.findElement(By.id("ext-comp-1025")));
					 WebElement Total5 = driver.findElement(By.xpath("//*[@class='reportTable tabularReportTable']/tbody/tr[@class='grandTotal grandTotalTop']/td/strong"));
					 String grandTota1_INFRA = Total5.getText();
					 System.out.println(grandTota1_SPA);
					 String grandTotal2_INFRA = grandTota1_INFRA.substring(14, 17);
					 System.out.println(grandTotal2_INFRA);
					 //int grandTotal1 = Integer.parseInt(grandTotal);
					// System.out.println("integer value of grand total  "+grandTotal1);
					 
				 		
				
				Thread.sleep(5000);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
	    
	   Statement smt = conn.createStatement();		

	   String trunc= "truncate  table OPSBI_360_CSONE_100";
	   smt.executeQuery(trunc);
	   
	   
	 

		String query = "INSERT INTO OPSBI_360_CSONE_100 (REC_ID,QUERY_CD,PIN,TOTAL_COUNT) VALUES ('1','A10','Switching','"+grandTotal2_switching+"')";			
		String query1 = "INSERT INTO OPSBI_360_CSONE_100 (REC_ID,QUERY_CD,PIN,TOTAL_COUNT) VALUES ('2','A11','Routing','"+grandTotal2_routing+"')";	
		
		String query2 = "INSERT INTO OPSBI_360_CSONE_100 (REC_ID,QUERY_CD,PIN,TOTAL_COUNT) VALUES ('3','A12','Wireless','"+grandTotal2_Wireless+"')";	
		String query3 = "INSERT INTO OPSBI_360_CSONE_100 (REC_ID,QUERY_CD,PIN,TOTAL_COUNT) VALUES ('4','A14','DNA','"+grandTotal2_DNA+"')";	
		String query4 = "INSERT INTO OPSBI_360_CSONE_100 (REC_ID,QUERY_CD,PIN,TOTAL_COUNT) VALUES ('5','A15','SPA','"+grandTotal2_SPA+"')";	
		String query5 = "INSERT INTO OPSBI_360_CSONE_100 (REC_ID,QUERY_CD,PIN,TOTAL_COUNT) VALUES ('6','A13','INFRA','"+grandTotal2_INFRA+"')";	

		System.out.println(query);
		smt.executeQuery(query);

		smt.executeQuery(query1);
		smt.executeQuery(query2);
		smt.executeQuery(query3);
		smt.executeQuery(query4);

		smt.executeQuery(query5).close();

		
		
	
		System.out.println("--- Data Inserted into OPSBI_360_CSONE_100 ---");
		
		

	}

	public static void main(String args[]) throws ClassNotFoundException, InterruptedException, SQLException, IOException, AWTException {
		Campus_switching_100 cs= new Campus_switching_100();
		cs.ifd();
		
	}
}
	