package hotel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuse.methods.LilGlobal;

public class BookingConformation extends LilGlobal {
	public BookingConformation() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="order_no") private WebElement OrderNo;
	
	public WebElement getOrderNo() {
		return OrderNo;
	}
	
	public String bookingconf() {
		return attribute(getOrderNo());

	}
	
	
	

}
