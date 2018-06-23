package com.prestashop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NegativeFour {

	@Test
	public void blankPasswordTest() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get(" http://automationpractice.com");
		driver.findElement(By.cssSelector("div[class='header_user_info']>a")).click();

		driver.findElement(By.id("email")).sendKeys("aghdxdxhj@yahoo.com");
		driver.findElement(By.id("passwd")).sendKeys("");
		driver.findElement(By.id("SubmitLogin")).click();

		Assert.assertTrue(driver.getPageSource().contains("Password is required"));

	}
}
