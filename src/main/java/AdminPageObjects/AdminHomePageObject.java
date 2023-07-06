package AdminPageObjects;

import AdminPageObjects.*;
import AdminPageUIs.*;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

import static commons.GlobalConstants.SHORT_TIMEOUT;

public class AdminHomePageObject extends BasePage {
    private WebDriver driver;

    public AdminHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AdminProductPageObject clickToManageProduct() {
        waitForElementVisible(driver, AdminProductPageUI.MANAGE_PRODUCT);
        clickToElement(driver, AdminProductPageUI.MANAGE_PRODUCT);
        return new AdminProductPageObject(driver);
    }
}
