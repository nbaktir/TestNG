package com.class2;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

/*
 * TC 1: HRMS Add Employee: 
Open chrome browser
Go to "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login"
Login into the application
Click on Add Employee
Verify labels: Full Name, Employee Id, Photograph are displayed
Provide Employee First and Last Name
Verify Employee has been added successfully
Close the browser
*/

public class AddEmployee extends CommonMethods {

	@BeforeMethod
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
	@Test
	public void addEmployee() throws InterruptedException {
		
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		Thread.sleep(3000);
		
		boolean fullNameDisplayed = driver.findElement(By.className("hasTopFieldHelp")).isDisplayed();
		
		SoftAssert validation = new SoftAssert();
		validation.assertTrue(fullNameDisplayed, "Full Name is NOT displayed");
		
		boolean empIDDisplayed = driver.findElement(By.xpath("//label[@for='employeeId']")).isDisplayed();
		validation.assertTrue(empIDDisplayed,"Employee id is NOT displayed");
		
		boolean photoDisplayed = driver.findElement(By.xpath("//label[@for='photofile']")).isDisplayed();
		validation.assertTrue(photoDisplayed,"Photograph field is NOT displayed");
		
		driver.findElement(By.id("firstName")).sendKeys("Anna");
		driver.findElement(By.id("lastName")).sendKeys("Wilson");
		driver.findElement(By.id("btnSave")).click();
		
		String name = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		
		validation.assertEquals(name, "Anna Wilson","Employee is NOT added");
		
		validation.assertAll();
	}
}
