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

public class UserManagementAddAccountant extends BaseTest {
    WebDriver driver;

    private String browserName;

    private AdminHomePageUI homePageUI;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;
    private UserManagementHomePageObject userManagementHomePage;
    private CreateUserManagementPageObject createUserManagementPage;
    private CreateAccountantPageObject createAccountantPage;
    private CreateAccountAccountantPageObject createAccountAccountantPage;
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
        position = "Trưởng phòng";
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
    public void TC_01_Cancel_Accountant(Method method) {
        ExtentTestManager.startTest(method.getName(), "Cancel Accountant");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createAccountantPage = createUserManagementPage.clickAddAccountant();
        createUserManagementPage = createAccountantPage.clickCancelAccountantButton();
    }

    @Test
    public void TC_02_Add_Accountant_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Accountant Empty Data");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createAccountantPage = createUserManagementPage.clickAddAccountant();
        createAccountantPage.inputToName("");
        createAccountantPage.inputToPhone("");
        createAccountantPage.inputToDateOfBirth("");
        createAccountantPage.inputToIdCard("");
        createAccountantPage.inputToDateRange("");
        createAccountantPage.inputToIssuedBy("");
        createAccountantPage.inputToAddress("");
        createAccountantPage.inputToTimeIn("");
        createAccountantPage.clickNextAccountantButton();

