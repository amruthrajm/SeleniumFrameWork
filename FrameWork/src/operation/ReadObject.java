package operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadObject {

	Properties allProperties = new Properties();
 
	public Properties getObjectRepository(String fileName) throws IOException{
		//Read object repository file
		InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\objects\\"+fileName+".properties"));
		//load all objects
		System.out.println(System.getProperty("user.dir")+"\\src\\objects\\"+fileName+".properties");
		
		allProperties.load(stream);
		 return allProperties;
	}
	
}
