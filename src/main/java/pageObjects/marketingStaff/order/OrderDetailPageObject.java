package pageObjects.marketingStaff.order;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminHomePageUI;
import pageUIs.marketingStaff.MarketingStaffHomePageUI;

public class OrderDetailPageObject extends BasePage {
	private WebDriver driver;

	public OrderDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductNameText() {
		waitForLoadingItemInvisible(driver);
		waitForElementVisible(driver, MarketingStaffHomePageUI.PRODUCT_NAME_TEXT);
		return getElementText(driver, MarketingStaffHomePageUI.PRODUCT_NAME_TEXT);
	}
}
