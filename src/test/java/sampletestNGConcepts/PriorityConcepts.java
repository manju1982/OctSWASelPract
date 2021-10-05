package sampletestNGConcepts;

import org.testng.annotations.Test;

public class PriorityConcepts {
	
	//by default test will run based on alphabetical order if no priority given to test
	@Test(priority=1)
	public void loginTest(){
		
		System.out.println("Login Test");
		
	}
	
	@Test(priority=3)
	public void homePageTest(){
		
		System.out.println("Home Page Test");
	}

	@Test(priority=4)
	public void profileTest(){
		
		System.out.println("Home Page Search");
	}

	@Test(priority=2)
	public void homeTabTest(){
		
		System.out.println("Home Page Search");
	}
	
}
