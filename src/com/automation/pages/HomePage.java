package com.automation.pages;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

// to search the laptops.
	public void enterProductName(String productName) {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(productName);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

	}

//	to list the laptop and price.
	public void consoleResults() {
		for (int i = 1; i < 23; i++) {
			WebElement el = driver.findElement(By.xpath(
					"//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_"
							+ i + "']//div[@class='a-section a-spacing-small a-spacing-top-small']"));
			String productName = el.findElement(By.xpath(
					"//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_"
							+ i
							+ "']//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-size-medium a-color-base a-text-normal']"))
					.getText();
			String productPrice = el.findElement(By.xpath(
					"//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_"
							+ i
							+ "']//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole']"))
					.getText();
			assertFalse(productName.isEmpty(), "Product name should not be empty");

			System.out.println("Name of the product = " + productName);
			System.out.println("Name of the product = " + productPrice);
		}
	}

}
