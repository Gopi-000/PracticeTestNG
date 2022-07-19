package execution;

import java.util.Date;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import hotel.pages.BookAHotel;
import hotel.pages.BookingConformation;
import hotel.pages.LoginPage;
import hotel.pages.SearchHotel;
import hotel.pages.SelectHotel;
import reuse.methods.LilGlobal;

public class HotelBooking extends LilGlobal {
	@BeforeClass
	private void openbrowser() {
		launchBrave();
		maxWindow();
		loadUrl("http://adactinhotelapp.com/index.php");
	}
	
	@AfterClass
	private void closebrave() throws InterruptedException {
		Thread.sleep(5000);
		closeBrowser();
	}
	
	@BeforeMethod
	private void startTime() {
		Date date = new Date();
		System.out.println("Test Starting time: "+date);
	}
	
	@AfterMethod
	private void endTime() {
		Date date = new Date();
		System.out.println("Test Ending time: "+date);
	}
	@Parameters({"userName","password"})
	@Test(priority = -20)
	private void SignInPage(String userName, String password) {
		LoginPage lp = new LoginPage();
		lp.login(userName, password);
	}
	
	@Parameters({"checkin", "checkout"})
	@Test(priority=-10)
	private void SearchHotelPage(String indate, String outdate) {
		SearchHotel srh = new SearchHotel();
		srh.searchhotel(indate, outdate);
	}
	
	@Test
	private void SelectHotelPage() {
		SelectHotel seh = new SelectHotel();
		seh.selectHotel();
	}
	@Parameters({"firstName", "lastName", "address", "cardNum", "cvv"})
	@Test(priority = 10)
	private void BookAHotelpage(String firname, String Lastname, String address, String cardNo, String cvv) throws InterruptedException {
		BookAHotel hotel = new BookAHotel();
		hotel.bookHotel(firname, Lastname, address, cardNo, cvv);
		Thread.sleep(8000);
	}
	
	@Test(priority = 20)
	private void BookingConformationPage() {
		BookingConformation bf = new BookingConformation();
		String orderId = bf.bookingconf();
		System.out.println("Your Booking was Successfully Completed.");
		System.out.println("Your Order ID: "+orderId);
		System.out.println("Thank You for Booking ");
	}


}
