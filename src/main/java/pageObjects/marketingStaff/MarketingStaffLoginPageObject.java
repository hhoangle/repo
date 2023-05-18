package pageObjects.marketingStaff;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.marketingStaff.MarketingStaffLoginPageUI;

import static commons.GlobalConstants.*;
import static org.testng.Assert.assertTrue;

public class MarketingStaffLoginPageObject extends BasePage {
    private WebDriver driver;

    public MarketingStaffLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login to website")
    public MarketingStaffHomePageObject loginWebsite(String account, String password) {
        inputToAccountTextbox(account);
        inputToPasswordTextbox(password);
        clickToLoginButton();
        waitForLoadingIconInvisible(driver);
        return new MarketingStaffHomePageObject(driver);
    }

    @Step("Click to Login button")
    public MarketingStaffHomePageObject clickToLoginButton() {
        waitForElementClickable(driver, MarketingStaffLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, MarketingStaffLoginPageUI.LOGIN_BUTTON);
        return new MarketingStaffHomePageObject(driver);
    }

    @Step("Enter to Account textbox")
    public void inputToAccountTextbox(String account) {
        waitForElementVisible(driver, MarketingStaffLoginPageUI.ACCOUNT_TEXTBOX);
        sendKeyToElement(driver, MarketingStaffLoginPageUI.ACCOUNT_TEXTBOX, account);
    }

    @Step("Enter to Password textbox")
    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, MarketingStaffLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, MarketingStaffLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click to Login button")
    public void clickToIconEyeSlash() {
        waitForElementClickable(driver, MarketingStaffLoginPageUI.ICON_EYE);
        clickToElement(driver, MarketingStaffLoginPageUI.ICON_EYE);
    }

    @Step("Click to Account textbox")
    public void clickToAccountTextbox() {
        waitForElementClickable(driver, MarketingStaffLoginPageUI.ACCOUNT_TEXTBOX);
        clickToElement(driver, MarketingStaffLoginPageUI.ACCOUNT_TEXTBOX);
    }

    @Step("Click to Password textbox")
    public void clickToPasswordTextbox() {
        waitForElementClickable(driver, MarketingStaffLoginPageUI.PASSWORD_TEXTBOX);
        clickToElement(driver, MarketingStaffLoginPageUI.PASSWORD_TEXTBOX);
    }

    @Step("Verify Error Message At Account Textbox")
    public String getErrorMessageAtAccountTextbox() {
        waitForElementVisible(driver, MarketingStaffLoginPageUI.ACCOUNT_EMPTY_ERROR_MESSAGE);
        return getElementText(driver, MarketingStaffLoginPageUI.ACCOUNT_EMPTY_ERROR_MESSAGE);
    }

    @Step("Verify Error Message At Passwork Textbox")
    public String getErrorMessageAtPassworkTextbox() {
        waitForElementVisible(driver, MarketingStaffLoginPageUI.PASS_EMPTY_ERROR_MESSAGE);
        return getElementText(driver, MarketingStaffLoginPageUI.PASS_EMPTY_ERROR_MESSAGE);
    }

    @Step("Verify Modal Confirm Displayed")
    public boolean isModalConfirmDisplayed() {
        waitForElementVisible(driver, MarketingStaffLoginPageUI.MODAL_TEXT);
        return isElementDisplay(driver, MarketingStaffLoginPageUI.MODAL_TEXT);
    }

    public MarketingStaffHomePageObject goToMarketingStaffHomePage(WebDriver driver) {
        MarketingStaffLoginPageObject marketingStaffLoginPage = new MarketingStaffLoginPageObject(driver);
        marketingStaffLoginPage.loginWebsite(MARKETING_STAFF_ACCOUNT, MARKETING_STAFF_PASSWORD);
        return new MarketingStaffHomePageObject(driver);
    }
}
