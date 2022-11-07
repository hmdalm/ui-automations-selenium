package com.shadab.ui.testing.selenium.sample.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChromeAgeCalculation {
	private static WebDriver driver;

	// @Before if want to run before every test method call, but method should be
	// non static then
	@BeforeClass
	public static void prepare() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.calculator.net/");
		driver.manage().window().maximize();
	}
	@Test
	public void test1_Age_Cal() throws Exception {
	 // Click on Other Calculators 
    driver.findElement(By.xpath("//*[@id=\"contentout\"]/table/tbody/tr/td[4]/div[2]/a")).click();
    // Click on Age Calculator
    driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr/td[1]/div[1]/a")).click();
 
    
    WebElement selectElement = driver.findElement(By.xpath("//*[@id=\"today_Month_ID\"]"));
     Select sel = new Select(selectElement);
    sel.selectByIndex(10);
    WebElement selectElement1 =driver.findElement(By.xpath("//*[@id=\"today_Day_ID\"]"));
    Select sel1 = new Select(selectElement1);
    
    sel1.selectByIndex(27);
    //driver.findElement(By.id("today_Year_ID")).getTex
    WebElement textbox = driver.findElement(By.id("today_Year_ID"));
    textbox.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.BACK_SPACE));
   // textbox.clear();
    Thread.sleep(5000);
    driver.findElement(By.id("today_Year_ID")).sendKeys("1993");
    driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/table/tbody/tr[3]/td[2]/input")).click();
    String result1 =
    driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText();
    System.out.println(" The Result1 is " + result1);
    driver.close();
}
}