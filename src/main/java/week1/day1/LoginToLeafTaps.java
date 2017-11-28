package week1.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToLeafTaps {

	public static void main(String[] args) {
		
		//Set the web driver - chromedriver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//ClassName objectName = new ClassName();
		ChromeDriver driver = new ChromeDriver();
		
		//To maximize browser
		driver.manage().window().maximize();
		
		//implicitly Wait - to wait if the webelement is not found in the page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Open URL
		driver.get("http://leaftaps.com/opentaps");
		
		
		//Enter Username
		driver.findElementById("username").sendKeys("Demosalesmanager");
		
		//Enter Password
		driver.findElementById("password").sendKeys("crmsfa");
		
		//Click Login
		driver.findElementByClassName("decorativeSubmit").click();
		
		
		//Close Current Browser
		driver.close();
		
		//Close all browser opened by driver
		//driver.quit();
		

	}

}
