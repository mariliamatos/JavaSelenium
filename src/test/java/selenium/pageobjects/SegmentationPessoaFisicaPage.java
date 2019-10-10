package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class SegmentationPessoaFisicaPage extends SegmentationPage {



	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Masculino'])[1]/following::label[1]")
	public WebElement masculine;
	
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Feminino'])[1]/following::label[1]")
	public WebElement feminine;
	
	@FindBy(how = How.CLASS_NAME, using = "filter-type")
	public WebElement filter;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/aside/div[1]/div[2]/label[2]")
	public WebElement empresas;
	
	@FindBy(how = How.ID, using = "gender")
	public WebElement gender;
	
	@FindBy(how = How.ID, using = "demographic")
	public WebElement demographic;

	@FindBy(how = How.NAME, using = "demographicRangeMin")
	public WebElement demographicRangeMin;

	@FindBy(how = How.NAME, using = "demographicRangeMax")
	public WebElement demographicRangeMax;
	
	@FindBy(how = How.ID, using = "places")
	public WebElement places;
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-places\"]/div/div[1]/div/div[1]/span[1]")
	public WebElement stateBt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-places\"]/div/div[1]/div/div[2]/div/div/input")
	public WebElement stateSearch;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-places\"]/div/div[1]/div/div[2]/div/ul/li/label/span/span")
	public WebElement stateFirstOption;
	
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Cidade(s)'])[1]/following::span[1]")
	public WebElement cityBt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"cidade-opcoes\"]/div/div[2]/div/div/input")
	public WebElement citySearch;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"cidade-opcoes\"]/div/div[2]/div/ul/li[1]/label/span/span")
	public WebElement cityFirstOption;
									
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Bairro(s)'])[1]/following::span[1]")
	public WebElement neighborhoodBt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"bairro-opcoes\"]/div/div[2]/div/div/input")
	public WebElement neighborhoodSearch;

	@FindBy(how = How.XPATH, using = "//*[@id=\"bairro-opcoes\"]/div/div[2]/div/ul/li/label/span/span")
	public WebElement neighborhoodFirstOption;
	
	@FindBy(how = How.ID, using = "profession")
	public WebElement profession;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"profissao-opcoes\"]/div/div[1]/span[1]")
	public WebElement professionbt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"profissao-opcoes\"]/div/div[2]/div/div/input")
	public WebElement professionSearch;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"profissao-opcoes\"]/div/div[2]/div/ul/li[1]/label/span/span")
	public WebElement professionFirstOption;
									
	@FindBy(how = How.ID, using = "finance")
	public WebElement finance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-finance\"]/div/div[1]/div/label")
	public WebElement rangeFinance1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-finance\"]/div/div[2]/div/label")
	public WebElement rangeFinance2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-finance\"]/div/div[3]/div/label")
	public WebElement rangeFinance3;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-finance\"]/div/div[4]/div/label")
	public WebElement rangeFinance4;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-finance\"]/div/div[5]/div/label")
	public WebElement rangeFinance5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-finance\"]/div/div[6]/div/label")
	public WebElement rangeFinance6;
	
	@FindBy(how = How.ID, using = "school")
	public WebElement school;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-school\"]/div/div[1]/div/label")
	public WebElement rangeSchool1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-school\"]/div/div[2]/div/label")
	public WebElement rangeSchool2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-school\"]/div/div[3]/div/label")
	public WebElement rangeSchool3;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-school\"]/div/div[4]/div/label")
	public WebElement rangeSchool4;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-school\"]/div/div[5]/div/label")
	public WebElement rangeSchool5;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-school\"]/div/div[6]/div/label")
	public WebElement rangeSchool6;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-school\"]/div/div[7]/div/label")
	public WebElement rangeSchool7;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-school\"]/div/div[8]/div/label")
	public WebElement rangeSchool8;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-school\"]/div/div[9]/div/label")
	public WebElement rangeSchool9;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-school\"]/div/div[10]/div/label")
	public WebElement rangeSchool10;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-school\"]/div/div[11]/div/label")
	public WebElement rangeSchool11;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-school\"]/div/div[12]/div/label")
	public WebElement rangeSchool12;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-school\"]/div/div[13]/div/label")
	public WebElement rangeSchool13;

	@FindBy(how = How.ID, using = "debts")
	public WebElement debts;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-debts\"]/div/div[1]/div/label")
	public WebElement debtsYes;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-debts\"]/div/div[2]/div/label")
	public WebElement debtsNo;
	
	
	@FindBy(how = How.ID, using = "properties")
	public WebElement properties;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-properties\"]/div/div[1]/div/label")
	public WebElement propertiesYes;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-properties\"]/div/div[2]/div/label")
	public WebElement propertiesNo;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/nav/div/div/button[2]")
	public WebElement btmenucreateList;
	
	@FindBy(how = How.NAME, using = "nomeBase")
	public WebElement listName;


	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-shopcart\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]/button")
	public WebElement btcreateList;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-shopcart\"]/div/div[2]/div[1]/div[2]/div[2]/button")
	public WebElement btGoTohistoric;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"order-page\"]/div[3]/div/table/tbody/tr[1]/td[1]")
	public WebElement firstListName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"order-page\"]/div[3]/div/table/tbody/tr[1]/td[2]")
	public WebElement firstListId;

	@FindBy(how = How.XPATH, using = "//*[@id=\"order-page\"]/div[3]/div/table/tbody/tr[1]/td[6]")
	public WebElement firstListStatus;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/table/tbody/tr[1]/td[1]/div/label")
	public WebElement cpfListForm;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[1]/div[1]/div[1]/div/label")
	public WebElement cpf;            
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[2]/div[1]/div[1]/div/label")
	public WebElement nome;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[3]/div[1]/div[1]/div/label")
	public WebElement situacaoRF;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[4]/div[1]/div[1]/div/label")
	public WebElement endereco;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[5]/div[1]/div[1]/div/label")
	public WebElement dataNascimento;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[6]/div[1]/div[1]/div/label")
	public WebElement genero;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[7]/div[1]/div[1]/div/label")
	public WebElement escolaridade;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[8]/div[1]/div[1]/div/label")
	public WebElement nomepai;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[9]/div[1]/div[1]/div/label")
	public WebElement nomemae;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[10]/div[1]/div[1]/div/label")
	public WebElement profissao;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[11]/div[1]/div[1]/div/label")
	public WebElement mail;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[12]/div[1]/div[1]/div/label")
	public WebElement telefone1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[13]/div[1]/div[1]/div/label")
	public WebElement telefone2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[14]/div[1]/div[1]/div/label")
	public WebElement telefone3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[15]/div[1]/div[1]/div/label")
	public WebElement telefone4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[16]/div[1]/div[1]/div/label")
	public WebElement telefone5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[17]/div[1]/div[1]/div/label")
	public WebElement celular1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[18]/div[1]/div[1]/div/label")
	public WebElement celular2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[19]/div[1]/div[1]/div/label")
	public WebElement celular3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[20]/div[1]/div[1]/div/label")
	public WebElement celular4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[21]/div[1]/div[1]/div/label")
	public WebElement celular5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[22]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[23]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[24]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[25]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[26]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular5;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[27]/div[1]/div[1]/div/label")
	public WebElement veiculo;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[28]/div[1]/div[1]/div/label")
	public WebElement rendaPresumida;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[29]/div[1]/div[1]/div/label")
	public WebElement obito;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[30]/div[1]/div[1]/div/label")
	public WebElement bolsaFamilia;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[31]/div[1]/div[1]/div/label")
	public WebElement estadoCivil;
	

	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[32]/div[1]/div[1]/div/label")
	public WebElement funcionarioClt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[33]/div[1]/div[1]/div/label")
	public WebElement classeSocial;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[34]/div[1]/div[1]/div/label")
	public WebElement restricaoFinanceira;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[35]/div[1]/div[1]/div/label")
	public WebElement consignado;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[36]/div[1]/div[1]/div/label")
	public WebElement tituloEleitor;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[37]/div[1]/div[1]/div/label")
	public WebElement rg;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[38]/div[1]/div[1]/div/label")
	public WebElement pis;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[39]/div[1]/div[1]/div/label")
	public WebElement carteira;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[40]/div[1]/div[1]/div/label")
	public WebElement conselhoProfissional;
									
	

	@FindBy(how = How.XPATH, using = "//*[@id=\"CPF\"]")
	public WebElement inputCpf;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Nome\"]")
	public WebElement inputNome;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Situacao RF\"]")
	public WebElement inputSituacaoRF;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Endereco\"]")
	public WebElement inputEndereco;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Data Nascimento\"]")
	public WebElement inputDataNascimento;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Genero\"]")
	public WebElement inputGenero;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Escolaridade\"]")
	public WebElement inputEscolaridade;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Nome Pai\"]")
	public WebElement inputNomePai;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Nome Mae\"]")
	public WebElement inputNomeMae;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Profissão\"]")
	public WebElement inputProfissao;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"E-mail\"]")
	public WebElement inputMail;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Telefone Fixo 1\"]")
	public WebElement inputTelefone1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Telefone Fixo 2\"]")
	public WebElement inputTelefone2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Telefone Fixo 3\"]")
	public WebElement inputTelefone3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Telefone Fixo 4\"]")
	public WebElement inputTelefone4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Telefone Fixo 5\"]")
	public WebElement inputTelefone5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Telefone Celular 1\"]")
	public WebElement inputCelular1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Telefone Celular 2\"]")
	public WebElement inputCelular2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Telefone Celular 3\"]")
	public WebElement inputCelular3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Telefone Celular 4\"]")
	public WebElement inputCelular4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Telefone Celular 5\"]")
	public WebElement inputCelular5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"WahtasApp Celular 1\"]")
	public WebElement inputWhatsAppcelular1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"WahtasApp Celular 2\"]")
	public WebElement inputWhatsAppcelular2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"WahtasApp Celular 3\"]")
	public WebElement inputWhatsAppcelular3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"WahtasApp Celular 4\"]")
	public WebElement inputWhatsAppcelular4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"WahtasApp Celular 5\"]")
	public WebElement inputWhatsAppcelular5;

	@FindBy(how = How.XPATH, using = "//*[@id=\"Veiculo\"]")
	public WebElement inputVeiculo;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Renda Presumida\"]")
	public WebElement inputRendaPresumida;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Obito\"]")
	public WebElement inputObito;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Bolsa Familia\"]")
	public WebElement inputBolsaFamilia;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Estado Civil\"]")
	public WebElement inputEstadoCivil;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Funcionario CLT\"]")
	public WebElement inputFuncionarioClt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Classe Social\"]")
	public WebElement inputClasseSocial;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Restrição Financeira\"]")
	public WebElement inputRestricaoFinanceira;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Consignado\"]")
	public WebElement inputConsignado;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Título de Eleitor\"]")
	public WebElement inputTituloEleitor;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"RG\"]")
	public WebElement inputRg;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"PIS\"]")
	public WebElement inputPis;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Carteira Profissional\"]")
	public WebElement inputCarteira;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Conselho Profissional\"]")
	public WebElement inputConselhoProfissional;
									
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[1]/div[2]/div/div[1]")
	public WebElement cpfQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[2]/div[2]/div/div[1]")
	public WebElement nomeQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[3]/div[2]/div/div[1]")
	public WebElement situacaoRFQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[4]/div[2]/div/div[1]")
	public WebElement enderecoQtd;


	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[5]/div[2]/div/div[1]")
	public WebElement dataNascimentoQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[6]/div[2]/div/div[1]")
	public WebElement generoQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[7]/div[2]/div/div[1]")
	public WebElement escolaridadeQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[8]/div[2]/div/div[1]")
	public WebElement nomepaiQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[9]/div[2]/div/div[1]")
	public WebElement nomemaeQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[10]/div[2]/div/div[1]")
	public WebElement profissaoQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[11]/div[2]/div/div[1]")
	public WebElement mailQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[12]/div[2]/div/div[1]")
	public WebElement telefone1Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[13]/div[2]/div/div[1]")
	public WebElement telefone2Qtd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[14]/div[2]/div/div[1]")
	public WebElement telefone3Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[15]/div[2]/div/div[1]")
	public WebElement telefone4Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[16]/div[2]/div/div[1]")
	public WebElement telefone5Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[17]/div[2]/div/div[1]")
	public WebElement celular1Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[18]/div[2]/div/div[1]")
	public WebElement celular2Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[19]/div[2]/div/div[1]")
	public WebElement celular3Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[20]/div[2]/div/div[1]")
	public WebElement celular4Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[21]/div[2]/div/div[1]")
	public WebElement celular5Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[22]/div[2]/div/div[1]")
	public WebElement whatsAppcelular1Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[23]/div[2]/div/div[1]")
	public WebElement whatsAppcelular2Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[24]/div[2]/div/div[1]")
	public WebElement whatsAppcelular3Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[25]/div[2]/div/div[1]")
	public WebElement whatsAppcelular4Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[26]/div[2]/div/div[1]")
	public WebElement whatsAppcelular5Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[27]/div[2]/div/div[1]")
	public WebElement veiculoQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[28]/div[2]/div/div[1]")
	public WebElement rendaPresumidaQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[29]/div[2]/div/div[1]")
	public WebElement obitoQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[30]/div[2]/div/div[1]")
	public WebElement bolsaFamiliaQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[23]/div[2]/div/div[1]")
	public WebElement estadoCivilQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[32]/div[2]/div/div[1]")
	public WebElement funcionarioCltQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[33]/div[2]/div/div[1]")
	public WebElement classeSocialQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[34]/div[2]/div/div[1]")
	public WebElement restricaoFinanceiraQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[35]/div[2]/div/div[1]")
	public WebElement consignadoQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[36]/div[2]/div/div[1]")
	public WebElement tituloEleitorQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[37]/div[2]/div/div[1]")
	public WebElement rgQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[38]/div[2]/div/div[1]")
	public WebElement pisQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[39]/div[2]/div/div[1]")
	public WebElement carteiraQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[40]/div[2]/div/div[1]")
	public WebElement conselhoProfissionalQtd;
	
	public SegmentationPessoaFisicaPage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();
	}

}
