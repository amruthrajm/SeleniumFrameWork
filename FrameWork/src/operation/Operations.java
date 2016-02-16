package operation;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Operations {

	WebDriver driver;
	public Operations(WebDriver driver){
		this.driver = driver;
	}
	
	
	ReadObject object = new ReadObject();
	
	public void Click(String repositoryFileName,String objectName,String objectType) throws Exception 
	{	
		driver.findElement(this.getObject(repositoryFileName,objectName,objectType)).click();
	}
	
	public void SetText(String repositoryFileName,String objectName,String objectType,String value) throws Exception 
	{
		driver.findElement(this.getObject(repositoryFileName,objectName,objectType)).sendKeys(value);	
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
