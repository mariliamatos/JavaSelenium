package stepDefinitions.segmetacao.pessoajuridica;


import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import selenium.SeleniumTestWrapper;
import selenium.interactions.SegmentationPessoaJuridicaInteraction;

public class StepsPessoaJuridica {

	Scenario sc;
	Logger log = Logger.getLogger(StepsPessoaJuridica.class); // Classse de Log
	
	SegmentationPessoaJuridicaInteraction segmentatioPJInteraction;// Classe responsável pelos steps de
	// segmentação(Pessoa
	
	@Before
	public void initiTesting(Scenario s)  {
		this.sc = s;
	}

	@Given("^I should to choose Empresa as filter$")
	public void i_should_to_choose_Empresa_as_filter() throws Throwable {
		segmentatioPJInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaJuridicaInteraction.class);
		segmentatioPJInteraction.chooseFilterEmpresa();
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^I should choose filter localizationPJ as \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_should_choose_filter_localizationPJ_as_and_and(String locationState, String locationCity,
			String locationNeighborhood) throws Throwable {
		segmentatioPJInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaJuridicaInteraction.class);
		segmentatioPJInteraction.chooseLocation(locationState, locationCity, locationNeighborhood);
	}

	@Given("^I should choose filter status as \"([^\"]*)\"$")
	public void i_should_choose_filter_status_as(String statusC) throws Throwable {
		segmentatioPJInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaJuridicaInteraction.class);
		segmentatioPJInteraction.chooseStatus(statusC);
	}

	@Given("^I should choose filter faturamento  as  \"([^\"]*)\"$")
	public void i_should_choose_filter_faturamento_as(String finance) throws Throwable {
		segmentatioPJInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaJuridicaInteraction.class);
		segmentatioPJInteraction.chooseFinance(finance);
	}

	@Given("^I should choose filter atividades as \"([^\"]*)\"$")
	public void i_should_choose_filter_atividades_as(String activity) throws Throwable {
		segmentatioPJInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaJuridicaInteraction.class);
		segmentatioPJInteraction.chooseActivity(activity);
	}

	@Given("^I should choose filter data de abertura as \"([^\"]*)\"$")
	public void i_should_choose_filter_data_de_abertura_as(String dateC) throws Throwable {
		segmentatioPJInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaJuridicaInteraction.class);
		segmentatioPJInteraction.chooseOpeningDate(dateC);
	}

	@Given("^I should choose filter funcionarios as \"([^\"]*)\"$")
	public void i_should_choose_filter_funcionarios_as(String funcionarios) throws Throwable {
		segmentatioPJInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaJuridicaInteraction.class);
		segmentatioPJInteraction.chooseEmployeeQt(funcionarios);
	}

	@Given("^I should choose filter Porte da Empresa as  \"([^\"]*)\"$")
	public void i_should_choose_filter_Porte_da_Empresa_as(String SizeC) throws Throwable {
		segmentatioPJInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaJuridicaInteraction.class);
		segmentatioPJInteraction.chooseSize(SizeC);
	}

	@Given("^I should choose filter Natureza Júridica as  \"([^\"]*)\"$")
	public void i_should_choose_filter_Natureza_Júridica_as(String type) throws Throwable {
		segmentatioPJInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationPessoaJuridicaInteraction.class);
		segmentatioPJInteraction.chooseType(type);
		SeleniumTestWrapper.takeScreenshot(sc);
	}

}