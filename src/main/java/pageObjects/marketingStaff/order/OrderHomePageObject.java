package pageObjects.marketingStaff.order;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.marketingStaff.MarketingStaffHomePageUI;

public class OrderHomePageObject extends BasePage {
	private WebDriver driver;

	public OrderHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AddOrderFromDistributorPageObject clickAddOrderFromDistributor() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.ADD_ORDER_FROM_DISTRIBUTOR_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.ADD_ORDER_FROM_DISTRIBUTOR_BUTTON);
		return new AddOrderFromDistributorPageObject(driver);
	}

    public AddOrderForGroceriesPageObject clickAddOrderForGroceries() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.ADD_ORDER_FOR_GROCERIES_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.ADD_ORDER_FOR_GROCERIES_BUTTON);
		return new AddOrderForGroceriesPageObject(driver);
    }
}
