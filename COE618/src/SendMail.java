/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Main
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.swing.JOptionPane;
public class SendMail {
    
    private String to;
    private String from = "jpaolopapa@gmail.com";
    private String host = "localhost";
    private Customer cust;
    private Properties properties;
    private Session session;
    private String text;
    final String username = "618bookclub@gmail.com";
    final String password = "michaeldennisjohn";
    private String price;
    
    public SendMail(Customer e, String t, String p)
    {
        cust = e;
        text = e.getReceipt();
        to = t;
        price  = p;
        properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        session = Session.getInstance(properties, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username, password);
            }
        });
        
        try{
        
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Book Club Receipt");
        message.setText(text + price);
        Transport.send(message);
        JOptionPane.showMessageDialog(null, "Receipt sent!","E-mail receipit",JOptionPane.INFORMATION_MESSAGE);
        }
        
        catch(MessagingException mex)
        {
            mex.printStackTrace();
        }
    
   
    
    }
    
}
