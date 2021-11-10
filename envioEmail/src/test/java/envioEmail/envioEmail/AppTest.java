package envioEmail.envioEmail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	//4:00
	private String userName = "ganhar.em.dolar.oficial@gmail.com";
	private String senha = "545454445454";
	//Mesma coisa que o main
	@org.junit.Test
   public void testeEmail() {
		try {
			//Está na documentação do java mail
			   Properties properties = new Properties();
			   properties.put("mail.smtp.auth", "true");//Autorização
			   properties.put("mail.smtp.starttls", "true");//Autenticação
			   properties.put("mail.smtp.host", "smtp.gmail.com");//servidor gmail
			   properties.put("mail.smtp.port", "465");//porta servidor gmail
			   properties.put("mail.smtp.socketFactory.port", "465");//especifica a porta a ser conectada pelo socket
			   properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//Classe socket de conexão com o SMTP
			   Session session = Session.getInstance(properties, new Authenticator() {
					   @Override
					protected PasswordAuthentication getPasswordAuthentication() {
						
						return new PasswordAuthentication(userName,senha );
					}
				});
			   
			  Address[] toUser = InternetAddress.parse("contato@ruvianfabrin.com, ganhar.em.dolar.oficial@gmail.com");
			  Message message = new MimeMessage(session);
			  message.setFrom(new InternetAddress(userName));//Quem está enviando
			  message.setRecipients(Message.RecipientType.TO, toUser);//email de destino
			  message.setSubject("Chegou o email enviado com java.");//Assunto do email
			  message.setText("Esse é um corpo java");//Corpo
			  Transport.send(message);
			  
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
