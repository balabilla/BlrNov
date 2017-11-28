package week1.day2;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotSelenium {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//To maximize browser
		driver.manage().window().maximize();
		//implicitly Wait - to wait if the webElement is not found in the page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Open URL
		driver.get("http://www.crystalcruises.com/cruises/calendar");
		
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/CrystalCruises.jpg");
		FileUtils.copyFile(srcFile, destFile);

	
	}

}


/*Maven Dependency - to be added if not present.
<dependency>
	<groupId>org.apache.commons</groupId>
	<artifactId>commons-io</artifactId>
	<version>1.3.2</version>
</dependency>*/