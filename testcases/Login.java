package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import wdMethods.SeMethods;

public class Login extends SeMethods {

	@Test(invocationCount=3, threadPoolSize=2)
	public void login() throws InterruptedException {
		//Replaced by startApp
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps");

		//startApp("chrome", "http://leaftaps.com/opentaps");
		
		//Replaced by type and locateElement
		driver.findElementById("username").sendKeys("DemoSalesManager");
		//WebElement userNameEle = locateElement("id", "username");
		//type(userNameEle, "DemoSalesManager");
		
		driver.findElementById("password").sendKeys("crmsfa");
		//type(locateElement("id","password"), "crmsfa");

		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		//click(locateElement("class", "decorativeSubmit"));
		//verifyPartialText(locateElement("xpath","//h2[contains(text(),'Welcome')]"), "Demo Sales Manager");
		Thread.sleep(3000);
		//closeBrowser();
		driver.close();
		
	}

}









