package com.qa.rtp.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class ExcelUtil {
	
	public static Workbook book;
	public static Sheet sheet;

	public static String RTPTestData_Path="C://Users//manju//workspace//JanPOMFrameWork//JanPOM_FrameWork//src//"
			+ "main//java//com//qa//rtp//testdata//RTPTestData.xlsx";
	
	public static Object[][] getTestdata(String sheetName){
		
		try {
			FileInputStream ip=new FileInputStream(RTPTestData_Path);
			book=WorkbookFactory.create(ip); //we have reached at workbook level, this line will create exact replica of excel data in java memory
			sheet=book.getSheet(sheetName);//Reached at sheet level
			Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		    
			
			for(int i=0;i<sheet.getLastRowNum();i++){
				
				for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
					
					data[i][k]=sheet.getRow(i+1).getCell(k).toString();
					
					
				}
				
					
			}
			
			
			  return data;
			    
		     } catch (InvalidFormatException e) {
				 e.printStackTrace();
			 } catch (FileNotFoundException e) {
			    e.printStackTrace();
			 } catch (IOException e) {
				e.printStackTrace();
			 }
	
		return null;
	}	
}
