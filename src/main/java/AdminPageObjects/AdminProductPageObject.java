package AdminPageObjects;

import AdminPageUIs.AdminProductPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import java.util.Random;

import static AdminPageUIs.AdminProductPageUI.PRODUCT_IMAGE;

public class AdminProductPageObject extends BasePage {
    private WebDriver driver;
    public AdminProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCreateProductButton() {
        waitForElementVisible(driver, AdminProductPageUI.CREATE_PRODUCT_BUTTON);
        clickToElement(driver, AdminProductPageUI.CREATE_PRODUCT_BUTTON);
    }

    public AdminProductDetailPageObject clickSaveButton() {
        sleepInSecond(2);
        scrollToTopPage(driver);
        waitForElementVisible(driver, AdminProductPageUI.SAVE_PRODUCT);
        clickToElement(driver, AdminProductPageUI.SAVE_PRODUCT);
        return new AdminProductDetailPageObject(driver);
    }
    public boolean checkWarningMessageIsDisplayed(){
        waitForElementVisible(driver,AdminProductPageUI.WARNING_MESSAGE);
        return isElementDisplay(driver,AdminProductPageUI.WARNING_MESSAGE);
    }

    public void cliclCloseWarningPopup() {
        waitForElementVisible(driver,AdminProductPageUI.CLOSE_POPUP_BUTTON);
        clickToElement(driver,AdminProductPageUI.CLOSE_POPUP_BUTTON);
    }

    public void insertProductName(String productName) {
        waitForElementVisible(driver, AdminProductPageUI.PRODUCT_NAME_FIELD);
        sendKeyToElement(driver,AdminProductPageUI.PRODUCT_NAME_FIELD,productName);
    }
    public void insertBarCode(long randomNum) {
        waitForElementVisible(driver, AdminProductPageUI.BARCODE_FIELD);
        sendKeyToElement(driver, AdminProductPageUI.BARCODE_FIELD, String.valueOf(randomNum));
    }

    public void insertSellingPrice(String sellingPrice) {
        sendKeyToElement(driver, AdminProductPageUI.SELLING_PRICE_FIELD,sellingPrice);
    }

    public void insertImportPrice(String importPrice) {
        sendKeyToElement(driver, AdminProductPageUI.IMPORT_PRICE_FIELD,importPrice);
    }

    public void insertQuantity(String quantityProduct) {
        waitForElementVisible(driver,AdminProductPageUI.QUANTITY_FIELD);
        sendKeyToElement(driver,AdminProductPageUI.QUANTITY_FIELD,quantityProduct);
    }

    public void inputImg(String imagePath) {
        uploadImage(driver, PRODUCT_IMAGE, imagePath);
    }

    public void insertProductDescription(String productDesciption) {
        sendKeyToElement(driver, AdminProductPageUI.PRODUCT_DESCRIPTION_FIELD,productDesciption);

    }

    public void clickTrademarkInput() {
        sleepInSecond(3);
        clickToElement(driver, AdminProductPageUI.TRADEMARK_INPUT);
    }

    public void clickBrandName() {
        sleepInSecond(2);
        clickToElement(driver, AdminProductPageUI.BRAND_NAME);
    }

    public void clickAddInfo() {
        waitForElementVisible(driver, AdminProductPageUI.ADD_INFO_TEXT);
        clickToElement(driver, AdminProductPageUI.ADD_INFO_TEXT);
    }

    public String getBrandNameText() {
        waitForElementVisible(driver, AdminProductPageUI.BRAND_NAME_TEXT);
        return getElementText(driver, AdminProductPageUI.BRAND_NAME_TEXT);
    }
}
