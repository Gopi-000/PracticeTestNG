package interview.questions;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reuse.methods.LilGlobal;

public class WaitsConcept extends LilGlobal {
	@BeforeClass
	private void launchandmax() {
		launchBrave();
		maxWindow();
	}

	@AfterClass
	private void exitBrowser() {
		quitBrowser();
	}
	
	
	@Test
	private void implicitwaitconcept() {
		loadUrl("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Sabari");
		System.out.println("Implicit Wait Done.");
	}
	
	@Test(priority=1)
	private void explicitwatiConcept() {
		loadUrl("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("firstname")))).sendKeys("sabari");
		System.out.println("Explicit Wait Done.");
	}
	
	@Test(priority=2)
	public void fluendWaitConcept() {
		loadUrl("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		
		fwait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.name("firstname"));
			}
		}).sendKeys("Sabari");
		System.out.println("Fluent Wait Done.");
	}}
