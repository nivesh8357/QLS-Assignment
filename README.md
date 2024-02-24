
# Hi, I'm Nivesh sharma
I have created automation testing script for - 


# E-Commerce website

An e-commerce website is an online store that allows businesses to sell products or services to customers.





## About Code

## Running Tests

To run tests, run the following Class

```bash
  com/automation/testcase/TestCases.java
```

This class have all the Test cases which required to run.


## Package Info


| Package Name |
| :-------- |
| `com.automation.base` |
| `com.automation.pages` |
| `com.automation.testcase` |
|`com.automation.utility`|



Projetc have 4 packages,

1. **com.automation.base** Package have base classes which have basic configuration like initialize the Browser instance, open URL and close the Browser.

It has @BeforeMethod and @afterMethod Annotation classes, which runs before and after every test.

2. **com.automation.pages** Package contains classes which have method to interact with particular pages,
 like **com.automation.pages.Login.java** contains methods who used to perform operations on Login page.

3. **com.automation.testcase** Package contains classes which have Required testcases. i created methods for each test classes, we can also create multiple classes for different type of testcases.

4. **com.automation.utility** Package contains classes which have Utility methods to get data from **config.properties** file. and later can use Utility methods in every classes to perform Required operations.
## Other files Info.

- ***Config/Config.properties*** - File contains properties of the project. like Xpaths of the elements, Browser name, Required files location, Url location etc. We can iterate those properties using the Utility class methos.

- ***pom.xml*** - I used maven project to create test script so in maven we have *pom.xml* to add dependencies in our project.

## Test Cases.


### 1st test method
1st method of TestCases class is used to validate log in functionality of the application. As Assignment says i don't have to login before performing automation on application so just marked code commented for reference.
```java
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
```
### 2nd test method
2nd method of TestCases class is used to provide data to the methods who needs.
Its a Data-Driven approch of selenium and testing.
```java
@DataProvider(name = "logindata")
	public Object[][] testData() {
//		we can also use excelsheet here.
		Object arr[][] = { { "Niveshsharma835783@gmail.com", "bharatmata" },
				{ "Niveshsharma835783@gmail.com", "bharatmata" } };
		return arr;
	}
```
### 3rd test method
3rd method of TestCases class is used to search the product and print name and price in console. 
```java
@Test(testName = "product search and print.", priority = 1)
	public void searchLaptop() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.enterProductName("Laptop");
		hp.consoleResults();
	}

```
### 4th test method
4th method of TestCases class is used to check price filter functionality.
```java
@Test(testName = "filter functionality for price range", priority = 2)
	public void checkPriceFilter() throws InterruptedException {
		Filterfunc ff = new Filterfunc(driver);
		ff.rangeFilter();
		ff.validatePrices();
	}
```
### 5th test method
5th method of TestCases class is used to check brand filter functionality.
```java
@Test(testName = "Filter functionality for multiple brands.", priority = 3)
	public void checkBrandFilter() throws InterruptedException {
		Filterfunc ff = new Filterfunc(driver);
		ff.brandFilter();
		ff.validateBrand();
	}
```

