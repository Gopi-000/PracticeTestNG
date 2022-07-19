package hotel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuse.methods.LilGlobal;

public class LoginPage extends LilGlobal {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username") private WebElement userName;
	@FindBy(id="password") private WebElement password;
	@FindBy(id="login") private WebElement btnLogin;
	
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	public void login(String username, String pass) {
		insertText(username, getUserName());
		insertText(pass, getPassword());
		btnClick(getBtnLogin());
	}

}
