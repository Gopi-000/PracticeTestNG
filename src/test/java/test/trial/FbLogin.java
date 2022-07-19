package test.trial;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuse.methods.LilGlobal;

public class FbLogin extends LilGlobal {
	public FbLogin() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email") private WebElement userName;
	@FindBy(id="pass") private WebElement password;
	@FindBy(name="login") private WebElement btnlogin;
	
	
	public WebElement getBtnlogin() {
		return btnlogin;
	}
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassword() {
		return password;
	}
	
	public void loginPage(String username, String pass) {
		insertText(username, getUserName());
		insertText(pass, getPassword());
		btnClick(getBtnlogin());
	}
	

}
