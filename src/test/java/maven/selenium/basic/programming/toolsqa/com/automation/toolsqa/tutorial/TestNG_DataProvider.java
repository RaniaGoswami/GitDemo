package maven.selenium.basic.programming.toolsqa.com.automation.toolsqa.tutorial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DataProvider {
	@DataProvider(name = "searchProvider")
	public Object[][] getData(){
		Object a[][] = new Object[3][2];
		
		a[0][0] = "hello1";
		a[0][1] = "hello2";
		a[1][0] = "hello3";
		a[1][1] = "hello4";
		a[2][0] = "hello5";
		a[2][1] = "hello6";
		return a;
		}
	@Test(dataProvider = "searchProvider")
	public void getDataFromDataProvider(String username,String password) {
		System.out.println("username " + username);
		System.out.println("password " + password);
		
	
}
}
