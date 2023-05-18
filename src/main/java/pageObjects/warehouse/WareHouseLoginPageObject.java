package pageObjects.warehouse;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.warehouse.WareHouseLoginPageUI;

import static commons.GlobalConstants.WARE_HOUSE_ACCOUNT;
import static commons.GlobalConstants.WARE_HOUSE_PASSWORD;

public class WareHouseLoginPageObject extends BasePage {
    private WebDriver driver;

    public WareHouseLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login to website")
    public WareHouseHomePageObject loginWebsite(String account, String password) {
        inputToAccountTextbox(account);
        inputToPasswordTextbox(password);
        clickToLoginButton();
        waitForLoadingIconInvisible(driver);
        return new WareHouseHomePageObject(driver);
    }

    @Step("Click to Account textbox")
    public void clickToAccountTextbox() {
        waitForElementClickable(driver, WareHouseLoginPageUI.WAREHOUSE_ACCOUNT_TEXTBOX);
        clickToElement(driver, WareHouseLoginPageUI.WAREHOUSE_ACCOUNT_TEXTBOX);
    }

    @Step("Click to Password textbox")
    public void clickToPasswordTextbox() {
        waitForElementClickable(driver, WareHouseLoginPageUI.WAREHOUSE_PASSWORD_TEXTBOX);
        clickToElement(driver, WareHouseLoginPageUI.WAREHOUSE_PASSWORD_TEXTBOX);
    }

    @Step("Verify Error Message At Account Textbox")
    public String getErrorMessageAtAccountTextbox() {
        waitForElementVisible(driver, WareHouseLoginPageUI.ACCOUNT_EMPTY_ERROR_MESSAGE);
        return getElementText(driver, WareHouseLoginPageUI.ACCOUNT_EMPTY_ERROR_MESSAGE);
    }

    @Step("Verify Error Message At Passwork Textbox")
    public String getErrorMessageAtPassworkTextbox() {
        waitForElementVisible(driver, WareHouseLoginPageUI.PASS_EMPTY_ERROR_MESSAGE);
        return getElementText(driver, WareHouseLoginPageUI.PASS_EMPTY_ERROR_MESSAGE);
    }

    public void inputToAccountTextbox(String account) {
        waitForElementVisible(driver, WareHouseLoginPageUI.WAREHOUSE_ACCOUNT_TEXTBOX);
        sendKeyToElement(driver, WareHouseLoginPageUI.WAREHOUSE_ACCOUNT_TEXTBOX, account);

    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, WareHouseLoginPageUI.WAREHOUSE_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, WareHouseLoginPageUI.WAREHOUSE_PASSWORD_TEXTBOX, password);
    }

    public void clickToEyeIcon() {
        waitForElementVisible(driver, WareHouseLoginPageUI.EYE_ICON);
        clickToElement(driver, WareHouseLoginPageUI.EYE_ICON);
    }

    public void clickToLoginButton() {
        waitForElementVisible(driver, WareHouseLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, WareHouseLoginPageUI.LOGIN_BUTTON);
    }

    public void closeErrorPopup() {
        waitForElementVisible(driver, WareHouseLoginPageUI.CLOSE_POPUP_BUTTON);
        clickToElement(driver, WareHouseLoginPageUI.CLOSE_POPUP_BUTTON);
    }

    public String getErrorTextModal() {
        waitForElementVisible(driver, WareHouseLoginPageUI.MODAL_TEXT);
        return getElementText(driver, WareHouseLoginPageUI.MODAL_TEXT);
    }

    public boolean loginSuccessMark() {
        waitForElementVisible(driver, WareHouseLoginPageUI.LOGIN_SUCCESS_MARK);
        return isElementDisplay(driver, WareHouseLoginPageUI.LOGIN_SUCCESS_MARK);
    }

    public WareHouseHomePageObject goToWareHouseHomePage(WebDriver driver) {
        WareHouseLoginPageObject loginWareHousePage = new WareHouseLoginPageObject(driver);
        WareHouseHomePageObject WareHouseHomePage;
        WareHouseHomePage = loginWareHousePage.loginWebsite(WARE_HOUSE_ACCOUNT, WARE_HOUSE_PASSWORD);
        return new WareHouseHomePageObject(driver);
    }

}

