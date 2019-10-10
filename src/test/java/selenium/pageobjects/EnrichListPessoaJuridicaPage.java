package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class EnrichListPessoaJuridicaPage extends Pages {

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/nav/div/ul/li[2]/a")
	public WebElement enrichButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div/div[3]/div[1]/label")
	public WebElement pf;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div/div[3]/div[2]/label")
	public WebElement pj;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"btn-upload-file\"]/div")
	public WebElement btUploadFile;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"enrichment-upload\"]/aside/ul/li/div/div[5]/button")
	public WebElement btEnrich;
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Não são aceitos arquivos com CPFs e CNPJs misturados.'])[1]/following::input[1]")
	public WebElement file;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[2]/div[1]/div[1]/div/label")
	public WebElement razaoSocial;            
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[3]/div[1]/div[1]/div/label")
	public WebElement situacaoRF;
								
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[4]/div[1]/div[1]/div/label")
	public WebElement dataFundacao;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[5]/div[1]/div[1]/div/label")
	public WebElement nomeFantasia;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[6]/div[1]/div[1]/div/label")
	public WebElement email;
		
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[7]/div[1]/div[1]/div/label")
	public WebElement telefone1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[8]/div[1]/div[1]/div/label")
	public WebElement telefone2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[9]/div[1]/div[1]/div/label")
	public WebElement telefone3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[10]/div[1]/div[1]/div/label")
	public WebElement telefone4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[11]/div[1]/div[1]/div/label")
	public WebElement telefone5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[12]/div[1]/div[1]/div/label")
	public WebElement celular1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[13]/div[1]/div[1]/div/label")
	public WebElement celular2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[14]/div[1]/div[1]/div/label")
	public WebElement celular3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[15]/div[1]/div[1]/div/label")
	public WebElement celular4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[16]/div[1]/div[1]/div/label")
	public WebElement celular5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[17]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[18]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[19]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[20]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[21]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[22]/div[1]/div[1]/div/label")
	public WebElement cnae;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[23]/div[1]/div[1]/div/label")
	public WebElement porte;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[24]/div[1]/div[1]/div/label")
	public WebElement numeroFuncionarios;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[25]/div[1]/div[1]/div/label")
	public WebElement faturamento;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[26]/div[1]/div[1]/div/label")
	public WebElement socio1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[27]/div[1]/div[1]/div/label")
	public WebElement socio2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[28]/div[1]/div[1]/div/label")
	public WebElement socio3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[29]/div[1]/div[1]/div/label")
	public WebElement restricaoFinanceira;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[30]/div[1]/div[1]/div/label")
	public WebElement sintegra;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[31]/div[1]/div[1]/div/label")
	public WebElement endereco;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[1]/div[2]/div/div[1]/button")
	public WebElement cnpjQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[2]/div[2]/div/div[1]/button")
	public WebElement razaoSocialQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[3]/div[2]/div/div[1]/button")
	public WebElement situacaoRFQtd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[4]/div[2]/div/div[1]/button")
	public WebElement dataFundacaoQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[5]/div[2]/div/div[1]/button")
	public WebElement nomeFantasiaQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[6]/div[2]/div/div[1]/button")
	public WebElement emailQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[7]/div[2]/div/div[1]/button")
	public WebElement telefone1Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[8]/div[2]/div/div[1]/button")
	public WebElement telefone2Qtd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[9]/div[2]/div/div[1]/button")
	public WebElement telefone3Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[10]/div[2]/div/div[1]/button")
	public WebElement telefone4Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[11]/div[2]/div/div[1]/button")
	public WebElement telefone5Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[12]/div[2]/div/div[1]/button")
	public WebElement celular1Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[13]/div[2]/div/div[1]/button")
	public WebElement celular2Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[14]/div[2]/div/div[1]/button")
	public WebElement celular3Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[15]/div[2]/div/div[1]/button")
	public WebElement celular4Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[16]/div[2]/div/div[1]/button")
	public WebElement celular5Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[17]/div[2]/div/div[1]/button")
	public WebElement whatsAppcelular1Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[18]/div[2]/div/div[1]/button")
	public WebElement whatsAppcelular2Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[19]/div[2]/div/div[1]/button")
	public WebElement whatsAppcelular3Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[20]/div[2]/div/div[1]/button")
	public WebElement whatsAppcelular4Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[21]/div[2]/div/div[1]/button")
	public WebElement whatsAppcelular5Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[22]/div[2]/div/div[1]/button")
	public WebElement cnaeQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[23]/div[2]/div/div[1]/button")
	public WebElement porteQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[24]/div[2]/div/div[1]/button")
	public WebElement numeroFuncionariosQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[25]/div[2]/div/div[1]/button")
	public WebElement faturamentoQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[26]/div[2]/div/div[1]/button")
	public WebElement socio1Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[27]/div[2]/div/div[1]/button")
	public WebElement socio2Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[28]/div[2]/div/div[1]/button")
	public WebElement socio3Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[29]/div[2]/div/div[1]/button")
	public WebElement restricaoFinanceiraQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[30]/div[2]/div/div[1]/button")
	public WebElement sintegraQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[31]/div[2]/div/div[1]/button")
	public WebElement enderecoQtd;
	
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
	
	
	public EnrichListPessoaJuridicaPage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();
	}

}
