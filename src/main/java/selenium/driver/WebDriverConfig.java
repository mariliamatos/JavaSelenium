package selenium.driver;

import selenium.configurations.TypedProperties;

public class WebDriverConfig {

	private final TypedProperties typedProperties = new TypedProperties("/configfiles/driver_config.properties");

	String getBrowserName() {

		return typedProperties.getValue("browser.name");
	}

	String getDriverPath() {

		return typedProperties.getValue("driver.path");
	}

	int getImplicitlyWait() {
		return typedProperties.getInt("implicitly_wait");
	}

	int getDomMaxScriptRunTime() {
		return typedProperties.getInt("dom.max_script_run_time");
	}

}
