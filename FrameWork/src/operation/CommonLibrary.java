package operation;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonLibrary {

	
	public  WebDriver createBrowser() {
		WebDriver driver=new FirefoxDriver();
		return driver;
	}
	//finds unique number
	public String uniqueNumber(){
		  String tempUniqueNumber,currentDate;
		  Date TodayDate=new Date();
		  DateFormat getDate=new SimpleDateFormat("ddmmyyyy");
		  currentDate=getDate.format(new Date());
		  tempUniqueNumber=currentDate+TodayDate.getTime();
		  return tempUniqueNumber;
	  }
	
	 public String takeScreenshot(WebDriver driver) {
		  String workingDirectory = System.getProperty("user.dir");
		  String fileName = workingDirectory + File.separator + "screenshots" + File.separator  + "screenshot"+uniqueNumber()+".png";//filename
		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		  try {
			  FileUtils.copyFile(scrFile, new File(fileName ));
			  } catch (IOException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
			  }
		  return fileName;
	  }
	 
	 
	 public String takeObjectScreenShot(WebDriver driver,WebElement element)
	 	{
		 String workingDirectory = System.getProperty("user.dir");
		  String fileName = workingDirectory + File.separator + "screenshots" + File.separator  + "screenshot"+uniqueNumber()+".png";//filename
		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		  try {
			  BufferedImage fullImg=ImageIO.read(scrFile);
			  org.openqa.selenium.Point point=element.getLocation();
			//Get width and height of the element
			  int eleWidth = element.getSize().getWidth();
			  int eleHeight = element.getSize().getHeight();
			//Crop the entire page screenshot to get only element screenshot
			  BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth,
			      eleHeight);
			  ImageIO.write(eleScreenshot, "png", scrFile);
			  FileUtils.copyFile(scrFile, new File(fileName ));
			  } catch (IOException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
			  }
		  return fileName;
	 	}
	 
	public void  genarateRandomNumber()
	{
		Random tempRan=new Random();
		
		System.out.println(tempRan.nextInt());
	}
	
}
