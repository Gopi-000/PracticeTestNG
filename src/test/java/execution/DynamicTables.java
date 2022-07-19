package execution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import reuse.methods.LilGlobal;

public class DynamicTables extends LilGlobal{
	
	private void table() {
		launchBrave();
		maxWindow();
		loadUrl("http://www.leafground.com/pages/table.html");
		
		//find no of columns
		List<WebElement> columnCount = driver.findElements(By.tagName("th"));
		int totalColumn = columnCount.size();
		System.out.println("Total no of Columns: "+totalColumn);
		
		//find no of rows
		List<WebElement> rowCount = driver.findElements(By.tagName("tr"));
		int totalRow = rowCount.size();
		System.out.println("Total no of rows: "+totalRow);
		
		//find the progress percent near a table data
		List<WebElement> totalProgress = driver.findElements(By.xpath("//td[normalize-space()='Learn to interact with Elements']//following::td[1]"));
		int totalsize = totalProgress.size();
		System.out.println("There are total "+totalsize+" values in same name.");
		System.out.println("They Are:");
		for (int i = 1; i <= totalsize; i++) {
			WebElement percentage = driver.findElement(By.xpath("(//td[normalize-space()='Learn to interact with Elements']//following::td[1])["+i+"]"));
			String percent = percentage.getText();
			System.out.println(percent);
		}
		
		//click the lowest progress box
		List<WebElement> allProgress = driver.findElements(By.xpath("//td[2]"));
		List<Integer> numberList = new ArrayList<Integer>();
		for (WebElement value : allProgress) {
			String individualNo = value.getText().replace("%", "");
			numberList.add(Integer.parseInt(individualNo));
			
		}
		System.out.println("the final list is "+numberList);
		
		//identfying smallest number 
		int min = Collections.min(numberList);
		System.out.println("The smallest value is: "+min);
		
		//checking the smallest no checkbox
		String stringMin = Integer.toString(min);
		String finalXpath = "//td[normalize-space()='"+stringMin+"%']//following::td[1]";
		WebElement checkbox = driver.findElement(By.xpath(finalXpath));
		checkbox.click();
		closeBrowser();
		
		
	}
	
	public static void main(String[] args) {
		DynamicTables dt = new DynamicTables();
		dt.table();
	}
	
	
	
}
