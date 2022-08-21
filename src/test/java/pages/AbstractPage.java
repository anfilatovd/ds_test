package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import common.DriverFactory;
import common.ExtendedFieldDecorator;

public abstract class AbstractPage {

	public AbstractPage() {
		init();
	}
	

	public void init() {
		WebDriver driver = DriverFactory.GetDriver();
		PageFactory.initElements(new ExtendedFieldDecorator(new DefaultElementLocatorFactory(driver)), this);
	}
}
