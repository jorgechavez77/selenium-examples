package org.demo.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumExample {

	@Test
	public void test1() {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://google.com");
		// driver.navigate().to("http://google.com");

		WebElement element = driver.findElement(By.name("q"));

		element.sendKeys("cheese!");

		element.submit();

		System.out.println(driver.getTitle());

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver webDriver) {
				return webDriver.getTitle().toLowerCase().startsWith("cheese!");
			}
		});

		System.out.println(driver.getTitle());

		driver.quit();
	}

	@Test
	public void test2() {
		WebDriver driver = new FirefoxDriver();

		String baseUrl = "http://google.com/";

		driver.get(baseUrl);

		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib")).sendKeys("it");

		driver.findElement(By.name("btnG")).click();

		System.out.println(driver.getTitle());

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver webDriver) {
				return webDriver.getTitle().toLowerCase().startsWith("it");
			}
		});

		System.out.println(driver.getTitle());

		driver.quit();
	}

}
