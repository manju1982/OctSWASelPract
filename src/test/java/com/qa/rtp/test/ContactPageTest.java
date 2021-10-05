package com.qa.rtp.test;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.rtp.base.BasePage;
import com.qa.rtp.pages.ContactsPage;
import com.qa.rtp.pages.HomePage;
import com.qa.rtp.pages.LoginPage;
import com.qa.rtp.util.Constants;
import com.qa.rtp.util.ExcelUtil;

public class ContactPageTest   {
	
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginpage;
	HomePage homePage;
	ContactsPage contactsPage;
		
	
	
	  @BeforeTest
	  public void setup(){
	
		  basepage=new BasePage();
		  prop=basepage.init_properties();
		  driver=basepage.init_driver(prop);  
		  loginpage=new LoginPage(driver);
		  homePage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));  
		  contactsPage=homePage.goToContactsPage();
		  
		  }

	@Test
	public void verifyContactsPageTitle(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
						e.printStackTrace();
		}
		String title=contactsPage.getContactsPageTitle();
		System.out.println("contacts page title is " + title);
		Assert.assertEquals(title, Constants.Contact_page_title);
	}
	
	
	@DataProvider
	public Object[][] getContactsTestData(){
		Object data[][]=ExcelUtil.getTestdata(Constants.testdata_sheet_name.trim());
		return data;
		
	}
	
	@Test(dataProvider="getContactsTestData")
	public void createContactsTest(String email,String firstname,String lastname,String title){
		//contactsPage.createNewContacts("naveentest@gmail.com", "naveenTest", "kodi", "admin");
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		contactsPage.createNewContacts(email, firstname, lastname, title);	
	 
	}
	   
	  @AfterTest
		public void quitbrowser(){
			
		driver.quit();	
			
		}
}
