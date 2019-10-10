package selenium.interactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import selenium.pageobjects.EnrichListPessoaJuridicaPage;

public class EnrichListPessoaJuridicaInteraction extends EnrichListPessoaJuridicaPage {

	private final Logger log = Logger.getLogger(EnrichListPessoaJuridicaInteraction.class);
	public static String dateList;

	public EnrichListPessoaJuridicaInteraction(final WebDriver driver) {
		super(driver);
	}

//	public void clickEnrichMenu() throws Exception {
//		Thread.sleep(13000);
//		waitToElementAndClick(enrichButton);
//	}
//
//	public void choosenListType(int type) throws Exception {
//		if (type == 1)
//			waitToElementAndClick(pf);
//		if (type == 2)
//			waitToElementAndClick(pj);
//	}
//
//	public void clickEnrichButton() throws Exception {
//		Thread.sleep(4000);
//		waitToElementAndClick(btEnrich);
//		Thread.sleep(4000);
//	}

/*	public int[] chooseAttributes(String atributos) throws Exception {

		// Enviamos um array de temanho 40 ( 40 atributos na pessoa física) - Se enviar
		// 1 , ele deve ser selecionado. Se enviar 0 , não deve ser selecionado.

		int qtdAttributesChecked = 0; // quantidade de atributos selecionados
		int qtdAttributesSent = 0; // atributos enviados
		if (atributos.length() == 31) {
			try {
				Thread.sleep(7000);
				if (atributos.substring(0, 1).equals("1")) { // verifica se o atributo foi selecionado(enviado no casos
					// de teste) - 1 é selecionado e 0 não é selecionado
					qtdAttributesSent++;
					if (!cnpjQtd.getText().equals("N.D.")) { // verifica se a quantidade do atributo não é zero
						if (!inputCnpj.isSelected())// verifica se ele foi mesmo selecionado
							log.info("Cnpj was noy checked");
						if (inputCnpj.isSelected()) {// atributo foi selecionado
							log.info("Cnpj was checked");
							qtdAttributesChecked++;// aumenta a quantidade de atributos selecionados
							String Qtd = cnpjQtd.getText().replace(".", "");// seleciona a quantidade do atributo
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[0] = Integer.parseInt(Qtd);// preenche o array com a quantidade selecionada
						}
					} else {
						log.info("The quantity of the attribute CNPJ is 0 in this filter");
					}
				}
				if (atributos.substring(0, 1).equals("0")) {
					log.info("CNPJ was not chosen in this test");
				}
				if (atributos.substring(1, 2).equals("1")) {
					qtdAttributesSent++;
					if (!razaoSocialQtd.getText().equals("N.D.")) {
						waitToElementAndClick(razaoSocial);// seleciona o atributo
						if (!inputRazaoSocial.isSelected())// verifica se ele foi mesmo selecionado
							log.info("Razão Social was checked");
						if (inputRazaoSocial.isSelected()) {// atributo foi selecionado
							log.info("Razão Social was checked");
							qtdAttributesChecked++;
							String Qtd = razaoSocialQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[1] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Razão Social is 0 in this filter");
					}
				}
				if (atributos.substring(1, 2).equals("0")) {
					log.info("Razão Social was not chosen in this test");
				}
				if (atributos.substring(2, 3).equals("1")) {
					qtdAttributesSent++;
					if (!situacaoRFQtd.getText().equals("N.D.")) {
						waitToElementAndClick(situacaoRF);
						if (!inputSituacaoRF.isSelected())
							log.info("Situação was checked");
						if (inputSituacaoRF.isSelected()) {
							log.info("Situação RF was checked");
							qtdAttributesChecked++;
							String Qtd = situacaoRFQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[2] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Situação RF is 0 in this filter");
					}

				}
				if (atributos.substring(2, 3).equals("0")) {
					log.info("Situação RF was not chosen in this test");
				}
				if (atributos.substring(3, 4).equals("1")) {
					qtdAttributesSent++;
					if (!dataFundacaoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(dataFundacao);
						if (!inputDataFundacao.isSelected())
							log.info("Data fundação was not checked");
						if (inputDataFundacao.isSelected()) {
							log.info("Data fundação was checked");
							qtdAttributesChecked++;
							String Qtd = dataFundacaoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[3] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Data Fundação is 0 in this filter");
					}
				}
				if (atributos.substring(3, 4).equals("0")) {
					log.info("Data Fundaçao was not chosen in this test");
				}
				if (atributos.substring(4, 5).equals("1")) {
					qtdAttributesSent++;
					if (!nomeFantasiaQtd.getText().equals("N.D.")) {
						waitToElementAndClick(nomeFantasia);
						if (!inputNomeFantasia.isSelected())
							log.info("Nome Fantasia was not checked");
						if (inputNomeFantasia.isSelected()) {
							log.info("Nome Fantasia was checked");
							qtdAttributesChecked++;
							String Qtd = nomeFantasiaQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[4] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Nome Fantasia is 0 in this filter");
					}
				}
				if (atributos.substring(4, 5).equals("0")) {
					log.info("Nome fantasia was not chosen in this test");
				}
				if (atributos.substring(5, 6).equals("1")) {
					qtdAttributesSent++;
					if (!emailQtd.getText().equals("N.D.")) {
						waitToElementAndClick(email);
						if (!inputEmail.isSelected())
							log.info("Email was not checked");
						if (inputEmail.isSelected()) {
							log.info("Email was checked");
							qtdAttributesChecked++;
							String Qtd = emailQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[5] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Email is 0 in this filter");
					}
				}
				if (atributos.substring(5, 6).equals("0")) {
					log.info("Email was not chosen in this test");
				}
				if (atributos.substring(6, 7).equals("1")) {
					qtdAttributesSent++;
					if (!telefone1Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone1);
						if (!inputTelefone1.isSelected())
							log.info("Telefone 1 was not checked");
						if (inputTelefone1.isSelected()) {
							log.info("Telefone 1 was checked");
							qtdAttributesChecked++;
							String Qtd = telefone1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[6] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 1 is 0 in this filter");
					}
				}
				if (atributos.substring(6, 7).equals("0")) {
					log.info("Telefone 1 was not chosen in this test");

				}
				if (atributos.substring(7, 8).equals("1")) {
					qtdAttributesSent++;
					if (!telefone2Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone2);
						if (!inputTelefone2.isSelected())
							log.info("Telefone 2 was not checked");
						if (inputTelefone2.isSelected()) {
							log.info("Telefone 2 was checked");
							qtdAttributesChecked++;
							String Qtd = telefone2Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[7] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 2 is 0 in this filter");
					}
				}
				if (atributos.substring(7, 8).equals("0")) {
					log.info("Telefone 2 was not chosen in this test");
				}
				if (atributos.substring(8, 9).equals("1")) {
					qtdAttributesSent++;
					if (!telefone3Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone3);
						if (!inputTelefone3.isSelected())
							log.info("Telefone 3 was not checked");
						if (inputTelefone3.isSelected()) {
							log.info("Telefone 3 was checked");
							qtdAttributesChecked++;
							String Qtd = telefone3Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[8] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 3 is 0 in this filter");
					}
				}
				if (atributos.substring(8, 9).equals("0")) {
					log.info("Telefone 3 was not chosen in this test");
				}
				if (atributos.substring(9, 10).equals("1")) {
					qtdAttributesSent++;
					if (!telefone4Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone4);
						if (!inputTelefone4.isSelected())
							log.info("Telefone 4 was not checked");
						if (inputTelefone4.isSelected()) {
							log.info("Telefone 4 was checked");
							qtdAttributesChecked++;
							String Qtd = telefone4Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[9] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 4 is 0 in this filter");
					}
				}
				if (atributos.substring(9, 10).equals("0")) {
					log.info("Telefone 4 was not chosen in this test");
				}
				if (atributos.substring(10, 11).equals("1")) {
					qtdAttributesSent++;
					if (!telefone5Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone5);
						if (!inputTelefone5.isSelected())
							log.info("Telefone 5 was not checked");
						if (inputTelefone5.isSelected()) {
							log.info("Telefone 5 was checked");
							qtdAttributesChecked++;
							String Qtd = telefone5Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[10] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 5 is 0 in this filter");
					}
				}
				if (atributos.substring(10, 11).equals("0")) {
					log.info("Telefone 5 was not chosen in this test");
				}
				if (atributos.substring(11, 12).equals("1")) {
					qtdAttributesSent++;
					if (!celular1Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular1);
						if (!inputCelular1.isSelected())
							log.info("Celular 1 was not checked");
						if (inputCelular1.isSelected()) {
							log.info("Celular 1 was checked");
							qtdAttributesChecked++;
							String Qtd = celular1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[11] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 1 is 0 in this filter");
					}
				}
				if (atributos.substring(11, 12).equals("0")) {
					log.info("Celular 1 was not chosen in this test");
				}
				if (atributos.substring(12, 13).equals("1")) {
					qtdAttributesSent++;
					if (!celular2Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular2);
						if (!inputCelular2.isSelected())
							log.info("Celular 2 was not checked");
						if (inputCelular2.isSelected()) {
							log.info("Celular 2 was checked");
							qtdAttributesChecked++;
							String Qtd = celular2Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[12] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 2 is 0 in this filter");
					}
				}
				if (atributos.substring(12, 13).equals("0")) {
					log.info("Celular 2 was not chosen in this test");
				}
				if (atributos.substring(13, 14).equals("1")) {
					qtdAttributesSent++;
					if (!celular3Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular3);
						if (!inputCelular3.isSelected())
							log.info("Celular 3 was not checked");
						if (inputCelular3.isSelected()) {
							log.info("Celular 3 was checked");
							qtdAttributesChecked++;
							String Qtd = celular3Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[13] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of attribute Celular 3 is 0 in this filter");
					}
				}
				if (atributos.substring(13, 14).equals("0")) {
					log.info("Celular 3 was not chosen in this test");
				}
				if (atributos.substring(14, 15).equals("1")) {
					qtdAttributesSent++;
					if (!celular4Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular4);
						if (!inputCelular4.isSelected())
							log.info("Celular 4 was not checked");
						if (inputCelular4.isSelected()) {
							log.info("Celular 4 was checked");
							qtdAttributesChecked++;
							String Qtd = celular4Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[14] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 4 is 0 in this filter");
					}
				}
				if (atributos.substring(14, 15).equals("0")) {
					log.info("Celular 4 was not chosen in this test");
				}
				if (atributos.substring(15, 16).equals("1")) {
					qtdAttributesSent++;
					if (!celular5Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular5);
						if (!inputCelular5.isSelected())
							log.info("Celular 5 was not checked");
						if (inputCelular5.isSelected()) {
							log.info("Celular 5 was checked");
							qtdAttributesChecked++;
							String Qtd = celular5Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[15] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 4 is 0 in this filter");
					}
				}
				if (atributos.substring(15, 16).equals("0")) {
					log.info("Celular 5 was not chosen in this test");
				}
				if (atributos.substring(16, 17).equals("1")) {
					qtdAttributesSent++;
					if (!whatsAppcelular1Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular1);
						if (!inputWhatsAppcelular1.isSelected())
							log.info("whatsAppcelular1 was not checked");
						if (inputWhatsAppcelular1.isSelected()) {
							log.info("whatsAppcelular1 was checked");
							qtdAttributesChecked++;
							String Qtd = whatsAppcelular1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[16] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular1 is 0 in this filter");
					}
				}
				if (atributos.substring(16, 17).equals("0")) {
					log.info("whatsAppcelular1 was not chosen in this test");
				}
				if (atributos.substring(17, 18).equals("1")) {
					qtdAttributesSent++;
					if (!whatsAppcelular2Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular2);
						if (!inputWhatsAppcelular2.isSelected())
							log.info("whatsAppcelular2 was not checked");
						if (inputWhatsAppcelular2.isSelected()) {
							log.info("whatsAppcelular2 was checked");
							qtdAttributesChecked++;
							String Qtd = whatsAppcelular2Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[17] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular2 is 0 in this filter");
					}
				}
				if (atributos.substring(17, 18).equals("0")) {
					log.info("WhatsAppcelular2 was not chosen in this test");
				}
				if (atributos.substring(18, 19).equals("1")) {
					qtdAttributesSent++;
					if (!whatsAppcelular3Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular3);
						if (!inputWhatsAppcelular3.isSelected())
							log.info("whatsAppcelular3 was not checked");
						if (inputWhatsAppcelular3.isSelected()) {
							log.info("whatsAppcelular3 was checked");
							qtdAttributesChecked++;
							String Qtd = whatsAppcelular3Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[18] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular3 is 0 in this filter");
					}
				}
				if (atributos.substring(18, 19).equals("0")) {
					log.info("WhatsAppcelular3 was not chosen in this test");
				}
				if (atributos.substring(19, 20).equals("1")) {
					qtdAttributesSent++;
					if (!whatsAppcelular4Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular4);
						if (!inputWhatsAppcelular4.isSelected())
							log.info("whatsAppcelular4 was not checked");
						if (inputWhatsAppcelular4.isSelected()) {
							log.info("whatsAppcelular4 was checked");
							qtdAttributesChecked++;
							String Qtd = whatsAppcelular1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[19] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular4 is 0 in this filter");
					}
				}
				if (atributos.substring(19, 20).equals("0")) {
					log.info("WhatsAppcelular3 was not chosen in this test");
				}
				if (atributos.substring(20, 21).equals("1")) {
					qtdAttributesSent++;
					if (!whatsAppcelular5Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular5);
						if (!inputWhatsAppcelular5.isSelected())
							log.info("whatsAppcelular5 was not checked");
						if (inputWhatsAppcelular5.isSelected()) {
							log.info("whatsAppcelular5 was checked");
							qtdAttributesChecked++;
							String Qtd = whatsAppcelular5Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[20] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular5 is 0 in this filter");
					}
				}
				if (atributos.substring(20, 21).equals("0")) {
					log.info("WhatsAppcelular5 was not chosen in this test");
				}
				if (atributos.substring(21, 22).equals("1")) {
					qtdAttributesSent++;
					if (!cnaeQtd.getText().equals("N.D.")) {
						waitToElementAndClick(cnae);
						if (!inputCnae.isSelected())
							log.info("Cnae was not checked");
						if (inputCnae.isSelected()) {
							log.info("Cnae was checked");
							qtdAttributesChecked++;
							String Qtd = cnaeQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[21] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Cnae is 0 in this filter");
					}
				}
				if (atributos.substring(21, 22).equals("0")) {
					log.info("Cnae was not chosen in this test");
				}
				if (atributos.substring(22, 23).equals("1")) {
					qtdAttributesSent++;
					if (!porteQtd.getText().equals("N.D.")) {
						waitToElementAndClick(porte);
						if (!inputPorte.isSelected())
							log.info("Porte da Empresa was not checked");
						if (inputPorte.isSelected()) {
							log.info("Porte da Empresa was checked");
							qtdAttributesChecked++;
							String Qtd = porteQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[22] = Integer.parseInt(Qtd);
						}

					} else {
						log.info("The quantity of the attribute Porte da Empresa is 0 in this filter");
					}
				}
				if (atributos.substring(22, 23).equals("0")) {
					log.info("Porte da Empresa was not chosen in this test");
				}
				if (atributos.substring(23, 24).equals("1")) {
					qtdAttributesSent++;
					if (!numeroFuncionariosQtd.getText().equals("N.D.")) {
						waitToElementAndClick(numeroFuncionarios);
						if (!inputNumeroFuncionarios.isSelected())
							log.info("Número de Funcionário was not checked");
						if (inputNumeroFuncionarios.isSelected()) {
							log.info("Número de Funcionário was checked");
							qtdAttributesChecked++;
							String Qtd = numeroFuncionariosQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[23] = Integer.parseInt(Qtd);
						}

					} else {
						log.info("The quantity of the attribute Número de Funcionário is 0 in this filter");
					}
				}
				if (atributos.substring(23, 24).equals("0")) {
					log.info("Número de Funcionário was not chosen in this test");
				}
				if (atributos.substring(24, 25).equals("1")) {
					qtdAttributesSent++;
					if (!faturamentoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(faturamento);
						if (!inputFaturamento.isSelected())
							log.info("Faturamento was not checked");
						if (inputFaturamento.isSelected()) {
							log.info("Faturamento was checked");
							qtdAttributesChecked++;
							String Qtd = faturamentoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[24] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Faturamento is 0 in this filter");
					}
				}
				if (atributos.substring(24, 25).equals("0")) {
					log.info("Faturamento was not chosen in this test");
				}
				if (atributos.substring(25, 26).equals("1")) {
					qtdAttributesSent++;
					if (!socio1Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(socio1);
						if (!inputSocio1.isSelected())
							log.info("Sócio 1 was checked");
						if (inputSocio1.isSelected()) {
							log.info("Sócio 1 was checked");
							qtdAttributesChecked++;
							String Qtd = socio1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[25] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Sócio 1 is 0 in this filter");
					}
				}
				if (atributos.substring(25, 26).equals("0")) {
					log.info("Sócio 1 was not chosen in this test");
				}
				if (atributos.substring(26, 27).equals("1")) {
					qtdAttributesSent++;
					if (!socio2Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(socio2);
						if (!inputSocio2.isSelected())
							log.info("Sócio 2 was checked");
						if (inputSocio2.isSelected()) {
							log.info("Sócio 2 was checked");
							qtdAttributesChecked++;
							String Qtd = socio2Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[26] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Sócio 2 is 0 in this filter");
					}
				}
				if (atributos.substring(26, 27).equals("0")) {
					log.info("Sócio 2 was not chosen in this test");
				}
				if (atributos.substring(27, 28).equals("1")) {
					qtdAttributesSent++;
					if (!socio3Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(socio3);
						if (!inputSocio3.isSelected())
							log.info("Sócio 3 was checked");
						if (inputSocio3.isSelected()) {
							log.info("Sócio 3 was checked");
							qtdAttributesChecked++;
							String Qtd = socio3Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[27] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Sócio 3 is 0 in this filter");
					}
				}
				if (atributos.substring(27, 28).equals("0")) {
					log.info("Sócio 3 was not chosen in this test");
				}
				if (atributos.substring(28, 29).equals("1")) {
					qtdAttributesSent++;
					if (!restricaoFinanceiraQtd.getText().equals("N.D.")) {
						waitToElementAndClick(restricaoFinanceira);
						if (!inputRestricaoFinanceira.isSelected())
							log.info("Restricao Financeira was not schecked");
						if (inputRestricaoFinanceira.isSelected()) {
							log.info("Restricao Financeira was checked");
							qtdAttributesChecked++;
							String Qtd = restricaoFinanceiraQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[28] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Restricao Financeira is 0 in this filter");
					}
				}
				if (atributos.substring(28, 29).equals("0")) {
					log.info("Restricao Financeira was not chosen in this test");
				}
				if (atributos.substring(29, 30).equals("1")) {
					qtdAttributesSent++;
					if (!sintegraQtd.getText().equals("N.D.")) {
						waitToElementAndClick(sintegra);
						if (!inputSintegra.isSelected())
							log.info("Síntegra was not checked");
						if (inputSintegra.isSelected()) {
							log.info("Síntegra was checked");
							qtdAttributesChecked++;
							String Qtd = sintegraQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[29] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Síntegra is 0 in this filter");
					}
				}
				if (atributos.substring(28, 30).equals("0")) {
					log.info("Síntegra was not chosen in this test");
				}
				if (atributos.substring(30, 31).equals("1")) {
					qtdAttributesSent++;
					if (!enderecoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(endereco);
						if (!inputEndereco.isSelected())
							log.info("Endereço was not checked");
						if (inputEndereco.isSelected()) {
							log.info("Endereço was checked");
							qtdAttributesChecked++;
							String Qtd = enderecoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[30] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Endereço is 0 in this filter");
					}
				}
				if (atributos.substring(30, 31).equals("0")) {
					log.info("Endereço was not chosen in this test");
				}
				log.info("" + qtdAttributesChecked + " attributess were checked");
				log.info("" + qtdAttributesSent + " attributess sent");
				if (qtdAttributesSent != qtdAttributesChecked) {
					log.error("Quantity of attributes checked was not the same sent in the file");
					throw new Exception("Quantity of attributes checked was not the same sent in the file");
				}
				return arrayQuantidade;
			} catch (Exception e) {
				log.error("It was not possible to select all attributes needed");
				log.error(e.getMessage());
				log.error(e.getStackTrace());
				throw e;
			}
		} else {
			log.error("Attributes format sent was wrong");
			throw new Exception("Attributes format sent was wrong");
		}

	}/*/
	

