package AdminPageObjects;
import AdminPageUIs.AdminProductPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
public class AdminProductDetailPageObject extends BasePage {
    private WebDriver driver;
    public AdminProductDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public String getProductName() {
        waitForElementVisible(driver, AdminProductPageUI.PRODUCT_NAME_TEXT);
        return getElementText(driver, AdminProductPageUI.PRODUCT_NAME_TEXT);
    }
    public String getSellingPrice(){
        waitForElementVisible(driver, AdminProductPageUI.SELLING_PRICE_TEXT);
        return getElementText(driver, AdminProductPageUI.SELLING_PRICE_TEXT);
    }
    public String getImportPrice(){
        waitForElementVisible(driver, AdminProductPageUI.IMPORT_PRICE_TEXT);
        return getElementText(driver, AdminProductPageUI.IMPORT_PRICE_TEXT);
    }

    public String getBrandName() {
        waitForElementVisible(driver, AdminProductPageUI.BRAND_NAME_TEXT_IN_DETAIL_PAGE);
        return getElementText(driver, AdminProductPageUI.BRAND_NAME_TEXT_IN_DETAIL_PAGE);
    }
}
