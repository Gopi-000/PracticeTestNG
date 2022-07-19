package hotel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reuse.methods.LilGlobal;

public class BookAHotel extends LilGlobal{
	public BookAHotel() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="first_name") private WebElement firstName;
	@FindBy(id="last_name") private WebElement lastName;
	@FindBy(id="address") private WebElement address;
	@FindBy(id="cc_num") private WebElement creditCardNo;
	@FindBy(id="cc_type") private WebElement creditCardType;
	@FindBy(id="cc_exp_month") private WebElement cardMonth;
	@FindBy(id="cc_exp_year") private WebElement cardYear;
	@FindBy(id="cc_cvv") private WebElement cardCVV;
	@FindBy(id="book_now") private WebElement btnBook;
	
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getCreditCardNo() {
		return creditCardNo;
	}
	public WebElement getCreditCardType() {
		return creditCardType;
	}
	public WebElement getCardMonth() {
		return cardMonth;
	}
	public WebElement getCardYear() {
		return cardYear;
	}
	public WebElement getCardCVV() {
		return cardCVV;
	}
	public WebElement getBtnBook() {
		return btnBook;
	}
	
	public void bookHotel(String fname, String lname , String address, String cardno, String cvv) {
		insertText(fname, getFirstName());
		insertText(lname, getLastName());
		insertText(address, getAddress());
		insertText(cardno, getCreditCardNo());
		selectValue(getCreditCardType(), "VISA");
		selectValue(getCardMonth(), "11");
		selectValue(getCardYear(), "2022");
		insertText(cvv, getCardCVV());
		btnClick(getBtnBook());
	}


}
