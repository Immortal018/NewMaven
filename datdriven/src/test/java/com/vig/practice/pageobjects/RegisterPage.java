package com.vig.practice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends HomePage {
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterFistName(String us1) {
		
		driver.findElement(By.id("input-firstname")).sendKeys(us1);
	}
	
	public void enterLastName(String us2) {
		
		driver.findElement(By.id("input-lastname")).sendKeys(us2);
	}
	
	public void enterEmail(String mail) {
		
		driver.findElement(By.id("input-email")).sendKeys(mail);
	}
	
public void enterPhone(String phone) {
		
		driver.findElement(By.id("input-telephone")).sendKeys(phone);
	}


	public void enterPassword(String pass) {
		
		driver.findElement(By.id("input-password")).sendKeys(pass);
	}
	
	public void enterconfirmPassword(String pass1) {
		
		driver.findElement(By.id("input-confirm")).sendKeys(pass1);
	}
	
	public void clickOnPolicy() {
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	}
	
	public void clickContinue() {
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
	}
	
	public String titleofPage() {
		
		return driver.getTitle();
	}
	
 


}
