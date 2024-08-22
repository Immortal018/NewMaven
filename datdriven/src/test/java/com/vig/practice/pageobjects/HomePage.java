package com.vig.practice.pageobjects;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	
	public void clickMyAccount() {
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
	}
public void clickRegister() {
		
		driver.findElement(By.xpath("//a[text()='Register']")).click();
	}
	
	public void clickOnLogin() {
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		}
	
	
}
