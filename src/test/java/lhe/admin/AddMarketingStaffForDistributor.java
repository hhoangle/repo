package lhe.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.distributorManagement.DetailDistributorPageObject;
import pageObjects.admin.distributorManagement.DetailUserPageObject;
import pageObjects.admin.distributorManagement.DistributorManagementPageObject;
import pageObjects.admin.userManagement.CreateAccountMarketingStaffPageObject;
import pageObjects.admin.userManagement.CreateMarketingStaffPageObject;
import pageObjects.admin.userManagement.CreateUserManagementPageObject;
import pageObjects.admin.userManagement.UserManagementHomePageObject;
import pageUIs.admin.AdminHomePageUI;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.BasePage.getRandomInt;
import static commons.BasePage.getRandomString;
import static commons.GlobalConstants.ADMIN_LOGIN;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddMarketingStaffForDistributor extends BaseTest {
    WebDriver driver;

    private String browserName;

    private AdminHomePageUI homePageUI;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;
    private UserManagementHomePageObject userManagementHomePage;
    private CreateUserManagementPageObject createUserManagementPage;
    private CreateMarketingStaffPageObject createMarketingStaffPage;
    private CreateAccountMarketingStaffPageObject createAccountMarketingStaffPage;
    private DetailUserPageObject detailUserPage;
    private DistributorManagementPageObject distributorPage;
    private DetailDistributorPageObject detailDistributorPage;

    private String name, gender, phone, maritalStatus, dateOfBirth, idCard, dateRange,
            issuedBy, address, position, region, area, nationality, nation,
            timeIn, account, password, passwordShort, passwordMissNumber, passwordMissSpecial, email, emailInvalid;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, ADMIN_LOGIN);
        loginPage = new AdminLoginPageObject(driver);
        homePage = loginPage.goToAdminHomePage(driver);

        name = "LHETest" + getRandomString();
        gender = "Nam";
        phone = "09876" + getRandomInt();
        maritalStatus = "Độc thân";
        dateOfBirth = "2011-01-01";
        idCard = "0380970" + getRandomInt();
        dateRange = "2011-01-01";
        issuedBy = "Ha Noi";
        address = "Cau Giay, Ha Noi";
        position = "Trưởng phòng thị trường";
        region = "Vùng 1";
        area = "Khu vực 11";
        nationality = "Việt Nam";
        nation = "Kinh";
        timeIn = "2011-01-01";
        passwordShort = "test";
        passwordMissNumber = "LongHaiTest@";
        passwordMissSpecial = "LongHaiTest123";
        emailInvalid = "LongHaiTest";
        account = "Account" + getRandomInt();
        password = "LHETest@123";
        email = "LongHaiTest" + getRandomInt() + "@gmail.com";
    }

    public void goToHomePage() {
        homePage.openPageUrl(driver, ADMIN_LOGIN);
        homePage.clickButtonDragToTheLeft();
    }

    @Test
    public void TC_01_Add_New_Marketing_Staff(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add New Marketing Staff");
        goToHomePage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createMarketingStaffPage = createUserManagementPage.clickAddMarketingStaff();
        createMarketingStaffPage.inputToName(name);
        createMarketingStaffPage.inputToPhone(phone);
        createMarketingStaffPage.inputToDateOfBirth(dateOfBirth);
        createMarketingStaffPage.inputToIdCard(idCard);
        createMarketingStaffPage.inputToDateRange(dateRange);
        createMarketingStaffPage.inputToIssuedBy(issuedBy);
        createMarketingStaffPage.inputToAddress(address);
        createMarketingStaffPage.inputToTimeIn(timeIn);
        createMarketingStaffPage.clickNextMarketingStaffButton();
        createMarketingStaffPage.inputToGender(gender);
        createMarketingStaffPage.clickToValueGender();

        createMarketingStaffPage.clickNextMarketingStaffButton();
        createMarketingStaffPage.inputToMaritalStatus(maritalStatus);
        createMarketingStaffPage.clickToValueMaritalStatus();

        createMarketingStaffPage.inputToPosition(position);
        createMarketingStaffPage.clickToValuePosition();

        createMarketingStaffPage.inputToRegion(region);
        createMarketingStaffPage.clickToValueRegion();
        createMarketingStaffPage.inputToArea(area);
        createMarketingStaffPage.clickToValueArea();

        createMarketingStaffPage.inputToNationality(nationality);
        createMarketingStaffPage.clickToValueNationality();
        createMarketingStaffPage.inputToNation(nation);
        createMarketingStaffPage.clickToValueNation();
        createAccountMarketingStaffPage = createMarketingStaffPage.clickNextMarketingStaffButton();
        assertTrue(createAccountMarketingStaffPage.isAccountMarketingStaffTextDisplayed());
    }

    @Test
    public void TC_02_Add_Marketing_Staff_Account_Success(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Marketing Staff Account Success");
        goToHomePage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createMarketingStaffPage = createUserManagementPage.clickAddMarketingStaff();
        createMarketingStaffPage.inputToName(name);
        createMarketingStaffPage.inputToPhone(phone);
        createMarketingStaffPage.inputToDateOfBirth(dateOfBirth);
        createMarketingStaffPage.inputToIdCard(idCard);
        createMarketingStaffPage.inputToDateRange(dateRange);
        createMarketingStaffPage.inputToIssuedBy(issuedBy);
        createMarketingStaffPage.inputToAddress(address);
        createMarketingStaffPage.inputToTimeIn(timeIn);
        createMarketingStaffPage.clickNextMarketingStaffButton();
        createMarketingStaffPage.inputToGender(gender);
        createMarketingStaffPage.clickToValueGender();

        createMarketingStaffPage.clickNextMarketingStaffButton();
        createMarketingStaffPage.inputToMaritalStatus(maritalStatus);
        createMarketingStaffPage.clickToValueMaritalStatus();

        createMarketingStaffPage.inputToPosition(position);
        createMarketingStaffPage.clickToValuePosition();

        createMarketingStaffPage.inputToRegion(region);
        createMarketingStaffPage.clickToValueRegion();
        createMarketingStaffPage.inputToArea(area);
        createMarketingStaffPage.clickToValueArea();

        createMarketingStaffPage.inputToNationality(nationality);
        createMarketingStaffPage.clickToValueNationality();
        createMarketingStaffPage.inputToNation(nation);
        createMarketingStaffPage.clickToValueNation();
        createAccountMarketingStaffPage = createMarketingStaffPage.clickNextMarketingStaffButton();

        createAccountMarketingStaffPage.inputToAccountMarketingStaff(account);
        createAccountMarketingStaffPage.inputToPassWordMarketingStaff(password);
        createAccountMarketingStaffPage.inputToEmailMarketingStaff(email);

        createAccountMarketingStaffPage.clickCreateMarketingStaffButton();
        userManagementHomePage = createAccountMarketingStaffPage.clickToUserManagementHomePageButton();

        userManagementHomePage.clickViewDetailAllMarketingStaff();
        detailUserPage = userManagementHomePage.clickViewDetailNewMarketingStaff();
        assertEquals(detailUserPage.getUserNameText(), name);
        assertEquals(detailUserPage.getInfoDistributorText("Email"), email);
        assertEquals(detailUserPage.getInfoDistributorText("Giới tính"), gender);
        assertEquals(detailUserPage.getInfoDistributorText("CMT/CCCD"), idCard);
        assertEquals(detailUserPage.getInfoDistributorText("Ngày cấp"), dateRange);
        assertEquals(detailUserPage.getInfoDistributorText("Nơi cấp"), issuedBy);
        assertEquals(detailUserPage.getInfoDistributorText("Địa chỉ"), address);
        assertEquals(detailUserPage.getInfoDistributorText("Quốc tịch"), nationality);
        assertEquals(detailUserPage.getInfoDistributorText("Dân tộc"), nation);
        assertEquals(detailUserPage.getInfoDistributorText("Tình trạng hôn nhân"), maritalStatus);
        assertEquals(detailUserPage.getInfoDistributorText("Vùng"), region);
        assertEquals(detailUserPage.getInfoDistributorText("Khu vực"), area);
        assertEquals(detailUserPage.getInfoDistributorText("Bộ phận"), "Phòng thị trường");
        assertEquals(detailUserPage.getInfoDistributorText("Chức vụ"), position);
        assertEquals(detailUserPage.getInfoDistributorText("Ngày vào"), timeIn);
    }

    @Test
    public void TC_03_Add_Marketing_Staff_For_Distributor(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Marketing Staff For Distributor");
        goToHomePage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createMarketingStaffPage = createUserManagementPage.clickAddMarketingStaff();
        createMarketingStaffPage.inputToName(name);
        createMarketingStaffPage.inputToPhone(phone);
        createMarketingStaffPage.inputToDateOfBirth(dateOfBirth);
        createMarketingStaffPage.inputToIdCard(idCard);
        createMarketingStaffPage.inputToDateRange(dateRange);
        createMarketingStaffPage.inputToIssuedBy(issuedBy);
        createMarketingStaffPage.inputToAddress(address);
        createMarketingStaffPage.inputToTimeIn(timeIn);
        createMarketingStaffPage.clickNextMarketingStaffButton();
        createMarketingStaffPage.inputToGender(gender);
        createMarketingStaffPage.clickToValueGender();

        createMarketingStaffPage.clickNextMarketingStaffButton();
        createMarketingStaffPage.inputToMaritalStatus(maritalStatus);
        createMarketingStaffPage.clickToValueMaritalStatus();

        createMarketingStaffPage.inputToPosition(position);
        createMarketingStaffPage.clickToValuePosition();

        createMarketingStaffPage.inputToRegion(region);
        createMarketingStaffPage.clickToValueRegion();
        createMarketingStaffPage.inputToArea(area);
        createMarketingStaffPage.clickToValueArea();

        createMarketingStaffPage.inputToNationality(nationality);
        createMarketingStaffPage.clickToValueNationality();
        createMarketingStaffPage.inputToNation(nation);
        createMarketingStaffPage.clickToValueNation();
        createAccountMarketingStaffPage = createMarketingStaffPage.clickNextMarketingStaffButton();

        createAccountMarketingStaffPage.inputToAccountMarketingStaff(account);
        createAccountMarketingStaffPage.inputToPassWordMarketingStaff(password);
        createAccountMarketingStaffPage.inputToEmailMarketingStaff(email);

        createAccountMarketingStaffPage.clickCreateMarketingStaffButton();
        userManagementHomePage = createAccountMarketingStaffPage.clickToUserManagementHomePageButton();

        homePage = userManagementHomePage.clickGoToAdminHomePageIcon(driver);
        homePage.clickButtonDragToTheLeft();
        distributorPage = homePage.clickDistributorManagementButton();
        detailDistributorPage = distributorPage.clickViewDetailDistributorButton();
        detailDistributorPage.clickStaffTab();
        detailDistributorPage.clickAddNewStaffButton();
        detailDistributorPage.dragAndDropIcon();
        detailDistributorPage.inputSearchStaff(name);
        detailDistributorPage.clickSelectStaffCheckbox(name);
        detailDistributorPage.clickAddStaffButtonInModal();
        detailDistributorPage.clickCloseModalButton();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
