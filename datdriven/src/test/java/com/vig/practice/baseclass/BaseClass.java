package com.vig.practice.baseclass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Properties p;
	public Logger logger;
	
	
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"browser"})
	public void setUp(String br) throws IOException {
		
		//loading property file//
		
		
		 FileReader file=new FileReader("./src/test/resources/config.properties"); 
		 p=new Properties();
		 p.load(file);
		 
		 
		
		logger=LogManager.getLogger(this.getClass());
		switch (br.toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();		
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		default: System.out.println("Invalid browser");
			return;
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appurl"));
	}
	
	
	  @AfterClass(groups= {"sanity","regression","master"})
	  
	  public void tearDown() {
	  
	  driver.quit(); }
	  
	  public String captureScreen(String tname) throws IOException {
		  String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  File srcfile=ts.getScreenshotAs(OutputType.FILE);
		  
		  String targetfilepath=System.getProperty("user.dir")+"\\snaps\\"+tname+"_"+timestamp+".png";
		  File targetfile= new File(targetfilepath);
		  
		  srcfile.renameTo(targetfile);
		  
		return targetfilepath;
		  
	  }
	 
}
