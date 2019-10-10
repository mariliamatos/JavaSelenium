package selenium.interactions;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import selenium.pageobjects.RegisterPage;
import utils.MailHelper;
import utils.database.User;
import utils.database.UserDataBase;
import utils.CpfHelper;

public class RegisterInteraction extends RegisterPage {

	private final Logger log = Logger.getLogger(RegisterInteraction.class);

	public RegisterInteraction(final WebDriver driver) {
		super(driver);
	}

	public void clickOnRegisterLink() throws InterruptedException {
		try {
			waitToElementAndClick(menuRegistrar);
		} catch (Exception e) {
			log.error("Error on click Register Menu");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendUserNameByLogin(String userName) throws InterruptedException, SQLException, ClassNotFoundException {
		try {
			UserDataBase dtBase = new UserDataBase();
			dtBase.deleteEmail(userName);
			sendElemet(usernameLogin, userName);
			log.info("Username infomed was " + userName);
		} catch (Exception e) {
			log.error("Error on submit a username not registered");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendValidCPF() throws InterruptedException {
		try {
			String cpfNumber = CpfHelper.geraCPF();
			sendElemet(cpf, cpfNumber);
			log.info("Cpf used was " + cpfNumber);
		} catch (Exception e) {
			log.error("Error on submit username's cpf");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendUserCPF(String cpfNumber) throws InterruptedException {
		try {
			System.out.println(cpfNumber);
			sendElemet(cpf, cpfNumber);
			log.info("Cpf used was " + cpfNumber);
		} catch (Exception e) {
			log.error("Error on submit username's cpf");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}
	
	public void sendBhDate() throws InterruptedException {
		try {
			sendElemet(bthdate, getTestData("dataNascimento"));
			log.info("Birthday used was " + getTestData("dataNascimento"));
			waitToElementAndClick(bthdate);
		} catch (Exception e) {
			log.error("Error on send birthday");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickNextButton() throws InterruptedException {
		waitToElementAndClick(btProxima);
	}

	public void sendOperator() throws InterruptedException, SQLException, ClassNotFoundException {
		try {
			UserDataBase dataBase = new UserDataBase();
			log.info("Creating a new Operador");
			User newUser = dataBase.insertUser();
			dataBase.insertPassWord(newUser.getId());
			sendElemet(operador, newUser.getUsername());
			log.info("Operador was created");
			log.info("Operador created was " + newUser.getUsername());
		} catch (Exception e) {
			log.error("Error on send operator");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickOnRegisterButton() throws InterruptedException {
		try {
			submitElement(password);
			Thread.sleep(1000);
			log.info("Password was submitted");
		} catch (Exception e) {
			log.error("It was not possible to register");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void confirmRegistration(String email,String passwordSend) throws Exception {
		try {
			Thread.sleep(40000);
			String windowns = driver.getWindowHandle();
			driver.switchTo().window(windowns);
			assertTrue(driver.getPageSource().contains("Verifique seu e-mail"));
			Thread.sleep(2000);
			log.info("Activating email ... ");
			MailHelper mailH = new MailHelper();
			driver.get(mailH.conectMail(email,passwordSend));
			log.info("Mail activated");
			Thread.sleep(4000);
		} catch (Exception e) {
			log.error("It was not possible to confirm registration");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendNewUserName(String userName) throws SQLException, ClassNotFoundException {
		try {
			// UserDataBase dtBase = new UserDataBase();
			// dtBase.deleteEmail(userName);
			sendElemet(username, userName);
			log.info("Username used was " + userName);
		} catch (Exception e) {
			log.error("It was not possible send username");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendNewPassword(String newPassword) {
		try {
			sendElemet(password, newPassword);
			log.info("New Password sent was " + newPassword);
		} catch (Exception e) {
			log.error("It was not possible to send password");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendBhDate(String dataNascimento) throws Exception {

		try {
			sendElemet(bthdate, dataNascimento);
			waitToElementAndClick(bthdate);
			log.info("Data de nascimento used was " + dataNascimento);
		} catch (Exception e) {
			log.error("It was not possible to send birthday");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendCpf(String cpfNumber) {
		try {
			sendElemet(cpf, cpfNumber);
			log.info("Cpf sent was " + cpfNumber);
		} catch (Exception e) {
			log.error("It was not possible to send cpf");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void receiveAMessage(String message) throws InterruptedException {
		try {
			verifyTextIsPresent(message);
			log.info("Message is present on the screen " + message);
		} catch (Exception e) {
			log.error("It was not possible to check messages");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickUpdateUserButton() throws Exception {
		try {
			waitToElementAndClick(btUpdateUser);
			log.info("Update user button was clicked");
		} catch (Exception e) {
			log.error("It was not possible to click on update user button");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendNewEmail(String email) {
		try {
			sendElemet(username, email);
			log.info("New Username used was " + email);
		} catch (Exception e) {
			log.error("It was not possible send the new username");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void sendOperador(String operadorSend) {
		try {
			sendElemet(operador, operadorSend);
			log.info("New Username used was " + operador);
		} catch (Exception e) {
			log.error("It was not possible send the new username");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickUpdateEmail() throws Exception {
		try {
			waitToElementAndClick(btUpdateEmail);
			log.info("Update email button was clicked");
		} catch (Exception e) {
			log.error("It was not possible to click on update email button");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}



}
