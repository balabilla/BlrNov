package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeMethods implements WdMethods {

	RemoteWebDriver driver = null;  
	int i = 1;

	public void startApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(url);
			System.out.println("The Browser launched the URL successfully");
		} catch (WebDriverException e) {
			//e.printStackTrace();
			System.err.println("WebDriverException Occurred. Please validate");
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("Exception Occurred. Please validate");
		}
	}

	public void startApp(String url) {
		// TODO Auto-generated method stub

	}

	public WebElement locateElement(String locator, String locValue) {
		WebElement ele = null;
		try {
			switch (locator) {
			case "id":
				ele = driver.findElementById(locValue);
				break;
			case "class":
				ele = driver.findElementByClassName(locValue);
				break;
			case "link":
				ele = driver.findElementByLinkText(locValue);
				break;
			case "xpath":
				ele = driver.findElementByXPath(locValue);
				break;
			case "name":
				ele = driver.findElementByName(locValue);
				break;
			default:
				ele = driver.findElementById(locValue);
				break;
			}
		} catch (NoSuchElementException e) {
			//e.printStackTrace();
			System.err.println("Unable to locate the element - " + locValue);
			throw new RuntimeException();
		} catch (WebDriverException e) {
			//e.printStackTrace();
			System.err.println("WebDriverException Occured - " + locValue);
			throw new RuntimeException();
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("Exception Occured - " + locValue);
			throw new RuntimeException();
		} finally {
			takeSnap();
		}

		return ele;
	}

	public WebElement locateElement(String locValue) {
		// TODO Auto-generated method stub
		return null;
	}

	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println(data + " enetered successfully");
		} catch (WebDriverException e) {
			//e.printStackTrace();
			System.err.println("WebDriverException Occured - " + data);
			throw new RuntimeException();
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("Exception Occured - " + data);
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void click(WebElement ele) {
		try {
			ele.click();
			System.out.println(ele + " Element clicked successfully");
		} catch (StaleElementReferenceException e) {
			//e.printStackTrace();
			System.err.println("StaleElementReferenceException Occured while click of - " + ele);
			throw new RuntimeException();
		} catch (WebDriverException e) {
			//e.printStackTrace();
			System.err.println("WebDriverException Occured  while click of - " + ele);
			throw new RuntimeException();
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("Exception Occured  while click of - " + ele);
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public String getText(WebElement ele) {
		String eleText = "";
		try {
			eleText = ele.getText();
			System.out.println("Text of the webelement - " + eleText);
		} catch (StaleElementReferenceException e) {
			//e.printStackTrace();
			System.err.println("StaleElementReferenceException Occured while getText of - " + ele);
			throw new RuntimeException();
		} catch (WebDriverException e) {
			//e.printStackTrace();
			System.err.println("WebDriverException Occured while getText of - " + ele);
			throw new RuntimeException();
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("Exception Occured while getText of - " + ele);
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
		return eleText;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		// TODO Auto-generated method stub

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub

	}

	public void verifyTitle(String expectedTitle) {
		try {
			if (driver.getTitle().equals(expectedTitle)) {
				System.out.println("The title "+expectedTitle+" matches with the webpage title");
			} else {
				System.out.println("The title "+expectedTitle+" did not match with the webpage title");
			}
		} catch (NoSuchWindowException e) {
			//e.printStackTrace();
			System.err.println("NoSuchWindowException Occured while verifyTitle for - " + expectedTitle);
			throw new RuntimeException();
		} catch (WebDriverException e) {
			//e.printStackTrace();
			System.err.println("WebDriverException Occured while verifyTitle for - " + expectedTitle);
			throw new RuntimeException();
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("Exception Occured while verifyTitle for - " + expectedTitle);
			throw new RuntimeException();
		} finally {
			takeSnap();
		}

	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if (ele.getText().equals(expectedText)) {
				System.out.println("The text "+expectedText+" matches with the element text");
			} else {
				System.out.println("The text "+expectedText+" did not match with the element text");
			}
		} catch (StaleElementReferenceException e) {
			//e.printStackTrace();
			System.err.println("StaleElementReferenceException Occured while verifyExactText of - " + ele);
			throw new RuntimeException();
		} catch (WebDriverException e) {
			//e.printStackTrace();
			System.err.println("WebDriverException Occured while verifyExactText of - " + ele);
			throw new RuntimeException();
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("Exception Occured while verifyExactText of - " + ele);
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			System.out.println(ele.getText());
			if (ele.getText().contains(expectedText)) {
				System.out.println("The text "+expectedText+" matches with the element text");
			} else {
				System.out.println("The text "+expectedText+" did not match with the element text");
			}
		} catch (StaleElementReferenceException e) {
			//e.printStackTrace();
			System.err.println("StaleElementReferenceException Occured while verifyExactText of - " + ele);
			throw new RuntimeException();
		} catch (WebDriverException e) {
			//e.printStackTrace();
			System.err.println("WebDriverException Occured while verifyExactText of - " + ele);
			throw new RuntimeException();
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("Exception Occured while verifyExactText of - " + ele);
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void switchToWindow(int index) {
		// TODO Auto-generated method stub

	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void acceptAlert() {
		// TODO Auto-generated method stub

	}

	public void dismissAlert() {
		// TODO Auto-generated method stub

	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void takeSnap() {
		try {
			File srcFile = driver.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./snaps/snap"+i+".jpeg");
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("IOException while takesnap");
		} catch (WebDriverException e) {
			//e.printStackTrace();
			System.err.println("WebDriverException while takesnap");
		}
		i++;
	}

	public void closeBrowser() {
		try {
			driver.close();
			System.out.println("Browser closed successfully");
		} catch (WebDriverException e) {
			System.err.println("WebDriverException while close browser");
		}

	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("All browsers closed successfully");
		} catch (WebDriverException e) {
			System.err.println("WebDriverException while close all browsers");
		}
	}

}
