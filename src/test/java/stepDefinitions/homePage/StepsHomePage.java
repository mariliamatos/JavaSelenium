package stepDefinitions.homePage;

import static selenium.utils.annotations.browser.Browsers.INTERNET_EXPLORER;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.channels.FileChannel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import selenium.SeleniumTestWrapper;
import selenium.interactions.HomeInteraction;
import selenium.interactions.SegmentationInteraction;
import selenium.utils.annotations.browser.Browser;
import selenium.utils.annotations.browser.BrowserDimension;

import selenium.utils.browser.Screen;
import utils.DateTimeHelper;
import utils.MailHelper;
import utils.database.UserDataBase;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@BrowserDimension(Screen.XLARGE)
@Browser(skip = { INTERNET_EXPLORER })
public class StepsHomePage {

	Scenario sc;
	Logger log = Logger.getLogger(StepsHomePage.class); // Classse de Log
	String browserName = "";
	HomeInteraction homeInteraction;// Classe responsável
									// pelos steps de
									// entrada na home
									// page do sistema

	String pathLogFinal = "";

	@Before("@Chrome")
	public void initiTestingChrome(Scenario s) throws Exception {
		this.sc = s;
		// BrowserDimension testea =
		// this.getClass().getAnnotation(BrowserDimension.class);
		// testea.value();
		browserName = "Chrome";
		logConfiguration("Chrome");
		log.info("Scenario  " + s.getName() + " has started"); // filling the log
		SeleniumTestWrapper.getDriver(2);
		if(s.getName().length()>38)
		{
			log.info("The name of the scenario is too bigger! It has more than 36 characteres");
			throw new Exception("The name of the scenario is too bigger! It has more than 36 characteres"); 
		}
//		homeInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), HomeInteraction.class);
//		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
//		registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
//		homeInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), HomeInteraction.class);
//		segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), SegmentationInteraction.class);
//		segmentatioPFInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
//				SegmentationPessoaFisicaInteraction.class);
//		segmentatioPJInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
//				SegmentationPessoaJuridicaInteraction.class);
//		createListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), CreateListInteraction.class);
//		enrichListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), EnrichistInteraction.class);
//		// UserDataBase userDb = new UserDataBase(); //updating password number of
		// tentatives
		// userDb.updatePasswordTentative();
		// userDb.updateUserStatus();

		log.info("Scenario  " + s.getName() + " is running on Chrome"); // filling the log
		
		
	}

	@Before("@Firefox")
	public void initiTestingFirefox(Scenario s) throws Exception {
		/*
		 * this.sc = s; // BrowserDimension testea = //
		 * this.getClass().getAnnotation(BrowserDimension.class); // testea.value();
		 */
		this.sc = s;
		browserName = "Firefox";
		logConfiguration("Firefox");
		log.info("Scenario  " + s.getName() + " has started"); // filling the log
		SeleniumTestWrapper.getDriver(1);
		if(s.getName().length()>38)
		{
			log.info("The name of the scenario is too bigger! It has more than 36 characteres");
			throw new Exception("The name of the scenario is too bigger! It has more than 36 characteres"); 
		}
		// homeInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
		// HomeInteraction.class);
//		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
//		registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
//		homeInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), HomeInteraction.class);
//		segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), SegmentationInteraction.class);
//		segmentatioPFInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
//				SegmentationPessoaFisicaInteraction.class);
//		segmentatioPJInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
//				SegmentationPessoaJuridicaInteraction.class);
//		createListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), CreateListInteraction.class);
//		enrichListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), EnrichistInteraction.class);

		// UserDataBase userDb = new UserDataBase(); //updating password number of
		// tentatives
		// userDb.updatePasswordTentative();
		// userDb.updateUserStatus();

		log.info("Scenario  " + s.getName() + " is running on Firefox"); // filling the log
	}

	@Before("@IE")
	public void initiTestingIntenetExplorer(Scenario s) throws Exception {
		/*
		 * this.sc = s; // BrowserDimension testea = //
		 * this.getClass().getAnnotation(BrowserDimension.class); // testea.value();
		 */

		this.sc = s;
		browserName = "Internet Explorer";
		logConfiguration("Internet_Explorer");
		log.info("Scenario  " + s.getName() + " has started"); // filling the log
		SeleniumTestWrapper.getDriver(3);
		
		if(s.getName().length()>38)
		{
			log.info("The name of the scenario is too bigger! It has more than 36 characteres");
			throw new Exception("The name of the scenario is too bigger! It has more than 36 characteres"); 
		}
		
		// homeInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
		// HomeInteraction.class);
//		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
//		registerInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), RegisterInteraction.class);
//		homeInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), HomeInteraction.class);
//		segmentationInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), SegmentationInteraction.class);
//		segmentatioPFInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
//				SegmentationPessoaFisicaInteraction.class);
//		segmentatioPJInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(),
//				SegmentationPessoaJuridicaInteraction.class);
//		createListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), CreateListInteraction.class);
//		enrichListInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), EnrichistInteraction.class);

		// UserDataBase userDb = new UserDataBase(); //updating password number of
		// tentatives
		// userDb.updatePasswordTentative();
		// userDb.updateUserStatus();
		log.info("Scenario  " + s.getName() + " is running on Internet Explorer"); // filling the log
	}

//	// HomePage
//	@Given("^I open the homepage$") // navigate to homepage
//	public void i_open_the_homepage() throws Throwable {
//		// Step para ir para home
//		homeInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), HomeInteraction.class);
//		homeInteraction.navigateToHomePage();
//		SeleniumTestWrapper.takeScreenshot(sc);
//
//	}

