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

public class UserManagementAddWarehouse extends BaseTest {
    WebDriver driver;

    private String browserName;

    private AdminHomePageUI homePageUI;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;
    private UserManagementHomePageObject userManagementHomePage;
    private CreateUserManagementPageObject createUserManagementPage;
    private CreateWarehousePageObject createWarehousePage;
    private CreateAccountWarehousePageObject createAccountWarehousePage;
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
        position = "Thủ kho";
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
    public void TC_01_Cancel_Warehouse(Method method) {
        ExtentTestManager.startTest(method.getName(), "Cancel Warehouse");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createWarehousePage = createUserManagementPage.clickAddWarehouse();
        createUserManagementPage = createWarehousePage.clickCancelWarehouseButton();
    }

    @Test
    public void TC_02_Add_Warehouse_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Warehouse Empty Data");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createWarehousePage = createUserManagementPage.clickAddWarehouse();

        createWarehousePage.inputToName("");
        createWarehousePage.inputToPhone("");
        createWarehousePage.inputToDateOfBirth("");
        createWarehousePage.inputToIdCard("");
        createWarehousePage.inputToDateRange("");
        createWarehousePage.inputToIssuedBy("");
        createWarehousePage.inputToAddress("");
        createWarehousePage.inputToTimeIn("");
        createWarehousePage.clickNextWarehouseButton();

