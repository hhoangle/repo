package NPT.NptPageObjects;

import java.util.Random;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import NPT.NptPageObjects.NptPageUIs.NptProductPageUI;

import static NPT.NptPageObjects.NptPageUIs.NptProductPageUI.*;
import static commons.GlobalConstants.SHORT_TIMEOUT;

public class NptProductPageObject extends BasePage {
    private WebDriver driver;

    public NptProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public static long generateRandomNumber() {
        Random random = new Random();
        long randomNumber = random.nextLong() % 9000000000000L + 1000000000000L;
        return randomNumber;
    }

    public void clickToCreateProductButton() {
        waitForElementVisible(driver, NptProductPageUI.CREATE_PRODUCT_BUTTON);
        clickToElement(driver, NptProductPageUI.CREATE_PRODUCT_BUTTON);
    }

    public void insertBarCode() {
        waitForElementVisible(driver, NptProductPageUI.BARCODE_FIELD);
        long randomBarcode = generateRandomNumber();
        sendKeyToElement(driver, NptProductPageUI.BARCODE_FIELD, String.valueOf(randomBarcode));
    }

    public void insertProductName() {
        sendKeyToElement(driver, NptProductPageUI.PRODUCT_NAME_FIELD, "Bánh rán");
    }

    public void insertSellingPrice() {
        sendKeyToElement(driver, NptProductPageUI.SELLING_PRICE_FIELD, "45000");
    }

    public void insertImportPrice() {
        sendKeyToElement(driver, NptProductPageUI.IMPORT_PRICE_FIELD, "15000");
    }

    public void insertQuantity() {
        scrollToElement(driver, NptProductPageUI.QUANTITY_TITLE);
        sendKeyToElement(driver, NptProductPageUI.QUANTITY_FIELD, "200");
    }

    public void selectBrand() {
        waitForElementVisible(driver, SELECT_BRAND_DROPDOWN_LIST_PARENT);
        sendKeyToElement(driver, SELECT_BRAND_DROPDOWN_LIST_PARENT, "Unilever");
        clickToElement(driver,BRAND_NAME);
    }

    public void selectProductCategory() {
        sleepInSecond(SHORT_TIMEOUT);
        waitForElementVisible(driver, SELECT_PRODUCT_CATEGORY_LIST_PARENT);
        clickToElement(driver,SELECT_PRODUCT_CATEGORY_LIST_PARENT);
        clickToElement(driver, PRODUCT_CATEGORY_NAME);
    }

    public void selectProductGroup() {
        waitForElementVisible(driver,SELECT_PRODUCT_GROUP_LIST_PARENT);
        sendKeyToElement(driver,SELECT_PRODUCT_GROUP_LIST_PARENT,"Mỹ phẩm cao cấp");
        clickToElement(driver,PRODUCT_GROUP_NAME);
    }

    public void clickStatusButton() {
        waitForElementVisible(driver,ENABLE_STATUS_BUTTON);
        clickToElement(driver, ENABLE_STATUS_BUTTON);
    }

    public void clickSellOnlineButton() {
        waitForElementVisible(driver, SELL_ONLINE_BUTTON);
        clickToElement(driver,SELL_ONLINE_BUTTON);
    }

    public void insertProductDescription() {
        waitForElementVisible(driver,PRODUCT_DESCRIPTION_FIELD);
        sendKeyToElement(driver,NptProductPageUI.PRODUCT_DESCRIPTION_FIELD,"Tươi ngon mát lạnh");
    }

    public void clickSaveButton() {
        waitForElementClickable(driver,SAVE_BUTTON);
        clickToElement(driver, SAVE_BUTTON);
    }

    public void inputImg(String imagePath) {
        uploadImage(driver, PRODUCT_IMAGE, imagePath);
    }
}
