package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public WebDriver driver;
	public static Properties prop;
	public ChromeOptions co;
	public EdgeOptions eo;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * This method is used to initialize the WebDriver on the basis of browserName
	 * @param browserName
	 * @return this method will return driver instance
	 */
	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");
		System.out.println("Running on ----> " + browserName + " browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(getChromeOptions()));
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver(getEdgeOptions()));
		} else {
			System.out.println(browserName + " is not found, please pass the right browser Name");
		}
		getEnvironmentDetails();
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	/**
	 * 
	 * @return this method returns properties - prop available in
	 *         config.proerties file
	 */
	public Properties init_prop() {
		prop = new Properties();
		String path = System.getProperty("user.dir")+ "\\src\\test\\resources\\Config\\config.properties";
		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("config file is not found.....");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public ChromeOptions getChromeOptions(){
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) 
			co.addArguments("--incognito");
		if(Boolean.parseBoolean(prop.getProperty("headless")))
			co.addArguments("--headless");
		return co;
	}

	public EdgeOptions getEdgeOptions(){
		eo = new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) 
			eo.addArguments("--headless");
		return eo;
	}

	public static void getEnvironmentDetails() {
		Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
		String browserName = cap.getBrowserName();
		String platform = cap.getPlatformName().toString();
		String browserVersion = cap.getBrowserVersion();
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("OS= " + os + ", Browser = " + browserName + " " + browserVersion);
	}
}
