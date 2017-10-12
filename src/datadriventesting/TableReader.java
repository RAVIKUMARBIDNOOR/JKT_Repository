package datadriventesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TableReader {
	WebDriver wd;
	@Test
	public void readcolumn()
	{
		System.out.println("Testing started..");
		System.setProperty("webdriver.geckodriver.driver", "‪D:\\Automation Projects\\geckodriver-v0.17.0-win64.zip");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Projects\\chromedriver.exe");
		wd=new ChromeDriver(options);
		System.out.println("Test Starting");
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().window().maximize(); 
		wd.get("http://money.rediff.com/gainers/bsc/daily/groupa?");
		List <WebElement> col = wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println("No of cols are : " +col.size()); 
		 List <WebElement> rows = wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]")); 
	    System.out.println("No of rows are : " + rows.size());
	    List <WebElement> Cells = wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td")); 
        System.out.println("No of Cells are : " + Cells.size());
        WebElement we=wd.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr[2]/td[1]"));
        System.out.println(we.getText());
		wd.close();
		System.out.println("Test is Ended");
	}

}
