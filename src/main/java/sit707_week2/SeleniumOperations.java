package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver","D:\\My Softwares\\Chrome\\chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement fName = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + fName);
		fName.sendKeys("sachin");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		WebElement lName = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + lName);
		lName.sendKeys("jayakody");
		
		WebElement pNumber = driver.findElement(By.id("phoneNumber"));
		System.out.println("Found element: " + pNumber);
		pNumber.sendKeys("0450003269");
		
		WebElement email = driver.findElement(By.id("email"));
		System.out.println("Found element: " + email);
		email.sendKeys("sachin@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		System.out.println("Found element: " + password);
		password.sendKeys("Joes@123456");
		
		WebElement cPassword = driver.findElement(By.id("confirmPassword"));
		System.out.println("Found element: " + cPassword);
		cPassword.sendKeys("Joes@123456");
		
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		WebElement button = driver.findElement(By.id("account-action-btn"));
		button.click();
		
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    try {
		        FileUtils.copyFile(scrFile, new File("D:\\My Studies\\1. Master\\Year - 02\\Semester - 01\\SIT707 - Software Quality and Testing\\02. Ontrack"));
		        System.out.println("Screenshot saved successfully!");
		    } catch (IOException e) {
		        System.out.println("Error saving screenshot: " + e.getMessage());
		    }
		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
