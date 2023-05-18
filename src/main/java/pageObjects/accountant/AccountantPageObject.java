package pageObjects.accountant;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import pageObjects.warehouse.WareHouseHomePageObject;
import pageObjects.warehouse.WareHouseLoginPageObject;
import pageUIs.accountant.AccountantPageUI;
import pageUIs.npp.NppLoginPageUI;

import static commons.GlobalConstants.*;

public class AccountantPageObject extends BasePage {
    WebDriver driver;
    public AccountantPageObject(WebDriver driver) {this.driver = driver;}
    @Step("Login to website")
    public AccountantPageObject loginWebsite(String account, String password) {
        inputToAccountTextbox(account);
        inputToPasswordTextbox(password);
        clickToLoginButton();
        waitForLoadingIconInvisible(driver);
        return new AccountantPageObject(driver);
    }

    @Step("Click to Account textbox")
    public void clickToAccountTextbox() {
        waitForElementClickable(driver, AccountantPageUI.ACCOUNTANT_ACCOUNT_TEXTBOX);
        clickToElement(driver, AccountantPageUI.ACCOUNTANT_ACCOUNT_TEXTBOX);
    }

    @Step("Click to Password textbox")
    public void clickToPasswordTextbox() {
        waitForElementClickable(driver, AccountantPageUI.ACCOUNTANT_PASSWORD_TEXTBOX);
        clickToElement(driver, AccountantPageUI.ACCOUNTANT_PASSWORD_TEXTBOX);
    }

    @Step("Verify Error Message At Account Textbox")
    public String getErrorMessageAtAccountTextbox() {
        waitForElementVisible(driver, AccountantPageUI.ACCOUNT_EMPTY_ERROR_MESSAGE);
        return getElementText(driver, AccountantPageUI.ACCOUNT_EMPTY_ERROR_MESSAGE);
    }

    @Step("Verify Error Message At Passwork Textbox")
    public String getErrorMessageAtPassworkTextbox() {
        waitForElementVisible(driver, AccountantPageUI.PASS_EMPTY_ERROR_MESSAGE);
        return getElementText(driver, AccountantPageUI.PASS_EMPTY_ERROR_MESSAGE);
    }

    public void inputToAccountTextbox(String account) {
        waitForElementVisible(driver, AccountantPageUI.ACCOUNTANT_ACCOUNT_TEXTBOX);
        sendKeyToElement(driver, AccountantPageUI.ACCOUNTANT_ACCOUNT_TEXTBOX, account);

    }

    public void inputToPasswordTextbox(String passwordInvalid) {
        waitForElementVisible(driver, AccountantPageUI.ACCOUNTANT_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, AccountantPageUI.ACCOUNTANT_PASSWORD_TEXTBOX, passwordInvalid);
    }

    public void clickToEyeIcon() {
        waitForElementVisible(driver, NppLoginPageUI.EYE_ICON);
        clickToElement(driver, NppLoginPageUI.EYE_ICON);
    }

    public void clickToLoginButton() {
        waitForElementVisible(driver, AccountantPageUI.LOGIN_BUTTON);
        clickToElement(driver, AccountantPageUI.LOGIN_BUTTON);
    }

    public void closeErrorPopup() {
        waitForElementVisible(driver, AccountantPageUI.CLOSE_POPUP_BUTTON);
        clickToElement(driver, AccountantPageUI.CLOSE_POPUP_BUTTON);
    }

    public String getErrorTextModal() {
        waitForElementVisible(driver, AccountantPageUI.MODAL_TEXT);
        return getElementText(driver, AccountantPageUI.MODAL_TEXT);
    }
    public AccountantPageObject goToAccountantHomePage(WebDriver driver) {
        AccountantPageObject loginAccountantPage = new AccountantPageObject(this.driver);
        AccountantPageObject accountantPage;
        accountantPage = loginAccountantPage.loginWebsite(ACCOUNTANT_ACCOUNT, ACCOUNTANT_PASSWORD);
        return new AccountantPageObject(this.driver);
    }
    public boolean dashboardTextIsDisplayed() {
        waitForElementVisible(driver, AccountantPageUI.LOGIN_SUCCESS_MARK);
        return isElementDisplay(driver, AccountantPageUI.LOGIN_SUCCESS_MARK);
    }

    public AccountantPageObject goToOrderDetailPage(WebDriver driver) {
        AccountantPageObject loginAccountantPage = new AccountantPageObject(driver);
        AccountantPageObject accountantHomePage;
        accountantHomePage = loginAccountantPage.loginWebsite(ACCOUNTANT_ACCOUNT, ACCOUNTANT_PASSWORD);
        return new AccountantPageObject(driver);
    }

    public AccountantPageObject clickOrderButton() {
        waitForElementVisible(driver, AccountantPageUI.ORDER_BUTTON);
        clickToElement(driver, AccountantPageUI.ORDER_BUTTON);
        return new AccountantPageObject(driver);
    }

    public void clickViewDetail() {
        waitForElementVisible(driver, AccountantPageUI.VIEW_ORDER_DETAIL_BUTTON);
        clickToElement(driver, AccountantPageUI.VIEW_ORDER_DETAIL_BUTTON);
    }

    public void clickOrderStatusDropDown() {
        waitForLoadingItemInvisible(driver);
        waitForElementVisible(driver, AccountantPageUI.ORDER_STATUS_DROPDOWN);
        clickToElement(driver, AccountantPageUI.ORDER_STATUS_DROPDOWN);
    }

    public void clickInProgressStatus() {
        waitForElementVisible(driver, AccountantPageUI.ORDER_STATUS_VALUE);
        clickToElement(driver, AccountantPageUI.ORDER_STATUS_VALUE);
    }

    public void clickFinishOrderButton() {
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, AccountantPageUI.FINISH_ORDER_BUTTON);
        clickToElement(driver, AccountantPageUI.FINISH_ORDER_BUTTON);
    }
}
