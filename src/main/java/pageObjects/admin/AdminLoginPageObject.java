package pageObjects.admin;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login to website")
    public AdminHomePageObject loginWebsite(String account, String password) {
        inputToAccountTextbox(account);
        inputToPasswordTextbox(password);
        clickToLoginButton();
        waitForLoadingIconInvisible(driver);
        return new AdminHomePageObject(driver);
    }

    @Step("Click to Login button")
    public AdminHomePageObject clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return new AdminHomePageObject(driver);
    }

    @Step("Enter to Account textbox")
    public void inputToAccountTextbox(String account) {
        waitForElementVisible(driver, AdminLoginPageUI.ACCOUNT_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.ACCOUNT_TEXTBOX, account);
    }

    @Step("Enter to Password textbox")
    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click to Login button")
    public void clickToIconEyeSlash() {
        waitForElementClickable(driver, AdminLoginPageUI.ICON_EYE);
        clickToElement(driver, AdminLoginPageUI.ICON_EYE);
    }

    @Step("Click to Account textbox")
    public void clickToAccountTextbox() {
        waitForElementClickable(driver, AdminLoginPageUI.ACCOUNT_TEXTBOX);
        clickToElement(driver, AdminLoginPageUI.ACCOUNT_TEXTBOX);
    }

    @Step("Click to Password textbox")
    public void clickToPasswordTextbox() {
        waitForElementClickable(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        clickToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
    }

    @Step("Verify Error Message At Account Textbox")
    public String getErrorMessageAtAccountTextbox() {
        waitForElementVisible(driver, AdminLoginPageUI.ACCOUNT_EMPTY_ERROR_MESSAGE);
        return getElementText(driver, AdminLoginPageUI.ACCOUNT_EMPTY_ERROR_MESSAGE);
    }

    @Step("Verify Error Message At Passwork Textbox")
    public String getErrorMessageAtPassworkTextbox() {
        waitForElementVisible(driver, AdminLoginPageUI.PASS_EMPTY_ERROR_MESSAGE);
        return getElementText(driver, AdminLoginPageUI.PASS_EMPTY_ERROR_MESSAGE);
    }

    @Step("Verify Modal Confirm Displayed")
    public boolean isModalConfirmDisplayed() {
        waitForElementVisible(driver, AdminLoginPageUI.MODAL_TEXT);
        return isElementDisplay(driver, AdminLoginPageUI.MODAL_TEXT);
    }
}
