package testcases;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.testng.annotations.Test;

public class LearnDepends {

	@Test (expectedExceptions={NoSuchElementException.class, NoSuchWindowException.class})
	public void createLead() {
		System.out.println("createLead");
		//throw new RuntimeException();
	}
	
	@Test(enabled=false)
	public void editLead() {
		System.out.println("Edit Lead");
	}
	
	@Test (successPercentage=80)
	public void xeditLead() {
		System.out.println("X Edit Lead");
	}
	
	@Test(alwaysRun=true, dependsOnMethods={"createLead"})
	public void dupLead() {
		System.out.println("Dup Lead");
	}
}
