package test.excel.read.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;



public class ReadExcel {
	
	public static void main(String args[]) throws IOException{
		File file = new File(System.getProperty("user.dir")+File.separator+"testExcel.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		int sheetNumber = wb.getActiveSheetIndex();
		System.out.println("Total sheet number "+(sheetNumber+1));
		int last_Row_Count = sheet1.getLastRowNum();
		System.out.println("Last Row Number Count "+last_Row_Count);
		
		for(int r=0;r<last_Row_Count;r++) {
			int last_Col_Count = sheet1.getRow(r).getLastCellNum();
			System.out.println("Last column count is "+last_Col_Count);
			for(int c = 0;c<last_Col_Count;c++) {
				String data = sheet1.getRow(r).getCell(c).getStringCellValue();
				//BaseClass.driver.findElement(By.xpath(BaseClass.propertyFile.getProperty("Error_message_in_Incorrect_Login"))).sendKeys(data);
				System.out.println("data is "+ data);
			}
		}
		
	}
}
