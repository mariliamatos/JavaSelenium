package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;




public class CreateListPage extends Pages {


	@FindBy(how = How.CLASS_NAME, using = "filter-type")
	public WebElement filter;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/aside/div[1]/div[2]/label[2]")
	public WebElement empresas;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/nav/div/div/button[2]")
	public WebElement btmenucreateList;

	@FindBy(how = How.NAME, using = "nomeBase")
	public WebElement listName;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[1]/div/div/div[3]/div/div[2]/button")
	public WebElement btcreateList;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-shopcart\"]/div/div[1]/div[2]/div[2]/button")
	public WebElement btGoTohistoric;
	//*[@id="modal-shopcart"]/div/div[1]/div[2]/div[2]/button
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"order-page\"]/div[3]/table/tbody/tr[1]/td[1]")
	public WebElement firstListName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"order-page\"]/div[3]/table/tbody/tr[1]/td[2]")
	public WebElement firstListId;

	@FindBy(how = How.XPATH, using = "//*[@id=\"order-page\"]/div[3]/table/tbody/tr[1]/td[6]")
	public WebElement firstListStatus;



	@FindBy(how = How.XPATH, using = "//*[@id=\"order-page\"]/div[3]/table/tbody/tr[1]/td[6]/div/div/button[1]")
	public WebElement btXlsx;		 	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"order-page\"]/div[3]/table/tbody/tr[1]/td[6]/div/div/button[2]")
	public WebElement btCsv;

	@FindBy(how = How.XPATH, using = "//*[@id=\"order-page\"]/div[3]/table/tbody/tr[1]/td[6]/div/div/button[3]")
	public WebElement btTxt;

	
	
	
	public CreateListPage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();
	}

}
