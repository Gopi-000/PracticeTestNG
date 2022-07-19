package interview.questions;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import reuse.methods.LilGlobal;

public class TakingScreensnap extends LilGlobal{
	@Test
	private void screenSnap() throws IOException {
		launchBrave();
		maxWindow();
		loadUrl("https://www.facebook.com/");
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File("G://test.png");
		FileUtils.copyFile(sourcefile, destinationfile);
		//FileHandler.copy(sourcefile, destinationfile);
		closeBrowser();
	}

	@Test
	private void fullScreenSnap() throws Exception {
		launchBrave();
		maxWindow();
		loadUrl("https://www.facebook.com/");
		Robot robot = new Robot();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(screenSize);
		BufferedImage origfile = robot.createScreenCapture(rect);
		File targetfile = new File("G://fullsnap.jpeg");
		ImageIO.write(origfile, "jpeg", targetfile);
	}
	
}
