package com.automation.pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Filterfunc {
	WebDriver driver;

	public Filterfunc(WebDriver driver) {
		super();
		this.driver = driver;
	}

//	setting values for filters
	int minValue = 10000;
	int maxValue = 20000;

//method to input value in price range boxes and filter result.
	public void rangeFilter() throws InterruptedException {
//    	using homepage method to search laptops
		HomePage hm = new HomePage(driver);
		hm.enterProductName("Laptop");
		driver.findElement(By.xpath("//input[@id='low-price']")).sendKeys(Integer.toString(minValue));
		WebElement el = driver.findElement(By.xpath("//input[@id='high-price']"));
		el.sendKeys(Integer.toString(maxValue));
		Thread.sleep(1000);
		el.sendKeys(Keys.ENTER);
	}

//    method to validate that price range filter is working properly or not.
	public void validatePrices() {
		for (int i = 1; i < 11; i++) {
			WebElement el = driver.findElement(By.xpath(
					"//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_"
							+ i + "']//div[@class='a-section a-spacing-small a-spacing-top-small']"));

			String productPrice = el.findElement(By.xpath(
					"//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_"
							+ i
							+ "']//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole']"))
					.getText();

//			validating price range
			assertTrue(Integer.parseInt(productPrice.replace(",", "")) >= minValue
					&& Integer.parseInt(productPrice.replace(",", "")) <= maxValue);

		}
	}

//	method to check brand filter functionality.
	public void brandFilter() throws InterruptedException {
		HomePage hm = new HomePage(driver);
		hm.enterProductName("Laptop");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement el1 = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//li[@id='p_123/219979']//i[@class='a-icon a-icon-checkbox']")));
		el1.click();
		WebElement el2 = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//li[@id='p_123/391242']//i[@class='a-icon a-icon-checkbox']")));
		el2.click();
		WebElement el3 = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//li[@id='p_123/247341']//i[@class='a-icon a-icon-checkbox']")));
		el3.click();
	}

//  Method to validate brand filter is working properly or not;
	public void validateBrand() {
		for (int i = 1; i < 11; i++) {
			WebElement el = driver.findElement(By.xpath(
					"//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_"
							+ i + "']//div[@class='a-section a-spacing-small a-spacing-top-small']"));
			String productName = el.findElement(By.xpath(
					"//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_"
							+ i
							+ "']//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-size-medium a-color-base a-text-normal']"))
					.getText();
			assertTrue(productName.toLowerCase().contains("asus") || productName.toLowerCase().contains("acer")
					|| productName.toLowerCase().contains("lenovo"));

		}
	}
}
