package pageObjects.admin.product;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.admin.distributorManagement.CreateAccountDistributorPageObject;
import pageUIs.admin.AdminHomePageUI;

import static commons.GlobalConstants.SHORT_TIMEOUT;

public class CreateProductPageObject extends BasePage {
	private WebDriver driver;

	public CreateProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ProductHomePageObject clickCancelButton() {
		waitForElementClickable(driver, AdminHomePageUI.CANCEL_BUTTON);
		clickToElement(driver, AdminHomePageUI.CANCEL_BUTTON);
		return new ProductHomePageObject(driver);
	}

	public void inputProductDescription(String productDescription) {
		waitForElementVisible(driver, AdminHomePageUI.PRODUCT_DESCRIPTION_TEXT_AREA);
		sendKeyToElement(driver, AdminHomePageUI.PRODUCT_DESCRIPTION_TEXT_AREA, productDescription);
	}

	public void clickToCategory() {
		waitForElementVisible(driver, AdminHomePageUI.CATEGORY_INPUT);
		clickToElement(driver, AdminHomePageUI.CATEGORY_INPUT);
	}

	public void clickSelectCategory() {
		sleepInSecond(SHORT_TIMEOUT);
		waitForElementVisible(driver, AdminHomePageUI.CATEGORY_INPUT_VALUE);
		clickToElement(driver, AdminHomePageUI.CATEGORY_INPUT_VALUE);
	}

	public void clickAddAttributeButton() {
		waitForElementVisible(driver, AdminHomePageUI.ADD_ATTRIBUTE_BUTTON);
		clickToElement(driver, AdminHomePageUI.ADD_ATTRIBUTE_BUTTON);
	}

	public void clickDeleteAttributeButton() {
		waitForElementVisible(driver, AdminHomePageUI.DELETE_ATTRIBUTE_BUTTON);
		clickToElement(driver, AdminHomePageUI.DELETE_ATTRIBUTE_BUTTON);
	}

	public void clickCreateNewButton() {
		waitForElementClickable(driver, AdminHomePageUI.CREATE_NEW_BUTTON);
		clickToElement(driver, AdminHomePageUI.CREATE_NEW_BUTTON);
	}

	public ProductHomePageObject clickCloseModalButton() {
		waitForElementClickable(driver, AdminHomePageUI.CLOSE_MODAL_BUTTON);
		clickToElement(driver, AdminHomePageUI.CLOSE_MODAL_BUTTON);
		return new ProductHomePageObject(driver);
	}

	public void inputProductImage(String productImage) {
		uploadImage(driver, AdminHomePageUI.PRODUCT_IMAGE, productImage);
	}
}
