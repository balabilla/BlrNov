package week2.learnJava;

public class BMW extends Car {

	public void inBMW() {
		System.out.println("in BMW");
	}
	
	@Override
	public void applyBreak() {
		System.out.println("ABS in BMW");
	}
	
	public static void staticCheck() {
		
	}
}
