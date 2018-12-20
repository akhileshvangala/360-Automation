package clip;

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

public class Clip_SPA {
	Properties prop = new Properties();
	public WebDriver driver;
	//A1
	ArrayList<String> Engagement_IDList = new ArrayList<String>();
	ArrayList<String> causesList = new ArrayList<String>();
	ArrayList<String> Escalation_TriggerList = new ArrayList<String>();
	ArrayList<String> otherCauseCommentList = new ArrayList<String>();

	
	
	private void routing() throws InterruptedException, SQLException, ClassNotFoundException, IOException{
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
		driver.get("https://clpsvs.cloudapps.cisco.com/services/clip/main/app/myclip/engagement/309680432");
		Thread.sleep(5000);
		//Test case
		driver.findElement(By.xpath("//table[@class='table gridv2']/tfoot/tr/td/div/span[2]/a[4]")).click();
		Thread.sleep(3000);
	
	System.out.println("4");
		List<WebElement> Engagement_ID = driver.findElements(By.xpath("//table[@class='table gridv2']/tbody/tr/td[1]/a"));
		System.out.println("5");
		List<WebElement> causes = driver.findElements(By.xpath("//table[@class='table gridv2']/tbody/tr/td[2]/a"));
		List<WebElement> Escalation_Trigger = driver.findElements(By.xpath("//table[@class='table gridv2']/tbody/tr/td[3]"));
		List<WebElement> otherCauseComment = driver.findElements(By.xpath("//table[@class='table gridv2']/tbody/tr/td[4]"));
		System.out.println("6");
		System.out.println(Engagement_ID.size());
		
		for(int i=0;i<Engagement_ID.size();i++){
			System.out.println("7");
			Engagement_IDList.add(Engagement_ID.get(i).getText());
			System.out.println(Engagement_ID.get(i).getText());
			causesList.add(causes.get(i).getText());
			System.out.println(causes.get(i).getText());
			Escalation_TriggerList.add(Escalation_Trigger.get(i).getText());
			System.out.println(Escalation_Trigger.get(i).getText());
			otherCauseCommentList.add(otherCauseComment.get(i).getText());
			System.out.println(otherCauseComment.get(i).getText());
			
			
			
			//AggList.add(Integer.parseInt(Agg.get(i).getText().replaceAll(",", "")));
			System.out.println("9");
			
		    }
		Thread.sleep(5000);
		//driver.quit();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
	    
	   Statement smt = conn.createStatement();		
	   String deletequery = "DELETE FROM OPSBI_360_ESC_CLIP_SPA";
	   ResultSet delrs=  smt.executeQuery(deletequery);
	   
	   
	   String A1_queryCD = DataBaseConnection.getQueryCodeFromDataBase("TAC_SR_A1");	
	 

		for(int i=0;i<Engagement_IDList.size();i++){	
		String query = "INSERT INTO OPSBI_360_ESC_CLIP_SPA (REC_ID,QUERY_CD,ENGAGEMENT_ID,CAUSE_DESC,ESCALATION_TRIGGER,OTHER_CAUSE_COMMENT) VALUES ('"+(i+1)+"','A3','"+Engagement_IDList.get(i)+"','"+causesList.get(i)+"','"+Escalation_TriggerList.get(i)+"','"+otherCauseCommentList.get(i)+"')";			
		System.out.println(query);
		smt.executeQuery(query).close();
		}
		
	
		System.out.println("--- Data Inserted into OPSBI_360_ESC_CLIP_SPA---");

	}
	public static void main(String args[]) throws ClassNotFoundException, InterruptedException, SQLException, IOException {
		Clip_SPA e= new Clip_SPA();
		e.routing();
	}

	

}
