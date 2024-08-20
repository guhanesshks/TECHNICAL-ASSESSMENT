package com.base;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;

	public void launchBrowser() {
		driver = new ChromeDriver();
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void implicitWait(long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public void loadUrl(String url) {
		driver.get(url);
	}

	public void elementSendKeys(WebElement e, String data) {
		e.sendKeys(data);
	}

	public void elementSendKeysWithEnter(WebElement e, String data) {
		e.sendKeys(data, Keys.ENTER);
	}

	public void elementClear(WebElement e) {
		e.clear();
	}

	public void elementClick(WebElement element) {
		element.click();
	}

	public void closeBrowser() {
		driver.quit();
	}

	public void clickElementByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}

	public void enterValueByJS(String data, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	public byte[] takeScreenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] bs = screenshot.getScreenshotAs(OutputType.BYTES);
		return bs;

	}

	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	public void selectOptionByText(WebElement e, String text) {
		Select s = new Select(e);
		s.selectByVisibleText(text);
	}

	public String elementGetText(WebElement e) {
		String text = e.getText();
		return text;
	}

	public static String getDateForWorkingDay() {
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

}
