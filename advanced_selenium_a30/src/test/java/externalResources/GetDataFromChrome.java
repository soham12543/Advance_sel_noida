package externalResources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromChrome {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\TestNG Workspace\\advanced_selenium_a30\\src\\main\\resources\\commonData.properties");
		Properties pObj=new Properties();
		pObj.load(file);
		System.out.println(pObj.getProperty("lastNAME"));
		
		//How to write the data into the properties file.
		
		//Step4: By using setProperty() method write the data into Properties file
		pObj.setProperty("firstNAME", "VijayKumar");
	    
		//Step2 : By using store() method save the data
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Asus\\eclipse-workspace\\TestNG Workspace\\advanced_selenium_a30\\src\\main\\resources\\commonData.properties");
		pObj.store(fos, "Added first name in the common data");

	}

}
