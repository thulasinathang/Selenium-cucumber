package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Common {

	private WebDriver driver;

	public void invokebrowser(String browser, String url) {

		String fs = System.getProperty("file.separator");
		String curdir = System.getProperty("user.dir");
		String path = curdir + fs + "drivers" + fs;

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", path + "chromedriver");
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", path + "geckodriver");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", path + "msedgedriver");
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("safari")) {

			driver = new SafariDriver();
		} else if (browser.equalsIgnoreCase("headless")) {
			System.setProperty("webdriver.chrome.driver", path + "chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
		} else {
			System.out.println("Valid browser was not provided");
			System.exit(0);
		}
		driver.manage().window().maximize();
		if (url != "") {
			driver.get(url);
		} else {
			driver.get("about:blank");
		}

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void closeTab() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
