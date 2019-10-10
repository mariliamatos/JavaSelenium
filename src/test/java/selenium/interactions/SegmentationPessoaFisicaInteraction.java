package selenium.interactions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import selenium.pageobjects.SegmentationPessoaFisicaPage;

public class SegmentationPessoaFisicaInteraction extends SegmentationPessoaFisicaPage {

	private final Logger log = Logger.getLogger(SegmentationPessoaFisicaInteraction.class);// Classe de log

	public SegmentationPessoaFisicaInteraction(final WebDriver driver) {
		super(driver);
	}

	public void chooseLocation(String locationState, String locationCity, String locationNeighborhood)
			throws Exception {
		// selecionado o filtro localização
		try {
			Thread.sleep(500);			if (!locationState.isEmpty()) { // selecionado os estados - podemos enviar mais de um estado
				String[] loc = locationState.split("&"); // o atributo estado sera enviado em uma unica string ,
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
			if (!locationCity.isEmpty()) { // selecionado as cidades
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
			if (!locationNeighborhood.isEmpty()) {// selecionado os bairros
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

	public void goToHistory() throws InterruptedException {
		try {
			waitToElementAndClick(btGoTohistoric);
			Thread.sleep(10000);
		} catch (Exception e) {
			log.error("It was possible to go to history");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void chooseGender(String genero) throws Exception {
		// Filtro gênero
		// tamanho de 2 caracteres - caracter 1 - Masculino e caracter 2 - Feminino
		// Enviado caracter igual a 1, selecionamos o gênero. Enviado igual 0 , não
		// selecionamos.
		try {
			if (!genero.isEmpty() && genero.length() == 2) {
				String masculineC = genero.substring(0, 1);
				String feminineC = genero.substring(1, 2);
				if (masculineC.equals("1") || feminineC.equals("1")) {
					Thread.sleep(3000);
					waitToElementAndClick(gender);
					if (masculineC.equals("1")) {
						try {
							waitToElementAndClick(masculine);
							log.info("Gender Masculine was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Masculine Filter");
							throw e;
						}
					}
					if (feminineC.equals("1")) {
						try {
							waitToElementAndClick(feminine);
							log.info("Gender Feminine was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Feminine Filter");
							throw e;
						}
					}
				} else {
					log.info("Gender was not checked");
				}
			} else {
				if (!genero.isEmpty() && genero.length() != 2)
					log.error("Gender filter format sent was wrong");
				if (genero.isEmpty()) {
					log.info("Gender was not sent");
				}
			}
		} catch (Exception e) {
			log.error("Error in Gender Filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void chooseProfession(String professionC) throws Exception {
		// selecionado filtro profissão
		try {
			if (!professionC.isEmpty()) {// verifica se profissão não é vazia
				String[] prof = professionC.split("&");// podemos enviar mais de uma profissão , separada por &
				List<String> namesList = new ArrayList<>();
				for (int i = 0; i < prof.length; i++) // loop no array de todas as profissões
					namesList.add(prof[i].toLowerCase());
				Collections.sort(namesList);
				waitToElementAndClick(profession);// seleciona o filtro profissão
				waitToElementAndClick(professionbt);
				for (int i = namesList.size() - 1; i >= 0; i--) {// loop no array de todas as profissões
					sendElemet(professionSearch, namesList.get(i));
					professionSearch.sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					waitToElementAndClick(professionFirstOption);
					Thread.sleep(2000);
					log.info("Profession send was " + namesList.get(i));
				}
				waitToElementAndClick(profession);

			} else {
				log.info("Profession filter was not sent");
			}
		} catch (Exception e) {

			log.error("Error in Profession Filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void chooseAge(String age) throws Exception {
		// selecionando o filtro Faixa etária
		try {
			Thread.sleep(1000);
			if (!age.isEmpty() && age.length() == 6) {// verifica se o formato enviado é correto
				String minAge = age.substring(0, 3);// os primeiros 3 caractes correspondem a idade minima
				Thread.sleep(1000);
				if (minAge.startsWith("0"))
					minAge = minAge.substring(1, 3);

				String maxAge = age.substring(3, 6);// os últimos caractes correspondem a idade maxima
				if (maxAge.startsWith("0"))
					maxAge = maxAge.substring(1, 3);

				if (!minAge.equals("") && !maxAge.equals("")) {
					waitToElementAndClick(demographic);// seleciona o filtro idade
					log.info("Age was checked");
					while (!demographicRangeMin.getAttribute("value").equals(minAge)) {
						sendElemet(demographicRangeMin, minAge);
						demographicRangeMin.sendKeys(Keys.ARROW_LEFT);
						demographicRangeMin.sendKeys(Keys.ARROW_LEFT);
						if (minAge.length() == 3)
							demographicRangeMin.sendKeys(Keys.ARROW_LEFT);
						demographicRangeMin.sendKeys(Keys.BACK_SPACE);
						demographicRangeMin.sendKeys(Keys.BACK_SPACE);
						demographicRangeMin.sendKeys(Keys.ARROW_RIGHT);
						demographicRangeMin.sendKeys(Keys.ARROW_RIGHT);
						if (minAge.length() == 3)
							demographicRangeMin.sendKeys(Keys.ARROW_RIGHT);
					} // envia a idade minima
					Thread.sleep(5000);
					if (Integer.parseInt(minAge) < 18 || Integer.parseInt(minAge) > 150
							|| Integer.parseInt(minAge) > Integer.parseInt(maxAge)) {// verifica se idade enviada é
																						// correta -
						System.out.println("color = " + demographicRangeMin.getCssValue("border-color")); // se a idade
						// não estiver
						// entre 18 e
						// 150 , e não
						// for menor que
						// a idade
						// máxima o
						// campo idade
						// minima fica
						// com a borda
						// vermelha
						log.error("Min Age sent is wrong");
						sendElemet(demographicRangeMin, "18");
						minAge = "018";
					}

					while (!demographicRangeMax.getAttribute("value").equals(maxAge)) {
						System.out.println(demographicRangeMax.getAttribute("value"));
						System.out.println("max = " + maxAge);
						sendElemet(demographicRangeMax, maxAge);
						demographicRangeMax.sendKeys(Keys.ARROW_LEFT);
						demographicRangeMax.sendKeys(Keys.ARROW_LEFT);
						if (maxAge.length() == 3)
							demographicRangeMax.sendKeys(Keys.ARROW_LEFT);
						demographicRangeMax.sendKeys(Keys.BACK_SPACE);
						demographicRangeMax.sendKeys(Keys.BACK_SPACE);
						demographicRangeMax.sendKeys(Keys.BACK_SPACE);
						demographicRangeMax.sendKeys(Keys.ARROW_RIGHT);
						demographicRangeMax.sendKeys(Keys.ARROW_RIGHT);
						if (maxAge.length() == 3)
							demographicRangeMax.sendKeys(Keys.ARROW_RIGHT);
					} // verifica se a idade
						// enviada é correta -
						// se a idade não
						// estiver entre 18 e
						// 150 , e não for maior
						// que a idade minima o
						// campo idade minima
						// fica com a borda
						// vermelha
					Thread.sleep(5000);
					if (Integer.parseInt(maxAge) < 18 || Integer.parseInt(maxAge) > 150
							|| Integer.parseInt(minAge) > Integer.parseInt(maxAge)) {
						log.error("Max age sent is wrong");
						sendElemet(demographicRangeMax, "150");
						maxAge = "150";
					}
					log.info("MinAge was checked as " + demographicRangeMin.getAttribute("value"));
					log.info("MaxAge was checked as " + demographicRangeMax.getAttribute("value"));
					waitToElementAndClick(demographic);
				}
			} else {
				if (!age.isEmpty() && age.length() != 6)
					log.info("Ages filter formtat was wrong");
				if (age.isEmpty())
					log.info("Ages filter was not sent");
			}
		} catch (Exception e) {

			log.error("Error in Age Filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void chooseFinance(String financeC) throws InterruptedException {
		try {
			// selecionando filtro Rendas
			if (!financeC.isEmpty() && financeC.length() == 6) { // string enviada vai ter tamanho igual a 6
				String range1 = financeC.substring(0, 1); // primeiro caracter corresponde ao primeiro range
				String range2 = financeC.substring(1, 2);// segundo caracter corresponde ao segundo range
				String range3 = financeC.substring(2, 3);// terceiro caracter corresponde ao terceiro range
				String range4 = financeC.substring(3, 4);// quarto caracter corresponde ao quarto range
				String range5 = financeC.substring(4, 5);// quinto caracter corresponde ao quinto range
				String range6 = financeC.substring(5, 6);// sexto caracter corresponde ao sexto range

				if (range1.equals("1") || range2.equals("1") || range3.equals("1") || range4.equals("1")
						|| range5.equals("1") || range6.equals("1")) { // verifica se algum range é igual a 1 -> 1
																		// signifa que deve ser selecionado, 0 não deve
																		// ser selecionado

					waitToElementAndClick(finance);
					Thread.sleep(2000);
					if (range1.equals("1")) {
						try {
							log.info("Range até R$ 788 is on the list to be checked");
							waitToElementAndClick(rangeFinance1);
							log.info("Range até R$ 788 was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range até R$ 788");
							throw e;
						}
					}
					if (range2.equals("1")) {
						try {
							log.info("Range R$ 788 a R$ 1.140  is on the list to be checked");
							waitToElementAndClick(rangeFinance2);
							log.info("Range R$ 788 a R$ 1.140 was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range R$ 788 a R$ 1.140");
							throw e;
						}
					}
					if (range3.equals("1")) {
						try {
							log.info("Range R$ 1.140 a R$ 1.900  is on the list to be checked");
							waitToElementAndClick(rangeFinance3);
							log.info("Range R$ 1.140 a R$ 1.900 was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range R$ 1.140 a R$ 1.900");
							throw e;
						}
					}
					if (range4.equals("1")) {
						try {
							log.info("Range R$ 1.900 a R$ 3.800  is on the list to be checked");
							waitToElementAndClick(rangeFinance4);
							log.info("Range R$ 1.900 a R$ 3.800 was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range R$ 1.900 a R$ 3.800");
							throw e;
						}
					}
					if (range5.equals("1")) {
						try {
							log.info("Range R$ 3.800 a R$ 7.600  is on the list to be checked");
							waitToElementAndClick(rangeFinance5);
							log.info("Range R$ 3.800 a R$ 7.600 was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range R$ 3.800 a R$ 7.600");
							throw e;
						}
					}
					if (range6.equals("1")) {
						try {
							log.info("Range maior que R$ 7.600 is on the list to be checked");
							waitToElementAndClick(rangeFinance6);
							log.info("Range maior que R$ 7.600 was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range maior que R$ 7.600");
							throw e;
						}
					}
				} else {
					log.info("No Finance Range was checked");
				}
			} else {
				if (!financeC.isEmpty() && financeC.length() != 6)
					log.error("Finance filter format sent was wrong");
				if (financeC.isEmpty()) {
					log.info("No Finance Range was sent");
				}
			}
		} catch (Exception e) {
			log.error("Error in Finance Filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void chooseSchool(String schoolC) throws Exception {
		try {
			// Filtro Escolaridade
			// Atributo enviado de ter 13 caracteres e cada caracter corresponde a 1 range
			if (!schoolC.isEmpty() && schoolC.length() == 13) {
				String range1 = schoolC.substring(0, 1);
				String range2 = schoolC.substring(1, 2);
				String range3 = schoolC.substring(2, 3);
				String range4 = schoolC.substring(3, 4);
				String range5 = schoolC.substring(4, 5);
				String range6 = schoolC.substring(5, 6);
				String range7 = schoolC.substring(6, 7);
				String range8 = schoolC.substring(7, 8);
				String range9 = schoolC.substring(8, 9);
				String range10 = schoolC.substring(9, 10);
				String range11 = schoolC.substring(10, 11);
				String range12 = schoolC.substring(11, 12);
				String range13 = schoolC.substring(12, 13);

				if (range1.equals("1") || range2.equals("1") || range3.equals("1") || range4.equals("1")
						|| range5.equals("1") || range6.equals("1") || range7.equals("1") || range8.equals("1")
						|| range9.equals("1") || range10.equals("1") || range11.equals("1") || range12.equals("1")
						|| range13.equals("1")

				) {
					Thread.sleep(1000);
					waitToElementAndClick(school);
					Thread.sleep(2000);
					if (range1.equals("1")) {
						try {
							log.info("Range ANALFABETO is on the list to be checked");
							waitToElementAndClick(rangeSchool1);
							log.info("Range ANALFABETO was checked");
						} catch (Exception e) {
							log.info("It was not possible to check Range ANALFABETO");
						}
					}
					if (range2.equals("1")) {
						try {
							log.info("Range ENSINO FUNDAMENTAL INCOMPLETO is on the list to be checked");
							waitToElementAndClick(rangeSchool2);
							log.info("Range ENSINO FUNDAMENTAL INCOMPLETO was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range ENSINO FUNDAMENTAL INCOMPLETO");
							throw e;
						}
					}
					if (range3.equals("1")) {
						try {
							log.info("Range ENSINO FUNDAMENTAL COMPLETO is on the list to be checked");
							waitToElementAndClick(rangeSchool3);
							log.info("Range ENSINO FUNDAMENTAL COMPLETO was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range ENSINO FUNDAMENTAL COMPLETO");
							throw e;
						}
					}
					if (range4.equals("1")) {
						try {
							log.info("Range ENSINO ENSINO MÉDIO INCOMPLETO is on the list to be checked");
							waitToElementAndClick(rangeSchool4);
							log.info("Range ENSINO ENSINO MÉDIO INCOMPLETO was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range ENSINO ENSINO MÉDIO INCOMPLETO");
							throw e;
						}
					}
					if (range5.equals("1")) {
						try {
							log.info("Range ENSINO MÉDIO COMPLETO is on the list to be checked");
							waitToElementAndClick(rangeSchool5);
							log.info("Range ENSINO MÉDIO COMPLETO was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range ENSINO ENSINO MÉDIO COMPLETO");
							throw e;
						}
					}
					if (range6.equals("1")) {
						try {
							log.info("Range SUPERIO INCOPLETO is on the list to be checked");
							waitToElementAndClick(rangeSchool6);
							log.info("Range SUPERIO INCOPLETO was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range SUPERIO INCOPLETO");
							throw e;
						}
					}
					if (range7.equals("1")) {
						try {
							log.info("Range SUPERIO COMPLETO is on the list to be checked");
							waitToElementAndClick(rangeSchool7);
							log.info("Range SUPERIO COMPLETO was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range SUPERIO COPLETO");
							throw e;
						}
					}
					if (range8.equals("1")) {
						try {
							log.info("Range PÓS GRADUAÇÃO INCOMPLETA is on the list to be checked");
							waitToElementAndClick(rangeSchool8);
							log.info("Range PÓS GRADUAÇÃO INCOMPLETA was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range PÓS GRADUAÇÃO INCOMPLETA");
							throw e;
						}
					}
					if (range9.equals("1")) {
						try {
							log.info("Range PÓS GRACUAÇÃO COMPLETA is on the list to be checked");
							waitToElementAndClick(rangeSchool9);
							log.info("Range PÓS GRACUAÇÃO COMPLETA was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range PÓS GRADUAÇÃO COMPLETA");
							throw e;
						}
					}
					if (range10.equals("1")) {
						try {
							log.info("Range MESTRADO INCOMPLETO is on the list to be checked");
							waitToElementAndClick(rangeSchool10);
							log.info("Range MESTRADO INCOMPLETO was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range MESTRADO INCOMPLETO");
							throw e;
						}
					}
					if (range11.equals("1")) {
						try {
							log.info("Range MESTRADO COMPLETO is on the list to be checked");
							waitToElementAndClick(rangeSchool11);
							log.info("Range MESTRADO COMPLETO was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range MESTRADO COMPLETO");
							throw e;
						}
					}
					if (range12.equals("1")) {
						try {
							log.info("Range DOUTORADO INCOMPLETO is on the list to be checked");
							waitToElementAndClick(rangeSchool12);
							log.info("Range DOUTORADO INCOMPLETO was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range DOUTORADO INCOMPLETO");
							throw e;
						}
					}
					if (range13.equals("1")) {
						try {
							log.info("Range DOUTORADO COMPLETO is on the list to be checked");
							waitToElementAndClick(rangeSchool13);
							log.info("Range DOUTORADO COMPLETO was checked");
						} catch (Exception e) {
							log.error("It was not possible to check Range DOUTORADO COMPLETO");
							throw e;
						}

					}

				} else {
					log.info("No School Range was checked");
				}
			} else {
				if (!schoolC.isEmpty() && schoolC.length() != 13)
					log.error("School filter format sent was wrong");
				if (schoolC.isEmpty())
					log.info("No School Range was sent");
			}
		} catch (Exception e) {
			log.error("Error in School Filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void chooseDebts(String debtsC) throws InterruptedException {
		// Filtro restrição
		try {
			if (debtsC.equals("1")) { // enviado 1 , significa que selecionaremos os que tem restrição
				try {
					waitToElementAndClick(debts); // Filtro restrição
					Thread.sleep(1000);
					waitToElementAndClick(debtsYes); // Restrição - Sim
					log.info("Yes Debts was checked");
				} catch (Exception e) {
					log.error("It was not possible to check Yes Debts Filter");
					throw e;
				}
			}
			if (debtsC.equals("0")) { // enviado 0 ,signifa que selecionaremos os que não tem restrição
				try {
					waitToElementAndClick(debts); // Filtro restrição
					Thread.sleep(1000);
					waitToElementAndClick(debtsNo); // Restrição - Não
					log.info("No Debts was checked");
				} catch (Exception e) {
					log.error("It was not possible to check No Debts Filter");
					throw e;
				}
			}
			if (debtsC.equals("2") || debtsC.length() != 1) {// enviado 2 ,signifa que não selecionaremos o filtro
				log.info("Debts Filter was not sent");
				log.info("Debts Filter sent was " + debtsC);
			}
			
		} catch (Exception e) {
			log.error("Error in Debts Filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void chooseProperties(String propertiesC) throws InterruptedException {
		// Filtro bens
		try {
			if (propertiesC.equals("1")) {// enviado 1 ,signifa que selecionaremos os usuários que tem bens
				try {
					waitToElementAndClick(properties);// Filtro bens
					Thread.sleep(1000);
					waitToElementAndClick(propertiesYes);// Filtro bens - Sim
					log.info("Yes Properties was checked");
				} catch (Exception e) {
					log.error("It was not possible to check Yes Properties Filter");
					throw e;
				}
			}
			if (propertiesC.equals("0")) {// enviado 0 ,signifa que selecionaremos os que não tem bens
				try {
					waitToElementAndClick(properties);// Filtro bens
					Thread.sleep(1000);
					waitToElementAndClick(propertiesNo);// Filtro bens - Não
					log.info("No Properties was checked");
				} catch (Exception e) {
					log.error("It was not possible to check No Properties Filter");
					throw e;
				}
			}
			if (propertiesC.equals("2") || propertiesC.length() != 1) {// enviado 2 ,signifa que não selecionaremos o
																		// filtro
				log.info("Properties Filter was not sent");
				log.info("Properties Filter sent was " + propertiesC);

			}
			Thread.sleep(5000);
		} catch (Exception e) {
			log.error("Error in Properties filter");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	/*
	 * public int[] chooseAttributesQuantityToZero(String attributes) { // Mudando a
	 * quantidade pra zero SegmentationInteraction segInt = new
	 * SegmentationInteraction(driver); if (attributes.length() == 40) { try {
	 * Thread.sleep(7000); if (attributes.substring(0, 1).equals("1")) { if
	 * (!cpfQtd.getText().equals("N.D.")) { waitToElementAndClick(cpf); if
	 * (!inputCpf.isSelected()) { log.info("Cpf was not checked");
	 * waitToElementAndClick(cpf); } if (inputCpf.isSelected()) {
	 * waitToElementAndClick(cpfQtd); arrayQuantidade[0] =
	 * segInt.changeQuantityToZero();// mudando a quantidade pra zero if
	 * (!inputCpf.isEnabled()) {
	 * log.info("The quantity of the attribute Cpf is 0 in this filter now"); } if
	 * (inputCpf.isEnabled()) { log.info("Cpf should not be enable to be selected");
	 * throw new Exception("Cpf should not be enable to be selected"); } } } else {
	 * log.info("The quantity of the attribute Cpf is 0 in this filter"); } } if
	 * (attributes.substring(0, 1).equals("0")) {
	 * log.info("CPF was was not chosen in this test"); } } catch (Exception e) {
	 * 
	 * } } return arrayQuantidade; }
	 * 
	 * 
	 * public void chooseAttributesQuantityToZeroOnCart() throws Exception { //
	 * Alteração da quantidade para Zero - No carrinho
	 * 
	 * log.info("The quantity of the attribute will be changed"); String windows =
	 * driver.getWindowHandle(); driver.switchTo().window(windows);
	 * Thread.sleep(1000); quantity.clear(); quantity.sendKeys("0");// mudando a
	 * quantidade pra zero
	 * log.info("The quantity of the attribute is 0 in this filter now");
	 * Thread.sleep(2500); System.out.println(" " +
	 * quantity.getCssValue("border-color")); if
	 * (!quantity.getCssValue("border-color").equals("rgb(220, 53, 69)")) { //
	 * verifica se a cor da borda mudou - Se // a cor alterou é pq a quntidade //
	 * enviada não é válida log.info(
	 * "The quantity of the attribute was changed to zero, but the color of the attribute did not change"
	 * ); throw new Exception(
	 * "The quantity of the attribute was changed to zero, but the color of the attribute did not change"
	 * ); } if (inputCpf.isEnabled()) { // verifica se o atributo foi desabilidade
	 * log.info("Cpf should not be enable to be selected"); throw new
	 * Exception("Attribute should not be enable to be selected"); }
	 * Thread.sleep(2000); } /
	 * 
	 * 
	 * public void chooseAttributesQuantityToZeroListMode() throws Exception { //
	 * Mudar a quantidade do atributo para zero no modo lista
	 * log.info("The quantity of the attribute will be changed");
	 * quantity.sendKeys("0");// enviado quantidade zero
	 * log.info("The quantity of the attribute is 0 in this filter now");
	 * Thread.sleep(3000); if
	 * (!quantity.getCssValue("border-color").equals("rgb(220, 53, 69)")) { //
	 * verifica se a cor da borda mudou - Se // a cor alterou é pq a quntidade //
	 * enviada não é válida log.info(
	 * "The quantity of the attribute was changed to zero, but the color of the attribute did not change"
	 * ); throw new Exception(
	 * "The quantity of the attribute was changed to zero, but the color of the attribute did not change"
	 * ); } if (inputCpf.isEnabled()) { // verifica se o atributo foi desabilidade
	 * log.info("Cpf should not be enable to be selected"); throw new
	 * Exception("Attribute should not be enable to be selected");
	 * 
	 * } Thread.sleep(2000); }
	 */

}
