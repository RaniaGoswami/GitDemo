package maven.selenium.basic.programming.toolsqa.com.automation.toolsqa.tutorial;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Test {

	/*@BeforeSuite
	public void beforeSuiteMethod() {
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("Before Test");
	}
	
	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("Before Class");
	}*/
	
	@Test(groups = {"Car"})
	public void beforeMethodMethod() {
		System.out.println("Before Method");
	}
	@Test(groups = {"scooter"})
	public void testMethod1() {
		System.out.println("test method");
	}
	@Test(groups = {"Car"})
	public void testMethod2() {
		System.out.println("test method");
	}
	@Test(groups = {"scooter"})
	public void afterMethodMethod() {
		System.out.println("after Method");
	}
	@Test(groups = {"scooter","Car"})
	public void bothMethod() {
		System.out.println("both Method");
	}
	/*@AfterClass
	public void afterClassMethod() {
		System.out.println("After Class");
	}
	@AfterTest
	public void afterTestMethod() {
		System.out.println("After Test");
	}
	@AfterSuite
	public void afterSuiteMethod() {
		System.out.println("after suite");
	}*/
}
