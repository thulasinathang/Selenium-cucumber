package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	public void loadProperties() {
		FileReader reader = null;
		try {
		 reader= new FileReader("configuration.properties");
		} catch (FileNotFoundException e) {
			System.out.println("Properties file not found");
			e.printStackTrace();
		}
		
		Properties prop=new Properties();
		try {
			prop.load(reader);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Constants.Browser=prop.getProperty("Browser");
		Constants.App_URL=prop.getProperty("App_URL");
		
	}

}
