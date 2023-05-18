package pageObjects.admin.userManagement;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.admin.AdminHomePageObject;
import pageUIs.admin.AdminHomePageUI;

public class CreateAccountMarketingStaffPageObject extends BasePage {
	private WebDriver driver;

	public CreateAccountMarketingStaffPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isAccountMarketingStaffTextDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.ACCOUNT_IN_USER_MANAGEMENT_TEXT);
		return isElementDisplay(driver, AdminHomePageUI.ACCOUNT_IN_USER_MANAGEMENT_TEXT);
	}

	public void closeModalErrorButton() {
		waitForElementClickable(driver, AdminHomePageUI.CLOSE_MODAL_BUTTON);
		clickToElement(driver, AdminHomePageUI.CLOSE_MODAL_BUTTON);
	}

	public UserManagementHomePageObject clickToUserManagementHomePageButton() {
		waitForLoadingIconInvisible(driver);
		clickToElement(driver, AdminHomePageUI.BACK_TO_MANAGEMENT_HOME_PAGE_BUTTON);
		return new UserManagementHomePageObject(driver);
	}

	public boolean isModalErrorDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.MODAL_ERROR);
		return isElementDisplay(driver, AdminHomePageUI.MODAL_ERROR);
	}

	public void inputToAccountMarketingStaff(String account) {
		waitForElementVisible(driver, AdminHomePageUI.ACCOUNT_IN_USER_MANAGEMENT_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.ACCOUNT_IN_USER_MANAGEMENT_INPUT_TEXT, account);
	}

	public void inputToPassWordMarketingStaff(String password) {
		waitForElementVisible(driver, AdminHomePageUI.PASSWORD_IN_USER_MANAGEMENT_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.PASSWORD_IN_USER_MANAGEMENT_INPUT_TEXT, password);
	}

	public void inputToEmailMarketingStaff(String email) {
		waitForElementVisible(driver, AdminHomePageUI.EMAIL_IN_USER_MANAGEMENT_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.EMAIL_IN_USER_MANAGEMENT_INPUT_TEXT, email);
	}

	public void clickCreateMarketingStaffButton() {
		waitForElementClickable(driver, AdminHomePageUI.CREATE_IN_USER_MANAGEMENT_BUTTON);
		clickToElement(driver, AdminHomePageUI.CREATE_IN_USER_MANAGEMENT_BUTTON);
	}

	public String getErrorMessageAccountMarketingStaff() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_ACCOUNT);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_ACCOUNT);
	}

	public String getErrorMessagePassWordMarketingStaff() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_PASSWORD);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_PASSWORD);
	}

	public String getErrorMessageEmailMarketingStaff() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_EMAIL);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_EMAIL);
	}
}
