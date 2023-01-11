package Groupsix;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Php {
	ExtentSparkReporter report;
	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	
	 @BeforeTest
	  public void setup() {
		 String path="C:\\Users\\avusodapu.ashritha\\Desktop\\Mock Assessment\\PhpTravels\\test-output\\reports.html";
		 report=new ExtentSparkReporter(path);		 
		 extent=new ExtentReports();
		 extent.attachReporter(report);
		 test=extent.createTest("Php Travels title validation");
	  }
  @Test
  public void travels() throws InterruptedException, IOException {
	  test.info("Chrome Browser Opening");
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\avusodapu.ashritha\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  test.pass("Successfully Chrome Driver opened");
		    driver.get("https://phptravels.net");		    
		    test.pass("Php Travels title validated");
		    String actualtitle="PHPTRAVELS | Travel Technology Partner - PHPTRAVELS";
		    String title = driver.getTitle();
		    Assert.assertEquals(title, actualtitle);	   
  
	  // Create a new instance of the ChromeDriver
	   System.out.println("Title:"+driver.getTitle());
	  test.info("Open the login Page");
	   driver.navigate().to("https://www.phptravels.net/login");
 	   test.pass("Login page opened successfully");
	System.out.println("Module:"+driver.getTitle());
	//Login using Apachepoi
	FileInputStream file=new FileInputStream("C:\\Users\\avusodapu.ashritha\\Desktop\\Login Info.xlsx");
	XSSFWorkbook book=new XSSFWorkbook(file);
	XSSFSheet sheet=book.getSheet("Sheet1");
	int noOfRows=sheet.getLastRowNum();
	System.out.println("Number of rows:"+noOfRows);
	for(int row=1; row<=noOfRows; row++) {
		XSSFRow currentRow=sheet.getRow(row);
		
		String email=currentRow.getCell(0).getStringCellValue();
		String password=currentRow.getCell(0).getStringCellValue();
		
	// Find email and password input fields and enter login information
	 driver.findElement(By.name("email")).isDisplayed();
	 driver.findElement(By.name("email")).sendKeys(email);
	 driver.findElement(By.name("password")).isDisplayed();
	 driver.findElement(By.name("password")).sendKeys(password);

	// Find login button and click it
	driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/form/div[3]/button")).click();

	Thread.sleep(3000);
	   test.info("Open the Hotels page");
		driver.navigate().to("https://phptravels.net/hotels");
		test.pass("Hotels page opened successfully");
		System.out.println("Module:"+driver.getTitle());
	// Set city name
	 driver.findElement(By.id("select2-hotels_city-container")).isDisplayed();	 
	// Set check-in date
	 driver.findElement(By.id("checkin")).click();
	 driver.findElement(By.id("checkin")).sendKeys("29/12/2022");
	// Set check-out date
	 driver.findElement(By.id("checkout")).click();
	 driver.findElement(By.id("checkout")).sendKeys("31/12/2022");

	// Click search button
	driver.findElement(By.id("submit")).click();

//Navigate to flights page
	test.info("Open flights page");
	driver.navigate().to("https://phptravels.net/flights");
	test.pass("Flights page opened successfully");
	System.out.println("Module:"+driver.getTitle());
	
	 driver.findElement(By.id("autocomplete")).isDisplayed();
	 driver.findElement(By.id("autocomplete")).sendKeys("Penn Station");
	 
	 driver.findElement(By.id("autocomplete2")).isDisplayed();
	 driver.findElement(By.id("autocomplete2")).sendKeys("San Francisco Intl");
	
	 driver.findElement(By.id("departure")).isDisplayed();
	 driver.findElement(By.id("departure")).sendKeys("01/12/2022");
	
	 driver.findElement(By.id("flights-search")).click();

//Navigate to flights page
     test.info("Open tours page");
	driver.navigate().to("https://phptravels.net/tours");
	test.pass("Tours page opened successfully");
	System.out.println("Module:"+driver.getTitle());
	
	 driver.findElement(By.id("select2-tours_city-container")).isDisplayed();
	 //driver.findElement(By.id("autocomplete")).sendKeys("Penn Station");
	
	 driver.findElement(By.id("date")).isDisplayed();
	 driver.findElement(By.id("date")).sendKeys("01/12/2022");
	 
	 driver.findElement(By.xpath("//*[@id=\"tours-search\"]/div/div/div[3]/div/div/div/a")).isDisplayed();
	
	 driver.findElement(By.id("submit")).click();
	
	 driver.navigate().to("https://phptravels.net/offers");

//Navigate to flights page
    test.info("open Visa Page");
	driver.navigate().to("https://phptravels.net/visa");
	test.pass("Visa page opened successfully");
	System.out.println("Module:"+driver.getTitle());
	 
	 driver.findElement(By.id("select2-from_country-container")).isDisplayed();
	// driver.findElement(By.id("select2-from_country-container")).sendKeys("India");
	
	 driver.findElement(By.id("select2-to_country-container")).isDisplayed();
	 //driver.findElement(By.id("select2-to_country-container")).sendKeys("Australia");
	
	 driver.findElement(By.id("date")).isDisplayed();
	// driver.findElement(By.id("date")).sendKeys("31/12/2022");
	
	 driver.findElement(By.id("submit")).click();
	
//Navigate to Offers page
	 test.info("Open Offers page");
	driver.navigate().to("https://phptravels.net/offers");
	test.pass("Offers page opened successfully");
	System.out.println("Module:"+driver.getTitle());
	driver.close();
	driver.quit();
	file.close();
  }
  }
	@AfterTest
	public void closetest()
	{
	    extent.flush();
	}
	}