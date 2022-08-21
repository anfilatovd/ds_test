package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static WebDriver webDriver;

	private static WebDriver InitWebDriver() {
		if (webDriver == null) {
			webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();
		}
		return webDriver;
	}

	public static WebDriver GetDriver() {
		return InitWebDriver();
	}
	
}
