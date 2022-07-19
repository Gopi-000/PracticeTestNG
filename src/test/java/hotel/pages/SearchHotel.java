package hotel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuse.methods.LilGlobal;

public class SearchHotel extends LilGlobal {
	
	public SearchHotel() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="location") private WebElement location;
	@FindBy(id="hotels") private WebElement hotel;
	@FindBy(id="room_type") private WebElement roomType;
	@FindBy(id="room_nos") private WebElement noOfRooms;
	@FindBy(id="datepick_in") private WebElement checkIn;
	@FindBy(id="datepick_out") private WebElement checkOut;
	@FindBy(id="adult_room") private WebElement adultPerRoom;
	@FindBy(id="child_room") private WebElement childPerRoom;
	@FindBy(id="Submit") private WebElement btnSearch;
	
	public WebElement getBtnSearch() {
		return btnSearch;
	}
	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotel() {
		return hotel;
	}
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getNoOfRooms() {
		return noOfRooms;
	}
	public WebElement getCheckIn() {
		return checkIn;
	}
	public WebElement getCheckOut() {
		return checkOut;
	}
	public WebElement getAdultPerRoom() {
		return adultPerRoom;
	}
	public WebElement getChildPerRoom() {
		return childPerRoom;
	}
	
	public void searchhotel(String checkin, String checkout) {
		selectValue(getLocation(), "London");
		selectValue(getHotel(), "Hotel Cornice");
		selectValue(getRoomType(), "Super Deluxe");
		selectValue(getNoOfRooms(), "3");
		clearText(getCheckIn());
		insertText(checkin, getCheckIn());
		clearText(getCheckOut());
		insertText(checkout, getCheckOut());
		selectValue(getAdultPerRoom(), "2");
		selectValue(getChildPerRoom(), "3");
		btnClick(getBtnSearch());
	}
	

}
