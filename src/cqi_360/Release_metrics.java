package cqi_360;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import clip.DataBaseConnection;

public class Release_metrics {
	WebDriver driver;
	Properties prop = new Properties();
	String rg;
	String cfd;
	String urc;
	String mttr_rg;
	String mttr_cfd;
	String mttr_urc;

	
	private void set_cqa_DNA() throws InterruptedException, SQLException, ClassNotFoundException, IOException, AWTException{
		Robot robot = new Robot();
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
		driver.get("https://wwwin-cqi.cisco.com/cqi/relViewHome.htm?org=XE&vewId=735");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='dropdownMenu1']")).click();
		Thread.sleep(2000);
		 List<WebElement> dropdown = driver.findElements(By.xpath("//*[@aria-labelledby='dropdownMenu1']/li/a"));
			System.out.println(dropdown.size());
			for(int i=0; i<dropdown.size(); i++) {
				System.out.println(dropdown.get(i).getText());
				if(dropdown.get(i).getText().equalsIgnoreCase("XE")) {
				dropdown.get(i).click();
				break;
				}
			}
			Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@type='search']")).click();
		//driver.findElement(By.xpath("//*[@class='dropdown-search']")).sendKeys("16111");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
				
		List<WebElement> dropdown1 = driver.findElements(By.xpath("//*[@id='viewsSearch']/ul/li/label/span"));
		System.out.println(dropdown1.size());
		for(int i=0; i<dropdown1.size(); i++) {
			System.out.println(dropdown1.get(i).getText());
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(1000);
			if(dropdown1.get(i).getText().equalsIgnoreCase("16111 Release View")) {
			dropdown1.get(i).click();
			dropdown1.get(i).click();
			break;
			}
		}
		Thread.sleep(2000);
		WebElement apply= driver.findElement(By.xpath("//*[@class='btn btn-primary btnCQISubmit btnViewSearchSelectAll ']"));
		apply.click();
		Thread.sleep(2000);
		apply.click();
		Thread.sleep(3000);
		
		WebElement count1 = driver.findElement(By.xpath("//*[@id='relViewHomeCont']/div[2]/div[2]/div[38]//*/table[@class='table table-hover metricsTable']/tbody/tr[2]/td[2]/span[1]"));
		rg=count1.getText();
		WebElement count2 = driver.findElement(By.xpath("//*[@id='relViewHomeCont']/div[2]/div[2]/div[38]//*/table[@class='table table-hover metricsTable']/tbody/tr[2]/td[3]/span[1]"));
		cfd=count2.getText();
		WebElement count3 = driver.findElement(By.xpath("//*[@id='relViewHomeCont']/div[2]/div[2]/div[38]//*/table[@class='table table-hover metricsTable']/tbody/tr[2]/td[4]/span[1]"));
		urc=count3.getText();
		WebElement count4 = driver.findElement(By.xpath("//*[@id='relViewHomeCont']/div[2]/div[2]/div[38]//*/table[@class='table table-hover metricsTable']/tbody/tr[3]/td[2]/span[1]"));
		mttr_rg=count4.getText();
		WebElement count5 = driver.findElement(By.xpath("//*[@id='relViewHomeCont']/div[2]/div[2]/div[38]//*/table[@class='table table-hover metricsTable']/tbody/tr[3]/td[3]/span[1]"));
		mttr_cfd=count5.getText();
		WebElement count6 = driver.findElement(By.xpath("//*[@id='relViewHomeCont']/div[2]/div[2]/div[38]//*/table[@class='table table-hover metricsTable']/tbody/tr[3]/td[4]/span[1]"));
		mttr_urc=count6.getText();
		System.out.println(mttr_urc);
		
		
		//List<WebElement> Count = driver.findElements(By.xpath("//*[@id='relViewHomeCont']/div[2]/div[2]/div[38]//*/table[@class='table table-hover metricsTable']/tbody/tr/td/span[1]"));
		
				/*System.out.println(Count.size());
		for(int i=0;i<=Count.size();i++){
			rg = Count.get(i).getText();
			System.out.println(rg);
			cfd= Count.get(i).getText();
			System.out.println(cfd);
			 urc= Count.get(i).getText();
			System.out.println(urc);
			mttr_rg = Count.get(i).getText();
			System.out.println(mttr_rg);
			mttr_cfd= Count.get(i).getText();
			System.out.println(mttr_cfd);
			mttr_urc= Count.get(i).getText();
			System.out.println(mttr_urc);
			
			break;
			
			scoreList.add(Month.get(i).getText());
			compareList.add(Year.get(i).getText());
			detailsList.add(Integer.parseInt(Agg.get(i).getText().replaceAll(",", "")));
			
		    }*/
		


 		Class.forName("oracle.jdbc.driver.OracleDriver");
 		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
 	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
 	    System.out.println("3");
 	   Statement smt = conn.createStatement();		
 	  String deletequery = "DELETE FROM OPSBI_360_RELEASE_METRICS1";
 	  smt.executeQuery(deletequery).close();
 	   
 	   System.out.println("4");
 	   String queryCD = DataBaseConnection.getQueryCodeFromDataBase("CQ1");	
 	   System.out.println("5");
 	 			
		
		String query = "INSERT INTO OPSBI_360_RELEASE_METRICS1 (REC_ID,QUERY_CD,COUNT_RG,COUNT_CFD,COUNT_URC,MTTR_RG,MTTR_CFG,MTTR_URC) VALUES ('"+1+"','E1','"+rg+"','"+cfd+"','"+urc+"','"+mttr_rg+"','"+mttr_cfd+"','"+mttr_urc+"')";
		System.out.println(query);
		smt.executeQuery(query).close();
 	 
 		/*for(int i=0;i< Count.size();i++){	
 			System.out.println("Here 6");			
 			String query = "INSERT INTO OPSBI_360_CFD_IFD_RI_DNAC (REC_ID,QUERY_CD,CATEGORY_DATE,CFD_INCOMING,CFD_DISPOSED,CFD_BACKLOG,CFD_AVERAGE,CFD_MTTR,IFD_AVERAGE,IFD_MTTR,IFD_BACKLOG,CFR,IFR) VALUES ('"+(i+1)+"','"+queryCD+"','"+category_IFD_List.get(i)+"','"+CFD_IncomingList.get(i)+"','"+CFD_DisposedList.get(i)+"','"+CFD_BacklogList.get(i)+"','"+CFD_AverageList.get(i)+"','"+CFD_MttrList.get(i)+"','"+IFD_AverageList.get(i)+"','"+IFD_MttrList.get(i)+"','"+IFD_BacklogList.get(i)+"','"+CFR_List.get(i)+"','"+IFR_List.get(i)+"')";
 			System.out.println("");
 			smt.executeQuery(query).close();
 		}*/
		
 	
 		System.out.println("--- ORACLE Data Table  Inserted into Table OPSBI_360_RELEASE_METRICS1---");
    		
		
		
		
		
		
		}
	public static void main(String args[]) throws ClassNotFoundException, InterruptedException, SQLException, IOException, AWTException {
		Release_metrics rm= new Release_metrics();
		rm.set_cqa_DNA();
	}

	
}
