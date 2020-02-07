package com.class3;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.Constants;

/*
 * verify user is able to login into hrms with different user id 
 * and password
 * */
public class DataProviderDemo extends CommonMethods{

	@BeforeMethod
	public void openBrowser() {
		setUp("chrome",Constants.HRMS_URL);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "getData")
	public void login(String username, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		boolean welcomeDisplayed = driver.findElement(By.id("welcome")).isDisplayed();
		Assert.assertTrue(welcomeDisplayed,"Welcome is NOT displayed");
	}
	
	@DataProvider // use this data as data provider for login page
	public Object[][] getData(){
		Object[][] data = {
				{"Admin","Hum@nhrm123"},
				{"Syntax","Syntax123!"},
				{"SyntaxUser","Syntax123!"}
		};
		return data;
	}
}
