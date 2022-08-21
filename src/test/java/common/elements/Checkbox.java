package common.elements;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.DriverFactory;

public class Checkbox extends AbstractElement {

	public Checkbox(WebElement el) {
		super(el);
	}

	@Override
	public void click() {
		this.scrollIntoView();
		new WebDriverWait(DriverFactory.GetDriver(), Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click();
	}

}
