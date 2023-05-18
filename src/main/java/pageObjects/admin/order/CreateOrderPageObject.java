package pageObjects.admin.order;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminHomePageUI;

public class CreateOrderPageObject extends BasePage {
	private WebDriver driver;

	public CreateOrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public OrderHomePageObject clickCancelButton() {
		waitForElementClickable(driver, AdminHomePageUI.CANCEL_BUTTON);
		clickToElement(driver, AdminHomePageUI.CANCEL_BUTTON);
		return new OrderHomePageObject(driver);
	}

	public void clickChooseStoreButton() {
		waitForElementVisible(driver, AdminHomePageUI.CHOOSE_STORE_BUTTON);
		clickToElement(driver, AdminHomePageUI.CHOOSE_STORE_BUTTON);
	}

	public void clickSelectStore() {
		waitForElementVisible(driver, AdminHomePageUI.STORE_INPUT_VALUE);
		clickToElement(driver, AdminHomePageUI.STORE_INPUT_VALUE);
	}

	public void clickChooseProductButton() {
		waitForElementClickable(driver, AdminHomePageUI.CHOOSE_PRODUCT_IN_STOCK_BUTTON);
		clickToElement(driver, AdminHomePageUI.CHOOSE_PRODUCT_IN_STOCK_BUTTON);
	}

	public void clickChooseProductTextbox() {
		waitForLoadingItemInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.CHOOSE_PRODUCT_CHECKBOX);
		clickToElement(driver, AdminHomePageUI.CHOOSE_PRODUCT_CHECKBOX);
	}

	public void clickCancelProductButton() {
		waitForElementClickable(driver, AdminHomePageUI.CANCEL_PRODUCT_BUTTON);
		clickToElement(driver, AdminHomePageUI.CANCEL_PRODUCT_BUTTON);
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

	public void clickAddButton() {
		waitForElementClickable(driver, AdminHomePageUI.ADD_BUTTON);
		clickToElement(driver, AdminHomePageUI.ADD_BUTTON);
	}

	public void clickDistributorInput() {
		waitForElementClickable(driver, AdminHomePageUI.DISTRIBUTOR_INPUT);
		clickToElement(driver, AdminHomePageUI.DISTRIBUTOR_INPUT);
	}

	public void clickSelectDistributor() {
		waitForLoadingItemInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.SELECT_DISTRIBUTOR_DROPDOWN);
		clickToElement(driver, AdminHomePageUI.SELECT_DISTRIBUTOR_DROPDOWN);
	}

	public void clickCreateOrderButton() {
		waitForElementClickable(driver, AdminHomePageUI.CREATE_ORDER_BUTTON);
		clickToElement(driver, AdminHomePageUI.CREATE_ORDER_BUTTON);
	}

	public void clickListPageButton() {
		waitForLoadingItemInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.LIST_PAGE_BUTTON);
		clickToElement(driver, AdminHomePageUI.LIST_PAGE_BUTTON);
	}

	public OrderDetailPageObject clickViewDetailOrderButton() {
		waitForLoadingIconInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.VIEW_DETAIL_ORDER_BUTTON);
		clickToElement(driver, AdminHomePageUI.VIEW_DETAIL_ORDER_BUTTON);
		return new OrderDetailPageObject(driver);
	}
}
