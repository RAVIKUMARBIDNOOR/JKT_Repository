package pack.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TextonWebpage {
	//WebDriver wd;
	@Test
	public void testing()
	{
	/*System.out.println("Testing started.. for to open JKT map and taking SS");
		System.setProperty("webdriver.geckodriver.driver", "‪D:\\Automation Projects\\geckodriver-v0.17.0-win64.zip");
		//System.setProperty("webdriver.chrome.driver", "‪D:/Automation Projects/chromedriver_win32.zip");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Projects\\chromedriver.exe");
		wd=new ChromeDriver(options);
		System.out.println("Test Starting");
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		wd.get("https://www.makemytrip.com/");
        String s=wd.getPageSource().substring(2);
        System.out.println(s);
       List<WebElement> we= wd.findElements(By.tagName("span"));*/
		System.out.println("Testing started.. for to open JKT map and taking SS");
		System.setProperty("webdriver.geckodriver.driver", "‪D:\\Automation Projects\\geckodriver-v0.17.0-win64.zip");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Projects\\chromedriver.exe");
		WebDriver wd=new ChromeDriver(options);
		System.out.println("Test Starting");
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().window().maximize(); 
	   //wd.get("http://www.goole.com");
		wd.navigate().to("file:///C:/Users/ravi.bidnoor/Desktop/TestPage.html");
		
		JavascriptExecutor js= (JavascriptExecutor)wd;
		 WebElement element = wd.findElement(By.cssSelector("#gmail-address-label > strong"));
		String s7=(String)js.executeScript("return getComputedStyle(arguments[0]).getPropertyValue('font-Weight');", element);
		  if(s7.trim().equals("bold"))
		  {
			  System.out.println("Is bold");
		  }
		  else
		  {
			  System.out.println("its not bold"+s7);
		  }
	}
		
		/* Page Code for above bold word finding on webpage
		<div class="form-element email-address" id="gmail-address-form-element">
  <label id="gmail-address-label">
  <strong>
  Choose your username
  </strong>
  <input type="text" maxlength="30" autocomplete="off"  
  name="GmailAddress" id="GmailAddress" value=""
spellcheck="false">
  <span class="atgmail">@gmail.com</span>
  </label>
		 
		 */

}
			
	

