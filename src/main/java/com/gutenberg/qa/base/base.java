package com.gutenberg.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public static WebDriver driver;
	public Properties prop;

	// Create a new instance of the driver
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();

		// read properties file
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\gutenberg\\qa\\config\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		if (driver == null) {
			String browsername = prop.getProperty("browser");
			if (browsername.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browsername.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browsername.equals("internetExplorer")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}

			// maximize browser window
			driver.manage().window().maximize();

			// apply implicit wait for elements
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return driver;
		} else {
			return driver;
		}
	}
}
