package com.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.base.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenMRSSteps extends BaseClass {
	@Given("User is on OpenMRS login page")
	public void userIsOnOpenMRSLoginPage() {
		launchBrowser();
		loadUrl("https://demo.openmrs.org/openmrs/login.htm");
		maximizeWindow();
		implicitWait(20);

	}

	@When("User enters username {string} and password {string}")
	public void userEntersUsernameAndPassword(String username, String password) {
		WebElement txtUserName = driver.findElement(By.xpath("//input[@id='username']"));
		elementSendKeys(txtUserName, username);

		WebElement txtPassword = driver.findElement(By.xpath("//input[@id='password']"));
		elementSendKeys(txtPassword, password);

	}

	@When("pick any location {string} and click on login button")
	public void pickAnyLocationAndClickOnLoginButton(String location) {

		List<WebElement> optionLocation = driver.findElements(By.xpath("//ul[@id='sessionLocation']//child::li"));
		for (WebElement element : optionLocation) {

			if (element.getText().equals(location)) {
				elementClick(element);
			}

		}

		WebElement btnLogin = driver.findElement(By.id("loginButton"));
		elementClick(btnLogin);
	}

	@Then("User verify dashboard page is displayed or not")
	public void userVerifyDashboardPageIsDisplayedOrNot() {
		WebElement loginMessage = driver.findElement(By.xpath("//h4[contains(text(),'Logged')]"));
		Assert.assertTrue("verify dashboard page is displayed", loginMessage.isDisplayed());
	}

	@When("User click on register patient menu")
	public void userClickOnRegisterPatientMenu() {
		WebElement optRegisterAPatient = driver
				.findElement(By.xpath("//div[@id='apps']//child::a[contains(@href,'register')]"));
		elementClick(optRegisterAPatient);
	}

	@When("User enters details of demo graphics firstname {string}, familyname {string} and select gender {string}")
	public void userEntersDetailsOfDemoGraphicsFirstnameFamilynameAndSelectGender(String firstName, String familyName,
			String gender) {
		WebElement txtGivenName = driver.findElement(By.name("givenName"));
		elementSendKeys(txtGivenName, firstName);

		WebElement txtFamilyName = driver.findElement(By.name("familyName"));
		elementSendKeys(txtFamilyName, familyName);

		WebElement btnNext = driver.findElement(By.xpath("//button[@id='next-button']"));
		elementClick(btnNext);

		WebElement ddnGender = driver.findElement(By.name("gender"));
		selectOptionByText(ddnGender, gender);

		elementClick(btnNext);

	}

	@When("User enters birthdate {string}, select birthmonth {string} and birthyear {string}")
	public void userEntersBirthdateSelectBirthmonthAndBirthyear(String birthDate, String birthMonth, String birthYear) {
		WebElement txtBirthDay = driver.findElement(By.name("birthdateDay"));
		elementSendKeys(txtBirthDay, birthDate);

		WebElement ddnMonth = driver.findElement(By.name("birthdateMonth"));
		selectOptionByText(ddnMonth, birthMonth);

		WebElement txtBirthYear = driver.findElement(By.name("birthdateYear"));
		elementSendKeys(txtBirthYear, birthYear);

		WebElement btnNext = driver.findElement(By.xpath("//button[@id='next-button']"));
		elementClick(btnNext);
	}

	@When("User enters address {string} city {string},state {string},country {string} and postalcode {string}")
	public void userEntersAddressCityStateCountryAndPostalcode(String address, String city, String state,
			String country, String postalCode) {
		WebElement txtAddress = driver.findElement(By.id("address1"));
		elementSendKeys(txtAddress, address);

		WebElement txtCity = driver.findElement(By.id("cityVillage"));
		elementSendKeys(txtCity, city);

		WebElement txtState = driver.findElement(By.id("stateProvince"));
		elementSendKeys(txtState, state);

		WebElement txtCountry = driver.findElement(By.id("country"));
		elementSendKeys(txtCountry, country);

		WebElement txtPostalCode = driver.findElement(By.id("postalCode"));
		elementSendKeys(txtPostalCode, postalCode);

		WebElement btnNext = driver.findElement(By.xpath("//button[@id='next-button']"));
		elementClick(btnNext);
	}

	@When("User enters phonenumber {string}")
	public void userEntersPhonenumber(String phoneNumber) {
		WebElement txtPhoneNumber = driver.findElement(By.name("phoneNumber"));
		elementSendKeys(txtPhoneNumber, phoneNumber);

		WebElement btnNext = driver.findElement(By.xpath("//button[@id='next-button']"));
		elementClick(btnNext);

	}

	@When("User select relationship {string} and enters personname {string}")
	public void userSelectRelationshipAndEntersPersonname(String relationship, String personName) {
		WebElement ddnRelationShip = driver.findElement(By.id("relationship_type"));
		selectOptionByText(ddnRelationShip, relationship);

		WebElement txtPersonName = driver.findElement(By.xpath("//input[@placeholder='Person Name']"));
		elementSendKeys(txtPersonName, personName);

		WebElement btnNext = driver.findElement(By.xpath("//button[@id='next-button']"));
		elementClick(btnNext);
	}

	@Then("User verify details populated correctly")
	public void userVerifyDetailsPopulatedCorrectly() {
		WebElement txtName = driver.findElement(By.xpath("//p[text()='Mary, Mark']"));
		System.out.println(elementGetText(txtName));
		WebElement txtGender = driver.findElement(By.xpath("//p[text()='Female']"));
		System.out.println(elementGetText(txtGender));
		WebElement txtBirthDate = driver.findElement(By.xpath("//p[text()='02, April, 1992']"));
		System.out.println(elementGetText(txtBirthDate));
		WebElement txtAdd = driver
				.findElement(By.xpath("//p[text()='Wilson Street, Coimbatore, Tamil Nadu, India, 641010']"));
		System.out.println(elementGetText(txtAdd));

	}

	@When("User click confirm button")
	public void userClickConfirmButton() {
		WebElement btnConfirm = driver.findElement(By.xpath("//input[@type='submit']"));
		elementClick(btnConfirm);
	}

	@When("User click on Home icon")
	public void userClickOnHomeIcon() {
		WebElement optHome = driver.findElement(By.xpath("//i[@class='icon-home small']"));
		elementClick(optHome);
	}

	@Then("User verify home page is displayed")
	public void userVerifyHomePageIsDisplayed() {
		WebElement homePage = driver.findElement(By.xpath("//h4[contains(text(),'Logged')]"));
		Assert.assertTrue("verify home page is displayed", homePage.isDisplayed());
	}

	@When("User click on appointment scheduling")
	public void userClickOnAppointmentScheduling() {
		WebElement optAppointmentScheduling = driver
				.findElement(By.xpath("//div[@id='apps']//child::a[contains(@href,'appointment')]"));
		elementClick(optAppointmentScheduling);

	}

	@Then("User verify appointment scheduling page is displayed")
	public void userVerifyAppointmentSchedulingPageIsDisplayed() {

		WebElement appoinmentPage = driver
				.findElement(By.xpath("//ul[@id='breadcrumbs']//child::li//following-sibling::li"));

		Assert.assertTrue("verify appointmentscheduling page is displayed", appoinmentPage.isDisplayed());

	}

	@When("User click on ManageServiceTypes and click on NewServiceType")
	public void userClickOnManageServiceTypesAndClickOnNewServiceType() {
		WebElement optManageServiceType = driver
				.findElement(By.id("appointmentschedulingui-manageAppointmentTypes-app"));
		elementClick(optManageServiceType);

		WebElement optNewServiceType = driver
				.findElement(By.xpath("//button[@class='confirm appointment-type-label right']"));
		elementClick(optNewServiceType);

	}

	@When("User enters servicename {string} ,duration {string}, description {string} and click save button")
	public void userEntersServicenameDurationDescriptionAndClickSaveButton(String serviceName, String duration,
			String description) {
		WebElement txtServiceName = driver.findElement(By.id("name-field"));
		elementClear(txtServiceName);
		elementSendKeys(txtServiceName, serviceName);

		WebElement txtServiceDuration = driver.findElement(By.id("duration-field"));
		elementSendKeys(txtServiceDuration, duration);

		WebElement txtDescription = driver.findElement(By.id("description-field"));
		elementSendKeys(txtDescription, description);

		WebElement btnSave = driver.findElement(By.id("save-button"));
		elementClick(btnSave);

		WebElement optLast = driver.findElement(By.id("appointmentTypesTable_last"));
		elementClick(optLast);
	}

	@Then("User verify service type added in the table")
	public void userVerifyServiceTypeAddedInTheTable() {
		List<WebElement> table = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']//child::tr"));
		System.out.println(elementGetText(table.get(table.size() - 1)));
	}

	@When("User click on Appointment Scheduling link and click on ManageProviderSchedules")
	public void userClickOnAppointmentSchedulingLinkAndClickOnManageProviderSchedules() {

		WebElement optAppointment = driver.findElement(By.xpath("//a[contains(@href,'appointment')]"));
		elementClick(optAppointment);

		WebElement optManageProviderSchedule = driver
				.findElement(By.xpath("//a[@id='appointmentschedulingui-scheduleProviders-app']"));
		elementClick(optManageProviderSchedule);
	}

	@Then("User Verify Appointment block is displayed or not")
	public void userVerifyAppointmentBlockIsDisplayedOrNot() {
		WebElement appointmentBlock = driver.findElement(By.xpath("//h1[contains(text(),'Manage Appointment ')]"));
		Assert.assertTrue("verify appointment block", appointmentBlock.isDisplayed());
	}

	@When("User Select the current date in the calendar")
	public void userSelectTheCurrentDateInTheCalendar() {
		WebElement txtDate = driver.findElement(By.xpath("//td[@data-date='" + getDateForWorkingDay() + "']"));
		elementClick(txtDate);

	}

	@Then("User Verify create appointment block is displayed")
	public void userVerifyCreateAppointmentBlockIsDisplayed() {
		WebElement optCreateAppointment = driver.findElement(By.xpath("//h1[contains(text(),'Create Appointment')]"));
		Assert.assertTrue("verify create appoitnment", optCreateAppointment.isDisplayed());
	}

	@When("User select the location {string} and user enters provider {string}")
	public void userSelectTheLocationAndUserEntersProvider(String location, String provider) {
		WebElement ddLocation = driver.findElement(By.xpath("//div[@id='select-location']//child::select"));
		selectOptionByText(ddLocation, location);

		WebElement txtProviders = driver.findElement(By.xpath("//div[@id='select-provider']//child::input"));
		elementSendKeys(txtProviders, provider);

		WebElement startHour = driver.findElement(By.xpath("(//input[@ng-model='hours'])[1]"));
		elementSendKeys(startHour, "10");
		WebElement startMin = driver.findElement(By.xpath("(//input[@ng-model='minutes'])[1]"));
		elementSendKeys(startMin, "30");
		WebElement startMer = driver.findElement(By.xpath("(//button[@ng-click='toggleMeridian()'])[1]"));
		elementClick(startMer);

		WebElement endHour = driver.findElement(By.xpath("(//input[@ng-model='hours'])[2]"));
		elementSendKeys(endHour, "11");
		WebElement endMin = driver.findElement(By.xpath("(//input[@ng-model='minutes'])[2]"));
		elementSendKeys(endMin, "00");
		WebElement endMer = driver.findElement(By.xpath("(//button[@ng-click='toggleMeridian()'])[2]"));
		elementClick(endMer);

		WebElement viewAllTypes = driver.findElement(By.xpath("(//a[text()='View all types'])[2]"));
		viewAllTypes.click();

		List<WebElement> list = driver.findElements(By.xpath(
				"//div[@id='appointment-block-form']//child::selectmultipleappointmenttypes[@placeholdermessage='Select one or more services']//child::div[@id='allAppointmentTypesModal']//child::div[@class='dialog-content']//child::a"));

		clickElementByJS(list.get(list.size() - 1));

		WebElement btnClose = driver.findElement(By.xpath(
				"//div[@id='appointment-block-form']//child::selectmultipleappointmenttypes[@placeholdermessage='Select one or more services']//child::div[@id='allAppointmentTypesModal']//child::div[@class='dialog-content']//span[@class='button confirm ng-binding']"));
		clickElementByJS(btnClose);
		WebElement btnSaveAppoinment = driver.findElement(By.xpath("//button[@class='confirm']"));
		clickElementByJS(btnSaveAppoinment);

		WebElement selectedDate = driver.findElement(
				By.xpath("//td[@data-date='" + getDateForWorkingDay() + "']//child::div[@class='fc-day-content']"));
		System.out.println(elementGetText(selectedDate));
	}

	@When("User click on FindPatientRecord and search the patient record by patient id")
	public void userClickOnFindPatientRecordAndSearchThePatientRecordByPatientId() {
		WebElement optFindPatientRecord = driver.findElement(By.xpath(
				"//a[contains(@id,'coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension')]"));
		elementClick(optFindPatientRecord);

		WebElement txtFindPatient = driver.findElement(By.id("patient-search"));
		elementSendKeysWithEnter(txtFindPatient, "100KK3");
//		enterValueByJS("100JL2", txtFindPatient);

		WebElement optScheduleAppointment = driver
				.findElement(By.xpath("//div[contains(text(),'Schedule Appointment')]"));
		elementClick(optScheduleAppointment);

		WebElement viewAllTypes = driver.findElement(By.xpath("//a[text()='View all types']"));
		viewAllTypes.click();

		WebElement optService = driver.findElement(By.xpath("//a[text()='Z General Treatement']"));
		elementClick(optService);

		WebElement btnSearch = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
		elementClick(btnSearch);

		elementClick(driver.findElement(By.xpath("(//button[@title='Last Page'])[2]")));

		List<WebElement> appointments = driver.findElements(By.xpath("//div[@class='ng-scope ngRow even']"));
		clickElementByJS(appointments.get(appointments.size() - 1));

		WebElement btnNext = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		elementClick(btnNext);

		WebElement appointmentNotes = driver.findElement(By.id("appointmentReason"));
		elementSendKeys(appointmentNotes, "Appointment Test");

		WebElement btnSave = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		elementClick(btnSave);

		WebElement optStartVisit = driver.findElement(By.xpath("//div[contains(text(),'Start Visit')]"));
		elementClick(optStartVisit);

		WebElement btnConfirm = driver.findElement(By.id("start-visit-with-visittype-confirm"));
		elementClick(btnConfirm);

		WebElement optAttachements = driver.findElement(By.xpath("//a[contains(@href,'atta')]"));
		clickElementByJS(optAttachements);

		WebElement fileUpload = driver.findElement(By.id("visit-documents-dropzone"));
		elementSendKeysWithEnter(fileUpload, "C:\\Users\\nitis\\Downloads\\QA_Testing_35.pdf");

		WebElement txtCaption = driver.findElement(By.xpath("//textarea[@placeholder='Enter a caption']"));
		elementSendKeys(txtCaption, "Test");

		WebElement btnUpload = driver.findElement(By.xpath("//button[text()='Upload file']"));
		elementClick(btnUpload);
	}

}
