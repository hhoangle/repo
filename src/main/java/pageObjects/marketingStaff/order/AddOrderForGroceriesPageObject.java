package pageObjects.marketingStaff.order;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.marketingStaff.MarketingStaffHomePageUI;

public class AddOrderForGroceriesPageObject extends BasePage {
	private WebDriver driver;

	public AddOrderForGroceriesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ListGroceriesPageObject clickAddOrderForGroceriesButton() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.ADD_ORDER_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.ADD_ORDER_BUTTON);
		return new ListGroceriesPageObject(driver);
	}

	public boolean isAddOrderTextDisplayed() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.ADD_ORDER_TEXT);
		return isElementDisplay(driver, MarketingStaffHomePageUI.ADD_ORDER_TEXT);
	}
}
