package lhe.warehouse;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.warehouse.WareHouseHomePageObject;
import pageObjects.warehouse.WareHouseLoginPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.GlobalConstants.WARE_HOUSE_LOGIN;

public class TransactionSlip extends BaseTest {
    private WebDriver driver;
    private String browserName;
    private WareHouseHomePageObject whHomePage;
    private WareHouseLoginPageObject whLoginPage;
    private WareHouseHomePageObject whTransactionSlipPage;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, WARE_HOUSE_LOGIN);
        whLoginPage = new WareHouseLoginPageObject(driver);
        whHomePage = whLoginPage.goToWareHouseHomePage(driver);
    }

    public void goToWareHouseHomePage() {
        whHomePage.openPageUrl(driver, WARE_HOUSE_LOGIN);
    }

    @Test
    public void TC_01_ViewExportNoteList(Method method) {
        ExtentTestManager.startTest(method.getName(), "Go To Ware House Home Page");
        goToWareHouseHomePage();
        whTransactionSlipPage = whHomePage.clickTransactionSlipButton();
        whTransactionSlipPage.clickExportNote();
    }

    @Test
    public void TC_02_ApproveExportNote(Method method) {
        ExtentTestManager.startTest(method.getName(), "Go To Ware House Home Page");
        goToWareHouseHomePage();
        whTransactionSlipPage = whHomePage.clickTransactionSlipButton();
        whTransactionSlipPage.clickExportNote();
        whTransactionSlipPage.clickViewExportNoteDetail();
        whTransactionSlipPage.inputDeliverName();
        whTransactionSlipPage.inputDriverPlate();
        whTransactionSlipPage.chooseReasonToExport();
        whTransactionSlipPage.clickExport();
        whTransactionSlipPage.clickConfirmExport();
        Assert.assertTrue(whTransactionSlipPage.isApprovedButtonDisplayed());
    }

    @Test
    public void TC_03_DenyExportNote(Method method) {
        ExtentTestManager.startTest(method.getName(), "Go To Ware House Home Page");
        goToWareHouseHomePage();
        whTransactionSlipPage = whHomePage.clickTransactionSlipButton();
        whTransactionSlipPage.clickExportNote();
        whTransactionSlipPage.clickViewExportNoteDetail();
        whTransactionSlipPage.clickCancel();
        whTransactionSlipPage.clickConfirmCancel();
        Assert.assertTrue(whTransactionSlipPage.isCancelledButtonDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
