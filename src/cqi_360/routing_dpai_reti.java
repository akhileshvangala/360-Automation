package cqi_360;

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

public class routing_dpai_reti {
	WebDriver driver;
	JavascriptExecutor js;
	File myFile;
	//Workbook wb = null;
	Properties prop = new Properties();
	
	
	ArrayList<String> categoryList = new ArrayList<String>();
	ArrayList<String> CR_List = new ArrayList<String>();
	ArrayList<String> SA_List = new ArrayList<String>();
	ArrayList<String> UT_List = new ArrayList<String>();
	ArrayList<String> RETI_List = new ArrayList<String>();
	ArrayList<String> DEV_List = new ArrayList<String>();
	ArrayList<String> Test_List = new ArrayList<String>();
	


	
		 
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
		driver.get("https://wwwin-cqi.cisco.com/cqi/widgetReport.htm?widgetId=WDGT-srvattip-7&primary=N&hierarchy=org&viewId=422&intervalType=week");
Thread.sleep(10000);
driver.findElement(By.xpath("//*[@active='activeForm']/ul/li[2]/a")).click();
Thread.sleep(5000);
 		driver.findElement(By.xpath("//*[@class='col-sm-5 col-md-5 col-lg-5 topInfoOptions padRight0']//*[@ng-click='$select.toggle($event)']")).click();
 		Thread.sleep(2000);
 		WebElement warRoom = driver.findElement(By.xpath("//*[@ng-click='onQuerySelect(item)' and contains(text(), 'WarRoomView')]"));
 		System.out.println(warRoom.getText());
 		warRoom.click();
 		
 		//List<WebElement> element= driver.findElements(By.xpath("/*[@class='ui-select-choices ui-select-choices-content ui-select-dropdown dropdown-menu']/li/div/span/div"));
 		//System.out.println(element.size());
 		js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)", "");
		 Thread.sleep(2000);
 		
 		
 		
 		driver.findElement(By.xpath("//*[@class='reviewDirTabs']/div[2]/div/div[2]/div[2]/div/div[3]/div/div[11]/div/div/div/a")).click();
		 
 		WebElement e1 = driver.findElement(By.xpath("//html/body/ul[@id='hoverdiv'][42]/li/a[@title='Trend']"));
 		e1.click();
       Thread.sleep(5000);
 		 js = (JavascriptExecutor) driver;
 		 js.executeScript("window.scrollBy(0,500)", "");
 		driver.findElement(By.xpath("//*[@class='highcharts-button-symbol']")).click();
 		Thread.sleep(2000);
 		driver.findElement(By.xpath("//*[contains(text(), 'Download XLS')]")).click();
 		Thread.sleep(4000);
 		

 		//Open downloaded file
 			 
            if (Desktop.isDesktopSupported()) {

                   try {

                          File myFile1 = new File("C:/Users/" + System.getProperty("user.name") + "/Downloads/eng-routing-all-_-view-chart-2.xls");

                         Desktop.getDesktop().open(myFile1);

                   } catch (IOException ex) {

                         // no application registered for PDFs

                   }

            }
            System.out.println("2");
            Thread.sleep(2000);
            
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
        	
              
         myFile = new File("C:\\Users\\akvangal\\AppData\\Roaming\\Microsoft\\AddIns\\test.xls");
       
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
    	         String category = df.format(data1);
    	          
    	    	   
    	          System.out.println("Value of the Excel Cell is - "+ category);
    	           
    	          categoryList.add(category);
  	 			String CR = sheet1.getRow(i).getCell(1).toString();
  	 			CR_List.add(CR);
  	 			String SA = sheet1.getRow(i).getCell(2).toString();
  	 			SA_List.add(SA);
  	 			String UT = sheet1.getRow(i).getCell(3).toString();
  	 			UT_List.add(UT);
  	 			String RETI = sheet1.getRow(i).getCell(4).toString();
  	 			RETI_List.add(RETI);
  	 			String DEV = sheet1.getRow(i).getCell(5).toString();
  	 			DEV_List.add(DEV);
  	 			String TEST = sheet1.getRow(i).getCell(6).toString();
  	 			Test_List.add(TEST);
    			
    	        // print on console
    		//System.out.println("Data from Excel is >>> "+data);
    			System.out.println(category);
    			System.out.println(CR_List);
    			System.out.println(SA_List);
    			System.out.println(UT_List);
    		}
    		Thread.sleep(4000);


    		
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		String connectionURL = "jdbc:oracle:thin:@"+ "dbs-dev-vm-2002.cisco.com" + ":"+ "1527" + ":"+ "NTGDEV";
    	    Connection conn = DriverManager.getConnection(connectionURL, "IOPS_APPS", "iOPS#123");
    	    System.out.println("3");
    	   Statement smt = conn.createStatement();		
    	   String deletequery = "DELETE FROM OPSBI_360_RETI_DPAI_ROUTING";
    	   smt.executeQuery(deletequery).close();
    	   
    	   System.out.println("4");
    	   String queryCD = DataBaseConnection.getQueryCodeFromDataBase("CQ1");	
    	   System.out.println("5");
    	 
    	   for(int i=0;i< categoryList.size()*2;i++){	
   			int j = i;
   			String qry_code = "D2";
   			if (j >= categoryList.size()) {
   				j-= categoryList.size();
   				qry_code = "D3";
   			}    			System.out.println("Here 6");
     			String query = "INSERT INTO OPSBI_360_RETI_DPAI_ROUTING (REC_ID,QUERY_CD,CATEGORY_DATE,CR,SA,UT,RETI_ADOPTION,TOTAL_DEV_ESCAPE,TOTAL_TEST_ESCAPE) VALUES ('"+(i+1)+"','"+qry_code+"','"+categoryList.get(j)+"','"+CR_List.get(j)+"','"+SA_List.get(j)+"','"+UT_List.get(j)+"','"+RETI_List.get(j)+"','"+DEV_List.get(j)+"','"+Test_List.get(j)+"')";
    			System.out.println("");
    			smt.executeQuery(query).close();
    		}
    		
    	
    		System.out.println("--- ORACLE Data Table  Inserted into Table OPSBI_360_RETI_DPAI_ROUTING---");
	}
    		
    				
		
		//driver.quit();
		public static void main(String args[]) throws Exception, InterruptedException, SQLException, IOException {
			routing_dpai_reti dna1= new routing_dpai_reti(); 
		dna1.set_cqa_DNA();
		
	}



}
