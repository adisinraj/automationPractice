package excelReader;

import java.io.File;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileReading {
	
		static String currentDir = System.getProperty("user.dir");
	static final String excel_filepath = currentDir + "\\Resources\\EmployeeDetails.xlsx";   
	
    
		public static void main(String[] args) throws Exception {

		// Creating a Workbook from an Excel file (.xls or .xlsx)
		Workbook workbook = WorkbookFactory.create(new File(excel_filepath));
		
		// Retrieving the number of sheets in the Workbook
		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
		
		// Iterating over all the sheets in the workbook
		Iterator<Sheet> sheetIterator = workbook.iterator();
		while(sheetIterator.hasNext()){
			Sheet sheet = sheetIterator.next();
			System.out.println(sheet.getSheetName());
		}
		 
		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);
		
		//DataFormater formats the cells and gives their values as String
		DataFormatter dataFormatter = new DataFormatter();
		
		//Now we can iterate over rows and and columns over the sheet
		for(Row row:sheet){
			for(Cell cell:row){
				String valueOfColumn = dataFormatter.formatCellValue(cell);
				System.out.print(valueOfColumn +" | ");
			}
			System.out.println();
		}
		
		//close the workbook after use
		workbook.close();
	}

}
