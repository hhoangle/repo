package lhe.admin;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.distributorManagement.*;
import pageUIs.admin.AdminHomePageUI;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.BasePage.getRandomInt;
import static commons.BasePage.getRandomString;
import static commons.GlobalConstants.ADMIN_LOGIN;
import static commons.GlobalConstants.PROJECT_PATH;
import static org.testng.Assert.assertTrue;

public class EditDistributorManagement extends BaseTest {
    WebDriver driver;

    private String representative, phone, taxCode, idCard, idCardInvalid, dateRange, issuedBy, enterAddress, warehouseArea,
            labor, timeIn, distributionRoomCode, marketRoomCode, avatarImage;
    private String browserName;

    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;
    private DistributorManagementPageObject distributorPage;
    private EditInformationPageObject editInformationPage;
    private DetailDistributorPageObject detailDistributorPage;
    private ConfirmEditInformationPageObject confirmEditInformationPage;
    private AdminHomePageUI homePageUI;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, ADMIN_LOGIN);
        loginPage = new AdminLoginPageObject(driver);
        homePage = loginPage.goToAdminHomePage(driver);

        avatarImage =  PROJECT_PATH + "\\uploadFiles\\AvatarImage.jpg";
        representative = "LHETest" + getRandomString();
        phone = "09876" + getRandomInt();
        taxCode = "01234" + getRandomInt();
        idCard = "0123456" + getRandomInt();
        idCardInvalid = "0987654321987654321";
        dateRange = "01/01/2011";
        issuedBy = "Ha Noi";
        enterAddress = "Cau Giay, Ha Noi";
        warehouseArea = "1000";
        labor = "20";
        timeIn = "20/04/2020";
        distributionRoomCode = "AD1";
        marketRoomCode = "AD1";
    }

    public void goToHomPage() {
        homePage.openPageUrl(driver, ADMIN_LOGIN);
        homePage.clickButtonDragToTheLeft();
    }

    @Test
    public void TC_01_Edit_Data_Success(Method method) {
        ExtentTestManager.startTest(method.getName(), "Edit Distributor Management Success");
        goToHomPage();
        distributorPage = homePage.clickDistributorManagementButton();
        detailDistributorPage = distributorPage.clickViewDetailDistributorButton();
        editInformationPage = detailDistributorPage.clickEditDistributorButton();

        editInformationPage.inputAvatarImage(avatarImage);
        editInformationPage.inputByPlaceholder(driver, "Nơi cấp", issuedBy);
        editInformationPage.inputByPlaceholder(driver, "Người đại diện", representative);
        editInformationPage.inputByPlaceholder(driver, "Số điện thoại", phone);

        editInformationPage.inputToTaxCode(taxCode);
        editInformationPage.inputToIdCard(idCard);
        editInformationPage.inputByPlaceholder(driver, "Ngày cấp", dateRange);
        editInformationPage.clickToSelectAddress();
        editInformationPage.clickToSelectCity();
        editInformationPage.clickToSelectDistrict();

        editInformationPage.scrollToBottomPage(driver);
        editInformationPage.inputByPlaceholder(driver, "Địa chỉ cụ thể", enterAddress);

        editInformationPage.inputByPlaceholder(driver, "Mã chiện - Phòng thị trường tạo", marketRoomCode);
        editInformationPage.inputByPlaceholder(driver, "Mã NPP - Phòng kế toán tạo", distributionRoomCode);
        editInformationPage.inputByPlaceholder(driver, "Thời gian vào", timeIn);
        editInformationPage.inputByPlaceholder(driver, "Diện tích kho", warehouseArea);
        editInformationPage.inputToWarehouseArea(warehouseArea);
        editInformationPage.inputToLabor(labor);
        confirmEditInformationPage = editInformationPage.clickSaveButton();
        assertTrue(confirmEditInformationPage.isConfirmSuccessTextDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
