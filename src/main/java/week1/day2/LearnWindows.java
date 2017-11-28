package week1.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindows {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//ClassName objectName = new ClassName();
		ChromeDriver driver = new ChromeDriver();
		
		//To maximize browser
		driver.manage().window().maximize();
		
		//implicitly Wait - to wait if the webelement is not found in the page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Open URL
		driver.get("http://www.crystalcruises.com/cruises/calendar");
		
		List<WebElement> allBookNow = driver.findElementsByXPath("//a[text()='Book now']");
		
		int sizeOfList = allBookNow.size();
		System.out.println(sizeOfList);
		WebElement lastElement = allBookNow.get(sizeOfList-1);
		String parWindowBefore = driver.getWindowHandle();
		System.out.println(parWindowBefore);
		lastElement.click();
		
		String parWindowAfter = driver.getWindowHandle();
		System.out.println(parWindowAfter);		
		
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("Set-->"+allWindows);
		System.out.println("Size -- > "+allWindows.size());
		List<String> allWindowsList = new ArrayList<String>();
		allWindowsList.addAll(allWindows);
		
		System.out.println("List-->"+allWindowsList);
		
		String secWindow = allWindowsList.get(1);
		
		driver.switchTo().window(secWindow);
		
		System.out.println("Title of 2nd Window --> "+driver.getTitle());
		System.out.println("URL of 2nd Window -->" + driver.getCurrentUrl());
		Thread.sleep(3000);
		//close 2nd window
		driver.close();
		
		//This causes NoSuchWindowException
		/*System.out.println("Title of 2nd Window --> "+driver.getTitle());
		System.out.println("URL of 2nd Window -->" + driver.getCurrentUrl());*/
		
		driver.switchTo().window(allWindowsList.get(0));
		System.out.println("Title of 1st Window --> "+driver.getTitle());
		System.out.println("URL of 1st Window -->" + driver.getCurrentUrl());
		
		
		
		
		
		
		
		
	}

}
