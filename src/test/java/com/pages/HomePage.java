package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v124.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyTitle() {
		String actTitle = driver.getTitle();
		String expTitle = "Facebook";
		return actTitle.equals(expTitle);
	}
}
