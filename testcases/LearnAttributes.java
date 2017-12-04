package testcases;

import org.testng.annotations.Test;

public class LearnAttributes {

	@Test(priority=2)
	public void createLead() {
		System.out.println("createLead");
	}
	
	
	@Test(priority=1)
	public void editLead() {
		System.out.println("Edit Lead");
	}
	
	@Test(priority=-4)
	public void dupLead() {
		System.out.println("Dup Lead");
	}
}
