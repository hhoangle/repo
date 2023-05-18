package pageObjects.marketingStaff.order;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.admin.order.CreateOrderPageObject;
import pageUIs.admin.AdminHomePageUI;
import pageUIs.marketingStaff.MarketingStaffHomePageUI;

public class AddOrderFromDistributorPageObject extends BasePage {
	private WebDriver driver;

	public AddOrderFromDistributorPageObject(WebDriver driver) {
		this.driver = driver;
	}

    public ListProductsPageObject clickAddOrderButton() {
		waitForElementVisible(driver, MarketingStaffHomePageUI.ADD_ORDER_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.ADD_ORDER_BUTTON);
		return new ListProductsPageObject(driver);
    }
}
