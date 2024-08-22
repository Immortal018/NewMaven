package com.vig.practice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends HomePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	public void enterEmail(String user) {
		
		driver.findElement(By.id("input-email")).sendKeys(user);
	}
	
	public void enterPass(String pass) {
		driver.findElement(By.id("input-password")).sendKeys(pass);
	}

	public void clickonlogin() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	public String LoginpageTitle() {
		return driver.getTitle();
		
	}
	
	
	 
}

