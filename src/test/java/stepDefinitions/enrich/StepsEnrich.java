package stepDefinitions.enrich;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import selenium.SeleniumTestWrapper;
import selenium.interactions.EnrichistInteraction;
import selenium.interactions.SegmentationInteraction;
import stepDefinitions.createlist.StepsCreateList;
import stepDefinitions.segmetacao.StepsSegmentation;
import utils.Attributes;

public class StepsEnrich {

	Scenario sc;
	Logger log = Logger.getLogger(StepsEnrich.class); // Classse de Log
	
	SegmentationInteraction segmentationInteraction;// Classe responsável pelos steps de segmentação no sistema
	EnrichistInteraction enrichListInteraction;// Classe
	// responsável
	// pelos
	// steps
	// de
	// enriquecimento


	private Map<String, Integer> mapAttributes = new HashMap<String, Integer>();// mapa de atributos
	
	@Before
	public void initiTesting(Scenario s)  {
		this.sc = s;
		
	}

	
	// Enriquecimento
		@Given("^I click on Qualificar Button$")
		public void i_click_on_Qualificar_Button() throws Throwable {
			enrichListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), EnrichistInteraction.class);
			enrichListInteraction.clickEnrichMenu();
		}

		@Given("^I choose the list type as (\\d+)$")
		public void i_choose_the_list_type_as(int type) throws Throwable {
			enrichListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), EnrichistInteraction.class);
			enrichListInteraction.choosenListType(type);
			SeleniumTestWrapper.takeScreenshot(sc);
		}

		@Given("^I click on Upload File button$")
		public void i_click_on_Upload_File_button() throws Throwable {
			enrichListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), EnrichistInteraction.class);
			enrichListInteraction.clickUploadButton();
			SeleniumTestWrapper.takeScreenshot(sc);
		}

		@Given("^I click on Enrich button$")
		public void i_click_on_Enrich_button() throws Throwable {
			enrichListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), EnrichistInteraction.class);
			enrichListInteraction.clickEnrichButton();
			SeleniumTestWrapper.takeScreenshot(sc);
		}

		@Given("^I should choose the attributes to enrich and changing quantity using attibutes as \"([^\"]*)\"$")
		public void i_should_choose_the_attributes_to_enrich_and_changing_quantity_using_attibutes_as(String atributos)
				throws Throwable {
			segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
					SegmentationInteraction.class);
			enrichListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), EnrichistInteraction.class);
			String[] arrayAttributes = segmentationInteraction.initAttributes(atributos);
			List<Attributes> listAttributes = enrichListInteraction
					.chooseAttributesChanginQuantity(segmentationInteraction.fillList(atributos, arrayAttributes));
			mapAttributes=StepsSegmentation.fillMap(arrayAttributes, listAttributes);
			StepsCreateList.setMapAttributes(mapAttributes);
			SeleniumTestWrapper.takeScreenshot(sc);
		}

		@Given("^I choose attributes to enrich as \"([^\"]*)\"$")
		public void i_choose_attributes_to_enrich_as(String atributos) throws Throwable {
			segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
					SegmentationInteraction.class);
			enrichListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), EnrichistInteraction.class);
			String[] arrayAttributes = segmentationInteraction.initAttributes(atributos);
			List<Attributes> listAttributes = enrichListInteraction
					.chooseAttributes(segmentationInteraction.fillList(atributos, arrayAttributes));
			mapAttributes=StepsSegmentation.fillMap(arrayAttributes, listAttributes);
			StepsCreateList.setMapAttributes(mapAttributes);
			SeleniumTestWrapper.takeScreenshot(sc);
		}

		@Given("^I should choose my attributes as \"([^\"]*)\" in list view mode$")
		public void i_should_choose_my_attributes_as_in_list_view_mode(String atributos) throws Throwable {
			segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
					SegmentationInteraction.class);
			enrichListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), EnrichistInteraction.class);
			String[] arrayAttributes = segmentationInteraction.initAttributes(atributos);
			List<Attributes> listAttributes = enrichListInteraction
					.chooseAttributesModeList(segmentationInteraction.fillList(atributos, arrayAttributes));
			mapAttributes=StepsSegmentation.fillMap(arrayAttributes, listAttributes);
			StepsCreateList.setMapAttributes(mapAttributes);
			SeleniumTestWrapper.takeScreenshot(sc);
		}

		@Given("^I should choose the attributes to enrich and changing quantity to zero using attibutes as \"([^\"]*)\"$")
		public void i_should_choose_the_attributes_to_enrich_and_changing_quantity_to_zero_using_attibutes_as(
				String atributos) throws Throwable {
			enrichListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), EnrichistInteraction.class);
			segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
					SegmentationInteraction.class);
			String[] arrayAttributes = segmentationInteraction.initAttributes(atributos);
			enrichListInteraction
					.chooseAttributes_ChangingQuantityToZero(segmentationInteraction.fillList(atributos, arrayAttributes));
			SeleniumTestWrapper.takeScreenshot(sc);
		}


		@Given("^I should change the quantity of my attribute that I will enrich to zero in list view mode using \"([^\"]*)\"$")
		public void i_should_change_the_quantity_of_my_attribute_that_I_will_enrich_to_zero_in_list_view_mode_using(
				String atributos) throws Throwable {
			segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
					SegmentationInteraction.class);
			enrichListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), EnrichistInteraction.class);
			String[] arrayAttributes = segmentationInteraction.initAttributes(atributos);
			enrichListInteraction.chooseAttributes_ChangingQuantityToZeroListModeView(
					segmentationInteraction.fillList(atributos, arrayAttributes));
			SeleniumTestWrapper.takeScreenshot(sc);
		}

		@Given("^I should click list mode view button$")
		public void i_should_click_list_mode_view_button() throws Throwable {
			enrichListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), EnrichistInteraction.class);
			enrichListInteraction.clickListModeView();
			SeleniumTestWrapper.takeScreenshot(sc);
		}

		@Given("^I verify if file is empty$")
		public void i_verify_if_file_is_empty() throws Throwable {
			enrichListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), EnrichistInteraction.class);
			enrichListInteraction.verifyFile();
			SeleniumTestWrapper.takeScreenshot(sc);
		}

	
	
}