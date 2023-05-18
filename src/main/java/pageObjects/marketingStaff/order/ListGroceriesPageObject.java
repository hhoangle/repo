package pageObjects.marketingStaff.order;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.marketingStaff.MarketingStaffHomePageUI;

public class ListGroceriesPageObject extends BasePage {
	private WebDriver driver;

	public ListGroceriesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AddOrderFromDistributorPageObject clickCancelAddOrderButton() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.CANCEL_ADD_ORDER_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.CANCEL_ADD_ORDER_BUTTON);
		return new AddOrderFromDistributorPageObject(driver);
	}

	public void clickChooseProductButton() {
		waitForLoadingItemInvisible(driver);
		waitForElementVisible(driver, MarketingStaffHomePageUI.CHOOSE_PRODUCT_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.CHOOSE_PRODUCT_BUTTON);
	}

	public void clickCancelChooseProductButton() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.CANCEL_CHOOSE_PRODUCT_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.CANCEL_CHOOSE_PRODUCT_BUTTON);
	}

	public boolean isChooseProductButtonDisplayed() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.CHOOSE_PRODUCT_BUTTON);
		return isElementDisplay(driver, MarketingStaffHomePageUI.CHOOSE_PRODUCT_BUTTON);
	}

	public void inputSearchProduct(String product) {
		waitForElementVisible(driver, MarketingStaffHomePageUI.INPUT_SEARCH_PRODUCT);
		sendKeyToElement(driver, MarketingStaffHomePageUI.INPUT_SEARCH_PRODUCT, product);
	}

	public void clickTextboxChooseProduct() {
		waitForLoadingItemInvisible(driver);
		waitForElementVisible(driver, MarketingStaffHomePageUI.TEXT_BOX_CHOOSE_PRODUCT);
		clickToElement(driver, MarketingStaffHomePageUI.TEXT_BOX_CHOOSE_PRODUCT);
	}

	public void clickAddNewProductButton() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.ADD_NEW_PRODUCT_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.ADD_NEW_PRODUCT_BUTTON);
	}

	public void dragAndDropIcon() {
		waitForElementClickable(driver, MarketingStaffHomePageUI.HELP_DESK_ICON);
		dragAndDrop(driver, MarketingStaffHomePageUI.HELP_DESK_ICON, MarketingStaffHomePageUI.BELL_ICON);
	}

	public void clickAddUnitIcon() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.ADD_UNIT_ICON);
		clickToElement(driver, MarketingStaffHomePageUI.ADD_UNIT_ICON);
	}

	public void inputNumberOfBoxes(String numberOfBoxes) {
		waitForElementVisible(driver, MarketingStaffHomePageUI.NUMBER_OF_BOXES_INPUT);
		sendKeyToElement(driver, MarketingStaffHomePageUI.NUMBER_OF_BOXES_INPUT, numberOfBoxes);
	}

	public void inputNumberOfBags(String numberOfBags) {
		waitForElementVisible(driver, MarketingStaffHomePageUI.NUMBER_OF_BAGS_INPUT);
		sendKeyToElement(driver, MarketingStaffHomePageUI.NUMBER_OF_BAGS_INPUT, numberOfBags);
	}

	public void clickConfirmButton() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.CONFIRM_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.CONFIRM_BUTTON);
	}

	public OrderDetailPageObject clickDetailOrderButton() {
		waitForLoadingIconInvisible(driver);
		waitForElementVisible(driver, MarketingStaffHomePageUI.DETAIL_ORDER_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.DETAIL_ORDER_BUTTON);
		return new OrderDetailPageObject(driver);
	}

	public boolean isPriceTextDisplayed() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.PRICE_VALUE);
		return isElementDisplay(driver, MarketingStaffHomePageUI.PRICE_VALUE);
	}

	public void clickPriceText() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.PRICE_TEXT);
		clickToElement(driver, MarketingStaffHomePageUI.PRICE_TEXT);
	}

	public AddOrderFromDistributorPageObject clickListOrderButton() {
		waitForLoadingIconInvisible(driver);
		waitForElementVisible(driver, MarketingStaffHomePageUI.LIST_ORDER_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.LIST_ORDER_BUTTON);
		return new AddOrderFromDistributorPageObject(driver);
	}

	public ChooseOneGroceryPageObject clickChooseOneGroceryButton() {
		waitForLoadingIconInvisible(driver);
		waitForElementVisible(driver, MarketingStaffHomePageUI.CHOOSE_ONE_GROCERY_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.CHOOSE_ONE_GROCERY_BUTTON);
		return new ChooseOneGroceryPageObject(driver);
	}
}
