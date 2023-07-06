package Mykiot;

import AdminPageObjects.AdminHomePageObject;
import AdminPageObjects.AdminLoginPageObject;
import AdminPageObjects.AdminProductPageObject;
import AdminPageObjects.AdminProductDetailPageObject;
import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commons.BasePage.*;
import java.util.Random;

import static commons.GlobalConstants.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Random;
public class adminCreateProduct extends BaseTest {
    WebDriver driver;
    private String imagePath;
    private String browserName;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject adminHomePage;
    private AdminProductPageObject adminProductPage;
    private AdminProductDetailPageObject adminProductDetailPageObject;
    private String account, password, brandName;
    private long randomNum, min, max;
    private String productName, sellingPrice, importPrice, productDescription, quantityProduct;
    @BeforeClass
    public void beforeClass() {
        account = "0856174003";
        password = "01";
        browserName = "chrome";
        productName = "apple juice";
        sellingPrice = "15000";
        importPrice = "10000";
        quantityProduct = "1000";
        Random random = new Random();
        min = 1000000000000L; // Minimum 13-digit number
        max = 9999999999999L; // Maximum 13-digit number
        randomNum = Math.abs(random.nextLong()) % (max - min + 1) + min;
        productDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi finibus magna sed pulvinar dictum.";
        imagePath = PROJECT_PATH + "\\uploadFiles\\NewProductImage.png";
        driver = getBrowserDriver(browserName, ADMIN_LOGIN);
        loginPage = new AdminLoginPageObject(driver);
        adminHomePage = loginPage.loginWebsite(account, password);
    }

    public void goToHomePage() {
        adminHomePage.openPageUrl(driver, ADMIN_LOGIN);

    }

    @Test
    public void TC_01_Create_Product_Without_Input() {
        goToHomePage();
        adminProductPage = adminHomePage.clickToManageProduct();
        adminProductPage.waitForLoadingIconInvisible(driver);
        adminProductPage.clickToCreateProductButton();
        adminProductPage.clickSaveButton();
        assertTrue(adminProductPage.checkWarningMessageIsDisplayed());
        adminProductPage.cliclCloseWarningPopup();
    }

    @Test
    public void TC_02_Create_Product_Input_Only_Product_Name() {
        goToHomePage();
        adminProductPage = adminHomePage.clickToManageProduct();
        adminProductPage.waitForLoadingIconInvisible(driver);
        adminProductPage.clickToCreateProductButton();
        adminProductPage.insertProductName(productName);
        adminProductDetailPageObject = adminProductPage.clickSaveButton();
        assertEquals(adminProductDetailPageObject.getProductName(), productName);
    }

    @Test
    public void TC_03_Create_Product_Input_Full_Infor() {
        goToHomePage();
        adminProductPage = adminHomePage.clickToManageProduct();
        adminProductPage.waitForLoadingIconInvisible(driver);
        adminProductPage.clickToCreateProductButton();
        adminProductPage.insertBarCode(randomNum);
        adminProductPage.insertProductName(productName);
        adminProductPage.insertSellingPrice(sellingPrice);
        adminProductPage.insertImportPrice(importPrice);
        adminProductPage.insertQuantity(quantityProduct);
        adminProductPage.insertProductDescription(productDescription);
        adminProductPage.inputImg(imagePath);
        adminProductPage.clickAddInfo();
        adminProductPage.clickTrademarkInput();
        adminProductPage.clickBrandName();
        brandName = adminProductPage.getBrandNameText();
        adminProductDetailPageObject = adminProductPage.clickSaveButton();
        assertEquals(adminProductDetailPageObject.getProductName(), productName);
        assertEquals(adminProductDetailPageObject.getImportPrice(), "10.000 đ");
        assertEquals(adminProductDetailPageObject.getSellingPrice(), "15.000 đ");
        assertEquals(adminProductDetailPageObject.getBrandName(), brandName);
    }

//    @AfterClass
//    public void afterClass() {
//        closeBrowserAndDriver();
//    }
}
