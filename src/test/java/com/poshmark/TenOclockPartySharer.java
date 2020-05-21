package com.poshmark;



import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TenOclockPartySharer {

	@Test
	public void loginTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Random r = new Random();
		//driver.manage().window().fullscreen();

		// navigate to poshmark
		driver.get("https://poshmark.com/login");

		// input username and password

		String username = "closetofella";
		String pwd = "20191202ella";
		driver.findElement(By.xpath("//div[@class='form-group'][1]/input")).sendKeys(username);
		driver.findElement(By.xpath("//div[@class='form-group'][2]/input")).sendKeys(pwd);

		Thread.sleep(10000);

		driver.findElement(By.cssSelector(".form-actions>button")).click();

		// wait until successfully login
		Thread.sleep(5000);

		// click the dropdown menu from right top corner to click my closet
		driver.findElement(By.xpath("//div[@class='header__con']/ul/li[4]")).click();
		driver.findElement(By.xpath("//div[@class='header__con']/ul/li[4]//li[1]")).click();

		// wait till all the stuff in closet successfully loaded
		Thread.sleep(5000);

		// get the total listing of items
		String totalCount = driver.findElement(By.xpath("//li[@class='active']//div[1]")).getText();
		int totalInventory = Integer.valueOf(totalCount);

		// Input sould item Count

		int soldCount = 11;

		int shareCount = 0;
		int inventoryNumber = 1;
		int cycleCount=0;
		boolean b = true;
		int shareLoopCount=0;

		while (b) {
			
			while(shareLoopCount<5) {

			String xpathForXInventory = "//div[@id='tiles-con']/div[" + inventoryNumber + "]//li[3]";

			driver.findElement(By.xpath(xpathForXInventory)).click();

			
			//===========
		
			
			WebElement poshParty= driver.findElement(By.xpath("//div[@class='party-info']/div"));
			poshParty.click();
			
			//==============
			
			
			

			int random1 = r.nextInt(1) + 2;
			int waitTimePerShare = random1 * 1100;
			Thread.sleep(waitTimePerShare);
			
			

			if (inventoryNumber % 4 == 0 && shareLoopCount==4 ) {
				js.executeScript("window.scrollBy(0,300)", "");
				int random2 = r.nextInt(6) + 10;
				int waitTimePerGroup = random2 * 1200;
				Thread.sleep(waitTimePerGroup);
				
			}
			
			inventoryNumber += 1;

			shareCount += 1;

			if (inventoryNumber == totalInventory - soldCount) {
				js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
				inventoryNumber = 0;
				cycleCount += 1;
				System.out.println("total item " + shareCount +" and this is No."+ cycleCount +" Shareing Cycle");
				shareCount = 0;
				
				int random3 = r.nextInt(10) + 10;
				int waitTimePerCycle = random3 * 1000;
				Thread.sleep(waitTimePerCycle);
				
				if (cycleCount == 20) {
					b=false;
				}
				String str=a,b,c;
				
				for(int i=0;i<str,i++) {
					if(dte.charAt(i)==',') {
						charAt(i)='.'
					}
					
				}
			}

			

		}
		;
	}
	}
	
	
	
	

}
