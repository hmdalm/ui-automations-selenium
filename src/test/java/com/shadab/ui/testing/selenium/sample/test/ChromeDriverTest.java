package com.shadab.ui.testing.selenium.sample.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.shadab.ui.testing.selenium.constants.AppConstants;
import com.shadab.ui.testing.selenium.sample.util.SeleniumUtility;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChromeDriverTest {

	private static WebDriver driver;

	// @Before if want to run before every test method call, but method should be
	// non static then 
	@BeforeClass
	public static void prepare() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(AppConstants.BASE_URL_SWAG_LAB);
		driver.manage().window().maximize();
		System.out.println("");
	}

	@Test
	public void test1_testTitle() throws Exception {

		String title = driver.getTitle();
		SeleniumUtility.takeScreenShot(driver, AppConstants.OUTPUT_SWAG_LAB_PATH + "home_page.png");
		assertTrue("Home page not loaded", title.equals("Swag Labs"));

	}

	@Test
	public void test2_testLoginStandardUserSuccess() throws Exception {

		driver.findElement(By.id("user-name")).sendKeys(AppConstants.USER_STANDARD_SWAG_LAB);
		driver.findElement(By.id("password")).sendKeys(AppConstants.PASSWORD_STANDARD_SWAG_LAB);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		SeleniumUtility.takeScreenShot(driver, AppConstants.OUTPUT_SWAG_LAB_PATH + "LoginSuccess.png");
		String header = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		assertTrue("Login failed", header.equals("PRODUCTS"));

	}

	@Test
	public void test3_testProductSorting() throws Exception {
		
		String firstItemAmountString = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div"))
				.getText();
		Float firstItemAmount= Float.valueOf(firstItemAmountString.substring(1));
		WebElement selectElement = driver
				.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select"));
		SeleniumUtility.takeScreenShot(driver, AppConstants.OUTPUT_SWAG_LAB_PATH + "before_sorting.png");
		Select selectObject = new Select(selectElement);
		// low to high
		selectObject.selectByIndex(2);
		SeleniumUtility.takeScreenShot(driver, AppConstants.OUTPUT_SWAG_LAB_PATH + "after_sorting.png");
		
		/* ALTERNATE WAYS
		 * // Select an <option> based upon its value attribute
		 * selectObject.selectByValue("value1");
		 * 
		 * // Select an <option> based upon its text
		 * selectObject.selectByVisibleText("Bread");//*//*//*
		 */
		String firstItemAmountStringAfterSecond = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div"))
				.getText();
		Float firstItemAmountAfterSorting = Float.valueOf(firstItemAmountStringAfterSecond.substring(1));

		 assertTrue("Items not sorted", firstItemAmount>=firstItemAmountAfterSorting);
		 SeleniumUtility.hold(10000);
	}
	
	@Test
	public void test4_testItemAddinCart() throws Exception {
		SeleniumUtility.hold(10000);
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        SeleniumUtility.hold(10000);
        driver.findElement(By.xpath("//*//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
        SeleniumUtility.hold(10000);
        driver.findElement(By.xpath("//*//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click(); 

		SeleniumUtility.takeScreenShot(driver, AppConstants.OUTPUT_SWAG_LAB_PATH + "ItemAddingInCart.png");
		
		

	}
	@Test
	public void test5_CheckoutItem() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
		SeleniumUtility.hold(5000);
		driver.findElement(By.id("first-name")).sendKeys(AppConstants.FIRST_NAME_SWAG_LAB);
		SeleniumUtility.hold(5000);
		driver.findElement(By.id("last-name")).sendKeys(AppConstants.LAST_NAME_SWAG_LAB);
		SeleniumUtility.hold(5000);
		driver.findElement(By.id("postal-code")).sendKeys(AppConstants.ZIP_CODE_SWAG_LAB);
		SeleniumUtility.hold(5000);
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click(); 
		driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
		SeleniumUtility.hold(10000);
		driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
		SeleniumUtility.hold(5000);
		SeleniumUtility.takeScreenShot(driver, AppConstants.OUTPUT_SWAG_LAB_PATH + "ItemAddingInCart.png");
		
		
		
	}
	@Test
	public void test6_testLogOutUserSuccess() throws Exception {
		SeleniumUtility.hold(10000);
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
        SeleniumUtility.hold(10000);
        driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
        SeleniumUtility.hold(10000);
		SeleniumUtility.takeScreenShot(driver, AppConstants.OUTPUT_SWAG_LAB_PATH + "LogOutSuccess.png");
		
		

	}
	
	// @After can be used if we want to invoke it after every test method call - but
	// method should be non static then
	//@AfterClass
	public static void teardown() throws IOException {
		SeleniumUtility.hold(10000);
		driver.quit();
	}

}
