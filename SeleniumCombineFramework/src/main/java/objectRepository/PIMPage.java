package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {
	public PIMPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Employee List")
	private WebElement EmployeeListButton;

	@FindBy(linkText = "Add Employee")
	private WebElement AddEmployeeButton;
	
	@FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]")
	private WebElement pimButton;

	public WebElement getPimButton() {
		return pimButton;
	}
	public WebElement getEmployeeListButton() {
		return EmployeeListButton;
	}
	public WebElement getAddEmployeeButton() {
		return AddEmployeeButton;
	}
	@FindBy(xpath = "//i[@class='oxd-icon bi-trash oxd-button-icon']")
	private WebElement YesdeleteButton;

	public WebElement getYesdeleteButton() {
		return YesdeleteButton;
	}

}
