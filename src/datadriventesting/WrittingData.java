package datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class WrittingData {
	@Test
	public void writting() throws IOException
	{
		System.out.println("Testing started.. for to open JKT map and taking SS");
		System.setProperty("webdriver.geckodriver.driver", "‪D:\\Automation Projects\\geckodriver-v0.17.0-win64.zip");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Projects\\chromedriver.exe");
		WebDriver wd=new ChromeDriver(options);
		System.out.println("Test Starting");
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().window().maximize(); 
	    wd.get("http://www.goole.com");
	    String s=wd.getPageSource();
		File file=new File("D:\\Automation Projects\\TestData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		Iterator<Row> row= sheet.iterator();
		while(row.hasNext())
		{
			Row row1=row.next();
			Iterator<Cell> cell=row1.cellIterator();
			while(cell.hasNext())
			{
				Cell cell1=cell.next();
				switch(cell1.getCellType())
				{
				case Cell.CELL_TYPE_STRING:
					System.out.println(cell1.getStringCellValue());
					break;
				
				}
				{
					
				}
			}
		}
		Cell searchText = sheet.getRow(0).getCell(0);
		searchText.setCellValue(s);
		FileOutputStream fos=new FileOutputStream("D:\\Automation Projects\\TestData.xlsx");
		wb.write(fos);
		wb.close();
	}

}
