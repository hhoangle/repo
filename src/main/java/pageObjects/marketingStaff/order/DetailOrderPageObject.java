package pageObjects.marketingStaff.order;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.marketingStaff.MarketingStaffHomePageUI;

public class DetailOrderPageObject extends BasePage {
	private WebDriver driver;

	public DetailOrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductNameText() {
		waitForLoadingItemInvisible(driver);
		waitForElementVisible(driver, MarketingStaffHomePageUI.PRODUCT_NAME_TEXT);
		return getElementText(driver, MarketingStaffHomePageUI.PRODUCT_NAME_TEXT);
	}
}
