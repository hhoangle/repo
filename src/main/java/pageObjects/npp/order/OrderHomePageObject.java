package pageObjects.npp.order;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.npp.NppHomePageUI;

public class OrderHomePageObject extends BasePage {
    private WebDriver driver;

    public OrderHomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public CreateOrderPageObject createOrderButton() {
        waitForElementVisible(driver, NppHomePageUI.CREATE_ORDER_BUTTON);
        clickToElement(driver, NppHomePageUI.CREATE_ORDER_BUTTON);
        return new CreateOrderPageObject(driver);
    }

    public void clickInProgressTab() {
        waitForLoadingItemInvisible(driver);
        waitForElementVisible(driver, NppHomePageUI.IN_PROGRESS_TAB);
        clickToElement(driver, NppHomePageUI.IN_PROGRESS_TAB);
    }

    public void clickViewOrderDetailsButton() {
        waitForElementVisible(driver, NppHomePageUI.VIEW_ORDER_DETAILS_BUTTON);
        clickToElement(driver, NppHomePageUI.VIEW_ORDER_DETAILS_BUTTON);
    }

    public void clickConfirmReceivedButton() {
        waitForElementVisible(driver, NppHomePageUI.CONFIRM_RECEIVED_BUTTON);
        clickToElement(driver, NppHomePageUI.CONFIRM_RECEIVED_BUTTON);
    }

    public void inputNoteInReceivedPopup() {
        waitForElementVisible(driver, NppHomePageUI.RECEIVED_NOTE);
        sendKeyToElement(driver, NppHomePageUI.RECEIVED_NOTE,"Đã kiểm tra và nhận đủ hàng");
    }

    public void inputImage(String productImage) {
        uploadImage(driver, NppHomePageUI.PRODUCT_IMAGE,productImage);
    }

    public void clickConfirmReceivedButtonFromPopup() {
        waitForElementVisible(driver, NppHomePageUI.CONFIRM_RECEIVED_BUTTON_FROM_POPUP);
        clickToElement(driver, NppHomePageUI.CONFIRM_RECEIVED_BUTTON_FROM_POPUP);
    }

    public CreateOrderPageObject clickExportOrderTab() {
        waitForElementVisible(driver, NppHomePageUI.EXPORT_ORDER_TAB);
        clickToElement(driver, NppHomePageUI.EXPORT_ORDER_TAB);
        return new CreateOrderPageObject(driver);
    }
}
