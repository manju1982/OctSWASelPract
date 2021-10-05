package com.qa.rtp.test;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.rtp.base.BasePage;
import com.qa.rtp.pages.HomePage;
import com.qa.rtp.pages.LoginPage;
import com.qa.rtp.util.Constants;


public class LoginPageTest {
	
	//Reference variables
	WebDriver driver;
	BasePage basePage; 
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	
	//@BeforeMethod    //@BeforeMethod & @AfterMethod - The browser will launch for each test case separately.
	@BeforeTest      //@BeforeTest & @AfterTest - same browser will continue for all 3 test cases then quit
	public void setup(){
		
		basePage=new BasePage();
		prop=basePage.init_properties();//This method is returning you the properties so store inside the properties variable
		driver=basePage.init_driver(prop);//Lauch the url
		loginPage=new LoginPage(driver);
		
	}
	
	//@Test(priority=1,enabled=false) //enabled=false - This test case will exclude in execution.
	@Test(priority=1)
	public void verifyLoginPageTitle(){
		Reporter.log("Test Started>"+"verifyLoginPageTitle");
		String title=loginPage.getPageTitle();
		System.out.println("Login page title is"+ title);
		Reporter.log("Login page title is"+ title); //print on output report
		Assert.assertEquals(title,Constants.Login_page_title);
		Reporter.log("Test Ended"+"verifyLoginPageTitle");
	}
	
	@Test(priority=2)
	
	public void verifySignUpLinkTest(){
		Assert.assertTrue(loginPage.isSignUplinkExists());
	}
	
	@Test(priority=3)
	
	public void verifyLoginTest(){
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.verifyHomePageAccountName());
		Assert.assertEquals(homePage.getHomePageAccountName(),prop.getProperty("accountname"));
		
		
	}
	
//	@AfterMethod
	@AfterTest
	public void quitbrowser(){
		
	driver.quit();	
		
	}

}
