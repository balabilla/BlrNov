package week1.day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//ClassName objectName = new ClassName();
		ChromeDriver driver = new ChromeDriver();
		
		//Load the url
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		
		//maximize the Browser
		driver.manage().window().maximize();
		
		driver.findElementById("userRegistrationForm:checkavail").click();
		Thread.sleep(2000);
		
		//Get & print the alert text
		String txt = driver.switchTo().alert().getText();
		System.out.println(txt);

		//UnhandledAlertException
		//driver.findElementById("userRegistrationForm:userName").sendKeys("123456");
		
		Thread.sleep(2000);
		
		//Accept the alert
		driver.switchTo().alert().accept();
		
		driver.findElementById("userRegistrationForm:userName").sendKeys("123456");
		
	}
}
