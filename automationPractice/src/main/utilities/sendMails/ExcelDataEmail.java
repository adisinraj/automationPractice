package sendMails;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataEmail {

	public static final String excel_filepath = System.getProperty("user.dir")+"\\Resources\\EmployeeDetails.xlsx";
	public static void main(String[] args) {
		
		final String fromEmail="adisinraj@gmail.com";
		final String password= "Anshul@123";
		final String toEmail = "adityasinghrajput00@gmail.com";
		String message= null;
		String exception=  null;
		

		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.starttls.enable","true");
		
		Session session = Session.getDefaultInstance(properties,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(fromEmail, password);}		});
		
		MimeMessage mimeMessage = new MimeMessage(session);
		
		try {
			Workbook workbook =  WorkbookFactory.create(new File(excel_filepath));
			Sheet sheet = workbook.getSheetAt(1);
			DataFormatter dataFormatter = new DataFormatter();
			
			for(Row row: sheet){
				message = message+"<table border="+1+" width="+400+"><tr>";
				for(Cell cell: row){
					String cellvalue = dataFormatter.formatCellValue(cell);
					message= message+"<td>"+cellvalue+"</td>";
				}
				message = message+"</tr></table>";
			}
			
		
			mimeMessage.setFrom(fromEmail);
			mimeMessage.addRecipients(RecipientType.TO, toEmail);
			
			mimeMessage.setSubject("This is the subject");
			mimeMessage.setContent(message,"text/html");
			
			Transport.send(mimeMessage);
			System.out.println("Message sent successfully");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		

	}

}
