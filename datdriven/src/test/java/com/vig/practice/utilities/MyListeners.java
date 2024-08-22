package com.vig.practice.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vig.practice.baseclass.BaseClass;

public class MyListeners implements ITestListener{
	
	public ExtentSparkReporter reporter;
	public ExtentReports extent;
	public ExtentTest test;

	String repName;
	
	 public  void onStart(ITestContext context) {
		 
		 String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 
		 repName =" Test-Report-"+timeStamp+".html";
		 
		 reporter=new ExtentSparkReporter("./extreport/"+repName);
		 reporter.config().setDocumentTitle("Application Automation report");
		 reporter.config().setReportName("Functional testing");
		 reporter.config().setTheme(Theme.DARK);
		 
		 extent=new ExtentReports();
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Application", "App");
		 extent.setSystemInfo("Module", "Registration");
		 extent.setSystemInfo("TesterName", System.getProperty("TesterName"));
		 extent.setSystemInfo("Environment", "QA");
		 
		 String os= context.getCurrentXmlTest().getParameter("OS");
		 extent.setSystemInfo("Operating System", os);
		 
		 String browser=context.getCurrentXmlTest().getParameter("chrome");
		 extent.setSystemInfo("Browser", browser);
		 
		 List<String> includedgroups=context.getCurrentXmlTest().getIncludedGroups();
		 
		 if(!includedgroups.isEmpty()) {
			 extent.setSystemInfo("groups", includedgroups.toString());
		 }
		    
		  }
	 
	 public void onTestSuccess(ITestResult result) {
		 
		 test= extent.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		 
		 test.log(Status.PASS,result.getName()+"_"+"Successfully passed");
		    
		  }
	 
	 public void onTestFailure(ITestResult result) {
		 
		 test= extent.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.FAIL,result.getName()+"_"+"FAILED");
		 test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String impPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(impPath);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		 
		  }
	 public  void onTestSkipped(ITestResult result) {
		 
		 test= extent.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.SKIP,result.getName()+"_"+"skipped");
		 test.log(Status.INFO, result.getThrowable().getMessage());
		    
		  }
	 
	 public  void onFinish(ITestContext context) {
		 
		 extent.flush();
		 
		
		    
		  }
}
