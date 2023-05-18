package lhe.warehouse;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.warehouse.WareHouseHomePageObject;
import pageObjects.warehouse.WareHouseLoginPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static commons.GlobalConstants.WARE_HOUSE_LOGIN;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WareHouseLogin extends BaseTest {
    WebDriver driver;

    private String account, password, accountInvalid, passwordInvalid;
    private String browserName;

    private WareHouseLoginPageObject loginPage;
    private WareHouseHomePageObject homePage;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, WARE_HOUSE_LOGIN);
        loginPage = new WareHouseLoginPageObject(driver);
        homePage = new WareHouseHomePageObject(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        account = "0966666666";
        accountInvalid = "hoangtest";
        password = "Longhai@2023";
        passwordInvalid = "hoangtest@11";
    }

    @Test
    public void TC_01_Login_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Login Empty Data");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Click Account Textbox");
        loginPage.clickToAccountTextbox();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Click Password Textbox");
        loginPage.clickToPasswordTextbox();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Click Account Textbox again");
        loginPage.clickToAccountTextbox();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Verify Error Message At Account Textbox");
        assertEquals(loginPage.getErrorMessageAtAccountTextbox(), "Bạn cần điền vào mục này");

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify Error Message At Password Textbox");
        assertEquals(loginPage.getErrorMessageAtPassworkTextbox(), "Bạn cần điền vào mục này");
    }

    @Test
    public void TC_02_Login_Invalid(Method method) {
        loginPage.inputToAccountTextbox(accountInvalid);
        loginPage.inputToPasswordTextbox(passwordInvalid);
        loginPage.clickToEyeIcon();
        loginPage.clickToLoginButton();
        loginPage.getErrorTextModal();
        assertEquals(loginPage.getErrorTextModal(), "Sai tên hoặc sai mật khẩu");
        loginPage.closeErrorPopup();
    }

    @Test
    public void TC_03_Login_Valid(Method method) {
        driver.navigate().refresh();
        loginPage.inputToAccountTextbox(account);
        loginPage.inputToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        assertTrue(loginPage.loginSuccessMark());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}