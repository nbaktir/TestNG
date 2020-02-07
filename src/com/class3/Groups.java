package com.class3;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Groups extends CommonMethods{

	@BeforeMethod(alwaysRun=true)
	public void openAndNavigate() {
		setUp("chrome",Constants.HRMS_URL);
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test(priority =1,groups = {"smoke","login"})
	public void validLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test(groups = {"regression", "sprint1"})
	public void titleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		//validate title
		Assert.assertEquals(expectedTitle,actualTitle,"Title does NOT match");
	}
}
