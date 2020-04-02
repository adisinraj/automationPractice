package excelReader;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CreateSecondSheet {
	static final String excel_filepath = System.getProperty("user.dir")+"\\Resources\\EmployeeDetails.xlsx";
	private static String[] columns = {"userId","password"};
	private static List<UserIdAndPassword> listOfUserIdPassord = new ArrayList<UserIdAndPassword>();
	
	static{
		listOfUserIdPassord.add(new UserIdAndPassword("qwerwe@asd.net","1122"));
		
		listOfUserIdPassord.add(new UserIdAndPassword("asdff@asd.net","11223"));
		
		listOfUserIdPassord.add(new UserIdAndPassword("rturtyf@asd.net","112234"));

		listOfUserIdPassord.add(new UserIdAndPassword("jgfdsdf@asd.net","112235"));
	}
	
	public static void main(String[] args) throws Exception{
		Workbook workbook = WorkbookFactory.create(new File(excel_filepath));
		
		CreationHelper creationHelper = workbook.getCreationHelper();
		
		Sheet sheet = workbook.createSheet("RegisteredUsers");
		
		 // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        
     // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create the first Row
        Row headerRow = sheet.createRow(0);

        // Creating the columns for the first row with Cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        
        // Create Other rows and cells with employees data
        int rowNum = 1;
        for(UserIdAndPassword userIdAndPasswords: listOfUserIdPassord ){
        	 Row row = sheet.createRow(rowNum++);
        	 
        	 row.createCell(0).setCellValue(userIdAndPasswords.getUserId());
        	 row.createCell(1).setCellValue(userIdAndPasswords.getPassword());
        }
        
     // Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        
     // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("EmployeeDetails.xlsx");
        workbook.write(fileOut);
        fileOut.close();

     // Closing the workbook
        workbook.close();
    
        	
	}

}

