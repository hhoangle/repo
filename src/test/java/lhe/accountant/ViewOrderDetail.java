package lhe.accountant;

import commons.BaseTest;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.accountant.AccountantPageObject;
import pageUIs.accountant.AccountantPageUI;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.GlobalConstants.ACCOUNTANT_LOGIN;

public class ViewOrderDetail extends BaseTest {
    WebDriver driver;
    private String browserName;
    private AccountantPageObject orderDetailPage;
    private AccountantPageObject orderListPage;
    private AccountantPageObject accountantHomePage;
    private AccountantPageObject loginPage;
    private BasePage basePage;
    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, ACCOUNTANT_LOGIN);
        loginPage = new AccountantPageObject(driver);
        accountantHomePage = loginPage.goToAccountantHomePage(driver);
        BasePage basePage =  new BasePage();
    }

    public void goToAccountantHouseHomePage() {
        accountantHomePage.openPageUrl(driver, ACCOUNTANT_LOGIN);
    }

    @Test
    public void TC_01_ViewOrderList(Method method) {
        ExtentTestManager.startTest(method.getName(), "Go To Accountant Home Page");
        goToAccountantHouseHomePage();
        orderListPage = accountantHomePage.clickOrderButton();
        Assert.assertEquals(orderListPage.getElementText(driver, AccountantPageUI.ORDER_HEADER), "Đơn hàng");
    }
    @Test
    public void TC_02_ViewOrderDetails(Method method) {
        ExtentTestManager.startTest(method.getName(), "Go To Accountant Home Page");
        goToAccountantHouseHomePage();
        orderListPage = accountantHomePage.clickOrderButton();
        orderListPage.clickViewDetail();
        Assert.assertEquals(orderListPage.getElementText(driver, AccountantPageUI.ORDER_DETAIL_HEADER), "Chi tiết đơn hàng");
    }
    @Test
    public void TC_03_ApproveOrderFromOrderDetails (Method method)  {
        ExtentTestManager.startTest(method.getName(), "Go To Accountant Home Page");
        goToAccountantHouseHomePage();
        orderListPage = accountantHomePage.clickOrderButton();
        orderListPage.clickOrderStatusDropDown();
        orderListPage.clickInProgressStatus();
        orderListPage.clickViewDetail();
//        orderListPage.clickFinishOrderButton();
//        Assert.assertEquals(orderListPage.getElementText(driver,AccountantPageUI.FINISH_ORDER_SUCCESS), "Duyệt đơn thành công.");
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }

}
