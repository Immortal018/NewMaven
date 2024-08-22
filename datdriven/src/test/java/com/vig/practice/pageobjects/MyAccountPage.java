package com.vig.practice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends HomePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	public boolean isMyaccountPageexists() {
		try{
			boolean status=driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed();
			return status;
		}
		catch(Exception e) {
		return false;
		}
		
	}
	
  public void logout() {
		  
		  driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Logout']")).click();
	  
	
	  }

}
