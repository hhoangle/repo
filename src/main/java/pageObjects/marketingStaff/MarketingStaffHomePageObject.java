package pageObjects.marketingStaff;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.marketingStaff.order.OrderHomePageObject;
import pageUIs.marketingStaff.MarketingStaffHomePageUI;

public class MarketingStaffHomePageObject extends BasePage {
	private WebDriver driver;

	public MarketingStaffHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public OrderHomePageObject clickOrderButton() {
		waitForLoadingIconInvisible(driver);
		waitForElementClickable(driver, MarketingStaffHomePageUI.ORDER_BUTTON);
		clickToElement(driver, MarketingStaffHomePageUI.ORDER_BUTTON);
		return new OrderHomePageObject(driver);
	}
}
