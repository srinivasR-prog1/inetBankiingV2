package com.inetbanking.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.reporter.ConfigurableReporter;
import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	public static WebDriver driver;
	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		// logger = Logger.getLogger("ebanking");

		Logger logger = Logger.getLogger(ConfigurableReporter.class.getName());
		PropertyConfigurator.configure("log4j.properties");

		br = "chrome";

		if (br.equals("chrome")) {

			// System.setProperty("webdriver.chrome.driver",
			// readConfig.getChromePath());
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {

			// System.setProperty("webdriver.gecko.driver",
			// readConfig.getFirefoxPath());
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		logger.info("URL is opened");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png"));
		System.out.println("Screenshot taken");

	}

}
