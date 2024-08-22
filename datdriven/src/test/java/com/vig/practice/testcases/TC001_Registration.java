package com.vig.practice.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vig.practice.baseclass.BaseClass;
import com.vig.practice.pageobjects.RegisterPage;

public class TC001_Registration extends BaseClass{
	
	
	
	@Test(groups= {"regression","master"})
	
	public void createUser() throws InterruptedException {
		
		logger.info("*********Starting test**********");
		
		RegisterPage rp=new RegisterPage(driver);	
		
		
		rp.clickMyAccount();
		
		logger.info("*********Clicking register**********");
		rp.clickRegister();
		
		Thread.sleep(5000);
		logger.info("*********Entering name**********");
		rp.enterFistName(randomString().toUpperCase());
		rp.enterLastName(randomString().toUpperCase());
		
		Thread.sleep(5000);
		
		logger.info("*********Entering mail**********");
		rp.enterEmail(randomString()+"@gmail.com");
		
		Thread.sleep(5000);
		
		logger.info("*********Entering phone**********");
		rp.enterPhone(randomNumeric());
		
		Thread.sleep(5000);
		
		String pass= alphaNumeric();
		/* logger.info("*********Entering password**********"); */
		rp.enterPassword(pass);
		
		rp.enterconfirmPassword(pass);
		
		logger.info("*********Clicking policy**********");
		rp.clickOnPolicy();
		Thread.sleep(5000);
		
		logger.info("*********Clicking continue**********");
		rp.clickContinue();
		Thread.sleep(5000);
		String act=rp.titleofPage();
		if(act.equals("Your Account Has Been Created!")){
			Assert.assertTrue(true);
		}
		else {
			
			Assert.fail();
		}
		
		logger.info("*********finished register**********");
	}
	
	public String randomString() {
		String genr=RandomStringUtils.randomAlphabetic(6);
		return genr;
		
	}
	
	public String randomNumeric() {
		String num=RandomStringUtils.randomNumeric(10);
		return num;
	}
	
	public String alphaNumeric() {
		String gen=RandomStringUtils.randomAlphabetic(5);
		String num1=RandomStringUtils.randomNumeric(3);
		return (gen+"$"+num1);
		
	}

}
