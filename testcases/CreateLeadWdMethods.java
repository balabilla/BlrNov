package testcases;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import wdMethods.SeMethods;

public class CreateLeadWdMethods extends SeMethods {

	@Test
	public void login() {
		//Replaced by startApp
		/*System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps");*/

		startApp("chrome", "http://leaftaps.com/opentaps");
		
		//Replaced by type and locateElement
		/*driver.findElementById("username").sendKeys("DemoSalesManager");*/
		WebElement userNameEle = locateElement("id", "username");
		type(userNameEle, "DemoSalesManager");
		
		/*driver.findElementById("password").sendKeys("crmsfa");*/
		type(locateElement("id","password"), "crmsfa");

		/*driver.findElementByClassName("decorativeSubmit").click();*/
		click(locateElement("class", "decorativeSubmit"));
		
		
	}

}









