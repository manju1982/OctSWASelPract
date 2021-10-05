package sampletestNGConcepts;

import org.testng.annotations.Test;

public class InvocationCountConcept {
	
	@Test(invocationCount=10)//test will run 10 times
	public void createUserTest(){
		
		System.out.println("User create test");
	}
	
	

}
