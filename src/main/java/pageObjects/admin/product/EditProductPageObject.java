package pageObjects.admin.product;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminHomePageUI;

public class EditProductPageObject extends BasePage {
	private WebDriver driver;

	public EditProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ProductDetailPageObject clickCancelButton() {
		waitForLoadingItemInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.CANCEL_EDIT_PRODUCT_BUTTON);
		clickToElement(driver, AdminHomePageUI.CANCEL_EDIT_PRODUCT_BUTTON);
		return new ProductDetailPageObject(driver);
	}

	public void clickChangeStatusLabel() {
		waitForLoadingIconInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.CHANGE_STATUS_PRODUCT_LABEL);
		clickToElement(driver, AdminHomePageUI.CHANGE_STATUS_PRODUCT_LABEL);
	}

	public void clickExistingAttribute() {
		waitForElementClickable(driver, AdminHomePageUI.EXISTING_ATTRIBUTE_DIV);
		clickToElement(driver, AdminHomePageUI.EXISTING_ATTRIBUTE_DIV);
	}

	public void inputNewProperties(String attributeValue) {
		waitForElementClickable(driver, AdminHomePageUI.ATTRIBUTE_VALUE_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.ATTRIBUTE_VALUE_INPUT, attributeValue);
	}

	public void clickSaveProductButton() {
		waitForElementClickable(driver, AdminHomePageUI.SAVE_PRODUCT_BUTTON);
		clickToElement(driver, AdminHomePageUI.SAVE_PRODUCT_BUTTON);
	}

	public ProductHomePageObject clickCloseModalButton() {
		waitForElementClickable(driver, AdminHomePageUI.CLOSE_MODAL_BUTTON);
		clickToElement(driver, AdminHomePageUI.CLOSE_MODAL_BUTTON);
		return new ProductHomePageObject(driver);
	}

	public void inputRetailPrice(String retailPrice) {
		waitForElementClickable(driver, AdminHomePageUI.RETAIL_PRICE_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.RETAIL_PRICE_INPUT, retailPrice);
	}

	public void inputPerBarrelPrice(String perBarrelPrice) {
		waitForElementClickable(driver, AdminHomePageUI.PER_BARREL_PRICE_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.PER_BARREL_PRICE_INPUT, perBarrelPrice);
	}

	public void inputNumberOfProductsInOneBox(String numberOfProductsInOneBox) {
		waitForElementClickable(driver, AdminHomePageUI.NUMBER_OF_PRODUCTS_IN_ONE_BOX_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.NUMBER_OF_PRODUCTS_IN_ONE_BOX_INPUT, numberOfProductsInOneBox);
	}
}
