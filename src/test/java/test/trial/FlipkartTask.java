package test.trial;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuse.methods.LilGlobal;

public class FlipkartTask extends LilGlobal{
	public FlipkartTask() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//input[@type='text'])[2]") private WebElement username;
	@FindBy(xpath="//input[@type='password']") private WebElement password;
	@FindBy(xpath="(//button[@type='submit'])[2]") private WebElement btnlogin;
	
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getBtnlogin() {
		return btnlogin;
	}
	
	public void flipkartLogin(String username, String pass) {
		insertText(username, getUsername());
		insertText(pass, getPassword());
		btnClick(getBtnlogin());
	}
	
	

}
