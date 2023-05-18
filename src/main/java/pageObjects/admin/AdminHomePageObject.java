package pageObjects.admin;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.admin.distributorManagement.DistributorManagementPageObject;
import pageObjects.admin.order.OrderHomePageObject;
import pageObjects.admin.product.ProductHomePageObject;
import pageObjects.admin.userManagement.UserManagementHomePageObject;
import pageUIs.admin.AdminHomePageUI;

import static commons.GlobalConstants.SHORT_TIMEOUT;

public class AdminHomePageObject extends BasePage {
	private WebDriver driver;

	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify 'Product Text' is displayed")
	public boolean isProductTextDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.PRODUCT_TEXT);
		return isElementDisplay(driver, AdminHomePageUI.PRODUCT_TEXT);
	}

	public void clickButtonDragToTheLeft() {
		waitForElementClickable(driver, AdminHomePageUI.DRAG_TO_THE_LEFT_BUTTON);
		clickToElement(driver, AdminHomePageUI.DRAG_TO_THE_LEFT_BUTTON);
	}

	public DistributorManagementPageObject clickDistributorManagementButton() {
		sleepInSecond(SHORT_TIMEOUT);
		waitForElementClickable(driver, AdminHomePageUI.DISTRIBUTOR_MANAGEMENT);
		clickToElement(driver, AdminHomePageUI.DISTRIBUTOR_MANAGEMENT);
		return new DistributorManagementPageObject(driver);
	}

	public ProductHomePageObject clickProductButton() {
		sleepInSecond(SHORT_TIMEOUT);
		waitForElementClickable(driver, AdminHomePageUI.PRODUCT_BUTTON);
		clickToElement(driver, AdminHomePageUI.PRODUCT_BUTTON);
		return new ProductHomePageObject(driver);
	}

	public OrderHomePageObject clickOrderButton() {
		sleepInSecond(SHORT_TIMEOUT);
		waitForElementClickable(driver, AdminHomePageUI.ORDER_BUTTON);
		clickToElement(driver, AdminHomePageUI.ORDER_BUTTON);
		return new OrderHomePageObject(driver);
	}

	public UserManagementHomePageObject clickUserManagementButton() {
		waitForElementClickable(driver, AdminHomePageUI.USER_MANAGEMENT_BUTTON);
		clickToElement(driver, AdminHomePageUI.USER_MANAGEMENT_BUTTON);
		return new UserManagementHomePageObject(driver);
	}
}
