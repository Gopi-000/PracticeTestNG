package orangeLogintestCases;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reuse.methods.LilGlobal;

public class LoginTestCases extends LilGlobal{
	String[][] data= null;	
	
	@DataProvider(name="LoginDataProvider")
	public String[][] loginDataProvider() throws IOException {
		data=getExcelData();
		return data;
	}
	
	public String[][] getExcelData() throws IOException {
		FileInputStream excel = new FileInputStream("C:\\Users\\SOUNDARAVALLI.S\\Desktop\\Data.xlsx");
		Workbook w = new XSSFWorkbook(excel);
		Sheet sheet = w.getSheet("LoginData");
		int rowCount = sheet.getPhysicalNumberOfRows();
		Row row = sheet.getRow(0);
		int numberOfCells = row.getPhysicalNumberOfCells();
		
		String testData[][]=new String [rowCount-1][numberOfCells];
		for (int i = 1; i <=rowCount-1; i++) {
			for(int j=0; j<numberOfCells; j++) {
				testData[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();	
			}
		}
			return testData;	
	
	}
	@BeforeTest
	public void beforetest() {
		launchBrave();
		maxWindow();
	}
	
	
	@AfterTest
	public void aftertest() {
		closeBrowser();
		System.out.println("Process Done..");
	}

	@Test(dataProvider="LoginDataProvider")
	public void loginHrLogin(String userN, String passW) {
		loadUrl("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys(userN);
		driver.findElement(By.id("txtPassword")).sendKeys(passW);
		driver.findElement(By.id("btnLogin")).click();
	}

}
