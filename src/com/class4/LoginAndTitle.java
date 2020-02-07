package com.class4;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class LoginAndTitle extends CommonMethods implements ITestListener{
	@BeforeMethod(alwaysRun = true)
	public void openAndNavigate() {
		setUp("chrome",Constants.HRMS_URL);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test(groups="regression")
	public void titleValidation() {
		String expectedTitle = "Human Management Systems";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle,"Titles are NOT matched");
		System.out.println("I am text after the assertion");
	}
	
	@Test(groups="regression")
	public void logoValidation() {
		boolean logoDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		Assert.assertTrue(logoDisplayed,"Syntax Logo is NOT displayed");
	}
}