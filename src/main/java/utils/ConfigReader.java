package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public Properties intializeProperties(){
		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\config\\config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
}
