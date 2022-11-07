package com.shadab.ui.testing.selenium.sample.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FirefoxbrowserLaunch {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Selenium webdrivers\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		
		
		  WebElement selectElement = driver.findElement(By.xpath("//*//*[@id=\"container\"]/div/div[2]/div/div/div[4]/a/div[2]/div/div"));
		     Select sel = new Select(selectElement);
		    sel.selectByIndex(3);
		driver.close();
	}

}
