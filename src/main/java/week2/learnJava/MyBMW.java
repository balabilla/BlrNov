package week2.learnJava;

public class MyBMW extends BMW {

	public static void main(String[] args) {
		BMW bmw = new BMW();
		bmw.applyBreak();
	}
	
	public void nonStaticMethod() {
		applyBreak();
	}
}
