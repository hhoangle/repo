package lhe.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.distributorManagement.CreateAccountDistributorPageObject;
import pageObjects.admin.distributorManagement.DetailUserPageObject;
import pageObjects.admin.distributorManagement.DistributorManagementPageObject;
import pageObjects.admin.distributorManagement.CreateInformationDistributorPageObject;
import pageObjects.admin.userManagement.UserManagementHomePageObject;
import pageUIs.admin.AdminHomePageUI;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.BasePage.getRandomInt;
import static commons.BasePage.getRandomString;
import static commons.GlobalConstants.ADMIN_LOGIN;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddDistributorManagement extends BaseTest {
    WebDriver driver;

    private String representative, representativeInvalid, phone, phoneInvalid, taxCode, idCard, idCardInvalid, dateRange, issuedBy, enterAddress, region,
            area, businessModel, warehouseArea, labor, timeIn, distributionRoomCode, marketRoomCode,
            accountDistributor, passwordDistributor, passwordShort, passwordMissNumber, passwordMissSpecial, emailDistributor, emailInvalid;
    private String browserName;

    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;
    private DistributorManagementPageObject distributorPage;
    private CreateInformationDistributorPageObject createInformationDistributorPage;
    private CreateAccountDistributorPageObject createAccountDistributorPage;
    private UserManagementHomePageObject userManagementHomePage;
    private DetailUserPageObject detailUserPage;
    private AdminHomePageUI homePageUI;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, ADMIN_LOGIN);
        loginPage = new AdminLoginPageObject(driver);
        homePage = loginPage.goToAdminHomePage(driver);

        representative = "LHETest" + getRandomString();
        representativeInvalid = "Test1";
        phone = "09876" + getRandomInt();
        phoneInvalid = "0987654321987654321";
        taxCode = "01234" + getRandomInt();
        idCard = "0380970" + getRandomInt();
        idCardInvalid = "0987654321987654321";
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
        passwordShort = "test";
        passwordMissNumber = "LongHaiTest@";
        passwordMissSpecial = "LongHaiTest123";
        passwordDistributor = "LHETest@123";
        emailInvalid = "LongHaiTest";
    }

    public void goToHomePage() {
        homePage.openPageUrl(driver, ADMIN_LOGIN);
        homePage.clickButtonDragToTheLeft();
    }

    @Test
    public void TC_01_Cancel(Method method) {
        ExtentTestManager.startTest(method.getName(), "Click Cancel Button");
        goToHomePage();
        distributorPage = homePage.clickDistributorManagementButton();
        createInformationDistributorPage = distributorPage.clickAddMemberButton();
        distributorPage = createInformationDistributorPage.clickCancelButton();
        assertTrue(distributorPage.isDistributorManagementTextDisplayed());
    }

    @Test
    public void TC_02_Go_To_Add_Distributor_Management(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Distributor Management");
        goToHomePage();
        distributorPage = homePage.clickDistributorManagementButton();
        createInformationDistributorPage = distributorPage.clickAddMemberButton();

        assertTrue(createInformationDistributorPage.isPersonalInformationTextDisplayed());
    }

    @Test
    public void TC_03_Invalid_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Distributor Management Invalid Data");
        goToHomePage();
        distributorPage = homePage.clickDistributorManagementButton();
        createInformationDistributorPage = distributorPage.clickAddMemberButton();

        createInformationDistributorPage.inputByPlaceholder(driver, "Người đại diện", representativeInvalid);
        createInformationDistributorPage.inputByPlaceholder(driver, "Số điện thoại", phoneInvalid);
        createInformationDistributorPage.inputToIdCard(idCardInvalid);

        createInformationDistributorPage.clickNextButton();

        assertEquals(createInformationDistributorPage.getErrorMessageInvalidRepresentative(), "Tên không hợp lệ");
        assertEquals(createInformationDistributorPage.getErrorMessageInvalidPhone(), "Số điện thoại không hợp lệ");
        assertEquals(createInformationDistributorPage.getErrorInvalidMessageIdCard(), "CMT/CCCD không hợp lệ");
    }

    @Test
    public void TC_04_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Distributor Management Empty Data");
        goToHomePage();
        distributorPage = homePage.clickDistributorManagementButton();
        createInformationDistributorPage = distributorPage.clickAddMemberButton();

        createInformationDistributorPage.clickToInputByPlaceholder(driver, "Nơi cấp");
        createInformationDistributorPage.inputByPlaceholder(driver, "Người đại diện", "");
        createInformationDistributorPage.inputByPlaceholder(driver, "Số điện thoại", "");

        createInformationDistributorPage.clickToInputByPlaceholder(driver, "Mã số thuế NPP");
        createInformationDistributorPage.inputToIdCard("");
        createInformationDistributorPage.clickToInputByPlaceholder(driver, "Ngày cấp");
        createInformationDistributorPage.clickToInputByPlaceholder(driver, "Địa chỉ cụ thể");

        createInformationDistributorPage.scrollToBottomPage(driver);

        createInformationDistributorPage.clickToInputByPlaceholder(driver, "Mã chiện - Phòng thị trường tạo");
        createInformationDistributorPage.clickToInputByPlaceholder(driver, "Mã NPP - Phòng kế toán tạo");
        createInformationDistributorPage.clickToInputByPlaceholder(driver, "Thời gian vào");
        createInformationDistributorPage.clickToInputByPlaceholder(driver, "Diện tích kho");
        createInformationDistributorPage.clickToLabor();
        createInformationDistributorPage.clickToInputByPlaceholder(driver, "Loại hình kinh doanh");

        createInformationDistributorPage.clickNextButton();

        assertEquals(createInformationDistributorPage.getErrorMessageRepresentative(), "Bạn cần điền vào mục này");
        assertEquals(createInformationDistributorPage.getErrorMessagePhone(), "Bạn cần điền vào mục này");
        assertEquals(createInformationDistributorPage.getErrorMessageTaxCode(), "Bạn cần điền vào mục này");
        assertEquals(createInformationDistributorPage.getErrorMessageIdCard(), "Bạn cần điền vào mục này");
        assertEquals(createInformationDistributorPage.getErrorMessageDateRange(), "Bạn cần điền vào mục này");
        assertEquals(createInformationDistributorPage.getErrorMessageIssuedBy(), "Bạn cần điền vào mục này");
        assertEquals(createInformationDistributorPage.getErrorMessageSelectAddress(), "Bạn cần điền vào mục này");
        assertEquals(createInformationDistributorPage.getErrorMessageAddress(), "Bạn cần điền vào mục này");

        createInformationDistributorPage.scrollToBottomPage(driver);

        assertEquals(createInformationDistributorPage.getErrorMessageWarehouseArea(), "Bạn cần điền vào mục này");
        assertEquals(createInformationDistributorPage.getErrorMessageLabor(), "Bạn cần điền vào mục này");
        assertEquals(createInformationDistributorPage.getErrorMessageTimeIn(), "Bạn cần điền vào mục này");
    }

    @Test()
    public void TC_05_Add_Distributor_Management_Success(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Distributor Management Success");
        goToHomePage();
        distributorPage = homePage.clickDistributorManagementButton();
        createInformationDistributorPage = distributorPage.clickAddMemberButton();

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
    }

        @Test
    public void TC_06_Back_To_Previous_Page(Method method) {
        ExtentTestManager.startTest(method.getName(), "Click Back Button");
        goToHomePage();
        distributorPage = homePage.clickDistributorManagementButton();
        createInformationDistributorPage = distributorPage.clickAddMemberButton();

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
        createInformationDistributorPage = createAccountDistributorPage.clickBackButton();

        assertTrue(createInformationDistributorPage.isPersonalInformationTextDisplayed());
    }

    @Test()
    public void TC_07_Create_Account_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create Account Distributor Empty Data");
        goToHomePage();
        distributorPage = homePage.clickDistributorManagementButton();
        createInformationDistributorPage = distributorPage.clickAddMemberButton();

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

        createAccountDistributorPage.inputToAccountDistributor("");
        createAccountDistributorPage.inputToPassWordDistributor("");
        createAccountDistributorPage.inputToEmailDistributor("");

        createAccountDistributorPage.clickCreateButton();

        assertEquals(createAccountDistributorPage.getErrorMessageAccountDistributor(), "Bạn cần điền vào mục này");
        assertEquals(createAccountDistributorPage.getErrorMessagePassWordDistributor(), "Bạn cần điền vào mục này");
        assertEquals(createAccountDistributorPage.getErrorMessageEmailDistributor(), "Bạn cần điền vào mục này");
        assertTrue(createAccountDistributorPage.isModalErrorDisplayed());

        createAccountDistributorPage.closeModalErrorButton();
    }

    @Test()
    public void TC_08_Create_Account_Invalid_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create Account Distributor Invalid Data");
        goToHomePage();
        distributorPage = homePage.clickDistributorManagementButton();
        createInformationDistributorPage = distributorPage.clickAddMemberButton();

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

        createAccountDistributorPage.inputToPassWordDistributor(passwordShort);
        createAccountDistributorPage.inputToEmailDistributor(emailInvalid);
        assertEquals(createAccountDistributorPage.getErrorMessagePassWordDistributor(), "Cần ít nhất 8 ký tự");

        createAccountDistributorPage.inputToPassWordDistributor(passwordMissSpecial);
        assertEquals(createAccountDistributorPage.getErrorMessageEmailDistributor(), "Không đúng định dạng email");
        createAccountDistributorPage.inputToEmailDistributor(emailInvalid);
        assertEquals(createAccountDistributorPage.getErrorMessagePassWordDistributor(), "Cần chứa ít nhất 1 ký tự đặc biệt");

        createAccountDistributorPage.inputToPassWordDistributor(passwordMissNumber);
        createAccountDistributorPage.inputToEmailDistributor(emailInvalid);
        assertEquals(createAccountDistributorPage.getErrorMessagePassWordDistributor(), "Cần ít nhất 1 chữ số");
    }

    @Test()
    public void TC_09_Create_Account_Success(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create Account Distributor Success");
        goToHomePage();
        distributorPage = homePage.clickDistributorManagementButton();
        createInformationDistributorPage = distributorPage.clickAddMemberButton();

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
