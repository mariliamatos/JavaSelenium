package stepDefinitions.register;


import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.SeleniumTestWrapper;
import selenium.interactions.HomeInteraction;
import selenium.interactions.LoginInteraction;
import selenium.interactions.RegisterInteraction;

public class StepsRegister {

	Scenario sc;
	Logger log = Logger.getLogger(StepsRegister.class); // Classse de Log
	RegisterInteraction registerInteraction;// Classe
	// responsável
	// pelos
	// steps
	// de
	// registro
	// no
	// sistema
	LoginInteraction loginInteraction;// Classe
	// responsável
	// pelos steps
	// de login no
	// sistema

	HomeInteraction homeInteraction;// Classe responsável
									// pelos steps de
									// entrada na home
									// page do sistema

	@Before
	public void initiTesting(Scenario s)  {
		this.sc = s;
		
	}
	// Register
		@When("^I navigate to register menu$")
		public void i_navigate_to_register_menu() throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.clickOnRegisterLink();
		}

		@Given("^I provide a new username by login as \"([^\"]*)\"$")
		public void i_provide_a_new_username_by_login_as(String arg1) throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.sendUserNameByLogin(arg1);
		}

		@When("^I provide a new cpf$")
		public void i_provide_a_new_cpf() throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.sendValidCPF();
		}

		@When("^I provide data de nascimeto$")
		public void i_provide_datade_nascimeto() throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.sendBhDate();
		}

		@When("^I click on next page button$")
		public void i_click_on_next_page_button() throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.clickNextButton();
		}

		
		@Given("^I click on update user button$")
		public void i_click_on_update_user_button() throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.clickUpdateUserButton();
		}
		
		
		
		@Given("^I provide an new email as \"([^\"]*)\"$")
		public void i_provide_an_new_email_as(String email) throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.sendNewEmail(email);
		}

		@Given("^I provide an operator as \"([^\"]*)\"$")
		public void i_provide_an_operator_as(String operador) throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.sendOperador(operador);
		}
		
		
		
		@Given("^I click on update email button$")
		public void i_click_on_update_email_button() throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.clickUpdateEmail();
		}
		
		
		
		@When("^I provide the operator name$")
		public void i_provide_the_operator_name() throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.sendOperator();
		}

		@When("^I clik on register button$")
		public void I_clik_on_register_button() throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.clickOnRegisterButton();
		}

		
		
		
		@Then("^I should be registered as \"([^\"]*)\"$")
		public void i_should_be_registered_as(String arg1) throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
//			registerInteraction.confirmRegistration(arg1);
		}

		
		@Then("^I should be registered as \"([^\"]*)\" and \"([^\"]*)\"$")
		public void i_should_be_registered_as_and(String arg1, String arg2) throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.confirmRegistration(arg1,arg2);
		}
		
		
		
		@When("^I provide a new username by register as \"([^\"]*)\"$")
		public void i_provide_a_new_username_by_register_as(String arg1) throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.sendNewUserName(arg1);
		}

		@When("^I provide data de nascimeto as \"([^\"]*)\"$")
		public void i_provide_data_de_nascimeto_as(String arg1) throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.sendBhDate(arg1);
		}

		@When("^I provide a new password as \"([^\"]*)\"$")
		public void i_provide_a_new_password_as(String arg1) throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.sendNewPassword(arg1);
		}

		@Given("^I provide a new cpf as \"([^\"]*)\"$")
		public void i_provide_a_new_cpf_as(String cpfNumber) throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.sendCpf(cpfNumber);
		}

		@Given("^I should receive a message as \"([^\"]*)\"$")
		public void i_should_receive_a_message_as(String message) throws Throwable {
			registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
			registerInteraction.receiveAMessage(message);
		}
	
		

}