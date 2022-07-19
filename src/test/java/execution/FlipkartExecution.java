package execution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import reuse.methods.LilGlobal;
import test.trial.FlipkartTask;

public class FlipkartExecution extends LilGlobal {
	
	@BeforeClass
	private void openBrowser() {
		launchBrave();
		maxWindow();
	}
	
	@AfterClass
	private void exitBrowser() {
		closeBrowser();
	}
	
	@Test(parameters= {"userName", "password"})
	private void login(String s1, String s2) throws InterruptedException {
		loadUrl("https://www.flipkart.com/account/login");
		FlipkartTask ft = new FlipkartTask();
		ft.flipkartLogin(s1, s2);
		Thread.sleep(3000);
		WebElement errorMsg = driver.findElement(By.xpath("(//span[.=\"Please enter valid Email ID/Mobile number\"])[2]"));
		System.out.println(errorMsg.getText());
	}
	

}