	/*	public int[] chooseAttributesChangingQuantity(String atributos) throws Exception {
		// Enviamos um array de temanho 31 (31 atributos na pessoa jurídica ) - Se
		// enviar
		// 1 , ele deve ser selecionado. Se enviar 0 , não deve ser selecionado.

		int qtdAttributesChecked = 0; // quantidade de atributos selecionados
		int qtdAttributesSent = 0; // atributos enviados
		SegmentationInteraction segInt = new SegmentationInteraction(driver);
		if (atributos.length() == 31) {
			try {
				Thread.sleep(7000);
				if (atributos.substring(0, 1).equals("1")) { // verifica se o atributo foi selecionado(enviado no casos
					// de teste) - 1 é selecionado e 0 não é selecionado
					qtdAttributesSent++;
					if (!cnpjQtd.getText().equals("N.D.")) { // verifica se a quantidade do atributo não é zero
						if (!inputCnpj.isSelected())// verifica se ele foi mesmo selecionado
							log.info("Cnpj was noy checked");
						if (inputCnpj.isSelected()) {// atributo foi selecionado
							log.info("Cnpj was checked");
							qtdAttributesChecked++;// aumenta a quantidade de atributos selecionados
							String Qtd = cnpjQtd.getText().replace(".", "");// seleciona a quantidade do atributo
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[0] = Integer.parseInt(Qtd);// preenche o array com a quantidade selecionada

						}
					} else {
						log.info("The quantity of the attribute CNPJ is 0 in this filter");
					}
				}
				if (atributos.substring(0, 1).equals("0")) {
					log.info("CNPJ was not chosen in this test");
				}
				if (atributos.substring(1, 2).equals("1")) {
					qtdAttributesSent++;
					if (!razaoSocialQtd.getText().equals("N.D.")) {
						waitToElementAndClick(razaoSocial);// seleciona o atributo
						if (!inputRazaoSocial.isSelected())// verifica se ele foi mesmo selecionado
							log.info("Razão Social was checked");
						if (inputRazaoSocial.isSelected()) {// atributo foi selecionado
							log.info("Razão Social was checked");
							qtdAttributesChecked++;
							String qtd = razaoSocialQtd.getText().replace(".", "");
							int quantidade = Integer.parseInt(qtd);
							System.out.println("q " + quantidade);
							waitToElementAndClick(razaoSocialQtd);
							arrayQuantidade[1] = segInt.changeQuantity(quantidade);
						}
					} else {
						log.info("The quantity of the attribute Razão Social is 0 in this filter");
					}
				}
				if (atributos.substring(1, 2).equals("0")) {
					log.info("Razão Social was not chosen in this test");
				}
				if (atributos.substring(2, 3).equals("1")) {
					qtdAttributesSent++;
					if (!situacaoRFQtd.getText().equals("N.D.")) {
						waitToElementAndClick(situacaoRF);
						if (!inputSituacaoRF.isSelected())
							log.info("Situação was checked");
						if (inputSituacaoRF.isSelected()) {
							log.info("Situação RF was checked");
							qtdAttributesChecked++;
							String qtd = situacaoRFQtd.getText().replace(".", "");
							int quantidade = Integer.parseInt(qtd);
							waitToElementAndClick(situacaoRFQtd);
							arrayQuantidade[2] = segInt.changeQuantity(quantidade);

						}
					} else {
						log.info("The quantity of the attribute Situação RF is 0 in this filter");
					}

				}
				if (atributos.substring(2, 3).equals("0")) {
					log.info("Situação RF was not chosen in this test");
				}
				if (atributos.substring(3, 4).equals("1")) {
					qtdAttributesSent++;
					if (!dataFundacaoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(dataFundacao);
						if (!inputDataFundacao.isSelected())
							log.info("Data fundação was not checked");
						if (inputDataFundacao.isSelected()) {
							log.info("Data fundação was checked");
							qtdAttributesChecked++;
							String qtd = dataFundacaoQtd.getText().replace(".", "");
							int quantidade = Integer.parseInt(qtd);
							waitToElementAndClick(dataFundacaoQtd);
							arrayQuantidade[3] = segInt.changeQuantity(quantidade);

						}
					} else {
						log.info("The quantity of the attribute Data Fundação is 0 in this filter");
					}
				}
				if (atributos.substring(3, 4).equals("0")) {
					log.info("Data Fundaçao was not chosen in this test");
				}
				if (atributos.substring(4, 5).equals("1")) {
					qtdAttributesSent++;
					if (!nomeFantasiaQtd.getText().equals("N.D.")) {
						waitToElementAndClick(nomeFantasia);
						if (!inputNomeFantasia.isSelected())
							log.info("Nome Fantasia was not checked");
						if (inputNomeFantasia.isSelected()) {
							log.info("Nome Fantasia was checked");

							qtdAttributesChecked++;
							String qtd = nomeFantasiaQtd.getText().replace(".", "");
							int quantidade = Integer.parseInt(qtd);
							waitToElementAndClick(nomeFantasiaQtd);
							arrayQuantidade[4] = segInt.changeQuantity(quantidade);

						}
					} else {
						log.info("The quantity of the attribute Nome Fantasia is 0 in this filter");
					}
				}
				if (atributos.substring(4, 5).equals("0")) {
					log.info("Nome fantasia was not chosen in this test");
				}
				if (atributos.substring(5, 6).equals("1")) {
					qtdAttributesSent++;
					if (!emailQtd.getText().equals("N.D.")) {
						waitToElementAndClick(email);
						if (!inputEmail.isSelected())
							log.info("Email was not checked");
						if (inputEmail.isSelected()) {
							log.info("Email was checked");
							qtdAttributesChecked++;
							String qtd = emailQtd.getText().replace(".", "");
							int quantidade = Integer.parseInt(qtd);
							waitToElementAndClick(emailQtd);
							arrayQuantidade[5] = segInt.changeQuantity(quantidade);

						}
					} else {
						log.info("The quantity of the attribute Email is 0 in this filter");
					}
				}
				if (atributos.substring(5, 6).equals("0")) {
					log.info("Email was not chosen in this test");
				}
				if (atributos.substring(6, 7).equals("1")) {
					qtdAttributesSent++;
					if (!telefone1Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone1);
						if (!inputTelefone1.isSelected())
							log.info("Telefone 1 was not checked");
						if (inputTelefone1.isSelected()) {
							log.info("Telefone 1 was checked");
							qtdAttributesChecked++;
							String Qtd = telefone1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[6] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 1 is 0 in this filter");
					}
				}
				if (atributos.substring(6, 7).equals("0")) {
					log.info("Telefone 1 was not chosen in this test");

				}
				if (atributos.substring(7, 8).equals("1")) {
					qtdAttributesSent++;
					if (!telefone2Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone2);
						if (!inputTelefone2.isSelected())
							log.info("Telefone 2 was not checked");
						if (inputTelefone2.isSelected()) {
							log.info("Telefone 2 was checked");
							qtdAttributesChecked++;
							String Qtd = telefone2Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[7] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 2 is 0 in this filter");
					}
				}
				if (atributos.substring(7, 8).equals("0")) {
					log.info("Telefone 2 was not chosen in this test");
				}
				if (atributos.substring(8, 9).equals("1")) {
					qtdAttributesSent++;
					if (!telefone3Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone3);
						if (!inputTelefone3.isSelected())
							log.info("Telefone 3 was not checked");
						if (inputTelefone3.isSelected()) {
							log.info("Telefone 3 was checked");
							qtdAttributesChecked++;
							String Qtd = telefone3Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[8] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 3 is 0 in this filter");
					}
				}
				if (atributos.substring(8, 9).equals("0")) {
					log.info("Telefone 3 was not chosen in this test");
				}
				if (atributos.substring(9, 10).equals("1")) {
					qtdAttributesSent++;
					if (!telefone4Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone4);
						if (!inputTelefone4.isSelected())
							log.info("Telefone 4 was not checked");
						if (inputTelefone4.isSelected()) {
							log.info("Telefone 4 was checked");
							qtdAttributesChecked++;
							String Qtd = telefone4Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[9] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 4 is 0 in this filter");
					}
				}
				if (atributos.substring(9, 10).equals("0")) {
					log.info("Telefone 4 was not chosen in this test");
				}
				if (atributos.substring(10, 11).equals("1")) {
					qtdAttributesSent++;
					if (!telefone5Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone5);
						if (!inputTelefone5.isSelected())
							log.info("Telefone 5 was not checked");
						if (inputTelefone5.isSelected()) {
							log.info("Telefone 5 was checked");
							qtdAttributesChecked++;
							String Qtd = telefone5Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[10] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 5 is 0 in this filter");
					}
				}
				if (atributos.substring(10, 11).equals("0")) {
					log.info("Telefone 5 was not chosen in this test");
				}
				if (atributos.substring(11, 12).equals("1")) {
					qtdAttributesSent++;
					if (!celular1Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular1);
						if (!inputCelular1.isSelected())
							log.info("Celular 1 was not checked");
						if (inputCelular1.isSelected()) {
							log.info("Celular 1 was checked");
							qtdAttributesChecked++;
							String Qtd = celular1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[11] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 1 is 0 in this filter");
					}
				}
				if (atributos.substring(11, 12).equals("0")) {
					log.info("Celular 1 was not chosen in this test");
				}
				if (atributos.substring(12, 13).equals("1")) {
					qtdAttributesSent++;
					if (!celular2Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular2);
						if (!inputCelular2.isSelected())
							log.info("Celular 2 was not checked");
						if (inputCelular2.isSelected()) {
							log.info("Celular 2 was checked");
							qtdAttributesChecked++;
							String Qtd = celular2Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[12] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 2 is 0 in this filter");
					}
				}
				if (atributos.substring(12, 13).equals("0")) {
					log.info("Celular 2 was not chosen in this test");
				}
				if (atributos.substring(13, 14).equals("1")) {
					qtdAttributesSent++;
					if (!celular3Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular3);
						if (!inputCelular3.isSelected())
							log.info("Celular 3 was not checked");
						if (inputCelular3.isSelected()) {
							log.info("Celular 3 was checked");
							qtdAttributesChecked++;
							String Qtd = celular3Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[13] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of attribute Celular 3 is 0 in this filter");
					}
				}
				if (atributos.substring(13, 14).equals("0")) {
					log.info("Celular 3 was not chosen in this test");
				}
				if (atributos.substring(14, 15).equals("1")) {
					qtdAttributesSent++;
					if (!celular4Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular4);
						if (!inputCelular4.isSelected())
							log.info("Celular 4 was not checked");
						if (inputCelular4.isSelected()) {
							log.info("Celular 4 was checked");
							qtdAttributesChecked++;
							String Qtd = celular4Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[14] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 4 is 0 in this filter");
					}
				}
				if (atributos.substring(14, 15).equals("0")) {
					log.info("Celular 4 was not chosen in this test");
				}
				if (atributos.substring(15, 16).equals("1")) {
					qtdAttributesSent++;
					if (!celular5Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular5);
						if (!inputCelular5.isSelected())
							log.info("Celular 5 was not checked");
						if (inputCelular5.isSelected()) {
							log.info("Celular 5 was checked");
							qtdAttributesChecked++;
							String Qtd = celular5Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[15] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 4 is 0 in this filter");
					}
				}
				if (atributos.substring(15, 16).equals("0")) {
					log.info("Celular 5 was not chosen in this test");
				}
				if (atributos.substring(16, 17).equals("1")) {
					qtdAttributesSent++;
					if (!whatsAppcelular1Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular1);
						if (!inputWhatsAppcelular1.isSelected())
							log.info("whatsAppcelular1 was not checked");
						if (inputWhatsAppcelular1.isSelected()) {
							log.info("whatsAppcelular1 was checked");
							qtdAttributesChecked++;
							String Qtd = whatsAppcelular1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[16] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular1 is 0 in this filter");
					}
				}
				if (atributos.substring(16, 17).equals("0")) {
					log.info("whatsAppcelular1 was not chosen in this test");
				}
				if (atributos.substring(17, 18).equals("1")) {
					qtdAttributesSent++;
					if (!whatsAppcelular2Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular2);
						if (!inputWhatsAppcelular2.isSelected())
							log.info("whatsAppcelular2 was not checked");
						if (inputWhatsAppcelular2.isSelected()) {
							log.info("whatsAppcelular2 was checked");
							qtdAttributesChecked++;
							String Qtd = whatsAppcelular2Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[17] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular2 is 0 in this filter");
					}
				}
				if (atributos.substring(17, 18).equals("0")) {
					log.info("WhatsAppcelular2 was not chosen in this test");
				}
				if (atributos.substring(18, 19).equals("1")) {
					qtdAttributesSent++;
					if (!whatsAppcelular3Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular3);
						if (!inputWhatsAppcelular3.isSelected())
							log.info("whatsAppcelular3 was not checked");
						if (inputWhatsAppcelular3.isSelected()) {
							log.info("whatsAppcelular3 was checked");
							qtdAttributesChecked++;
							String Qtd = whatsAppcelular3Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[18] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular3 is 0 in this filter");
					}
				}
				if (atributos.substring(18, 19).equals("0")) {
					log.info("WhatsAppcelular3 was not chosen in this test");
				}
				if (atributos.substring(19, 20).equals("1")) {
					qtdAttributesSent++;
					if (!whatsAppcelular4Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular4);
						if (!inputWhatsAppcelular4.isSelected())
							log.info("whatsAppcelular4 was not checked");
						if (inputWhatsAppcelular4.isSelected()) {
							log.info("whatsAppcelular4 was checked");
							qtdAttributesChecked++;
							String Qtd = whatsAppcelular1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[19] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular4 is 0 in this filter");
					}
				}
				if (atributos.substring(19, 20).equals("0")) {
					log.info("WhatsAppcelular3 was not chosen in this test");
				}
				if (atributos.substring(20, 21).equals("1")) {
					qtdAttributesSent++;
					if (!whatsAppcelular5Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular5);
						if (!inputWhatsAppcelular5.isSelected())
							log.info("whatsAppcelular5 was not checked");
						if (inputWhatsAppcelular5.isSelected()) {
							log.info("whatsAppcelular5 was checked");
							qtdAttributesChecked++;
							String Qtd = whatsAppcelular5Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[20] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular5 is 0 in this filter");
					}
				}
				if (atributos.substring(20, 21).equals("0")) {
					log.info("WhatsAppcelular5 was not chosen in this test");
				}
				if (atributos.substring(21, 22).equals("1")) {
					qtdAttributesSent++;
					if (!cnaeQtd.getText().equals("N.D.")) {
						waitToElementAndClick(cnae);
						if (!inputCnae.isSelected())
							log.info("Cnae was not checked");
						if (inputCnae.isSelected()) {
							log.info("Cnae was checked");
							qtdAttributesChecked++;
							String Qtd = cnaeQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[21] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Cnae is 0 in this filter");
					}
				}
				if (atributos.substring(21, 22).equals("0")) {
					log.info("Cnae was not chosen in this test");
				}
				if (atributos.substring(22, 23).equals("1")) {
					qtdAttributesSent++;
					if (!porteQtd.getText().equals("N.D.")) {
						waitToElementAndClick(porte);
						if (!inputPorte.isSelected())
							log.info("Porte da Empresa was not checked");
						if (inputPorte.isSelected()) {
							log.info("Porte da Empresa was checked");
							qtdAttributesChecked++;
							String Qtd = porteQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[22] = Integer.parseInt(Qtd);
						}

					} else {
						log.info("The quantity of the attribute Porte da Empresa is 0 in this filter");
					}
				}
				if (atributos.substring(22, 23).equals("0")) {
					log.info("Porte da Empresa was not chosen in this test");
				}
				if (atributos.substring(23, 24).equals("1")) {
					qtdAttributesSent++;
					if (!numeroFuncionariosQtd.getText().equals("N.D.")) {
						waitToElementAndClick(numeroFuncionarios);
						if (!inputNumeroFuncionarios.isSelected())
							log.info("Número de Funcionário was not checked");
						if (inputNumeroFuncionarios.isSelected()) {
							log.info("Número de Funcionário was checked");
							qtdAttributesChecked++;
							String Qtd = numeroFuncionariosQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[23] = Integer.parseInt(Qtd);
						}

					} else {
						log.info("The quantity of the attribute Número de Funcionário is 0 in this filter");
					}
				}
				if (atributos.substring(23, 24).equals("0")) {
					log.info("Número de Funcionário was not chosen in this test");
				}
				if (atributos.substring(24, 25).equals("1")) {
					qtdAttributesSent++;
					if (!faturamentoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(faturamento);
						if (!inputFaturamento.isSelected())
							log.info("Faturamento was not checked");
						if (inputFaturamento.isSelected()) {
							log.info("Faturamento was checked");
							qtdAttributesChecked++;
							String Qtd = faturamentoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[24] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Faturamento is 0 in this filter");
					}
				}
				if (atributos.substring(24, 25).equals("0")) {
					log.info("Faturamento was not chosen in this test");
				}
				if (atributos.substring(25, 26).equals("1")) {
					qtdAttributesSent++;
					if (!socio1Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(socio1);
						if (!inputSocio1.isSelected())
							log.info("Sócio 1 was checked");
						if (inputSocio1.isSelected()) {
							log.info("Sócio 1 was checked");
							qtdAttributesChecked++;
							String Qtd = socio1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[25] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Sócio 1 is 0 in this filter");
					}
				}
				if (atributos.substring(25, 26).equals("0")) {
					log.info("Sócio 1 was not chosen in this test");
				}
				if (atributos.substring(26, 27).equals("1")) {
					qtdAttributesSent++;
					if (!socio2Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(socio2);
						if (!inputSocio2.isSelected())
							log.info("Sócio 2 was checked");
						if (inputSocio2.isSelected()) {
							log.info("Sócio 2 was checked");
							qtdAttributesChecked++;
							String Qtd = socio2Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[26] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Sócio 2 is 0 in this filter");
					}
				}
				if (atributos.substring(26, 27).equals("0")) {
					log.info("Sócio 2 was not chosen in this test");
				}
				if (atributos.substring(27, 28).equals("1")) {
					qtdAttributesSent++;
					if (!socio3Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(socio3);
						if (!inputSocio3.isSelected())
							log.info("Sócio 3 was checked");
						if (inputSocio3.isSelected()) {
							log.info("Sócio 3 was checked");
							qtdAttributesChecked++;
							String Qtd = socio3Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[27] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Sócio 3 is 0 in this filter");
					}
				}
				if (atributos.substring(27, 28).equals("0")) {
					log.info("Sócio 3 was not chosen in this test");
				}
				if (atributos.substring(28, 29).equals("1")) {
					qtdAttributesSent++;
					if (!restricaoFinanceiraQtd.getText().equals("N.D.")) {
						waitToElementAndClick(restricaoFinanceira);
						if (!inputRestricaoFinanceira.isSelected())
							log.info("Restricao Financeira was not schecked");
						if (inputRestricaoFinanceira.isSelected()) {
							log.info("Restricao Financeira was checked");
							qtdAttributesChecked++;
							String Qtd = restricaoFinanceiraQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[28] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Restricao Financeira is 0 in this filter");
					}
				}
				if (atributos.substring(28, 29).equals("0")) {
					log.info("Restricao Financeira was not chosen in this test");
				}
				if (atributos.substring(29, 30).equals("1")) {
					qtdAttributesSent++;
					if (!sintegraQtd.getText().equals("N.D.")) {
						waitToElementAndClick(sintegra);
						if (!inputSintegra.isSelected())
							log.info("Síntegra was not checked");
						if (inputSintegra.isSelected()) {
							log.info("Síntegra was checked");
							qtdAttributesChecked++;
							String Qtd = sintegraQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[29] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Síntegra is 0 in this filter");
					}
				}
				if (atributos.substring(28, 30).equals("0")) {
					log.info("Síntegra was not chosen in this test");
				}
				if (atributos.substring(30, 31).equals("1")) {
					qtdAttributesSent++;
					if (!enderecoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(endereco);
						if (!inputEndereco.isSelected())
							log.info("Endereço was not checked");
						if (inputEndereco.isSelected()) {
							log.info("Endereço was checked");
							qtdAttributesChecked++;
							String Qtd = enderecoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + Qtd);
							arrayQuantidade[30] = Integer.parseInt(Qtd);
						}
					} else {
						log.info("The quantity of the attribute Endereço is 0 in this filter");
					}
				}
				if (atributos.substring(30, 31).equals("0")) {
					log.info("Endereço was not chosen in this test");
				}
				log.info("" + qtdAttributesChecked + " attributess were checked");
				log.info("" + qtdAttributesSent + " attributess sent");
				if (qtdAttributesSent != qtdAttributesChecked) {
					log.error("Quantity of attributes checked was not the same sent in the file");
					throw new Exception("Quantity of attributes checked was not the same sent in the file");
				}
				return arrayQuantidade;
			} catch (Exception e) {
				log.error("It was not possible to select all attributes needed");
				log.error(e.getMessage());
				log.error(e.getStackTrace());
				throw e;
			}
		} else {
			log.error("Attributes format sent was wrong");
			throw new Exception("Attributes format sent was wrong");
		}
	}/*/

