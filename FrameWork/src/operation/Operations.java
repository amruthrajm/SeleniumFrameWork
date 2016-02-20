package operation;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Throwables;


public class Operations {
	 SoftAssert softAssert=new SoftAssert();
	 CommonLibrary commonLib=new CommonLibrary();
	 WebDriver driver;
	 
public Operations(WebDriver driver){
		this.driver = driver;
	}
	
	
	ReadObject object = new ReadObject();
	
	public void Click(String repositoryFileName,String objectName,String objectType) throws Exception 
	{	
	try{
	
		driver.findElement(this.getObject(repositoryFileName,objectName,objectType)).click();
		Reporter.log("<br><B>Passed,  click done, having objectName-"+objectName+",with Type-"+objectType+"</B></br>", true);
	
	} 
	catch (Exception e)
	{
		String stackTrace = Throwables.getStackTraceAsString(e);
		 softAssert.assertTrue(false);
	//	Assert.assertTrue(false, " click operation failed");
//		File file=new File(commonFunctionsObject.takeScreenshot(driver));
		commonLib.reportLogScreenshot(new File(commonLib.takeScreenshot(driver)),"<p>click operation Failed, object Details RepositoryName-"+repositoryFileName+", objectName-"+objectName+",with Type-"+objectType+"</p>");	
		
		Reporter.log("Error Details:- "+stackTrace.split("sun.reflect")[0]);//trim the unwanted error details and report it
	}
		
	}
	//performs the SetTex operation for web edit or input fields
	public void SetText(String repositoryFileName,String objectName,String objectType,String value) throws Exception 
	{
		try
		{
			driver.findElement(this.getObject(repositoryFileName,objectName,objectType)).sendKeys(value);
			Reporter.log("<br><B>Passed,  Set Text done, having objectName-"+objectName+",with Type-"+objectType+" , value-"+value+"</B></br>", true);
		}
		catch (Exception e)
		{		 
			String stackTrace = Throwables.getStackTraceAsString(e);
			 softAssert.assertTrue(false);
			// e.printStackTrace();
			commonLib.reportLogScreenshot(new File(commonLib.takeScreenshot(driver)),"<br>Failed, Set operation failed,object not found having repository-"+repositoryFileName+", objectName-"+objectName+",with Type-"+objectType+"</br>");	
			Reporter.log("Error Details:- "+stackTrace.split("sun.reflect")[0]);
		}
		
			
	}
	
	public void GoToUrl(String repositoryFileName,String urlKeyName) throws IOException
	{
		Properties allObjects =  object.getObjectRepository(repositoryFileName);
		driver.get(allObjects.getProperty(urlKeyName));
	}
	
	public String GetText(String repositoryFileName,String objectName,String objectType) throws Exception
	{
		//Get text of an element
	return	driver.findElement(this.getObject(repositoryFileName,objectName,objectType)).getText();
	}
	
	public void reportErrors()
	{
		softAssert.assertAll();	
	}
	
	/**
	 * Find element BY using object type and value
	 * @param p
	 * @param objectName
	 * @param objectType
	 * @return
	 * @throws Exception
	 */
	private By getObject(String repositoryFileName,String objectName,String objectType) throws Exception{
		//Find by xpath
		Properties allObjects =  object.getObjectRepository(repositoryFileName);
		if(objectType.equalsIgnoreCase("XPATH")){
			
			return By.xpath(allObjects.getProperty(objectName));
		}
		//find by class
		else if(objectType.equalsIgnoreCase("CLASSNAME")){
			
			return By.className(allObjects.getProperty(objectName));
			
		}
		//find by name
		else if(objectType.equalsIgnoreCase("NAME")){
			
			return By.name(allObjects.getProperty(objectName));
			
		}
		else if(objectType.equalsIgnoreCase("ID")){
			
			return By.id(allObjects.getProperty(objectName));
			
		}
		//Find by css
		else if(objectType.equalsIgnoreCase("CSS")){
			
			return By.cssSelector(allObjects.getProperty(objectName));
			
		}
		//find by link
		else if(objectType.equalsIgnoreCase("LINK")){
			
			return By.linkText(allObjects.getProperty(objectName));
			
		}
		//find by partial link
		else if(objectType.equalsIgnoreCase("PARTIALLINK")){
			
			return By.partialLinkText(allObjects.getProperty(objectName));
			
		}else
		{
			throw new Exception("Wrong object type");
		}
	}
	
}
