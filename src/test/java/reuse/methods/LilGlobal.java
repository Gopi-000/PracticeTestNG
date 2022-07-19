package reuse.methods;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LilGlobal {
	public static WebDriver driver;
	//WEBDRIVER INTERFACE RELATED METHODS
	public WebDriver launchBrave() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions brave = new ChromeOptions().setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
		driver = new ChromeDriver(brave);
		return driver;
	}
	
	public WebDriver launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
	
	public void loadUrl(String url) {
		driver.get(url);
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}

	public void maxWindow() {
		driver.manage().window().maximize();
	}
	
	public void minWindow() {
		driver.manage().window().minimize();
	}
	
	public String currentPageId() {
		return driver.getWindowHandle();
	}
	
	public Set<String> allPageId() {
		return driver.getWindowHandles();
	}
	
	//WEBELEMENT INTERFACE RELATED METHODS
	public void insertText(String data, WebElement e) {
		e.sendKeys(data);
	}
	
	public void btnClick(WebElement e) {
		e.click();
	}
	
	public void clearText(WebElement e) {
		e.clear();
	}
	
	public String textGet(WebElement e) {
		return e.getText();
	}
	
	public String attribute(WebElement e) {
		return e.getAttribute("value");
	}
	//SELECT CLASS RELATED METHODS
	public Select selectelement(WebElement e) {
		return new Select(e);
	}
	
	public void selectIndex(WebElement e, int index) {
		selectelement(e).selectByIndex(index);
	}
	
	public void selectValue(WebElement e, String value) {
		selectelement(e).selectByValue(value);
	}
	
	public void selectVisiText(WebElement e, String text) {
		selectelement(e).selectByVisibleText(text);
	}
	
	public List<WebElement> getAllOptions(WebElement e) {
		return selectelement(e).getOptions();
	}
	
	public List<WebElement> allSelectedOpt(WebElement e) {
		return selectelement(e).getAllSelectedOptions();
	}
	
	public void deselectIndex(WebElement e, int index) {
		selectelement(e).deselectByIndex(index);
	}
	
	public void deselectValue(WebElement e,String value) {
		selectelement(e).deselectByValue(value);
	}
	
	public void deselectVisiText(WebElement e, String text) {
		selectelement(e).deselectByVisibleText(text);
	}
	
	public void deselectAll(WebElement e) {
		selectelement(e).deselectAll();
	}
	//ACTIONS CLASS RELATED METHODS
	public Actions actionClass() {
		return new Actions(driver);
	}
	
	public void moveMouse(WebElement target) {
		actionClass().moveToElement(target).perform();
	}
	
	public void rightClick(WebElement target) {
		actionClass().contextClick(target).perform();
	}
	
	public void dragAnddrop(WebElement src, WebElement target) {
		actionClass().dragAndDrop(src, target).perform();
	}
	
	public void doubleClick(WebElement target) {
		actionClass().doubleClick(target).perform();
	}
	//ALERT INTERFACE RELATED METHODS
	public Alert switchToAlert() {
		return driver.switchTo().alert();
	}
	
	public void acceptAlert() {
		switchToAlert().accept();
	}
	
	public void dismissAlert() {
		switchToAlert().dismiss();
	}
	
	public String alertText() {
		return switchToAlert().getText();
	}
	
	public void alertFill(String text) {
		switchToAlert().sendKeys(text);
	}
	//NAVIGATION INTERFACE RELATED METHODS
	public Navigation webNavigate() {
		return driver.navigate();
	}
	
	public void refreshWeb() {
		webNavigate().refresh();
	}
	
	public void goForward() {
		webNavigate().forward();
	}
	
	public void gobackward() {
		webNavigate().back();
	}
	
}
