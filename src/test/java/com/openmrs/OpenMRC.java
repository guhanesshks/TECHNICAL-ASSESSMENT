package com.openmrs;

import java.awt.AWTException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenMRC {

	public static String getDateForMonday() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		String dayOfWeek = sdf.format(date);
		String d = null;

		System.out.println(dayOfWeek);

		if (dayOfWeek.equals("Saturday") || dayOfWeek.equals("Sunday")) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			if (dayOfWeek.equals("Saturday")) {
				calendar.add(Calendar.DAY_OF_YEAR, 2);
			} else {
				calendar.add(Calendar.DAY_OF_YEAR, 1);
			}
			Date mondayDate = calendar.getTime();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			d = dateFormat.format(mondayDate);

		} else {
			SimpleDateFormat dateSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			d = dateSimpleDateFormat.format(date);
		}
		return d;

	}

	public static void main(String[] args) throws AWTException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement txtUserName = driver.findElement(By.xpath("//input[@id='username']"));
		txtUserName.sendKeys("Admin");
		WebElement txtPassword = driver.findElement(By.xpath("//input[@id='password']"));
		txtPassword.sendKeys("Admin123");

		List<WebElement> optionLocation = driver.findElements(By.xpath("//ul[@id='sessionLocation']//child::li"));
		for (WebElement element : optionLocation) {

			if (element.getText().equals("Registration Desk")) {
				element.click();
			}

		}

		WebElement btnLogin = driver.findElement(By.id("loginButton"));
		btnLogin.click();

		WebElement loginMessage = driver.findElement(By.xpath("//h4[contains(text(),'Logged')]"));
		boolean b = loginMessage.isDisplayed();
		System.out.println(b);

		WebElement optRegisterAPatient = driver
				.findElement(By.xpath("//div[@id='apps']//child::a[contains(@href,'register')]"));
		optRegisterAPatient.click();

		WebElement txtGivenName = driver.findElement(By.name("givenName"));
		txtGivenName.sendKeys("Mary");

		WebElement txtFamilyName = driver.findElement(By.name("familyName"));
		txtFamilyName.sendKeys("Mark");

		WebElement btnNext = driver.findElement(By.xpath("//button[@id='next-button']"));
		btnNext.click();

		WebElement ddnGender = driver.findElement(By.name("gender"));
		Select s = new Select(ddnGender);
		s.selectByVisibleText("Female");

		btnNext.click();

		WebElement txtBirthDay = driver.findElement(By.name("birthdateDay"));
		txtBirthDay.sendKeys("02");

		WebElement ddnMonth = driver.findElement(By.name("birthdateMonth"));
		Select select = new Select(ddnMonth);
		select.selectByVisibleText("April");

		WebElement txtBirthYear = driver.findElement(By.name("birthdateYear"));
		txtBirthYear.sendKeys("1992");

		btnNext.click();

		WebElement txtAddress = driver.findElement(By.id("address1"));
		txtAddress.sendKeys("Wilson Street");

		WebElement txtCity = driver.findElement(By.id("cityVillage"));
		txtCity.sendKeys("Coimbatore");
		WebElement txtState = driver.findElement(By.id("stateProvince"));
		txtState.sendKeys("Tamil Nadu");
		WebElement txtCountry = driver.findElement(By.id("country"));
		txtCountry.sendKeys("India");
		WebElement txtPostalCode = driver.findElement(By.id("postalCode"));
		txtPostalCode.sendKeys("641010");

		btnNext.click();

		WebElement txtPhoneNumber = driver.findElement(By.name("phoneNumber"));
		txtPhoneNumber.sendKeys("8989898989");

		btnNext.click();

		WebElement ddnRelationShip = driver.findElement(By.id("relationship_type"));
		Select select2 = new Select(ddnRelationShip);
		select2.selectByVisibleText("Doctor");

		WebElement txtPersonName = driver.findElement(By.xpath("//input[@placeholder='Person Name']"));
		txtPersonName.sendKeys("Jake Smith");

		btnNext.click();

		WebElement txtName = driver.findElement(By.xpath("//p[text()='Mary, Mark']"));
		System.out.println(txtName.getText());
		WebElement txtGender = driver.findElement(By.xpath("//p[text()='Female']"));
		System.out.println(txtGender.getText());
		WebElement txtBirthDate = driver.findElement(By.xpath("//p[text()='02, April, 1992']"));
		System.out.println(txtBirthDate.getText());
		WebElement txtAdd = driver
				.findElement(By.xpath("//p[text()='Wilson Street, Coimbatore, Tamil Nadu, India, 641010']"));
		System.out.println(txtAdd.getText());

		WebElement btnConfirm = driver.findElement(By.xpath("//input[@type='submit']"));
		btnConfirm.click();

		WebElement optHome = driver.findElement(By.xpath("//i[@class='icon-home small']"));
		optHome.click();

		WebElement optAppointmentScheduling = driver
				.findElement(By.xpath("//div[@id='apps']//child::a[contains(@href,'appointment')]"));
		optAppointmentScheduling.click();

		WebElement appoinmentPage = driver
				.findElement(By.xpath("//ul[@id='breadcrumbs']//child::li//following-sibling::li"));
		boolean displayed = appoinmentPage.isDisplayed();
		System.out.println(displayed);

		WebElement optManageServiceType = driver
				.findElement(By.id("appointmentschedulingui-manageAppointmentTypes-app"));
		optManageServiceType.click();

		WebElement optNewServiceType = driver
				.findElement(By.xpath("//button[@class='confirm appointment-type-label right']"));
		optNewServiceType.click();

		WebElement txtServiceName = driver.findElement(By.id("name-field"));
		txtServiceName.clear();
		txtServiceName.sendKeys("Z General Treatement");

		WebElement txtServiceDuration = driver.findElement(By.id("duration-field"));
		txtServiceDuration.sendKeys("25");

		WebElement txtDescription = driver.findElement(By.id("description-field"));
		txtDescription.sendKeys("Test");

		WebElement btnSave = driver.findElement(By.id("save-button"));
		btnSave.click();

		WebElement optLast = driver.findElement(By.id("appointmentTypesTable_last"));
		optLast.click();

		List<WebElement> table = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']//child::tr"));
		String text = table.get(table.size() - 1).getText();
		System.out.println(text);

		WebElement optAppointment = driver.findElement(By.xpath("//a[contains(@href,'appointment')]"));
		optAppointment.click();

		WebElement optManageProviderSchedule = driver
				.findElement(By.xpath("//a[@id='appointmentschedulingui-scheduleProviders-app']"));
		optManageProviderSchedule.click();

		WebElement appointmentBlock = driver.findElement(By.xpath("//h1[contains(text(),'Manage Appointment ')]"));
		boolean c = appointmentBlock.isDisplayed();
		System.out.println(c);

		WebElement txtDate = driver.findElement(By.xpath("//td[@data-date='" + getDateForMonday() + "']"));
		txtDate.click();

		WebElement ddLocation = driver.findElement(By.xpath("//div[@id='select-location']//child::select"));
		Select select3 = new Select(ddLocation);
		select3.selectByVisibleText("Registration Desk");

		WebElement txtProviders = driver.findElement(By.xpath("//div[@id='select-provider']//child::input"));
		txtProviders.sendKeys("Jake Smith");

		WebElement viewAllTypes = driver.findElement(By.xpath("(//a[text()='View all types'])[2]"));
		viewAllTypes.click();

		List<WebElement> list = driver.findElements(By.xpath(
				"//div[@id='appointment-block-form']//child::selectmultipleappointmenttypes[@placeholdermessage='Select one or more services']//child::div[@id='allAppointmentTypesModal']//child::div[@class='dialog-content']//child::a"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", list.get(list.size() - 1));

		WebElement btnClose = driver.findElement(By.xpath(
				"//div[@id='appointment-block-form']//child::selectmultipleappointmenttypes[@placeholdermessage='Select one or more services']//child::div[@id='allAppointmentTypesModal']//child::div[@class='dialog-content']//span[@class='button confirm ng-binding']"));
		executor.executeScript("arguments[0].click();", btnClose);

		WebElement btnSaveAppoinment = driver.findElement(By.xpath("//button[@class='confirm']"));
		executor.executeScript("arguments[0].click();", btnSaveAppoinment);

	}

}
