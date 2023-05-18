package pageObjects.admin.product;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminHomePageUI;

public class ProductHomePageObject extends BasePage {
	private WebDriver driver;

	public ProductHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductWareHouseTextDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.PRODUCT_WAREHOUSE_TEXT);
		return isElementDisplay(driver, AdminHomePageUI.PRODUCT_WAREHOUSE_TEXT);
	}

		public CreateProductPageObject clickAddNewProductButton() {
		waitForElementClickable(driver, AdminHomePageUI.ADD_NEW_PRODUCT_BUTTON);
		clickToElement(driver, AdminHomePageUI.ADD_NEW_PRODUCT_BUTTON);
		return new CreateProductPageObject(driver);
	}

	public boolean productNameDisplayed(String productName) {
		waitForElementVisible(driver, AdminHomePageUI.PRODUCT_NAME, productName);
		return isElementDisplay(driver, AdminHomePageUI.PRODUCT_NAME, productName);
	}

    public ProductDetailPageObject clickViewProduct() {
		waitForLoadingItemInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.PRODUCT_DETAIL);
		clickToElement(driver, AdminHomePageUI.PRODUCT_DETAIL);
		return new ProductDetailPageObject(driver);
    }

    public boolean isProductStatusInactiveTextDisplayed(String productStatusInactiveText) {
		waitForElementVisible(driver, AdminHomePageUI.PRODUCT_STATUS_INACTIVE_TEXT, productStatusInactiveText);
		return isElementDisplay(driver, AdminHomePageUI.PRODUCT_STATUS_INACTIVE_TEXT, productStatusInactiveText);
    }

	public void clickInactiveButton() {
		waitForElementClickable(driver, AdminHomePageUI.INFO_PRODUCT_INACTIVE_BUTTON);
		clickToElement(driver, AdminHomePageUI.INFO_PRODUCT_INACTIVE_BUTTON);
	}

	public boolean isProductStatusActiveTextDisplayed(String productStatusActiveText) {
		waitForElementVisible(driver, AdminHomePageUI.PRODUCT_STATUS_ACTIVE_TEXT, productStatusActiveText);
		return isElementDisplay(driver, AdminHomePageUI.PRODUCT_STATUS_ACTIVE_TEXT, productStatusActiveText);
	}

	public void clickActiveButton() {
		waitForElementClickable(driver, AdminHomePageUI.INFO_PRODUCT_ACTIVE_BUTTON);
		clickToElement(driver, AdminHomePageUI.INFO_PRODUCT_ACTIVE_BUTTON);
	}
}
