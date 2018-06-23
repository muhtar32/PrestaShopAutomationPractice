package com.prestashop.tests;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PositiveOne {

	@Test
	public void loginTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();

		driver.get(" http://automationpractice.com");
		driver.findElement(By.cssSelector("div[class='header_user_info']>a")).click();

		Faker faker = new Faker();

		String emailAddress = faker.internet().emailAddress();
		driver.findElement(By.id("email_create")).sendKeys(emailAddress);
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(3000);

		Random r = new Random();
		int i = r.nextInt(2);
		if (i == 0) {
			driver.findElement(By.id("id_gender1")).click();
		} else {
			driver.findElement(By.id("id_gender2")).click();
		}

		String firstName = faker.name().firstName();
		driver.findElement(By.id("customer_firstname")).sendKeys(firstName);

		String lastName = faker.name().lastName();
		driver.findElement(By.id("customer_lastname")).sendKeys(lastName);

		String password = faker.internet().password();
		driver.findElement(By.id("passwd")).sendKeys(password);

		WebElement selectTagDay = driver.findElement(By.id("days"));
		Select listDay = new Select(selectTagDay);
		List<WebElement> dayOptions = listDay.getOptions();
		int indexOfDay = r.nextInt(dayOptions.size() - 1) + 1;
		listDay.selectByIndex(indexOfDay);

		WebElement selectTagMonth = driver.findElement(By.id("months"));
		Select listMonth = new Select(selectTagMonth);
		List<WebElement> monthOptions = listMonth.getOptions();
		int indexOfMonth = r.nextInt(monthOptions.size() - 1) + 1;
		listMonth.selectByIndex(indexOfMonth);

		WebElement selectTagYear = driver.findElement(By.id("years"));
		Select listYear = new Select(selectTagYear);
		List<WebElement> yearOptions = listYear.getOptions();
		int indexOfYear = r.nextInt(yearOptions.size() - 1) + 1;
		listYear.selectByIndex(indexOfYear);

		String address = faker.address().streetAddress();
		driver.findElement(By.id("address1")).sendKeys(address);

		String city = faker.address().city();
		driver.findElement(By.id("city")).sendKeys(city);

		WebElement selectTagState = driver.findElement(By.id("id_state"));
		Select listState = new Select(selectTagState);
		List<WebElement> stateOptions = listState.getOptions();
		int indexOfState = r.nextInt(stateOptions.size() - 1) + 1;
		listState.selectByIndex(indexOfState);

		String zipCode = faker.address().zipCode();
		driver.findElement(By.id("postcode")).sendKeys(zipCode.substring(0, 5));

		String phoneNumber = faker.phoneNumber().cellPhone();
		driver.findElement(By.id("phone_mobile")).sendKeys(phoneNumber);

		String aliasAddress = faker.address().streetAddress();
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys(aliasAddress);

		driver.findElement(By.id("submitAccount")).click(); // finish registering process

		driver.findElement(By.cssSelector("a[title='Log me out']")).click();// sign out

		driver.findElement(By.id("email")).sendKeys(emailAddress);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click(); //sign in

		String actual = driver.findElement(By.cssSelector("a[title='View my customer account']")).getText();

		Assert.assertTrue(actual.contains(firstName) && actual.contains(lastName));

	}
}
