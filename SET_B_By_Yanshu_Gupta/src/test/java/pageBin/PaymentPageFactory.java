package pageBin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPageFactory {
	// chrome driver object
	WebDriver driver;

	// card holder name deal with this object
	@FindBy(xpath = "//*[@id=\"txtCardholderName\"]")
	WebElement cardHolderName;

	// card Number deal with this object
	@FindBy(xpath = "//*[@id=\"txtDebit\"]")
	WebElement cardNumber;

	// card cvv Number deal with this object
	@FindBy(xpath = "//*[@id=\"txtCvv\"]")
	WebElement cvv;

	// card expiration month deal with this object
	@FindBy(xpath = "//*[@id=\"txtMonth\"]")
	WebElement expirationMonth;

	// card expiration year deal with this object
	@FindBy(xpath = "//*[@id=\"txtYear\"]")
	WebElement expirationYear;

	// make payment button deal with this object
	@FindBy(xpath = "//*[@id=\"btnPayment\"]")
	WebElement makePayment;

	// Constructor for initialization all variable
	public PaymentPageFactory(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Appropriate Getter and setters
	public String getCardHolderName() {
		return cardHolderName.getText();
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName.sendKeys(cardHolderName);
		;
	}

	public String getCardNumber() {
		return cardNumber.getText();
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber.sendKeys(cardNumber);
	}

	public String getCvv() {
		return cvv.getText();
	}

	public void setCvv(String cvv) {
		this.cvv.sendKeys(cvv);
	}

	public String getExpirationMonth() {
		return expirationMonth.getText();
	}

	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth.sendKeys(expirationMonth);
		;
	}

	public String getExpirationYear() {
		return expirationYear.getText();
	}

	public void setExpirationYear(String expirationYear) {
		this.expirationYear.sendKeys(expirationYear);
	}

	public void setMakePayment() {
		makePayment.click();
	}

}
