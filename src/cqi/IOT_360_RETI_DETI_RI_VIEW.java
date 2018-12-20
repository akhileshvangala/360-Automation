package cqi;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import clip.DataBaseConnection;

public class IOT_360_RETI_DETI_RI_VIEW {
	WebDriver driver;
	JavascriptExecutor js;
	File myFile;
	//Workbook wb = null;
	Properties prop = new Properties();
	
	ArrayList<String> category_IFD_List = new ArrayList<String>();
	ArrayList<String> CFR_List = new ArrayList<String>();
	
	 
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
		driver.get("https://wwwin-cqi.cisco.com/cqi/widgetReport.htm?widgetId=WDGT-srvattip-3&primary=N&hierarchy=org&viewId=422&intervalType=week");
Thread.sleep(15000);
 		driver.findElement(By.xpath("//*[@class='col-sm-5 col-md-5 col-lg-5 topInfoOptions padRight0']//*[@ng-click='$select.toggle($event)']")).click();
 		Thread.sleep(5000);
 		WebElement warRoom = driver.findElement(By.xpath("//*[@ng-click='onQuerySelect(item)' and contains(text(), 'WarRoomView')]"));
 		System.out.println(warRoom.getText());
 		warRoom.click();
 		
 		/*//List<WebElement> element= driver.findElements(By.xpath("/*[@class='ui-select-choices ui-select-choices-content ui-select-dropdown dropdown-menu']/li/div/span/div"));
 		//System.out.println(element.size());
 		for(int i=0;i<=element.size();i++) {
 			System.out.println(element.get(i).getText());
 		}*/
 		driver.findElement(By.xpath("//*[@class='reviewDirTabs']/div[2]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div/div/a")).click();
 		Thread.sleep(2000);
 		
 		js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)", "");
		 Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		 js1.executeScript("window.scrollBy(500,0)", "");
		 Thread.sleep(3000);
 		WebElement e1 = driver.findElement(By.xpath("//html/body/ul[@id='hoverdiv'][38]/li/a[@title='Trend']"));
 		e1.click();
       Thread.sleep(5000);
 		 js = (JavascriptExecutor) driver;
 		 js.executeScript("window.scrollBy(0,250)", "");
 		driver.findElement(By.xpath("//*[@class='highcharts-button-symbol']")).click();
 		Thread.sleep(2000);
 		driver.findElement(By.xpath("//*[contains(text(), 'Download XLS')]")).click();
 		Thread.sleep(4000);
 		


 		//Open downloaded file
 		
 		//public void openAndCloseSummaryReportExcel() throws AWTException {

 			 
            if (Desktop.isDesktopSupported()) {

                   try {

                          File myFile1 = new File("C:/Users/" + System.getProperty("user.name") + "/Downloads/eng-iot-all-_-regression-incoming.xls");

                         Desktop.getDesktop().open(myFile1);

                   } catch (IOException ex) {

                         // no application registered for PDFs

                   }

            }
            System.out.println("2");
            Thread.sleep(2000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("3");
            Thread.sleep(8000);

            //robot.keyPress(KeyEvent.VK_F4);  
		robot.keyPress(KeyEvent.VK_F12);
        robot.keyRelease(KeyEvent.VK_F12);
        Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_F);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
       
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        
       
        int count =9;
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
        	
        //CLOSING EXCEL FILE
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
       
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_F4);
        
     
         myFile = new File("C:\\Users\\akvangal\\AppData\\Roaming\\Microsoft\\AddIns\\ifd.xls");
      
    	       
         	FileInputStream fis = new FileInputStream(myFile);
     		//XSSFWorkbook wb= new XSSFWorkbook(fis);
             HSSFWorkbook wb= new HSSFWorkbook(fis);
         	
         
 		HSSFSheet sheet1 = wb.getSheetAt(0);
 		int rowCount = sheet1.getLastRowNum();
 		
 		System.out.println("Total row is  "+rowCount);
 		
 		for(int i=1; i<=rowCount; i++) {
 			
 			//String category= sheet1.getRow(i).getCell(0).getStringCellValue();
 			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
 	    	   Date data1 = sheet1.getRow(i).getCell(0).getDateCellValue();
 	         String category_IFD = df.format(data1);
 	          
 	    	   
 	          System.out.println("Value of the Excel Cell is - "+ category_IFD);
 	           
 	         
 	          category_IFD_List.add(category_IFD);
 			
 	          String CFR = sheet1.getRow(i).getCell(1).toString();
 			CFR_List.add(CFR);
 			
 			
 			
 		
 			
 	        // print on console
 		//System.out.println("Data from Excel is >>> "+data);
 			System.out.println(category_IFD);
 			System.out.println(CFR);
 			
 		
 		}
 		Thread.sleep(4000);
 		
 		Class.forName("oracle.jdbc.driver.OracleDriver");
 		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
 	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
 	    System.out.println("3");
 	   Statement smt = conn.createStatement();		
 	  String deletequery = "DELETE FROM OPSBI_360_RETI_RI_IOT";
 	  smt.executeQuery(deletequery).close();
 	   
 	   System.out.println("4");
 	   String queryCD = DataBaseConnection.getQueryCodeFromDataBase("CQ1");	
 	   System.out.println("5");
 	 
 		for(int i=0;i< category_IFD_List.size();i++){	
 			System.out.println("Here 6");			
 			String query = "INSERT INTO OPSBI_360_RETI_RI_IOT (REC_ID,QUERY_CD,CATEGORY_DATE,CFR) VALUES ('"+(i+1)+"','"+queryCD+"','"+category_IFD_List.get(i)+"','"+CFR_List.get(i)+"')";
 			System.out.println("");
 			smt.executeQuery(query).close();
 		}
		
 	
 		System.out.println("--- ORACLE Data Table  Inserted into Table RI IOT---");
    		
    		  
 		
 		Thread.sleep(3000);
		
		//driver.quit();
	}

	public static void main(String args[]) throws Exception, InterruptedException, SQLException, IOException {
		IOT_360_RETI_DETI_RI_VIEW dna1= new IOT_360_RETI_DETI_RI_VIEW(); 
		dna1.ifd();
		
	}

}
