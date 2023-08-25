package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage {
	public AddEmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	@FindBy(name = "firstName")
	private WebElement firstnametextfield;

	@FindBy(name = "lastName")
	private WebElement lastnametextfield;
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement EmployeeIdTextField;
	@FindBy(xpath = "//button[text()=' Save ']")
	private WebElement saveButton;
	public WebElement getFirstnametextfield() {
		return firstnametextfield;
	}
	public WebElement getLastnametextfield() {
		return lastnametextfield;
	}
	public WebElement getEmployeeIdTextField() {
		return EmployeeIdTextField;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//div[text()='1 jam']/../..//i[@class="oxd-icon bi-trash"]
	//div[text()='1 jam']/../..//i[@class="oxd-icon bi-check oxd-checkbox-input-icon"]

}
