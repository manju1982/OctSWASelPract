package com.qa.rtp.test;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.rtp.base.BasePage;
import com.qa.rtp.pages.HomePage;
import com.qa.rtp.pages.LoginPage;
import com.qa.rtp.util.Constants;

public class HomePageTest {

WebDriver driver;
BasePage basepage;
Properties prop;
LoginPage loginpage;
HomePage homePage;
SoftAssert softAssert;

  @BeforeTest
  public void setup(){
	  basepage=new BasePage();
	  prop=basepage.init_properties();
	  driver=basepage.init_driver(prop);  
	  loginpage=new LoginPage(driver);
	  homePage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	  softAssert=new SoftAssert();
  }

/*@Test(priority=1)
public void isHeaderExistTest(){
Assert.assertTrue(homePage.verifyHomePageHeader());
}
*/
@Test(priority=1) //Combine 2 test 
public void verifyHomePageHeaderValueTest(){ 
//Assert.assertTrue,Assert.assertEquals are hard assertions if one test case fails then whole test set will be  
	softAssert.assertTrue(homePage.verifyHomePageHeader());//test1
	//softAssert.assertTrue(homePage.verifyHomePageHeader());//test1
	String headerValue=homePage.getTextHomePageHeader();//test2
	System.out.println("Home Page Header value is" + headerValue);
    softAssert.assertEquals(headerValue, Constants.Home_page_header);
    
    softAssert.assertAll();
}
  
  
/*@Test(priority=3)
public void isAccountNameExistTest(){
	Assert.assertTrue(homePage.verifyHomePageAccountName());
}
*/
@Test(priority=2)

public void verifyAccountNameValueTest(){
	softAssert.assertTrue(homePage.verifyHomePageAccountName());//softAssert.assertTrue -Execution will continue even test case fail.
	//Assert.assertTrue(homePage.verifyHomePageAccountName());
	String accountnamevalue=homePage.getHomePageAccountName();
	System.out.println("Account Name value is " + accountnamevalue);
	//softAssert.assertEquals(accountnamevalue,prop.getProperty("accountname")); //poperty value is not working due to some space issue
	softAssert.assertEquals(accountnamevalue,Constants.accountname);
   
	softAssert.assertAll();
}

@Test(priority=3)
public void verifyHomePageLogoTest(){
	Assert.assertTrue(homePage.verifyHomePageLogo());
}
  
@Test(priority=4)
public void verifyHomepgaeTitle(){
	String title=homePage.getHomePageTitle();
	System.out.println("Home Page title is " + title);
	Assert.assertEquals(title, Constants.Home_page_title);
}


 @AfterTest
  public void quitbrowser(){
	 
  driver.quit();
 }
  
}
