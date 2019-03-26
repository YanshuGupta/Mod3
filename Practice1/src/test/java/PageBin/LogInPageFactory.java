package PageBin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPageFactory {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"mainCnt\"]/div/div[1]/form/table/tbody/tr[2]/td[2]/input")
	WebElement userName;
	
	@FindBy(xpath="//*[@id=\"mainCnt\"]/div/div[1]/form/table/tbody/tr[3]/td[2]/input")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"userErrMsg\"]")
	WebElement userNameError;
	
	@FindBy(xpath="//*[@id=\"pwdErrMsg\"]")
	WebElement passwordError;
	
	@FindBy(xpath="//*[@id=\"mainCnt\"]/div/div[1]/form/table/tbody/tr[4]/td[2]/input")
	WebElement submitButton;
	
	public LogInPageFactory(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName.sendKeys(userName);
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public String getUserNameError() {
		return userNameError.getText();
	}

	public String getPasswordError() {
		return passwordError.getText();
	}

	public void setSubmitButton() {
		submitButton.click();
	}
	
	
}
