package com.qa.rtp.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	
 /*.....This method is to initialize the driver on the basis of browser...
  * @param browser
  * @return driver
  * */	
	
	//public WebDriver init_driver(String browser){
		
	public WebDriver init_driver(Properties prop){
		String browser=prop.getProperty("browser");//browser value from property file
		
		if(browser.equals("chrome"))
		{
	     	WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
		}
		
		else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else if(browser.equals("safari")){
			WebDriverManager.getInstance(SafariDriver.class).setup();
		    driver=new SafariDriver();	
		}
		
		else {
			
			System.out.println("Please enter proper browser....");
			
		}
		
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		return driver;
		
	}
	
	
/*This method is to initialize the properties from the config.properties file
 * @return prop
 */	
	
	public Properties init_properties(){
		
	prop=new Properties();	
		
	try {
		FileInputStream ip=new FileInputStream("C://Users//manju//workspace//JanPOMFrameWork//JanPOM_FrameWork"
				+ "//src//main//java//com//qa//rtp//config//config.properties");
			prop.load(ip);
		
	} catch (FileNotFoundException e) {
		
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	return prop;
	
	}
	
	

}
