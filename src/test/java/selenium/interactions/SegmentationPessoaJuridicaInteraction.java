package selenium.interactions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import selenium.pageobjects.SegmentationPessoaJuridicaPage;

public class SegmentationPessoaJuridicaInteraction extends SegmentationPessoaJuridicaPage {

	private final Logger log = Logger.getLogger(SegmentationPessoaJuridicaInteraction.class);
	public static String dateList;

	public SegmentationPessoaJuridicaInteraction(final WebDriver driver) {
		super(driver);
	}

	public void chooseLocation(String locationState, String locationCity, String locationNeighborhood)
			throws Exception {
		// selecionado o filtro localização
		try {
			Thread.sleep(2000);
			if (!locationState.equals("")) { // selecionado os estados - podemos enviar mais de um estado
				String[] loc = locationState.split("&"); // o atributo estado sera enviado em uma unica string ,
															// separados por &
				waitToElementAndClick(places);
				log.info("Selecting places");
				waitToElementAndClick(stateBt);
				log.info("Selecting states");
				List<String> namesList = new ArrayList<>();
				for (int i = 0; i < loc.length; i++) // loop no array de todos os estados
					namesList.add(loc[i].toLowerCase());
				Collections.sort(namesList);

				for (int i = namesList.size() - 1; i >= 0; i--) {
					sendElemet(stateSearch, namesList.get(i));
					stateSearch.sendKeys(Keys.ENTER);
					waitToElementAndClick(stateFirstOption);
					log.info("State checked was " + namesList.get(i));
				}
			}
			if (!locationCity.equals("")) { // selecionado as cidades
				Thread.sleep(10000);
				String[] loc = locationCity.split("&");// o atributo cidade sera enviado em uma unica string , separadas
														// por &
				waitToElementAndClick(stateBt);
				waitToElementAndClick(cityBt);
				log.info("Selecting cities");
				List<String> namesList = new ArrayList<>();
				for (int i = 0; i < loc.length; i++) // loop no array de todos as cidades
					namesList.add(loc[i].toLowerCase());
				Collections.sort(namesList);
				for (int i = namesList.size() - 1; i >= 0; i--) {
					sendElemet(citySearch, namesList.get(i));
					citySearch.sendKeys(Keys.ENTER);
					waitToElementAndClick(cityFirstOption);
					log.info("City checked was " + namesList.get(i));
				}
				waitToElementAndClick(cityBt);
			}
			if (!locationNeighborhood.equals("")) {// selecionado os bairros
				Thread.sleep(10000);
				String[] loc = locationNeighborhood.split("&");// o atributo bairros sera enviado em uma unica string ,
																// separados por &

				List<String> namesList = new ArrayList<>();
				for (int i = 0; i < loc.length; i++) // loop no array de todas as profissões
					namesList.add(loc[i].toLowerCase());
				Collections.sort(namesList);
				waitToElementAndClick(neighborhoodBt);
				log.info("Selecting Neighborhoods");
				for (int i = namesList.size() - 1; i >= 0; i--) {
					sendElemet(neighborhoodSearch, namesList.get(i));
					neighborhoodSearch.sendKeys(Keys.ENTER);
					waitToElementAndClick(neighborhoodFirstOption);
					log.info("Neighborhood checked was " + namesList.get(i));
				}
				waitToElementAndClick(neighborhoodBt);
			}
			if (locationState.isEmpty()) {
				log.info("No State was sent");
			}
			if (locationCity.isEmpty()) {
				log.info("No city was sent");
			}
			if (locationNeighborhood.isEmpty()) {
				log.info("No neighborhood was sent");
			}
		} catch (Exception e) {
			log.error("Error in Location Filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void chooseEmployeeQt(String employeeQt) throws Exception {
		// Filtro quantidade de funcionários
		try {
			if (employeeQt.length() == 8) {// verifica se o formato enviado é correto
				String minEmployee = employeeQt.substring(0, 4);// os primeiros 4 caractes correspondem a numéro de
																// funcionários de (minimo)
				String maxEmployee = employeeQt.substring(4, 8);// os ultimos 4 caractes correspondem a numéro de
																// funcionários até (maximo)
				if (!minEmployee.equals("") && !maxEmployee.equals("")) {
					waitToElementAndClick(employee);
					log.info("Quantity of employees was checked");
					while (!employeeRangeMin.getAttribute("value").equals(minEmployee)) {
						sendElemet(employeeRangeMin, minEmployee);// envia o minimo
						Thread.sleep(2500);
					}
					if (!employeeRangeMin.getCssValue("border-color").equals("rgb(128, 148, 188)")
							|| Integer.parseInt(minEmployee) > 10000
							|| Integer.parseInt(minEmployee) > Integer.parseInt(maxEmployee)) { // verifico se a
						// borda mudou
						// de cor
						// (quantidade
						// de
						// funcionários
						// mínimo)
						log.error("Min Age sent is wrong");
						sendElemet(employeeRangeMin, "1");
						minEmployee = "1";
					}
					while (!employeeRangeMax.getAttribute("value").equals(maxEmployee)) {
						sendElemet(employeeRangeMax, maxEmployee);// envia o máximo
						Thread.sleep(2500);
					}
					Thread.sleep(1500);
					if (!employeeRangeMax.getCssValue("border-color").equals("rgb(128, 148, 188)")
							|| Integer.parseInt(maxEmployee) > 10000
							|| Integer.parseInt(minEmployee) > Integer.parseInt(maxEmployee)) {// verifico se a
						// borda mudou
						// de cor
						// (quantidade
						// de
						// funcionários
						// máxima)
						log.error("Max age sent is wrong");
						sendElemet(employeeRangeMax, "10000");
						maxEmployee = "10000";
					}
					log.info("Min Employee quantity was checked as " + minEmployee);
					log.info("Max Employee quantity was checked as " + maxEmployee);
				}
			} else {
				if (employeeQt.isEmpty()) {
					log.info("Employee quantity filter was not sent");
				}
				if (employeeQt.length() > 0 && employeeQt.length() < 8) {
					log.error("Employee quantity filter format sent was wrong");
				}
			}
		} catch (Exception e) {
			log.error("Error in Employees Filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void chooseFinance(String financeC) throws InterruptedException {
		try {
			// filtro Faturamento
			// Atributo enviado deve ter 6 caracteres e cada caracter corresponde a 1 range
			if (!financeC.isEmpty() && financeC.length() == 6) {
				String range1 = financeC.substring(0, 1); // primeiro caracter corresponde ao primeiro range
				String range2 = financeC.substring(1, 2);// segundo caracter corresponde ao segundo range
				String range3 = financeC.substring(2, 3);// terceiro caracter corresponde ao terceiro range
				String range4 = financeC.substring(3, 4);// quarto caracter corresponde ao quarto range
				String range5 = financeC.substring(4, 5);// quinto caracter corresponde ao quinto range
				String range6 = financeC.substring(5, 6);// sexto caracter corresponde ao sexto range

				if (range1.equals("1") || range2.equals("1") || range3.equals("1") || range4.equals("1")
						|| range5.equals("1") || range6.equals("1")) {// verifica se algum range é igual a 1 -> 1
																		// signifa que deve ser selecionado, 0 não deve
																		// ser selecionado

					waitToElementAndClick(finance);
					Thread.sleep(2000);
					log.info("Finance Filter was checked");
					if (range1.equals("1")) {
						try {
							log.info("Range até R$ 80.000 is on the list to be checked");
							waitToElementAndClick(rangeFinance1);
							log.info("Range até R$ 80.000 was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range até R$ 80.000");
							throw e;
						}
					}
					if (range2.equals("1")) {
						try {
							log.info("Range R$ 80.000 a R$ 360.000  is on the list to be checked");
							waitToElementAndClick(rangeFinance2);
							log.info("Range R$ 80.000 a R$ 360.000 was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range R$ 80.000 a R$ 360.000");
							throw e;
						}
					}
					if (range3.equals("1")) {
						try {
							log.info("Range R$ 360.000 a R$ 500.000  is on the list to be checked");
							waitToElementAndClick(rangeFinance3);
							log.info("Range R$ 360.000 a R$ 500.000 was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range R$ 360.000 a R$ 500.000");
							throw e;
						}
					}
					if (range4.equals("1")) {
						try {
							log.info("Range R$ 500.000 a R$ 800.000  is on the list to be checked");
							waitToElementAndClick(rangeFinance4);
							log.info("Range R$ 500.000 a R$ 800.000 was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range R$ 500.000 a R$ 800.000");
							throw e;
						}
					}
					if (range5.equals("1")) {
						try {
							log.info("Range R$ 800.000 a R$ 1.000.000  is on the list to be checked");
							waitToElementAndClick(rangeFinance5);
							log.info("Range R$ 800.000 a R$ 1.000.000 was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range R$ 800.000 a R$ 1.000.000");
							throw e;
						}
					}
					if (range6.equals("1")) {
						try {
							log.info("Range maior que 1.000.000 is on the list to be checked");
							waitToElementAndClick(rangeFinance6);
							log.info("Range maior que 1.000.000 was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range maior que 1.000.000");
							throw e;
						}
					}
				} else {
					log.info("No Finance Range was checked");
				}
			} else {
				if (financeC.isEmpty())
					log.info("No Finance Range was sent");
				if (financeC.length() > 0 & financeC.length() < 6)
					log.error("Finance filter format sent was wrong");
			}
		} catch (Exception e) {
			log.error("Error in Finance Filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void chooseFilterEmpresa() throws InterruptedException {
		try {
			waitForUrlToBe(getTestData("homePage"));
			// clicando no filtro Empresa
			Thread.sleep(10000);
			waitToElementAndClick(empresas);
		} catch (Exception e) {
			log.error("Error when it tries to go to Empresas session");
			log.error(e.getMessage());
			throw e;
		}
	}

	public void chooseType(String kindC) throws InterruptedException {
		//Natureza Jurídica
		try {
			if (!kindC.isEmpty()) {
				String[] kindList = kindC.split("&");
				waitToElementAndClick(kind);
				waitToElementAndClick(kindBt);
				List<String> namesList = new ArrayList<>();
				for (int i = 0; i < kindList.length; i++) // Loop no array da natureza jurídica
					namesList.add(kindList[i].toLowerCase());
				Collections.sort(namesList);
				for (int i = 0; i < namesList.size(); i++)
					System.out.println(namesList.get(i));
				for (int i = namesList.size() - 1; i >= 0; i--) {
					sendElemet(kindSearch, namesList.get(i));
					kindSearch.sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					waitToElementAndClick(kindFirstOption);
					log.info("Kind checked  was " + kindFirstOption.getText());
					log.info("Kind checked  was " + namesList.get(i));
				}
				waitToElementAndClick(kind);
			} else {
				log.info("Kind filter was not sent");
			}
			Thread.sleep(10000);
		} catch (Exception e) {
			log.error("Error in Type Filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void chooseSize(String sizeC) throws InterruptedException {
		// Porte Empresa
		try {
			if (!sizeC.isEmpty()) {
				log.info("Size filter was checked");
				String[] sizeList = sizeC.split("&");
				waitToElementAndClick(size);
				waitToElementAndClick(sizeBt);
				List<String> namesList = new ArrayList<>();
				for (int i = 0; i < sizeList.length; i++) // loop no array de todas as profissões
					namesList.add(sizeList[i].toLowerCase());
				Collections.sort(namesList);
				for (int i = namesList.size() - 1; i >= 0; i--) {
					sendElemet(sizeSearch, namesList.get(i));
					sizeSearch.sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					waitToElementAndClick(sizeFirstOption);
					log.info("Size checked  was " + sizeFirstOption.getText());
					log.info("Size checked  was " + namesList.get(i));
				}
				waitToElementAndClick(size);
			} else {
				log.info("Size filter was not sent");
			}
		} catch (Exception e) {
			log.error("Error in Size Filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void chooseOpeningDate(String dateC) throws InterruptedException {
		// Filtro data de abertura - se for igual a 1 , o filtro de data será escolhido
		// Range de data de 01-01-2000 até 31-01-2019
		try {
			if (dateC.equals("1")) {
				log.info("Opening Date filter will be checked");
				Thread.sleep(2000);
				waitToElementAndClick(opening);// filtro de data
				waitToElementAndClick(openingStart);// data inicia
				Select dropdownY = new Select(openingYear);// Ano inicial
				dropdownY.selectByIndex(19);
				Select dropdownM = new Select(openingMonth);// Mês inicial
				dropdownM.selectByIndex(0);
				waitToElementAndClick(openingStartDay);// Dia inicial
				Thread.sleep(3000);
				waitToElementAndClick(openingFinal); // data final
				dropdownY.selectByIndex(0);
				dropdownM.selectByIndex(0);
				waitToElementAndClick(openingFinalDay);// data final
				waitToElementAndClick(opening);
				log.info("Opening Date filter was checked");
				log.info("Start date was  01-01-2000");
				log.info("Final date was  31-01-2019");
			} else {
				log.info("Opening Date filter was not sent");
			}
		} catch (Exception e) {
			log.error("Error in Opening Date Filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void chooseActivity(String activityC) throws InterruptedException {
		// Filtro Atividade
		// Podemos enviar mais de uma atividade, separadas por &
		try {
			if (!activityC.isEmpty()) {
				String[] act = activityC.split("&");
				Thread.sleep(1000);
				List<String> namesList = new ArrayList<>();
				for (int i = 0; i < act.length; i++) // loop no array de todas as profissões
					namesList.add(act[i].toLowerCase());
				Collections.sort(namesList);
				waitToElementAndClick(activity);
				waitToElementAndClick(activityBt);
				for (int i = namesList.size() - 1; i >= 0; i--) {
					sendElemet(activitySearch, namesList.get(i));
					activitySearch.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					waitToElementAndClick(activityFirstOption);
					log.info("Activity checked  was " + activityFirstOption.getText());
					log.info("Activity checked was " + namesList.get(i));
				}
				waitToElementAndClick(activity);

			} else {
				log.info("Activity filter was not sent");
			}
		} catch (Exception e) {
			log.error("Error in Activity Filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void chooseStatus(String statusC) throws InterruptedException {
		try {
			// filtro Status empresa
			// Atributo enviado de ter 9 caracteres e cada caracter corresponde a 1 range
			if (!statusC.isEmpty() && statusC.length() == 9) {
				String range1 = statusC.substring(0, 1);
				String range2 = statusC.substring(1, 2);
				String range3 = statusC.substring(2, 3);
				String range4 = statusC.substring(3, 4);
				String range5 = statusC.substring(4, 5);
				String range6 = statusC.substring(5, 6);
				String range7 = statusC.substring(6, 7);
				String range8 = statusC.substring(7, 8);
				String range9 = statusC.substring(8, 9);

				if (range1.equals("1") || range2.equals("1") || range3.equals("1") || range4.equals("1")
						|| range5.equals("1") || range6.equals("1") || range7.equals("1") || range8.equals("1")
						|| range9.equals("1")) {

					waitToElementAndClick(status);
					log.info("Status Filter was checked");
					Thread.sleep(1000);
					if (range1.equals("1")) {
						try {
							log.info("Stutus Baixada is on the list to be checked");
							waitToElementAndClick(statusBaixada);
							log.info("Stutus Baixada was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Stutus Baixada");
							throw e;
						}
					}
					if (range2.equals("1")) {
						try {
							log.info("Status Baixada Exterior is on the list to be checked");
							waitToElementAndClick(statusBaixadaExterior);
							log.info("Status Baixada Exterior was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Status Baixada Exterior");
							throw e;
						}
					}
					if (range3.equals("1")) {
						try {
							log.info("Status Ativa is on the list to be checked");
							waitToElementAndClick(statusAtiva);
							log.info("Status Ativa was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Status Ativa");
							throw e;
						}
					}
					if (range4.equals("1")) {
						try {
							log.info("Status Ativa Exterior is on the list to be checked");
							waitToElementAndClick(statusAtivaExterior);
							log.info("Status Ativa Exterior was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Status Ativa Exterior");
							throw e;
						}
					}
					if (range5.equals("1")) {
						try {
							log.info("Status Inapta is on the list to be checked");
							waitToElementAndClick(statusInapta);
							log.info("Status Inapta was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Status Inapta");
							throw e;
						}
					}
					if (range6.equals("1")) {
						try {
							log.info("Status Nula is on the list to be checked");
							waitToElementAndClick(statusNula);
							log.info("Status Nula was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Status Nula");
							throw e;
						}
					}
					if (range7.equals("1")) {
						try {
							log.info("Status Nula Exterior is on the list to be checked");
							waitToElementAndClick(statusNulaExterior);
							log.info("Status Nula Exterior was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Status Nula Exterior");
							throw e;
						}
					}
					if (range8.equals("1")) {
						try {
							log.info("Status Suspensa is on the list to be checked");
							waitToElementAndClick(statusSuspensa);
							log.info("Status Suspensa was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Status Suspensa");
							throw e;
						}
					}
					if (range9.equals("1")) {
						try {
							log.info("Status Suspensa Exterior is on the list to be checked");
							waitToElementAndClick(statusSuspensaExterior);
							log.info("Status Suspensa Exterior was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Status Suspensa Exterior");
							throw e;
						}
					}
					waitToElementAndClick(status);
				} else {
					log.info("No Status Filter was checked");
				}
			} else {
				if (!statusC.isEmpty() && statusC.length() != 9)
					log.error("Status filter format sent was wrong");
				if (statusC.isEmpty())
					log.info("No Status Filter was not sent");
			}
		} catch (Exception e) {
			log.error("Error in Finance Filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void chooseDebts(String debtsC) throws InterruptedException {
		// filtro restrição
		try {
			if (debtsC.equals("1")) { // enviado 1 , signifa que selecionaremos os que tem restrição
				try {
					waitToElementAndClick(debts);
					Thread.sleep(1000);
					waitToElementAndClick(debtsYes);
					log.info("Yes Debts was checked");
				} catch (Exception e) {
					log.error("It was not possible to check Yes Debts Filter");
					throw e;
				}
			}
			if (debtsC.equals("0")) {// enviado 0 ,signifa que selecionaremos os que não tem restrição
				try {
					waitToElementAndClick(debts);
					Thread.sleep(1000);
					waitToElementAndClick(debtsNo);
					log.info("Yes Debts was checked");
				} catch (Exception e) {
					log.error("It was not possible to check No Debts Filter");
					throw e;
				}
			}
			if (debtsC.equals("2") || debtsC.length() != 1) {// enviado 2 ,signifa que não selecionaremos o filtro
				log.info("Debts Filter was not checked");
			}

		} catch (Exception e) {
			log.error("Error in Debts Filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	/*
	 * /public int[] chooseAttributesQuantityToZero(String attributes) { // Mudando
	 * a quantidade pra zero SegmentationInteraction segInt = new
	 * SegmentationInteraction(driver); if (attributes.length() == 31) { try {
	 * Thread.sleep(7000); if (attributes.substring(0, 1).equals("1")) { if
	 * (!cnpjQt.getText().equals("N.D.")) { waitToElementAndClick(cnpj); if
	 * (!inputCnpj.isSelected()) { log.info("Cnpj was not checked");
	 * waitToElementAndClick(cnpj); } if (inputCnpj.isSelected()) {
	 * log.info("Cnpj was checked"); waitToElementAndClick(cnpjQt);
	 * arrayQuantidade[0] = segInt.changeQuantityToZero();// mudando a quantidade
	 * pra zero if (!inputCnpj.isEnabled()) {
	 * log.info("The quantity of the attribute Cnpj is 0 in this filter now"); } if
	 * (inputCnpj.isEnabled()) {
	 * log.info("Cnpj should not be enable to be selected"); throw new
	 * Exception("Cnpj should not be enable to be selected"); } } } else {
	 * log.info("The quantity of the attribute Cnpj is 0 in this filter"); } } if
	 * (attributes.substring(0, 1).equals("0")) {
	 * log.info("Cnpj was was not chosen in this test"); } } catch (Exception e) {
	 * 
	 * } } return arrayQuantidade; }
	 * 
	 * 
	 * public void chooseAttributesQuantityToZeroListMode() throws Exception { //
	 * Mudar a quantidade do atributo para zero no modo lista
	 * log.info("The quantity of the attribute will be changed"); quantity.clear();
	 * quantity.sendKeys("0");// enviado quantidade zero
	 * log.info("The quantity of the attribute is 0 in this filter now");
	 * Thread.sleep(3000); if
	 * (!quantity.getCssValue("border-color").equals("rgb(220, 53, 69)")) { //
	 * verifica se a cor da borda mudou - Se // a cor alterou é pq a quntidade //
	 * enviada não é válida log.info(
	 * "The quantity of the attribute was changed to zero, but the color of the attribute did not change"
	 * ); throw new Exception(
	 * "The quantity of the attribute was changed to zero, but the color of the attribute did not change"
	 * ); } if (inputCnpj.isEnabled()) { // verifica se o atributo foi desabilidade
	 * log.info("Cnpj should not be enable to be selected"); throw new
	 * Exception("Attribute should not be enable to be selected");
	 * 
	 * } Thread.sleep(2000); } /
	 */
}
