package datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadingData1 
{
	@Test(dataProvider="getdata")
	public static void setData(String usn ,String pwd )
	{
		System.out.println();
		System.out.println();
	}
	
	        
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="Ravi";
		data[0][1]="kumar";
		data[1][0]="ravi";
		data[1][1]="Bidnoor";
		return data;
	}
	}
