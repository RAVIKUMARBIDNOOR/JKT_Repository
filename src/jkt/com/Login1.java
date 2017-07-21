package jkt.com;

import java.io.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login1 {

	/**
	 * @throws IOException
	 */
	/**
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException
	{
		// TODO Auto-generated method stub
		System.out.println("Testing started.. for to open JKT map and taking SS");
		System.setProperty("webdriver.geckodriver.driver", "‪D:\\Automation Projects\\geckodriver-v0.17.0-win64.zip");
		//System.setProperty("webdriver.chrome.driver", "‪D:/Automation Projects/chromedriver_win32.zip");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Projects\\chromedriver.exe");
		WebDriver wd=new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		
		wd.get("http://www.Google.com");
	   
	   
//		File source=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
//	    FileUtils.copyFile(source,new File("D:\\SS\\map2.png"));
		wd.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("JKT");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//wd.findElement(By.cssSelector("body")).sendKeys(Keys.ESCAPE);
		wd.findElement(By.cssSelector(".sbico._wtf._Qtf")).click();
		wd.findElement(By.xpath("//*[@id='lu_map']")).click(); 
		
		//WebElement html = driver.findElement(By.tagName("html"));
		//html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
		wd.findElement(By.cssSelector(".gsst_a")).click();
		/*int i=1;
		while(i!=5){
		wd.findElement(By.xpath("//*[@id='widget-zoom-out']/div")).click();
		
		try{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		i++;
		}*/
		int j=1;
		while(j!=5){
		wd.findElement(By.xpath("//*[@id='widget-zoom-in']")).click();
		
		try{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		j++;
		}
		//wd.get("https://www.google.co.in/maps/@12.9201082,77.6708263,20z");
		
	
	   
		//*[@id="widget-zoom-out"]/div
		//*[@id="widget-zoom-in"]
		
		File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(src, new File("C:\\Users\\ravi.bidnoor\\Desktop\\Latest\\7.png"));
		    System.out.println("Testing Ended");
	    wd.close();
		
	}
}
