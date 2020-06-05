package org.iit.mmp.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	
   public static String generateRandom(int n,int range)
	{
		String str = "";
		for(int j = 0 ; j < 5;j++)
		{
				str = str+ 9;	 
		}
		System.out.println(str);
			
		return str+new Random().nextInt(range);
	}
	public static String getFutureDate(int days,String pattern)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		
		Date d = cal.getTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(d);
		return date;
	}
	public static String getFutureDate(int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		
		Date d = cal.getTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		String date = sdf.format(d);
		return date;
	}
	 
	/*public static String[][] readXls(String FilePath) throws IOException {
	
	String filePath = System.getProperty("user.dir")+"\\data\\MMP_testdata_patientlogin.xls";
	File file =new File(filePath);

    FileInputStream inputStream = new FileInputStream(file);
    Workbook workbook=new HSSFWorkbook(inputStream);
//Read sheet inside the workbook by its name

Sheet sheet = workbook.getSheet("sheet1");

//Find number of rows in excel file

int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

//Create a loop over all the rows of excel file to read it

for (int i = 0; i < rowCount+1; i++) {

    Row row = sheet.getRow(i);

    //Create a loop to read cell values in a row

    for (int j = 0; j < row.getLastCellNum(); j++) {

       

       String cellDate=row.getCell(j).getStringCellValue()+"|| ";

    }

    System.out.println();
}
return null;

		
}



	public static String[][] readXLSXFile(String fileName) throws IOException {
		String filePath = System.getProperty("user.dir")+"\\data\\MMP_testdata_patientlogin.xlsx";
		File file =new File(filePath);
	    FileInputStream inputStream = new FileInputStream(file);
	    Workbook workbook=new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
					
		for (int i = 0; i < rowCount+1; i++) {

	        Row row = sheet.getRow(i);

	        //Create a loop to read cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	           

	           String cellDate=row.getCell(j).getStringCellValue()+"|| ";

	        }

	        System.out.println();
	    }
		return null; 
	}*/
		
	 
}









