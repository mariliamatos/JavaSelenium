package stepDefinitions.segmetacao.pessoafisica;


import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import selenium.SeleniumTestWrapper;
import selenium.interactions.SegmentationPessoaFisicaInteraction;

public class StepsPessoaFisica {

	Scenario sc;
	Logger log = Logger.getLogger(StepsPessoaFisica.class); // Classse de Log
	
	SegmentationPessoaFisicaInteraction segmentatioPFInteraction;// Classe responsável pelos steps de segmentação (Pessoa Física) no sistema

	@Before
	public void initiTesting(Scenario s)  {
		this.sc = s;
		
	}
	
	@Then("^I should choose filter gender as \"([^\"]*)\"$")
	public void i_should_choose_filter_gender_as(String gender) throws Throwable {
		segmentatioPFInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaFisicaInteraction.class);
		segmentatioPFInteraction.chooseGender(gender);
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Then("^I should choose filter faixetaria as \"([^\"]*)\"$")
	public void i_should_choose_filter_faixetaria_as(String age) throws Throwable {
		segmentatioPFInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaFisicaInteraction.class);
		segmentatioPFInteraction.chooseAge(age);
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^I should choose filter localizationPF as \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_should_choose_filter_localizationPF_as_and_and(String locationState, String locationCity,
			String locationNeighborhood) throws Throwable {
		segmentatioPFInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaFisicaInteraction.class);
		segmentatioPFInteraction.chooseLocation(locationState, locationCity, locationNeighborhood);
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^I should choose filter profissao as \"([^\"]*)\"$")
	public void i_should_choose_filter_profissao_as(String profession) throws Throwable {
		segmentatioPFInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaFisicaInteraction.class);
		segmentatioPFInteraction.chooseProfession(profession);
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^I should choose filter renda as  \"([^\"]*)\"$")
	public void i_should_choose_filter_renda_as(String finance) throws Throwable {
		segmentatioPFInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaFisicaInteraction.class);
		segmentatioPFInteraction.chooseFinance(finance);
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^I should choose filter escolaridade as \"([^\"]*)\"$")
	public void i_should_choose_filter_escolaridade_as(String school) throws Throwable {
		segmentatioPFInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaFisicaInteraction.class);
		segmentatioPFInteraction.chooseSchool(school);
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^I should choose filter restricao as  \"([^\"]*)\"$")
	public void i_should_choose_filter_restricao_as(String debts) throws Throwable {
		segmentatioPFInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaFisicaInteraction.class);
		segmentatioPFInteraction.chooseDebts(debts);
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^I should choose filter bens as  \"([^\"]*)\"$")
	public void i_should_choose_filter_bens_as(String properties) throws Throwable {
		segmentatioPFInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaFisicaInteraction.class);
		segmentatioPFInteraction.chooseProperties(properties);
		SeleniumTestWrapper.takeScreenshot(sc);
		SeleniumTestWrapper.takeScreenshot(sc);
	}


}