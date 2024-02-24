package com.automation.testcase;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.DriverInstance;
import com.automation.pages.Filterfunc;
import com.automation.pages.HomePage;
import com.automation.pages.Login;

public class TestCases extends DriverInstance {

//	first test method to login application - uncomment code to if wants to login first.
	/*
	 * @Test(dataProvider = "logindata") public void login(String email, String
	 * pass) throws InterruptedException {
	 * 
	 * Login log = new Login(driver); WebElement el =
	 * driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"))
	 * ; Actions ac = new Actions(driver); ac.moveToElement(el).perform();
	 * driver.findElement(By.xpath(
	 * "//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']"
	 * )) .click(); log.enterEmail(email); log.enterPass(pass);
	 * 
	 * // if you got any otp, then use below code. // Scanner sc = new
	 * Scanner(System.in); // System.out.println("Enter otp"); // int otp =
	 * sc.nextInt(); // Thread.sleep(5000); // log.enterOtp(otp); }
	 */

//	it's data provider method - to implement data-driven, even if we have 1000 data, the test will run 1000 times.
	@DataProvider(name = "logindata")
	public Object[][] testData() {
//		we can also use excelsheet here.
		Object arr[][] = { { "Niveshsharma835783@gmail.com", "bharatmata" },
				{ "Niveshsharma835783@gmail.com", "bharatmata" } };
		return arr;
	}

//	Task 1: Search of Product
//	2nd test method to search the product and print name and price in console.
	@Test(testName = "product search and print.", priority = 1)
	public void searchLaptop() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.enterProductName("Laptop");
		hp.consoleResults();
	}

//	Task 2: Apply Search Filter --> a. Verify working of price range in price range boxes
//	3rd test method to check filter functionality.
	@Test(testName = "filter functionality for price range", priority = 2)
	public void checkPriceFilter() throws InterruptedException {
		Filterfunc ff = new Filterfunc(driver);
		ff.rangeFilter();
		ff.validatePrices();
	}

//	Task 2: Apply Search Filter --> b. Check multiple brands of laptop
//	4th method to check filter functionality.
	@Test(testName = "Filter functionality for multiple brands.", priority = 3)
	public void checkBrandFilter() throws InterruptedException {
		Filterfunc ff = new Filterfunc(driver);
		ff.brandFilter();
		ff.validateBrand();
	}

}
