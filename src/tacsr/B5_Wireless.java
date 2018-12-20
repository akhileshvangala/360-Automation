package tacsr;

import java.awt.AWTException;
import java.awt.Desktop;
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
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import clip.DataBaseConnection;

public class B5_Wireless {
	File myFile;
	Properties prop = new Properties();
	public WebDriver driver;
	
	//A8
	ArrayList<String> SR_intial_list = new ArrayList<String>();
	ArrayList<String> SR_sw_list = new ArrayList<String>();
	
	ArrayList<String> Total_SR_count_list = new ArrayList<String>();
	ArrayList<String> SR_count_list = new ArrayList<String>();
	
	
	
	private void set_tAC_SR_A1() throws InterruptedException, SQLException, ClassNotFoundException, IOException, AWTException{
		Robot robot = new Robot();
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
		driver.get("https://gtcbi.cisco.com/#/views/iSRV/B_5SRCountbySWRelease?:iid=1&Int%20Be=Wireless&Int%20Sub%20Be=Ent.%20-%20Wireless");
		Thread.sleep(5000);
		//Test case
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='data visualization']")));
		System.out.println("1");
			//A1 Int BE apply
		Thread.sleep(2000);
		//A1 Int BE apply
	driver.findElement(By.xpath("//*[@id='dijit_form_DropDownButton_0_label']")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='dijit_TooltipDialog_0']/div/div/div/div[3]/div/input")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='dijit_form_DropDownButton_0_label']")).click();
		Thread.sleep(3000);

		//Int BE
		//Window.scrollBy(0, 100);
		driver.findElement(By.xpath("//*[@name='FI_federated.149la7x0jupmum1fpqfe51s9do3m,none:int_be:nk16018648559655363980_16656844614826462805_(All)']")).click();	
		driver.findElement(By.xpath("//*[@id='dijit_form_Button_4']//*[@class='dijitReset dijitInline wcIconSearch']")).click();
		driver.findElement(By.xpath("//*[@title='Search (Enter)']")).sendKeys("Wireless");
		
		
		
		Thread.sleep(2000);
		driver.findElement(By.name("SI_federated.149la7x0jupmum1fpqfe51s9do3m,none:int_be:nk16018648559655363980_16656844614826462805_13")).click();
		Thread.sleep(2000);         
		
		System.out.println("2");
		//driver.findElement(By.xpath(".//*[@id='tableau_base_widget_LegacyCategoricalQuickFilter_1']/div/div[3]/button[2]")).click();   
