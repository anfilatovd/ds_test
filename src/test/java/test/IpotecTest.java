package test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import common.DriverFactory;
import model.IpotecOffer;
import model.IpotecParams;
import pages.IpotecCalcPage;

public class IpotecTest {
	public static String ipotecCalcUrl = "https://alfabank.ru/get-money/mortgage/ipotechnyj-kalkulyator/";

	@Test
	//Проверяется корректное формирование ипотечного предложения
	public void CheckIpotecOffer() {
		// Arrange
		WebDriver driver = DriverFactory.GetDriver();
		driver.get(ipotecCalcUrl);
		IpotecCalcPage page = new IpotecCalcPage().waitPageLoad();

		// Act
		page.fillParametrs(5_000_000, 2_000_000, 10);

		// Assert
		IpotecOffer expectedOffer = new IpotecOffer() {
			{
				monthlyPayment = 34_370;
				rate = "6,7%";
				creditSum = 3_000_000;
				creditTerm = 10;
			}
		};
		IpotecOffer actualOffer = page.getIpotecOffer();
		assertEquals(actualOffer, expectedOffer);
	}

	@Test
	//Проверяется корректное поведение при вводе параметров за допустимыми границами
	public void CheckWrongValues() {
		// Arrange
		WebDriver driver = DriverFactory.GetDriver();
		driver.get(ipotecCalcUrl);
		IpotecCalcPage page = new IpotecCalcPage().waitPageLoad();

		// Act
		page.fillParametrs(88_000_000, 87_000_000, 31);
		page.eRegButton.click(); // убираем фокус с инпута

		// Assert
		IpotecParams expectedIpotecParams = new IpotecParams() {
			{
				estateCost = 87_500_000;
				initialFee = 86_900_000;
				creditTerm = 30;
			}
		};
		IpotecParams actualIpotecParams = page.getIpotecParams();
		assertEquals(actualIpotecParams, expectedIpotecParams);
	}

	@AfterClass
	public static void CloseDriver() {
		DriverFactory.GetDriver().close();
	}
}