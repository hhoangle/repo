package NPT.NptPageObjects;

import NPT.NptPageObjects.NptPageUIs.NptProductPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

import static commons.GlobalConstants.SHORT_TIMEOUT;

public class NptHomePageObject extends BasePage {
    private WebDriver driver;
    public NptHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public NptProductPageObject clickToManageProduct() {
        sleepInSecond(SHORT_TIMEOUT);
        waitForElementVisible(driver, NptProductPageUI.MANAGE_PRODUCT);
        clickToElement(driver, NptProductPageUI.MANAGE_PRODUCT);
        return new NptProductPageObject(driver);
    }

    public void clickToCreateProductButton() {
        waitForLoadingIconInvisible(driver);
        waitForElementVisible(driver, NptProductPageUI.CREATE_PRODUCT_BUTTON);
        clickToElement(driver,NptProductPageUI.CREATE_PRODUCT_BUTTON);

    }
}
