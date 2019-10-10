package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class RegisterPage extends Pages {


	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/nav/button[3]")
    public WebElement menuLogin;
	
	@FindBy(how = How.LINK_TEXT, using = "Registrar")
	public WebElement menuRegistrar;

	@FindBy(how = How.NAME, using = "username")
	public WebElement username;
	
	@FindBy(how = How.NAME, using = "username")
	public WebElement usernameLogin;
		
	@FindBy(how = How.NAME, using = "operador")
	public WebElement operador;
	
	@FindBy(how = How.NAME, using = "document")
	public WebElement cpf;
	
	@FindBy(how = How.NAME, using = "password")
	public WebElement password;

	@FindBy(how = How.NAME, using = "form")
	public WebElement form;
	
	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Registrar'])[1]/following::button[1]")
	public WebElement btnLogin;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div[2]/div/form/div[2]")
	public WebElement messageWrongPassword;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/span")
	public WebElement userNameConfirmation;

//	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Acesso'])[1]/following::input[4]")
//	public WebElement bthdate;//*[@id="root"]/div/div/div/div[4]/div/div/form/div[3]/div[1]/div/input
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div/div[4]/div/div/form/div[3]/div[1]/div/input")
	public WebElement bthdate;//*[@id="root"]/div/div/div/div[4]/div/div/form/div[3]/div[1]/div/input
	
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"root\"]/div/div/div/div[4]/div/div/form/div[4]/button")
	public WebElement btProxima;
	//*[@id="root"]/div/div/div/div[4]/div/div/form/div[4]/button
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[2]/button")
	public WebElement btRegistrar;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div/div[4]/div/div/form/button")
	public WebElement btUpdateUser;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div/div[4]/div/div/form/div[5]/button[1]")
	public WebElement btUpdateEmail;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[2]>")
	public WebElement messageError;
	
	public RegisterPage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();
	}

}
