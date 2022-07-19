package interview.questions;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import reuse.methods.LilGlobal;

public class GoogleSuggPrint extends LilGlobal{
	@Test
	private void googleSugg() {
		launchBrave();
		maxWindow();
		loadUrl("https://www.google.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("q")).sendKeys("fun");
		List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']/child::li"));
		
		for (WebElement listsugg : suggestions) {			
			System.out.println(listsugg.getText());			
		}
		closeBrowser();
	}

}
