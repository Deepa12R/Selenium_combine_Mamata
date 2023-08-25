package generics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility extends BaseClass implements IAutoConstants{
	public String takingScreenshot(String screenshotname) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File photo = ts.getScreenshotAs(OutputType.FILE);
		String path=DIRECTORY+SSPATH+screenshotname+" "+TIME+".png";
		System.out.println(path);
		File file=new File(path);
		try {
			FileUtils.copyFile(photo, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
