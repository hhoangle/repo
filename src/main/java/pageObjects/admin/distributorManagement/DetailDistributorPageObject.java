package pageObjects.admin.distributorManagement;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminHomePageUI;
import pageUIs.npp.NppOrderPageUI;

import static commons.GlobalConstants.SHORT_TIMEOUT;

public class DetailDistributorPageObject extends BasePage {
	private WebDriver driver;

	public DetailDistributorPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public EditInformationPageObject clickEditDistributorButton() {
		waitForElementClickable(driver, AdminHomePageUI.EDIT_DISTRIBUTOR_BUTTON);
		clickToElement(driver, AdminHomePageUI.EDIT_DISTRIBUTOR_BUTTON);
		return new EditInformationPageObject(driver);
	}

    public void clickStaffTab() {
		waitForElementClickable(driver, AdminHomePageUI.STAFF_TAB_IN_DISTRIBUTOR_DETAIL);
		clickToElement(driver, AdminHomePageUI.STAFF_TAB_IN_DISTRIBUTOR_DETAIL);
    }

	public void clickAddNewStaffButton() {
		waitForLoadingIconInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.ADD_NEW_STAFF_BUTTON);
		clickToElement(driver, AdminHomePageUI.ADD_NEW_STAFF_BUTTON);
	}

	public void inputSearchStaff(String name) {
		sleepInSecond(SHORT_TIMEOUT);
		waitForElementClickable(driver, AdminHomePageUI.SEARCH_STAFF_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.SEARCH_STAFF_INPUT, name);
		waitForLoadingItemInvisible(driver);
	}

	public void clickSelectStaffCheckbox(String name) {
		waitForLoadingItemInvisible(driver);
		scrollToElement(driver, AdminHomePageUI.SELECT_STAFF_CHECKBOX, name);
		waitForElementClickable(driver, AdminHomePageUI.SELECT_STAFF_CHECKBOX, name);
		clickToElement(driver, AdminHomePageUI.SELECT_STAFF_CHECKBOX, name);
	}

	public void clickAddStaffButtonInModal() {
		waitForElementClickable(driver, AdminHomePageUI.ADD_STAFF_BUTTON_IN_MODAL);
		clickToElement(driver, AdminHomePageUI.ADD_STAFF_BUTTON_IN_MODAL);
	}

	public void clickCloseModalButton() {
		waitForLoadingIconInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.CLOSE_MODAL_BUTTON);
		clickToElement(driver, AdminHomePageUI.CLOSE_MODAL_BUTTON);
	}

	public void dragAndDropIcon() {
		waitForElementClickable(driver, AdminHomePageUI.HELP_DESK_ICON);
		dragAndDrop(driver, AdminHomePageUI.HELP_DESK_ICON, AdminHomePageUI.BELL_ICON);
	}
}
