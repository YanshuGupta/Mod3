package com.cg.payment;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageBin.PaymentPageFactory;

public class PaymentStepDef {

	// Web driver object for handling operation
	private WebDriver driver;

	// Bean File for Web Elements
	PaymentPageFactory factory;

	// This Method is Used to open web Page
	@Given("^User is on Payment page$")
	public void user_is_on_Payment_page() throws Throwable {
		// for finding the local path of project inside eclips
		String projectLocation = System.getProperty("user.dir");
		// setting up the system properties
		System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\chromedriver.exe");
		// instantiate the chrome driver
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Instantiate loacal Bean Class
		factory = new PaymentPageFactory(driver);
		driver.get(projectLocation + "\\webPages\\PaymentDetails.html");
	}

	// This Method is used to check the title of web page
	@Then("^The Title of the page must be \"([^\"]*)\"$")
	public void the_Title_of_the_page_must_be(String arg1) throws Throwable {
		// checking the title of opened web page
		assertEquals(driver.getTitle(), arg1);
	}

	// this page for inserting information
	@When("^User Click 'Make Payment' without entering 'Card holder name'$")
	public void user_Click_Make_Payment_without_entering_Card_holder_name() throws Throwable {
		// click on the payment button
		factory.setMakePayment();
	}

	// This method is for handling the alerts
	@Then("^'Please fill the Card holder name' message must be display$")
	public void please_fill_the_Card_holder_name_message_must_be_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please fill the Card holder name";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
	}

	// This method is for sending information
	@When("^User Click 'Make Payment' button without entering 'Debit card Number'$")
	public void user_Click_Make_Payment_button_without_entering_Debit_card_Number() throws Throwable {
		factory.setCardHolderName("AAAAAAAA");
		factory.setMakePayment();
	}

	// This method is for handling the alerts
	@Then("^'Please fill the Debit card Number' message must be display$")
	public void please_fill_the_Debit_card_Number_message_must_be_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please fill the Debit card Number";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
	}

	// This method is for sending information
	@When("^User Click 'Make Payment' button without entering 'Please fill the CVV Number'$")
	public void user_Click_Make_Payment_button_without_entering_Please_fill_the_CVV_Number() throws Throwable {
		factory.setCardNumber("1234567891234567");
		factory.setMakePayment();
	}

	// This method is for handling the alerts
	@Then("^'Please fill the CVV' message must be display$")
	public void please_fill_the_CVV_message_must_be_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please fill the CVV";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
	}

	// This method is for sending information
	@When("^User Click 'Make Payment' button without entering 'Expiration month'$")
	public void user_Click_Make_Payment_button_without_entering_Expiration_month() throws Throwable {
		factory.setCvv("123");
		factory.setMakePayment();
	}

	// This method is for handling the alerts
	@Then("^'Please fill expiration month' message must be display$")
	public void please_fill_expiration_month_message_must_be_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please fill expiration month";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
	}

	// This method is for sending information
	@When("^User Click 'Make Payment' button without entering 'Expiration year'$")
	public void user_Click_Make_Payment_button_without_entering_Expiration_year() throws Throwable {
		factory.setExpirationMonth("11");
		factory.setMakePayment();
	}

	// This method is for handling the alerts
	@Then("^'Please fill the expiration year' message must be display$")
	public void please_fill_the_expiration_year_message_must_be_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please fill the expiration year";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
		driver.close();
	}

	// This method is for sending information
	@When("^User Click 'Make Payment' button after entering valid 'payment details'$")
	public void user_Click_Make_Payment_button_after_entering_valid_payment_details() throws Throwable {
		factory.setCardHolderName("AAAAAAAA");
		factory.setCardNumber("1234567891234567");
		factory.setCvv("123");
		factory.setExpirationMonth("11");
		factory.setExpirationYear("2024");
		factory.setMakePayment();
	}

	// This method is for handling the alerts
	@Then("^'Conference Room Booking successfully done!!!' message should display$")
	public void conference_Room_Booking_successfully_done_message_should_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Conference Room Booking successfully done!!!";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(1000);
		alert.accept();
		Thread.sleep(1000);
		driver.close();
	}

}
