package sendMails;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

	public static void main(String[] args) {
		final String fromEmail = "adisinraj@gmail.com"; //requires valid gmail id
		final String password = "Anshul@123"; // correct password for gmail id
		final String toEmail = "adityasinghrajput00@gmail.com"; // can be any email id 
		
		Properties properties = System.getProperties();
	
		properties.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		properties.put("mail.smtp.port", "587"); //TLS Port
		properties.put("mail.smtp.auth", "true"); //enable authentication
		properties.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		Session session = Session.getDefaultInstance(properties,auth);
		
		try{
			MimeMessage message = new MimeMessage(session);
		
		/*	//set message headers
			message.addHeader("Content-type", "text/HTML; charset=UTF-8");
			message.addHeader("format", "flowed");
			message.addHeader("Content-Transfer-Encoding", "8bit");
			
			*Dont understand why this is used.
			*/
			message.setFrom(fromEmail);
			message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject("this is system generated email from Java");
			
			/**
			 *  In below 2 lines, the setText() is used to send the normal text in the body while 
			 *  setContent() is used to send the message in the form of HTML document.
			 */
			
		//	message.setText("<p1>Using lorem ipsum to focus attention on graphic elements in a webpage design proposalIn publishing and graphic design, lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document without relying on meaningful content (also called greeking). Replacing the actual content with placeholder text allows designers to design the form of the content before the content itself has been produced.</p1>");
			message.setContent("<table border="+1+"><tr> <th>Month</th>    <th>Savings</th>  </tr>  <tr>    <td>January</td>    <td>$100</td>  </tr></table>","text/html");
			
			Transport.send(message);
			System.out.println("message sent successfully");
			
		}
		
		catch(Exception e){
			e.printStackTrace();			
		}
	}

}
