package utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Flags.Flag;

import org.apache.commons.io.input.MessageDigestCalculatingInputStream;
import org.apache.log4j.Logger;
import com.sun.activation.registries.MailcapParseException;
import com.sun.mail.pop3.POP3SSLStore;
import com.sun.mail.util.MailConnectException;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailHelper {

	private final static Logger log = Logger.getLogger(MailHelper.class);

	public String conectMail(String userMail, String userPassword) throws Exception {

		Store mailStore = null;
		Properties props = new Properties();

		if (userMail.contains("gmail")) {
			props.put("mail.store.protocol", "imaps"); // set up the session Session
			Session session = Session.getInstance(props);
			mailStore = session.getStore("imaps"); // Connect to your email account
			mailStore.connect("imap.gmail.com", userMail.trim(), userPassword); //
		} else {
			if (userMail.contains("hotmail") || userMail.contains("outlook") ) {

				// create properties field
				props.put("mail.imap.ssl.enable", "true");
				Session mailSession = Session.getInstance(props);
				mailSession.setDebug(true);

				// create the IMAP store object and connect with the pop server
				mailStore = mailSession.getStore("imap");
				mailStore.connect("outlook.office365.com", userMail, userPassword);
			} else {
				log.error("Use a gmail or hotmail address");
				throw new Exception("Use a gmail or hotmail address");
			}
		}
		
		// create the folder object and open it
		Folder emailFolder = mailStore.getFolder("INBOX");
		emailFolder.open(Folder.READ_WRITE);

		// Get directory
		Message message[] = emailFolder.getMessages();
		System.out.println("tamanho " + message.length);
		if (message.length == 0) {
			log.error("Username did not received the right email");
			throw new Exception("Username did not received the right email");
		}

		String link = "";
		System.out.println(
				"Email: " + message[message.length - 1].getFrom()[0] + "\t" + message[message.length - 1].getSubject());

		Object content = message[message.length - 1].getContent();
		if (content instanceof String) {
			String body = (String) content;
			System.out.println(body);
		}
		if (content instanceof Multipart) {
			Multipart mp = (Multipart) content;
			BodyPart bodyPartm = mp.getBodyPart(0);
			link = dumpPart(bodyPartm);
		}
		message[message.length - 1].setFlag(Flag.DELETED, true);

		return link;

	}

	public String dumpPart(BodyPart bodyPartm) throws Exception {

		InputStream is = bodyPartm.getInputStream();
		if (!(is instanceof BufferedInputStream)) {
			is = new BufferedInputStream(is);
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		String line = "";
		String link = null;
		int achei = 0;
		while ((line = reader.readLine()) != null) {
			if (line.contains("href=")) {
				link = line.split("https://")[1];
				achei = 0;
			}
			if (link != "" && link != null && achei <= 2) {
				link = link + line;
				achei++;
			}
		}

		link = link.split("href")[1];
		link = link.replace("3D", "");
		link = link.replace("=", "");
		link = link.replace("amp;", "");
		link = link.replace("username", "username=");
		link = link.replace("\">", "");
		link = link.replace("\"", "");
		link = link.replace("&k", "&k=");
		System.out.println("" + link);
		return link;
	}

	public static void sendAttachEmail(List<String> to, String subject, String body, String attach) {
		Properties p = getProps();
		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(p, auth);
		MimeMessage msg = new MimeMessage(session);
		MimeBodyPart mbp = new MimeBodyPart();

		boolean sendEmail = true;
		try {
			// "de" e "para"!!
			msg.setFrom(new InternetAddress("mariliauspiana@gmail.com"));
			InternetAddress[] emails = new InternetAddress[to.size()];
			int i = 0;
			for (Iterator iterator = to.iterator(); iterator.hasNext();) {
				String toAddr = (String) iterator.next();
				emails[i] = new InternetAddress(toAddr);
				i++;
			}
			msg.setRecipients(Message.RecipientType.TO, emails);
			msg.setSentDate(new Date());
			msg.setSubject(subject);
			msg.setText(body);
			// enviando anexo
			DataSource fds = new FileDataSource(attach);
			mbp.setDisposition(Part.ATTACHMENT);
			mbp.setDataHandler(new DataHandler(fds));
			mbp.setFileName(fds.getName());
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp);
			msg.setContent(mp);
			Transport.send(msg);

		} catch (MailConnectException mailconnect) {
			log.error(mailconnect.toString());
			sendEmail = false;
		} catch (AddressException adEx) {
			log.error(adEx.toString());
			sendEmail = false;
		} catch (MessagingException me) {
			log.error(me.toString());
			me.printStackTrace();
			sendEmail = false;
		}
		if (sendEmail)
			log.info("Email was sent");
		else
			log.error("Email was not sent");
	}

	private static Properties getProps() {
		Properties p = new Properties();
		p.put("mail.transport.protocol", "smtp");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.auth", "true");
		return p;

	}

}

class SMTPAuthenticator extends javax.mail.Authenticator {
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("mariliauspiana@gmail.com", "&MG7694216");
	}
}
