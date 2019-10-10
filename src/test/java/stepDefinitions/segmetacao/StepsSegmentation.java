package stepDefinitions.segmetacao;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import selenium.SeleniumTestWrapper;
import selenium.interactions.CreateListInteraction;
import selenium.interactions.SegmentationInteraction;
import stepDefinitions.createlist.StepsCreateList;
import utils.Attributes;

public class StepsSegmentation {

	Scenario sc;
	Logger log = Logger.getLogger(StepsSegmentation.class); // Classse de Log

	SegmentationInteraction segmentationInteraction;// Classe responsável pelos steps de segmentação no sistema

	private static Map<String, Integer> mapAttributes = new HashMap<String, Integer>();// mapa de atributos

	@Before
	public void initiTesting(Scenario s) {
		this.sc = s;

	}

	
	@Given("^I should choose the type of my list as \"([^\"]*)\"$")
	public void i_should_choose_the_type_of_my_list_as(String lType) throws Throwable {
		segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationInteraction.class);
		segmentationInteraction.setListType(lType);
	}
	
	
	@Given("^I should change the quantity of my attribute to zero$")
	public void i_should_change_the_quantity_of_my_attribute_to_zero() throws Throwable {
		segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationInteraction.class);
		segmentationInteraction.chooseAttributesQuantityToZeroOnCart();
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^I should click to list view$")
	public void i_should_click_to_list_view() throws Throwable {
		segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationInteraction.class);
		segmentationInteraction.clickListModeView();
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^verify two filters message$")
	public void verify_two_filters_message() throws Throwable {
		segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationInteraction.class);
		segmentationInteraction.verifyTwoFilteMessage();
	}

	

	
	@Given("^I should change the quantity of my attribute to zero in list view mode using \"([^\"]*)\"$")
	public void i_should_change_the_quantity_of_my_attribute_to_zero_in_list_view_mode_using(String atributos)
			throws Throwable {
		segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationInteraction.class);
		String[] at = segmentationInteraction.initAttributes(atributos);
		segmentationInteraction
				.chooseAttributesModeListChangingQuantityToZero(segmentationInteraction.fillList(atributos, at));
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	/*
	 * @Given("^I should choose the attributes from as \"([^\"]*)\" and \"([^\"]*)\" in list view mode$"
	 * ) public void
	 * i_should_choose_the_attributes_from_as_and_in_list_view_mode(String
	 * atributos, String combinedBaseC) throws Throwable { String[] at =
	 * segmentationInteraction.initAttributes(atributos); List<Attributes>
	 * listAttributes = segmentationInteraction
	 * .chooseAttributesModeList(segmentationInteraction.fillList(atributos, at),
	 * combinedBaseC); for (int i = 0; i < at.length; i++) {
	 * System.out.println("----------------------------");
	 * System.out.println("Descrição " + listAttributes.get(i).getDescription());
	 * System.out.println("Issent " + listAttributes.get(i).isSent());
	 * System.out.println("Quantidade " + listAttributes.get(i).getQuantity());
	 * String description = listAttributes.get(i).getDescription().toLowerCase();
	 * description = description.replace(" ", ""); description =
	 * description.replace("-", "");
	 * 
	 * if(at.length == 40) { description = description.replace("fixo", "");
	 * description = description.replace("telefonecelular", "celular"); }
	 * 
	 * description = description.replace("endereco", "logradouro"); description =
	 * description.replace("ã", "a"); description = description.replace("í", "i");
	 * 
	 * description = description.replace("titulode", "titulo");
	 * System.out.println(description);
	 * 
	 * example.put(description, listAttributes.get(i).getQuantity());
	 * System.out.println(example.get(description));
	 * 
	 * 
	 * if (atributos.length() == 31) arrayQuantidadePJ[i] =
	 * listAttributes.get(i).getQuantity(); if (atributos.length() == 40)
	 * arrayQuantidadePF[i] = listAttributes.get(i).getQuantity(); } } /
	 */

	@Given("^I should choose the attributes changing quantity using attibutes as \"([^\"]*)\"$")
	public void i_should_choose_the_attributes_changing_quantity_using_attibutes_as(String atributos) throws Throwable {
		segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationInteraction.class);
		String[] arrayAttributes = segmentationInteraction.initAttributes(atributos);
		List<Attributes> listAttributes = segmentationInteraction
				.chooseAttributesChangingQuantity(segmentationInteraction.fillList(atributos, arrayAttributes));
		fillMap(arrayAttributes, listAttributes);
		StepsCreateList.setMapAttributes(mapAttributes);
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	public static Map<String, Integer> fillMap(String[] attributes, List<Attributes> listAttributes) {
		// Preencher HashMap com descrição e quantidade de atributos selecionados
		// Fazer as substituiçoes necessárias para verificar se a description está no
		// arquivo a ser exportada
		// Headers dos arquivos exportados não são iguais a descrição dos atributos que
		// aparecem na tela
		for (int i = 0; i < attributes.length; i++) {
			String description = listAttributes.get(i).getDescription().toLowerCase();
			description = description.replace(" ", "");
			description = description.replace("-", "");
			if (attributes.length == 40) { // verifica se é lista e pessoa física
				description = description.replace("fixo", "");
				description = description.replace("telefonecelular", "celular");
			}
			description = description.replace("endereco", "logradouro");
			description = description.replace("ã", "a");
			description = description.replace("í", "i");
			description = description.replace("titulode", "titulo");
			// System.out.println("Descricao = " + description);
			// System.out.println("Quantidade = " + listAttributes.get(i).getQuantity());
			mapAttributes.put(description, listAttributes.get(i).getQuantity());
		}
		return mapAttributes;
	}

	@Given("^I should choose the attributes as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_should_choose_the_attributes_as_and(String atributos, String combinedBaseC) throws Throwable {
		segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationInteraction.class);
		String[] arrayAttributes = segmentationInteraction.initAttributes(atributos);
		List<Attributes> listAttributes = segmentationInteraction
				.chooseAttributes(segmentationInteraction.fillList(atributos, arrayAttributes), combinedBaseC);
		fillMap(arrayAttributes, listAttributes);
		StepsCreateList.setMapAttributes(mapAttributes);
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^I should choose the attributes as \"([^\"]*)\" and \"([^\"]*)\" in list view mode$")
	public void i_should_choose_the_attributes_as_and_in_list_view_mode(String atributos, String combinedBaseC)
			throws Throwable {
		segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationInteraction.class);
		String[] arrayAttributes = segmentationInteraction.initAttributes(atributos);
		List<Attributes> listAttributes = segmentationInteraction
				.chooseAttributesModeList(segmentationInteraction.fillList(atributos, arrayAttributes), combinedBaseC);
		fillMap(arrayAttributes, listAttributes);
		StepsCreateList.setMapAttributes(mapAttributes);
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^I should choose the attributes changing quantity to zero using attibutes as \"([^\"]*)\"$")
	public void i_should_choose_the_attributes_changing_quantity_to_zero_using_attibutes_as(String atributos)
			throws Throwable {
		segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationInteraction.class);
		String[] arrayAttributes = segmentationInteraction.initAttributes(atributos);
		segmentationInteraction
				.chooseAttributesChanginQuantityToZero(segmentationInteraction.fillList(atributos, arrayAttributes));
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^I should uncheck attributes$")
	public void i_should_uncheck_attributes() throws Throwable {
		segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationInteraction.class);
		segmentationInteraction.uncheckAttributes();
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	
	
	@Given("^I am testing a idea$")
	public void i_am_testing_a_idea() throws Throwable {
	   mapAttributes.put("teste1", 1);
	   mapAttributes.put("teste2", 2);
	   mapAttributes.put("teste3", 3);
	   mapAttributes.put("teste4", 4);
	   mapAttributes.put("teste5", 5);
	   mapAttributes.put("teste6", 6);
	   mapAttributes.put("teste7", 7);
	   mapAttributes.put("teste8", 8);
	   StepsCreateList.setMapAttributes(mapAttributes);
		
	}
	
	@Given("^I should click on apply button$")
	public void i_should_click_on_apply_button() throws Throwable {
		segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
				SegmentationInteraction.class);
		segmentationInteraction.clickAplicarButton();
	}
	
}