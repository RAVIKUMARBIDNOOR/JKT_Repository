package pack.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.openqa.selenium.NoAlertPresentException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

public class SimpleTest {
	@Test
	public void test1() throws InterruptedException
	{
		System.setProperty("webdriver.geckodriver.driver", "‪D:\\Automation Projects\\geckodriver-v0.17.0-win64.zip");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
	
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   
        
        // Alert Message handling
                    		
        driver.get("http://demo.guru99.com/selenium/delete_customer.php");			
                            		
       	
          driver.findElement(By.name("cusid")).sendKeys("53920");					
          driver.findElement(By.name("submit")).submit();
          Thread.sleep(2000);
          Alert alert= driver.switchTo().alert();
          String s=alert.getText();
          System.out.println("Popup text"+s);
          alert.accept();
      
          
		
	}
	
	 {									
		
    }	

}