package selenium.interactions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import selenium.pageobjects.SegmentationPage;
import utils.Attributes;

public class SegmentationInteraction extends SegmentationPage {

	private final Logger log = Logger.getLogger(SegmentationInteraction.class);
	private int[] arrayQuantidade = null;// array que irá guardar a quantidade de atributos selecionado na tela
	private static String listType ;
	
	
	public SegmentationInteraction(final WebDriver driver) {
		super(driver);
	}

	
	
	
	public int changeQuantityLessOne(int quantidade) throws InterruptedException {
		try {
			log.info("Changing quantity of attributes");
			// trocando a quantidade do atributo
			String windows = driver.getWindowHandle();
			driver.switchTo().window(windows);
			Thread.sleep(1000);
			if (quantidade > 1) { // verifica se a quantidade é maior que 2 , para que possamos diminui-la
				quantidade = quantidade - 1; // diminui a quantidade
				quantity.clear();
				sendElemet(quantity, String.valueOf(quantidade));
				// quantity.sendKeys(String.valueOf(quantidade));
				log.info("Quantidade alterada para " + quantidade);
			}
			waitToElementAndClick(btUpdateQt);// atualizando a quantidade
			Thread.sleep(1000);
			driver.switchTo().activeElement();
			return quantidade;
		} catch (Exception e) {
			log.error("Error when it tried to change attribute quantity");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public int changeQuantity(int quantidade) throws InterruptedException {
		try {
			log.info("Changing quantity of attributes");
			// trocando a quantidade do atributo
			String windows = driver.getWindowHandle();
			driver.switchTo().window(windows);
			Thread.sleep(2000);
			if (quantidade > 0) { // verifica se a quantidade é maior que 2 , para que possamos diminui-la
				// quantidade = 100; // diminui a quantidade
				if (Integer.parseInt(quantity.getAttribute("value")) >= quantidade) {
					quantity.clear();
					sendElemet(quantity, String.valueOf(quantidade));
					log.info("Quantidade alterada para " + quantidade);
				}
			}
			waitToElementAndClick(btUpdateQt);// atualizando a quantidade
			Thread.sleep(1000);
			driver.switchTo().activeElement();
			return quantidade;
		} catch (Exception e) {
			log.error("Error when it tried to change attribute quantity");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public int changeQuantityToZero() throws InterruptedException {
		try {
			log.info("Changing quantity of attributes");
			// trocando a quantidade do atributo para zero
			String windows = driver.getWindowHandle();
			driver.switchTo().window(windows);
			Thread.sleep(1000);
			quantity.clear();
			sendElemet(quantity, "0");
			waitToElementAndClick(btUpdateQt);// atualizando a quantidade
			Thread.sleep(1000);
			driver.switchTo().activeElement();
			return 0;
		} catch (Exception e) {
			log.error("Error when it tried to change attribute quantity");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickListModeView() throws InterruptedException {
		try {
			log.info("Changing to list mode view");
			waitToElementAndClick(btListMode);
		} catch (Exception e) {
			log.error("Error when it tried to go to list view mode");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void setListType(String listType) throws Exception {
		this.listType=listType;
	}
	
	public void chooseAttributesQuantityToZeroOnCart() throws Exception {
		try {

			// Alteração da quantidade para Zero - No carrinho

			
			WebElement linha = null;
			WebElement coluna = null;
	
			log.info("The quantity of the attribute will be changed");
			
			WebElement table = driver.findElement(By.xpath("//*[@id=\"modal-shopcart\"]/div/div[2]/div")); // tabela
			
			linha = table.findElements(By.className("row")).get(0);
			coluna = linha.findElements(By.className("col-12")).get(1).findElements(By.tagName("input")).get(0);
			
			sendElemet(coluna, "0");

			log.info("The quantity of the attribute is 0 in this filter now");
			Thread.sleep(2500);
			if (!coluna.getCssValue("border-color").equals("rgb(220, 53, 69)")) { // verifica
																													// se
																													// a
																													// cor
																													// da
																													// borda
																													// mudou
																													// -
																													// Se
				// a cor alterou é pq a quntidade
				// enviada não é válida
				log.info(
						"The quantity of the attribute was changed to zero, but the color of the attribute did not change");
				throw new Exception(
						"The quantity of the attribute was changed to zero, but the color of the attribute did not change");
			}

			WebElement button = driver
					.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[2]/button"));
				if (button.isEnabled()) { // verifica se button create list está ativo
				log.info("Button should not be enable to be selected");
				throw new Exception("Button should not be enable to be selected");
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			log.error("Error on attributes selection");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public List<Attributes> chooseAttributes(List<Attributes> listA, String combinedBaseC) throws Exception {
		try {
			Thread.sleep(5000);

			if (driver.getPageSource().contains(
					"Escolha, do lado esquerdo da tela, pelo menos dois filtros que melhor compõem os perfis que você deseja na sua lista.")) {
				throw new Exception("Less than two filters was selected");
			}

			while (driver.getPageSource().contains("Carregando")) {
				Thread.sleep(2000);
				log.info("Loading attributes");
			}

			log.info("Choosing attributes");
			
			
			int qtdAttributesChecked = 0;// quantidade de atributos selecionados
			int qtdattributesSent = 0;// atributos enviados
	
	
			List<WebElement> divP = driver.findElements(By.className("col-4"));// buscando o atributos
			WebElement qtd = null;
			WebElement input = null;
			WebElement label = null;

			
			if (combinedBaseC.equals("1")) { // Verificando se Perfil completo tem que ser selecionado
				waitToElementAndClick(combinedBase);// Selecionando Perfil completo
				Thread.sleep(3000);
				log.info("Base combinada was checked");
			}

			for (int i = 1; i < divP.size(); i++) {

				qtd = divP.get(i).findElements(By.className("quantity-label")).get(0);
				label = divP.get(i).findElements(By.tagName("label")).get(0);
				input = divP.get(i).findElements(By.tagName("input")).get(0);

				waitAndMoveToElement(label);
				Thread.sleep(1000);
				for (int j = 0; j < listA.size(); j++) {
					if (listA.get(j).getDescription().equals(label.getText()) && listA.get(j).isSent()) { // verifica se
																											// o
																											// atributo
																											// foi
																											// selecionado(enviado
																											// no casos
						qtdattributesSent++;
						if (!qtd.getText().equals("N.D.") || input.isEnabled()) {
							// verifica se a quantidade do atributo não é
							waitAndMoveToElement(label);
							Thread.sleep(500);
							waitToElementAndClick(label);
							if (combinedBaseC.equals("1")) {
								Thread.sleep(5000);
								label = divP.get(i).findElements(By.tagName("label")).get(0);
								input = divP.get(i).findElements(By.tagName("input")).get(0);
							}
							if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
								log.info(label.getText() + " was not checked");
								Thread.sleep(2000);
								waitToElementAndClick(label);
							}
							if (input.isSelected()) {// atributo foi selecionado
								log.info(label.getText() + " was checked");
								try {
									qtd = divP.get(i).findElements(By.className("quantity-label")).get(0)
											.findElement(By.tagName("button"));
									listA.get(j).setQuantity(Integer.parseInt(qtd.getText().replace(".", "")));
									qtdAttributesChecked++;
								} catch (Exception e) {
									listA.get(j).setQuantity(0);
									log.info("The quantity of the attribute " + label.getText()
											+ " is 0 in this filter");
								}
							}
						} else {
							log.info("The quantity of the attribute " + label.getText() + " is 0 in this filter");
							listA.get(j).setQuantity(0);
						}
						break;
					}
					if (listA.get(j).getDescription().equals(label.getText()) && !listA.get(j).isSent()) {
						log.info(label.getText() + " was not sent in this test");
						break;
					}
				}

			}

			if (combinedBaseC.equals("1")) { // Verificando se Perfil completo tem que ser selecionado
				qtd = divP.get(0).findElements(By.className("quantity-label")).get(0);
				String quantity = "";
				if (!qtd.getText().equals("N.D.")) {
					quantity = divP.get(0).findElements(By.className("quantity-label")).get(0)
							.findElement(By.tagName("button")).getText();
				} else {
					quantity = "0";
					qtdAttributesChecked = 0;
				}
				for (int i = 0; i < listA.size(); i++) {
					listA.get(i).setQuantity(Integer.parseInt(quantity.replace(".", "")));// quantidade de todos
																							// atributos devem ser
																							// iguais
																							// atributos devem ser
																							// iguais
				}
			}

			log.info(qtdAttributesChecked + " attributes were checked");
			log.info(qtdattributesSent + " attributes sent");

			if (qtdAttributesChecked == 0) { // verificando se a quantidade de atributos selecionados é maior que
				log.error("Quantity of attributes checked has to be greater than zero");
				throw new Exception("Quantity of attributes checked has to be greater than zero");
			}

			// if (qtdattributesSent != qtdattributes) {
			// log.error("Quantity of attributes checked was not the same sent in the
			// file");
			// throw new Exception("Quantity of attributes checked was not the same sent in
			// the file");
			// }

			return listA;
		} catch (Exception e) {
			log.error("Error on attributes selection");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public List<Attributes> chooseAttributesChangingQuantity(List<Attributes> listA) throws Exception {
		try {

			Thread.sleep(5000);

			if (driver.getPageSource().contains(
					"Escolha, do lado esquerdo da tela, pelo menos dois filtros que melhor compõem os perfis que você deseja na sua lista.")) {
				throw new Exception("Less than two filters was selected");
			}

			while (driver.getPageSource().contains("Carregando")) {
				Thread.sleep(3000);
				log.info("Loading attributes");
			}

			log.info("Choosing attributes");

			log.info("Tamanho lista "+listA.size());
			// waitForTextToAppear("dados disponíveis", element);

			int qtdAttributesChecked = 0;// quantidade de atributos selecionados
			int qtdattributesSent = 0;// atributos enviados
			List<WebElement> divP = driver.findElements(By.className("col-4"));
			WebElement qtd = null;
			WebElement input = null;
			WebElement label = null;
			for (int i = 1; i < divP.size(); i++) {

				log.info("Tamanho lista divP "+divP.size());
				qtd = divP.get(i).findElements(By.className("attribute-quantity")).get(0);
				
				label = divP.get(i).findElements(By.tagName("label")).get(0);
				input = divP.get(i).findElements(By.tagName("input")).get(0);
				for (int j = 0; j < listA.size(); j++) {
					if (listA.get(j).getDescription().equals(label.getText()) && listA.get(j).isSent()) { // verifica se
																											// o
																											// atributo
																											// foi
																											// selecionado(enviado
																											// no casos
						qtdattributesSent++;
						if (!qtd.getText().equals("N.D.")) { // verifica se a quantidade do atributo não é
																// zero
							waitToElementAndClick(label);
							Thread.sleep(1000);
							if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
								log.info(label.getText() + " was not checked");
								Thread.sleep(2000);
								waitToElementAndClick(label);
							}
							if (input.isSelected()) {// atributo foi selecionado
								qtdAttributesChecked++;
								qtd = divP.get(i).findElements(By.className("quantity-label")).get(0)
										.findElement(By.tagName("button"));
								log.info(label.getText() + " was checked");
								if (Integer.parseInt(qtd.getText().replace(".", "")) > 0) {
									waitToElementAndClick(qtd);
									changeQuantity(listA.get(j).getQuantity());
									listA.get(j).setQuantity(listA.get(j).getQuantity());
								} else {
									listA.get(j).setQuantity(Integer.parseInt(qtd.getText().replace(".", "")));
								}
							}
						} else {
							log.info("The quantity of the attribute " + label.getText() + " is 0 in this filter");
						}
						break;
					}
					if (listA.get(j).getDescription().equals(label.getText()) && !listA.get(j).isSent()) {
						log.info(label.getText() + " was not sent in this test");
						break;
					}
				}

			}

			log.info(qtdAttributesChecked + " attributes were checked");
			log.info(qtdattributesSent + " attributes sent");

			if (qtdAttributesChecked == 0) { // verificando se a quantidade de atributos selecionados é maior que zero
				log.error("Quantity of attributes checked has to be greater than zero");
				throw new Exception("Quantity of attributes checked has to be greater than zero");
			}

			// if (qtdattributesSent != qtdattributes) {
			// log.error("Quantity of attributes checked was not the same sent in the
			// file");
			// throw new Exception("Quantity of attributes checked was not the same sent in
			// the file");
			// }

			return listA;

		} catch (Exception e) {
			log.error("Error on attributes selection");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public List<Attributes> chooseAttributesChanginQuantityToZero(List<Attributes> listA) throws Exception {
		try {
			Thread.sleep(5000);

			if (driver.getPageSource().contains(
					"Escolha, do lado esquerdo da tela, pelo menos dois filtros que melhor compõem os perfis que você deseja na sua lista.")) {
				throw new Exception("Less than two filters was selected");
			}

			while (driver.getPageSource().contains("Carregando")) {
				Thread.sleep(3000);
				log.info("Loading attributes");
			}

			log.info("Choosing attributes");

			// waitForTextToAppear("dados disponíveis", element);

			List<WebElement> divP = driver.findElements(By.className("col-4"));

			int qtdAttributesChecked = 0;// quantidade de atributos selecionados
			int qtdattributesSent = 0;// atributos enviados

			WebElement qtd = null;
			WebElement input = null;
			WebElement label = null;
			for (int i = 1; i < 4; i++) {
				qtd = divP.get(i).findElements(By.className("quantity-label")).get(0);
				label = divP.get(i).findElements(By.tagName("label")).get(0);
				input = divP.get(i).findElements(By.tagName("input")).get(0);
				for (int j = 0; j < listA.size(); j++) {
					if (listA.get(j).getDescription().equals(label.getText()) && listA.get(j).isSent()) { // verifica se
																											// o
																											// atributo
																											// foi
																											// selecionado(enviado
																											// no casos
						qtdattributesSent++;
						if (!qtd.getText().equals("N.D.")) { // verifica se a quantidade do atributo não é
																// zero
							waitToElementAndClick(label);
							Thread.sleep(1000);
							if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
								log.info(label.getText() + " was not checked");
								Thread.sleep(2000);
								waitToElementAndClick(label);
							}
							if (input.isSelected()) {// atributo foi selecionado
								qtd = divP.get(i).findElements(By.className("quantity-label")).get(0)
										.findElement(By.tagName("button"));
								log.info(label.getText() + " was checked");
								waitToElementAndClick(qtd);
								changeQuantityToZero();
								listA.get(j).setQuantity(0);
								qtdAttributesChecked++;
								if (!input.isEnabled()) {
									log.info("The quantity of the attribute " + label.getText()
											+ " is 0 in this filter now");
								}
								if (input.isEnabled()) {
									log.info("Attribute should not be enable to be selected");
									throw new Exception("Attribute should not be enable to be selected");
								}

							}
						} else {
							log.info("The quantity of the attribute " + label.getText() + " is 0 in this filter");
						}
						break;
					}
					if (listA.get(j).getDescription().equals(label.getText()) && !listA.get(j).isSent()) {
						log.info(label.getText() + " was not sent in this test");
						break;
					}
				}
			}

			log.info("" + qtdAttributesChecked + " attributes were checked");
			log.info("" + qtdattributesSent + " attributes sent");

			if (qtdAttributesChecked == 0) { // verificando se a quantidade de atributos selecionados é maior que zero
				log.error("Quantity of attributes checked has to be greater than zero");
				throw new Exception("Quantity of attributes checked has to be greater than zero");
			}

			// if (qtdattributesSent != qtdattributes) {
			// log.error("Quantity of attributes checked was not the same sent in the
			// file");
			// throw new Exception("Quantity of attributes checked was not the same sent in
			// the file");
			// }

			return listA;
		} catch (Exception e) {
			log.error("Error on attributes selection");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public List<Attributes> chooseAttributesModeList(List<Attributes> listA, String combinedBaseC) throws Exception {
		try {
			Thread.sleep(5000);

			if (driver.getPageSource().contains(
					"Escolha, do lado esquerdo da tela, pelo menos dois filtros que melhor compõem os perfis que você deseja na sua lista.")) {
				throw new Exception("Less than two filters was selected");
			}

			while (driver.getPageSource().contains("Carregando")) {
				Thread.sleep(3000);
				log.info("Loading attributes");
			}

			log.info("Choosing attributes");

			int qtdAttributesChecked = 0;// quantidade de atributos selecionados
			int qtdattributesSent = 0;// atributos enviados

			WebElement table = driver
					.findElement(By.xpath("//*[@id=\"segment-page\"]/section/div[3]/div[2]/div/table/tbody"));
			
			WebElement linha = null;
			WebElement coluna = null;
			WebElement input = null;
			WebElement label = null;

			driver.switchTo().activeElement();

			if (combinedBaseC.equals("1")) { // Verificando se Perfil completo tem que ser selecionado
				waitToElementAndClick(combinedBase);// Selecionando Perfil completo
				Thread.sleep(3000);
				log.info("Base combinada was checked");
			}

			for (int i = 0; i < table.findElements(By.tagName("tr")).size(); i++) {
				linha = table.findElements(By.tagName("tr")).get(i);
				coluna = linha.findElements(By.tagName("td")).get(1);
				String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
				label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
				input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
				for (int j = 0; j < listA.size(); j++) {
					if (listA.get(j).getDescription().equals(label.getText()) && listA.get(j).isSent()) { // verifica se
																											// o
																											// atributo
																											// foi
																											// selecionado
						qtdattributesSent++;
						if (!quantidade.equals("0") || input.isEnabled()) { // verifica se a quantidade do atributo não
																			// é zero
							waitToElementAndClick(label);

							if (combinedBaseC.equals("1")) {
								Thread.sleep(5000);
								linha = table.findElements(By.tagName("tr")).get(i);
								coluna = linha.findElements(By.tagName("td")).get(1);
								label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label"))
										.get(0);
								input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input"))
										.get(0);
							}

							if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
								log.info(label.getText() + " was not checked");
								Thread.sleep(2000);
								waitToElementAndClick(input);
							}

							if (input.isSelected()) {// atributo foi selecionado
								log.info(label.getText() + " was checked");
								qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
								if (Integer.parseInt(quantidade) > 2) {
									int qtdS = listA.get(j).getQuantity();
									Thread.sleep(1000);
									if (qtdS > 0 && Integer.parseInt(quantidade)>=qtdS) {
										sendElemet(coluna.findElement(By.id("quantity")), String.valueOf(qtdS));
										log.info("The quantity of " + label.getText() + " was changed to " + qtdS);
									} else {
										listA.get(j).setQuantity(Integer.parseInt(quantidade.replace(".", "")));
									}
								} else {
									listA.get(j).setQuantity(Integer.parseInt(quantidade.replace(".", "")));
								}
							}
						} else {
							log.info("The quantity of the attribute " + label.getText() + "  is 0 in this filter");
						}
						break;
					}
					if (listA.get(j).getDescription().equals(label.getText()) && !listA.get(j).isSent()) {
						log.info(label.getText() + " was not sent in this test");
						break;
					}
				}

			}

			if (combinedBaseC.equals("1")) { // Verificando se Perfil completo tem que ser selecionado
				linha = table.findElements(By.tagName("tr")).get(0);
				coluna = linha.findElements(By.tagName("td")).get(1);
				String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
				if (quantidade.equals("0")) {
					qtdAttributesChecked = 0;
				}
				for (int i = 0; i < listA.size(); i++) {
					listA.get(i).setQuantity(Integer.parseInt(quantidade.replace(".", "")));// quantidade de todos
																							// atributos devem ser
																							// iguais
				}
			}

			log.info(qtdAttributesChecked + " attributes were checked");
			log.info(qtdattributesSent + " attributes sent");

			if (qtdAttributesChecked == 0) { // verificando se a quantidade de atributos selecionados é maior que zero
				log.error("Quantity of attributes checked has to be greater than zero");
				throw new Exception("Quantity of attributes checked has to be greater than zero");
			}

			// if (qtdattributesSent != qtdattributes) {
			// log.error("Quantity of attributes checked was not the same sent in the
			// file");
			// throw new Exception("Quantity of attributes checked was not the same sent in
			// the file");
			// }

			return listA;
		} catch (Exception e) {
			log.error("Error on attributes selection");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public List<Attributes> chooseAttributesModeListChangingQuantityToZero(List<Attributes> listA) throws Exception {
		try {
			// Método responsavel por selecionar os atributos -- Mode list view

			Thread.sleep(5000);

			if (driver.getPageSource().contains(
					"Escolha, do lado esquerdo da tela, pelo menos dois filtros que melhor compõem os perfis que você deseja na sua lista.")) {
				throw new Exception("Less than two filters was selected");
			}

			while (driver.getPageSource().contains("Carregando")) {
				Thread.sleep(3000);
				log.info("Loading attributes");
			}

			log.info("Choosing attributes");


			int qtdAttributesChecked = 0;// quantidade de atributos selecionados
			int qtdattributesSent = 0;// atributos enviados

			Thread.sleep(5000);

			driver.switchTo().activeElement();

			WebElement table = driver
					.findElement(By.xpath("//*[@id=\"segment-page\"]/section/div[3]/div[2]/div/table/tbody")); // tabela
																												// do
																												// modo
																												// view

			WebElement linha = null;
			WebElement coluna = null;
			WebElement input = null;
			WebElement label = null;

			for (int i = 0; i < 3; i++) {// fazer um for em cada linha da tabela
				linha = table.findElements(By.tagName("tr")).get(i);
				coluna = linha.findElements(By.tagName("td")).get(1);
				String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
				label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
				input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
				for (int j = 0; j < listA.size(); j++) {
					if (listA.get(j).getDescription().equals(label.getText()) && listA.get(j).isSent()) { // verifica se
																											// o
																											// atributo
																											// foi
																											// selecionado
						qtdattributesSent++;
						if (!quantidade.equals("0")) { // verifica se a quantidade do atributo não é zero
							waitToElementAndClick(label);
							if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
								log.info(label.getText() + " was not checked");
								Thread.sleep(2000);
								waitToElementAndClick(input);
							}
							if (input.isSelected()) {// atributo foi selecionado
								qtdAttributesChecked++; // aumentar a quantidade de atributos selecinados
								log.info(label.getText() + " was checked");
								if (Integer.parseInt(quantidade) > 2 && i < 3) {
									// coluna.findElement(By.id("quantity")).clear();
									// coluna.findElement(By.id("quantity")).sendKeys("0");
									sendElemet(coluna.findElement(By.id("quantity")), "0");
									listA.get(j).setQuantity(0);
								}
								Thread.sleep(3000);
								if (!coluna.findElement(By.id("quantity")).getCssValue("border-color")
										.equals("rgb(220, 53, 69)")) { // verifica
									// se a
									// cor
									// da
									// borda
									// mudou
									// - Se
//a cor alterou é pq a quntidade
//enviada não é válida
									log.info(
											"The quantity of the attribute was changed to zero, but the color of the attribute did not change");
									throw new Exception(
											"The quantity of the attribute was changed to zero, but the color of the attribute did not change");
								}
								if (!input.isEnabled()) {// verifica se o input esta enable
									log.info("The quantity of the attribute " + label.getText()
											+ " is 0 in this filter now");
								}
								if (input.isEnabled()) {
									log.info("Attribute should not be enable to be selected");
									throw new Exception("Attribute should not be enable to be selected");
								}

							}
						} else {
							log.info("The quantity of the attribute " + label.getText() + "  is 0 in this filter");
						}
						break;
					}
					if (listA.get(j).getDescription().equals(label.getText()) && !listA.get(j).isSent()) {
						log.info(label.getText() + " was not sent in this test");
						break;
					}
				}
			}

			log.info("" + qtdAttributesChecked + " attributes were checked");
			log.info("" + qtdattributesSent + " attributes sent");

			if (qtdAttributesChecked == 0) { // verificando se a quantidade de atributos selecionados é maior que zero
				log.error("Quantity of attributes checked has to be greater than zero");
				throw new Exception("Quantity of attributes checked has to be greater than zero");
			}

			return listA;
		} catch (

		Exception e) {
			log.error("Error on attributes selection");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public String[] initAttributes(String attributes) throws Exception {
		try {
			String[] attributesPessoaFisica = { "CPF", "Nome", "Situacao RF", "Endereco", "Data Nascimento", "Genero",
					"Escolaridade", "Nome Pai", "Nome Mae", "Profissão", "E-mail", "Telefone Fixo 1", "Telefone Fixo 2",
					"Telefone Fixo 3", "Telefone Fixo 4", "Telefone Fixo 5", "Telefone Celular 1", "Telefone Celular 2",
					"Telefone Celular 3", "Telefone Celular 4", "Telefone Celular 5", "WahtasApp Celular 1",
					"WahtasApp Celular 2", "WahtasApp Celular 3", "WahtasApp Celular 4", "WahtasApp Celular 5",
					"Veiculo", "Renda Presumida", "Obito", "Bolsa Familia", "Estado Civil", "Funcionario CLT",
					"Classe Social", "Restrição Financeira", "Consignado", "Título de Eleitor", "RG", "PIS",
					"Carteira Profissional", "Conselho Profissional" }; // Atributos pré estabelecidos pessoa física

			String[] attributesPessoaJuridica = { "CNPJ", "Razao Social", "Situação RF", "Data Fundacao",
					"Nome Fantasia", "E-mail", "Telefone Fixo 1", "Telefone Fixo 2", "Telefone Fixo 3",
					"Telefone Fixo 4", "Telefone Fixo 5", "Telefone Celular 1", "Telefone Celular 2",
					"Telefone Celular 3", "Telefone Celular 4", "Telefone Celular 5", "WahtasApp Celular 1",
					"WahtasApp Celular 2", "WahtasApp Celular 3", "WahtasApp Celular 4", "WahtasApp Celular 5", "CNAE",
					"Porte", "Numero Funcionarios", "faturamento", "Socio 1", "Socio 2", "Socio 3", "Sintegra",
					"Restricao Financeira", "Endereco" };// Atributos pré
															// estabelecidos
															// pessoa jurídica

			if (listType.equals("2")) { // Tamanho dos atributos enviados - tamamho 31 para pessoa jurídica
				log.info("Pessoa Jurídica was chosen");
				return attributesPessoaJuridica;
			}
			if (listType.equals("1")) {// Tamanho dos atributos enviados - tamamho 40 para pessoa física
				log.info("Pessoa Jurídica was chosen");
				return attributesPessoaFisica;
			}
			else {
				throw new Exception("Wrong list type was chosen!");	
			}
			
		} catch (Exception e) {

			log.error("Error on it tried initialize attributes list");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public List<Attributes> fillList(String atributos, String[] descricao) {
		try {
			List<Attributes> listA = new ArrayList<>();

			List<Attributes> listAttributes = new ArrayList<>();

			String lista2[] = atributos.split(",");
			HashMap<String, String> mapa = new HashMap<String, String>();

			for (String item : lista2) {
				if (item.indexOf("=") >= 0) // Por garantia, fazemos uma checagem para garantir que a String tenha o
											// sinal de igual (=)
				{
					String separado[] = item.split("="); // Por exemplo, separado = {"file_0", "1"}
					if (separado.length == 2) // Outra checagem
					{
						Attributes attribute = new Attributes();
						attribute.setDescription(separado[0].trim());
						String quantidade[] = separado[1].split(":");
						mapa.put(separado[0].trim(), quantidade[0]); // Agora pode colocar no hashmap
						attribute.setSent(false);
						attribute.setQuantity(1);
						if (quantidade.length < 2) {
							if (quantidade[0].equals("1"))
								attribute.setSent(true);
							attribute.setQuantity(1);
						}
						if (quantidade.length == 2) {// Outra checagem
							if (quantidade[0].equals("1"))
								attribute.setSent(true);
							attribute.setQuantity(Integer.parseInt(quantidade[1].trim()));
						}
						if(attribute.isSent())
							listAttributes.add(attribute);
					}
				}
			}

			for (int i = 0; i < descricao.length; i++) { // preenchendo a lista com a descrição e com o enviou ou não
				Attributes attribute = new Attributes(); // do
				attribute.setSent(false);
				attribute.setQuantity(1);
				for (int j = 0; j < listAttributes.size(); j++) { // preenchendo a lista com a descrição e com o enviou
					try {
						if (descricao[i].equals(listAttributes.get(j).getDescription())) {
							attribute.setQuantity(listAttributes.get(j).getQuantity());
							if (listAttributes.get(j).isSent()) { // verifica se o atributo foi enviado
								attribute.setSent(true);
							} else {
								attribute.setSent(false);
							}
						}
					} catch (Exception e) {
						attribute.setSent(false);
						attribute.setQuantity(1);
					}
					attribute.setDescription(descricao[i]);
				}
				listA.add(attribute);
			}
			return listA;
		} catch (Exception e) {
			log.error("Error when it tried to fill the list of the atrributes");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void verifyTwoFilteMessage() throws Exception {
		Thread.sleep(2000);
		if (!verifyTextIsPresent(
				"Escolha, do lado esquerdo da tela, pelo menos dois filtros que melhor compõem os perfis que você deseja na sua lista.")) {
			throw new Exception("Message of two filter was not found");
		}
	}

	public void uncheckAttributes() throws Exception {
		try {
			log.info("Unchecking the attributes");
			Thread.sleep(2000);
			WebElement table = driver.findElement(By.xpath("//*[@id=\"modal-shopcart\"]/div/div[2]/div")); // tabela
			
			WebElement linha = null;

			int quantityAttributes = table.findElements(By.className("row")).size();
			log.error("The quantity a "+ quantityAttributes );

			for (int i = 0; i <quantityAttributes; i++) {
				linha = table.findElements(By.className("row")).get(0);
				WebElement label = linha.findElements(By.className("col-12")).get(0).findElements(By.className("custom-control")).get(0).findElements(By.tagName("label")).get(0);
				label.click();
				Thread.sleep(500);
			}
			
			Thread.sleep(2000);
			if (quantityAttributes <= table.findElements(By.className("row")).size()) {
				log.error("The quantity of attibute is wrong after the exclusion");
				throw new Exception("The quantity of attibute is wrong after the exclusion");
			}
			WebElement button = driver
					.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[2]/button"));
			if (button.isEnabled()) { // verifica se button create list está ativo
				log.info("Button should not be enable to be selected");
				throw new Exception("Button should not be enable to be selected");
			}
			
			Thread.sleep(2000);
		} catch (Exception e) {
			log.error("Error when it tried to uncheck the attributes");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickAplicarButton() throws InterruptedException {
		waitToElementAndClick(btAplicar);
		log.info("Clicking on Aplicar button");
	}

}