	/*public int[] chooseAttributesQuantityToZero(String attributes) {
		// Mudando a quantidade pra zero
		SegmentationInteraction segInt = new SegmentationInteraction(driver);
		if (attributes.length() == 31) {
			try {
				Thread.sleep(7000);
				if (attributes.substring(1, 2).equals("1")) {
					if (!razaoSocialQtd.getText().equals("N.D.")) {
						waitToElementAndClick(razaoSocial);
						if (!inputRazaoSocial.isSelected()) {
							log.info("Razão Social was not checked");
							waitToElementAndClick(razaoSocial);
						}
						if (inputRazaoSocial.isSelected()) {
							log.info("Razão Social was checked");
							waitToElementAndClick(razaoSocialQtd);
							arrayQuantidade[1] = segInt.changeQuantityToZero();// mudando a quantidade pra zero
							if (!inputRazaoSocial.isEnabled()) {
								log.info("The quantity of the attribute Razão Social is 0 in this filter now");
							}
							if (inputRazaoSocial.isEnabled()) {
								log.info("Razão Social should not be enable to be selected");
								throw new Exception("Cpf should not be enable to be selected");
							}
						}
					} else {
						log.info("The quantity of the attribute Razão Social is 0 in this filter");
					}
				}
				if (attributes.substring(1, 2).equals("0")) {
					log.info("Razão Social was was not chosen in this test");
				}
			} catch (Exception e) {

			}
		}
		return arrayQuantidade;
	}/*/

