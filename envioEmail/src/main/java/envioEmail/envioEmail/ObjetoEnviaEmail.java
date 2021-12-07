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

public class ObjetoEnviaEmail {
	private String userName = "ganhar.em.dolar.oficial@gmail.com";
	private String senha = "pvdwzfnnyheghyra";
	private String listaDestinatarios = "";
	private String nomeRemetente="";
	private String assunto="";
	private String mensagem="";
	
	
	

	public ObjetoEnviaEmail(String listaDestinatario, String nomeRemetente, String assuntoEmail, String mensagemEmail) {
		this.listaDestinatarios=listaDestinatario;
		this.nomeRemetente = nomeRemetente;
		this.assunto = assuntoEmail;
		this.mensagem = mensagemEmail;
	}




	public void enviarEmail() throws Exception {
			//Está na documentação do java mail
		   Properties properties = new Properties();
		   properties.put("mail.smtp.ssl.trust", "*");
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
		   
		  Address[] toUser = InternetAddress.parse(listaDestinatarios);
		  Message message = new MimeMessage(session);
		  message.setFrom(new InternetAddress(userName,nomeRemetente));//Quem está enviando
		  message.setRecipients(Message.RecipientType.TO, toUser);//email de destino
		  message.setSubject(assunto);//Assunto do email
		  message.setText(mensagem);//Corpo
		  Transport.send(message);
	}
}