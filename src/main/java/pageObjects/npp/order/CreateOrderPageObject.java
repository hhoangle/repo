package pageObjects.npp.order;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.npp.NppOrderPageUI;

import static pageUIs.npp.NppOrderPageUI.*;

public class CreateOrderPageObject extends BasePage {

    private WebDriver driver;

    public CreateOrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputNote() {
        sendKeyToElement(driver, ORDER_NOTE, "Giao hàng nhanh trong ngày");
    }

    public void searchProduct() {
        sendKeyToElement(driver, SEARCH_PRODUCT, "Thạch rau câu phong cách Nhật Bản Kimiko 990g");
    }

    public void dragAndDropIcon() {
        waitForElementClickable(driver, NppOrderPageUI.HELP_DESK_ICON);
        dragAndDrop(driver, NppOrderPageUI.HELP_DESK_ICON, NppOrderPageUI.BELL_ICON);
    }

    public void inputSelectProductCheckbox() {
        waitForElementClickable(driver, NppOrderPageUI.PRODUCT_CHECKBOX);
        clickToElement(driver, NppOrderPageUI.PRODUCT_CHECKBOX);
    }

    public void clickConfirmOrder() {
        waitForElementClickable(driver, NppOrderPageUI.CONFIRM_ORDER_BUTTON);
        clickToElement(driver, NppOrderPageUI.CONFIRM_ORDER_BUTTON);
    }

    public String getTextFromSuccessPopup() {
        waitForElementVisible(driver, NppOrderPageUI.SUCCESSFULL_POPUP_CONTENT);
        return getElementText(driver, SUCCESSFULL_POPUP_CONTENT);
    }

    public void clickOnOrderDetail() {
        waitForElementVisible(driver, NppOrderPageUI.VIEW_ORDER_DETAIL_BUTTON_AFTER_CREATED_SUCCESS);
        clickToElement(driver, VIEW_ORDER_DETAIL_BUTTON_AFTER_CREATED_SUCCESS);
    }

    public void clickOnOrderList() {
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, VIEW_ORDER_LIST_BUTTON_AFTER_CREATED_SUCCESS);
        clickToElement(driver, VIEW_ORDER_LIST_BUTTON_AFTER_CREATED_SUCCESS);
    }

    public void clickChooseProductFromWarehouseButton() {
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, NppOrderPageUI.CHOOSE_PRODUCT_FROM_WAREHOUSE);
        clickToElement(driver, NppOrderPageUI.CHOOSE_PRODUCT_FROM_WAREHOUSE);
    }

    public void clickToWarehouseList() {
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, NppOrderPageUI.EXPORT_FROM_FIELD);
        clickToElement(driver, EXPORT_FROM_FIELD);
    }

    public void chooseWarehouseValue() {
        waitForElementVisible(driver, NppOrderPageUI.EXPORT_FROM_VALUE);
        clickToElement(driver, EXPORT_FROM_VALUE);
    }

    public void clickToObjectList() {
        waitForElementVisible(driver, EXPORT_TO_FIELD);
        clickToElement(driver, EXPORT_TO_FIELD);
    }

    public void chooseObject() {
        waitForElementVisible(driver, EXPORT_TO_VALUE);
        clickToElement(driver, EXPORT_TO_VALUE);
    }

    public void clickChooseProductFromWareHouseButton() {
        waitForElementVisible(driver, CHOOSE_PRODUCT_FROM_WAREHOUSE_BUTTON);
        clickToElement(driver, CHOOSE_PRODUCT_FROM_WAREHOUSE_BUTTON);
    }

    public void selectProductFromWareHouse() {
        waitForElementVisible(driver, PRODUCT_FROM_WAREHOUSE);
        clickToElement(driver, PRODUCT_FROM_WAREHOUSE);
    }

    public void clickToExportFromConsignmentButton() {
        waitForElementVisible(driver, EXPORT_CONSIGNMENT_BUTTON);
        clickToElement(driver, EXPORT_CONSIGNMENT_BUTTON);
    }

    public void inputExportAmount() {
        waitForElementVisible(driver, INPUT_AMOUNT_FIELD);
        sendKeyToElement(driver, INPUT_AMOUNT_FIELD, "1");
    }

    public void inputSingleAmount() {
        waitForElementVisible(driver, INPUT_SINGLE_AMOUNT_FIELD);
        sendKeyToElement(driver, INPUT_SINGLE_AMOUNT_FIELD, "1");
    }

    public void clickConfirmExportButton() {
        waitForElementVisible(driver, CONFIRM_EXPORT_BUTTON);
        clickToElement(driver, CONFIRM_EXPORT_BUTTON);
    }

    public void clickCreateExportOrderButton() {
        waitForElementVisible(driver, CREATE_EXPORT_ORDER);
        clickToElement(driver, CREATE_EXPORT_ORDER);
    }

    public void clickViewExportOrderDetail() {
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, VIEW_EXPORT_ORDER_DETAIL);
        clickToElement(driver, VIEW_EXPORT_ORDER_DETAIL);
    }
}


