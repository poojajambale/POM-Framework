package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "pass")
	WebElement password;
	
	@FindBy(name = "login")
	WebElement login;
	
	public void enterEmail(String emailId) {
		email.clear();
		email.sendKeys(emailId);
	}
	
	public void enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public boolean verifyLoginPage() {
		String actTitle = driver.getTitle();
		String expTitle = "Log in to Facebook";
		return actTitle.endsWith(expTitle);
	}
	
	public HomePage validLogin(String emailId, String pass) {
		enterEmail(emailId);
		enterPassword(pass);
		clickLogin();
		return new HomePage(driver);
	}
	
	public void invalidLogin(String emailId, String pass) {
		enterEmail(emailId);
		enterPassword(pass);
		clickLogin();
	}
}
