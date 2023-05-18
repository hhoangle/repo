package lhe.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.distributorManagement.CreateAccountDistributorPageObject;
import pageObjects.admin.distributorManagement.CreateInformationDistributorPageObject;
import pageObjects.admin.distributorManagement.DetailUserPageObject;
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

public class UserManagementAddDistributor extends BaseTest {
    WebDriver driver;

    private String browserName;

    private AdminHomePageUI homePageUI;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;
    private UserManagementHomePageObject userManagementHomePage;
    private CreateUserManagementPageObject createUserManagementPage;
    private CreateInformationDistributorPageObject createInformationDistributorPage;
    private CreateAccountDistributorPageObject createAccountDistributorPage;
    private DetailUserPageObject detailUserPage;
    private String representative, phone, taxCode, idCard, dateRange, issuedBy, enterAddress, region,
            area, businessModel, warehouseArea, labor, timeIn, distributionRoomCode, marketRoomCode,
            accountDistributor, passwordDistributor, emailDistributor;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, ADMIN_LOGIN);
        loginPage = new AdminLoginPageObject(driver);
        homePage = loginPage.goToAdminHomePage(driver);

        representative = "LHETest" + getRandomString();
        phone = "09876" + getRandomInt();
        taxCode = "01234" + getRandomInt();
        idCard = "0380970" + getRandomInt();
        dateRange = "2011-01-01";
        issuedBy = "Ha Noi";
        enterAddress = "Cau Giay, Ha Noi";
        region = "Vùng 1";
        area = "Khu vực 11";
        businessModel = "Công ty";
        warehouseArea = "1000";
        labor = "20";
        timeIn = "2020-01-01";
        distributionRoomCode = "AD1";
        marketRoomCode = "AD1";
        accountDistributor = "Account" + getRandomInt();
        passwordDistributor = "LHETest@123";
        emailDistributor = "LongHaiTest" + getRandomInt() + "@gmail.com";
        passwordDistributor = "LHETest@123";
    }

    public void goToHomPage() {
        homePage.openPageUrl(driver, ADMIN_LOGIN);
        homePage.clickButtonDragToTheLeft();
    }

    @Test
    public void TC_01_Add_Distributor_Management(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Distributor Management");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createInformationDistributorPage = createUserManagementPage.clickAddDistributorManagement();

        createInformationDistributorPage.inputByPlaceholder(driver, "Nơi cấp", issuedBy);
        createInformationDistributorPage.inputByPlaceholder(driver, "Người đại diện", representative);
        createInformationDistributorPage.inputByPlaceholder(driver, "Số điện thoại", phone);

        createInformationDistributorPage.inputToTaxCode(taxCode);
        createInformationDistributorPage.inputToIdCard(idCard);
        createInformationDistributorPage.inputByPlaceholder(driver, "Ngày cấp", dateRange);
        createInformationDistributorPage.clickToSelectAddress();
        createInformationDistributorPage.clickToSelectCity();
        createInformationDistributorPage.clickToSelectDistrict();
        createInformationDistributorPage.clickToSelectWard();
        createInformationDistributorPage.inputByPlaceholder(driver, "Địa chỉ cụ thể", enterAddress);

        createInformationDistributorPage.scrollToBottomPage(driver);

        createInformationDistributorPage.inputByPlaceholder(driver, "Mã chiện - Phòng thị trường tạo", marketRoomCode);
        createInformationDistributorPage.inputByPlaceholder(driver, "Mã NPP - Phòng kế toán tạo", distributionRoomCode);
        createInformationDistributorPage.inputByPlaceholder(driver, "Thời gian vào", timeIn);
        createInformationDistributorPage.inputByPlaceholder(driver, "Diện tích kho", warehouseArea);
        createInformationDistributorPage.inputToWarehouseArea(warehouseArea);
        createInformationDistributorPage.inputToLabor(labor);
        createInformationDistributorPage.selectItemInCustomDropdown(driver, homePageUI.BUSINESS_MODEL_TEXT, homePageUI.BUSINESS_MODEL_VALUE, businessModel);

        createInformationDistributorPage.clickToInputRegion();
        createInformationDistributorPage.selectItemInCustomDropdown(driver, homePageUI.REGION_INPUT_TEXT, homePageUI.REGION_VALUE, region);
        createInformationDistributorPage.clickToInputArea();
        createInformationDistributorPage.selectItemInCustomDropdown(driver, homePageUI.AREA_INPUT_TEXT, homePageUI.AREA_VALUE, area);

        createAccountDistributorPage = createInformationDistributorPage.clickNextButton();
        assertTrue(createAccountDistributorPage.isCreateUserTextDisplayed());

        createAccountDistributorPage.inputToAccountDistributor(accountDistributor);
        createAccountDistributorPage.inputToPassWordDistributor(passwordDistributor);
        createAccountDistributorPage.inputToEmailDistributor(emailDistributor);

        createAccountDistributorPage.clickCreateButton();
        userManagementHomePage = createAccountDistributorPage.clickToBackCreateDistributorPageButton();
        assertTrue(userManagementHomePage.representativeDisplayed(representative), representative);
        userManagementHomePage.clickViewDetailAllDistributor();
        detailUserPage = userManagementHomePage.clickViewDetailNewDistributor();
        assertEquals(detailUserPage.getUserNameText(), representative);
        assertEquals(detailUserPage.getInfoDistributorText("Email"), emailDistributor);
        assertEquals(detailUserPage.getInfoDistributorText("CMT/CCCD"), idCard);
        assertEquals(detailUserPage.getInfoDistributorText("Ngày cấp"), dateRange);
        assertEquals(detailUserPage.getInfoDistributorText("Nơi cấp"), issuedBy);
        assertEquals(detailUserPage.getInfoDistributorText("Địa chỉ"), enterAddress);
        assertEquals(detailUserPage.getInfoDistributorText("Vùng"), region);
        assertEquals(detailUserPage.getInfoDistributorText("Khu vực"), area);
        assertEquals(detailUserPage.getInfoDistributorText("Diện tích kho"), warehouseArea);
        assertEquals(detailUserPage.getInfoDistributorText("Số lượng nhân công"), labor);
        assertEquals(detailUserPage.getInfoDistributorText("Ngày vào"), timeIn);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
