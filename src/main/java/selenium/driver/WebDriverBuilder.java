package selenium.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;

public class WebDriverBuilder {

	private String name;
	private final WebDriverConfig webDriverConfig;
	private String userAgent;
	private boolean disableCookies;
	private final static Logger log = Logger.getLogger(WebDriverBuilder.class);
	// private String ipServer = "10.199.6.15:4444";
	private static String ipServer = "localhost:4444";

	private static WebDriver driver; // webdriver que vai ser usado nos testes

	static DesiredCapabilities capability;

	public WebDriverBuilder(WebDriverConfig webDriverConfig) {
		this.webDriverConfig = webDriverConfig;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void disableCookies(boolean cookies) {
		this.disableCookies = cookies;
	}

	public static WebDriver getDriver() throws Exception {
		if(driver==null)
			throw new Exception("Browser was not chosen");
		return driver;
	}

	public static WebDriver toWebDriver(int browser) throws Exception {
		// String driverpath = webDriverConfig.getDriverPath();// caminho do webdriver
		String separator = File.separator;// Separador de arquivo do SistemaOperacional
		String downloadDirectory = new File(
				"src" + separator + "test" + separator + "resources" + separator + "downloads").getAbsolutePath();
		// String browser = webDriverConfig.getBrowserName();// nome do browser
		switch (browser) {
		case 1:// escolhendo o firefox

//			capability = DesiredCapabilities.firefox();
//			FirefoxOptions optionsF = new FirefoxOptions(); // optionsF.addArguments("--headless");
//			optionsF.addArguments("--start-maximized");
//			optionsF.addArguments("--window-size=1920,1080");
//			optionsF.addArguments("--headless");
//			
//			String separator = File.separator;// Separador de arquivo do Sistema Operacional
//			String downloadDirectory = new File(
//					"src" + separator + "test" + separator + "resources" + separator + "downloads").getAbsolutePath();
//			downloadDirectory = downloadDirectory + separator;
//			System.out.println("separator " + separator);
//			System.out.println("caminho - " + downloadDirectory);
//			optionsF.addArguments("profile.default_content_settings.popups", "0");
//			optionsF.addArguments("download.default_directory", downloadDirectory);
//			
//			capability = DesiredCapabilities.firefox();
//			capability.setCapability("marionette", true);
//			optionsF.merge(capability);
//			driver = new RemoteWebDriver(new URL("http://" + ipServer + "/wd/hub"), optionsF);
//			setDriver(driver);
//			log.info("Firefox was chosen");
//			
			try {
				FirefoxOptions optionsF = new FirefoxOptions();
				optionsF.addArguments("--s tart-maximized");
			  //optionsF.addArguments("--headless");

				optionsF.addArguments("--start-maximized");
				optionsF.addArguments("use-fake-ui-for-media-stream");
				optionsF.addArguments("--window-size=1920,1080");

				optionsF.addPreference("profile.default_content_settings.popups", 0);
				optionsF.addPreference("browser.download.folderList",2);
				optionsF.addPreference("browser.download.manager.showWhenStarting",false);
				optionsF.addPreference("browser.download.dir", downloadDirectory);
				optionsF.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
				optionsF.merge(capability);

				capability = DesiredCapabilities.firefox();
				capability.setCapability("marionette", true);
				optionsF.merge(capability);
				driver = new RemoteWebDriver(new URL("http://" + ipServer + "/wd/hub"), optionsF);
				log.info("Firefox was chosen");
				return driver;
			} catch (Exception e) {
				log.error("It was not possible to execute Firefox");
				log.error(e.getMessage());
			}
//			FirefoxDriverManager.firefoxdriver().config().setTargetPath(driverpath);
//			FirefoxDriverManager.firefoxdriver().setup();
//			FirefoxDriver firefoxDriver = new FirefoxDriver();
//			firefoxDriver.manage().window().maximize();
//			setDriver(firefoxDriver);
//			log.info("Firefox was chosen");
//			return firefoxDriver;
			

		case 2:// escolhendo o chrome
			try {
				ChromeOptions optionsC = new ChromeOptions();
				// optionsC.addArguments("--headless");
				optionsC.addArguments("--start-maximized");
				optionsC.addArguments("use-fake-ui-for-media-stream");
				//optionsC.addArguments("--window-size=1920,1080");

				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", downloadDirectory);
				//chromePrefs.put("version","73");
				optionsC.setExperimentalOption("prefs", chromePrefs);
				optionsC.merge(capability);
				capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
			//	capability.setVersion("73");
				capability.setCapability(ChromeOptions.CAPABILITY, optionsC);
				driver = new RemoteWebDriver(new URL("http://" + ipServer + "/wd/hub"), capability);
				log.info("Chrome was chosen");
				return driver;
			} catch (Exception e) {
				log.error("It was not possible to execute Chrome");
				log.error(e.getMessage());
				throw e;
			}
//			ChromeOptions optionsC = new ChromeOptions();
//			// optionsC.addArguments("--headless");
//			optionsC.addArguments("--start-maximized");
//			optionsC.addArguments("use-fake-ui-for-media-stream");
//			optionsC.addArguments("--window-size=1920,1080");
//
//			separator = File.separator;// Separador de arquivo do Sistema Operacional
//			downloadDirectory = new File(
//					"src" + separator + "test" + separator + "resources" + separator + "downloads").getAbsolutePath();
//
//			downloadDirectory = downloadDirectory + separator;
//			System.out.println("separator " + separator);
//			System.out.println("caminho - " + downloadDirectory);
//			optionsC.addArguments("profile.default_content_settings.popups", "0");
//			optionsC.addArguments("download.default_directory", downloadDirectory);
//			// capability = DesiredCapabilities.chrome();
//			// capability.setBrowserName("chrome");
//			// capability.setCapability(ChromeOptions.CAPABILITY, optionsC);
//
//			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//			chromePrefs.put("profile.default_content_settings.popups", 0);
//			chromePrefs.put("download.default_directory", downloadDirectory);
//			ChromeOptions options = new ChromeOptions();
//			options.setExperimentalOption("prefs", chromePrefs);
//
//			ChromeDriverManager.chromedriver().version("73");
//			ChromeDriverManager.chromedriver().config().setTargetPath(driverpath);// caminho do driver
//			ChromeDriverManager.chromedriver().setup();
//			final ChromeDriver driver = new ChromeDriver(options);
//			// Dimension targetSize=new Dimension(700,700);
//			// chromeDriver.manage().window().setSize(targetSize);
//			driver.manage().window().maximize(); // maximiza o browser
//			// return chromeDriver; //retorna o driver
//			setDriver(driver);
//			log.info("Chrome was chosen");
//			return driver;
		case 3:
			try {
				capability = DesiredCapabilities.internetExplorer();
				capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capability.setJavascriptEnabled(true);
				capability.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				capability.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
				capability.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver = new RemoteWebDriver(new URL("http://" + ipServer + "/wd/hub"), capability);
				log.info("Intenet Explorer was chosen");
				return driver;
			} catch (Exception e) {
				log.error("It was not possible to execute Internet explorer");
				log.error(e.getMessage());
				throw e;
			}
		default:
			try {
				ChromeOptions optionsC = new ChromeOptions();
				// optionsC.addArguments("--headless");
				optionsC.addArguments("--start-maximized");
				optionsC.addArguments("use-fake-ui-for-media-stream");
				optionsC.addArguments("--window-size=1920,1080");

				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", downloadDirectory);
				optionsC.setExperimentalOption("prefs", chromePrefs);
				optionsC.merge(capability);

				capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
				capability.setCapability(ChromeOptions.CAPABILITY, optionsC);
				driver = new RemoteWebDriver(new URL("http://" + ipServer + "/wd/hub"), capability);
				log.info("Chrome was chosen");
				return driver;
			} catch (Exception e) {
				log.error("It was not possible to execute Chrome");
				log.error(e.getMessage());
				throw e;
			}
		}
	//	log.error("It was not possible to execute any browser");
	//	throw new Exception("It was not possible to execute any browser");
	}

	public static void setDriver(WebDriver driver) {
		WebDriverBuilder.driver = driver;
	}

	/*
	 * public WebDriver toWebDriver() { // DesiredCapabilitiesFactory
	 * desiredCapabilitiesFactory = new DesiredCapabilitiesFactory();
	 * //DesiredCapabilities capabilities =
	 * desiredCapabilitiesFactory.initDesiredCapabilities(webDriverConfig, //
	 * userAgent, disableCookies); String browser =
	 * webDriverConfig.getBrowserName();//nome do browser String
	 * driverpath=webDriverConfig.getDriverPath();//caminho do webdriver
	 * 
	 * log.info(""+browser+" was chosen to run the test"); switch (browser) { case
	 * "chrome"://escolhendo o chrome
	 * ChromeDriverManager.chromedriver().version("73");
	 * ChromeDriverManager.chromedriver().config().setTargetPath(driverpath);//
	 * caminho do driver ChromeDriverManager.chromedriver().setup(); final
	 * ChromeDriver chromeDriver = new ChromeDriver(); //Dimension targetSize=new
	 * Dimension(700,700); //chromeDriver.manage().window().setSize(targetSize);
	 * chromeDriver.manage().window().maximize(); //maximiza o browser return
	 * chromeDriver; //retorna o driver case "edge": // escolhendo o edge
	 * EdgeDriverManager.edgedriver().setup(); final EdgeDriver edgeDriver = new
	 * EdgeDriver(); edgeDriver.manage().window().maximize(); return edgeDriver;
	 * case "internetexplorer":// escolhendo o ie
	 * InternetExplorerDriverManager.iedriver().setup(); final
	 * InternetExplorerDriver internetExplorerDriver = new InternetExplorerDriver();
	 * internetExplorerDriver.manage().window().maximize(); return
	 * internetExplorerDriver; case "opera": //escolhendo o ópera
	 * OperaDriverManager.operadriver().setup(); final OperaDriver operaDriver = new
	 * OperaDriver(); operaDriver.manage().window().maximize(); return operaDriver;
	 * default://Firefox
	 * FirefoxDriverManager.firefoxdriver().config().setTargetPath(driverpath);
	 * FirefoxDriverManager.firefoxdriver().setup(); FirefoxDriver firefoxDriver =
	 * new FirefoxDriver(); firefoxDriver.manage().window().maximize(); return
	 * firefoxDriver; } }
	 */

}
