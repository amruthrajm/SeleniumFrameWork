package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import operation.ReadObject;
import operation.Operations;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelExportAndFileIO.ReadExcelFile;

public class HybridExecuteTest {
	
	WebDriver driver=new FirefoxDriver();
	  @BeforeTest
	  public void LaunchApp()
	  {
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  @Test
	public void setData() throws Exception {
		// TODO Auto-generated method stub
      
    	
    	
 
    	
       // ReadObject object = new ReadObject();
        //Properties allObjects =  object.getObjectRepository("allObject");
        Operations operation = new Operations(driver);
     //  WebDriver driver=operation.createBrowser();
       operation.GoToUrl("allObject", "url");
      	//Call perform function to perform operation on UI
        
    		//operation.perform("allObject", "", "", "GOTOURL", "url");
    	    
	}

  
//    @DataProvider(name="hybridData")
//	public ArrayList<String> getDataFromDataprovider() throws IOException{
//    	ReadExcelFile file = new ReadExcelFile();
//    	ArrayList<String> myStringList=new ArrayList<String>();
//         //Read keyword sheet
//         Sheet resdSheet = file.readExcel(System.getProperty("user.dir")+"\\","TestCase.xlsx" , "KeywordFramework");
//       //Find number of rows in excel file
//     	int rowCount = resdSheet.getLastRowNum()-resdSheet.getFirstRowNum();
//     	//object = new Object[rowCount][5];
//     	for (int i = 0; i < rowCount; i++) {
//   		//Loop over all the rows
//   		Row row = resdSheet.getRow(i+1);
// 		//Create a loop to print cell values in a row
//   		for (int j = 0; j < row.getLastCellNum(); j++) {
//   			//Print excel data in console
//   			myStringList.add(row.getCell(j).toString());
//   		
//   		}
//         
//    	}
//     	System.out.println("");
//     	  return myStringList;	 
//	}
}