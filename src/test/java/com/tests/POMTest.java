package com.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;

public class POMTest extends BaseIntegration{
	
	@Test(dataProvider = "loginData")
	public void doLogin(String tName, String email, String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		
		if(tName.equals("Both are valid")) {
			HomePage home = loginPage.validLogin(email, password);
			Assert.assertTrue(home.verifyTitle());
		}
		else{
			loginPage.invalidLogin(email, password);
			assertTrue(loginPage.verifyLoginPage());
		}
		
		Thread.sleep(2000);
	}
}
