package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	private WebElement UserDropdownIcon;
	@FindBy(linkText = "Logout")
	private WebElement LogoutButton;

	public WebElement getUserDropdownIcon() {
		return UserDropdownIcon;
	}

	public WebElement getLogoutButton() {
		return LogoutButton;
	}

	public void loggingOut() {
		getUserDropdownIcon().click();
		getLogoutButton().click();
	}

}
