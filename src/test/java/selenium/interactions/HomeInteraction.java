package selenium.interactions;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import selenium.pageobjects.LoginPage;

public class HomeInteraction extends LoginPage {

	private final Logger log = Logger.getLogger(HomeInteraction.class);

	public HomeInteraction(final WebDriver driver) {
		super(driver);
	}

	public void navigateToHomePage() throws Exception {
		try { 
			goToUrl(getTestData("homePage"));//redirecionando pra homepage
			log.info("User is in the Home Page");
		} catch (Exception e) {
			log.error("It was not possible to redirect to HomePage");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void nagivateToIdentityPage() throws InterruptedException, MessagingException {
		try {
			goToUrl(getTestData("identityUrl")); //redirecionando pra identityPage
			log.info("User is in authetication page");
		} catch (Exception e) {
			log.error("It was not possible to redirect to IdentityPage");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

}
