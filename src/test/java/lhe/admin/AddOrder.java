package lhe.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.order.OrderDetailPageObject;
import pageObjects.admin.order.CreateOrderPageObject;
import pageObjects.admin.order.OrderHomePageObject;
import pageUIs.admin.AdminHomePageUI;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.GlobalConstants.ADMIN_LOGIN;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddOrder extends BaseTest {
    WebDriver driver;

    private String browserName;

    private AdminHomePageUI homePageUI;
    private AdminLoginPageObject loginPage;
    private AdminHomePageObject homePage;
    private OrderHomePageObject orderHomePage;
    private CreateOrderPageObject createOrderPage;
    private OrderDetailPageObject orderDetailPage;

    private String selectDistributor, enterNote, productName, productAddName, noteText;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, ADMIN_LOGIN);
        loginPage = new AdminLoginPageObject(driver);
        homePage = loginPage.goToAdminHomePage(driver);

        selectDistributor = "NPP Test";
        enterNote = "LHETest";
        productName = "Thạch rau câu phong cách Nhật Bản Kimiko 990g";
        productAddName = "Thạch rau câu phong cách Nhật Bản Kimikoko hihi 450g";
        noteText = "LHETest";
    }

    public void goToHomPage() {
        homePage.openPageUrl(driver, ADMIN_LOGIN);
        homePage.clickButtonDragToTheLeft();
    }

    @Test
    public void TC_01_Cancel_Order_Page(Method method) {
        ExtentTestManager.startTest(method.getName(), "Cancel Order Page");
        goToHomPage();
        orderHomePage = homePage.clickOrderButton();
        createOrderPage = orderHomePage.clickAddNewOrderButton();
        orderHomePage = createOrderPage.clickCancelButton();
        assertTrue(orderHomePage.isOrderInFormationTextDisplayed());
    }

    @Test
    public void TC_02_Create_Order_Page_Success(Method method) {
        ExtentTestManager.startTest(method.getName(), "Create Order Page");
        goToHomPage();
        orderHomePage = homePage.clickOrderButton();
        createOrderPage = orderHomePage.clickAddNewOrderButton();
        createOrderPage.inputDynamic(driver,"Tìm kiến nhà phân phối", selectDistributor);
        createOrderPage.clickDistributorInput();
        createOrderPage.clickSelectDistributor();
        createOrderPage.inputDynamic(driver,"Nhập ghi chú", enterNote);
        createOrderPage.clickChooseStoreButton();
        createOrderPage.clickSelectStore();
        createOrderPage.clickChooseProductButton();
        createOrderPage.clickCancelProductButton();
        createOrderPage.clickChooseProductButton();
        createOrderPage.dragAndDropIcon();
        createOrderPage.clickCancelHelpdesk();
        createOrderPage.inputDynamic(driver,"Tìm kiếm sản phẩm", productName);
        createOrderPage.clickChooseProductTextbox();
        createOrderPage.clickAddButton();
        createOrderPage.clickCreateOrderButton();
        createOrderPage.clickListPageButton();
    }

    @Test
    public void TC_03_Approve_Order(Method method) {
        ExtentTestManager.startTest(method.getName(), "Approve Order");
        goToHomPage();
        orderHomePage = homePage.clickOrderButton();
        createOrderPage = orderHomePage.clickAddNewOrderButton();
        createOrderPage.inputDynamic(driver,"Tìm kiến nhà phân phối", selectDistributor);
        createOrderPage.clickDistributorInput();
        createOrderPage.clickSelectDistributor();
        createOrderPage.inputDynamic(driver,"Nhập ghi chú", enterNote);
        createOrderPage.clickChooseStoreButton();
        createOrderPage.clickSelectStore();
        createOrderPage.clickChooseProductButton();
        createOrderPage.clickCancelProductButton();
        createOrderPage.clickChooseProductButton();
        createOrderPage.dragAndDropIcon();
        createOrderPage.clickCancelHelpdesk();
        createOrderPage.inputDynamic(driver,"Tìm kiếm sản phẩm", productName);
        createOrderPage.clickChooseProductTextbox();
        createOrderPage.clickAddButton();
        createOrderPage.clickCreateOrderButton();
        orderDetailPage = createOrderPage.clickViewDetailOrderButton();

        assertEquals(orderDetailPage.getDistributorText(), selectDistributor);
        assertEquals(orderDetailPage.getEnterNoteText(), enterNote);
        assertEquals(orderDetailPage.getStoreText(), "Kho Cẩm Thượng");
        assertEquals(orderDetailPage.getProductNameText(), productName);

        orderDetailPage.clickApproveOrderButton();
        orderDetailPage.clickCancelButton();
        assertTrue(orderDetailPage.isProcessingButtonDisplayed());
    }

    @Test
    public void TC_04_Approve_Order_From_Order_Home_Page(Method method) {
        ExtentTestManager.startTest(method.getName(), "Approve Order From Order Home Page");
        goToHomPage();
        orderHomePage = homePage.clickOrderButton();
        createOrderPage = orderHomePage.clickAddNewOrderButton();
        createOrderPage.inputDynamic(driver,"Tìm kiến nhà phân phối", selectDistributor);
        createOrderPage.clickDistributorInput();
        createOrderPage.clickSelectDistributor();
        createOrderPage.inputDynamic(driver,"Nhập ghi chú", enterNote);
        createOrderPage.clickChooseStoreButton();
        createOrderPage.clickSelectStore();
        createOrderPage.clickChooseProductButton();
        createOrderPage.clickCancelProductButton();
        createOrderPage.clickChooseProductButton();
        createOrderPage.dragAndDropIcon();
        createOrderPage.clickCancelHelpdesk();
        createOrderPage.inputDynamic(driver,"Tìm kiếm sản phẩm", productName);
        createOrderPage.clickChooseProductTextbox();
        createOrderPage.clickAddButton();
        createOrderPage.clickCreateOrderButton();
        createOrderPage.clickListPageButton();

        orderHomePage.clickWaitingForApproveButton();
        orderDetailPage = orderHomePage.clickViewDetailButton();
        orderDetailPage.clickAddProductButton();
        orderDetailPage.dragAndDropIcon();
        orderDetailPage.clickCancelHelpdesk();
        orderDetailPage.inputDynamic(driver,"Tìm kiếm sản phẩm", productAddName);
        orderDetailPage.clickChooseProductAddNewTextbox();
        orderDetailPage.clickAddButton();
        orderDetailPage.clickUpdateOrderButton();
        orderDetailPage.clickCancelButton();
        orderDetailPage.clickApproveOrderButton();
        orderDetailPage.clickCancelButton();
        assertTrue(orderDetailPage.isProcessingButtonDisplayed());
    }

    @Test
    public void TC_05_Refuse_Approve_Order(Method method) {
        ExtentTestManager.startTest(method.getName(), "Refuse Approve Order");
        goToHomPage();
        orderHomePage = homePage.clickOrderButton();
        orderHomePage.clickWaitingForApproveButton();
        orderDetailPage = orderHomePage.clickViewDetailButton();
        orderDetailPage.clickRefuseOrderButton();
        orderDetailPage.inputNoteText(noteText);
        orderDetailPage.clickConfirmButton();
        orderDetailPage.clickCancelButton();
        assertTrue(orderDetailPage.isFailureButtonDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
//        closeBrowserAndDriver();
    }
}
