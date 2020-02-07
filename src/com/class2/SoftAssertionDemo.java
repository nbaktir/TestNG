package com.class2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

/*Open Application
 * Verify logo is displayed
 * Enter valid credentials
 * Verify user successfully logged in
 */
public class SoftAssertionDemo extends CommonMethods{

	@BeforeMethod
	public void open() {
		setUp("chrome",Constants.HRMS_URL);
	}
	
	@Test(groups="smoke")
	public void login() {
		
		boolean logoIsDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		
		logoIsDisplayed = false;
		
		//Hard Assert will fail and execution will stop at that point
		//Assert.assertTrue(logoIsDisplayed, "Logo is NOT displayed");
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(logoIsDisplayed,"Logo is NOT displayed");
		
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		
		boolean welcomeDisplayed = driver.findElement(By.id("welcome")).isDisplayed();
		softAssert.assertTrue(welcomeDisplayed);
		softAssert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
