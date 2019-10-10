package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class LoginPage extends Pages {


	@FindBy(how = How.CLASS_NAME, using = "btn-login")
    public WebElement menuLogin;
	
	@FindBy(how = How.NAME, using = "username")
	public WebElement username;

	@FindBy(how = How.NAME, using = "password")
	public WebElement password;

	@FindBy(how = How.CLASS_NAME, using = "ibtn")
	public WebElement btnLogin;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div/div[4]/div/div/div/form/div[2]/button[1]")
	public WebElement btnSubmit;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/span")
	public WebElement userNameConfirmation;

	@FindBy(how = How.NAME, using = "form")
	public WebElement form;
	
	@FindBy(how = How.CLASS_NAME, using = "page-username")
	public WebElement pageusername;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/nav/div/div/div/div/div[2]/button")
	public WebElement divUser;
	
	@FindBy(how = How.CLASS_NAME, using = "email")
	public WebElement email;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div/div[4]/div/div/div/form/div[2]/button[2]")
	public WebElement resetPasswordButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div/div[4]/div/div/div/form/div/button")
	public WebElement confirmResetPasswordButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div/div[4]/div/div/form/div[2]/button")
	public WebElement confirmCpfResetPasswordButton;
		
	@FindBy(how = How.NAME, using = "document")
	public WebElement resetCPF;
	
	@FindBy(how = How.NAME, using = "password")
	public WebElement resetPassword;
	
	@FindBy(how = How.NAME, using = "password_confirm")
	public WebElement confirmResetPassword;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[2]>")
	public WebElement messageError;
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Masculino'])[1]/following::label[1]")
	public WebElement masculine;
	
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Feminino'])[1]/following::label[1]")
	public WebElement feminine;
	
	
	@FindBy(how = How.CLASS_NAME, using = "main-fixed")
	public WebElement formTeste;
	

	
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
	public WebElement 	places;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-places\"]/div/div[1]/div/div")
	public WebElement 	placesBt;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-places\"]/div/div[1]/div/div/div[2]/div/div/input")
	public WebElement stateSearch;

	@FindBy(how = How.XPATH, using = "//*[@id=\"collapse-places\"]/div/div[1]/div/div/div[2]/div/ul/li[1]/label/span/span")
	public WebElement stateSp;
	
	@FindBy(how = How.ID, using = "profession")
	public WebElement profession;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"profissao-opcoes\"]/div/div")
	public WebElement professionOptions;

	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Selecione'])[4]/following::input[1]")
	public WebElement professionSearch;
		
	@FindBy(how = How.XPATH, using = "//*[@id=\"profissao-opcoes\"]/div/div/div[2]/div/label/span/span")
	public WebElement professionselectOption;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"profissao-opcoes\"]/div/div/div[2]/div/ul/li[104]/label")
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
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[1]/div[1]/div[1]/div/label")
	public WebElement cpfSelect;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[2]/div[1]/div[1]/div/label")
	public WebElement nomeSelect;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[2]/div[3]/div[1]/div[1]/div/label")
	public WebElement situacaoRFSelect;
	
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
	
	
	public LoginPage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();
	}

}
