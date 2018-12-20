package csone;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class Campus_switching_50 {
	WebDriver driver;
	JavascriptExecutor js;
	File myFile;
	//Workbook wb = null;
	Properties prop = new Properties();
	
	ArrayList<String> CaseNumber_List = new ArrayList<String>();
	ArrayList<String> Status_List = new ArrayList<String>();
	ArrayList<String> Priority_List = new ArrayList<String>();
	
	 
	private void ifd() throws InterruptedException, SQLException, ClassNotFoundException, IOException, AWTException{
		
	//myFile = new File("C:\\Users\\akvangal\\Downloads\\test.xls");
		// myFile = new File("C:\\Users\\akvangal\\Downloads\\dnac-all-_-cfd-mttr (9).xls");
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
		driver.get("https://csone.my.salesforce.com/console");
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.id("ext-comp-1005")));
		Thread.sleep(2000);
		driver.findElement(By.id("ext-comp-1013")).sendKeys("360-CAMPUS-SWITCHING-50");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='00O1C0000080vXb_NAME']/div[2]/a")).click();
		Thread.sleep(4000);
		 driver.switchTo().defaultContent();
		// driver.findElement(By.xpath("//*[@class='hasMotif reportTab  reportRunPage sfdcBody brandQuaternaryBgr   ext-webkit ext-chrome']")).click();
		 System.out.println("here1");
		
		    //ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		   // driver.switchTo().window(tabs2.get(1));
		   // driver.close();
		   // driver.switchTo().window(tabs2.get(0));
		//driver.findElement(By.id("//*[@id='ext-gen175']")).click();
		System.out.println("here");
		//driver.findElement(arg0)
		//driver.switchTo().frame(driver.findElement(By.id("ext-comp-1025")));
		    System.out.println("1");
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,500)", "");
			 driver.switchTo().frame(driver.findElement(By.id("ext-comp-1025")));
		 
		//WebElement e= driver.findElement(By.xpath("//*[@value='Printable View']"));
		//e.click();
			 /*Robot robot =new Robot();
			 robot.keyPress(KeyEvent.VK_TAB);
	         robot.keyRelease(KeyEvent.VK_TAB);
	         robot.keyPress(KeyEvent.VK_DOWN);
	         robot.keyRelease(KeyEvent.VK_DOWN);
	         robot.keyPress(KeyEvent.VK_DOWN);
	         robot.keyRelease(KeyEvent.VK_DOWN);
	            Thread.sleep(2000);*/
	           
	           // driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

		
		List<WebElement> CaseNumber = driver.findElements(By.xpath("//*[@class='reportTable tabularReportTable']/tbody/tr/td[1]/a"));
		//System.out.println("5");
		List<WebElement> Status = driver.findElements(By.xpath("//*[@class='reportTable tabularReportTable']/tbody/tr/td[2]"));
		List<WebElement> Priority = driver.findElements(By.xpath("//*[@class='reportTable tabularReportTable']/tbody/tr/td[3]"));
		//System.out.println("6");
		System.out.println(CaseNumber.size());
		
		for(int i=0;i<CaseNumber.size();i++){
			System.out.println("7");
			CaseNumber_List.add(CaseNumber.get(i).getText());
			System.out.println(CaseNumber.get(i).getText());
			Status_List.add(Status.get(i).getText());
			System.out.println(Status.get(i).getText());
			Priority_List.add(Priority.get(i).getText());
			
			//AggList.add(Integer.parseInt(Priority.get(i).getText().replaceAll(",", "")));
			//System.out.println("9");
		
			
		    }
		Thread.sleep(5000);
		//driver.quit();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
	    
	   Statement smt = conn.createStatement();		
	   String deletequery = "DELETE FROM OPSBI_360_CSONE_SWITCHING50";
	   ResultSet delrs=  smt.executeQuery(deletequery);
	   
	   
	   String A1_queryCD = DataBaseConnection.getQueryCodeFromDataBase("TAC_SR_A1");	
	 

	   for(int i=0;i< CaseNumber_List.size()*2;i++){	
  			int j = i;
  			String qry_code = "A10";
  			if (j >= CaseNumber_List.size()) {
  				j-= CaseNumber_List.size();
  				qry_code = "A16";
  			}
  			String query = "INSERT INTO OPSBI_360_CSONE_SWITCHING50 (REC_ID,QUERY_CD,CASE_NUMBER,STATUS,PRIORITY) VALUES ('"+(i+1)+"','"+qry_code+"','"+CaseNumber_List.get(j)+"','"+Status_List.get(j)+"','"+Priority_List.get(j)+"')";			
		System.out.println(query);
		smt.executeQuery(query).close();
		}
		
	
		System.out.println("--- Data Inserted into OPSBI_360_CSONE_SWITCHING50 ---");
		
		

 			}
	public static void main(String args[]) throws ClassNotFoundException, InterruptedException, SQLException, IOException, AWTException {
		Campus_switching_50 cs= new Campus_switching_50();
		cs.ifd();
		
		
	}

}
