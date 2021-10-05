package sampletestNGConcepts;

import org.testng.annotations.Test;

public class DependsOnMethods {
	
	@Test
	public void loginTest(){
		
		System.out.println("Login Test");
		int i=9/0;
	}
	
	@Test(dependsOnMethods="loginTest")
	public void homePageTest(){
		
		System.out.println("Home Page Test");
	}

	@Test(dependsOnMethods="loginTest")
	public void homePageSearch(){
		
		System.out.println("Home Page Search");
	}
}
