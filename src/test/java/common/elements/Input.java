package common.elements;

import org.openqa.selenium.WebElement;

public class Input extends AbstractElement {

	public Input(WebElement el) {
		super(el);
	}

	public Input fillUp(String value) {
		super.scrollIntoView();
		webElement.clear();
		webElement.sendKeys(value);
		return this;
	}

	public Input fillUp(int value) {
		return fillUp(String.valueOf(value));
	}

	public Object GetValue() {
		String text = this.webElement.getAttribute("value").replaceAll("[^\\d.]", "");
		return text == "" ? webElement.getText() : text;
	}

	@Override
	public void click() {
		webElement.click();
	}
}