        assertEquals(createWarehousePage.getErrorMessageName(), "Bạn cần điền vào mục này");
        assertEquals(createWarehousePage.getErrorMessagePhone(), "Bạn cần điền vào mục này");
        assertEquals(createWarehousePage.getErrorMessageDateOfBirth(), "Bạn cần điền vào mục này");
        assertEquals(createWarehousePage.getErrorMessageIdCard(), "Bạn cần điền vào mục này");
        assertEquals(createWarehousePage.getErrorMessageDateRange(), "Bạn cần điền vào mục này");
        assertEquals(createWarehousePage.getErrorMessageIssuedBy(), "Bạn cần điền vào mục này");
        assertEquals(createWarehousePage.getErrorMessageAddress(), "Bạn cần điền vào mục này");
    }

    @Test
    public void TC_03_Add_Warehouse_Empty_Data_In_Dropdown_List(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Add Warehouse Empty Data In Dropdown List");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createWarehousePage = createUserManagementPage.clickAddWarehouse();

        createWarehousePage.inputToName(name);
        createWarehousePage.inputToPhone(phone);
        createWarehousePage.inputToDateOfBirth(dateOfBirth);
        createWarehousePage.inputToIdCard(idCard);
        createWarehousePage.inputToDateRange(dateRange);
        createWarehousePage.inputToIssuedBy(issuedBy);
        createWarehousePage.inputToAddress(address);
        createWarehousePage.inputToTimeIn(timeIn);
        createWarehousePage.clickNextWarehouseButton();

        assertEquals(createWarehousePage.getErrorMessageGender(), "Vui lòng chọn");
        createWarehousePage.inputToGender(gender);
        createWarehousePage.clickToValueGender();

        createWarehousePage.clickNextWarehouseButton();
        assertEquals(createWarehousePage.getErrorMessageMaritalStatus(), "Vui lòng chọn");
    }

    @Test
    public void TC_04_Add_Warehouse_Success(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Warehouse Success");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createWarehousePage = createUserManagementPage.clickAddWarehouse();

        createWarehousePage.inputToName(name);
        createWarehousePage.inputToPhone(phone);
        createWarehousePage.inputToDateOfBirth(dateOfBirth);
        createWarehousePage.inputToIdCard(idCard);
        createWarehousePage.inputToDateRange(dateRange);
        createWarehousePage.inputToIssuedBy(issuedBy);
        createWarehousePage.inputToAddress(address);
        createWarehousePage.inputToTimeIn(timeIn);
        createWarehousePage.clickNextWarehouseButton();
        createWarehousePage.inputToGender(gender);
        createWarehousePage.clickToValueGender();

        createWarehousePage.clickNextWarehouseButton();
        createWarehousePage.inputToMaritalStatus(maritalStatus);
        createWarehousePage.clickToValueMaritalStatus();

        createWarehousePage.inputToPosition(position);
        createWarehousePage.clickToValuePosition();

        createWarehousePage.inputToNationality(nationality);
        createWarehousePage.clickToValueNationality();
        createWarehousePage.inputToNation(nation);
        createWarehousePage.clickToValueNation();
        createAccountWarehousePage = createWarehousePage.clickNextWarehouseButton();
        assertTrue(createAccountWarehousePage.isAccountWarehouseTextDisplayed());
    }

    @Test
    public void TC_05_Add_Warehouse_Account_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Warehouse Account Empty Data");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createWarehousePage = createUserManagementPage.clickAddWarehouse();

        createWarehousePage.inputToName(name);
        createWarehousePage.inputToPhone(phone);
        createWarehousePage.inputToDateOfBirth(dateOfBirth);
        createWarehousePage.inputToIdCard(idCard);
        createWarehousePage.inputToDateRange(dateRange);
        createWarehousePage.inputToIssuedBy(issuedBy);
        createWarehousePage.inputToAddress(address);
        createWarehousePage.inputToTimeIn(timeIn);
        createWarehousePage.clickNextWarehouseButton();
        createWarehousePage.inputToGender(gender);
        createWarehousePage.clickToValueGender();

        createWarehousePage.clickNextWarehouseButton();
        createWarehousePage.inputToMaritalStatus(maritalStatus);
        createWarehousePage.clickToValueMaritalStatus();

        createWarehousePage.inputToPosition(position);
        createWarehousePage.clickToValuePosition();

        createWarehousePage.inputToNationality(nationality);
        createWarehousePage.clickToValueNationality();
        createWarehousePage.inputToNation(nation);
        createWarehousePage.clickToValueNation();
        createAccountWarehousePage = createWarehousePage.clickNextWarehouseButton();

        createAccountWarehousePage.inputToAccount("");
        createAccountWarehousePage.inputToPassWord("");
        createAccountWarehousePage.inputToEmail("");

        createAccountWarehousePage.clickCreateWarehouseButton();

        assertEquals(createAccountWarehousePage.getErrorMessageAccount(), "Bạn cần điền vào mục này");
        assertEquals(createAccountWarehousePage.getErrorMessagePassWord(), "Bạn cần điền vào mục này");
        assertEquals(createAccountWarehousePage.getErrorMessageEmail(), "Bạn cần điền vào mục này");
        assertTrue(createAccountWarehousePage.isModalErrorDisplayed());

        createAccountWarehousePage.closeModalErrorButton();
    }

    @Test
    public void TC_06_Add_Warehouse_Account_Invalid_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Warehouse Account Invalid Data");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createWarehousePage = createUserManagementPage.clickAddWarehouse();

        createWarehousePage.inputToName(name);
        createWarehousePage.inputToPhone(phone);
        createWarehousePage.inputToDateOfBirth(dateOfBirth);
        createWarehousePage.inputToIdCard(idCard);
        createWarehousePage.inputToDateRange(dateRange);
        createWarehousePage.inputToIssuedBy(issuedBy);
        createWarehousePage.inputToAddress(address);
        createWarehousePage.inputToTimeIn(timeIn);
        createWarehousePage.clickNextWarehouseButton();
        createWarehousePage.inputToGender(gender);
        createWarehousePage.clickToValueGender();

        createWarehousePage.clickNextWarehouseButton();
        createWarehousePage.inputToMaritalStatus(maritalStatus);
        createWarehousePage.clickToValueMaritalStatus();

        createWarehousePage.inputToPosition(position);
        createWarehousePage.clickToValuePosition();

        createWarehousePage.inputToNationality(nationality);
        createWarehousePage.clickToValueNationality();
        createWarehousePage.inputToNation(nation);
        createWarehousePage.clickToValueNation();
        createAccountWarehousePage = createWarehousePage.clickNextWarehouseButton();

        createAccountWarehousePage.inputToPassWord(passwordShort);
        createAccountWarehousePage.inputToEmail(emailInvalid);
        assertEquals(createAccountWarehousePage.getErrorMessagePassWord(), "Cần ít nhất 8 ký tự");

        createAccountWarehousePage.inputToPassWord(passwordMissSpecial);
        assertEquals(createAccountWarehousePage.getErrorMessageEmail(), "Không đúng định dạng email");
        createAccountWarehousePage.inputToEmail(emailInvalid);
        assertEquals(createAccountWarehousePage.getErrorMessagePassWord(), "Cần chứa ít nhất 1 ký tự đặc biệt");

        createAccountWarehousePage.inputToPassWord(passwordMissNumber);
        createAccountWarehousePage.inputToEmail(emailInvalid);
        assertEquals(createAccountWarehousePage.getErrorMessagePassWord(), "Cần ít nhất 1 chữ số");
    }

    @Test
    public void TC_07_Add_Accountant_Account_Success(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Accountant Account Success");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createWarehousePage = createUserManagementPage.clickAddWarehouse();

        createWarehousePage.inputToName(name);
        createWarehousePage.inputToPhone(phone);
        createWarehousePage.inputToDateOfBirth(dateOfBirth);
        createWarehousePage.inputToIdCard(idCard);
        createWarehousePage.inputToDateRange(dateRange);
        createWarehousePage.inputToIssuedBy(issuedBy);
        createWarehousePage.inputToAddress(address);
        createWarehousePage.inputToTimeIn(timeIn);
        createWarehousePage.clickNextWarehouseButton();
        createWarehousePage.inputToGender(gender);
        createWarehousePage.clickToValueGender();

        createWarehousePage.clickNextWarehouseButton();
        createWarehousePage.inputToMaritalStatus(maritalStatus);
        createWarehousePage.clickToValueMaritalStatus();

        createWarehousePage.inputToPosition(position);
        createWarehousePage.clickToValuePosition();

        createWarehousePage.inputToNationality(nationality);
        createWarehousePage.clickToValueNationality();
        createWarehousePage.inputToNation(nation);
        createWarehousePage.clickToValueNation();
        createAccountWarehousePage = createWarehousePage.clickNextWarehouseButton();

        createAccountWarehousePage.inputToAccount(account);
        createAccountWarehousePage.inputToPassWord(password);
        createAccountWarehousePage.inputToEmail(email);

        createAccountWarehousePage.clickCreateWarehouseButton();
        userManagementHomePage = createAccountWarehousePage.clickToUserManagementHomePageButton();
        userManagementHomePage.clickViewDetailAllWarehouse();
        detailUserPage = userManagementHomePage.clickViewDetailNewWarehouse();;
        assertEquals(detailUserPage.getUserNameText(), name);
        assertEquals(detailUserPage.getInfoDistributorText("Email"), email);
        assertEquals(detailUserPage.getInfoDistributorText("CMT/CCCD"), idCard);
        assertEquals(detailUserPage.getInfoDistributorText("Ngày cấp"), dateRange);
        assertEquals(detailUserPage.getInfoDistributorText("Nơi cấp"), issuedBy);
        assertEquals(detailUserPage.getInfoDistributorText("Địa chỉ"), address);
        assertEquals(detailUserPage.getInfoDistributorText("Quốc tịch"), nationality);
        assertEquals(detailUserPage.getInfoDistributorText("Dân tộc"), nation);
        assertEquals(detailUserPage.getInfoDistributorText("Tình trạng hôn nhân"), maritalStatus);
        assertEquals(detailUserPage.getInfoDistributorText("Bộ phận"), "Bộ phận kho");
        assertEquals(detailUserPage.getInfoDistributorText("Chức vụ"), position);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
