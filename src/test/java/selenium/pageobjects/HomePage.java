package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends Pages {


	@FindBy(how = How.CLASS_NAME, using = "btn-login")
    public WebElement menuLogin;
	

	public HomePage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();
	}

}
