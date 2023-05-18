package lhe.npp;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.npp.NppHomePageObject;
import pageObjects.npp.NppLoginPageObject;
import pageObjects.npp.product.category.ProductPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.GlobalConstants.NPP_LOGIN;

public class ProductListAndViewDetailProduct extends BaseTest {
    private WebDriver driver;
    private String browserName;
    private NppHomePageObject nppHomePage;
    private NppLoginPageObject nppLoginPage;
    private ProductPageObject nppProductPage;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, NPP_LOGIN);
        nppLoginPage = new NppLoginPageObject(driver);
        nppHomePage = nppLoginPage.goToNppHomePage(driver);
    }

    public void goToNppHomePage() {
        nppHomePage.openPageUrl(driver, NPP_LOGIN);
        nppHomePage.dragToLeft();
    }

    @Test
    public void TC_01_View_Product_List_And_Product_Detail(Method method) {
        ExtentTestManager.startTest(method.getName(), "View List and Product Detail");
        goToNppHomePage();
        nppProductPage = nppHomePage.clickProductButton();
        nppProductPage.clickViewProductDetail();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}