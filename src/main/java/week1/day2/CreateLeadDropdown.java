package week1.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLeadDropdown {

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
		
		driver.findElementByLinkText("CRM/SFA").click();;
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		
		//Find the drop-down web element
		WebElement industryElement = driver.findElementById("createLeadForm_industryEnumId");
		
		//Select Class to be used only if drop-down is a select tag
		Select industrySel = new Select(industryElement);
		
		//To select an option using value
		industrySel.selectByValue("IND_GEN_SERVICES");
		
		//To select an option using index
		//industrySel.selectByIndex(0);
		
		//To print all the contents of the dropdown 
		List<WebElement> allOption = industrySel.getOptions();
		System.out.println(allOption.size());
		
		//syntax - foreach loop for(type oneOption : AllOptions)
		for(WebElement oneOption : allOption) {
			System.out.println(oneOption.getText());
		}
		
		//Close Current Browser
		//driver.close();
		
		//Close all browser opened by driver
		//driver.quit();
		

	}

}
