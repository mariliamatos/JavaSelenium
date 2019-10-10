package selenium.interactions;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import selenium.pageobjects.LoginPage;
import utils.MailHelper;

public class LoginInteraction extends LoginPage {

	private final Logger log = Logger.getLogger(LoginInteraction.class);

	public LoginInteraction(final WebDriver driver) {
		super(driver);
	}

	public void sendUserName(String userName) throws SQLException {
		// Método para enviar username na tela delogin
		try {
			sendElemet(username, userName);// preenchendo campo usuário
			log.info("User informed the username");
			log.info("Username informed was " + userName);
		} catch (Exception e) {
			log.error("Username could not be informed");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void userSentToRegisterPage() throws InterruptedException {
		// Username enviado não é registrado - Se ela não for registrado , usuário é
		// enviado pra pagina de registrar
		try {
			// username not registered
			waitForUrlToBe(getTestData("registerUrl"));// esperando a url
			verifyUrl(getTestData("registerUrl"));// verificando a url
			log.info("User is not registered");
		} catch (Exception e) {
			log.error("User could not be sent to registerPage");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void userSentActivateMessage() throws InterruptedException {
		// username é enviado para a página de ativação (Usuário encontrado , mas não
		// ativo)
		try {
			waitForUrlToBe(getTestData("sendMailUrl"));// esperando a url
			verifyUrl(getTestData("sendMailUrl"));// esperando a url
			verifyTextIsPresent("Verifique seu e-mail"); // verifica que a mensagem de Ativar email está presente na
															// tela
			log.info("User is not active");
		} catch (Exception e) {
			log.error("User could not be sent to Activation Page");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sessionExpiredMessage() throws InterruptedException {
		try {
			waitForUrlToBe(getTestData("loginUrl"));
			verifyUrl(getTestData("loginUrl"));
			verifyTextIsPresent("Sessão inválida");
			log.info("Session expired");
		} catch (Exception e) {
			log.error("Error when it tries to verify session expired message");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickLoginExpiredButton() throws InterruptedException {
		waitToElementAndClick(btnLogin);
	}

	public void clickContinueButton() throws InterruptedException {
		try {
			waitToElementAndClick(btnLogin);// botão e submeter username
			log.info("User submitted the username");
		} catch (Exception e) {
			log.error("Error when it tried to inform username");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void verifyUser(String username) throws InterruptedException {
		try {
			Thread.sleep(15000);
			waitForUrlToBe(getTestData("loginUrl"));// verificando se username existe- se existe, é direcionado pra
													// pagina
													// Login. Se não existir , direcionado para página de Registrar;
			verifyUrl(getTestData("loginUrl"));// verificando url
			waitForElement(pageusername);
			assertEquals(username, pageusername.getText());// verifica se nome do usuário enviado na primeira parte do
															// login
															// está presente
		} catch (Exception e) {
			log.error("Error when it tries to verify username");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickLoginButton() throws InterruptedException {
		try {
			// submetendo a senha
			waitToElementAndClick(btnSubmit);
			log.info("User submit login information!");
		} catch (Exception e) {
			log.error("Error when it tried to click on login button");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendPassword(String passwordToSend) {
		try {
			// enviando a senha
			sendElemet(password, passwordToSend);
			log.info("User informed the password " + passwordToSend);
		} catch (Exception e) {
			log.error("Error when it tried to send password");
			log.error(e.getMessage());
			throw e;
		}
	}

	public void verifyUserLogged(String user) throws InterruptedException {
		try { // verifica se user foi mesmo logado
			log.info("Verifying user logged");
			waitForUrlToBe(getTestData("criarUrl")); // verifica primeiramente a url
			verifyUrl(getTestData("criarUrl"));
			log.info("User is logged!");
			log.info("Password was right!");
			Thread.sleep(4000);
			driver.switchTo().activeElement();
			waitToElementAndClick(divUser);// verifica o username presente no perfil do usuário corresponde ao usuário
											// logado
			driver.switchTo().activeElement();

			//assertEquals(user, email.getText());// verifica o email presente no perfil do usuário corresponde ao do
												// usuário logado
			log.info("User " + user + " is logged");

		} catch (Exception e) {
			log.error("User " + user + " is not logged");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void verifyUserNotLogged() throws InterruptedException {
		try {
			verifyTextIsPresent("Senha inválida");// verifica se a mensagem de senha inválida aparece na tela
			log.info("User is not logged!");
			log.info("Password was wrong!Password is not valid");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	public void clickResetPasswordButton() throws InterruptedException {
		try {
			// clica no botão de resetar senha
			log.info("Reseting Password");
			waitToElementAndClick(resetPasswordButton);
		} catch (Exception e) {
			log.error("Error on click reset password button ");
			log.error(e.getMessage());
			throw e;
		}
	}

	public void confirmResetPassword(String userMail,String userPassword) throws InterruptedException, Exception {
		try {
			waitToElementAndClick(confirmResetPasswordButton);// botão de confirmação de reset
			Thread.sleep(15000);
			log.info("Checking reset password email");
			MailHelper mailH = new MailHelper();
			driver.get(mailH.conectMail(userMail,userPassword)); // verifica se o email de reset de senha foi enviado para caixa de
													// entrada do usuário
			log.info("User received the reset password mail");
			Thread.sleep(3000);
			} catch (Exception e) {
			log.error("Error on click Confirm Reset Password button ");
			log.error(e.getMessage());
			throw e;
		}
	}

	public void confirmCpf(String cpf) throws InterruptedException {
		try {
			// confirma cpf do usuário para o reset de senha
			Thread.sleep(2000);
			sendElemet(resetCPF,cpf);
			log.info("User cpf to reset was " + cpf);
			Thread.sleep(2000);
			waitToElementAndClick(confirmCpfResetPasswordButton);
		} catch (Exception e) {
			log.error("User's cpf was wrong");
			log.error(e.getMessage());
			throw e;
		}
	}

	public void sendNewPassword(String password) throws InterruptedException {
		try {
			// Metódo do envio de senha do usuário
			Thread.sleep(1000);
			sendElemet(resetPassword, password);// nova senha
			sendElemet(confirmResetPassword, password);// confirmação da nova senha
			submitElement(confirmResetPassword); // submetendo formulário
			log.info("User sent a new Password " + password);
			log.info("User reset the password");
		} catch (Exception e) {
			log.error("It was not possible to inform a new passoword");
			log.error(e.getMessage());
			throw e;
		}
	}

	public void receiveAMessage(String message) throws InterruptedException {
		try {
			// verifica se a mensagem enviado como parâmetro está presente na página
			verifyTextIsPresent(message);
			log.info("Message " + message + " is present on the screen");
		} catch (Exception e) {
			log.error("It was not possible to check if message was on the screen");
			log.error(e.getMessage());
			throw e;
		}
	}



}
