package pageObjects.admin.order;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminHomePageUI;

public class OrderDetailPageObject extends BasePage {
	private WebDriver driver;

	public OrderDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickCancelButton() {
		waitForLoadingIconInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.CANCEL_ORDER_MODAL_SUCCESS_BUTTON);
		clickToElement(driver, AdminHomePageUI.CANCEL_ORDER_MODAL_SUCCESS_BUTTON);
	}

	public boolean isProcessingButtonDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.PROCESSING_BUTTON);
		return isElementDisplay(driver, AdminHomePageUI.PROCESSING_BUTTON);
	}

	public void clickApproveOrderButton() {
		waitForLoadingIconInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.APPROVE_BUTTON);
		clickToElement(driver, AdminHomePageUI.APPROVE_BUTTON);
	}

	public void clickRefuseOrderButton() {
		waitForElementClickable(driver, AdminHomePageUI.REFUSE_ORDER_BUTTON);
		clickToElement(driver, AdminHomePageUI.REFUSE_ORDER_BUTTON);
	}

	public void inputNoteText(String noteText) {
		waitForElementClickable(driver, AdminHomePageUI.NOTE_TEXT_AREA);
		sendKeyToElement(driver, AdminHomePageUI.NOTE_TEXT_AREA, noteText);
	}

	public void clickConfirmButton() {
		waitForElementClickable(driver, AdminHomePageUI.CONFIRM_BUTTON);
		clickToElement(driver, AdminHomePageUI.CONFIRM_BUTTON);
	}

	public boolean isFailureButtonDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.FAILURE_BUTTON);
		return isElementDisplay(driver, AdminHomePageUI.FAILURE_BUTTON);
	}

	public String getDistributorText() {
		waitForElementVisible(driver, AdminHomePageUI.DISTRIBUTOR_TEXT);
		return getElementText(driver, AdminHomePageUI.DISTRIBUTOR_TEXT);
	}

	public String getEnterNoteText() {
		waitForElementVisible(driver, AdminHomePageUI.ENTER_NOTE_TEXT);
		return getElementText(driver, AdminHomePageUI.ENTER_NOTE_TEXT);
	}

	public String getStoreText() {
		waitForElementVisible(driver, AdminHomePageUI.STORE_TEXT);
		return getElementText(driver, AdminHomePageUI.STORE_TEXT);
	}

	public String getProductNameText() {
		waitForElementVisible(driver, AdminHomePageUI.PRODUCT_NAME_TEXT);
		return getElementText(driver, AdminHomePageUI.PRODUCT_NAME_TEXT);
	}

    public void clickAddProductButton() {
		waitForLoadingIconInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.ADD_PRODUCT_IN_EDIT_ORDER_BUTTON);
		clickToElement(driver, AdminHomePageUI.ADD_PRODUCT_IN_EDIT_ORDER_BUTTON);
    }

	public void dragAndDropIcon() {
		waitForLoadingItemInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.HELP_DESK_ICON);
		dragAndDrop(driver, AdminHomePageUI.HELP_DESK_ICON, AdminHomePageUI.SELECT_ALL_TEXT);
	}

	public void clickCancelHelpdesk() {
		waitForElementClickable(driver, AdminHomePageUI.CANCEL_HELP_DESK);
		clickToElement(driver, AdminHomePageUI.CANCEL_HELP_DESK);
	}

	public void clickChooseProductTextbox() {
		waitForLoadingItemInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.CHOOSE_PRODUCT_CHECKBOX);
		clickToElement(driver, AdminHomePageUI.CHOOSE_PRODUCT_CHECKBOX);
	}

	public void clickAddButton() {
		waitForElementClickable(driver, AdminHomePageUI.ADD_BUTTON);
		clickToElement(driver, AdminHomePageUI.ADD_BUTTON);
	}

	public void clickChooseProductAddNewTextbox() {
		waitForLoadingItemInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.CHOOSE_PRODUCT_ADD_NEW_CHECKBOX);
		clickToElement(driver, AdminHomePageUI.CHOOSE_PRODUCT_ADD_NEW_CHECKBOX);
	}

	public void clickUpdateOrderButton() {
		waitForLoadingIconInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.UPDATE_ORDER_BUTTON);
		clickToElement(driver, AdminHomePageUI.UPDATE_ORDER_BUTTON);
	}
}
