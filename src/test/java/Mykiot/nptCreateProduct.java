package Mykiot;

import NPT.NptPageObjects.NptHomePageObject;
import NPT.NptPageObjects.NptLoginPageObject;
import NPT.NptPageObjects.NptProductPageObject;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static commons.GlobalConstants.*;

public class nptCreateProduct extends BaseTest {
    WebDriver driver;
    private String imagePath;
    private String browserName;
    private NptLoginPageObject loginPage;
    private NptHomePageObject nptHomePage;
    private NptProductPageObject nptProductPage;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, NPT_LOGIN);
        loginPage = new NptLoginPageObject(driver);
        nptHomePage = loginPage.goToNptHomePage(driver);

        imagePath = PROJECT_PATH + "\\uploadFiles\\NewProductImage.png";

    }

    public void goToHomePage() {
        nptHomePage.openPageUrl(driver, NPT_LOGIN);
    }

    @Test
    public void TC_01_Create_Product_Without_Input() {
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptProductPage.clickToCreateProductButton();
    }

    @Test
    public void TC_02_Create_Product_With_Valid_Information() {
        goToHomePage();
        nptProductPage = nptHomePage.clickToManageProduct();
        nptProductPage.waitForLoadingIconInvisible(driver);
        nptProductPage.clickToCreateProductButton();
        nptProductPage.inputImg(imagePath);
        nptProductPage.insertBarCode();
        nptProductPage.insertProductName();
        nptProductPage.insertSellingPrice();
        nptProductPage.insertImportPrice();
        nptProductPage.insertQuantity();
        nptProductPage.selectBrand();
        nptProductPage.selectProductCategory();
        nptProductPage.selectProductGroup();
        nptProductPage.clickStatusButton();
        nptProductPage.clickSellOnlineButton();
        nptProductPage.insertProductDescription();
        nptProductPage.clickSaveButton();
    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
