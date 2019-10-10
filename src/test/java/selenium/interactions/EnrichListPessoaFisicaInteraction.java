package selenium.interactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.pageobjects.EnrichListPessoaFisicaPage;

public class EnrichListPessoaFisicaInteraction extends EnrichListPessoaFisicaPage {

	private final Logger log = Logger.getLogger(EnrichListPessoaFisicaInteraction.class);
	public static String dateList;
	private int[] arrayQuantidade = new int[40];// array que irá guardar a quantidade de atributos selecionado na tela

	public EnrichListPessoaFisicaInteraction(final WebDriver driver) {
		super(driver);
	}
/*
	public int[] chooseAttributes(String atributos) throws Exception {
		// Array de temanho 40 ( 40 atributos na pessoa física) - Se enviar 1 , ele deve
		// ser selecionado. Se enviar 0 , não deve ser selecionado.

		// Escolhendo os atributos
		int qtdAttributesChecked = 0;
		int qtdattributesSent = 0;
		driver.switchTo().activeElement();
		if (atributos.length() == 40) {// verifica se a string tem tamanho 40

			try {
				Thread.sleep(9000);
				if (atributos.substring(0, 1).equals("1")) {// verifica se o atributo 1 foi selecionado - 1 para
															// selecionado / 0 - para não selecionado
					qtdattributesSent++;
					if (!cpfQtd.getText().equals("N.D.")) {// verifica se a quantidade é maior que zero
						if (!inputCpf.isSelected()) {// verifica se o atributo foi selecionado
							log.info("Cpf was not checked");
						}
						if (inputCpf.isSelected()) { // atributo selecionado
							log.info("Cpf was checked");
							qtdAttributesChecked++;// aumenta a quantidade de atributos selecionados
							String qtd = cpfQtd.getText().replace(".", "");// seleciona a quantiade do atributo
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[0] = Integer.parseInt(qtd);// guarda a quantidade do atributo no array
						}
					} else {
						log.info("The quantity of the attribute Cpf is 0 in this filter");
					}
				}
				if (atributos.substring(0, 1).equals("0")) {
					log.info("CPF was was not chosen in this test");
				}
				if (atributos.substring(1, 2).equals("1")) {
					qtdattributesSent++;
					if (!nomeQtd.getText().equals("N.D.")) {
						waitToElementAndClick(nome);
						if (!inputNome.isSelected()) {
							log.info("Nome was not checked");
							waitToElementAndClick(nome);
						}
						if (inputNome.isSelected()) {
							log.info("Nome was checked");
							qtdAttributesChecked++;
							String qtd = nomeQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[1] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Nome is 0 in this filter");
					}
				}
				if (atributos.substring(1, 2).equals("0")) {
					log.info("Nome was was not chosen in this test");
				}
				if (atributos.substring(2, 3).equals("1")) {
					qtdattributesSent++;
					if (!situacaoRFQtd.getText().equals("N.D.")) {
						waitToElementAndClick(situacaoRF);
						if (!inputSituacaoRF.isSelected()) {
							waitToElementAndClick(situacaoRF);
							log.info("Situação RF was not checked");
						}
						if (inputSituacaoRF.isSelected()) {
							log.info("Situação RF was checked");
							qtdAttributesChecked++;
							String qtd = situacaoRFQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[2] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Situação RF is 0 in this filter");
					}
				}
				if (atributos.substring(2, 3).equals("0")) {
					log.info("Situação RF was was not chosen in this test");
				}
				if (atributos.substring(3, 4).equals("1")) {
					qtdattributesSent++;
					if (!enderecoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(endereco);
						if (!inputEndereco.isSelected()) {
							log.info("Endereço was not checked");
							waitToElementAndClick(endereco);
						}
						if (inputEndereco.isSelected()) {
							log.info("Endereço was checked");
							qtdAttributesChecked++;
							String qtd = enderecoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[3] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Endereço is 0 in this filter");
					}
				}
				if (atributos.substring(3, 4).equals("0")) {
					log.info("Endereço was was not chosen in this test");
				}
				if (atributos.substring(4, 5).equals("1")) {
					qtdattributesSent++;
					if (!dataNascimentoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(dataNascimento);
						if (!inputDataNascimento.isSelected()) {
							log.info("Data de Nascimento was not checked");
							waitToElementAndClick(dataNascimento);
						}
						if (inputDataNascimento.isSelected()) {
							log.info("Data de Nascimento was checked");
							qtdAttributesChecked++;
							String qtd = dataNascimentoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[4] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Data de Nascimento is 0 in this filter");
					}
				}
				if (atributos.substring(4, 5).equals("0")) {
					log.info("Data de Nascimento was not chosen in this test");
				}
				if (atributos.substring(5, 6).equals("1")) {
					qtdattributesSent++;
					if (!generoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(genero);
						if (!inputGenero.isSelected()) {
							log.info("Gênero was not checked");
							waitToElementAndClick(genero);
						}
						if (inputGenero.isSelected()) {
							log.info("Gênero was checked");
							qtdAttributesChecked++;
							String qtd = generoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[5] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Gênero is 0 in this filter");
					}
				}
				if (atributos.substring(5, 6).equals("0")) {
					log.info("Gênero was not chosen in this test");
				}
				if (atributos.substring(6, 7).equals("1")) {
					qtdattributesSent++;
					if (!escolaridadeQtd.getText().equals("N.D.")) {
						waitToElementAndClick(escolaridade);
						if (!inputEscolaridade.isSelected()) {
							waitToElementAndClick(escolaridade);
							log.info("Escolaridade was not checked");
						}
						if (inputEscolaridade.isSelected()) {
							log.info("Escolaridade was checked");
							qtdAttributesChecked++;
							String qtd = escolaridadeQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[6] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Escolaridade is 0 in this filter");
					}
				}
				if (atributos.substring(6, 7).equals("0")) {
					log.info("Escolaridade was not chosen in this test");
				}
				if (atributos.substring(7, 8).equals("1")) {
					qtdattributesSent++;
					if (!nomepaiQtd.getText().equals("N.D.")) {
						waitToElementAndClick(nomepai);
						if (!inputNomePai.isSelected()) {
							waitToElementAndClick(nomepai);
							log.info("Nome do pai was not checked");
						}
						if (inputNomePai.isSelected()) {
							log.info("Nome do pai was checked");
							qtdAttributesChecked++;
							String qtd = nomepaiQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[7] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Nome do Pai is 0 in this filter");
					}
				}
				if (atributos.substring(7, 8).equals("0")) {
					log.info("Nome do pai was not chosen in this test");
				}
				if (atributos.substring(8, 9).equals("1")) {
					qtdattributesSent++;
					if (!nomemaeQtd.getText().equals("N.D.")) {
						waitToElementAndClick(nomemae);
						if (!inputNomeMae.isSelected()) {
							waitToElementAndClick(nomemae);
							log.info("Nome da mãe was not checked");
						}
						if (inputNomeMae.isSelected()) {
							log.info("Nome da mãe was checked");
							qtdAttributesChecked++;
							String qtd = nomemaeQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[8] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Nome da Mãe is 0 in this filter");
					}
				}
				if (atributos.substring(8, 9).equals("0")) {
					log.info("Nome da mãe was not chosen in this test");
				}
				if (atributos.substring(9, 10).equals("1")) {
					qtdattributesSent++;
					if (!profissaoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(profissao);
						if (!inputProfissao.isSelected()) {
							waitToElementAndClick(profissao);
							log.info("Profissão was not checked");
						}
						if (inputProfissao.isSelected()) {
							log.info("Profissão was checked");
							qtdAttributesChecked++;
							String qtd = profissaoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[9] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Profissão is 0 in this filter");
					}
				}
				if (atributos.substring(9, 10).equals("0")) {
					log.info("Profissão was not chosen in this test");
				}
				if (atributos.substring(10, 11).equals("1")) {
					qtdattributesSent++;
					if (!mailQtd.getText().equals("N.D.")) {
						waitToElementAndClick(mail);
						if (!inputMail.isSelected()) {
							log.info("Mail was not checked");
							waitToElementAndClick(mail);
						}
						if (inputMail.isSelected()) {
							log.info("Mail was checked");
							qtdAttributesChecked++;
							String qtd = mailQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[10] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Email is 0 in this filter");
					}
				}
				if (atributos.substring(10, 11).equals("0")) {
					log.info("Mail was not chosen in this test");
				}
				if (atributos.substring(11, 12).equals("1")) {
					qtdattributesSent++;
					if (!telefone1Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone1);
						if (!inputTelefone1.isSelected()) {
							log.info("Telefone1 was not checked");
							waitToElementAndClick(telefone1);
						}
						if (inputTelefone1.isSelected()) {
							log.info("Telefone1 was checked");
							qtdAttributesChecked++;
							String qtd = telefone1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[11] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 1 is 0 in this filter");
					}
				}
				if (atributos.substring(11, 12).equals("0")) {
					log.info("Telefone 1 was not chosen in this test");
				}
				if (atributos.substring(12, 13).equals("1")) {
					qtdattributesSent++;
					if (!telefone2Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone2);
						if (!inputTelefone2.isSelected()) {
							waitToElementAndClick(telefone2);
							log.info("Telefone2 was not checked");
						}
						if (inputTelefone2.isSelected()) {
							log.info("Telefone2 was checked");
							qtdAttributesChecked++;
							String qtd = telefone2Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[12] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 2 is 0 in this filter");
					}
				}
				if (atributos.substring(12, 13).equals("0")) {
					log.info("Telefone 2 was not chosen in this test");
				}
				if (atributos.substring(13, 14).equals("1")) {
					qtdattributesSent++;
					if (!telefone3Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone3);
						if (!inputTelefone3.isSelected()) {
							waitToElementAndClick(telefone3);
							log.info("Telefone3 was not checked");
						}
						if (inputTelefone3.isSelected()) {
							log.info("Telefone3 was checked");
							qtdAttributesChecked++;
							String qtd = telefone3Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[13] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 3 is 0 in this filter");
					}
				}
				if (atributos.substring(13, 14).equals("0")) {
					log.info("Telefone 3 was not chosen in this test");
				}
				if (atributos.substring(14, 15).equals("1")) {
					qtdattributesSent++;
					if (!telefone4Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone4);
						if (!inputTelefone4.isSelected()) {
							waitToElementAndClick(telefone4);
							log.info("Telefone4 was not checked");
						}
						if (inputTelefone4.isSelected()) {
							log.info("Telefone4 was checked");
							qtdAttributesChecked++;
							String qtd = telefone4Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[14] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 4 is 0 in this filter");
					}
				}
				if (atributos.substring(14, 15).equals("0")) {
					log.info("Telefone 4 was not chosen in this test");
				}
				if (atributos.substring(15, 16).equals("1")) {
					qtdattributesSent++;
					if (!telefone5Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone5);
						if (!inputTelefone5.isSelected()) {
							waitToElementAndClick(telefone5);
							log.info("Telefone5 was not checked");
						}
						if (inputTelefone5.isSelected()) {
							log.info("Telefone5 was checked");
							qtdAttributesChecked++;
							String qtd = telefone5Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[15] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 5 is 0 in this filter");
					}
				}
				if (atributos.substring(15, 16).equals("0")) {
					log.info("Telefone 5 was not chosen in this test");
				}
				if (atributos.substring(16, 17).equals("1")) {
					qtdattributesSent++;
					if (!celular1Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular1);
						if (!inputCelular1.isSelected()) {
							waitToElementAndClick(celular1);
							log.info("Celular1 was not checked");
						}
						if (inputCelular1.isSelected()) {
							log.info("Celular1 was checked");
							qtdAttributesChecked++;
							String qtd = celular1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[16] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 1 is 0 in this filter");
					}
				}
				if (atributos.substring(16, 17).equals("0")) {
					log.info("Celular 1 was not chosen in this test");
				}
				if (atributos.substring(17, 18).equals("1")) {
					qtdattributesSent++;
					if (!celular2Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular2);
						if (!inputCelular2.isSelected()) {
							waitToElementAndClick(celular2);
							log.info("Celular2 was not checked");
						}
						if (inputCelular2.isSelected()) {
							log.info("Celular2 was checked");
							qtdAttributesChecked++;
							String qtd = celular2Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[17] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 2 is 0 in this filter");
					}
				}
				if (atributos.substring(17, 18).equals("0")) {
					log.info("Celular 2 was not chosen in this test");
				}
				if (atributos.substring(18, 19).equals("1")) {
					qtdattributesSent++;
					if (!celular3Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular3);
						if (!inputCelular3.isSelected()) {
							waitToElementAndClick(celular3);
							log.info("Celular3 was not checked");
						}
						if (inputCelular3.isSelected()) {
							log.info("Celular3 was checked");
							qtdAttributesChecked++;
							String qtd = celular3Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[18] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 3 is 0 in this filter");
					}
				}
				if (atributos.substring(18, 19).equals("0")) {
					log.info("Celular 3 was not chosen in this test");
				}
				if (atributos.substring(19, 20).equals("1")) {
					qtdattributesSent++;
					if (!celular4Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular4);
						if (!inputCelular4.isSelected()) {
							waitToElementAndClick(celular4);
							log.info("Celular4 was not checked");
						}
						if (inputCelular4.isSelected()) {
							log.info("Celular4 was checked");
							qtdAttributesChecked++;
							String qtd = celular4Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[19] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 4 is 0 in this filter");
					}
				}
				if (atributos.substring(19, 20).equals("0")) {
					log.info("Celular 4 was not chosen in this test");
				}
				if (atributos.substring(20, 21).equals("1")) {
					qtdattributesSent++;
					if (!celular5Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular5);
						if (!inputCelular5.isSelected()) {
							waitToElementAndClick(celular5);
							log.info("Celular5 was not checked");
						}
						if (inputCelular5.isSelected()) {
							log.info("Celular5 was checked");
							qtdAttributesChecked++;
							String qtd = celular5Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[20] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 5 is 0 in this filter");
					}
				}
				if (atributos.substring(20, 21).equals("0")) {
					log.info("Celular 5 was not chosen in this test");
				}
				if (atributos.substring(21, 22).equals("1")) {
					qtdattributesSent++;
					if (!whatsAppcelular1Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular1);
						if (!inputWhatsAppcelular1.isSelected()) {
							waitToElementAndClick(whatsAppcelular1);
							log.info("whatsAppcelular1 was not checked");
						}
						if (inputWhatsAppcelular1.isSelected()) {
							log.info("whatsAppcelular1 was checked");
							qtdAttributesChecked++;
							String qtd = whatsAppcelular1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[21] = Integer.parseInt(qtd);
						}

					} else {
						log.info("The quantity of the attribute WhatsAppcelular 1 is 0 in this filter");
					}
				}
				if (atributos.substring(21, 22).equals("0")) {
					log.info("whatsAppcelular1 was not chosen in this test");
				}
				if (atributos.substring(22, 23).equals("1")) {
					qtdattributesSent++;
					if (!whatsAppcelular2Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular2);
						if (!inputWhatsAppcelular2.isSelected()) {
							waitToElementAndClick(whatsAppcelular2);
							log.info("whatsAppcelular2 was not checked");
						}
						if (inputWhatsAppcelular2.isSelected()) {
							log.info("whatsAppcelular2 was checked");
							qtdAttributesChecked++;
							String qtd = whatsAppcelular2Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[22] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular 2 is 0 in this filter");
					}
				}
				if (atributos.substring(22, 23).equals("0")) {
					log.info("whatsAppcelular2 was not chosen in this test");
				}
				if (atributos.substring(23, 24).equals("1")) {
					qtdattributesSent++;
					if (!whatsAppcelular3Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular3);
						if (!inputWhatsAppcelular3.isSelected()) {
							waitToElementAndClick(whatsAppcelular3);
							log.info("whatsAppcelular3 was not checked");
						}
						if (inputWhatsAppcelular3.isSelected()) {
							log.info("whatsAppcelular3 was checked");
							qtdAttributesChecked++;
							String qtd = whatsAppcelular3Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[23] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular 3 is 0 in this filter");
					}
				}
				if (atributos.substring(23, 24).equals("0")) {
					log.info("whatsAppcelular3 was not chosen in this test");
				}
				if (atributos.substring(24, 25).equals("1")) {
					qtdattributesSent++;
					if (!whatsAppcelular4Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular4);
						if (!inputWhatsAppcelular4.isSelected()) {
							waitToElementAndClick(whatsAppcelular4);
							log.info("whatsAppcelular4 was not checked");
						}
						if (inputWhatsAppcelular4.isSelected()) {
							log.info("whatsAppcelular4 was checked");
							qtdAttributesChecked++;
							String qtd = whatsAppcelular4Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[24] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular 4 is 0 in this filter");
					}
				}
				if (atributos.substring(24, 25).equals("0")) {
					log.info("whatsAppcelular4 was not chosen in this test");
				}
				if (atributos.substring(25, 26).equals("1")) {
					qtdattributesSent++;
					if (!whatsAppcelular5Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular5);
						if (!inputWhatsAppcelular5.isSelected()) {
							waitToElementAndClick(whatsAppcelular5);
							log.info("whatsAppcelular5 was not checked");
						}
						if (inputWhatsAppcelular5.isSelected()) {
							log.info("whatsAppcelular5 was checked");
							qtdAttributesChecked++;
							String qtd = whatsAppcelular5Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[25] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular 5 is 0 in this filter");
					}
				}
				if (atributos.substring(25, 26).equals("0")) {
					log.info("whatsAppcelular5 was not chosen in this test");
				}
				if (atributos.substring(26, 27).equals("1")) {
					qtdattributesSent++;
					if (!veiculoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(veiculo);
						if (!inputVeiculo.isSelected()) {
							waitToElementAndClick(veiculo);
							log.info("Veículo was not checked");
						}
						if (inputVeiculo.isSelected()) {
							log.info("Veículo was checked");
							qtdAttributesChecked++;
							String qtd = veiculoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[26] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Veículo is 0 in this filter");
					}
				}
				if (atributos.substring(26, 27).equals("0")) {
					log.info("Veículo was not chosen in this test");
				}
				if (atributos.substring(27, 28).equals("1")) {
					qtdattributesSent++;
					if (!rendaPresumidaQtd.getText().equals("N.D.")) {
						waitToElementAndClick(rendaPresumida);
						if (!inputRendaPresumida.isSelected()) {
							waitToElementAndClick(rendaPresumida);
							log.info("Renda Presumida was not checked");
						}
						if (inputRendaPresumida.isSelected()) {
							log.info("Renda Presumida was checked");
							qtdAttributesChecked++;
							String qtd = rendaPresumidaQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[27] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Renda Presumida is 0 in this filter");
					}
				}
				if (atributos.substring(27, 28).equals("0")) {
					log.info("Renda Presumida was not chosen in this test");
				}
				if (atributos.substring(28, 29).equals("1")) {
					qtdattributesSent++;
					if (!obitoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(obito);
						if (!inputObito.isSelected()) {
							waitToElementAndClick(obito);
							log.info("Óbito was not checked");
						}
						if (inputObito.isSelected()) {
							log.info("Óbito was checked");
							qtdAttributesChecked++;
							String qtd = obitoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[28] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Óbito is 0 in this filter");
					}
				}
				if (atributos.substring(28, 29).equals("0")) {
					log.info("Óbito was not chosen in this test");
				}
				if (atributos.substring(29, 30).equals("1")) {
					qtdattributesSent++;
					if (!bolsaFamiliaQtd.getText().equals("N.D.")) {
						waitToElementAndClick(bolsaFamilia);
						if (!inputBolsaFamilia.isSelected()) {
							waitToElementAndClick(bolsaFamilia);
							log.info("Bolsa Familia was not checked");
						}
						if (inputBolsaFamilia.isSelected()) {
							log.info("Bolsa Familia was checked");
							qtdAttributesChecked++;
							String qtd = bolsaFamiliaQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[29] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Bolsa Familia is 0 in this filter");
					}
				}
				if (atributos.substring(29, 30).equals("0")) {
					log.info("Bolsa Familia was not chosen in this test");
				}
				if (atributos.substring(30, 31).equals("1")) {
					qtdattributesSent++;
					if (!estadoCivilQtd.getText().equals("N.D.")) {
						waitToElementAndClick(estadoCivil);
						if (!inputEstadoCivil.isSelected()) {
							waitToElementAndClick(estadoCivil);
							log.info("Estado Civil was not checked");
						}
						if (inputEstadoCivil.isSelected()) {
							log.info("Estado Civil was checked");
							qtdAttributesChecked++;
							String qtd = estadoCivilQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[30] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Estado Civil is 0 in this filter");
					}
				}
				if (atributos.substring(30, 31).equals("0")) {
					log.info("Estado Civil was not chosen in this test");
				}
				if (atributos.substring(31, 32).equals("1")) {
					qtdattributesSent++;
					if (!funcionarioCltQtd.getText().equals("N.D.")) {
						waitToElementAndClick(funcionarioClt);
						if (!inputFuncionarioClt.isSelected()) {
							waitToElementAndClick(funcionarioClt);
							log.info("Funcionário Clt was not checked");
						}
						if (inputFuncionarioClt.isSelected()) {
							log.info("Funcionário Clt was checked");
							qtdAttributesChecked++;
							String qtd = funcionarioCltQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[31] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Funcionário Clt is 0 in this filter");
					}
				}
				if (atributos.substring(31, 32).equals("0")) {
					log.info("Funcionário Clt was not chosen in this test");
				}
				if (atributos.substring(32, 33).equals("1")) {
					qtdattributesSent++;
					if (!classeSocialQtd.getText().equals("N.D.")) {
						waitToElementAndClick(classeSocial);
						if (!inputClasseSocial.isSelected()) {
							waitToElementAndClick(classeSocial);
							log.info("Classe Social was not checked");
						}
						if (inputClasseSocial.isSelected()) {
							log.info("Classe Social was checked");
							qtdAttributesChecked++;
							String qtd = classeSocialQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[32] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Classe Social is 0 in this filter");
					}
				}
				if (atributos.substring(32, 33).equals("0")) {
					log.info("Classe Social was not chosen in this test");
				}
				if (atributos.substring(33, 34).equals("1")) {
					qtdattributesSent++;
					if (!restricaoFinanceiraQtd.getText().equals("N.D.")) {
						waitToElementAndClick(restricaoFinanceira);
						if (!inputRestricaoFinanceira.isSelected()) {
							waitToElementAndClick(restricaoFinanceira);
							log.info("Restrição Financeira was not checked");
						}
						if (inputRestricaoFinanceira.isSelected()) {
							log.info("Restrição Financeira was checked");
							qtdAttributesChecked++;
							String qtd = restricaoFinanceiraQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[33] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Restrição Financeira is 0 in this filter");
					}
				}
				if (atributos.substring(33, 34).equals("0")) {
					log.info("Restrição Financeira was not chosen in this test");
				}
				if (atributos.substring(34, 35).equals("1")) {
					qtdattributesSent++;
					if (!consignadoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(consignado);
						if (!inputConsignado.isSelected()) {
							waitToElementAndClick(consignado);
							log.info("Consignado was not checked");
						}
						if (inputConsignado.isSelected()) {
							log.info("Consignado was checked");
							qtdAttributesChecked++;
							String qtd = consignadoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[34] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Consignado is 0 in this filter");
					}
				}
				if (atributos.substring(34, 35).equals("0")) {
					log.info("Consignado was not chosen in this test");
				}
				if (atributos.substring(35, 36).equals("1")) {
					qtdattributesSent++;
					if (!tituloEleitorQtd.getText().equals("N.D.")) {
						waitToElementAndClick(tituloEleitor);
						if (!inputTituloEleitor.isSelected()) {
							waitToElementAndClick(tituloEleitor);
							log.info("Titulor de Eleitor was not checked");
						}
						if (inputTituloEleitor.isSelected()) {
							log.info("Titulor de Eleitor was checked");
							qtdAttributesChecked++;
							String qtd = tituloEleitorQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[35] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Título de eleitor is 0 in this filter");
					}
				}
				if (atributos.substring(35, 36).equals("0")) {
					log.info("Titulor de Eleitor was not chosen in this test");
				}
				if (atributos.substring(36, 37).equals("1")) {
					qtdattributesSent++;
					if (!rgQtd.getText().equals("N.D.")) {
						waitToElementAndClick(rg);
						if (!inputRg.isSelected()) {
							waitToElementAndClick(rg);
							log.info("Rg was not checked");
						}
						if (inputRg.isSelected()) {
							qtdAttributesChecked++;
							log.info("Rg was checked");
							String qtd = rgQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[36] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Rg is 0 in this filter");
					}
				}
				if (atributos.substring(36, 37).equals("0")) {
					log.info("Rg was not chosen in this test");
				}
				if (atributos.substring(37, 38).equals("1")) {
					qtdattributesSent++;
					if (!pisQtd.getText().equals("N.D.")) {
						waitToElementAndClick(pis);
						if (!inputPis.isSelected()) {
							waitToElementAndClick(pis);
							log.info("Pis was not checked");
						}
						if (inputPis.isSelected()) {
							qtdAttributesChecked++;
							log.info("Pis was checked");
							String qtd = pisQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[37] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Pis is 0 in this filter");
					}
				}
				if (atributos.substring(37, 38).equals("0")) {
					log.info("Titulor de Eleitor was not chosen in this test");
				}
				if (atributos.substring(38, 39).equals("1")) {
					qtdattributesSent++;
					if (!carteiraQtd.getText().equals("N.D.")) {
						waitToElementAndClick(carteira);
						if (!inputCarteira.isSelected()) {
							waitToElementAndClick(carteira);
							log.info("Carteira was not checked");
						}
						if (inputCarteira.isSelected()) {
							qtdAttributesChecked++;
							log.info("Carteira Profissional was checked");
							String qtd = carteiraQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[38] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Carteira Profissional is 0 in this filter");
					}
				}
				if (atributos.substring(38, 39).equals("0")) {
					log.info("Carteira Profissional was not chosen in this test");
				}
				if (atributos.substring(39, 40).equals("1")) {
					qtdattributesSent++;
					if (!conselhoProfissionalQtd.getText().equals("N.D.")) {
						waitToElementAndClick(conselhoProfissional);
						if (!inputConselhoProfissional.isSelected()) {
							waitToElementAndClick(conselhoProfissional);
							log.info("Conselho Profissional was not checked");
						}
						if (inputConselhoProfissional.isSelected()) {
							qtdAttributesChecked++;
							log.info("Conselho Profissional was checked");
							String qtd = conselhoProfissionalQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[39] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Conselhor Profissional is 0 in this filter");
					}
				}
				if (atributos.substring(39, 40).equals("0")) {
					log.info("Conselho Profissional was not chosen in this test");
				}
				log.info("" + qtdAttributesChecked + " attributes were checked");
				log.info("" + qtdattributesSent + " attributes sent");

				if (qtdAttributesChecked == 0) { // quantidade de cnpj outros atributos devem ser iguais
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
	}

	public int[] chooseAttributesChangingQuantity(String atributos) throws Exception {
		// Enviamos um array de temanho 40 ( 40 atributos na pessoa física) - Se enviar
		// 1 , ele deve ser selecionado. Se enviar 0 , não deve ser selecionado.

		// Escolhendo os atributos
		int qtdAttributesChecked = 0;
		int qtdattributesSent = 0;
		SegmentationInteraction segInt = new SegmentationInteraction(driver);
		driver.switchTo().activeElement();
		if (atributos.length() == 40) {// verifica se a string tem tamanho 40

			try {
				Thread.sleep(7000);
				if (atributos.substring(0, 1).equals("1")) {// verifica se o atributo 1 foi selecionado - 1 para
															// selecionado / 0 - para não selecionado
					qtdattributesSent++;
					if (!cpfQtd.getText().equals("N.D.")) {// verifica se a quantidade é maior que zero
						if (!inputCpf.isSelected()) {// verifica se o atributo foi selecionado
							log.info("Cpf was not checked");
						}
						if (inputCpf.isSelected()) { // atributo selecionado
							log.info("Cpf was checked");
							String qtd = cpfQtd.getText().replace(".", "");
							int quantidade = Integer.parseInt(qtd);
							// waitToElementAndClick(cpfQtd);
							arrayQuantidade[0] = Integer.parseInt(qtd);
							qtdAttributesChecked++;
						}
					} else {
						log.info("The quantity of the attribute Cpf is 0 in this filter");
					}
				}
				if (atributos.substring(0, 1).equals("0")) {
					log.info("CPF was was not chosen in this test");
				}
				if (atributos.substring(1, 2).equals("1")) {
					qtdattributesSent++;
					if (!nomeQtd.getText().equals("N.D.")) {
						waitToElementAndClick(nome);
						if (!inputNome.isSelected()) {
							log.info("Nome was not checked");
							waitToElementAndClick(nome);
						}
						if (inputNome.isSelected()) {
							log.info("Nome was checked");
							String qtd = nomeQtd.getText().replace(".", "");
							int quantidade = Integer.parseInt(qtd);
							System.out.println("q " + quantidade);
							waitToElementAndClick(nomeQtd);
							arrayQuantidade[1] = segInt.changeQuantity(quantidade);
							qtdAttributesChecked++;
						}
					} else {
						log.info("The quantity of the attribute Nome is 0 in this filter");
					}
				}
				if (atributos.substring(1, 2).equals("0")) {
					log.info("Nome was was not chosen in this test");
				}
				if (atributos.substring(2, 3).equals("1")) {
					qtdattributesSent++;
					if (!situacaoRFQtd.getText().equals("N.D.")) {
						waitToElementAndClick(situacaoRF);
						if (!inputSituacaoRF.isSelected()) {
							waitToElementAndClick(situacaoRF);
							log.info("Situação RF was not checked");
						}
						if (inputSituacaoRF.isSelected()) {
							log.info("Situação RF was checked");
							String qtd = situacaoRFQtd.getText().replace(".", "");
							int quantidade = Integer.parseInt(qtd);
							waitToElementAndClick(situacaoRFQtd);
							arrayQuantidade[2] = segInt.changeQuantity(quantidade);
							qtdAttributesChecked++;
						}
					} else {
						log.info("The quantity of the attribute Situação RF is 0 in this filter");
					}
				}
				if (atributos.substring(2, 3).equals("0")) {
					log.info("Situação RF was was not chosen in this test");
				}
				if (atributos.substring(3, 4).equals("1")) {
					qtdattributesSent++;
					if (!enderecoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(endereco);
						if (!inputEndereco.isSelected()) {
							log.info("Endereço was not checked");
							waitToElementAndClick(endereco);
						}
						if (inputEndereco.isSelected()) {
							log.info("Endereço was checked");
							String qtd = enderecoQtd.getText().replace(".", "");
							int quantidade = Integer.parseInt(qtd);
							waitToElementAndClick(enderecoQtd);
							arrayQuantidade[3] = segInt.changeQuantity(quantidade);
							qtdAttributesChecked++;
						}
					} else {
						log.info("The quantity of the attribute Endereço is 0 in this filter");
					}
				}
				if (atributos.substring(3, 4).equals("0")) {
					log.info("Endereço was was not chosen in this test");
				}
				if (atributos.substring(4, 5).equals("1")) {
					qtdattributesSent++;
					if (!dataNascimentoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(dataNascimento);
						if (!inputDataNascimento.isSelected()) {
							log.info("Data de Nascimento was not checked");
							waitToElementAndClick(dataNascimento);
						}
						if (inputDataNascimento.isSelected()) {
							log.info("Data de Nascimento was checked");
							String qtd = dataNascimentoQtd.getText().replace(".", "");
							int quantidade = Integer.parseInt(qtd);
							waitToElementAndClick(dataNascimentoQtd);
							arrayQuantidade[4] = segInt.changeQuantity(quantidade);
							qtdAttributesChecked++;
						}
					} else {
						log.info("The quantity of the attribute Data de Nascimento is 0 in this filter");
					}
				}
				if (atributos.substring(4, 5).equals("0")) {
					log.info("Data de Nascimento was not chosen in this test");
				}
				if (atributos.substring(5, 6).equals("1")) {
					qtdattributesSent++;
					if (!generoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(genero);
						if (!inputGenero.isSelected()) {
							log.info("Gênero was not checked");
							waitToElementAndClick(genero);
						}
						if (inputGenero.isSelected()) {
							log.info("Gênero was checked");
							qtdAttributesChecked++;
							String qtd = generoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[5] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Gênero is 0 in this filter");
					}
				}
				if (atributos.substring(5, 6).equals("0")) {
					log.info("Gênero was not chosen in this test");
				}
				if (atributos.substring(6, 7).equals("1")) {
					qtdattributesSent++;
					if (!escolaridadeQtd.getText().equals("N.D.")) {
						waitToElementAndClick(escolaridade);
						if (!inputEscolaridade.isSelected()) {
							waitToElementAndClick(escolaridade);
							log.info("Escolaridade was not checked");
						}
						if (inputEscolaridade.isSelected()) {
							log.info("Escolaridade was checked");
							qtdAttributesChecked++;
							String qtd = escolaridadeQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[6] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Escolaridade is 0 in this filter");
					}
				}
				if (atributos.substring(6, 7).equals("0")) {
					log.info("Escolaridade was not chosen in this test");
				}
				if (atributos.substring(7, 8).equals("1")) {
					qtdattributesSent++;
					if (!nomepaiQtd.getText().equals("N.D.")) {
						waitToElementAndClick(nomepai);
						if (!inputNomePai.isSelected()) {
							waitToElementAndClick(nomepai);
							log.info("Nome do pai was not checked");
						}
						if (inputNomePai.isSelected()) {
							log.info("Nome do pai was checked");
							qtdAttributesChecked++;
							String qtd = nomepaiQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[7] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Nome do Pai is 0 in this filter");
					}
				}
				if (atributos.substring(7, 8).equals("0")) {
					log.info("Nome do pai was not chosen in this test");
				}
				if (atributos.substring(8, 9).equals("1")) {
					qtdattributesSent++;
					if (!nomemaeQtd.getText().equals("N.D.")) {
						waitToElementAndClick(nomemae);
						if (!inputNomeMae.isSelected()) {
							waitToElementAndClick(nomemae);
							log.info("Nome da mãe was not checked");
						}
						if (inputNomeMae.isSelected()) {
							log.info("Nome da mãe was checked");
							qtdAttributesChecked++;
							String qtd = nomemaeQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[8] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Nome da Mãe is 0 in this filter");
					}
				}
				if (atributos.substring(8, 9).equals("0")) {
					log.info("Nome da mãe was not chosen in this test");
				}
				if (atributos.substring(9, 10).equals("1")) {
					qtdattributesSent++;
					if (!profissaoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(profissao);
						if (!inputProfissao.isSelected()) {
							waitToElementAndClick(profissao);
							log.info("Profissão was not checked");
						}
						if (inputProfissao.isSelected()) {
							log.info("Profissão was checked");
							qtdAttributesChecked++;
							String qtd = profissaoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[9] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Profissão is 0 in this filter");
					}
				}
				if (atributos.substring(9, 10).equals("0")) {
					log.info("Profissão was not chosen in this test");
				}
				if (atributos.substring(10, 11).equals("1")) {
					qtdattributesSent++;
					if (!mailQtd.getText().equals("N.D.")) {
						waitToElementAndClick(mail);
						if (!inputMail.isSelected()) {
							log.info("Mail was not checked");
							waitToElementAndClick(mail);
						}
						if (inputMail.isSelected()) {
							log.info("Mail was checked");
							qtdAttributesChecked++;
							String qtd = mailQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[10] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Email is 0 in this filter");
					}
				}
				if (atributos.substring(10, 11).equals("0")) {
					log.info("Mail was not chosen in this test");
				}
				if (atributos.substring(11, 12).equals("1")) {
					qtdattributesSent++;
					if (!telefone1Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone1);
						if (!inputTelefone1.isSelected()) {
							log.info("Telefone1 was not checked");
							waitToElementAndClick(telefone1);
						}
						if (inputTelefone1.isSelected()) {
							log.info("Telefone1 was checked");
							qtdAttributesChecked++;
							String qtd = telefone1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[11] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 1 is 0 in this filter");
					}
				}
				if (atributos.substring(11, 12).equals("0")) {
					log.info("Telefone 1 was not chosen in this test");
				}
				if (atributos.substring(12, 13).equals("1")) {
					qtdattributesSent++;
					if (!telefone2Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone2);
						if (!inputTelefone2.isSelected()) {
							waitToElementAndClick(telefone2);
							log.info("Telefone2 was not checked");
						}
						if (inputTelefone2.isSelected()) {
							log.info("Telefone2 was checked");
							qtdAttributesChecked++;
							String qtd = telefone2Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[12] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 2 is 0 in this filter");
					}
				}
				if (atributos.substring(12, 13).equals("0")) {
					log.info("Telefone 2 was not chosen in this test");
				}
				if (atributos.substring(13, 14).equals("1")) {
					qtdattributesSent++;
					if (!telefone3Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone3);
						if (!inputTelefone3.isSelected()) {
							waitToElementAndClick(telefone3);
							log.info("Telefone3 was not checked");
						}
						if (inputTelefone3.isSelected()) {
							log.info("Telefone3 was checked");
							qtdAttributesChecked++;
							String qtd = telefone3Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[13] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 3 is 0 in this filter");
					}
				}
				if (atributos.substring(13, 14).equals("0")) {
					log.info("Telefone 3 was not chosen in this test");
				}
				if (atributos.substring(14, 15).equals("1")) {
					qtdattributesSent++;
					if (!telefone4Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone4);
						if (!inputTelefone4.isSelected()) {
							waitToElementAndClick(telefone4);
							log.info("Telefone4 was not checked");
						}
						if (inputTelefone4.isSelected()) {
							log.info("Telefone4 was checked");
							qtdAttributesChecked++;
							String qtd = telefone4Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[14] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 4 is 0 in this filter");
					}
				}
				if (atributos.substring(14, 15).equals("0")) {
					log.info("Telefone 4 was not chosen in this test");
				}
				if (atributos.substring(15, 16).equals("1")) {
					qtdattributesSent++;
					if (!telefone5Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(telefone5);
						if (!inputTelefone5.isSelected()) {
							waitToElementAndClick(telefone5);
							log.info("Telefone5 was not checked");
						}
						if (inputTelefone5.isSelected()) {
							log.info("Telefone5 was checked");
							qtdAttributesChecked++;
							String qtd = telefone5Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[15] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Telefone 5 is 0 in this filter");
					}
				}
				if (atributos.substring(15, 16).equals("0")) {
					log.info("Telefone 5 was not chosen in this test");
				}
				if (atributos.substring(16, 17).equals("1")) {
					qtdattributesSent++;
					if (!celular1Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular1);
						if (!inputCelular1.isSelected()) {
							waitToElementAndClick(celular1);
							log.info("Celular1 was not checked");
						}
						if (inputCelular1.isSelected()) {
							log.info("Celular1 was checked");
							qtdAttributesChecked++;
							String qtd = celular1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[16] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 1 is 0 in this filter");
					}
				}
				if (atributos.substring(16, 17).equals("0")) {
					log.info("Celular 1 was not chosen in this test");
				}
				if (atributos.substring(17, 18).equals("1")) {
					qtdattributesSent++;
					if (!celular2Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular2);
						if (!inputCelular2.isSelected()) {
							waitToElementAndClick(celular2);
							log.info("Celular2 was not checked");
						}
						if (inputCelular2.isSelected()) {
							log.info("Celular2 was checked");
							qtdAttributesChecked++;
							String qtd = celular2Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[17] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 2 is 0 in this filter");
					}
				}
				if (atributos.substring(17, 18).equals("0")) {
					log.info("Celular 2 was not chosen in this test");
				}
				if (atributos.substring(18, 19).equals("1")) {
					qtdattributesSent++;
					if (!celular3Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular3);
						if (!inputCelular3.isSelected()) {
							waitToElementAndClick(celular3);
							log.info("Celular3 was not checked");
						}
						if (inputCelular3.isSelected()) {
							log.info("Celular3 was checked");
							qtdAttributesChecked++;
							String qtd = celular3Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[18] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 3 is 0 in this filter");
					}
				}
				if (atributos.substring(18, 19).equals("0")) {
					log.info("Celular 3 was not chosen in this test");
				}
				if (atributos.substring(19, 20).equals("1")) {
					qtdattributesSent++;
					if (!celular4Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular4);
						if (!inputCelular4.isSelected()) {
							waitToElementAndClick(celular4);
							log.info("Celular4 was not checked");
						}
						if (inputCelular4.isSelected()) {
							log.info("Celular4 was checked");
							qtdAttributesChecked++;
							String qtd = celular4Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[19] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 4 is 0 in this filter");
					}
				}
				if (atributos.substring(19, 20).equals("0")) {
					log.info("Celular 4 was not chosen in this test");
				}
				if (atributos.substring(20, 21).equals("1")) {
					qtdattributesSent++;
					if (!celular5Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(celular5);
						if (!inputCelular5.isSelected()) {
							waitToElementAndClick(celular5);
							log.info("Celular5 was not checked");
						}
						if (inputCelular5.isSelected()) {
							log.info("Celular5 was checked");
							qtdAttributesChecked++;
							String qtd = celular5Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[20] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Celular 5 is 0 in this filter");
					}
				}
				if (atributos.substring(20, 21).equals("0")) {
					log.info("Celular 5 was not chosen in this test");
				}
				if (atributos.substring(21, 22).equals("1")) {
					qtdattributesSent++;
					if (!whatsAppcelular1Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular1);
						if (!inputWhatsAppcelular1.isSelected()) {
							waitToElementAndClick(whatsAppcelular1);
							log.info("whatsAppcelular1 was not checked");
						}
						if (inputWhatsAppcelular1.isSelected()) {
							log.info("whatsAppcelular1 was checked");
							qtdAttributesChecked++;
							String qtd = whatsAppcelular1Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[21] = Integer.parseInt(qtd);
						}

					} else {
						log.info("The quantity of the attribute WhatsAppcelular 1 is 0 in this filter");
					}
				}
				if (atributos.substring(21, 22).equals("0")) {
					log.info("whatsAppcelular1 was not chosen in this test");
				}
				if (atributos.substring(22, 23).equals("1")) {
					qtdattributesSent++;
					if (!whatsAppcelular2Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular2);
						if (!inputWhatsAppcelular2.isSelected()) {
							waitToElementAndClick(whatsAppcelular2);
							log.info("whatsAppcelular2 was not checked");
						}
						if (inputWhatsAppcelular2.isSelected()) {
							log.info("whatsAppcelular2 was checked");
							qtdAttributesChecked++;
							String qtd = whatsAppcelular2Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[22] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular 2 is 0 in this filter");
					}
				}
				if (atributos.substring(22, 23).equals("0")) {
					log.info("whatsAppcelular2 was not chosen in this test");
				}
				if (atributos.substring(23, 24).equals("1")) {
					qtdattributesSent++;
					if (!whatsAppcelular3Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular3);
						if (!inputWhatsAppcelular3.isSelected()) {
							waitToElementAndClick(whatsAppcelular3);
							log.info("whatsAppcelular3 was not checked");
						}
						if (inputWhatsAppcelular3.isSelected()) {
							log.info("whatsAppcelular3 was checked");
							qtdAttributesChecked++;
							String qtd = whatsAppcelular3Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[23] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular 3 is 0 in this filter");
					}
				}
				if (atributos.substring(23, 24).equals("0")) {
					log.info("whatsAppcelular3 was not chosen in this test");
				}
				if (atributos.substring(24, 25).equals("1")) {
					qtdattributesSent++;
					if (!whatsAppcelular4Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular4);
						if (!inputWhatsAppcelular4.isSelected()) {
							waitToElementAndClick(whatsAppcelular4);
							log.info("whatsAppcelular4 was not checked");
						}
						if (inputWhatsAppcelular4.isSelected()) {
							log.info("whatsAppcelular4 was checked");
							qtdAttributesChecked++;
							String qtd = whatsAppcelular4Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[24] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular 4 is 0 in this filter");
					}
				}
				if (atributos.substring(24, 25).equals("0")) {
					log.info("whatsAppcelular4 was not chosen in this test");
				}
				if (atributos.substring(25, 26).equals("1")) {
					qtdattributesSent++;
					if (!whatsAppcelular5Qtd.getText().equals("N.D.")) {
						waitToElementAndClick(whatsAppcelular5);
						if (!inputWhatsAppcelular5.isSelected()) {
							waitToElementAndClick(whatsAppcelular5);
							log.info("whatsAppcelular5 was not checked");
						}
						if (inputWhatsAppcelular5.isSelected()) {
							log.info("whatsAppcelular5 was checked");
							qtdAttributesChecked++;
							String qtd = whatsAppcelular5Qtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[25] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute WhatsAppcelular 5 is 0 in this filter");
					}
				}
				if (atributos.substring(25, 26).equals("0")) {
					log.info("whatsAppcelular5 was not chosen in this test");
				}
				if (atributos.substring(26, 27).equals("1")) {
					qtdattributesSent++;
					if (!veiculoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(veiculo);
						if (!inputVeiculo.isSelected()) {
							waitToElementAndClick(veiculo);
							log.info("Veículo was not checked");
						}
						if (inputVeiculo.isSelected()) {
							log.info("Veículo was checked");
							qtdAttributesChecked++;
							String qtd = veiculoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[26] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Veículo is 0 in this filter");
					}
				}
				if (atributos.substring(26, 27).equals("0")) {
					log.info("Veículo was not chosen in this test");
				}
				if (atributos.substring(27, 28).equals("1")) {
					qtdattributesSent++;
					if (!rendaPresumidaQtd.getText().equals("N.D.")) {
						waitToElementAndClick(rendaPresumida);
						if (!inputRendaPresumida.isSelected()) {
							waitToElementAndClick(rendaPresumida);
							log.info("Renda Presumida was not checked");
						}
						if (inputRendaPresumida.isSelected()) {
							log.info("Renda Presumida was checked");
							qtdAttributesChecked++;
							String qtd = rendaPresumidaQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[27] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Renda Presumida is 0 in this filter");
					}
				}
				if (atributos.substring(27, 28).equals("0")) {
					log.info("Renda Presumida was not chosen in this test");
				}
				if (atributos.substring(28, 29).equals("1")) {
					qtdattributesSent++;
					if (!obitoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(obito);
						if (!inputObito.isSelected()) {
							waitToElementAndClick(obito);
							log.info("Óbito was not checked");
						}
						if (inputObito.isSelected()) {
							log.info("Óbito was checked");
							qtdAttributesChecked++;
							String qtd = obitoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[28] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Óbito is 0 in this filter");
					}
				}
				if (atributos.substring(28, 29).equals("0")) {
					log.info("Óbito was not chosen in this test");
				}
				if (atributos.substring(29, 30).equals("1")) {
					qtdattributesSent++;
					if (!bolsaFamiliaQtd.getText().equals("N.D.")) {
						waitToElementAndClick(bolsaFamilia);
						if (!inputBolsaFamilia.isSelected()) {
							waitToElementAndClick(bolsaFamilia);
							log.info("Bolsa Familia was not checked");
						}
						if (inputBolsaFamilia.isSelected()) {
							log.info("Bolsa Familia was checked");
							qtdAttributesChecked++;
							String qtd = bolsaFamiliaQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[29] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Bolsa Familia is 0 in this filter");
					}
				}
				if (atributos.substring(29, 30).equals("0")) {
					log.info("Bolsa Familia was not chosen in this test");
				}
				if (atributos.substring(30, 31).equals("1")) {
					qtdattributesSent++;
					if (!estadoCivilQtd.getText().equals("N.D.")) {
						waitToElementAndClick(estadoCivil);
						if (!inputEstadoCivil.isSelected()) {
							waitToElementAndClick(estadoCivil);
							log.info("Estado Civil was not checked");
						}
						if (inputEstadoCivil.isSelected()) {
							log.info("Estado Civil was checked");
							qtdAttributesChecked++;
							String qtd = estadoCivilQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[30] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Estado Civil is 0 in this filter");
					}
				}
				if (atributos.substring(30, 31).equals("0")) {
					log.info("Estado Civil was not chosen in this test");
				}
				if (atributos.substring(31, 32).equals("1")) {
					qtdattributesSent++;
					if (!funcionarioCltQtd.getText().equals("N.D.")) {
						waitToElementAndClick(funcionarioClt);
						if (!inputFuncionarioClt.isSelected()) {
							waitToElementAndClick(funcionarioClt);
							log.info("Funcionário Clt was not checked");
						}
						if (inputFuncionarioClt.isSelected()) {
							log.info("Funcionário Clt was checked");
							qtdAttributesChecked++;
							String qtd = funcionarioCltQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[31] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Funcionário Clt is 0 in this filter");
					}
				}
				if (atributos.substring(31, 32).equals("0")) {
					log.info("Funcionário Clt was not chosen in this test");
				}
				if (atributos.substring(32, 33).equals("1")) {
					qtdattributesSent++;
					if (!classeSocialQtd.getText().equals("N.D.")) {
						waitToElementAndClick(classeSocial);
						if (!inputClasseSocial.isSelected()) {
							waitToElementAndClick(classeSocial);
							log.info("Classe Social was not checked");
						}
						if (inputClasseSocial.isSelected()) {
							log.info("Classe Social was checked");
							qtdAttributesChecked++;
							String qtd = classeSocialQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[32] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Classe Social is 0 in this filter");
					}
				}
				if (atributos.substring(32, 33).equals("0")) {
					log.info("Classe Social was not chosen in this test");
				}
				if (atributos.substring(33, 34).equals("1")) {
					qtdattributesSent++;
					if (!restricaoFinanceiraQtd.getText().equals("N.D.")) {
						waitToElementAndClick(restricaoFinanceira);
						if (!inputRestricaoFinanceira.isSelected()) {
							waitToElementAndClick(restricaoFinanceira);
							log.info("Restrição Financeira was not checked");
						}
						if (inputRestricaoFinanceira.isSelected()) {
							log.info("Restrição Financeira was checked");
							qtdAttributesChecked++;
							String qtd = restricaoFinanceiraQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[33] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Restrição Financeira is 0 in this filter");
					}
				}
				if (atributos.substring(33, 34).equals("0")) {
					log.info("Restrição Financeira was not chosen in this test");
				}
				if (atributos.substring(34, 35).equals("1")) {
					qtdattributesSent++;
					if (!consignadoQtd.getText().equals("N.D.")) {
						waitToElementAndClick(consignado);
						if (!inputConsignado.isSelected()) {
							waitToElementAndClick(consignado);
							log.info("Consignado was not checked");
						}
						if (inputConsignado.isSelected()) {
							log.info("Consignado was checked");
							qtdAttributesChecked++;
							String qtd = consignadoQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[34] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Consignado is 0 in this filter");
					}
				}
				if (atributos.substring(34, 35).equals("0")) {
					log.info("Consignado was not chosen in this test");
				}
				if (atributos.substring(35, 36).equals("1")) {
					qtdattributesSent++;
					if (!tituloEleitorQtd.getText().equals("N.D.")) {
						waitToElementAndClick(tituloEleitor);
						if (!inputTituloEleitor.isSelected()) {
							waitToElementAndClick(tituloEleitor);
							log.info("Titulor de Eleitor was not checked");
						}
						if (inputTituloEleitor.isSelected()) {
							log.info("Titulor de Eleitor was checked");
							qtdAttributesChecked++;
							String qtd = tituloEleitorQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[35] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Título de eleitor is 0 in this filter");
					}
				}
				if (atributos.substring(35, 36).equals("0")) {
					log.info("Titulor de Eleitor was not chosen in this test");
				}
				if (atributos.substring(36, 37).equals("1")) {
					qtdattributesSent++;
					if (!rgQtd.getText().equals("N.D.")) {
						waitToElementAndClick(rg);
						if (!inputRg.isSelected()) {
							waitToElementAndClick(rg);
							log.info("Rg was not checked");
						}
						if (inputRg.isSelected()) {
							qtdAttributesChecked++;
							log.info("Rg was checked");
							String qtd = rgQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[36] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Rg is 0 in this filter");
					}
				}
				if (atributos.substring(36, 37).equals("0")) {
					log.info("Rg was not chosen in this test");
				}
				if (atributos.substring(37, 38).equals("1")) {
					qtdattributesSent++;
					if (!pisQtd.getText().equals("N.D.")) {
						waitToElementAndClick(pis);
						if (!inputPis.isSelected()) {
							waitToElementAndClick(pis);
							log.info("Pis was not checked");
						}
						if (inputPis.isSelected()) {
							qtdAttributesChecked++;
							log.info("Pis was checked");
							String qtd = pisQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[37] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Pis is 0 in this filter");
					}
				}
				if (atributos.substring(37, 38).equals("0")) {
					log.info("Titulor de Eleitor was not chosen in this test");
				}
				if (atributos.substring(38, 39).equals("1")) {
					qtdattributesSent++;
					if (!carteiraQtd.getText().equals("N.D.")) {
						waitToElementAndClick(carteira);
						if (!inputCarteira.isSelected()) {
							waitToElementAndClick(carteira);
							log.info("Carteira was not checked");
						}
						if (inputCarteira.isSelected()) {
							qtdAttributesChecked++;
							log.info("Carteira Profissional was checked");
							String qtd = carteiraQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[38] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Carteira Profissional is 0 in this filter");
					}
				}
				if (atributos.substring(38, 39).equals("0")) {
					log.info("Carteira Profissional was not chosen in this test");
				}
				if (atributos.substring(39, 40).equals("1")) {
					qtdattributesSent++;
					if (!conselhoProfissionalQtd.getText().equals("N.D.")) {
						waitToElementAndClick(conselhoProfissional);
						if (!inputConselhoProfissional.isSelected()) {
							waitToElementAndClick(conselhoProfissional);
							log.info("Conselho Profissional was not checked");
						}
						if (inputConselhoProfissional.isSelected()) {
							qtdAttributesChecked++;
							log.info("Conselho Profissional was checked");
							String qtd = conselhoProfissionalQtd.getText().replace(".", "");
							System.out.println("quantidade = " + qtd);
							arrayQuantidade[39] = Integer.parseInt(qtd);
						}
					} else {
						log.info("The quantity of the attribute Conselhor Profissional is 0 in this filter");
					}
				}
				if (atributos.substring(39, 40).equals("0")) {
					log.info("Conselho Profissional was not chosen in this test");
				}
				log.info("" + qtdAttributesChecked + " attributes were checked");
				log.info("" + qtdattributesSent + " attributes sent");

				if (qtdAttributesChecked == 0) {
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
	}

	public int[] chooseAttributesQuantityToZero(String attributes) {
		// Mudando a quantidade pra zero
		SegmentationInteraction segInt = new SegmentationInteraction(driver);
		if (attributes.length() == 40) {
			try {
				Thread.sleep(7000);
				if (attributes.substring(1, 2).equals("1")) {
					if (!nomeQtd.getText().equals("N.D.")) {
						waitToElementAndClick(nome);
						if (!inputNome.isSelected()) {
							log.info("Nome was not checked");
							waitToElementAndClick(nome);
						}
						if (inputNome.isSelected()) {
							log.info("Nome was checked");
							waitToElementAndClick(nomeQtd);
							arrayQuantidade[1] = segInt.changeQuantityToZero();// mudando a quantidade pra zero
							if (!inputNome.isEnabled()) {
								log.info("The quantity of the attribute Nome is 0 in this filter now");
							}
							if (inputNome.isEnabled()) {
								log.info("Nome should not be enable to be selected");
								throw new Exception("Nome should not be enable to be selected");
							}
						}
					} else {
						log.info("The quantity of the attribute Nome is 0 in this filter");
					}
				}
				if (attributes.substring(1, 2).equals("0")) {
					log.info("Nome was was not chosen in this test");
				}
			} catch (Exception e) {

			}
		}
		return arrayQuantidade;
	}

	public int[] chooseAttributesModeList(String atributos) throws Exception {
		// Método responsavel por selecionar os atributos -- Sem alterar a quantidade
		// deles
		// Enviamos um array de temanho 40 ( 40 atributos na pessoa física) - Se enviar
		// 1 , ele deve ser selecionado. Se enviar 0 , não deve ser selecionado.

		int qtdAttributesChecked = 0;// quantidade de atributos selecionados
		int qtdattributesSent = 0;// atributos enviados

		Thread.sleep(5000);

		driver.switchTo().activeElement();
		if (atributos.length() == 40) {
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
						input = linha.findElements(By.tagName("td")).get(0).findElements(By.tagName("input")).get(0);
						if (!input.isSelected()) { // verifica se ele foi mesmo selecionado
							log.info("Cpf was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Cpf was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[0] = Integer.parseInt(quantidade); // preenche o array com a quantidadade
																				// selecionada

						}
					} else {
						log.info("The quantity of the attribute Cpf is 0 in this filter");
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
							log.info("Nome was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Nome was checked");
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
						log.info("The quantity of the attribute Nome is 0 in this filter");
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
								// selecionada
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
							log.info("Endereço was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Endereço was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[3] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Endereço is 0 in this filter");
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
							log.info("Data de Nascimento was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Data de Nascimento was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[4] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Data de Nascimento is 0 in this filter");
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
							log.info("Gênero was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Gênero was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[5] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Gênero is 0 in this filter");
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
							log.info("Escolaridade was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Escolaridade was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[6] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Escolaridade is 0 in this filter");
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
							log.info("Nome Pai was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Nome Pai was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[7] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Nome Pai is 0 in this filter");
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
							log.info("Nome Mãe was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Nome Mãe was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[8] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Nome Mãe is 0 in this filter");
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
							log.info("Profissão was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Profissão was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[9] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Profissão is 0 in this filter");
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
							log.info("Email was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Email was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[10] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Email is 0 in this filter");
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
							log.info("Telefone 1 was not checked");
							waitToElementAndClick(input);
						}
						if (input.isSelected()) {// atributo foi selecionado
							log.info("Telefone 1 was checked");
							qtdAttributesChecked++; // aumenta a quantidade de atributos selecionados
							arrayQuantidade[11] = Integer.parseInt(quantidade); // preenche o array com a quantidade
																				// selecionada
						}
					} else {
						log.info("The quantity of the attribute Telefone 1 is 0 in this filter");
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

	}

	public void chooseAttributesQuantityToZeroListModeView(String atributos) throws Exception {
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
					Thread.sleep(1000);
					coluna.findElement(By.id("quantity")).clear();
					coluna.findElement(By.id("quantity")).sendKeys("0");
					arrayQuantidade[1] = 0; // preenche o array com a quantidade  selecionada
					log.info("The quantity of the attribute Nome is 0 in this filter");
				}
			} else {
				log.info("The quantity of the attribute Nome is 0 in this filter");
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
				log.info("Cpf should not be enable to be selected");
				throw new Exception("Attribute should not be enable to be selected");

			}
			Thread.sleep(2000);

		}

	}
/*/
	
}
