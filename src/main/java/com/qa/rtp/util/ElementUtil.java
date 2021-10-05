package com.qa.rtp.util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public ElementUtil(WebDriver driver){
		
		this.driver=driver;
		wait=new WebDriverWait(driver,15);
		
	}

	
	public WebElement getElement(By locator){
		waitForElementPresent(locator);
		WebElement element=null;
		try{
		 element=driver.findElement(locator);
		}catch(Exception e){
		  System.out.println("some exception got occured while creating the WebElement:"+ locator);
		  System.out.println(e.getMessage());
		}
		
		return element;
	}

	
	public void doClick(By locator){
		try{
		getElement(locator).click();
		
		}catch(Exception e){
			
			System.out.println("some exception got occcured while clicking on the webelement" + locator);
			System.out.println(e.getMessage());
		}
	}
	
	public void doActionClick(By locator){
		try{
		
			Actions action=new Actions(driver);
			action.click(getElement(locator)).build().perform();
			
		}catch(Exception e){
			
			System.out.println("some exception got occcured while clicking on the webelement" + locator);
			System.out.println(e.getMessage());
		}
	}
	
	public void doSendKeys(By locator, String... value){
		
		try{
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
		}catch(Exception e){
			
			System.out.println("some exception got occured while sending the webelements"+ locator);
			System.out.println(e.getMessage());
		}
	}
	
    
	public void doActionSendKeys(By locator, String... value){
		try{
		
			Actions action=new Actions(driver);
			action.sendKeys(getElement(locator), value).build().perform();
		}catch(Exception e){
			
			System.out.println("some exception got occcured while clicking on the webelement" + locator);
			System.out.println(e.getMessage());
		}
	}
	
	public String dogetText(By locator){
		String text=null;
		try{
		text=getElement(locator).getText();
		}catch(Exception e){
			
			System.out.println("some exception got occured while getting the text from webelements"+ locator);
			System.out.println(e.getMessage());
		}
		return text;
	}
	
    public boolean isDisplayed(By locator){
		boolean flag=false;
		try{
		flag=getElement(locator).isDisplayed();
		} catch(Exception e){
			
			System.out.println("some exception got occured while checking isdisplayed for webelements"+ locator);
			System.out.println(e.getMessage());
		}
		return flag;
	}	
	
    public String doGetTitle(){
		String title=null;
		try{
		title=driver.getTitle();
		} catch(Exception e){
			
			System.out.println("some exception got occured while getting the title of teh page");
			System.out.println(e.getMessage());
		}
		return title;
	}	
	
    public void doActionMoveToElement(By locator){
		try{
		
			Actions action=new Actions(driver);
			action.moveToElement(getElement(locator)).build().perform();
		}catch(Exception e){
			
			System.out.println("some exception got occcured while moving on the webelement" + locator);
			System.out.println(e.getMessage());
		}
	}
	
 
    public void doDragandDrop(By locator, WebElement element){
		try{
		
			Actions action=new Actions(driver);
			action.dragAndDrop(getElement(locator), element);
		}catch(Exception e){
			
			System.out.println("some exception got occcured while dragging on the webelement" + locator);
			System.out.println(e.getMessage());
		}
	}

   
    public void waitForPageUrl(String Url){
    	wait.until(ExpectedConditions.urlToBe(Url));
    }
    
    public void waitForTitle(String title){
    	wait.until(ExpectedConditions.titleContains(title));
    	
    }
    
    public void waitForElementPresent(By locator){
    	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
