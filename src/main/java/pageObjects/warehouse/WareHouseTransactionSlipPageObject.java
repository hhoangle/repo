package pageObjects.warehouse;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class WareHouseTransactionSlipPageObject extends BasePage {
    private WebDriver driver;
    WareHouseLoginPageObject login = new WareHouseLoginPageObject(driver);

    public WareHouseTransactionSlipPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login to website")
    public WareHouseTransactionSlipPageObject loginWebsite(String account, String password) {
        login.inputToAccountTextbox(account);
        login.inputToPasswordTextbox(password);
        login.clickToLoginButton();
        waitForLoadingIconInvisible(driver);
        return new WareHouseTransactionSlipPageObject(driver);
    }
}
