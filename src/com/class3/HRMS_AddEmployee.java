package com.class3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.yaml.snakeyaml.scanner.Constant;

import com.utils.CommonMethods;
import com.utils.Constants;
/*
 * Open chrome browser
Go to "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login"
Login into the application
Add 5 different Employees and create login credentials by providing: 
First Name
Last Name
Username
Password
Provide Employee First and Last Name
Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
Close the browser
Specify group for this test case, add it into specific suite and execute from xml file.


*/

public class HRMS_AddEmployee extends CommonMethods{
	
	@BeforeMethod(alwaysRun = true)
	public void openBrowserAndLogin() {
		setUp("chrome",Constants.HRMS_URL);
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
	}
	@Test(groups = {"add"})
	public void add() {
		System.out.println("I am in group add");
	}
	
	@Test(groups = {"addEmployee"},dataProvider = "getData")
	public void addEmployee(String firstName,String lastName,String userName,String password) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_addEmployee")));
		
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='head']/h1")));
	
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("chkLogin")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")));
		driver.findElement(By.id("user_name")).sendKeys(userName);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("re_password")).sendKeys(password);
		driver.findElement(By.id("btnSave")).click();	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='profile-pic']/h1")));
		String name = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		
		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(name, firstName+" "+lastName, "Name dos NOT match");
		assertion.assertAll();
		
		if(name.equals(firstName+" "+lastName)) {
			System.out.println(name+" successfully added");
		
			TakesScreenshot ts = (TakesScreenshot)driver;
			File screenShot = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenShot, new File("screenshots/HRMS/AddEmployeee/"+firstName+lastName+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@DataProvider
	public Object getData() {
		Object [][] data = {
				{"Samanta","Jones","sjones","1smJ*$12"},
				{"Ammy","Gibson","agibson","99AZ!#gb"},
				{"Zoe","Scott","zoescott","zs12&^HM"},
				{"Chris","Bond","chrisbond","Bond07<*"},
				{"Jasmine","Wright","jasmine","wR!345L*m"}
		};
		return data;
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
	
}
