package common.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import common.DriverFactory;

public abstract class AbstractElement extends RemoteWebElement {

	protected WebElement webElement;

	public AbstractElement(WebElement el) {
		webElement = el;
	}

	public AbstractElement scrollIntoView() {
		WebDriver webDriver = DriverFactory.GetDriver();
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("arguments[0].scrollIntoView();", webElement);
		try {
			Thread.sleep(100); // без задержки скролл не отрабатывает корректно
		} catch (InterruptedException e) {
			//ignored
		}
		return this;
	}

}
