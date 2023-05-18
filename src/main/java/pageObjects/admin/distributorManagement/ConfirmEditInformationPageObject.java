package pageObjects.admin.distributorManagement;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminHomePageUI;

public class ConfirmEditInformationPageObject extends BasePage {
	private WebDriver driver;

	public ConfirmEditInformationPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public DistributorManagementPageObject clickCancelButton() {
		waitForElementClickable(driver, AdminHomePageUI.CANCEL_BUTTON);
		clickToElement(driver, AdminHomePageUI.CANCEL_BUTTON);
		return new DistributorManagementPageObject(driver);
	}

	public boolean isConfirmSuccessTextDisplayed() {
		waitForLoadingIconInvisible(driver);
		waitForElementVisible(driver, AdminHomePageUI.CONFIRM_SUCCESS_TEXT);
		return isElementDisplay(driver, AdminHomePageUI.CONFIRM_SUCCESS_TEXT);
	}
}
