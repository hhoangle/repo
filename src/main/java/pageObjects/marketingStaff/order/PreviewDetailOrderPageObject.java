package pageObjects.marketingStaff.order;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.marketingStaff.MarketingStaffHomePageUI;

public class PreviewDetailOrderPageObject extends BasePage {
	private WebDriver driver;

	public PreviewDetailOrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductNameText() {
		waitForLoadingItemInvisible(driver);
		waitForElementVisible(driver, MarketingStaffHomePageUI.PRODUCT_NAME_TEXT);
		return getElementText(driver, MarketingStaffHomePageUI.PRODUCT_NAME_TEXT);
	}

	public void clickCompletedButton() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.COMPLETED_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.COMPLETED_BUTTON);
	}

	public DetailOrderPageObject clickDetailOrderButton() {
		waitForLoadingIconInvisible(driver);
		waitForElementVisible(driver, MarketingStaffHomePageUI.DETAIL_ORDER_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.DETAIL_ORDER_BUTTON);
		return new DetailOrderPageObject(driver);
	}

	public AddOrderForGroceriesPageObject clickListOrderButton() {
		waitForLoadingIconInvisible(driver);
		waitForElementVisible(driver, MarketingStaffHomePageUI.LIST_ORDER_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.LIST_ORDER_BUTTON);
		return new AddOrderForGroceriesPageObject(driver);
	}

	public ChooseOneGroceryPageObject clickEditOrderButton() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.EDIT_ORDER_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.EDIT_ORDER_BUTTON);
		return new ChooseOneGroceryPageObject(driver);
	}
}
