package selenium.interactions;

import java.awt.AWTEvent;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gherkin.lexer.Pa;
import selenium.pageobjects.EnrichListPage;
import utils.Attributes;

public class EnrichistInteraction extends EnrichListPage {

	private final Logger log = Logger.getLogger(EnrichistInteraction.class);
	public static String dateList;
	public static int listType;

	public EnrichistInteraction(final WebDriver driver) {
		super(driver);
	}

	public void clickEnrichMenu() throws Exception {
		Thread.sleep(2000);// Menu do enriquecimento
		waitToElementAndClick(enrichButton);
		log.info("Menu Qualificar was clicked");
	}

	public void choosenListType(int type) throws Exception {
		try {
			// Escolhendo o tipo da lista - Pessoa Juridica ou Pessoa Física
			listType = type;
			log.info("TIPO == " + listType);
			if (type == 1 || type == 3 || type == 5) { // Pessoa física
				waitToElementAndClick(pf);
				log.info("Pessoa física was choosen");
			}
			if (type == 2 || type == 4) { // Pessoa Jurídica
				waitToElementAndClick(pj);
				log.info("Pessoa jurídica was choosen");
			}
		} catch (Exception e) {
			log.error("It was not possible to chose the type of the list");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickEnrichButton() throws Exception {
		try {
			waitToElementAndClick(btEnrich);
			log.info("Button Qualificar was clicked");
			Thread.sleep(2000);
		} catch (Exception e) {
			log.error("Error on click Enrich button");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickUploadButton() throws Exception {
		try {
			// Upload de arquivo
			waitToElementAndClick(btUploadFile);// botão de upload do arquivo
			log.info("Starting file selection");
			String path = "";
			Thread.sleep(3000);
			StringSelection ss = null;
			String separator = File.separator;
			if (listType == 1 || listType == 4) {// selecionando 4 (pessoa jurídica) e enviando cpf
				path = new File("src" + separator + "test" + separator + "resources" + separator + "testFiles"
						+ separator + "cpfValidosQa.txt").getAbsolutePath();
				ss = new StringSelection(path);
				// file.sendKeys(path);
			} // Pessoa física}
			if (listType == 2 || listType == 5) {// selecionado 5(pessoa física) e enviado cnpj
				path = new File("src" + separator + "test" + separator + "resources" + separator + "testFiles"
						+ separator + "cnpjsValidosQa.txt").getAbsolutePath();
				ss = new StringSelection(path);
				// file.sendKeys(path);

			} // Pessoa Jurídica
			if (listType == 3) {
				path = new File("src" + separator + "test" + separator + "resources" + separator + "testFiles"
						+ separator + "arquivoVazio.txt").getAbsolutePath();
				ss = new StringSelection(path);
				// file.sendKeys(path);
			}
			// arquivo vazio

			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = null;
			if (toolkit != null) {
				clipboard = toolkit.getSystemClipboard();
				clipboard.setContents(ss, null);

				Robot robot = new Robot();

				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				robot.delay(1000);
				log.info("File was choosen");

				Thread.sleep(3000);
				if (file.getText().isEmpty()) {
					file.sendKeys(path);
					log.info("File was choosen");
				}

			} else {
				log.error("It was not possible to upload the file to enrich");
				throw new Exception("It was not possible to upload the file to enrich");

			}

		} catch (Exception e) {
			log.error("It was not possible to upload the file");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

		// file.sendKeys("C:\\Users\\gsw.mariliam\\Desktop\\cpfValidosQa.txt");
		// waitToElementAndClick(btUploadFile);
		// Thread.sleep(12000);
	}

	public void verifyFile() throws InterruptedException {
		// Arquivos especiais
		if (listType == 3) {
			verifyTextIsPresent("Erro ao validar conteúdo do arquivo, o arquivo está vazio");// arquivo vazio
			log.info("File is Empty");
		}
		if (listType == 4) {
			verifyTextIsPresent("O arquivo não possuí nenhum documento válido");// selecionado 5(pessoa física) e
																				// enviado cnpj
			log.info("File has some Cpfs when it should contain only cnpjs");
		}
		if (listType == 5) {
			verifyTextIsPresent("Erro ao validar lista de CPFs, um CNPJ está presente no arquivo"); // selecionando 4
																									// (pessoa jurídica)
																									// e enviando cpfs
			log.info("File has some Cnpjs when it should contain only cpfs");
		}
	}

	public List<Attributes> chooseAttributes(List<Attributes> listA) throws Exception {
		try {

			Thread.sleep(2000);
			while (driver.getPageSource().contains("Carregando")) {
				Thread.sleep(3000);
				log.info("Loading attributes");
			}

			log.info("Choosing attributes");

			int qtdAttributesChecked = 0;// quantidade de atributos selecionados
			int qtdattributesSent = 0;// atributos enviados

			List<WebElement> divP = driver.findElements(By.className("col-4"));// buscando o atributos
			WebElement qtd = null;
			WebElement input = null;
			WebElement label = null;
			// coluna = linha.findElements(By.tagName("td")).get(1);
			// qtd=divP.get(i).findElements(By.className("quantity-label")).get(0).findElement(By.tagName("button"));
			for (int i = 1; i < divP.size(); i++) {
				qtd = divP.get(i).findElements(By.className("quantity-label")).get(0);
				label = divP.get(i).findElements(By.tagName("label")).get(0);
				input = divP.get(i).findElements(By.tagName("input")).get(0);
				// if (i == 0) {
//					int attempts = 0;
//					while (attempts < 11) {
//						try {
//							if (qtd.getText().isEmpty()) {
//								System.out.println("Entrei");
//								Thread.sleep(10000);
//							}
//						} catch (StaleElementReferenceException e) {
//							Thread.sleep(10000);
//						}
//						attempts++;
//					}
//				}

				for (int j = 0; j < listA.size(); j++) {
					if (listA.get(j).getDescription().equals(label.getText()) && listA.get(j).isSent()) { // verifica se
																											// o
																											// atributo
																											// foi
																											// selecionado(enviado
																											// no casos
						qtdattributesSent++;

						qtd = divP.get(i).findElements(By.className("quantity-label")).get(0);
						label = divP.get(i).findElements(By.tagName("label")).get(0);
						input = divP.get(i).findElements(By.tagName("input")).get(0);

						if (!qtd.getText().equals("N.D.")) { // verifica se a quantidade do atributo não é
							waitToElementAndClick(label);
							if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
								log.info(label.getText() + " was not checked");
								Thread.sleep(2000);
								waitToElementAndClick(label);
							}
							if (input.isSelected()) {// atributo foi selecionado
								log.info(label.getText() + " was checked");
								qtd = divP.get(i).findElements(By.className("quantity-label")).get(0)
										.findElement(By.tagName("button"));
								listA.get(j).setQuantity(Integer.parseInt(qtd.getText().replace(".", "")));
								qtdAttributesChecked++;
							}
						} else {
							log.info("The quantity of the attribute " + label.getText() + " is 0 in this filter");
						}

					}
					if (listA.get(j).getDescription().equals(label.getText()) && !listA.get(j).isSent())
						log.info("  " + label.getText() + " was not sent in this test");
				}
			}
			log.info("" + qtdAttributesChecked + " attributes were checked");
			log.info("" + qtdattributesSent + " attributes sent");

			if (qtdAttributesChecked == 0) { // verificando se a quantidade de atributos selecionados é maior que
												// zero
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

	public List<Attributes> chooseAttributesChanginQuantity(List<Attributes> listA) throws Exception {
		
		try {

			Thread.sleep(2000);
			while (driver.getPageSource().contains("Carregando")) {
				Thread.sleep(3000);
				log.info("Loading attributes");
			}

			log.info("Choosing attributes");

			int qtdAttributesChecked = 0;// quantidade de atributos selecionados
			int qtdattributesSent = 0;// atributos enviados

			List<WebElement> divP = driver.findElements(By.className("col-4"));// buscando o atributos
			WebElement qtd = null;
			WebElement input = null;
			WebElement label = null;

			SegmentationInteraction segInt = new SegmentationInteraction(driver);

			for (int i = 1; i < divP.size(); i++) {
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

						qtd = divP.get(i).findElements(By.className("quantity-label")).get(0);
						label = divP.get(i).findElements(By.tagName("label")).get(0);
						input = divP.get(i).findElements(By.tagName("input")).get(0);

						if (!qtd.getText().equals("N.D.")) { // verifica se a quantidade do atributo não é
							waitToElementAndClick(label);
							if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
								log.info(label.getText() + " was not checked");
								Thread.sleep(2000);
								waitToElementAndClick(label);
							}
							if (input.isSelected()) {// atributo foi selecionado
								log.info(label.getText() + " was checked");
								qtd = divP.get(i).findElements(By.className("quantity-label")).get(0)
										.findElement(By.tagName("button"));
								if(i>=2)
								{
									qtd.click();
									segInt.changeQuantity(listA.get(j).getQuantity());
									listA.get(j).setQuantity(Integer.parseInt(qtd.getText().replace(".", "")));
									
								}
								else {
									listA.get(j).setQuantity(Integer.parseInt(qtd.getText().replace(".", "")));
								}
								qtdAttributesChecked++;
							}
						} else {
							log.info("The quantity of the attribute " + label.getText() + " is 0 in this filter");
						}

					}
					if (listA.get(j).getDescription().equals(label.getText()) && !listA.get(j).isSent())
						log.info("  " + label.getText() + " was not sent in this test");
				}
			}
			log.info("" + qtdAttributesChecked + " attributes were checked");
			log.info("" + qtdattributesSent + " attributes sent");

			
			if (qtdAttributesChecked == 0) { // verificando se a quantidade de atributos selecionados é maior que
												// zero
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

	public List<Attributes> chooseAttributes_ChangingQuantityToZero(List<Attributes> listA) throws Exception {
		try {

			Thread.sleep(2000);
			while (driver.getPageSource().contains("Carregando")) {
				Thread.sleep(3000);
				log.info("Loading attributes");
			}

			log.info("Choosing attributes");

			SegmentationInteraction segInt = new SegmentationInteraction(driver);
			List<WebElement> divP = driver.findElements(By.className("col-4"));

			int qtdAttributesChecked = 0;// quantidade de atributos selecionados
			int qtdattributesSent = 0;// atributos enviados

			WebElement qtd = null;
			WebElement input = null;
			WebElement label = null;
			for (int i = 1; i < 3; i++) {
				qtd = divP.get(i).findElements(By.className("quantity-label")).get(0);
				label = divP.get(i).findElements(By.tagName("label")).get(0);
				input = divP.get(i).findElements(By.tagName("input")).get(0);

				for (int j = 0; j < listA.size(); j++)
					if (listA.get(j).getDescription().equals(label.getText()) && listA.get(j).isSent()) { // verifica se
																											// o
																											// atributo
																											// foi
																											// selecionado(enviado
																											// no casos
						qtdattributesSent++;

						qtd = divP.get(i).findElements(By.className("quantity-label")).get(0);
						label = divP.get(i).findElements(By.tagName("label")).get(0);
						input = divP.get(i).findElements(By.tagName("input")).get(0);

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
								qtdAttributesChecked++;
								if (i > 1) {
									waitToElementAndClick(qtd);
									segInt.changeQuantityToZero();
									listA.get(j).setQuantity(0);
									if (!input.isEnabled()) {
										log.info("The quantity of the attribute " + label.getText()
												+ " is 0 in this filter now");
									}
									if (input.isEnabled()) {
										log.info("Attribute should not be enable to be selected");
										throw new Exception("Attribute should not be enable to be selected");
									}

								}
							}

						} else {
							log.info("The quantity of the attribute " + label.getText() + " is 0 in this filter");
						}
						if (listA.get(j).getDescription().equals(label.getText()) && !listA.get(j).isSent())
							log.info(label.getText() + " was not sent in this test");
					}
				Thread.sleep(1000);
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

	public void clickListModeView() throws InterruptedException {
		try {
			waitToElementAndClick(btListMode);
		} catch (Exception e) {
			log.error("Error on click list Mode button");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public List<Attributes> chooseAttributesModeList(List<Attributes> listA) throws Exception {
		try {
			// Método responsavel por selecionar os atributos -- Sem alterar a quantidade
			// deles

			Thread.sleep(2000);
			while (driver.getPageSource().contains("Carregando")) {
				Thread.sleep(3000);
				log.info("Loading attributes");
			}

			log.info("Choosing attributes");

			int qtdAttributesChecked = 0;// quantidade de atributos selecionados
			int qtdattributesSent = 0;// atributos enviados

			WebElement table = driver.findElement(By.xpath("//*[@id=\"enrichment-page\"]/div[3]/div/table/tbody"));

			WebElement linha = null;
			WebElement coluna = null;
			WebElement input = null;
			WebElement label = null;

			driver.switchTo().activeElement();

			qtdAttributesChecked++;

			for (int i = 1; i < table.findElements(By.tagName("tr")).size(); i++) {
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
						label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
						input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);

						if (!quantidade.equals("0")) { // verifica se a quantidade do atributo não é zero
							waitToElementAndClick(label);
							if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
								log.info(label.getText() + " was not checked");
								Thread.sleep(2000);
								waitToElementAndClick(input);
							}
							if (input.isSelected()) {// atributo foi selecionado
								log.info(label.getText() + " was checked");
								qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
								int qtdS = listA.get(j).getQuantity();
								if (Integer.parseInt(quantidade) > 0 && Integer.parseInt(quantidade) >= qtdS && i > 1
										&& i < 6) {
									Thread.sleep(1000);
									coluna.findElement(By.id("quantity")).clear();
									sendElemet(coluna.findElement(By.id("quantity")), String.valueOf(qtdS));
									log.info("The quantity of " + label.getText() + " was changed to " + qtdS);
								} else {
									listA.get(j).setQuantity(Integer.parseInt(quantidade.replace(".", "")));
									// quantidade selecionada
								}

							}
						} else {
							log.info("The quantity of the attribute " + label.getText() + "  is 0 in this filter");
						}
						break;
					}

					if (listA.get(j).getDescription().equals(label.getText()) && !listA.get(j).isSent()) {
						log.info("  " + label.getText() + " was not sent in this test");
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

	public List<Attributes> chooseAttributes_ChangingQuantityToZeroListModeView(List<Attributes> listA)
			throws Exception {
		try {
			// Método responsavel por selecionar os atributos -- Mode list view

			Thread.sleep(2000);
			while (driver.getPageSource().contains("Carregando")) {
				Thread.sleep(3000);
				log.info("Loading attributes");
			}

			log.info("Choosing attributes");

			int qtdAttributesChecked = 0;// quantidade de atributos selecionados
			int qtdattributesSent = 0;// atributos enviados

			Thread.sleep(5000);

			driver.switchTo().activeElement();
			WebElement table = driver.findElement(By.xpath("//*[@id=\"enrichment-page\"]/div[3]/div/table/tbody"));

			WebElement linha = null;
			WebElement coluna = null;
			WebElement input = null;
			WebElement label = null;

			for (int i = 1; i < 3; i++) {// fazer um for em cada linha da tabela
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
						label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
						input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);

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
								if (Integer.parseInt(quantidade) > 2 && i > 0) {
									coluna.findElement(By.id("quantity")).clear();
									coluna.findElement(By.id("quantity")).sendKeys("0");
									listA.get(j).setQuantity(0);
									Thread.sleep(3000);
									if (!coluna.findElement(By.id("quantity")).getCssValue("border-color")
											.equals("rgb(220, 53, 69)")) { // verifica
										// se a
										// cor
										// da
										// borda
										// mudou
										// - Se
// a cor alterou é pq a quntidade
// enviada não é válida
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
							}
						} else {
							log.info("The quantity of the attribute " + label.getText() + "  is 0 in this filter");
						}
						break;
					}
					if (listA.get(j).getDescription().equals(label.getText()) && !listA.get(j).isSent()) {
						log.info("  " + label.getText() + " was not sent in this test");
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
		} catch (Exception e) {
			log.error("Error on attributes selection");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

}