	/*public int[] chooseAttributesModeList(String atributos) throws Exception {
		// Método responsavel por selecionar os atributos
		// Enviamos um array de temanho 31 (31 atributos na pessoa jurídica) - Se enviar
		// 1 , ele deve ser selecionado. Se enviar 0 , não deve ser selecionado.

		int qtdAttributesChecked = 0;// quantidade de atributos selecionados
		int qtdattributesSent = 0;// atributos enviados

		Thread.sleep(5000);

		driver.switchTo().activeElement();
		if (atributos.length() == 31) {
			try {

				WebElement table = driver
						.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/table/tbody"));

				WebElement linha = null;
				WebElement coluna = null;
				WebElement input = null;
				WebElement label = null;

				if (atributos.substring(0, 1).equals("1")) { // verifica se o atributo foi selecionado(enviado no casos
					qtdattributesSent++;
					linha = table.findElements(By.tagName("tr")).get(0);
					coluna = linha.findElements(By.tagName("td")).get(1);
					String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
					if (!quantidade.equals("0")) { // verifica se a quantidade do atributo não é zero
						label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
						waitToElementAndClick(label);
						input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
						if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
							log.info("Cnpj was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Cnpj was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[0] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada

						}
					} else {
						log.info("The quantity of the attribute Cnpj is 0 in this filter");
					}
				}

				if (atributos.substring(1, 2).equals("1")) { // verifica se o atributo foi selecionado(enviado no casos
					qtdattributesSent++;
					linha = table.findElements(By.tagName("tr")).get(1);
					coluna = linha.findElements(By.tagName("td")).get(1);
					String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
					if (!quantidade.equals("0")) { // verifica se a quantidade do atributo não é zero
						label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
						waitToElementAndClick(label);
						input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
						if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
							log.info("Razão Social was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Razão Social was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							if (Integer.parseInt(quantidade) > 2) {
								System.out.println("Entrei");
								int qtdS = Integer.parseInt(quantidade) - 1;
								System.out.println("Entrei " + qtdS);
								Thread.sleep(1000);
								coluna.findElement(By.id("quantity")).clear();
								coluna.findElement(By.id("quantity")).sendKeys(String.valueOf(qtdS));
								arrayQuantidade[1] = Integer.parseInt(quantidade) - 1; // preenche o array com a
																						// quantidade
								// selecionada
							} else {
								arrayQuantidade[1] = Integer.parseInt(quantidade); // preenche o array com a quantidade
							} // selecionada

						}
					} else {
						log.info("The quantity of the attribute Razão Social is 0 in this filter");
					}
				}
				if (atributos.substring(2, 3).equals("1")) { // verifica se o atributo foi selecionado(enviado no casos
					qtdattributesSent++;
					linha = table.findElements(By.tagName("tr")).get(2);
					coluna = linha.findElements(By.tagName("td")).get(1);
					String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
					if (!quantidade.equals("0")) { // verifica se a quantidade do atributo não é zero
						label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
						waitToElementAndClick(label);
						input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
						if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
							log.info("Situação RF was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Situação RF was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							if (Integer.parseInt(quantidade) > 2) {
								System.out.println("Entrei");
								int qtdS = Integer.parseInt(quantidade) - 1;
								System.out.println("Entrei " + qtdS);
								Thread.sleep(1000);
								coluna.findElement(By.id("quantity")).clear();
								coluna.findElement(By.id("quantity")).sendKeys(String.valueOf(qtdS));
								arrayQuantidade[2] = Integer.parseInt(quantidade) - 1; // preenche o array com a
																						// quantidade
								// selecionada
							} else {
								arrayQuantidade[2] = Integer.parseInt(quantidade); // preenche o array com a quantidade
							} // selecionada

						}
					} else {
						log.info("The quantity of the attribute Situação RF is 0 in this filter");
					}
				}

				if (atributos.substring(3, 4).equals("1")) { // verifica se o atributo foi selecionado(enviado no casos
					qtdattributesSent++;
					linha = table.findElements(By.tagName("tr")).get(3);
					coluna = linha.findElements(By.tagName("td")).get(1);
					String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
					if (!quantidade.equals("0")) { // verifica se a quantidade do atributo não é zero
						label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
						waitToElementAndClick(label);
						input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
						if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
							log.info("Data Fundacao was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Data Fundacao was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[3] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Data Fundacao is 0 in this filter");
					}
				}

				if (atributos.substring(4, 5).equals("1")) { // verifica se o atributo foi selecionado(enviado no casos
					qtdattributesSent++;
					linha = table.findElements(By.tagName("tr")).get(4);
					coluna = linha.findElements(By.tagName("td")).get(1);
					String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
					if (!quantidade.equals("0")) { // verifica se a quantidade do atributo não é zero
						label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
						waitToElementAndClick(label);
						input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
						if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
							log.info("Nome Fantasia was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Nome Fantasia was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[4] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Nome Fantasia is 0 in this filter");
					}
				}

				if (atributos.substring(5, 6).equals("1")) { // verifica se o atributo foi selecionado(enviado no casos
					qtdattributesSent++;
					linha = table.findElements(By.tagName("tr")).get(5);
					coluna = linha.findElements(By.tagName("td")).get(1);
					String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
					if (!quantidade.equals("0")) { // verifica se a quantidade do atributo não é zero
						label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
						waitToElementAndClick(label);
						input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
						if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
							log.info("Email was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Email was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[5] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Email is 0 in this filter");
					}
				}

				if (atributos.substring(6, 7).equals("1")) { // verifica se o atributo foi selecionado(enviado no casos
					qtdattributesSent++;
					linha = table.findElements(By.tagName("tr")).get(6);
					coluna = linha.findElements(By.tagName("td")).get(1);
					String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
					if (!quantidade.equals("0")) { // verifica se a quantidade do atributo não é zero
						label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
						waitToElementAndClick(label);
						input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
						if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
							log.info("Telefone 1 was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Telefone 1 was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[6] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Telefone 1 is 0 in this filter");
					}
				}

				if (atributos.substring(7, 8).equals("1")) { // verifica se o atributo foi selecionado(enviado no casos
					qtdattributesSent++;
					linha = table.findElements(By.tagName("tr")).get(7);
					coluna = linha.findElements(By.tagName("td")).get(1);
					String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
					if (!quantidade.equals("0")) { // verifica se a quantidade do atributo não é zero
						label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
						waitToElementAndClick(label);
						input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
						if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
							log.info("Telefone 2 was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Telefone 2 was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[7] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Telefone 2 is 0 in this filter");
					}
				}

				if (atributos.substring(8, 9).equals("1")) { // verifica se o atributo foi selecionado(enviado no casos
					qtdattributesSent++;
					linha = table.findElements(By.tagName("tr")).get(8);
					coluna = linha.findElements(By.tagName("td")).get(1);
					String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
					if (!quantidade.equals("0")) { // verifica se a quantidade do atributo não é zero
						label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
						waitToElementAndClick(label);
						input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
						if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
							log.info("Telefone 3 was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Telefone 3 was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[8] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Telefone 3 is 0 in this filter");
					}
				}

				if (atributos.substring(9, 10).equals("1")) { // verifica se o atributo foi selecionado(enviado no casos
					qtdattributesSent++;
					linha = table.findElements(By.tagName("tr")).get(9);
					coluna = linha.findElements(By.tagName("td")).get(1);
					String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
					if (!quantidade.equals("0")) { // verifica se a quantidade do atributo não é zero
						label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
						waitToElementAndClick(label);
						input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
						if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
							log.info("Telefone 4 was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Telefone 4 was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[9] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Telefone 4 is 0 in this filter");
					}
				}

				if (atributos.substring(10, 11).equals("1")) { // verifica se o atributo foi selecionado(enviado no
																// casos
					qtdattributesSent++;
					linha = table.findElements(By.tagName("tr")).get(10);
					coluna = linha.findElements(By.tagName("td")).get(1);
					String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
					if (!quantidade.equals("0")) { // verifica se a quantidade do atributo não é zero
						label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
						waitToElementAndClick(label);
						input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
						if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
							log.info("Telefone 5 was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Telefone 5 was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[10] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Telefone 5 is 0 in this filter");
					}
				}

				if (atributos.substring(11, 12).equals("1")) { // verifica se o atributo foi selecionado(enviado no
																// casos
					qtdattributesSent++;
					linha = table.findElements(By.tagName("tr")).get(11);
					coluna = linha.findElements(By.tagName("td")).get(1);
					String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
					if (!quantidade.equals("0")) { // verifica se a quantidade do atributo não é zero
						label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
						waitToElementAndClick(label);
						input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
						if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
							log.info("Celular 1 was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Celular 1 was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[11] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Celular 1 is 0 in this filter");
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
				return arrayQuantidade;

			} catch (Exception e) {
				log.error("It was not possible to select all attributes needed");
				log.error(e.getMessage());
				log.error(e.getStackTrace());
				throw e;
			}
		} else {
			log.error("Attributes format sent was wrong");
			throw new Exception("Attributes format sent was wrong");
		}

	}/*/

