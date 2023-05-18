package pageObjects.warehouse;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.warehouse.WareHouseHomePageUI;
import pageUIs.warehouse.WareHouseTransactionSlipPageUI;

import static pageUIs.warehouse.WareHouseTransactionSlipPageUI.REASON_EXPORT;

public class WareHouseHomePageObject extends BasePage {
    private WebDriver driver;

    public WareHouseHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WareHouseHomePageObject clickTransactionSlipButton() {
        waitForElementVisible(driver, WareHouseHomePageUI.TRANSACTION_NOTE_ICON);
        clickToElement(driver, WareHouseHomePageUI.TRANSACTION_NOTE_ICON);
        return new WareHouseHomePageObject(driver);
    }

    public void clickExportNote() {
        waitForElementVisible(driver, WareHouseTransactionSlipPageUI.EXPORT_NOTE_ICON);
        clickToElement(driver, WareHouseTransactionSlipPageUI.EXPORT_NOTE_ICON);
    }

    public void clickViewExportNoteDetail() {
        waitForLoadingItemInvisible(driver);
        waitForElementVisible(driver, WareHouseTransactionSlipPageUI.EXPORT_NOTE_DETAIL_ICON);
        clickToElement(driver, WareHouseTransactionSlipPageUI.EXPORT_NOTE_DETAIL_ICON);
    }

    public void clickExport() {
        waitForElementVisible(driver, WareHouseTransactionSlipPageUI.EXPORT_BUTTON);
        clickToElement(driver, WareHouseTransactionSlipPageUI.EXPORT_BUTTON);
    }

    public void clickConfirmExport() {
        waitForElementVisible(driver, WareHouseTransactionSlipPageUI.CONFIRM_POPUP_EXPORT_BUTTON);
        clickToElement(driver, WareHouseTransactionSlipPageUI.CONFIRM_POPUP_EXPORT_BUTTON);
    }

    public void clickCancel() {
        waitForElementVisible(driver, WareHouseTransactionSlipPageUI.CANCEL_EXPORT_BUTTON);
        clickToElement(driver, WareHouseTransactionSlipPageUI.CANCEL_EXPORT_BUTTON);
    }

    public void clickConfirmCancel() {
        waitForElementVisible(driver, WareHouseTransactionSlipPageUI.CONFIRM_POPUP_CANCEL_BUTTON);
        clickToElement(driver, WareHouseTransactionSlipPageUI.CONFIRM_POPUP_CANCEL_BUTTON);
    }

    public boolean isCancelledButtonDisplayed() {
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, WareHouseTransactionSlipPageUI.CANCEL_STATUS_BUTTON);
        return isElementDisplay(driver, WareHouseTransactionSlipPageUI.CANCEL_STATUS_BUTTON);
    }

    public boolean isApprovedButtonDisplayed() {
        waitForElementVisible(driver, WareHouseTransactionSlipPageUI.APPROVED_STATUS_BUTTON);
        return isElementDisplay(driver, WareHouseTransactionSlipPageUI.APPROVED_STATUS_BUTTON);
    }

    public void inputDeliverName() {
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, WareHouseTransactionSlipPageUI.DELIVER_NAME);
        sendKeyToElement(driver, WareHouseTransactionSlipPageUI.DELIVER_NAME, "Nguyen Van A");
    }

    public void inputDriverPlate() {
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, WareHouseTransactionSlipPageUI.DRIVER_PLATE);
        sendKeyToElement(driver, WareHouseTransactionSlipPageUI.DRIVER_PLATE, "29D1-37462");
    }

    public void chooseReasonToExport() {
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, REASON_EXPORT);
        sendKeyToElement(driver, REASON_EXPORT, "Nhà phân phối tạo đơn");
        WebElement enter = driver.findElement(By.xpath(REASON_EXPORT));
        enter.sendKeys(Keys.ENTER);
    }
}
