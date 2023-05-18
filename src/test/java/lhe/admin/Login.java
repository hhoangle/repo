package lhe.admin;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.AdminHomePageObject;

import static commons.GlobalConstants.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import reportConfig.ExtentTestManager;

public class Login extends BaseTest {
    WebDriver driver;

    private String account, password,accountInvalid, passwordInvalid;
    private String browserName;

    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, ADMIN_LOGIN);
        loginPage = new AdminLoginPageObject(driver);
        homePage = new AdminHomePageObject(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        account = ADMIN_ACCOUNT;
        accountInvalid = "dungtest";
        password = ADMIN_PASSWORD;
        passwordInvalid = "dungtest@11";
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
        driver.navigate().refresh();

        ExtentTestManager.startTest(method.getName(), "Login Invalid Data");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Input Account Textbox");
        loginPage.inputToAccountTextbox(accountInvalid);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input Password Textbox");
        loginPage.inputToPasswordTextbox(passwordInvalid);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Click Button Login");
        loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Verify Modal Confirm");
        assertTrue(loginPage.isModalConfirmDisplayed());

    }

    @Test
    public void TC_03_Login_Success(Method method) {
        driver.navigate().refresh();

        ExtentTestManager.startTest(method.getName(), "Login Success");
        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Input Account Textbox");
        loginPage.inputToAccountTextbox(account);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Input Password Textbox");
        loginPage.inputToPasswordTextbox(password);

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Click Icon Eye Slash");
        loginPage.clickToIconEyeSlash();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click Button Login");
        homePage = loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify Product Text Displayed");
        assertTrue(homePage.isProductTextDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
