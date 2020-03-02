package model;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class Email {

	public boolean enviarEmail(String destino,String assunto,String msg){
		SimpleEmail email = new SimpleEmail();
		email.setSSLOnConnect(true);
		email.setHostName( "smtp.gmail.com" );
		email.setSslSmtpPort( "465" );
		email.setAuthenticator( new DefaultAuthenticator( "tapiocamakerbr@gmail.com" , "WuyAnG271724" ) );
			try {
				email.setFrom("tapiocamakerbr@gmail.com");
			    email.setDebug(true); 
			    email.setSubject(assunto);
				email.setMsg(msg);
				email.addTo(destino);
				email.send();
				return true;
			} catch (EmailException e) {
			}
			return false;
	}
	public boolean enviarComAnexo(String nome,String destino,String assunto,String msg,String arquivo){
              
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(arquivo);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Pedido");
		attachment.setName(arquivo);
		  
		MultiPartEmail email = new MultiPartEmail();
		email.setSSLOnConnect(true);
		email.setHostName( "smtp.gmail.com" );
		email.setSslSmtpPort( "465" );
		email.setAuthenticator( new DefaultAuthenticator("tapiocamakerbr@gmail.com" ,"WuyAnG271724") );
		try {
			email.setFrom("tapiocamakerbr@gmail.com");
			email.setDebug(true); 
			email.setSubject(assunto);
			email.setMsg(msg);
			email.addTo( destino );
			email.attach(attachment);
			email.send();
			return true;
		} catch (EmailException e) {
		}
		return false;
	}
}