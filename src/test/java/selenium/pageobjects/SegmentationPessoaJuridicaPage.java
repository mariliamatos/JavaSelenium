package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class SegmentationPessoaJuridicaPage extends SegmentationPage {



	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Masculino'])[1]/following::label[1]")
	public WebElement masculine;
	
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Feminino'])[1]/following::label[1]")
	public WebElement feminine;
	
	@FindBy(how = How.CLASS_NAME, using = "filter-type")
	public WebElement filter;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/aside/div[1]/div[2]/label[2]")
	public WebElement empresas;
	
	@FindBy(how = How.ID, using = "status")
	public WebElement status;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-status\"]/div/div[1]/div/label")
	public WebElement statusBaixada;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-status\"]/div/div[2]/div/label")
	public WebElement statusBaixadaExterior;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-status\"]/div/div[3]/div/label")
	public WebElement statusAtiva;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-status\"]/div/div[4]/div/label")
	public WebElement statusAtivaExterior;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-status\"]/div/div[5]/div/label")
	public WebElement statusInapta;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-status\"]/div/div[6]/div/label")
	public WebElement statusNula;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-status\"]/div/div[7]/div/label")
	public WebElement statusNulaExterior;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-status\"]/div/div[8]/div/label")
	public WebElement statusSuspensa;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-status\"]/div/div[9]/div/label")
	public WebElement statusSuspensaExterior;
	
	@FindBy(how = How.ID, using = "places")
	public WebElement places;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-places\"]/div/div[1]/div/div")
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
	
	@FindBy(how = How.ID, using = "activity")
	public WebElement activity;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"cnaes-opcoes\"]/div/div[1]/span[1]")
	public WebElement activityBt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"cnaes-opcoes\"]/div/div[2]/div/div/input")
	public WebElement activitySearch;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"cnaes-opcoes\"]/div/div[2]/div/ul/li[1]/label/span/span")
	public WebElement activityFirstOption;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"cnae-opcoes\"]/div/div[2]/div/ul/li[1]/label/span/input")
	public WebElement activityInput;

	@FindBy(how = How.ID, using = "opening")
	public WebElement opening;
	
	@FindBy(how = How.NAME, using = "startDate")
	public WebElement openingStart;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-opening\"]/div/div[3]/div/div[2]/span/span[3]/select")
	public WebElement openingYear;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-opening\"]/div/div[3]/div/div[2]/span/span[1]/select")
	public WebElement openingMonth;
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='dom'])[1]/following::span[12]")
	public WebElement openingStartDay;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-opening\"]/div/div[3]/div/div[1]/div/span[2]/input")
	public WebElement openingFinal;
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='dom'])[1]/following::span[64]")
	public WebElement openingFinalDay;
	
	@FindBy(how = How.ID, using = "employee")
	public WebElement employee;
	
	@FindBy(how = How.NAME, using = "employeeRangeMin")
	public WebElement employeeRangeMin;

	@FindBy(how = How.NAME, using = "employeeRangeMax")
	public WebElement employeeRangeMax;

	@FindBy(how = How.ID, using = "size")
	public WebElement size;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"porte-opcoes\"]/div/div[1]/span[1]")
	public WebElement sizeBt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"porte-opcoes\"]/div/div[2]/div/div/input")
	public WebElement sizeSearch;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"porte-opcoes\"]/div/div[2]/div/ul/li[1]/label/span/span")
	public WebElement sizeFirstOption;
									
	
	@FindBy(how = How.ID, using = "kind")
	public WebElement kind;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"natureza-opcoes\"]/div/div[1]/span[1]")
	public WebElement kindBt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"natureza-opcoes\"]/div/div[2]/div/div/input")
	public WebElement kindSearch;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"natureza-opcoes\"]/div/div[2]/div/ul/li[1]/label/span/span")
	public WebElement kindFirstOption;
	
	
	@FindBy(how = How.ID, using = "debts")
	public WebElement debts;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-debts\"]/div/div[1]/div/label")
	public WebElement debtsYes;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-debts\"]/div/div[2]/div/label")
	public WebElement debtsNo;
	
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
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[1]/div[1]/div[1]/div/label")
	public WebElement cnpj;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[2]/div[1]/div[1]/div/label")
	public WebElement razaoSocial;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[3]/div[1]/div[1]/div/label")
	public WebElement situacaoRF;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[4]/div[1]/div[1]/div/label")
	public WebElement dataFundacao;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[5]/div[1]/div[1]/div/label")
	public WebElement nomeFantasia;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[6]/div[1]/div[1]/div/label")
	public WebElement email;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[7]/div[1]/div[1]/div/label")
	public WebElement telefone1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[8]/div[1]/div[1]/div/label")
	public WebElement telefone2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[9]/div[1]/div[1]/div/label")
	public WebElement telefone3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[10]/div[1]/div[1]/div/label")
	public WebElement telefone4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[11]/div[1]/div[1]/div/label")
	public WebElement telefone5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[12]/div[1]/div[1]/div/label")
	public WebElement celular1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[13]/div[1]/div[1]/div/label")
	public WebElement celular2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[14]/div[1]/div[1]/div/label")
	public WebElement celular3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[15]/div[1]/div[1]/div/label")
	public WebElement celular4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[16]/div[1]/div[1]/div/label")
	public WebElement celular5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[17]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[18]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[19]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[20]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[21]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[22]/div[1]/div[1]/div/label")
	public WebElement cnae;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[23]/div[1]/div[1]/div/label")
	public WebElement porte;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[24]/div[1]/div[1]/div/label")
	public WebElement numeroFuncionarios;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[25]/div[1]/div[1]/div/label")
	public WebElement faturamento;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[26]/div[1]/div[1]/div/label")
	public WebElement socio1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[27]/div[1]/div[1]/div/label")
	public WebElement socio2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[28]/div[1]/div[1]/div/label")
	public WebElement socio3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[29]/div[1]/div[1]/div/label")
	public WebElement restricaoFinanceira;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[30]/div[1]/div[1]/div/label")
	public WebElement sintegra;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[31]/div[1]/div[1]/div/label")
	public WebElement endereco;
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"CNPJ\"]")
	public WebElement inputCnpj;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Razao Social\"]")
	public WebElement inputRazaoSocial;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Situação RF\"]")
	public WebElement inputSituacaoRF;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Data Fundacao\"]")
	public WebElement inputDataFundacao;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Nome Fantasia\"]")
	public WebElement inputNomeFantasia;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"E-mail\"]")
	public WebElement inputEmail;
	
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
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"WhatsApp Celular 1\"]")
	public WebElement inputWhatsAppcelular1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"WhatsApp Celular 2\"]")
	public WebElement inputWhatsAppcelular2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"WhatsApp Celular 3\"]")
	public WebElement inputWhatsAppcelular3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"WhatsApp Celular 4\"]")
	public WebElement inputWhatsAppcelular4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"WhatsApp Celular 5\"]")
	public WebElement inputWhatsAppcelular5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"CNAE\"]")
	public WebElement inputCnae;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Porte\"]")
	public WebElement inputPorte;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Numero Funcionarios\"]")
	public WebElement inputNumeroFuncionarios;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Faturamento Presumido\"]")
	public WebElement inputFaturamento;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Socio 1\"]")
	public WebElement inputSocio1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Socio 2\"]")
	public WebElement inputSocio2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Socio 3\"]")
	public WebElement inputSocio3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Restricao Financeira\"]")
	public WebElement inputRestricaoFinanceira;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Sintegra\"]")
	public WebElement inputSintegra;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Endereco\"]")
	public WebElement inputEndereco;
	

	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[1]/div[2]/div/div[1]")
	public WebElement cnpjQt;

	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[2]/div[2]/div/div[1]")
	public WebElement razaoSocialQt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[3]/div[2]/div/div[1]")
	public WebElement situacaoRFQt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[4]/div[2]/div/div[1]")
	public WebElement dataFundacaoQt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[5]/div[2]/div/div[1]")
	public WebElement nomeFantasiaQt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[6]/div[2]/div/div[1]")
	public WebElement emailQt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[7]/div[2]/div/div[1]")
	public WebElement telefone1Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[8]/div[2]/div/div[1]")
	public WebElement telefone2Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[9]/div[2]/div/div[1]")
	public WebElement telefone3Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[10]/div[2]/div/div[1]")
	public WebElement telefone4Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[11]/div[2]/div/div[1]")
	public WebElement telefone5Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[12]/div[2]/div/div[1]")
	public WebElement celular1Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[13]/div[2]/div/div[1]")
	public WebElement celular2Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[14]/div[2]/div/div[1]")
	public WebElement celular3Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[15]/div[2]/div/div[1]")
	public WebElement celular4Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[16]/div[2]/div/div[1]")
	public WebElement celular5Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[17]/div[2]/div/div[1]")
	public WebElement whatsAppcelular1Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[18]/div[2]/div/div[1]")
	public WebElement whatsAppcelular2Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[19]/div[2]/div/div[1]")
	public WebElement whatsAppcelular3Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[20]/div[2]/div/div[1]")
	public WebElement whatsAppcelular4Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[21]/div[2]/div/div[1]")
	public WebElement whatsAppcelular5Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[22]/div[2]/div/div[1]")
	public WebElement cnaeQt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[23]/div[2]/div/div[1]")
	public WebElement porteQt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[24]/div[2]/div/div[1]")
	public WebElement numeroFuncionariosQt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[25]/div[2]/div/div[1]")
	public WebElement faturamentoQt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[26]/div[2]/div/div[1]")
	public WebElement socio1Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[27]/div[2]/div/div[1]")
	public WebElement socio2Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[28]/div[2]/div/div[1]")
	public WebElement socio3Qt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[29]/div[2]/div/div[1]")
	public WebElement restricaoFinanceiraQt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[30]/div[2]/div/div[1]")
	public WebElement sintegraQt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[31]/div[2]/div/div[1]")
	public WebElement enderecoQt;
	
	
	
	public SegmentationPessoaJuridicaPage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();
	}

}
