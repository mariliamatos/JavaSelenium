package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;




public class EnrichListPessoaFisicaPage extends Pages {

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
	public WebElement nome;            
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[3]/div[1]/div[1]/div/label")
	public WebElement situacaoRF;
								
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[4]/div[1]/div[1]/div/label")
	public WebElement endereco;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[5]/div[1]/div[1]/div/label")
	public WebElement dataNascimento;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[6]/div[1]/div[1]/div/label")
	public WebElement genero;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[7]/div[1]/div[1]/div/label")
	public WebElement escolaridade;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[8]/div[1]/div[1]/div/label")
	public WebElement nomepai;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[9]/div[1]/div[1]/div/label")
	public WebElement nomemae;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[10]/div[1]/div[1]/div/label")
	public WebElement profissao;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[11]/div[1]/div[1]/div/label")
	public WebElement mail;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[12]/div[1]/div[1]/div/label")
	public WebElement telefone1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[13]/div[1]/div[1]/div/label")
	public WebElement telefone2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[14]/div[1]/div[1]/div/label")
	public WebElement telefone3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[15]/div[1]/div[1]/div/label")
	public WebElement telefone4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[16]/div[1]/div[1]/div/label")
	public WebElement telefone5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[17]/div[1]/div[1]/div/label")
	public WebElement celular1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[18]/div[1]/div[1]/div/label")
	public WebElement celular2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[19]/div[1]/div[1]/div/label")
	public WebElement celular3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[20]/div[1]/div[1]/div/label")
	public WebElement celular4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[21]/div[1]/div[1]/div/label")
	public WebElement celular5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[22]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[23]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[24]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[25]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular4;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[26]/div[1]/div[1]/div/label")
	public WebElement whatsAppcelular5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[27]/div[1]/div[1]/div/label")
	public WebElement veiculo;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[28]/div[1]/div[1]/div/label")
	public WebElement rendaPresumida;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[29]/div[1]/div[1]/div/label")
	public WebElement obito;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[30]/div[1]/div[1]/div/label")
	public WebElement bolsaFamilia;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[31]/div[1]/div[1]/div/label")
	public WebElement estadoCivil;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[32]/div[1]/div[1]/div/label")
	public WebElement funcionarioClt;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[33]/div[1]/div[1]/div/label")
	public WebElement classeSocial;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[34]/div[1]/div[1]/div/label")
	public WebElement restricaoFinanceira;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[35]/div[1]/div[1]/div/label")
	public WebElement consignado;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[36]/div[1]/div[1]/div/label")
	public WebElement tituloEleitor;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[37]/div[1]/div[1]/div/label")
	public WebElement rg;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[38]/div[1]/div[1]/div/label")
	public WebElement pis;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[39]/div[1]/div[1]/div/label")
	public WebElement carteira;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[40]/div[1]/div[1]/div/label")
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
									
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[1]/div[2]/div/div[1]/button")
	public WebElement cpfQtd;
 
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[2]/div[2]/div/div[1]/button")
	public WebElement nomeQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[3]/div[2]/div/div[1]/button")
	public WebElement situacaoRFQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[4]/div[2]/div/div[1]/button")
	public WebElement enderecoQtd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[5]/div[2]/div/div[1]/button")
	public WebElement dataNascimentoQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[6]/div[2]/div/div[1]/button")
	public WebElement generoQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[7]/div[2]/div/div[1]/button")
	public WebElement escolaridadeQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[8]/div[2]/div/div[1]/button")
	public WebElement nomepaiQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[9]/div[2]/div/div[1]/button")
	public WebElement nomemaeQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[10]/div[2]/div/div[1]/button")
	public WebElement profissaoQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[11]/div[2]/div/div[1]/button")
	public WebElement mailQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[12]/div[2]/div/div[1]/button")
	public WebElement telefone1Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[13]/div[2]/div/div[1]/button")
	public WebElement telefone2Qtd;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[14]/div[2]/div/div[1]/button")
	public WebElement telefone3Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[15]/div[2]/div/div[1]/button")
	public WebElement telefone4Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[16]/div[2]/div/div[1]/button")
	public WebElement telefone5Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[17]/div[2]/div/div[1]/button")
	public WebElement celular1Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[18]/div[2]/div/div[1]/button")
	public WebElement celular2Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[19]/div[2]/div/div[1]/button")
	public WebElement celular3Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[20]/div[2]/div/div[1]/button")
	public WebElement celular4Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[21]/div[2]/div/div[1]/button")
	public WebElement celular5Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[22]/div[2]/div/div[1]/button")
	public WebElement whatsAppcelular1Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[23]/div[2]/div/div[1]/button")
	public WebElement whatsAppcelular2Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[24]/div[2]/div/div[1]/button")
	public WebElement whatsAppcelular3Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[25]/div[2]/div/div[1]/button")
	public WebElement whatsAppcelular4Qtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[26]/div[2]/div/div[1]/button")
	public WebElement whatsAppcelular5Qtd;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[27]/div[2]/div/div[1]/button")
	public WebElement veiculoQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[28]/div[2]/div/div[1]/button")
	public WebElement rendaPresumidaQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[29]/div[2]/div/div[1]/button")
	public WebElement obitoQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[30]/div[2]/div/div[1]/button")
	public WebElement bolsaFamiliaQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[31]/div[2]/div/div[1]/button")
	public WebElement estadoCivilQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[32]/div[2]/div/div[1]/button")
	public WebElement funcionarioCltQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[33]/div[2]/div/div[1]/button")
	public WebElement classeSocialQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[34]/div[2]/div/div[1]/button")
	public WebElement restricaoFinanceiraQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[35]/div[2]/div/div[1]/button")
	public WebElement consignadoQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[36]/div[2]/div/div[1]/button")
	public WebElement tituloEleitorQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[37]/div[2]/div/div[1]/button")
	public WebElement rgQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[38]/div[2]/div/div[1]/button")
	public WebElement pisQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[39]/div[2]/div/div[1]/button")
	public WebElement carteiraQtd;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div[2]/section/div[2]/div[40]/div[2]/div/div[1]/button")
	public WebElement conselhoProfissionalQtd;
	

	
	public EnrichListPessoaFisicaPage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();
	}

}
