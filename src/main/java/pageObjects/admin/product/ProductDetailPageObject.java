package pageObjects.admin.product;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminHomePageUI;

public class ProductDetailPageObject extends BasePage {
	private WebDriver driver;

	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public EditProductPageObject editProductPageButton() {
		waitForElementClickable(driver, AdminHomePageUI.EDIT_PRODUCT_BUTTON);
		clickToElement(driver, AdminHomePageUI.EDIT_PRODUCT_BUTTON);
		return new EditProductPageObject(driver);
	}

	public boolean isProductDetailTextDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.PRODUCT_DETAIL_TEXT);
		return isElementDisplay(driver, AdminHomePageUI.PRODUCT_DETAIL_TEXT);
	}

	public void clickCancelButton() {
		waitForElementClickable(driver, AdminHomePageUI.CANCEL_ORDER_MODAL_SUCCESS_BUTTON);
		clickToElement(driver, AdminHomePageUI.CANCEL_ORDER_MODAL_SUCCESS_BUTTON);
	}
}
