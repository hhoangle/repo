package lhe.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.distributorManagement.DetailUserPageObject;
import pageObjects.admin.userManagement.*;
import pageUIs.admin.AdminHomePageUI;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.BasePage.getRandomInt;
import static commons.BasePage.getRandomString;
import static commons.GlobalConstants.ADMIN_LOGIN;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserManagementAddAdmin extends BaseTest {
    WebDriver driver;

    private String browserName;

    private AdminHomePageUI homePageUI;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;
    private UserManagementHomePageObject userManagementHomePage;
    private CreateUserManagementPageObject createUserManagementPage;
    private CreateAdminPageObject createAdminPage;
    private CreateAccountAdminPageObject createAccountAdminPage;
    private DetailUserPageObject detailUserPage;

    private String name, gender, phone, maritalStatus, dateOfBirth, idCard, dateRange,
            issuedBy, address, position, nationality, nation,
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
        position = "Chủ tịch";
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

    public void goToHomPage() {
        homePage.openPageUrl(driver, ADMIN_LOGIN);
        homePage.clickButtonDragToTheLeft();
    }

    @Test
    public void TC_01_Cancel_Admin(Method method) {
        ExtentTestManager.startTest(method.getName(), "Cancel Admin");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createAdminPage = createUserManagementPage.clickAddAdmin();
        createUserManagementPage = createAdminPage.clickCancelWarehouseButton();
    }

    @Test
    public void TC_02_Add_Admin_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Admin Empty Data");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createAdminPage = createUserManagementPage.clickAddAdmin();

        createAdminPage.inputToName("");
        createAdminPage.inputToPhone("");
        createAdminPage.inputToDateOfBirth("");
        createAdminPage.inputToIdCard("");
        createAdminPage.inputToDateRange("");
        createAdminPage.inputToIssuedBy("");
        createAdminPage.inputToAddress("");
        createAdminPage.inputToTimeIn("");
        createAdminPage.clickNextWarehouseButton();

        assertEquals(createAdminPage.getErrorMessageName(), "Bạn cần điền vào mục này");
        assertEquals(createAdminPage.getErrorMessagePhone(), "Bạn cần điền vào mục này");
        assertEquals(createAdminPage.getErrorMessageDateOfBirth(), "Bạn cần điền vào mục này");
        assertEquals(createAdminPage.getErrorMessageIdCard(), "Bạn cần điền vào mục này");
        assertEquals(createAdminPage.getErrorMessageDateRange(), "Bạn cần điền vào mục này");
        assertEquals(createAdminPage.getErrorMessageIssuedBy(), "Bạn cần điền vào mục này");
        assertEquals(createAdminPage.getErrorMessageAddress(), "Bạn cần điền vào mục này");
    }

    @Test
    public void TC_03_Add_Admin_Empty_Data_In_Dropdown_List(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Add Admin Empty Data In Dropdown List");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createAdminPage = createUserManagementPage.clickAddAdmin();

        createAdminPage.inputToName(name);
        createAdminPage.inputToPhone(phone);
        createAdminPage.inputToDateOfBirth(dateOfBirth);
        createAdminPage.inputToIdCard(idCard);
        createAdminPage.inputToDateRange(dateRange);
        createAdminPage.inputToIssuedBy(issuedBy);
        createAdminPage.inputToAddress(address);
        createAdminPage.inputToTimeIn(timeIn);
        createAdminPage.clickNextWarehouseButton();

        assertEquals(createAdminPage.getErrorMessageGender(), "Vui lòng chọn");
        createAdminPage.inputToGender(gender);
        createAdminPage.clickToValueGender();

        createAdminPage.clickNextWarehouseButton();
        assertEquals(createAdminPage.getErrorMessageMaritalStatus(), "Vui lòng chọn");
    }

    @Test
    public void TC_04_Add_Admin_Success(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Admin Success");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createAdminPage = createUserManagementPage.clickAddAdmin();

        createAdminPage.inputToName(name);
        createAdminPage.inputToPhone(phone);
        createAdminPage.inputToDateOfBirth(dateOfBirth);
        createAdminPage.inputToIdCard(idCard);
        createAdminPage.inputToDateRange(dateRange);
        createAdminPage.inputToIssuedBy(issuedBy);
        createAdminPage.inputToAddress(address);
        createAdminPage.inputToTimeIn(timeIn);
        createAdminPage.clickNextWarehouseButton();
        createAdminPage.inputToGender(gender);
        createAdminPage.clickToValueGender();

        createAdminPage.clickNextWarehouseButton();
        createAdminPage.inputToMaritalStatus(maritalStatus);
        createAdminPage.clickToValueMaritalStatus();

        createAdminPage.inputToPosition(position);
        createAdminPage.clickToValuePosition();

        createAdminPage.inputToNationality(nationality);
        createAdminPage.clickToValueNationality();
        createAdminPage.inputToNation(nation);
        createAdminPage.clickToValueNation();
        createAccountAdminPage = createAdminPage.clickNextWarehouseButton();
        assertTrue(createAccountAdminPage.isAccountAdminTextDisplayed());
    }

    @Test
    public void TC_05_Add_Warehouse_Account_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Warehouse Account Empty Data");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createAdminPage = createUserManagementPage.clickAddAdmin();

        createAdminPage.inputToName(name);
        createAdminPage.inputToPhone(phone);
        createAdminPage.inputToDateOfBirth(dateOfBirth);
        createAdminPage.inputToIdCard(idCard);
        createAdminPage.inputToDateRange(dateRange);
        createAdminPage.inputToIssuedBy(issuedBy);
        createAdminPage.inputToAddress(address);
        createAdminPage.inputToTimeIn(timeIn);
        createAdminPage.clickNextWarehouseButton();
        createAdminPage.inputToGender(gender);
        createAdminPage.clickToValueGender();

        createAdminPage.clickNextWarehouseButton();
        createAdminPage.inputToMaritalStatus(maritalStatus);
        createAdminPage.clickToValueMaritalStatus();

        createAdminPage.inputToPosition(position);
        createAdminPage.clickToValuePosition();

        createAdminPage.inputToNationality(nationality);
        createAdminPage.clickToValueNationality();
        createAdminPage.inputToNation(nation);
        createAdminPage.clickToValueNation();
        createAccountAdminPage = createAdminPage.clickNextWarehouseButton();

        createAccountAdminPage.inputToAccount("");
        createAccountAdminPage.inputToPassWord("");
        createAccountAdminPage.inputToEmail("");

        createAccountAdminPage.clickCreateWarehouseButton();

        assertEquals(createAccountAdminPage.getErrorMessageAccount(), "Bạn cần điền vào mục này");
        assertEquals(createAccountAdminPage.getErrorMessagePassWord(), "Bạn cần điền vào mục này");
        assertEquals(createAccountAdminPage.getErrorMessageEmail(), "Bạn cần điền vào mục này");
        assertTrue(createAccountAdminPage.isModalErrorDisplayed());

        createAccountAdminPage.closeModalErrorButton();
    }

    @Test
    public void TC_06_Add_Warehouse_Account_Invalid_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Warehouse Account Invalid Data");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createAdminPage = createUserManagementPage.clickAddAdmin();

        createAdminPage.inputToName(name);
        createAdminPage.inputToPhone(phone);
        createAdminPage.inputToDateOfBirth(dateOfBirth);
        createAdminPage.inputToIdCard(idCard);
        createAdminPage.inputToDateRange(dateRange);
        createAdminPage.inputToIssuedBy(issuedBy);
        createAdminPage.inputToAddress(address);
        createAdminPage.inputToTimeIn(timeIn);
        createAdminPage.clickNextWarehouseButton();
        createAdminPage.inputToGender(gender);
        createAdminPage.clickToValueGender();

        createAdminPage.clickNextWarehouseButton();
        createAdminPage.inputToMaritalStatus(maritalStatus);
        createAdminPage.clickToValueMaritalStatus();

        createAdminPage.inputToPosition(position);
        createAdminPage.clickToValuePosition();

        createAdminPage.inputToNationality(nationality);
        createAdminPage.clickToValueNationality();
        createAdminPage.inputToNation(nation);
        createAdminPage.clickToValueNation();
        createAccountAdminPage = createAdminPage.clickNextWarehouseButton();

        createAccountAdminPage.inputToPassWord(passwordShort);
        createAccountAdminPage.inputToEmail(emailInvalid);
        assertEquals(createAccountAdminPage.getErrorMessagePassWord(), "Cần ít nhất 8 ký tự");

        createAccountAdminPage.inputToPassWord(passwordMissSpecial);
        assertEquals(createAccountAdminPage.getErrorMessageEmail(), "Không đúng định dạng email");
        createAccountAdminPage.inputToEmail(emailInvalid);
        assertEquals(createAccountAdminPage.getErrorMessagePassWord(), "Cần chứa ít nhất 1 ký tự đặc biệt");

        createAccountAdminPage.inputToPassWord(passwordMissNumber);
        createAccountAdminPage.inputToEmail(emailInvalid);
        assertEquals(createAccountAdminPage.getErrorMessagePassWord(), "Cần ít nhất 1 chữ số");
    }

    @Test
    public void TC_07_Add_Accountant_Account_Success(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Accountant Account Success");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createAdminPage = createUserManagementPage.clickAddAdmin();

        createAdminPage.inputToName(name);
        createAdminPage.inputToPhone(phone);
        createAdminPage.inputToDateOfBirth(dateOfBirth);
        createAdminPage.inputToIdCard(idCard);
        createAdminPage.inputToDateRange(dateRange);
        createAdminPage.inputToIssuedBy(issuedBy);
        createAdminPage.inputToAddress(address);
        createAdminPage.inputToTimeIn(timeIn);
        createAdminPage.clickNextWarehouseButton();
        createAdminPage.inputToGender(gender);
        createAdminPage.clickToValueGender();

        createAdminPage.clickNextWarehouseButton();
        createAdminPage.inputToMaritalStatus(maritalStatus);
        createAdminPage.clickToValueMaritalStatus();

        createAdminPage.inputToPosition(position);
        createAdminPage.clickToValuePosition();

        createAdminPage.inputToNationality(nationality);
        createAdminPage.clickToValueNationality();
        createAdminPage.inputToNation(nation);
        createAdminPage.clickToValueNation();
        createAccountAdminPage = createAdminPage.clickNextWarehouseButton();

        createAccountAdminPage.inputToAccount(account);
        createAccountAdminPage.inputToPassWord(password);
        createAccountAdminPage.inputToEmail(email);

        createAccountAdminPage.clickCreateWarehouseButton();
        userManagementHomePage = createAccountAdminPage.clickToUserManagementHomePageButton();

        userManagementHomePage.clickViewDetailAllAdmin();
        detailUserPage = userManagementHomePage.clickViewDetailNewAdmin();;
        assertEquals(detailUserPage.getUserNameText(), name);
        assertEquals(detailUserPage.getInfoDistributorText("Email"), email);
        assertEquals(detailUserPage.getInfoDistributorText("CMT/CCCD"), idCard);
        assertEquals(detailUserPage.getInfoDistributorText("Ngày cấp"), dateRange);
        assertEquals(detailUserPage.getInfoDistributorText("Nơi cấp"), issuedBy);
        assertEquals(detailUserPage.getInfoDistributorText("Địa chỉ"), address);
        assertEquals(detailUserPage.getInfoDistributorText("Quốc tịch"), nationality);
        assertEquals(detailUserPage.getInfoDistributorText("Dân tộc"), nation);
        assertEquals(detailUserPage.getInfoDistributorText("Tình trạng hôn nhân"), maritalStatus);
        assertEquals(detailUserPage.getInfoDistributorText("Bộ phận"), "Ban lãnh đạo");
        assertEquals(detailUserPage.getInfoDistributorText("Chức vụ"), position);
        assertEquals(detailUserPage.getInfoDistributorText("Ngày vào"), timeIn);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
