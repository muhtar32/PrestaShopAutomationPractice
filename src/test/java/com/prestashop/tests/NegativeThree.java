package com.prestashop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NegativeThree {

	@Test
	public void blankEmailTest() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get(" http://automationpractice.com");
		driver.findElement(By.cssSelector("div[class='header_user_info']>a")).click();

		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("passwd")).sendKeys("wbxhwcwhcbhbhcwdhu67879");
		driver.findElement(By.id("SubmitLogin")).click();

		Assert.assertTrue(driver.getPageSource().contains("An email address required"));

	}
}
