package servlet.mvc.rest.utility;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties; 
public class SendEmail {
 
 final String senderEmail = "freenforsale@gmail.com";
 final String senderPassword = " allareadmin";
 final String emailSMTPserver = "smtp.gmail.com";
 final String emailServerPort = "587";
 String receiverEmail = null;
 String emailSubject = null;
 String emailBody = null;
 
 public SendEmail(String receiverEmail, String Subject, String message) {
        this.receiverEmail = receiverEmail;
        this.emailSubject = Subject;
        this.emailBody = message;
 
        Properties props = new Properties();
        props.put("mail.smtp.user", senderEmail);
        props.put("mail.smtp.host", emailSMTPserver);
        props.put("mail.smtp.port", emailServerPort);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", emailServerPort);
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
  
 
        SecurityManager security = System.getSecurityManager();
 
        try {
             Authenticator auth = new SMTPAuthenticator();
             Session session = Session.getInstance(props, auth);
 
             Message msg = new MimeMessage(session);
             msg.setText(emailBody);
             msg.setSubject(emailSubject);
             msg.setFrom(new InternetAddress(senderEmail));
             msg.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(receiverEmail));
             Transport.send(msg);
             System.out.println("send successfully");
       } catch (Exception ex) {
             System.err.println("Error occurred while sending.!");
       }
 
 }
 
 private class SMTPAuthenticator extends javax.mail.Authenticator {
 
         public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
         }
 }
 

 
}