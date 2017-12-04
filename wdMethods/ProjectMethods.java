package wdMethods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectMethods extends SeMethods {
	
	@Parameters({"browser", "url", "username", "password"})
	@BeforeMethod(groups={"general"})
	public void login(String brw, String URL, String uname, String pass) {
		startApp(brw, URL);		
		type(locateElement("id", "username"), uname);
		type(locateElement("id","password"), pass);
		click(locateElement("class", "decorativeSubmit"));
		click(locateElement("link", "CRM/SFA"));
		click(locateElement("link", "Leads"));
	}
	
	@AfterMethod(groups={"general"})
	public void close(){
		closeBrowser();
	}

}
