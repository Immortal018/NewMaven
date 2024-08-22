package com.vig.practice.utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataExcel {
	
	@Test(dataProvider = "log")
	public void ff(String[] fff) {
		
		System.out.println(fff[0]);
		System.out.println(fff[1]);
		
	}
	
	@DataProvider(name="log")
	
	public String[][] getData(){
		
		ExcelLibrary gg=new ExcelLibrary("./testData/logindat.xlsx");
		String[][] getlog= gg.getExcelData("Sheet1");
		
		return getlog;
		
	}

}
