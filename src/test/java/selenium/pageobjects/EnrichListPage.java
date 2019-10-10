package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;




public class EnrichListPage extends Pages {

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
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"enrichment-page\"]/div[2]/div[2]/div/button[2]")
	public WebElement btListMode;
		

	public EnrichListPage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();
	}

}
