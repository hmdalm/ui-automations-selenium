package com.shadab.ui.testing.selenium.sample.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChromeConcreteCalculator {
	private static WebDriver driver;
	@BeforeClass
	public static void driverSet() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.calculator.net/");
		driver.manage().window().maximize();
	}
	@Test
	public void test1_Concrete_Cal() throws Exception {
	 // Click on Other Calculators 
    driver.findElement(By.xpath("//*[@id=\"contentout\"]/table/tbody/tr/td[4]/div[2]/a")).click();
    // Click on Concrete Calculator 
    driver.findElement(By.xpath("//*[@id=\"occontent\"]/a[8]")).click();
    
    WebElement textbox = driver.findElement(By.id("slablength"));
    textbox.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
    driver.findElement(By.id("slablength")).sendKeys("6.50");
    
    WebElement textbox1 = driver.findElement(By.id("slabwidth"));
    textbox1.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
    driver.findElement(By.id("slabwidth")).sendKeys("1.80");
    WebElement textbox2 = driver.findElement(By.id("slabthick"));
    textbox2.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
    driver.findElement(By.id("slabthick")).sendKeys(".150");
    WebElement sel_Element = driver.findElement(By.xpath("//*[@id=\"slabthickunit\"]"));
    Select select = new Select(sel_Element);
    select.selectByIndex(3);
    driver.findElement(By.xpath("//*[@id=\"standard\"]/tbody/tr[5]/td[2]/input[1]")).click();
       String result =
    driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/table[1]/tbody/tr/td[2]")).getText();
    System.out.println(" The Result1 is " + result);
    Thread.sleep(3000);
    driver.close();
	
	}
	}


