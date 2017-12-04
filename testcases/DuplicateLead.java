package testcases;


import org.testng.annotations.Test;
import wdMethods.ProjectMethods;

public class DuplicateLead extends ProjectMethods {


	@Test(groups="sanity", dependsOnGroups="smoke")
	public void duplicateLead() throws InterruptedException {

		/*startApp("chrome", "http://leaftaps.com/opentaps");		
		type(locateElement("id", "username"), "DemoSalesManager");
		type(locateElement("id","password"), "crmsfa");
		click(locateElement("class", "decorativeSubmit"));
		click(locateElement("link", "CRM/SFA"));
		click(locateElement("link", "Leads"));*/
		
//		login();
		click(locateElement("link", "Find Leads"));
		click(locateElement("xpath", "//span[contains(text(),'Email')]"));
		type(locateElement("name","emailAddress"), "aar@gmail.com");
		click(locateElement("xpath", "//span[contains(text(),'Email')]"));
		click(locateElement("xpath", "//button[contains(text(),'Find Leads')]"));
		Thread.sleep(3000);
		String fName = getText(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a"));
		click(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		click(locateElement("link", "Duplicate Lead"));
		verifyTitle("Duplicate Lead | opentaps CRM");
		click(locateElement("xpath", "//input[@value='Create Lead']"));
		verifyExactText(locateElement("id", "viewLead_firstName_sp"), fName);
		//Thread.sleep(5000);
		//closeBrowser();
		//close();

	}
}
