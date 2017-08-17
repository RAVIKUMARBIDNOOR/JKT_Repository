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
	public static void test1(String usn,String pwd,String name)
	{
		System.out.println(usn);
		System.out.println(pwd);
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] obj=new Object[2][2];
		
		obj[0][0]="Ravi";
		obj[0][1]="Kumar";
		obj[0][2]="Kumar";
		obj[1][0]="Bidnoor";
		obj[1][1]="Bidnoor";
		obj[1][2]="Bidnoor";
		obj[2][0]="Bidnoor";
		obj[2][1]="Bidnoor";
		obj[2][2]="Bidnoor";
		return obj;
		
	}
	}
