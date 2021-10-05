package sampletestNGConcepts;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	
	ExpectedExceptionConcept obj=null;
	
	//@Test(expectedExceptions=ArithmeticException.class)//It will forcefully pass the test
	//@Test(expectedExceptions=Exception.class)  //"Exception" is super class of all exceptions
	//@Test(expectedExceptions=Throwable.class)   //Throwable is a super class of Exception
	//@Test(expectedExceptions=Error.class)     //Error -we cannot user error as it is different from exceptions.
    
	@Test(expectedExceptions=Object.class)  //Object is the superSuper class of all classes
	public void loginTest(){
		
		System.out.println("Login Test");
		int i=9/0;
	}
	
	//@Test(expectedExceptions={NullPointerException.class,ArithmeticException.class})
	@Test(expectedExceptions=NullPointerException.class)
	public void homePageTest(){
		
		System.out.println("Home page Test");
		obj.login();
	}

public void login(){
	
	System.out.println("Login method");
}
	
}
