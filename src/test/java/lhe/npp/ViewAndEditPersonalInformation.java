package lhe.npp;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.npp.NppHomePageObject;
import pageObjects.npp.NppLoginPageObject;
import pageObjects.npp.UserInfoObject.NppUserInfoObject;
import pageUIs.npp.NppUserInfoPageUI;
import reportConfig.ExtentTestManager;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import static commons.GlobalConstants.NPP_LOGIN;

public class ViewAndEditPersonalInformation extends BaseTest {
    WebDriver driver;
    private String browserName;
    private NppLoginPageObject loginPage;
    private NppHomePageObject homePage;
    private NppUserInfoObject infoPage;
    private String fullName = "NPP Test";
    private String idNumber = "112233445566";
    private String dateOfBirth = "2000-01-08";
    private String phoneNumber = "0981122333";
    private String address = "Cau Giay, Cau Giay, Ha Noi";


    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, NPP_LOGIN);
        loginPage = new NppLoginPageObject(driver);
        homePage = new NppHomePageObject(driver);
        infoPage = new NppUserInfoObject(driver);

        homePage = loginPage.goToNppHomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void goToNppHomePage() {
        homePage.openPageUrl(driver, NPP_LOGIN);
        homePage.dragToLeft();
    }

    @Test
    public void TC_01_EditInfoThenSave(Method method) {
        ExtentTestManager.startTest(method.getName(), "Edit Info");
        goToNppHomePage();
        infoPage = homePage.clickPersonalInfoIcon();
        infoPage.clickPersonalInfoTab();
        infoPage.clickEditPersonalInfoButton();
        infoPage.clearValueInElementByDeleteKey(driver, NppUserInfoPageUI.FULLNAME_FIELD);
        infoPage.clearValueInElementByDeleteKey(driver, NppUserInfoPageUI.ID_NUMBER_FIELD);
        infoPage.clearValueInElementByDeleteKey(driver, NppUserInfoPageUI.DOB_FIELD);
        infoPage.clearValueInElementByDeleteKey(driver, NppUserInfoPageUI.PHONE_NUMBER_FIELD);
        infoPage.clearValueInElementByDeleteKey(driver, NppUserInfoPageUI.ADDRESS_FIELD);
        infoPage.sendKeyToElement(driver, NppUserInfoPageUI.FULLNAME_FIELD, fullName);
        infoPage.sendKeyToElement(driver, NppUserInfoPageUI.ID_NUMBER_FIELD, idNumber);
        infoPage.sendKeyToElement(driver, NppUserInfoPageUI.DOB_FIELD, dateOfBirth);
        infoPage.sendKeyToElement(driver, NppUserInfoPageUI.PHONE_NUMBER_FIELD, phoneNumber);
        infoPage.sendKeyToElement(driver, NppUserInfoPageUI.ADDRESS_FIELD, address);
        infoPage.clickToElement(driver, NppUserInfoPageUI.SAVE_INFO_BUTTON);
        Assert.assertEquals(infoPage.getInfoDistributor("Họ và tên"), fullName);
        Assert.assertEquals(infoPage.getInfoDistributor("CMT/CCCD"), idNumber);
        Assert.assertEquals(infoPage.getInfoDistributor("Ngày sinh"), dateOfBirth);
        Assert.assertEquals(infoPage.getInfoDistributor("Số điện thoại"), phoneNumber);
        Assert.assertEquals(infoPage.getInfoDistributor("Địa chỉ"), address);

    }

    @Test
    public void TC_02_CancelEditInfo(Method method) {
        ExtentTestManager.startTest(method.getName(), "Cancel Edit Info");
        goToNppHomePage();
        infoPage = homePage.clickPersonalInfoIcon();
        infoPage.clickPersonalInfoTab();
        infoPage.clickEditPersonalInfoButton();
        infoPage.clickCancelEditPersonalInfoButton();
    }
}