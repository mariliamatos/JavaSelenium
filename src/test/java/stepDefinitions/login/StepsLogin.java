package stepDefinitions.login;


import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.SeleniumTestWrapper;
import selenium.interactions.LoginInteraction;

public class StepsLogin {

	Scenario sc;
	Logger log = Logger.getLogger(StepsLogin.class); // Classse de Log
	LoginInteraction loginInteraction;// Classe
	// responsável
	// pelos steps
	// de login no
	// sistema


	@Before
	public void initiTesting(Scenario s)  {
		this.sc = s;
	}
	
	// LoginPage
	@When("^I click continue button$")
	public void i_click_continue_button() throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.clickContinueButton();
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@When("^I click to login button$")
	public void i_click_to_login_button() throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.clickLoginButton();
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Then("^I should be logged as \"([^\"]*)\"$")
	public void i_should_be_logged_as(String user) throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.verifyUserLogged(user);
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Then("^I should not be logged$")
	public void i_should_not_be_logged() throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.verifyUserNotLogged();
	}

	@Then("^I should be redirected to Register Page$")
	public void i_should_be_redirected_to_Register_Page() throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.userSentToRegisterPage();
	}

	@When("^I verify if the username exists as \"([^\"]*)\"$")
	public void i_verify_if_the_username_exists_as(String username) throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.verifyUser(username);
	}

	@When("^I provide the username as \"([^\"]*)\"$")
	public void i_provide_the_username_as(String userName) throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.sendUserName(userName);
	}

	@When("^I provide the password as \"([^\"]*)\"$")
	public void i_provide_the_wrong_password_as(String wrongPassword) throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.sendPassword(wrongPassword);
	}

	@Given("^I click in reset password button$")
	public void i_click_in_reset_password_button() throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.clickResetPasswordButton();
	}

	@Given("^I confirm my email to reset password as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_confirm_my_email_to_reset_password_as_and(String arg1, String arg2) throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.confirmResetPassword(arg1,arg2);
	}

	@Given("^I confirm my cpf as \"([^\"]*)\"$")
	public void i_confirm_my_cpf_as(String arg1) throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.confirmCpf(arg1);
	}

	@Given("^I confirm new password as \"([^\"]*)\"$")
	public void i_confirm_new_password_as(String password) throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.sendNewPassword(password);
	}

	@Then("^I should be redirected to activate message$")
	public void i_should_be_redirected_to_activate_message() throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.userSentActivateMessage();
	}

	@Given("^I receive a message that my session is expired$")
	public void i_receive_a_message_that_my_session_is_expired() throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.sessionExpiredMessage();
	}

	@Given("^I click in access spc button$")
	public void i_click_in_access_spc_button() throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.clickLoginExpiredButton();
	}

	
	
		

}