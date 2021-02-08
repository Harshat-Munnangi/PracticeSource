package ClientBSFI.DeepTesting;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailToCustomers {

	public static void initiateMail(String to, String status) {  
		  
		  String host="mail.example.com";  
		  final String user="customersMail@example.com";
		  final String password="SecreteExample";
		    
		  
		   Properties props = new Properties();  
		   props.put("mail.smtp.host",host);  
		   props.put("mail.smtp.auth", "true");  
		     
		   Session session = Session.getDefaultInstance(props,   new javax.mail.Authenticator() {  
			      protected PasswordAuthentication getPasswordAuthentication() {  
			    	    return new PasswordAuthentication(user,password);  
			    	      }  
			    	    });  
		  
		    try {  
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(user));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		     if(status.equalsIgnoreCase("S")) {
		    	 message.setSubject("Order Status");  
			     message.setText("Success!!! Order Placed");  
		     }else {
		    	 message.setSubject("Order Status");  
			     message.setText("Failure!! Stock ran out"); 
		     }
		     
		     message.setSentDate(new Date());
		       
		     Transport.send(message);  
		  
		     System.out.println("message sent successfully...");  
		   
		     } catch (MessagingException e) {
		    	 e.printStackTrace();
		    }  
		 }  
}
