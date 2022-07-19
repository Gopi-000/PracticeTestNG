package execution;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import reuse.methods.LilGlobal;

public class Practice extends LilGlobal{
	public void test() {
		launchBrave();
		maxWindow();
		webNavigate().to("http://www.leafground.com/pages/Link.html");
		//Homepage link
		WebElement homePageLink = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[1]/div/div/a"));
		btnClick(homePageLink);
		gobackward();
		
		//find without clicking
		WebElement noClick = driver.findElement(By.xpath("//a[@style='color:green']"));
		String link = noClick.getAttribute("href");
		System.out.println("The second link will go to the page link: "+link);
		
		//verify broken link
		WebElement brokenLink = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/a"));
		brokenLink.click();
		WebElement broken = driver.findElement(By.xpath("/html/body/center[1]/h1"));
		if(broken.getText().contains("404")) System.out.println("The Link is Broken");
		else System.out.println("the link is not broken");
		gobackward();
		
		//how many links 
		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		System.out.println(totalLinks.size());
		
		
		closeBrowser();
		
		
	}
	
	public static void main(String[] args) {
		Practice p = new Practice();
		p.test();
		
		
	}
	

}
