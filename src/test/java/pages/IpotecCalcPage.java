package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.DriverFactory;
import common.elements.Checkbox;
import common.elements.Input;
import common.elements.NumberString;
import model.IpotecOffer;
import model.IpotecParams;

public class IpotecCalcPage extends AbstractPage {

	@FindBy(xpath = "//button[span[.='Заполнить заявку']]")
	public WebElement TakeAcceptionButton;

	@FindBy(id = "estateCost")
	public Input estateCostInput;

	@FindBy(id = "initialFee")
	public Input initialFeeInput;

	@FindBy(id = "creditTerm")
	public Input creditTermInput;

	@FindBy(xpath = "//p[@data-test-id='monthly-payment']")
	public NumberString monthlyPaymentElement;

	@FindBy(xpath = "//p[@data-test-id='interest-rate']")
	public WebElement interestRate;

	@FindBy(xpath = "//p[@data-test-id='credit-sum']")
	public NumberString creditSumElement;

	@FindBy(xpath = "//p[@data-test-id='credit-term']")
	public NumberString creditTermElement;
	
	@FindBy(xpath = "//div[@data-test-id='eReg']")
	public Checkbox eRegButton;

	public void fillParametrs(int estateCost, int initialFee, int creditTerm) {
		estateCostInput.fillUp(estateCost);
		initialFeeInput.fillUp(initialFee);
		creditTermInput.fillUp(creditTerm);
	}

	public IpotecOffer getIpotecOffer() {
		return new IpotecOffer() {
			{
				monthlyPayment = (int) monthlyPaymentElement.GetValue();
				rate = interestRate.getText();
				creditSum = (int) creditSumElement.GetValue();
				creditTerm = (int) creditTermElement.GetValue();
			}
		};
	}

	public IpotecParams getIpotecParams() {
		return new IpotecParams() {
			{
				estateCost = Integer.parseInt(estateCostInput.GetValue().toString());
				initialFee = Integer.parseInt(initialFeeInput.GetValue().toString());
				creditTerm = Integer.parseInt(creditTermInput.GetValue().toString());
			}
		};
	}

	public IpotecCalcPage waitPageLoad() {
		new WebDriverWait(DriverFactory.GetDriver(), Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(TakeAcceptionButton));
		return this;
	}


}
