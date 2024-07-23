package maven.selenium.basic.programming.toolsqa.com.automation.toolsqa.tutorial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import maven.selenium.basic.programming.toolsqa.com.*;

public class AppTest{
	@BeforeTest(groups = {"openingURL" ,"firstCall"})
	public void testBrowser() throws IOException {
		
		BaseClass1.openBrowser();
		BaseClass1.driver.manage().window().maximize();
		BaseClass1.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Hello testing for git");
		System.out.println("Hello testing for git");
		
		/*BaseClass.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		BaseClass.driver.manage().deleteAllCookies();	
		/*System.out.println(BaseClass.driver.getTitle());
		String home_page_title = "Free QA Automation Tools Tutorial for Beginners with Examples";
		Assert.assertEquals("Free QA Automation Tools Tutorial for Beginners with Examples", home_page_title);
	*/
	}
	
	/*@Test(priority = 1)
	public void test_AgileAndScrum_Page() throws InterruptedException {
	    /*Actions action = new Actions(BaseClass.driver);
	    Thread.sleep(5000);
	    //action.click(BaseClass.driver.findElement(By.xpath("//li[contains(@class,'menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-17611 has-children dt-hovered show-mega-menu-content')]//span[contains(@class,'menu-text')][contains(text(),'IFrame practice page')]"))).perform();
	    //Thread.sleep(5000);
	    JavascriptExecutor jse = (JavascriptExecutor)BaseClass.driver;
	    jse.executeScript("window.scrollBy(0,250)");
	    int iframe_count = BaseClass.driver.findElements(By.tagName("iframe")).size();
	    System.out.println("iframe_count "+iframe_count);
	    BaseClass.driver.switchTo().frame("IF1");
	    System.out.println("switched to frame");
	    JavascriptExecutor jse1 = (JavascriptExecutor)BaseClass.driver;
	    jse.executeScript("window.scrollBy(0,250)");	    
	    Thread.sleep(5000);
	    BaseClass.driver.findElement(By.xpath("//span[text()='Facebook']")).click();
	    ArrayList<String> tab = new ArrayList<String>(BaseClass.driver.getWindowHandles());
	    System.out.println(tab.size());
	    BaseClass.driver.switchTo().window(tab.get(1));
	    Assert.assertTrue(BaseClass.driver.findElement(By.xpath("//u[text()='Facebook']")).isDisplayed());
		/*action.moveToElement(BaseClass.getData("Home_Page_Tutorial")).perform();
		Thread.sleep(5000);
		action.click(BaseClass.getData("Tutorial_Agile_Scrum")).perform();
		BaseClass.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		BaseClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*BaseClass.visibilityOfElement(BaseClass.driver, 10,"Under_Agile_Page_Agile_Logo" ,BaseClass.getData("Under_Agile_Page_Agile_Logo"));
		BaseClass.getData("Under_Agile_Page_Agile_Logo").click();
		Thread.sleep(5000);
		//BaseClass.getData("Under_Agile_Page_Agile_Logo_close_button").click();
		BaseClass.getData("Under_Agile_Page_Agile_Logo_fullscreen_button").click();
		Thread.sleep(5000);
		Assert.assertEquals("Complete Agile Scrum Tutorial with Easy Examples", BaseClass.driver.getTitle());
		action.sendKeys(Keys.ESCAPE).perform();		*/	
	//}
	
	/*@Test(priority = 2)
	public void test_Twitter_AgileAndScrum_Page() throws InterruptedException {
		BaseClass.scroll_down(BaseClass.getData("Agile_Scrum_Page_Facebook_logo"));
		Thread.sleep(5000);
		BaseClass.scroll_Up();
		Thread.sleep(2000);
		/*BaseClass.getData("Agile_Scrum_Page_Facebook_logo").click();
		Thread.sleep(5000);
		ArrayList<String> tab = new ArrayList<String>(BaseClass.driver.getWindowHandles());
		System.out.println("number of tabs open: " +tab.size());
		BaseClass.driver.switchTo().window(tab.get(1));
		Thread.sleep(5000);
		BaseClass.getData("Login_Button_On_Facebook_Page").click();
		Thread.sleep(1000);
		Assert.assertTrue(BaseClass.getData("Error_message_in_Incorrect_Login").isDisplayed());
		BaseClass.driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123456");
		new WebDriverWait(BaseClass.driver,20).until(ExpectedConditions.
				elementToBeClickable(BaseClass.driver.findElement(By.xpath(BaseClass.propertyFile.getProperty("password_In_Facebook_Page")))));
		BaseClass.getData("password_In_Facebook_Page").click();
		Thread.sleep(2000);
		BaseClass.getData("password_In_Facebook_Page").sendKeys("123456");
		Thread.sleep(2000);
		BaseClass.driver.close();
		Thread.sleep(2000);
		BaseClass.driver.switchTo().window(tab.get(0));
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)BaseClass.driver;
		jse.executeScript("window.scrollBy(0,-250)");
		Thread.sleep(2000);
		System.out.println(BaseClass.driver.getCurrentUrl());*/
	//}
	
