package org.login;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://bazaar.shopclues.com/");
		//Thread.sleep(14000);//- Static Wait
		//Implicit Wait
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		WebElement dontAllow = driver.findElement(By.xpath("//button[@class='moe-chrome-style-notification-btn moe-btn-close moe-block-class']"));
//		dontAllow.click();
		
		//Explicit Wait
//		WebDriverWait wait = new WebDriverWait(driver, 40);
//		WebElement dontAllow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='moe-chrome-style-notification-btn moe-btn-close moe-block-class']")));
//		dontAllow.click();
		
		//Fluent Wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(Duration.ofSeconds(40)).pollingEvery(Duration.ofSeconds(2)).
				ignoring(Exception.class);
		
		//Anonymus Function
		WebElement until = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				
				return driver.findElement(By.xpath("//button[@class='moe-chrome-style-notification-btn moe-btn-close moe-block-class']"));
			}
		});
		
		until.click();
		
	}

}