	/*	public void chooseAttributesQuantityToZeroListModeView(String atributos) throws Exception {
		// Mudar a quantidade do atributo para zero no modo lista
		log.info("The quantity of the attribute will be changed");

		WebElement table = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/table/tbody"));

		WebElement linha = null;
		WebElement coluna = null;
		WebElement input = null;
		WebElement label = null;

		if (atributos.substring(1, 2).equals("1")) { // verifica se o atributo foi selecionado(enviado no casos
			linha = table.findElements(By.tagName("tr")).get(1);
			coluna = linha.findElements(By.tagName("td")).get(1);
			String quantidade = coluna.findElement(By.id("quantity")).getAttribute("value");
			if (!quantidade.equals("0")) { // verifica se a quantidade do atributo não é zero
				label = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("label")).get(0);
				input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
				if (input.isSelected()) {// atributo foi selecionado
						log.info("Razão Social was checked");
						coluna.findElement(By.id("quantity")).clear();
						coluna.findElement(By.id("quantity")).sendKeys("0");
						arrayQuantidade[1] = 0; // preenche o array com a quantidade
						log.info("The quantity of the attribute Razão Social is 0 in this filter");
				}
			} else {
				log.info("The quantity of the attribute Razão Social is 0 in this filter");
			}
			Thread.sleep(4000);
			if (!coluna.findElement(By.id("quantity")).getCssValue("border-color").equals("rgb(220, 53, 69)")) { // verifica
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
			if (input.isEnabled()) { // verifica se o atributo foi desabilidade
				log.info("Razão Social should not be enable to be selected");
				throw new Exception("Attribute should not be enable to be selected");

			}
			Thread.sleep(2000);

		}

	}/*/
}
