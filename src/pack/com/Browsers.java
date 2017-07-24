package pack.com;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.nio.channels.Selector;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Browsers  {
	public static WebDriver wd;
	@BeforeMethod
	static public void common()
	{
		System.out.println("Testing started.. for to open JKT map and taking SS");
	/*	ExtentReports ext=new ExtentReports("‪D:\\Automation Projects\\test.html",true);
		ext.loadConfig(new File("‪D:\\Automation Projects\\test.xml"));*/
		System.setProperty("webdriver.geckodriver.driver", "‪D:\\Automation Projects\\geckodriver-v0.17.0-win64.zip");
		//System.setProperty("webdriver.chrome.driver", "‪D:/Automation Projects/chromedriver_win32.zip");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
	
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Projects\\chromedriver.exe");
		wd=new ChromeDriver(options);
	
		
	}
	@Test
	static public void tc1() throws InterruptedException
	{
		
		System.out.println("Test Starting");
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		wd.get("https://www.makemytrip.com/");
		wd.findElement(By.id("hp-widget__sfrom")).click();
		wd.findElement(By.cssSelector(".input_fromto.ui-autocomplete-input")).click();
		  Thread.sleep(2000);
	    wd.findElement(By.cssSelector("#ui-id-57 > div > p:nth-child(1) > span.autoCompleteItem__label")).click();
	      Thread.sleep(2000);
	    wd.findElement(By.id("hp-widget__sTo")).click();
	      Thread.sleep(2000);
	    wd.findElement(By.cssSelector("#ui-id-101 > div > p:nth-child(1) > span.autoCompleteItem__label")).click();
          Thread.sleep(2000);
        wd.findElement(By.cssSelector(".ui-state-default")).click();
   	      Thread.sleep(5000);
   	    wd.findElement(By.partialLinkText("Next")).click();
   	      Thread.sleep(5000);
   	    wd.findElement(By.partialLinkText("25")).click();
   	    wd.findElement(By.id("searchBtn")).click();
	      Thread.sleep(15000);
	}
	@Test
	static public void tc2() throws InterruptedException
	{

		
		JavascriptExecutor js = (JavascriptExecutor)wd; 
		js.executeScript("scroll(0,1000)");
		Thread.sleep(5000);
/*		js.executeScript("scroll(0,800)");*/
		WebElement slider=wd.findElement(By.xpath("//*[@id='price_slider']/a"));
	Actions act=new Actions(wd);
	 act.dragAndDropBy(slider, -70, 0).build().perform();
      Thread.sleep(10000);
  	JavascriptExecutor js1 = (JavascriptExecutor)wd; 
	js1.executeScript("scroll(0,100)");
      act.dragAndDropBy(slider, 50, 0).build().perform();
      Thread.sleep(20000);
	}
	@AfterMethod(dependsOnMethods={"common","before"})
	static public void after()
	{
		wd.quit();
		System.out.println("Test Ending");
	}
}