	// HomePage
	@Given("^I open the homepage$") // navigate to homepage
	public void i_open_the_homepage() throws Throwable {
		homeInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), HomeInteraction.class);
		homeInteraction.navigateToHomePage();
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@Given("^I open the IdentityPage$")
	public void i_open_the_IdentityPage() throws Throwable {
		homeInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), HomeInteraction.class);
		homeInteraction.nagivateToIdentityPage();
		SeleniumTestWrapper.takeScreenshot(sc);
	}

	@After
	public void closeBrowser() throws Exception {
		if (SeleniumTestWrapper.getDriver() != null) {
			// Finalizando o cenário
			Thread.sleep(2000);
			log.info("Finishing " + sc.getName() + "");
			String separator = File.separator;
			String[] id= sc.getId().split(";");
			String path = new File("target" + separator + "screenshots" + separator + sc.getName().replace(" ", "_").replace("-", "_")+"_"+id[3])
					.getAbsolutePath();
			File destDir = new File(path);
			System.out.println("teste  = " +path);
			if (!destDir.exists())
				destDir.mkdir();

			if (sc.isFailed()) { // verifica se o cenários não passou
				File destPath = new File(destDir.getAbsolutePath() + System.getProperty("file.separator") + sc.getName().replace(" ", "_").replace("-", "_")+"_"+id[3]
						+ "_error_" + DateTimeHelper.getCurrentDateTime().replace(" ", "_") + ".jpg");

				FileUtils.copyFile(((TakesScreenshot) SeleniumTestWrapper.getDriver()).getScreenshotAs(OutputType.FILE),
						destPath);
//				String pathReport = new File("src" + separator + "test" + separator + "resources" + separator
//						+ "configfiles" + separator + "extent-config.xml").getAbsolutePath();
//				File reportFile = new File(pathReport);
//				Reporter.loadXMLConfig(reportFile);
//				// This attach the specified screenshot to the test
//				Reporter.addScreenCaptureFromPath(destPath.toString());
				log.error(sc.getName() + " did not passed");
			}
			if (!sc.isFailed()) {// cenário passou
				File destPath = new File(destDir.getAbsolutePath() + System.getProperty("file.separator") + sc.getName().replace(" ", "_").replace("-", "_")+"_"+id[3]
						+ "_sucess_" + DateTimeHelper.getCurrentDateTime().replace(" ", "_") + ".jpg");

				FileUtils.copyFile(((TakesScreenshot) SeleniumTestWrapper.getDriver()).getScreenshotAs(OutputType.FILE),
						destPath);
//				String pathReport = new File("src" + separator + "test" + separator + "resources" + separator
//						+ "configfiles" + separator + "extent-config.xml").getAbsolutePath();
//				File reportFile = new File(pathReport);
//				Reporter.loadXMLConfig(reportFile);
//				// This attach the specified screenshot to the test
//				Reporter.addScreenCaptureFromPath(destPath.toString());

				log.info(sc.getName() + " passed");
			}
			FileChannel sourceChannel = null;
			FileChannel destinationChannel = null;
			File destPathCopy = new File(destDir.getAbsolutePath() + separator + sc.getName().replace(" ", "_").replace("-", "_")+"_"+id[3]
					+ DateTimeHelper.getCurrentDateTime().replace("-", "_") + separator);
			if (!destPathCopy.exists())
				destPathCopy.mkdir();
			String path3 = new File("target" + separator + "screenshots" + separator+sc.getName().replace(" ", "_").replace("-", "_")+"_"+id[3]).getAbsolutePath();
			
			File destPathCopy3 = new File(path3);
			if (!destPathCopy3.exists())
				destPathCopy3.mkdir();

			System.out.println("Tamanho diretorio = "+destDir.listFiles().length);
			for (int i = 0; i < destDir.listFiles().length; i++) {
				if (destDir.listFiles()[i].getName().contains("jpg")) {
					try {
						sourceChannel = new FileInputStream(destDir.listFiles()[i]).getChannel();
						File destPathCopy2 = new File(
								destPathCopy.getAbsolutePath() + separator + destDir.listFiles()[i].getName().replace("-", "_"));
						destinationChannel = new FileOutputStream(destPathCopy2).getChannel();
						sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
						destDir.listFiles()[i].deleteOnExit();
						sourceChannel.close();

						if (destDir.listFiles()[i].getName().contains("sucess")
								|| destDir.listFiles()[i].getName().contains("error")) {
							String pathReport = new File("src" + separator + "test" + separator + "resources"
									+ separator + "configfiles" + separator + "extent-config.xml").getAbsolutePath();
							File reportFile = new File(pathReport);
							Reporter.loadXMLConfig(reportFile);
							// This attach the specified screenshot to the test
							Reporter.addScreenCaptureFromPath(destPathCopy2.getAbsolutePath());
						}

					} catch (Exception e) {
						log.error("It was not possible to copy the files .jpg");
					}
				}
			}
			
			
			
//			List<String> to = new ArrayList<>();
//			to.add("mariliagpm@hotmail.com");
//			String subject = "Log do teste " + sc.getName() + "_" + sc.getStatus();
//			String body = "Segue Log do teste";
//			String attach = pathLogFinal;
//			MailHelper.sendAttachEmail(to, subject, body, attach);
			if (SeleniumTestWrapper.getDriver() != null) {
				SeleniumTestWrapper.closeDriver();// fechando o browser e driver
				log.info("Browser " + browserName + " was closed");
			}

		}
	}

	public void logConfiguration(String browserName) throws Exception {
		try {
			Thread.sleep(2000);
			String separator = File.separator;
			String nameSc = sc.getName().replace(" ", "_");

			String pathLogs = new File("target" + separator + "log" + separator).getAbsolutePath();
			

			File destPathLogs = new File(pathLogs);
			if (!destPathLogs.exists())
				destPathLogs.mkdir();
			String[] id= sc.getId().split(";");
			String pathLogsConf = new File("target" + separator + "log" + separator + "confiFiles" + separator)
					.getAbsolutePath();
			File destPathLogsConf = new File(pathLogsConf);
			if (!destPathLogsConf.exists())
				destPathLogsConf.mkdir();

			String path = new File(pathLogsConf + separator + "log4j_" + nameSc+"_"+  id[3]+ "_"+ browserName +"_"+DateTimeHelper.getCurrentDateTime()+".properties").getAbsolutePath();

			File file = new File(path);
			
			Properties properties = new Properties();

			properties.setProperty("log4j.appender.RFILE.File",
					"target" + separator + "log" + separator + nameSc+ "_" + id[3]+ "_"+ browserName +"_"+DateTimeHelper.getCurrentDateTime()+ ".log");

			pathLogFinal = "target" + separator + "log" + separator + nameSc+ "_" + id[3]+"_" + browserName + ".log";
			
			properties.setProperty("log4j.appender.name", "RFILE");
			properties.setProperty("log4j.appender.RFILE", "org.apache.log4j.RollingFileAppender");
			properties.setProperty("log4j.appender.RFILE.threshold", "INFO");
			properties.setProperty("log4j.appender.RFILE.maxFileSize", "25MB");
			properties.setProperty("log4j.appender.RFILE.maxBackupIndex", "100");
			properties.setProperty("log4j.appender.RFILE.layout", "org.apache.log4j.PatternLayout");
			properties.setProperty("log4j.appender.RFILE.layout.ConversionPattern",
					"%d{yyyy-MM-dd HH:mm:ss} [%-5p] [" + sc.getName() + "]["+id[3]+"][%c{1}] - [%M] %m%n");
			properties.setProperty("log4j.rootLogger", "INFO, RFILE,STDOUT");
			properties.setProperty("log4j.appender.name", "STDOUT");
			properties.setProperty("log4j.appender.STDOUT", "org.apache.log4j.ConsoleAppender");
			properties.setProperty("log4j.appender.STDOUT.Target", "System.out");
			properties.setProperty("log4j.appender.STDOUT.layout", "org.apache.log4j.PatternLayout");
			properties.setProperty("log4j.appender.STDOUT.layout.ConversionPattern",
					"%d{yyyy-MM-dd HH:mm:ss} [%-5p]["+browserName+"][" + sc.getName() + "]["+id[3]+"] [%c{1}] - [%M] %m%n");
			try {
				FileOutputStream fos = new FileOutputStream(file);
				properties.store(fos, "FILE LOG4J PROPERTIES:");
				fos.close();
			} catch (IOException ex) {
				log.error(ex.getMessage());
				ex.printStackTrace();
			}

			PropertyConfigurator.configure(path); // configuring the log of the project

		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
}