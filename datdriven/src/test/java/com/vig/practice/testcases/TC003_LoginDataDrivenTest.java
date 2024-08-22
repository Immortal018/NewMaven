package com.vig.practice.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vig.practice.baseclass.BaseClass;
import com.vig.practice.pageobjects.LoginPage;
import com.vig.practice.pageobjects.MyAccountPage;
import com.vig.practice.utilities.DataExcel;

public class TC003_LoginDataDrivenTest extends BaseClass {
	
	@Test(dataProvider = "log", dataProviderClass = DataExcel.class,groups= {"sanity","regression","master"})
	public void datadriventest(String user ,String pass,String exp) {
		
		logger.info("******Starting test*******");
		try {
		LoginPage lp1=new LoginPage(driver);
		
		lp1.clickMyAccount();
		lp1.clickOnLogin();
		lp1.enterEmail(user);
		lp1.enterPass(pass);
		lp1.clickonlogin();
		
		MyAccountPage acc1=new MyAccountPage(driver);
	
		boolean status=acc1.isMyaccountPageexists();
		Assert.assertTrue(status);
		
		if(exp.equalsIgnoreCase("valid")) {
			if(status==true) {
				Assert.assertTrue(true);
				acc1.logout();
			}else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid")) {
			if(status==true) {
				Assert.assertTrue(false);
				acc1.logout();
			}else {
				Assert.assertTrue(true);
			}
		}
		} catch(Exception e) {
			Assert.fail();
		}
		logger.info("******Finished test*******");
	}

}
