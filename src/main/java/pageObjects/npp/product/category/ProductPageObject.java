package pageObjects.npp.product.category;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.npp.NppCategoryPageUI;
import pageUIs.npp.NppProductPageUI;

import static commons.GlobalConstants.SHORT_TIMEOUT;
import static commons.GlobalConstants.THREE_SECONDS;

public class ProductPageObject extends BasePage {
    private WebDriver driver;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPageObject ViewCategoryButton() {
        waitForElementVisible(driver, NppCategoryPageUI.VIEW_CATEGORY_BUTTON);
        clickToElement(driver, NppCategoryPageUI.VIEW_CATEGORY_BUTTON);
        return new ProductPageObject(driver);
    }

    public void clickViewCategoryButton() {
        waitForElementVisible(driver, NppCategoryPageUI.VIEW_CATEGORY_BUTTON);
        clickToElement(driver, NppCategoryPageUI.VIEW_CATEGORY_BUTTON);
    }

    public void createNewCategory() {
        waitForElementVisible(driver, NppCategoryPageUI.CREATE_NEW_CATEGORY_BUTTON);
        clickToElement(driver, NppCategoryPageUI.CREATE_NEW_CATEGORY_BUTTON);
    }

    public void inputCategoryName() {
        waitForElementVisible(driver, NppCategoryPageUI.INPUT_NEW_CATEGORY_FIELD);
        sendKeyToElement(driver, NppCategoryPageUI.INPUT_NEW_CATEGORY_FIELD, "New Category");
    }

    public void confirmCreateNewCategory() {
        waitForElementClickable(driver, NppCategoryPageUI.CONFIRM_CREATE_NEW_CATEGORY_BUTTON);
        clickToElement(driver, NppCategoryPageUI.CONFIRM_CREATE_NEW_CATEGORY_BUTTON);
    }

    public void deleteCategory() {
        sleepInSecond(THREE_SECONDS);
        waitForElementVisible(driver, NppCategoryPageUI.DELETE_CATEGORY_ICON);
        clickToElement(driver, NppCategoryPageUI.DELETE_CATEGORY_ICON);
    }

    public void clickDeleteCategoryButton() {
        sleepInSecond(SHORT_TIMEOUT);
        waitForElementVisible(driver, NppCategoryPageUI.DELETE_CATEGORY_BUTTON);
        clickToElement(driver, NppCategoryPageUI.DELETE_CATEGORY_BUTTON);
    }

    public void clickViewProductDetail() {
        waitForElementVisible(driver, NppProductPageUI.PRODUCT_IMG);
        clickToElement(driver, NppProductPageUI.PRODUCT_IMG);
    }

    public void clickConfigCategoryButton() {
        sleepInSecond(SHORT_TIMEOUT);
        waitForElementVisible(driver, NppProductPageUI.CONFIG_CATEGORY_BUTTON);
        clickToElement(driver, NppProductPageUI.CONFIG_CATEGORY_BUTTON);
    }
    public void clickCategoryCheckbox() {
        waitForElementVisible(driver, NppProductPageUI.CATEGORY_CHECKBOX);
        clickToElement(driver, NppProductPageUI.CATEGORY_CHECKBOX);
    }

    public String numberOfCheckboxesIsSelected() {
        sleepInSecond(SHORT_TIMEOUT);
        waitForElementVisible(driver, NppProductPageUI.CATEGORY_SELECTED);
        String numberOfCheckboxSelected = getElementText(driver, NppProductPageUI.CATEGORY_SELECTED);
        return numberOfCheckboxSelected;
    }
}