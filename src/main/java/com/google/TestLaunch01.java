package com.google;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TestLaunch01 {
	public WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test(priority = 1)
	public void verifySearchButton() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Launch google Browser
		driver.get("http://www.google.com");
		String search_text = "Google Search";
		WebElement search_button = driver.findElement(By.cssSelector("*[value='Google Search']"));

		String text = search_button.getAttribute("value");

		Assert.assertEquals(text, search_text, "Text not found!");
	}

	@Test(priority = 0)
	public void VerifyTitle() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Launch google Browser
		driver.get("http://www.google.com");
		// Verify if Google Title is Available
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";
		Assert.assertEquals(expectedTitle, actualTitle);

	}

	@Test(priority = 2)
	public void VerifySearchValidText() {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Launch google Browser
		driver.get("http://www.google.com");

		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).sendKeys("Automation Testing");
		driver.findElement(By.cssSelector("*[value='Google Search']")).click();

	}

	@Test(priority = 3)
	public void VerifySearcInhValidText() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Launch google Browser
		driver.get("http://www.google.com");

		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).sendKeys("!@#$");
		driver.findElement(By.cssSelector("*[value='Google Search']")).click();

	}

	@Test(priority = 5)
	public void VerifySignin() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Launch google Browser
		driver.get("http://www.google.com");

		driver.findElement(By.cssSelector("a[class=\'gb_4 gb_5 gb_ae gb_4c\']")).click();

	}

	@Test(priority = 4)
	public void VerifyFeelingLucky() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Launch google Browser
		driver.get("http://www.google.com");

		Actions a = new Actions(driver);

		a.moveToElement(driver.findElement(By.cssSelector("*[class='RNmpXc']"))).click().build().perform();

	}

	@Test(priority = 7)
	public void VerifyGmail() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Launch google Browser
		driver.get("http://www.google.com");

		Actions a = new Actions(driver);

		a.moveToElement(driver.findElement(By.cssSelector("*[class='gb_g']"))).click().build().perform();

	}

	@Test(priority = 6)
	public void VerifyImages() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Launch google Browser
		driver.get("http://www.google.com");

		Actions a = new Actions(driver);

		a.moveToElement(driver.findElement(By.xpath("//div[@class='gb_9d gb_i gb_ng gb_eg']/div[2]/a"))).click().build()
				.perform();

	}

	@AfterClass
	public void afterClass() {
		driver.close();

	}

}
