package testcases;

import org.testng.annotations.Test;
import wdMethods.ProjectMethods;

public class EditLead extends ProjectMethods {

	@Test(groups="regression", dependsOnGroups="sanity")
	public void createLead() throws InterruptedException {
		click(locateElement("link", "Find Leads"));
		type(locateElement("xpath","(//input[@name='firstName'])[3]"), "S");
		click(locateElement("xpath", "//button[contains(text(),'Find Leads')]"));
		Thread.sleep(3000);
		click(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		verifyTitle("View Lead | opentaps CRM");
		click(locateElement("link", "Edit"));
		type(locateElement("id","updateLeadForm_companyName"),"CTS");
		selectDropDownUsingText(locateElement("id","updateLeadForm_industryEnumId"), "Computer Software");
		click(locateElement("name","submitButton"));
		verifyPartialText(locateElement("id", "viewLead_companyName_sp"), "CTS");
	}




}
