package hotel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuse.methods.LilGlobal;

public class SelectHotel extends LilGlobal{
	
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="radiobutton_0") private WebElement radioBtn;
	@FindBy(id="continue") private WebElement btnContinue;
	
	public WebElement getRadioBtn() {
		return radioBtn;
	}
	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	public void selectHotel() {
		btnClick(getRadioBtn());
		btnClick(getBtnContinue());

	}
	
}
