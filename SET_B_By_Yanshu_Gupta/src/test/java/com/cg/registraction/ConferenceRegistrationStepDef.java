package com.cg.registraction;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageBin.RegistrationPageFactory;

public class ConferenceRegistrationStepDef {

	// Web driver object for handling operation
	private WebDriver driver;

	// Bean File for Web Elements
	private RegistrationPageFactory factory;

	@Given("^User is on Conference room booking page$")
	public void user_is_on_Conference_room_booking_page() throws Throwable {
		// for finding the local path of project inside eclips
		String projectLocation = System.getProperty("user.dir");
		// setting up the system properties
		System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\chromedriver.exe");
		// instantiate the chrome driver
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Instantiate loacal Bean Class
		factory = new RegistrationPageFactory(driver);
		driver.get(projectLocation + "\\webPages\\ConferenceRegistartion.html");
	}

	// This Method is used to check the title of web page
	@Then("^The Title of the Page must be \"([^\"]*)\"$")
	public void the_Title_of_the_Page_must_be(String arg1) throws Throwable {
		// checking the title of opened web page
		assertEquals(driver.getTitle(), arg1);
	}

	@When("^User select 'Next' link without entering 'FirstName'$")
	public void user_select_Next_link_without_entering_FirstName() throws Throwable {
		// clicking on next link button
		factory.clickNextPageLink();
	}

	// handling the appropriate alerts
	@Then("^'Please fill the First Name' message should display$")
	public void please_fill_the_First_Name_message_should_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please fill the First Name";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
	}

	@When("^User select 'Next' link without entering 'LastName'$")
	public void user_select_Next_link_without_entering_LastName() throws Throwable {
		factory.setFirstName("ABCDEF");
		factory.clickNextPageLink();
	}

	// handling the appropriate alerts
	@Then("^'Please fill the Last Name' message should display$")
	public void please_fill_the_Last_Name_message_should_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please fill the Last Name";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
	}

	@When("^User select 'Next' link without entering 'Email'$")
	public void user_select_Next_link_without_entering_Email() throws Throwable {
		factory.setLastName("UVWXYZ");
		factory.clickNextPageLink();
	}

	// handling the appropriate alerts
	@Then("^'Please fill the Email' message should display$")
	public void please_fill_the_Email_message_should_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please fill the Email";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
	}

	@When("^User select 'Next' link after entering invalid 'Email' address$")
	public void user_select_Next_link_after_entering_invalid_Email_address() throws Throwable {
		factory.setEmail("abc.xyz-capgemini.com");
		factory.clickNextPageLink();
	}

	// handling the appropriate alerts
	@Then("^'Please enter valid Email Id\\.' message should display$")
	public void please_enter_valid_Email_Id_message_should_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please enter valid Email Id.";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
	}

	@When("^User select 'Next' link without entering 'Contact No'$")
	public void user_select_Next_link_without_entering_Contact_No() throws Throwable {
		factory.setEmail("abc.xyz@capgemini.com");
		factory.clickNextPageLink();
	}

	// handling the appropriate alerts
	@Then("^'Please fill the Contact No\\.' message should display$")
	public void please_fill_the_Contact_No_message_should_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please fill the Contact No.";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
	}

	@When("^User select 'Next' link after entering invalid 'Contact No'$")
	public void user_select_Next_link_after_entering_invalid_Contact_No() throws Throwable {
		factory.setContactNo("5555");
		factory.clickNextPageLink();
	}

	// handling the appropriate alerts
	@Then("^'Please enter valid Contact no\\.' message should display$")
	public void please_enter_valid_Contact_no_message_should_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please enter valid Contact no.";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
	}

	@When("^User select 'Next' link without selecting  'Number of people attending'$")
	public void user_select_Next_link_without_selecting_Number_of_people_attending() throws Throwable {
		factory.setContactNo("9999999999");
		factory.clickNextPageLink();
	}

	// handling the appropriate alerts
	@Then("^'Please fill the Number of people attending' message should display$")
	public void please_fill_the_Number_of_people_attending_message_should_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please fill the Number of people attending";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
	}

	@When("^User select 'Next' link without entereing  'Building Name & Room No'$")
	public void user_select_Next_link_without_entereing_Building_Name_Room_No() throws Throwable {
		factory.setNoOfPerson("3");
		factory.clickNextPageLink();
	}

	// handling the appropriate alerts
	@Then("^'Please fill the Building & Room No' message should display$")
	public void please_fill_the_Building_Room_No_message_should_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please fill the Building & Room No";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
	}

	@When("^User select 'Next' link without entereing  'Area Name'$")
	public void user_select_Next_link_without_entereing_Area_Name() throws Throwable {
		factory.setBuildingAndRoomNo("Technology park Unit-2 Talwade");
		factory.clickNextPageLink();
	}

	// handling the appropriate alerts
	@Then("^'Please fill the Area name' message should display$")
	public void please_fill_the_Area_name_message_should_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please fill the Area name";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
	}

	@When("^User select 'Next' link without selecting  'City'$")
	public void user_select_Next_link_without_selecting_City() throws Throwable {
		factory.setAreaName("Talwade");
		factory.clickNextPageLink();
	}

	// handling the appropriate alerts
	@Then("^'Please select city' message should display$")
	public void please_select_city_message_should_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please select city";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
	}

	@When("^User select 'Next' link without selecting  'State'$")
	public void user_select_Next_link_without_selecting_State() throws Throwable {
		factory.setCity("Pune");
		factory.clickNextPageLink();
	}

	// handling the appropriate alerts
	@Then("^'Please select state' message should display$")
	public void please_select_state_message_should_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please select state";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
	}

	@When("^User select 'Next' link without selecting  'MemberShip Status '$")
	public void user_select_Next_link_without_selecting_MemberShip_Status() throws Throwable {
		factory.setState("Maharashtra");
		factory.clickNextPageLink();
	}

	// handling the appropriate alerts
	@Then("^'Please Select MemeberShip status' message should display$")
	public void please_Select_MemeberShip_status_message_should_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Please Select MemeberShip status";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
		alert.accept();
		driver.close();
	}

	// Sending Inforamtion to web page
	@When("^User select 'Next' link after entering Valid set of information$")
	public void user_select_Next_link_after_entering_Valid_set_of_information() throws Throwable {
		// Sending all information
		factory.setFirstName("ABCDEF");
		factory.setLastName("UVWXYZ");
		factory.setEmail("abc.xyz@capgemini.com");
		factory.setContactNo("9999999999");
		factory.setNoOfPerson("3");
		factory.setBuildingAndRoomNo("Technology park Unit-2 Talwade");
		factory.setAreaName("Talwade");
		factory.setCity("Pune");
		factory.setState("Maharashtra");
		factory.setMemberStatus("member");
		// click on next button
		factory.clickNextPageLink();
		
	}

	// handling the appropriate alerts
	@Then("^'Personal details are validated\\.' message should display$")
	public void personal_details_are_validated_message_should_display() throws Throwable {
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		String expectedMessage = "Personal details are validated.";
		assertEquals(expectedMessage, actualMessage);
		Thread.sleep(1000);
		alert.accept();
		Thread.sleep(1000);
		driver.close();
	}
}
