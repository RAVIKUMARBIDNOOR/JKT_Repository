package datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadingData {
	@SuppressWarnings("deprecation")
	@Test
	public void test() throws IOException,FileNotFoundException,NullPointerException
	{
		File file=new File("D:\\Automation Projects\\TestData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		Iterator<Row> itrow= sheet.iterator();
		while(itrow.hasNext())
		{
			Row row=itrow.next();
			Iterator<Cell> cell=row.cellIterator();
			while(cell.hasNext())
			{
				Cell cell1=cell.next();
				
				switch(cell1.getCellType())
				{
				case Cell.CELL_TYPE_BLANK:
					System.out.println(cell1.getBooleanCellValue());
					break;
				case Cell.CELL_TYPE_STRING:
					System.out.println(cell1.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.println(cell1.getNumericCellValue());
					break;
				}
			}
		}
		
	           }
	       
	        }
		
		 /* Iterator<Row> iterator = sheet.iterator();
	         
	        while (iterator.hasNext()) {
	            Row nextRow = iterator.next();
	            Iterator<Cell> cellIterator = nextRow.cellIterator();
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                //System.out.println(cell.getNumericCellValue());
	                 
	                switch (cell.getCellType()) {
	                    case Cell.CELL_TYPE_STRING:
	                        System.out.print(cell.getStringCellValue());
	                        break;
	                    case Cell.CELL_TYPE_BOOLEAN:
	                        System.out.print(cell.getBooleanCellValue());
	                        break;
	                    case Cell.CELL_TYPE_NUMERIC:
	                        System.out.print(cell.getNumericCellValue());
	                        break;
	                }
	                System.out.print(" - ");
	            }
	            System.out.println();*/
	 
		/*String ss=sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(ss);
		
		
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

		   

		    for (int i = 0; i < rowCount+1; i++) {

		        Row row = sheet.getRow(i);

		

		        for (int j = 0; j < row.getLastCellNum(); j++) {

		            //Print Excel data in console
                   
		           String sd= row.getCell(j).getStringCellValue();
		            
		           System.out.println(sd);
		           
                   }}}}
                   
                   
                   Iterator<Row> itrow=sheet.iterator();
		while(itrow.hasNext()){
			Row nextrow=itrow.next();
	        Iterator<Cell> cellit=nextrow.cellIterator();
	        while(cellit.hasNext())
	        {
	        	Cell cell=cellit.next();
	        switch(cell.getCellType())
	        {
	        case Cell.CELL_TYPE_STRING:
	        System.out.print(cell.getRichStringCellValue());
	        break;
	        case Cell.CELL_TYPE_NUMERIC:
	        System.out.println(cell.getNumericCellValue());
	        break;
	        case Cell.CELL_TYPE_BOOLEAN:
	        System.out.println(cell.getBooleanCellValue());
	        break;
            }
            System.out.println();
                  
*/
		


	
		   
