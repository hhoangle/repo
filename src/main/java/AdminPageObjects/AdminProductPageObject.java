package AdminPageObjects;

import AdminPageUIs.AdminProductPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

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
        sleepInSecond(1);
        scrollToTopPage(driver);
        waitForElementVisible(driver, AdminProductPageUI.SAVE_PRODUCT);
        clickToElement(driver, AdminProductPageUI.SAVE_PRODUCT);
        return new AdminProductDetailPageObject(driver);
    }

    public boolean checkWarningMessageIsDisplayed() {
        waitForElementVisible(driver, AdminProductPageUI.WARNING_MESSAGE);
        return isElementDisplay(driver, AdminProductPageUI.WARNING_MESSAGE);
    }

    public void cliclCloseWarningPopup() {
        waitForElementVisible(driver, AdminProductPageUI.CLOSE_POPUP_BUTTON);
        clickToElement(driver, AdminProductPageUI.CLOSE_POPUP_BUTTON);
    }

    public void insertProductName(String productName) {
        waitForElementVisible(driver, AdminProductPageUI.PRODUCT_NAME_FIELD);
        sendKeyToElement(driver, AdminProductPageUI.PRODUCT_NAME_FIELD, productName);
    }

    public void insertBarCode(long randomNum) {
        waitForElementVisible(driver, AdminProductPageUI.BARCODE_FIELD);
        sendKeyToElement(driver, AdminProductPageUI.BARCODE_FIELD, String.valueOf(randomNum));
    }

    public void insertSellingPrice(String sellingPrice) {
        sendKeyToElement(driver, AdminProductPageUI.SELLING_PRICE_FIELD, sellingPrice);
    }

    public void insertImportPrice(String importPrice) {
        sendKeyToElement(driver, AdminProductPageUI.IMPORT_PRICE_FIELD, importPrice);
    }

    public void insertQuantity(String quantityProduct) {
        scrollToElement(driver, AdminProductPageUI.QUANTITY_FIELD);
        sendKeyToElement(driver, AdminProductPageUI.QUANTITY_FIELD, quantityProduct);
    }

    public void inputImg(String imagePath) {
        uploadImage(driver, PRODUCT_IMAGE, imagePath);
    }

    public void insertProductDescription(String productDesciption) {
        sendKeyToElement(driver, AdminProductPageUI.PRODUCT_DESCRIPTION_FIELD, productDesciption);

    }

    public void clickBrandNameDropDown() {
        sleepInSecond(1);
        clickToElement(driver, AdminProductPageUI.BRAND_NAME_DROPDOWN);
    }

    public void selectBrandName() {
        sleepInSecond(1);
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

    public void clickProductCategoryDropDown() {
        waitForElementVisible(driver, AdminProductPageUI.PRODUCT_CATEGORY_DROPDOWN);
        clickToElement(driver, AdminProductPageUI.PRODUCT_CATEGORY_DROPDOWN);
    }

    public void selectProductCategoryName() {
        sleepInSecond(1);
        clickToElement(driver, AdminProductPageUI.PRODUCT_CATEGORY_NAME);
    }

    public String getProductCategoryNameText() {
        waitForElementVisible(driver, AdminProductPageUI.PRODUCT_CATEGORY_NAME_TEXT);
        return getElementText(driver, AdminProductPageUI.PRODUCT_CATEGORY_NAME_TEXT);
    }

    public void clickProductGroupDropDown() {
        waitForElementVisible(driver, AdminProductPageUI.PRODUCT_GROUP_DROPDOWN);
        clickToElement(driver, AdminProductPageUI.PRODUCT_GROUP_DROPDOWN);
    }

    public void selectProductGroupDropDown() {
        sleepInSecond(1);
        clickToElement(driver, AdminProductPageUI.PRODUCT_GROUP_NAME);

    }

    public String getProductGroupNameText() {
        waitForElementVisible(driver, AdminProductPageUI.PRODUCT_GROUP_NAME_TEXT);
        return getElementText(driver, AdminProductPageUI.PRODUCT_GROUP_NAME_TEXT);
    }

    public String getDefaultVariantName() {
        waitForElementVisible(driver, AdminProductPageUI.VARIANT_NAME);
        return getElementText(driver, AdminProductPageUI.VARIANT_NAME);
    }

    public void clickAddProperties() {
        waitForElementVisible(driver, AdminProductPageUI.ADD_VARIANT_BUTTON);
        clickToElement(driver, AdminProductPageUI.ADD_VARIANT_BUTTON);
    }

    public void insertVariantName(String variantName) {
        sendKeyToElement(driver, AdminProductPageUI.VARIANT_NAME_FIELD,variantName);
    }
    public void insertVariantValue(String variantValue){
        sendKeyToElement(driver, AdminProductPageUI.VARIANT_VALUE_FIELD,variantValue);
    }

    public void insertVariantBarcode(long randomNum) {
        sendKeyToElement(driver, AdminProductPageUI.VARIANT_BARCODE_FIELD,String.valueOf(randomNum));
    }

    public void insertVariantQuantity(String variantQuantity) {
        waitForElementVisible(driver, AdminProductPageUI.VARIANT_QUANTITY_FIELD);
        sendKeyToElement(driver, AdminProductPageUI.VARIANT_QUANTITY_FIELD, variantQuantity);
    }

    public void clickProductStatusToggleButton() {
        clickToElement(driver, AdminProductPageUI.PRODUCT_STATUS_TOGGLE_BUTTON);
    }
    public String getProductStatus() {
        waitForElementVisible(driver, AdminProductPageUI.PRODUCT_STATUS);
        return getElementText(driver, AdminProductPageUI.PRODUCT_STATUS);
    }

    public String getSellOnlineStatus() {
        waitForElementVisible(driver, AdminProductPageUI.SELL_ONLINE_STATUS);
        return getElementText(driver, AdminProductPageUI.SELL_ONLINE_STATUS);
    }

    public String getSellOnlineStatusAfterSwitchOff() {
        waitForElementVisible(driver, AdminProductPageUI.SELL_ONLINE_STATUS_AFTER_SWITCH_OFF);
        return getElementText(driver, AdminProductPageUI.SELL_ONLINE_STATUS_AFTER_SWITCH_OFF);
    }

    public String getProductStatusAfterSwitchOff() {
        waitForElementVisible(driver, AdminProductPageUI.PRODUCT_STATUS_AFTER_SWITCH_OFF);
        return getElementText(driver, AdminProductPageUI.PRODUCT_STATUS_AFTER_SWITCH_OFF);
    }

    public void checkSellOnlineStatusToggleButton() {
        clickToElement(driver, AdminProductPageUI.SELL_ONLINE_STATUS_TOGGLE_BUTTON);
    }
}
