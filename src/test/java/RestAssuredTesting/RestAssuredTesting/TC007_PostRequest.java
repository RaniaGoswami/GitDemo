package RestAssuredTesting.RestAssuredTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;

public class TC007_PostRequest {
	
	@Test(dataProvider = "getData")
	public void postRequest(String id, String employee_name, String employee_salary, String employee_age, String profile_image) {
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		RestAssured.authentication = auth;
		auth.setUserName("");
		auth.setPassword("");
		JSONObject reqBody = new JSONObject();
		reqBody.put("id",id);
		reqBody.put("employee_name",employee_name);
		reqBody.put("employee_salary",employee_salary);
		reqBody.put("employee_age",employee_age);
		reqBody.put("profile_image",profile_image);
	}
	
	@DataProvider
	public String[][] getData() throws IOException {
		File file = new File("C:\\Users\\Rania\\eclipse-workspace\\RestAssuredTesting\\DataProviderRestApi.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wrkbk = new XSSFWorkbook(fis);
		XSSFSheet sheet = wrkbk.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum()+1;
		int colCount = sheet.getRow(0).getLastCellNum();
		String data[][] = new String[rowCount][colCount];
		DataFormatter dataFormat = new DataFormatter();
		for(int i = 1; i<rowCount; i++) {
			for(int j = 0; j<colCount; j++) {
				data[i][j] = dataFormat.formatCellValue(sheet.getRow(i).getCell(j));
				System.out.println(data[i][j]);
			}
		}
		
		for(String empData[]:data) {
			System.out.println(empData);
		}
		fis.close();
		wrkbk.close();
		return data;
	}

}
