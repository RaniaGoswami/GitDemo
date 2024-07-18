package maven.selenium.basic.programming.toolsqa.com.automation.toolsqa.tutorial;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import maven.selenium.basic.programming.toolsqa.com.BaseClass1;



public class AppTest1 {
	@BeforeTest
	public void openURL() throws IOException {
		BaseClass1.dd;
		System.out.println("hello");
		//BaseClass1.driver.manage().window().maximize();
		//BaseClass1.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

}