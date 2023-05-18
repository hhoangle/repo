package lhe.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.product.CreateProductPageObject;
import pageObjects.admin.product.ProductHomePageObject;
import pageUIs.admin.AdminHomePageUI;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.BasePage.getRandomInt;
import static commons.GlobalConstants.ADMIN_LOGIN;
import static commons.GlobalConstants.PROJECT_PATH;
import static org.testng.Assert.assertTrue;
import static pageUIs.admin.AdminHomePageUI.ADD_ATTRIBUTE_BUTTON;

public class AddProduct extends BaseTest {
    WebDriver driver;

    private String browserName;

    private AdminHomePageUI homePageUI;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;
    private ProductHomePageObject productHomePage;
    private CreateProductPageObject createProductPage;
    private String productName, productDescription, productImage, retailPrice, perBarrelPrice, numberOfProductsInOneBox, attributeName, attributeValue;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, ADMIN_LOGIN);
        loginPage = new AdminLoginPageObject(driver);
        homePage = loginPage.goToAdminHomePage(driver);

        productName = "Thạch rau câu"  + getRandomInt();
        productDescription = "Thạch 900g";
        productImage =  PROJECT_PATH + "\\uploadFiles\\ProductImage.jpg";
        retailPrice = "100000";
        perBarrelPrice = "50000";
        numberOfProductsInOneBox = "20";
        attributeName = "LHETest";
        attributeValue = "LHETest";
    }

    public void goToHomPage() {
        homePage.openPageUrl(driver, ADMIN_LOGIN);
        homePage.clickButtonDragToTheLeft();
    }

    @Test
    public void TC_01_Cancel_Product_Page(Method method) {
        ExtentTestManager.startTest(method.getName(), "Cancel Product Page");
        goToHomPage();
        productHomePage = homePage.clickProductButton();
        assertTrue(productHomePage.isProductWareHouseTextDisplayed());
        createProductPage = productHomePage.clickAddNewProductButton();
        productHomePage = createProductPage.clickCancelButton();
        assertTrue(productHomePage.isProductWareHouseTextDisplayed());
    }

    @Test
    public void TC_02_Create_Product_Page(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create Product Page Success");
        goToHomPage();
        productHomePage = homePage.clickProductButton();
        createProductPage = productHomePage.clickAddNewProductButton();
        createProductPage.clickToCategory();
        createProductPage.clickSelectCategory();
        createProductPage.inputDynamic(driver,"Nhập tên sản phẩm", productName);
        createProductPage.inputProductDescription(productDescription);
        createProductPage.inputProductImage(productImage);
        createProductPage.inputDynamic(driver,"Nhập giá bán lẻ", retailPrice);
        createProductPage.inputDynamic(driver,"Nhập giá theo thùng", perBarrelPrice);
        createProductPage.inputDynamic(driver,"Nhập số lượng sản phẩm trong 1 thùng", numberOfProductsInOneBox);
        createProductPage.scrollToElement(driver,ADD_ATTRIBUTE_BUTTON);
        createProductPage.clickAddAttributeButton();
        createProductPage.inputDynamic(driver,"Nhập tên thuộc tính", attributeName);
        createProductPage.inputDynamic(driver,"Nhập giá trị thuộc tính", attributeValue);
        createProductPage.clickDeleteAttributeButton();
        createProductPage.clickAddAttributeButton();
        createProductPage.inputDynamic(driver,"Nhập tên thuộc tính", attributeName);
        createProductPage.inputDynamic(driver,"Nhập giá trị thuộc tính", attributeValue);
        createProductPage.clickCreateNewButton();
        productHomePage = createProductPage.clickCloseModalButton();
        assertTrue(productHomePage.productNameDisplayed(productName), productName);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
