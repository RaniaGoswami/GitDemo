package maven.selenium.basic.programming.toolsqa.com.automation.toolsqa.tutorial;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Test2 {
	@Parameters({"username","password"})
	@Test(dependsOnMethods = {"testMethod3"})
	public void beforeMethod2(String username,String password) {
		System.out.println(username);
		System.out.println(password);
		System.out.println("second Method");
	}
	@Test
	public void testMethod3() {
		System.out.println("first method");
	}
	@Test(dependsOnMethods = {"afterMethod2"})
	public void testMethod4() {
		System.out.println("fourth method");
	}
	@Test(dependsOnMethods = {"testMethod3"})
	public void afterMethod2() {
		System.out.println("third Method");
	}

}
