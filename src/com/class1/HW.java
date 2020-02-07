package com.class1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utils.CommonMethods;
import com.utils.Constants;

public class HW extends CommonMethods{

	@BeforeMethod
	public void openAndNavigate() {
		setUp("chrome",Constants.HRMS_URL);
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	/*TC 1: HRMS Application Login: 
	 * Enter valid username and password
	 * Click on login button
	 * Then verify Syntax logo is displayed
	 */
	@Test
	public void appLoginAndVerifyLogo() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		
		boolean logoDisplayed = driver.findElement(By.xpath("//img[@alt='OrangeHRM']")).isDisplayed();
		
		Assert.assertTrue(logoDisplayed,"Logo is Not displayed");
	}

	/*TC 2: HRMS Application Negative Login: 
	 * Enter valid username
	 * Leave password field empty
	 * Verify error message with text "Password cannot be empty"
	 */
	@Test
	public void emptyPassword() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("btnLogin")).click();
		String actualErrorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
		String expectedMsg = "Password cannot be empty";
		
		Assert.assertEquals(actualErrorMsg, expectedMsg,"Error message is Not matched");
	
	}
	
}
