package com.automation.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.utility.Utility;

public class DriverInstance {
	public WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void openBrowser() throws InterruptedException, IOException {

		System.out.println("Automated by Nivesh sharma");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nives\\Downloads\\chromedriver-win64\\chromedriver.exe");
		Thread.sleep(2000);
		if (Utility.fetchPropertyValue("browserName").toString().contains("chrome")) {
			driver = new ChromeDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		try {
			driver.get(Utility.fetchPropertyValue("applicstionURL").toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
