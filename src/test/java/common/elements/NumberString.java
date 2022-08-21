package common.elements;

import org.openqa.selenium.WebElement;

public class NumberString extends AbstractElement {
	
	public NumberString(WebElement el) {
		super(el);
	}
	
	public int GetValue() {
		String text =  this.webElement.getText().replaceAll("[^\\d.]", "");
		return Integer.parseInt(text);
	}

}
