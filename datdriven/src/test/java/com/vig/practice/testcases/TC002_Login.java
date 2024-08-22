package com.vig.practice.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vig.practice.baseclass.BaseClass;
import com.vig.practice.pageobjects.LoginPage;
import com.vig.practice.pageobjects.MyAccountPage;

public class TC002_Login extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void accountLogin() throws InterruptedException {
		
		try{	logger.info("*********Starting test**********");
		
		LoginPage lp=new LoginPage(driver);
		
		logger.info("****entering login page*****");
		
		lp.clickMyAccount();
		lp.clickOnLogin();
		
		
		logger.info("****entering login details*****");
		
		lp.enterEmail(p.getProperty("email"));
		lp.enterPass(p.getProperty("pass"));
		lp.clickonlogin();
		
		logger.info("****entering accountpage*****");
		
		MyAccountPage mcc= new MyAccountPage(driver);
		boolean ss=mcc.isMyaccountPageexists();
		
		Assert.assertTrue(ss);
		
		
		mcc.logout();
		
		logger.info("****logged out*****");
		} catch(Exception e) {
			
			Assert.fail();
		}
	}	

}
