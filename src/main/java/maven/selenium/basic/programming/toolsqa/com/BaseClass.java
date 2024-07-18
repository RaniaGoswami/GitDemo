package maven.selenium.basic.programming.toolsqa.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BaseClass 
{
 
	public static WebDriver driver;
	public static Properties config;
	public static Properties propertyFile;
	
	public static void openBrowser() throws IOException {
		
		config = new Properties();
		
		
		propertyFile = new Properties();
		
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+File.separator+"config"+
		File.separator+"config.properties");
		
		
		FileInputStream propFile = new FileInputStream(System.getProperty("user.dir")+File.separator+"Properties"+
				File.separator+"propertyFile.properties");
		
		
		config.load(file);
		propertyFile.load(propFile);
		
		if(config.getProperty("browser").equalsIgnoreCase("firefox")){
			
			driver = new FirefoxDriver();
			driver.get(config.getProperty("url"));
		}
			
		else if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rania\\eclipse-workspace\\com.automation.toolsqa.tutorial\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(config.getProperty("url"));
			}
		else if (config.getProperty("browser").equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+File.separator+"com.automation.toolsqa.tutorial");
			//System.setProperty("webdriver.ie.driver", "C://Users//Rania//eclipse-workspace//com.automation.toolsqa.tutorial");
			driver = new InternetExplorerDriver();
			driver.get(config.getProperty("url"));		
		}
		
	}
	
	public static WebElement getData(String xpathkey) {
		//System.out.println(propertyFile);
		WebElement element = driver.findElement(By.xpath(propertyFile.getProperty(xpathkey)));
		return element;
	}
	
	public static void visibilityOfElement(WebDriver driver,int timeout,String xpathKey,WebElement element) {
		element = BaseClass.getData(xpathKey);
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));	
	}	
	
	
	public static void scroll_down(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(0,250)");
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void scroll_Down_bottom_page() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	
	public static void scroll_Up() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)");
	}
	
	public  static void sendKeysUsingJavaScriptExecutor(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='12345';", element);
	}
	
}
