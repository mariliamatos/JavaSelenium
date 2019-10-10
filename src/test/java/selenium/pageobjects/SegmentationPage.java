package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SegmentationPage extends Pages {

	
	@FindBy(how = How.ID, using = "quantity")
	public WebElement quantity;

	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-quantity\"]/div/div[3]/div[2]/button")
	public WebElement btUpdateQt;

	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/main/section/div[2]/div[1]/div[2]/div[1]/label")
	public WebElement combinedBase;

	@FindBy(how = How.XPATH, using = "/html/body/div/div/main/div/section/div[3]/div[1]/div[2]/div[2]/button[2]")
	public WebElement btListMode;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"segment-page\"]/aside/div[3]/button")
	public WebElement btAplicar;
	
	
	public SegmentationPage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();

	}

}

