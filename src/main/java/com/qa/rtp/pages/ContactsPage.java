package com.qa.rtp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.rtp.base.BasePage;
import com.qa.rtp.util.Constants;
import com.qa.rtp.util.ElementUtil;

public class ContactsPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By createContactButton=By.xpath("//span[text()='Create contact']");
	By createContactFormButton=By.xpath("//li//span[text()='Create contact']");
	
	By email=By.xpath("//input[@data-field='email']");
	By firstName=By.xpath("//input[@data-field='firstname']");
	By lastName=By.xpath("//input[@data-field='lastname']");
	By title=By.xpath("//input[@data-field='jobtitle']");
	
	
	public ContactsPage(WebDriver driver){
		this.driver=driver;
		
		elementUtil=new ElementUtil(driver);
		}
	

	
	public String getContactsPageTitle(){
		
		elementUtil.waitForTitle(Constants.Contact_page_title);
		
		return elementUtil.doGetTitle();
		
	}
	
	public void createNewContacts(String mail, String FN,String LN,String jobtitle){
		elementUtil.waitForElementPresent(createContactButton);
		elementUtil.doActionClick(createContactButton);
		elementUtil.doSendKeys(email, mail);
		elementUtil.doSendKeys(firstName, FN);
		elementUtil.doSendKeys(lastName, LN);
		elementUtil.doSendKeys(title, jobtitle);
		elementUtil.doActionClick(createContactFormButton);
	}
	
}
