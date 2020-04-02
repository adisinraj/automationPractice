package excelReader;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadSecondSheet {

	public static void main(String[] args) throws Exception, IOException 
	{
				final String filePath = System.getProperty("user.dir") + "\\Resources\\EmployeeDetails.xlsx";
		
				Workbook workbook = WorkbookFactory.create(new File(filePath));
				Sheet sheet = workbook.getSheetAt(1);
				DataFormatter dataFormatter = new DataFormatter();
		
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext())
				{
						Iterator<Cell> cellIterator = rowIterator.next().iterator();
						while (cellIterator.hasNext()) 
						{
							Cell cellValue = cellIterator.next();
							String valueOfColumn = dataFormatter.formatCellValue(cellValue);
							System.out.print(valueOfColumn + " - ");
					}
					System.out.println();
				}
				
				System.out.println("____below code prints data without first row________________________________");
				int temp=0;
				
				Iterator<Row> rowIterator2 = sheet.iterator();
				while (rowIterator2.hasNext())
				{
					Iterator<Cell> cellIterator = rowIterator2.next().iterator();
							if(temp==0)
							{
								temp=1;
							}
						else{
								while (cellIterator.hasNext()) 
								{
									Cell cellValue = cellIterator.next();
									String valueOfColumn = dataFormatter.formatCellValue(cellValue);
									System.out.print(valueOfColumn + " - ");
									
								}
							}
							System.out.println();
						}
				
				
				
				
			}//main method
	}//class

