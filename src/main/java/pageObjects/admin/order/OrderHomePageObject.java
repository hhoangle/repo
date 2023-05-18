package pageObjects.admin.order;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminHomePageUI;

public class OrderHomePageObject extends BasePage {
	private WebDriver driver;

	public OrderHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public CreateOrderPageObject clickAddNewOrderButton() {
		waitForElementClickable(driver, AdminHomePageUI.ADD_NEW_ORDER_BUTTON);
		clickToElement(driver, AdminHomePageUI.ADD_NEW_ORDER_BUTTON);
		return new CreateOrderPageObject(driver);
	}

	public boolean isOrderInFormationTextDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.ORDER_INFO_TEXT);
		return isElementDisplay(driver, AdminHomePageUI.ORDER_INFO_TEXT);
	}

    public OrderDetailPageObject clickViewDetailButton() {
		waitForElementClickable(driver, AdminHomePageUI.VIEW_DETAIL_BUTTON);
		clickToElement(driver, AdminHomePageUI.VIEW_DETAIL_BUTTON);
		return new OrderDetailPageObject(driver);
    }

	public void clickWaitingForApproveButton() {
		waitForLoadingItemInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.WAITING_FOR_APPROVE_BUTTON);
		clickToElement(driver, AdminHomePageUI.WAITING_FOR_APPROVE_BUTTON);
	}
}
