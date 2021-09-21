package Demo.Demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteTouchScreen;
import org.openqa.selenium.support.ui.Select;


import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class BasicSetup 
{

	public static WebDriver driver = null;
	public static String baseUrl = "https://www.saucedemo.com/";
	public static String UserDirectory = System.getProperty("user.dir");
	{ System.setProperty("atu.reporter.config", UserDirectory+"\\library\\atu.properties"); }
	{ System.setProperty("webdriver.chrome.driver",UserDirectory+"\\library\\chromedriver.exe"); }

	public static void setup() {
		try 
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--disable-infobars");
			options.addArguments("--no-proxy-server");
			options.addArguments("--ignore-certificate-errors");
			//options.addArguments("--start-fullscreen");
			driver = new ChromeDriver(options);
			
			driver.get(baseUrl);	
			
			
			
			ATUReports.setWebDriver(driver);
			ATUReports.indexPageDescription = "Demo Application";
			ATUReports.add("Chrome Browser", "Chrome" , "Chrome Application should launch", "Chrome Application should be launched", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
			
		}
		catch(Exception e){
			e.printStackTrace();
		} finally {
		}
	}

	
	public static void wait(int Seconds)
	{
		int sec = Seconds * 1000;
		try {
			Thread.sleep(sec);
			ATUReports.add("WaitForSeconds", Seconds+" Seconds", "Should wait", "Waiting is done successfully", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

	public static void Click(WebDriver driver,String Element) {
		WebElement NextButtonEnabled = driver.findElement(By.xpath(Element));				
		NextButtonEnabled.click();
		wait(1);
		ATUReports.add("Click By Xpath", "Should Click","", "Should be Clicked",LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));
	}	

	public static void JsClick(WebDriver driver,String Element) {
		WebElement NextButtonEnabled = driver.findElement(By.xpath(Element));				
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextButtonEnabled);
		//wait(driver, "1");
		ATUReports.add("Click By Xpath", "Should Click","", "Should be Clicked",LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));

	}	

	public static void ActionClick(WebDriver driver,String Element) {
		WebElement  element = driver.findElement(By.xpath(Element));             
		//Actions act=new Actions(driver);
		//act.moveToElement(element).click().perform();
		//wait(driver, "1");
		ATUReports.add("Click By Xpath", "Should Click","", "Should be Clicked",LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));

	}	

	public static void Submit(WebDriver driver,String Element) {
		WebElement element = driver.findElement(By.xpath(Element));	
		element.submit();
		ATUReports.add("Submit", "Should Submit","", "Should be Submit",LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));
	}

	public static String Type(WebDriver driver,String Element, String InputData) {
		WebElement element = driver.findElement(By.xpath(Element));	
		element.sendKeys(InputData);
		//try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		ATUReports.add("Type", InputData+" Should Type","", InputData+" Should be Typed",LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));
		return InputData;
	}

	public static String TypeByID(WebDriver driver,String Element, String InputData) {
		WebElement element = driver.findElement(By.id(Element));	
		element.sendKeys(InputData);
		//try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		ATUReports.add("Type", InputData+" Should Type","", InputData+" Should be Typed",LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));
		return InputData;
	}

	public static String ClearAndType(WebDriver driver,String Element, String InputData) {
		WebElement NextButtonEnabled = driver.findElement(By.xpath(Element));				
		NextButtonEnabled.clear();
		try { Thread.sleep(300); } catch (InterruptedException e) {	e.printStackTrace(); }
		NextButtonEnabled.sendKeys(InputData);
		ATUReports.add("Clear & Type", InputData+" Should Clear & Type","", InputData+" Should be Cleared & Typed",LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));
		return InputData;

	}

	public static void Clear(WebDriver driver,String Element) {
		WebElement NextButtonEnabled = driver.findElement(By.xpath(Element));				
		NextButtonEnabled.clear();
		try { Thread.sleep(300); } catch (InterruptedException e) {	e.printStackTrace(); }	
		ATUReports.add("Clear & Type", "Should Clear & Type","", "Should be Cleared & Typed",LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));
	}
	
	public static String SelectByVisibletext(WebDriver driver,String Element,String inputData) {
		try {
			WebElement element = driver.findElement(By.xpath(Element));
			Select selectBox = new Select(element);
			selectBox.selectByVisibleText(inputData);
			ATUReports.add("Select By Visible Text", "Should Select","", "Should be Selected",LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (Exception e) {			
		}
		return inputData;
	}

	public static String SelectByValue(WebDriver driver,String Element, String inputData) {
		try {
			WebElement element = driver.findElement(By.xpath(Element));
			Select selectBox = new Select(element);
			selectBox.selectByValue(inputData);
			ATUReports.add("Select By Value", "Should Select","", "Should be Selected",LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (Exception e) {
			inputData = "Unable to select selectbox";
			//log.info("Unable to select selectbox: " + element);
		}
		return inputData;
	}
	
	
	public static void MouseOver(WebDriver driver,String Element) {
		WebElement  element = driver.findElement(By.xpath(Element));             
		//Actions act=new Actions(driver);
		//act.moveToElement(element).build().perform();
		wait(2);
		ATUReports.add("MouseOver By Xpath", "Should MouseOver","", "Should be MouseOvered",LogAs.INFO, null);

	}
	
	public static boolean VerifyElementIsPresent(WebDriver driver, String Element){    	
		try {		
			WebElement webElement = driver.findElement(By.xpath(Element));	
			webElement.isDisplayed();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);",webElement, "color: red; border: 3px solid red; font-weight: bold;");
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);",webElement, "");
			
			String Value = webElement.getText();
			ATUReports.add("VerifyElementPresent", "Should Verify","", Value+" Should be Verified",LogAs.INFO, null);
			return true; 
		} catch(NoSuchElementException e)   {
			//log.info("Unable to Displayed WebElement: " + webElement);
			return false;
		}    	    	  
	} 

	public static void Highlight(WebDriver driver, String Element)
	{
		WebElement webElement = driver.findElement(By.xpath(Element));	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);",webElement, "color: red; border: 3px solid red; font-weight: bold;");
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);",webElement, "");

	}
	
	public static void ScrollDown(WebDriver driver)	{
		JavascriptExecutor js111 = (JavascriptExecutor) driver;
		js111.executeScript("window.scrollBy(0,200)"); 
		try { Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		ATUReports.add("Page Scroll Down", "Should ScrollDown","", "Should be ScrollDown",LogAs.INFO, null);
	}
	
	public static void ScrollUp(WebDriver driver)  {
		//((JavascriptExecutor) driver).executeScript("scroll(0,-250);");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, -250)", "");   
		try { Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		ATUReports.add("Page Scroll Up", "Should ScrollUp","", "Should be ScrollUp",LogAs.INFO, null);
	}

	public static void Application_Launch()
	{
		setup();
	}

	public static void Application_Close()
	{
		driver.close();
		driver.quit();
	}

	
}
