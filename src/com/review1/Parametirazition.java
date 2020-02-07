package com.review1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parametirazition {

	@Test(dataProvider ="getData")
	public void login(String username, String password) {
		System.out.println(username+": "+password);
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
