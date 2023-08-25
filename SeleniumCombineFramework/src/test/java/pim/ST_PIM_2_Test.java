package pim;

import org.testng.annotations.Test;

import generics.BaseClass;
import generics.ExcelUtility;
//@Listeners(ListnerImplementation.class)
public class ST_PIM_2_Test extends BaseClass {
	@Test(dataProvider = "testdata",dataProviderClass = ExcelUtility.class)
	public void Creating_an_employee_with_valid_details(String Firstname,String LastName,String d) throws InterruptedException {
		pimpage.getPimButton().click();
		pimpage.getAddEmployeeButton().click();
		addemployeepage.getFirstnametextfield().sendKeys(Firstname);
		addemployeepage.getLastnametextfield().sendKeys(LastName);
		addemployeepage.getEmployeeIdTextField().sendKeys("EMPID");
		utility.clickingOnElement(driver, addemployeepage.getSaveButton());		
	
	
	}
}
