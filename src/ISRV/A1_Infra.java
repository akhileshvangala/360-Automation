package ISRV;

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

public class A1_Infra {
	Properties prop = new Properties();
	public WebDriver driver;
	//A1
	ArrayList<String> MonthList = new ArrayList<String>();
	ArrayList<String> YearList = new ArrayList<String>();
	ArrayList<Integer> AggList = new ArrayList<Integer>();
	
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
		
		driver.get("https://gtcbi.cisco.com/#/views/iSRV/A_1AggregateSRVolume?:iid=1&Int%20Be=Wireless&Int%20Sub%20Be=Ent.%20-%20Wireless");
		Thread.sleep(5000);
		//Test case
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='data visualization']")));
		System.out.println("1");
		driver.findElement(By.xpath("//*[@name='FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk16018648559655363980_16656844614826462805_(All)']")).click();	

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
		driver.findElement(By.xpath("//*[@id='dijit_form_Button_12']//*[@class='dijitReset dijitInline wcIconSearch']")).click();
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_FilteringSearchWidget_2']//*[@title='Search (Enter)']")).sendKeys("Spa");
		
		
		
		Thread.sleep(2000);
		driver.findElement(By.name("SI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk16018648559655363980_16656844614826462805_673")).click();
		Thread.sleep(3000);  
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_FilteringSearchWidget_2']//*[@title='Search (Enter)']")).clear();
		driver.findElement(By.xpath("//*[@id='tableau_base_widget_FilteringSearchWidget_2']//*[@title='Search (Enter)']")).sendKeys("CISE");
		Thread.sleep(2000);
		driver.findElement(By.name("SI_federated.149la7x0jupmum1fpqfe51s9do3m,none:product_family:nk16018648559655363980_16656844614826462805_287")).click();
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

}
