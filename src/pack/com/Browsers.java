package pack.com;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.nio.channels.Selector;
import java.util.List;
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
		System.out.println("Test Starting");
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().window().maximize();
	
	
		
	}
	@Test
	static public void tc1() throws InterruptedException
	{
		
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

		
	/*	JavascriptExecutor js = (JavascriptExecutor)wd; 
		js.executeScript("scroll(0,1000)");
		Thread.sleep(5000);*/
		
		
   /* js.executeScript("scroll(0,800)");*/
		
		//Price range code-------------------
		
		/*WebElement slider=wd.findElement(By.xpath("//*[@id='price_slider']/a"));
	Actions act=new Actions(wd);
	 act.dragAndDropBy(slider, -70, 0).build().perform();
      Thread.sleep(10000);
  	JavascriptExecutor js1 = (JavascriptExecutor)wd; 
	js1.executeScript("scroll(0,100)");
      act.dragAndDropBy(slider, 50, 0).build().perform();
      Thread.sleep(20000);*/
		
		//Multiple check box checking it code-----
		
		/*List<WebElement> allck=wd.findElements(By.cssSelector(".checkbox_state.pull-right"));
		int count=allck.size();
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
		allck.get(i).click();
		Thread.sleep(2000);
		}
		Thread.sleep(10000);*/
		
      wd.findElement(By.cssSelector(".o-c-listing_row__flightD.pull-left.open_icon_mark")).click();
      Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@id='content']/div/div[2]/div[5]/div[2]/div[5]/div/div[5]/ul/li[2]/a")).click();
	  Thread.sleep(2000);
	  wd.findElement(By.cssSelector("#content > div > div.container.ng-scope > div.row > div.main.col-lg-9.col-md-9.col-sm-12.col-xs-12 > div:nth-child(5) > div > div.clearfix.main-div1.first_active.c-listing_row.c-listing_row__details > ul > li:nth-child(3) > a")).click();
	  Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@id='content']/div/div[2]/div[5]/div[2]/div[5]/div/div[5]/ul/li[4]/a")).click();
	  Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@id='content']/div/div[2]/div[5]/div[2]/div[5]/div/div[5]/ul/li[5]/a")).click();
	  Thread.sleep(10000);
	}
	@AfterMethod(dependsOnMethods={"common","before"})
	static public void after()
	{
		wd.quit();
		System.out.println("Test Ending");
	}
}