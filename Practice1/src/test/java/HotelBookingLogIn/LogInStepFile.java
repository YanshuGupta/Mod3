package HotelBookingLogIn;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageBin.LogInPageFactory;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogInStepFile {
	WebDriver driver;
	LogInPageFactory factory;
	@Given("^User open the login page$")
	public void user_open_the_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\YANGUPTA\\Downloads\\JARS\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		factory = new LogInPageFactory(driver);
		driver.get("C:\\Users\\YANGUPTA\\Downloads\\Shubham_Mod3-master/login.html");
	}

	@Then("^Title must be as \"([^\"]*)\"$")
	public void title_must_be_as(String arg1) throws Throwable {
		String title = driver.getTitle();
		assertEquals(title, arg1);
	}

	@When("^User Enter Wrong credential User Name as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_Enter_Wrong_credential_User_Name_as_and_Password_as(String arg1, String arg2) throws Throwable {
		factory.setUserName(arg1);
		factory.setPassword(arg2);
		factory.setSubmitButton();
	}

	@Then("^a alert is generated with message as \"([^\"]*)\"$")
	public void a_alert_is_generated_with_message_as(String arg1) throws Throwable {
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		assertEquals(arg1, alertMsg);
		Thread.sleep(500);
		alert.accept();
	}

	@Then("^a error is generated with message as \"([^\"]*)\"$")
	public void a_error_is_generated_with_message_as(String arg1) throws Throwable {
		String errorMessage = factory.getUserNameError();
		System.err.println(errorMessage+"ABBABAB");
		if(errorMessage == null || errorMessage == "" || errorMessage.length()==0) {
			errorMessage = factory.getPasswordError();
			System.err.println(errorMessage+"ABBABAB");
		}
		assertEquals(errorMessage, arg1);
	}

	@When("^User Enter Valid credential User Name as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_Enter_Valid_credential_User_Name_as_and_Password_as(String arg1, String arg2) throws Throwable {
		factory.setUserName(arg1);
		factory.setPassword(arg2);
		factory.setSubmitButton();
	}
}
