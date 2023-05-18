package pageObjects.marketingStaff.order;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.marketingStaff.MarketingStaffHomePageUI;

import static commons.GlobalConstants.SHORT_TIMEOUT;

public class ChooseOneGroceryPageObject extends BasePage {
	private WebDriver driver;

	public ChooseOneGroceryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AddOrderForGroceriesPageObject clickCancelAddOrderButton() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.CANCEL_ADD_ORDER_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.CANCEL_ADD_ORDER_BUTTON);
		return new AddOrderForGroceriesPageObject(driver);
	}

	public void inputNoteArea(String note) {
		waitForElementVisible(driver, MarketingStaffHomePageUI.NOTE_AREA_INPUT);
		sendKeyToElement(driver, MarketingStaffHomePageUI.NOTE_AREA_INPUT, note);
	}

	public void clickChooseProductToOrderButton() {
		waitForLoadingItemInvisible(driver);
		waitForElementVisible(driver, MarketingStaffHomePageUI.CHOOSE_PRODUCT_TO_ORDER_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.CHOOSE_PRODUCT_TO_ORDER_BUTTON);
	}

	public void inputSearchProduct(String product) {
		sleepInSecond(SHORT_TIMEOUT);
		waitForElementVisible(driver, MarketingStaffHomePageUI.INPUT_SEARCH_PRODUCT);
		sendKeyToElement(driver, MarketingStaffHomePageUI.INPUT_SEARCH_PRODUCT, product);
	}

	public void dragAndDropIcon() {
		waitForElementClickable(driver, MarketingStaffHomePageUI.HELP_DESK_ICON);
		dragAndDrop(driver, MarketingStaffHomePageUI.HELP_DESK_ICON, MarketingStaffHomePageUI.BELL_ICON);
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

	public void clickAddUnitIcon() {
		scrollToElement(driver, MarketingStaffHomePageUI.ADD_UNIT_ICON);
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

	public PreviewDetailOrderPageObject clickConfirmButton() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.CONFIRM_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.CONFIRM_BUTTON);
		return new PreviewDetailOrderPageObject(driver);
	}

	public void clickEditChooseProductToOrderButton() {
		waitForLoadingItemInvisible(driver);
		waitForElementVisible(driver, MarketingStaffHomePageUI.EDIT_CHOOSE_PRODUCT_TO_ORDER_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.EDIT_CHOOSE_PRODUCT_TO_ORDER_BUTTON);
	}
}
