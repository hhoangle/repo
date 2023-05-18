package pageObjects.npp.UserInfoObject;
import commons.*;
import org.openqa.selenium.WebDriver;
import pageUIs.npp.NppUserInfoPageUI;

import static commons.GlobalConstants.SHORT_TIMEOUT;

public class NppUserInfoObject extends BasePage {
    private WebDriver driver;
    public NppUserInfoObject(WebDriver driver) {
        this.driver = driver;
    }
    public NppUserInfoObject PersonalInformation() {
        waitForElementVisible(driver, NppUserInfoPageUI.PERSONAL_INFOMATION_ICON);
        clickToElement(driver, NppUserInfoPageUI.PERSONAL_INFOMATION_ICON);
        return new NppUserInfoObject(driver);
    }

    public void clickPersonalInfoTab() {
        waitForElementVisible(driver, NppUserInfoPageUI.PERSONAL_INFO_TAB);
        clickToElement(driver, NppUserInfoPageUI.PERSONAL_INFO_TAB);
    }

    public void clickEditPersonalInfoButton() {
        waitForElementVisible(driver, NppUserInfoPageUI.EDIT_PERSONAL_INFO_BUTTON);
        clickToElement(driver, NppUserInfoPageUI.EDIT_PERSONAL_INFO_BUTTON);
    }

    public String getInfoDistributor(String info) {
        waitForElementVisible(driver, NppUserInfoPageUI.INFO_DISTRIBUTOR_TEXT, info);
        return getElementText(driver, NppUserInfoPageUI.INFO_DISTRIBUTOR_TEXT, info);
    }

    public void clickCancelEditPersonalInfoButton() {
        sleepInSecond(SHORT_TIMEOUT);
        waitForElementVisible(driver, NppUserInfoPageUI.CANCEL_EDIT_INFO_BUTTON);
        clickToElement(driver, NppUserInfoPageUI.CANCEL_EDIT_INFO_BUTTON);
    }
}
