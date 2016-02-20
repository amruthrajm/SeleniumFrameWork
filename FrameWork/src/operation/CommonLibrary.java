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
import org.testng.Reporter;

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
	 
	 
	 public File takeObjectScreenShot(WebDriver driver,WebElement element)
	 	{
		 String workingDirectory = System.getProperty("user.dir");
		 System.setProperty("org.uncommons.reportng.escape-output", "false");
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
		  return scrFile;
	 	}
	 
	public void  genarateRandomNumber()
	{
		Random tempRan=new Random();
		
		System.out.println(tempRan.nextInt());
	}
	
	protected void reportLogScreenshot(File file, String reportMessage) {
	      System.setProperty("org.uncommons.reportng.escape-output", "false");  
//	      String absolute = file.getAbsolutePath();
//	      int beginIndex = absolute.indexOf(".");
//	      String relative = absolute.substring(beginIndex).replace(".\\","");
//	      String screenShot = relative.replace('\\','/');
    Reporter.log("<a href=\"" + file  + "\">  <u>"+reportMessage+"</u> "+ "--- "+ new Date()+ "</a>" );  
	     // Reporter.log("<a href=\"" + file + "\">"+reportMessage+"<p align=\"left\"> " + "---- "+ new Date()+ "</p>");
//	      Reporter.log("<p><img width=\"512\" src=\"" + file.getAbsoluteFile()  + "\" alt=\"screenshot at " + new Date()+ "\"/></p></a><br />"); 
	}
	
}