//click on apply
	    driver.findElement(By.xpath("//*[@class='CFApplyButtonContainer']/button[2]/span[2]")).click(); 
	    
	    //Done here
	    
	    
	    
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@class='tvimagesContainer']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='tabToolbarButton tab-widget download']")).click();
		//Thread.sleep(4000);
		//driver.findElement(By.xpath("//*[@data-tb-test-id='DownloadData-Button']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@data-tb-test-id='DownloadCrosstab-Button']")).click();
		//driver.findElement(By.xpath("html/body/div[5]/div/div/div[2]/div/div/div[2]/div/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@data-test-id='DownloadLink']")).click();
		System.out.println("3");
		driver.switchTo().defaultContent();
		Thread.sleep(6000);
		/*for(String childWindow:driver.getWindowHandles()){
			driver.switchTo().window(childWindow).manage().window().maximize();;
			}
		*/
		  if (Desktop.isDesktopSupported()) {

              try {

                     File myFile1 = new File("C:/Users/" + System.getProperty("user.name") + "/Downloads/B5_SR_Count_by_SW_Release__crosstab"
                     		+ ".csv");

                    Desktop.getDesktop().open(myFile1);

              } catch (IOException ex) {

                    // no application registered for PDFs

              }

       }
       System.out.println("2");
       Thread.sleep(2000);
       
       //robot.keyPress(KeyEvent.VK_F4);  
	robot.keyPress(KeyEvent.VK_F12);
   robot.keyRelease(KeyEvent.VK_F12);
   Thread.sleep(3000);
	/*robot.keyPress(KeyEvent.VK_TAB);
   robot.keyRelease(KeyEvent.VK_TAB);
   Thread.sleep(3000);
   robot.keyPress(KeyEvent.VK_ENTER);
   robot.keyRelease(KeyEvent.VK_ENTER);
   Thread.sleep(4000);*/
   robot.keyPress(KeyEvent.VK_T);
   robot.keyRelease(KeyEvent.VK_T);
   robot.keyPress(KeyEvent.VK_E);
   robot.keyRelease(KeyEvent.VK_E);
   robot.keyPress(KeyEvent.VK_S);
   robot.keyRelease(KeyEvent.VK_S);
   robot.keyPress(KeyEvent.VK_T);
   robot.keyRelease(KeyEvent.VK_T);
   robot.keyPress(KeyEvent.VK_TAB);
   robot.keyRelease(KeyEvent.VK_TAB);
   
  
   int count =6;
   for(int i=0; i<count; i++) {
   	robot.keyPress(KeyEvent.VK_E);
       robot.keyRelease(KeyEvent.VK_E);
       Thread.sleep(100);
   	
   }
   robot.keyPress(KeyEvent.VK_ENTER);
   robot.keyRelease(KeyEvent.VK_ENTER);
   Thread.sleep(4000);
   robot.keyPress(KeyEvent.VK_TAB);
   robot.keyRelease(KeyEvent.VK_TAB);
   Thread.sleep(1000);
   robot.keyPress(KeyEvent.VK_ENTER);
   robot.keyRelease(KeyEvent.VK_ENTER);
   Thread.sleep(6000);
   	
         
    myFile = new File("C:\\Users\\akvangal\\AppData\\Roaming\\Microsoft\\AddIns\\test.xls");
  
       	FileInputStream fis = new FileInputStream(myFile);
   		//XSSFWorkbook wb= new XSSFWorkbook(fis);
           HSSFWorkbook wb= new HSSFWorkbook(fis);
       	
       
		HSSFSheet sheet1 = wb.getSheetAt(0);
		int rowCount = sheet1.getLastRowNum();
		System.out.println("Total row is  "+rowCount);
		for(int i=1; i<=rowCount; i++) {
			System.out.println("raj here");
			
			
			//System.out.println(sheet1.getRow(i).getCell(0).getNumericCellValue());
			HSSFCell data1= sheet1.getRow(i).getCell(0);
 			if(data1==null) {
 				SR_sw_list.add("0");
 			}
 			else {
 				String SR_sw = sheet1.getRow(i).getCell(0).toString();
	 			SR_sw_list.add(SR_sw);
	 			System.out.println(SR_sw);
 			}
 			System.out.println("test");
			
			
			HSSFCell data= sheet1.getRow(i).getCell(1);
	 			if(data == null){
	 				System.out.println("raj here");
	 				SR_intial_list.add("0");
					 		
				 	}
				 else {
					 String SR_intial = sheet1.getRow(i).getCell(1).toString();
					 SR_intial_list.add(SR_intial);
					 System.out.println(SR_intial);
				 }
	 			
	 			
	 			String Total_SR_count = sheet1.getRow(i).getCell(2).toString();
	 			Total_SR_count_list.add(Total_SR_count);
	 			System.out.println(Total_SR_count);
	 			String SR_count = sheet1.getRow(i).getCell(3).toString();
	 			SR_count_list.add(SR_count);
	 			System.out.println(SR_count);
	 			
			
	        // print on console
		//System.out.println("Data from Excel is >>> "+data);
			/*System.out.println(SR_intial_list);
			System.out.println(SR_sw);
			System.out.println(Total_SR_count);
			System.out.println(SR_count);*/
		}
		Thread.sleep(4000);

		System.out.println("4");
		Thread.sleep(5000);
		//driver.quit();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
	    
	   Statement smt = conn.createStatement();		
	   String deletequery = "DELETE FROM OPSBI_360_ISRV_B5_WIRELESS";
	   ResultSet delrs=  smt.executeQuery(deletequery);
	   
	   
	   String A1_queryCD = DataBaseConnection.getQueryCodeFromDataBase("TAC_SR_A1");	
	 

		for(int i=0;i<SR_intial_list.size();i++){	
		String query = "INSERT INTO OPSBI_360_ISRV_B5_WIRELESS (REC_ID,QUERY_CD,SR_INITITAL_SERV,SR_SW_VERSION,AGG_PERCENTAGE,AGG_COUNT) VALUES ('"+(i+1)+"','A8','"+SR_intial_list.get(i)+"','"+SR_sw_list.get(i)+"','"+Total_SR_count_list.get(i)+"','"+SR_count_list.get(i)+"')";			
		System.out.println(query);
		smt.executeQuery(query).close();
		}
		
	
		System.out.println("--- Data Inserted into OPSBI_360_ISRV_B5_WIRELESS---");

	}
	public static void main(String args[]) throws ClassNotFoundException, InterruptedException, SQLException, IOException, AWTException {
		B5_Wireless e= new B5_Wireless();
		e.set_tAC_SR_A1();
	}

}
