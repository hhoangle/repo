package pageObjects.npp;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.npp.NppLoginPageUI;

import static commons.GlobalConstants.NPP_ACCOUNT;
import static commons.GlobalConstants.NPP_PASSWORD;

public class NppLoginPageObject extends BasePage {
    private WebDriver driver;

    public NppLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login to website")
    public NppHomePageObject loginWebsite(String account, String password) {
        inputToAccountTextbox(account);
        inputToPasswordTextbox(password);
        clickToLoginButton();
        waitForLoadingIconInvisible(driver);
        return new NppHomePageObject(driver);
    }

    @Step("Click to Account textbox")
    public void clickToAccountTextbox() {
        waitForElementClickable(driver, NppLoginPageUI.NPP_ACCOUNT_TEXTBOX);
        clickToElement(driver, NppLoginPageUI.NPP_ACCOUNT_TEXTBOX);
    }

    @Step("Click to Password textbox")
    public void clickToPasswordTextbox() {
        waitForElementClickable(driver, NppLoginPageUI.NPP_PASSWORD_TEXTBOX);
        clickToElement(driver, NppLoginPageUI.NPP_PASSWORD_TEXTBOX);
    }

    @Step("Verify Error Message At Account Textbox")
    public String getErrorMessageAtAccountTextbox() {
        waitForElementVisible(driver, NppLoginPageUI.ACCOUNT_EMPTY_ERROR_MESSAGE);
        return getElementText(driver, NppLoginPageUI.ACCOUNT_EMPTY_ERROR_MESSAGE);
    }

    @Step("Verify Error Message At Passwork Textbox")
    public String getErrorMessageAtPassworkTextbox() {
        waitForElementVisible(driver, NppLoginPageUI.PASS_EMPTY_ERROR_MESSAGE);
        return getElementText(driver, NppLoginPageUI.PASS_EMPTY_ERROR_MESSAGE);
    }

    public void inputToAccountTextbox(String account) {
        waitForElementVisible(driver, NppLoginPageUI.NPP_ACCOUNT_TEXTBOX);
        sendKeyToElement(driver, NppLoginPageUI.NPP_ACCOUNT_TEXTBOX, account);

    }

    public void inputToPasswordTextbox(String passwordInvalid) {
        waitForElementVisible(driver, NppLoginPageUI.NPP_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, NppLoginPageUI.NPP_PASSWORD_TEXTBOX, passwordInvalid);
    }

    public void clickToEyeIcon() {
        waitForElementVisible(driver, NppLoginPageUI.EYE_ICON);
        clickToElement(driver, NppLoginPageUI.EYE_ICON);
    }

    public void clickToLoginButton() {
        waitForElementVisible(driver, NppLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, NppLoginPageUI.LOGIN_BUTTON);
    }

    public void closeErrorPopup() {
        waitForElementVisible(driver, NppLoginPageUI.CLOSE_POPUP_BUTTON);
        clickToElement(driver, NppLoginPageUI.CLOSE_POPUP_BUTTON);
    }

    public String getErrorTextModal() {
        waitForElementVisible(driver, NppLoginPageUI.MODAL_TEXT);
        return getElementText(driver, NppLoginPageUI.MODAL_TEXT);
    }

    public boolean chartTextIsDisplayed() {
        waitForElementVisible(driver, NppLoginPageUI.LOGIN_SUCCESS_MARK);
        return isElementDisplay(driver, NppLoginPageUI.LOGIN_SUCCESS_MARK);
    }

    public void dragToLeft() {
        waitForElementVisible(driver, NppLoginPageUI.PROFIT_TEXT);
        clickAndHold(driver, NppLoginPageUI.PROFIT_TEXT);
    }

    public NppHomePageObject goToNppHomePage(WebDriver driver) {
        NppLoginPageObject loginNppPage = new NppLoginPageObject(this.driver);
        NppHomePageObject NppHomePage;
        NppHomePage = loginNppPage.loginWebsite(NPP_ACCOUNT, NPP_PASSWORD);
        NppHomePage.clickAndHold(this.driver, NppLoginPageUI.PROFIT_TEXT);
        return new NppHomePageObject(this.driver);
    }
}
