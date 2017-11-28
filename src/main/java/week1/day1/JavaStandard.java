package week1.day1;

public class JavaStandard {

	static int myFirstVariable = 5;

	public static void main(String[] args) {
		
		myFirstMethod();
		mySecondMethod(10);
		
		int findSum = myThirdMethod(10);
		System.out.println("main --> Sum: "+findSum);
		
		int findSum1 = myThirdMethod(20);
		System.out.println("main --> Sum1: "+findSum1);

	}

	private static void myFirstMethod() {
		System.out.println("myFirstMethod --> My First Variables: " +myFirstVariable);		
	}
	
	private static void mySecondMethod(int myInput) {
		System.out.println("mySecondMethod --> My First Variables: " +myFirstVariable);
		System.out.println("mySecondMethod --> My Input is: "+myInput);
	}

	private static int myThirdMethod(int myInput) {
		System.out.println("myThirdMethod --> My First Variables: " + myFirstVariable);
		System.out.println("myThirdMethod --> My Input is:"+myInput);
		int sum =  myInput + myFirstVariable;
		return sum;

	}

}
