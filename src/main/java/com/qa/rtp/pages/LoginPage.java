package com.qa.rtp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.rtp.base.BasePage;
import com.qa.rtp.util.Constants;
import com.qa.rtp.util.ElementUtil;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	//1. Page objects and page locators
	
	By emailID=By.id("username");
	By password=By.id("password");
	By loginButton=By.id("loginBtn");
	By signUPLink=By.linkText("Sign up");
	By forgorPassword=By.linkText("Forgot my password");
	
	//2. Page class constructor
	
	public LoginPage(WebDriver driver){
		
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	//Page libraries, methods
	
	//3. Page actions/methods
	
	public String getPageTitle(){
		elementUtil.waitForTitle(Constants.Login_page_title);
		//return driver.getTitle();
		return elementUtil.doGetTitle();
		
		}
	
	public boolean isSignUplinkExists(){
		
		//return driver.findElement(signUPLink).isDisplayed();
		return elementUtil.isDisplayed(signUPLink);
	}

	public HomePage doLogin(String username, String pwd){
		
		/*driver.findElement(emailID).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
*/
		elementUtil.doSendKeys(emailID, username);
		elementUtil.doSendKeys(password,pwd);
		elementUtil.doClick(loginButton);
		
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		*/
		return new HomePage(driver);
	}
	
	

}
