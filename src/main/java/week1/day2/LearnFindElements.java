package week1.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFindElements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//ClassName objectName = new ClassName();
		ChromeDriver driver = new ChromeDriver();
		
		//To maximize browser
		driver.manage().window().maximize();
		
		//implicitly Wait - to wait if the webelement is not found in the page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Open URL
		driver.get("http://www.crystalcruises.com/cruises/calendar");
		
		List<WebElement> allQuotes = driver.findElementsByXPath("//a[text()='Request A Quote']");
		
		int sizeOfList = allQuotes.size();
		System.out.println(sizeOfList);
		WebElement lastElement = allQuotes.get(sizeOfList-1);
		lastElement.click();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
