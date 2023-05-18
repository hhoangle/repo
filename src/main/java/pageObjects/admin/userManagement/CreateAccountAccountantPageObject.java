package pageObjects.admin.userManagement;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminHomePageUI;

public class CreateAccountAccountantPageObject extends BasePage {
	private WebDriver driver;

	public CreateAccountAccountantPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isAccountAccountantTextDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.ACCOUNT_ACCOUNTANT_TEXT);
		return isElementDisplay(driver, AdminHomePageUI.ACCOUNT_ACCOUNTANT_TEXT);
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

	public void inputToAccount(String account) {
		waitForElementVisible(driver, AdminHomePageUI.ACCOUNT_IN_USER_MANAGEMENT_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.ACCOUNT_IN_USER_MANAGEMENT_INPUT_TEXT, account);
	}

	public void inputToPassWord(String password) {
		waitForElementVisible(driver, AdminHomePageUI.PASSWORD_IN_USER_MANAGEMENT_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.PASSWORD_IN_USER_MANAGEMENT_INPUT_TEXT, password);
	}

	public void inputToEmail(String email) {
		waitForElementVisible(driver, AdminHomePageUI.EMAIL_IN_USER_MANAGEMENT_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.EMAIL_IN_USER_MANAGEMENT_INPUT_TEXT, email);
	}

	public void clickCreateAccountantButton() {
		waitForElementClickable(driver, AdminHomePageUI.CREATE_IN_USER_MANAGEMENT_BUTTON);
		clickToElement(driver, AdminHomePageUI.CREATE_IN_USER_MANAGEMENT_BUTTON);
	}

	public String getErrorMessageAccount() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_ACCOUNT);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_ACCOUNT);
	}

	public String getErrorMessagePassWordMarketingStaff() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_PASSWORD);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_PASSWORD);
	}

	public String getErrorMessageEmail() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_EMAIL);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_EMAIL);
	}
}
