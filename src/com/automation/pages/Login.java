package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	public Login(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebDriver driver;

	public void enterEmail(String email) {

		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
	}

	public void enterPass(String pass) {
		WebElement el = driver.findElement(By.xpath("//input[@id='ap_password']"));
		el.sendKeys(pass);
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	}

//	public void Click() {
//		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
//	}

	public void enterOtp(int otp) {
		driver.findElement(By.className("a-input-text cvf-widget-input cvf-widget-input-code single-input-box-otp"))
				.sendKeys(String.valueOf(otp));
		driver.findElement(By.xpath("//span[@id='cvf-submit-otp-button-announce']")).click();
	}

}