	/*@Test
	public void handling_Iframe() throws InterruptedException {
		int size = BaseClass.driver.findElements(By.tagName("iframe")).size();
		System.out.println("number of iframes "+size);
		BaseClass.driver.switchTo().frame(BaseClass.driver.findElement(By.tagName("iframe")));
		/*for(int i=0;i<size;i++) {
			BaseClass.driver.switchTo().frame(i);
			int sizeOfEle = BaseClass.driver.findElements(By.className("img_ad")).size();
			System.out.println("sizeOfEle "+sizeOfEle);
			BaseClass.driver.switchTo().defaultContent();
		}*/
		
		/*Thread.sleep(4000);
		BaseClass.driver.switchTo().frame(1);
		System.out.println("we are in iframe");
		BaseClass.driver.findElement(By.className("img_ad")).click();*/
		
	//}

/*@Test
public void demo_Sites_AutomationPracticeSwitchWindows() throws InterruptedException {
	BaseClass.driver.findElement(By.xpath(BaseClass.propertyFile.getProperty("New_Browser_Window_Under_Demo_Site"))).click();
	Thread.sleep(5000);
	String currentWindow = BaseClass.driver.getWindowHandle();
	Set<String> windows = BaseClass.driver.getWindowHandles();
	
	for(String handle:windows) {
		BaseClass.driver.switchTo().window(handle);
		Thread.sleep(5000);
		BaseClass.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		BaseClass.driver.manage().window().maximize();
		Thread.sleep(2000);
		BaseClass.driver.switchTo().window(currentWindow);
	}
	
	
}*/

	/*@Test
	/*public void handling_Alerts() throws InterruptedException {
		
		//BaseClass.driver.findElement(By.xpath(BaseClass.propertyFile.getProperty("Simple_Alert"))).click();
		JavascriptExecutor jse = (JavascriptExecutor)BaseClass.driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",BaseClass.driver.findElement(By.xpath("//button[contains(text(),'Prompt Pop up')]")));
		Thread.sleep(2000);
		BaseClass.driver.findElement(By.xpath("//button[contains(text(),'Prompt Pop up')]")).click();
		BaseClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//new WebDriverWait(BaseClass.driver,10).until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(2000);
		Alert alert = BaseClass.driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("yes");
		alert.dismiss();
		BaseClass.driver.switchTo().defaultContent();
		Thread.sleep(2000);
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}*/
	
	
/*	public void handling_Webtables() {
		Assert.assertTrue(BaseClass.driver.findElement(By.xpath(BaseClass.propertyFile.getProperty("Sample_Table_In_Handling_Webtable_Page"))).isDisplayed());
		WebElement table = BaseClass.driver.findElement(By.xpath("//table[@class='tsc_table_s13']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("rows count " +rows.size());
		/*List<WebElement> heading = table.findElements(By.tagName("th"));
		System.out.println("heading count " +heading.size());
		List<WebElement> cols = table.findElements(By.tagName("td"));
		System.out.println("column count " +cols.size());*/
		
	/*	for(int r = 0; r<rows.size(); r++ ) {
			//List<WebElement> head = BaseClass.driver.findElements(By.tagName("th"));
			//System.out.println(head.size());
			/*for (int h = 0;h<head.size();h++) {
				System.out.println(rows.get(h).getText());
			}*/
			
			/*List<WebElement> heading = rows.get(r).findElements(By.tagName("th"));
			List<WebElement> cols = rows.get(r).findElements(By.tagName("td"));
			//System.out.println("column size " +cols.size());
			
			for(int h = 0;h<heading.size();h++) {
				System.out.println(heading.get(h).getText());
			}
			for(int c = 0; c<cols.size();c++) {
				System.out.println(cols.get(c).getText());
			}
			
			
		}
		
		
	}*/
	
}