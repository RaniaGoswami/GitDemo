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
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass1 {
	
	public static Properties config;
	public static Properties PropertyFile;
	public static WebDriver driver;
	
	public static void openBrowser() throws IOException {
		
		config = new Properties();
		PropertyFile = new Properties();
		FileInputStream file1 = new FileInputStream(System.getProperty("user.dir")+File.separator+"config"+File.separator+"config.properties");
		config.load(file1);
		FileInputStream file2 = new FileInputStream(System.getProperty("user.dir")+File.separator+"Properties"+File.separator+"PropertyFile.properties");
		PropertyFile.load(file2);
		
		if(config.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+File.separator+"geckodriver.exe");
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myProfile = profile.getProfile("abcProfile");
			driver = new FirefoxDriver();
			driver.get(config.getProperty("url"));
		}
		else if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(config.getProperty("url"));
		}
		else if(config.getProperty("browser").equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+File.separator+"IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(config.getProperty("url"));
		}
		else
			System.exit(0);
		
		
	}
   public static WebElement getData(String xpathKey) {
	    return driver.findElement(By.xpath(config.getProperty(xpathKey)));
   }
   
   public static WebElement visibilityOfElement(WebDriver driver,int timeout,WebElement element,String xpathKey) {
	   element = BaseClass.getData(xpathKey);
	   return new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
   }
   
   public static void sendKeys(WebElement element,String xpathKey,int timeout,WebDriver driver,String inputData) {
	   element = BaseClass.getData(xpathKey);
	   new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
	   element.sendKeys(inputData);
   }
   
   public static void clickOn(WebElement element,String xpathKey,int timeout,WebDriver driver) {
	   element = BaseClass.getData(xpathKey);
	   new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
   }
   
   public static void scroll_Down_Specific_Element(String xpathKey) {
	   JavascriptExecutor jse = (JavascriptExecutor)driver;
	   WebElement element =  BaseClass.getData(xpathKey);
	   jse.executeScript("arguments[0].scrollIntoView(true);", element);
   }
   public static void scroll_Down_Bottom_Page() {
	   JavascriptExecutor jse= (JavascriptExecutor)driver;
	   jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
   }
   
   public static void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)");
   }
}
