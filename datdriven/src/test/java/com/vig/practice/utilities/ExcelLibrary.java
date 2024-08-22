package com.vig.practice.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	
	String filepath;
	
	public ExcelLibrary(String filepath) {
		
		this.filepath=filepath;
		
		
	}
	
	public String[][] getExcelData(String sheetname) {
		
	try {
		FileInputStream fis= new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s= wb.getSheet(sheetname);
		int lastrowNum=s.getLastRowNum();
		int lastcellnum=s.getRow(0).getLastCellNum();
		
		String[][] data=new String[lastrowNum][lastcellnum];
		for (int i = 1; i <= lastrowNum ; i++) {
			Row r = s.getRow(i);
			for (int j = 0; j < lastcellnum; j++) {
				Cell c = r.getCell(j);
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(c);
				data[i-1][j]=value;
			}
			
			}
		fis.close();
		return data;
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	

}
}
