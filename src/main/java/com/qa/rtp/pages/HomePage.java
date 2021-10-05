package com.qa.rtp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.rtp.base.BasePage;
import com.qa.rtp.util.ElementUtil;

public class HomePage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;

	By header=By.cssSelector("h1.private-page__title");
	By acccountmenu=By.cssSelector("#account-menu > img");
	By accountname=By.cssSelector("#navAccount-current > div.navAccount-accountName");
	By logo=By.cssSelector("li>a#nav-primary-home");
	
	By contactsParentTab=By.id("nav-primary-contacts-branch");
			//By.xpath("(//a[@id='nav-primary-contacts-branch'])[1]");
	By contactsChildTab=By.id("nav-secondary-contacts");
	//By.xpath("(//a[@id='nav-secondary-contacts'])[1]");
	
	public HomePage(WebDriver driver){
		this.driver=driver;	
		elementUtil=new ElementUtil(driver);
		elementUtil.waitForElementPresent(header);
		
	}
	
	
	public String getHomePageTitle(){
		//return driver.getTitle();
		return elementUtil.doGetTitle();
	}
	
	public boolean verifyHomePageHeader(){
		
		//return driver.findElement(header).isDisplayed();
		return elementUtil.isDisplayed(header);
		}
	
	public String getTextHomePageHeader(){
		
		//return driver.findElement(header).getText();
		return elementUtil.dogetText(header);
	}
	
	public boolean verifyHomePageAccountName(){
		/*driver.findElement(acccountmenu).click();
		return driver.findElement(accountname).isDisplayed();
        */
		elementUtil.doClick(acccountmenu);
		return elementUtil.isDisplayed(accountname);
		
		}
	
	public String getHomePageAccountName(){
		//return driver.findElement(accountname).getText();
		return elementUtil.dogetText(accountname);
	}
	
	public boolean verifyHomePageLogo(){
		
		//return driver.findElement(logo).isDisplayed();
		return elementUtil.isDisplayed(logo);	
	
	}
	
	public ContactsPage goToContactsPage(){
		
		elementUtil.waitForElementPresent(contactsParentTab);
		elementUtil.doClick(contactsParentTab);
		elementUtil.waitForElementPresent(contactsChildTab);
		elementUtil.doClick(contactsChildTab);
		
		return new ContactsPage(driver);
	}
	
}
