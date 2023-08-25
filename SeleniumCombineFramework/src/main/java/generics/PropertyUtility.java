package generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility implements IAutoConstants{
	/**
	 * This method is used to read data from property file
	 * @param key
	 * @return
	 */
	public String readingDataFromProprtyFile(String key) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(PROPERTYFILEPATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties ppt=new Properties();
		try {
			ppt.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  ppt.getProperty(key);

	}
}