        assertEquals(createAccountantPage.getErrorMessageName(), "Bạn cần điền vào mục này");
        assertEquals(createAccountantPage.getErrorMessagePhone(), "Bạn cần điền vào mục này");
        assertEquals(createAccountantPage.getErrorMessageDateOfBirth(), "Bạn cần điền vào mục này");
        assertEquals(createAccountantPage.getErrorMessageIdCard(), "Bạn cần điền vào mục này");
        assertEquals(createAccountantPage.getErrorMessageDateRange(), "Bạn cần điền vào mục này");
        assertEquals(createAccountantPage.getErrorMessageIssuedBy(), "Bạn cần điền vào mục này");
        assertEquals(createAccountantPage.getErrorMessageAddress(), "Bạn cần điền vào mục này");
    }

    @Test
    public void TC_03_Add_Accountant_Empty_Data_In_Dropdown_List(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Add Accountant Empty Data In Dropdown List");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createAccountantPage = createUserManagementPage.clickAddAccountant();
        createAccountantPage.inputToName(name);
        createAccountantPage.inputToPhone(phone);
        createAccountantPage.inputToDateOfBirth(dateOfBirth);
        createAccountantPage.inputToIdCard(idCard);
        createAccountantPage.inputToDateRange(dateRange);
        createAccountantPage.inputToIssuedBy(issuedBy);
        createAccountantPage.inputToAddress(address);
        createAccountantPage.inputToTimeIn(timeIn);
        createAccountantPage.clickNextAccountantButton();

        assertEquals(createAccountantPage.getErrorMessageGender(), "Vui lòng chọn");
        createAccountantPage.inputToGender(gender);
        createAccountantPage.clickToValueGender();

        createAccountantPage.clickNextAccountantButton();
        assertEquals(createAccountantPage.getErrorMessageMaritalStatus(), "Vui lòng chọn");
    }

    @Test
    public void TC_04_Add_Accountant_Success(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Accountant Success");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createAccountantPage = createUserManagementPage.clickAddAccountant();
        createAccountantPage.inputToName(name);
        createAccountantPage.inputToPhone(phone);
        createAccountantPage.inputToDateOfBirth(dateOfBirth);
        createAccountantPage.inputToIdCard(idCard);
        createAccountantPage.inputToDateRange(dateRange);
        createAccountantPage.inputToIssuedBy(issuedBy);
        createAccountantPage.inputToAddress(address);
        createAccountantPage.inputToTimeIn(timeIn);
        createAccountantPage.clickNextAccountantButton();
        createAccountantPage.inputToGender(gender);
        createAccountantPage.clickToValueGender();

        createAccountantPage.clickNextAccountantButton();
        createAccountantPage.inputToMaritalStatus(maritalStatus);
        createAccountantPage.clickToValueMaritalStatus();

        createAccountantPage.inputToPosition(position);
        createAccountantPage.clickToValuePosition();

        createAccountantPage.inputToNationality(nationality);
        createAccountantPage.clickToValueNationality();
        createAccountantPage.inputToNation(nation);
        createAccountantPage.clickToValueNation();
        createAccountAccountantPage = createAccountantPage.clickNextAccountantButton();
        assertTrue(createAccountAccountantPage.isAccountAccountantTextDisplayed());
    }

    @Test
    public void TC_05_Add_Accountant_Account_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Accountant Account Empty Data");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createAccountantPage = createUserManagementPage.clickAddAccountant();
        createAccountantPage.inputToName(name);
        createAccountantPage.inputToPhone(phone);
        createAccountantPage.inputToDateOfBirth(dateOfBirth);
        createAccountantPage.inputToIdCard(idCard);
        createAccountantPage.inputToDateRange(dateRange);
        createAccountantPage.inputToIssuedBy(issuedBy);
        createAccountantPage.inputToAddress(address);
        createAccountantPage.inputToTimeIn(timeIn);
        createAccountantPage.clickNextAccountantButton();
        createAccountantPage.inputToGender(gender);
        createAccountantPage.clickToValueGender();

        createAccountantPage.clickNextAccountantButton();
        createAccountantPage.inputToMaritalStatus(maritalStatus);
        createAccountantPage.clickToValueMaritalStatus();

        createAccountantPage.inputToPosition(position);
        createAccountantPage.clickToValuePosition();

        createAccountantPage.inputToNationality(nationality);
        createAccountantPage.clickToValueNationality();
        createAccountantPage.inputToNation(nation);
        createAccountantPage.clickToValueNation();
        createAccountAccountantPage = createAccountantPage.clickNextAccountantButton();

        createAccountAccountantPage.inputToAccount("");
        createAccountAccountantPage.inputToPassWord("");
        createAccountAccountantPage.inputToEmail("");

        createAccountAccountantPage.clickCreateAccountantButton();

        assertEquals(createAccountAccountantPage.getErrorMessageAccount(), "Bạn cần điền vào mục này");
        assertEquals(createAccountAccountantPage.getErrorMessagePassWordMarketingStaff(), "Bạn cần điền vào mục này");
        assertEquals(createAccountAccountantPage.getErrorMessageEmail(), "Bạn cần điền vào mục này");
        assertTrue(createAccountAccountantPage.isModalErrorDisplayed());

        createAccountAccountantPage.closeModalErrorButton();
    }

    @Test
    public void TC_06_Add_Accountant_Account_Invalid_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Accountant Account Invalid Data");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createAccountantPage = createUserManagementPage.clickAddAccountant();
        createAccountantPage.inputToName(name);
        createAccountantPage.inputToPhone(phone);
        createAccountantPage.inputToDateOfBirth(dateOfBirth);
        createAccountantPage.inputToIdCard(idCard);
        createAccountantPage.inputToDateRange(dateRange);
        createAccountantPage.inputToIssuedBy(issuedBy);
        createAccountantPage.inputToAddress(address);
        createAccountantPage.inputToTimeIn(timeIn);
        createAccountantPage.clickNextAccountantButton();
        createAccountantPage.inputToGender(gender);
        createAccountantPage.clickToValueGender();

        createAccountantPage.clickNextAccountantButton();
        createAccountantPage.inputToMaritalStatus(maritalStatus);
        createAccountantPage.clickToValueMaritalStatus();

        createAccountantPage.inputToPosition(position);
        createAccountantPage.clickToValuePosition();

        createAccountantPage.inputToNationality(nationality);
        createAccountantPage.clickToValueNationality();
        createAccountantPage.inputToNation(nation);
        createAccountantPage.clickToValueNation();
        createAccountAccountantPage = createAccountantPage.clickNextAccountantButton();

        createAccountAccountantPage.inputToPassWord(passwordShort);
        createAccountAccountantPage.inputToEmail(emailInvalid);
        assertEquals(createAccountAccountantPage.getErrorMessagePassWordMarketingStaff(), "Cần ít nhất 8 ký tự");

        createAccountAccountantPage.inputToPassWord(passwordMissSpecial);
        assertEquals(createAccountAccountantPage.getErrorMessageEmail(), "Không đúng định dạng email");
        createAccountAccountantPage.inputToEmail(emailInvalid);
        assertEquals(createAccountAccountantPage.getErrorMessagePassWordMarketingStaff(), "Cần chứa ít nhất 1 ký tự đặc biệt");

        createAccountAccountantPage.inputToPassWord(passwordMissNumber);
        createAccountAccountantPage.inputToEmail(emailInvalid);
        assertEquals(createAccountAccountantPage.getErrorMessagePassWordMarketingStaff(), "Cần ít nhất 1 chữ số");
    }

    @Test
    public void TC_07_Add_Accountant_Account_Success(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Accountant Account Success");
        goToHomPage();
        userManagementHomePage = homePage.clickUserManagementButton();
        createUserManagementPage = userManagementHomePage.clickAddUserManagementButton();
        createAccountantPage = createUserManagementPage.clickAddAccountant();
        createAccountantPage.inputToName(name);
        createAccountantPage.inputToPhone(phone);
        createAccountantPage.inputToDateOfBirth(dateOfBirth);
        createAccountantPage.inputToIdCard(idCard);
        createAccountantPage.inputToDateRange(dateRange);
        createAccountantPage.inputToIssuedBy(issuedBy);
        createAccountantPage.inputToAddress(address);
        createAccountantPage.inputToTimeIn(timeIn);
        createAccountantPage.clickNextAccountantButton();
        createAccountantPage.inputToGender(gender);
        createAccountantPage.clickToValueGender();

        createAccountantPage.clickNextAccountantButton();
        createAccountantPage.inputToMaritalStatus(maritalStatus);
        createAccountantPage.clickToValueMaritalStatus();

        createAccountantPage.inputToPosition(position);
        createAccountantPage.clickToValuePosition();

        createAccountantPage.inputToNationality(nationality);
        createAccountantPage.clickToValueNationality();
        createAccountantPage.inputToNation(nation);
        createAccountantPage.clickToValueNation();
        createAccountAccountantPage = createAccountantPage.clickNextAccountantButton();

        createAccountAccountantPage.inputToAccount(account);
        createAccountAccountantPage.inputToPassWord(password);
        createAccountAccountantPage.inputToEmail(email);

        createAccountAccountantPage.clickCreateAccountantButton();
        userManagementHomePage = createAccountAccountantPage.clickToUserManagementHomePageButton();

        userManagementHomePage.clickViewDetailAllAccountant();
        detailUserPage = userManagementHomePage.clickViewDetailNewAccountant();;
        assertEquals(detailUserPage.getUserNameText(), name);
        assertEquals(detailUserPage.getInfoDistributorText("Email"), email);
        assertEquals(detailUserPage.getInfoDistributorText("CMT/CCCD"), idCard);
        assertEquals(detailUserPage.getInfoDistributorText("Ngày cấp"), dateRange);
        assertEquals(detailUserPage.getInfoDistributorText("Nơi cấp"), issuedBy);
        assertEquals(detailUserPage.getInfoDistributorText("Địa chỉ"), address);
        assertEquals(detailUserPage.getInfoDistributorText("Quốc tịch"), nationality);
        assertEquals(detailUserPage.getInfoDistributorText("Dân tộc"), nation);
        assertEquals(detailUserPage.getInfoDistributorText("Tình trạng hôn nhân"), maritalStatus);
        assertEquals(detailUserPage.getInfoDistributorText("Bộ phận"), "Phòng Kế toán");
        assertEquals(detailUserPage.getInfoDistributorText("Chức vụ"), position);
        assertEquals(detailUserPage.getInfoDistributorText("Ngày vào"), timeIn);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
