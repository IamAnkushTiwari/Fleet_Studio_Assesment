package utility;


import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Browser;
import pom.TS001_Main_Page_Digital_Law_Suit;


public class Utility  {
	
	
	public static boolean isElementVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}
	
	public static void hover(WebDriver driver,WebElement ele) {
		
		Actions action = new Actions(driver);
		
		action.moveToElement(ele);
		
	}
	
	public static void writeExcel(Object[][] input) throws IOException{
		
		XSSFWorkbook wrWorkbook = new XSSFWorkbook();

		XSSFSheet sheet = wrWorkbook.createSheet("Info");
		
		
		Object empdata[][] = input;
		
		int rows = empdata.length;
		int cols = empdata[0].length;
		
	//	System.out.println(rows+" "+cols);
	
	for(int r= 0;r<rows;r++) {
		XSSFRow row = sheet.createRow(r);
		for(int c=0;c<cols;c++) {
			
			XSSFCell cell = row.createCell(c);
			Object value = empdata[r][c];
			
			if(value instanceof String)
				cell.setCellValue((String)value);
			if(value instanceof Integer)
				cell.setCellValue((Integer)value);
			if(value instanceof Boolean)
				cell.setCellValue((Boolean)value);
		}
	}
	String path = ".\\src\\main\\resources\\TestData.xlsx";
	
	FileOutputStream outstream = new FileOutputStream(path);
	wrWorkbook.write(outstream);
	outstream.close();
	System.out.println("Data Captured successfully");
	}
	

	
			
	}

