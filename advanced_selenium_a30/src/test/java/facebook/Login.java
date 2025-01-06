package facebook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Login {

	public static void main(String[] args) throws IOException 
	{
		//step1: get the java representation object of the physical file
		//step2: by using properties class load all the keys
		//step3: by using getProperty() method fetch all the methods
		
	   FileInputStream file=new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\TestNG Workspace\\advanced_selenium_a30\\src\\main\\resources\\commonData.properties");
	   Properties pObj=new Properties();
	   pObj.load(file);
	   System.out.println(pObj.getProperty("bro")); //String return type
	   System.out.println(pObj.getProperty("url"));
	   System.out.println(pObj.getProperty("un"));
	   System.out.println(pObj.getProperty("pwd"));
	}

}
