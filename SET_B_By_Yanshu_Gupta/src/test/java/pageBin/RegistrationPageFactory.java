package pageBin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPageFactory {
	// Chrome Web driver
	WebDriver driver;

	// first name field deal with this object
	@FindBy(xpath = "//*[@id=\"txtFirstName\"]")
	private WebElement firstName;

	// last name field deal with this object
	@FindBy(xpath = "//*[@id=\"txtLastName\"]")
	private WebElement lastName;

	// email field deal with this object
	@FindBy(xpath = "//*[@id=\"txtEmail\"]")
	private WebElement email;

	// contact number deal with this object
	@FindBy(xpath = "//*[@id=\"txtPhone\"]")
	private WebElement contactNo;

	// Number of person field deal with this object
	@FindBy(xpath = "/html/body/form/table/tbody/tr[5]/td[2]/select")
	private WebElement noOfPerson;

	// address field deal with this object
	@FindBy(xpath = "//*[@id=\"txtAddress1\"]")
	private WebElement buildingAndRoomNo;

	// are name field deal with this object
	@FindBy(how = How.ID, id = "txtAddress2")
	private WebElement areaName;

	// city name field deal with this object
	@FindBy(how = How.NAME, name = "city")
	private WebElement city;

	// state name field deal with this object
	@FindBy(how = How.NAME, name = "state")
	private WebElement state;

	// member field deal with this object
	@FindBy(how = How.NAME, name = "memberStatus")
	private List<WebElement> memberStatus;

	// next button deal with this object
	@FindBy(how = How.LINK_TEXT, linkText = "Next")
	private WebElement nextLink;

	// constructor
	public RegistrationPageFactory(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// handling Button events
	public void clickNextPageLink() {
		nextLink.click();
	}

	public String getMemberStatus() {
		for (WebElement webElement : memberStatus)
			if (webElement.isSelected())
				return webElement.getAttribute("value");
		return null;
	}

	public void setMemberStatus(String memberStatus) {
		if (memberStatus.equals("member"))
			this.memberStatus.get(0).click();
		else if (memberStatus.equals("non-member"))
			this.memberStatus.get(1).click();
	}

	public String getState() {
		return new Select(this.state).getFirstSelectedOption().getText();
	}

	public void setState(String state) {
		new Select(this.state).selectByVisibleText(state);
	}

	public String getCity() {
		return new Select(this.city).getFirstSelectedOption().getText();
	}

	public void setCity(String city) {
		new Select(this.city).selectByVisibleText(city);
	}

	public String getAreaName() {
		return areaName.getAttribute("value");
	}

	public void setAreaName(String areaName) {
		this.areaName.sendKeys(areaName);
	}

	public String getBuildingAndRoomNo() {
		return this.buildingAndRoomNo.getAttribute("value");
	}

	public void setBuildingAndRoomNo(String buildingAndRoomNo) {
		this.buildingAndRoomNo.sendKeys(buildingAndRoomNo);
	}

	public int getNoOfPerson() {
		return Integer.parseInt(new Select(noOfPerson).getFirstSelectedOption().getText());
	}

	public void setNoOfPerson(String noOfPerson) {
		new Select(this.noOfPerson).selectByVisibleText(noOfPerson);
	}

	public String getContactNo() {
		return contactNo.getAttribute("value");
	}

	public void setContactNo(String contactNo) {
		this.contactNo.clear();
		this.contactNo.sendKeys(contactNo);
	}

	public String getEmail() {
		return email.getAttribute("value");
	}

	public void setEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	public String getFirstName() {
		return firstName.getAttribute("value");
	}

	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}

	public String getLastName() {
		return lastName.getAttribute("value");
	}

	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
}
