package pageObjects.admin.distributorManagement;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.admin.userManagement.UserManagementHomePageObject;
import pageUIs.admin.AdminHomePageUI;

public class CreateAccountDistributorPageObject extends BasePage {
	private WebDriver driver;

	public CreateAccountDistributorPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCreateUserTextDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.CREATE_USER_TEXT);
		return isElementDisplay(driver, AdminHomePageUI.CREATE_USER_TEXT);
	}

	public CreateInformationDistributorPageObject clickBackButton() {
		waitForElementClickable(driver, AdminHomePageUI.BACK_BUTTON);
		clickToElement(driver, AdminHomePageUI.BACK_BUTTON);
		return new CreateInformationDistributorPageObject(driver);
	}

    public void inputToAccountDistributor(String accountDistributor) {
		waitForElementVisible(driver, AdminHomePageUI.ACCOUNT_DISTRIBUTOR_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.ACCOUNT_DISTRIBUTOR_INPUT_TEXT, accountDistributor);
    }

	public void inputToPassWordDistributor(String passwordDistributor) {
		waitForElementVisible(driver, AdminHomePageUI.PASSWORD_DISTRIBUTOR_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.PASSWORD_DISTRIBUTOR_INPUT_TEXT, passwordDistributor);
	}

	public void inputToEmailDistributor(String emailDistributor) {
		waitForElementVisible(driver, AdminHomePageUI.EMAIL_DISTRIBUTOR_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.EMAIL_DISTRIBUTOR_INPUT_TEXT, emailDistributor);
	}

	public void clickCreateButton() {
		waitForElementClickable(driver, AdminHomePageUI.CREATE_BUTTON);
		clickToElement(driver, AdminHomePageUI.CREATE_BUTTON);
	}

	public void closeModalErrorButton() {
		waitForElementClickable(driver, AdminHomePageUI.CLOSE_MODAL_BUTTON);
		clickToElement(driver, AdminHomePageUI.CLOSE_MODAL_BUTTON);
	}

	public UserManagementHomePageObject clickToBackCreateDistributorPageButton() {
		waitForLoadingIconInvisible(driver);
		clickToElement(driver, AdminHomePageUI.BACK_TO_MANAGEMENT_HOME_PAGE_BUTTON);
		return new UserManagementHomePageObject(driver);
	}

	public boolean isModalErrorDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.MODAL_ERROR);
		return isElementDisplay(driver, AdminHomePageUI.MODAL_ERROR);
	}

	public String getErrorMessageAccountDistributor() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_ACCOUNT);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_ACCOUNT);
	}

	public String getErrorMessagePassWordDistributor() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_PASSWORD);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_PASSWORD);
	}

	public String getErrorMessageEmailDistributor() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_EMAIL);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_EMAIL);
	}
}
