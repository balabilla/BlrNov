package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.LearnDataProvider;
import wdMethods.ProjectMethods;

public class CreateLead extends ProjectMethods {

	@Test(dataProvider="fetchdata"/*dataProviderClass=LearnDataProvider.class*/)
	public void createLead(String FName, String LName, String CName) throws InterruptedException {
		/*startApp("chrome", "http://leaftaps.com/opentaps");		
		type(locateElement("id", "username"), "DemoSalesManager");
		type(locateElement("id","password"), "crmsfa");
		click(locateElement("class", "decorativeSubmit"));
		click(locateElement("link", "CRM/SFA"));
		click(locateElement("link", "Leads"));*/


		//login();
		click(locateElement("link", "Create Lead"));
		type(locateElement("id","createLeadForm_companyName"), CName);
		type(locateElement("id","createLeadForm_firstName"), FName);
		type(locateElement("id","createLeadForm_lastName"), LName);
		click(locateElement("xpath", "//input[@value='Create Lead']"));
		verifyPartialText(locateElement("id", "viewLead_companyName_sp"), CName);

		/*closeBrowser();*/
		//close();	

	}


	public class LearnDataProvider {

		@DataProvider(name="fetchdata")
		public String[][] getData(){

			String[][] data = new String[3][3];
			data[0][0]="Nesa";
			data[0][1]="Kumar";
			data[0][2]="TestLeaf";
			data[1][0]="Bala";
			data[1][1]="S";
			data[1][2]="TestLeaf";
			data[2][0]="Babu";
			data[2][1]="M";
			data[2][2]="TestLeaf";
			return data;


		}



	}

}
