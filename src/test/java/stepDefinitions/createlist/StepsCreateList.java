package stepDefinitions.createlist;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import selenium.SeleniumTestWrapper;
import selenium.interactions.CreateListInteraction;
import selenium.interactions.SegmentationInteraction;

public class StepsCreateList {

	Scenario sc;
	Logger log = Logger.getLogger(StepsCreateList.class); // Classse de Log

	CreateListInteraction createListInteraction;// Classe
	// responsável
	// pelos
	// steps
	// de
	// criação
	// da
	// lista

	private static Map<String, Integer> mapAttributes = new HashMap<String, Integer>();// mapa de atributos

	public static Map<String, Integer> getMapAttributes() {
		return mapAttributes;
	}

	public static void setMapAttributes(Map<String, Integer> mapAttributes) {
		StepsCreateList.mapAttributes = mapAttributes;
	}

	@Before
	public void initiTesting(Scenario s) {
		this.sc = s;
	}

	@Then("^I should start choosing my filter to create my list as \"([^\"]*)\"$")
	public void i_should_start_choosing_my_filter_to_create_my_list_as(String listName) throws Throwable {
		createListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), CreateListInteraction.class);
		createListInteraction.firstFilter(listName);
	}
	
	@Given("^I should create a list as \"([^\"]*)\"$")
	public void i_should_create_a_list_as(String listName) throws Throwable {
		createListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), CreateListInteraction.class);
		createListInteraction.creatList(listName);
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^I should click create list button$")
	public void i_should_click_create_list_button() throws Throwable {
		createListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), CreateListInteraction.class);
		createListInteraction.clickCreateListButton();
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^I should go to history$")
	public void i_should_go_to_history() throws Throwable {
		createListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), CreateListInteraction.class);
		createListInteraction.goToHistory();
	}

	@Given("^I should verify is list was created as \"([^\"]*)\"$")
	public void i_should_verify_is_list_was_created_as(String listName) throws Throwable {
		createListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), CreateListInteraction.class);
		createListInteraction.verifyListCreation(listName);
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^I should download my list as (\\d+)$")
	public void i_should_download_my_list_as(int type) throws Throwable {
		createListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), CreateListInteraction.class);
		createListInteraction.downloadList(type);
	}

	@Given("^I should read my file as (\\d+) after download my list as (\\d+)$")
	public void i_should_read_my_file_as_after_download_my_list_as(int listType, int downloadType) throws Throwable {
		createListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), CreateListInteraction.class);
		createListInteraction.readFile(downloadType, listType, mapAttributes);
	}

	@Given("^I should copy my file$")
	public void i_should_copy_my_file() throws Throwable {
		createListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), CreateListInteraction.class);
		createListInteraction.copyFile();
	}

	@Given("^I should unzip my file$")
	public void i_should_unzip_my_file() throws Throwable {
		createListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), CreateListInteraction.class);
		createListInteraction.UnzipFile();
	}

	@Given("^I should click menu Create List$")
	public void i_should_click_menu_Create_List() throws Throwable {
		createListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), CreateListInteraction.class);
		createListInteraction.clickMenuCreateList();
	}

	@Given("^I should check if any message appears$")
	public void i_should_check_if_any_message_appears() throws Throwable {
		createListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), CreateListInteraction.class);
		createListInteraction.checkMessage();
	}

	

}