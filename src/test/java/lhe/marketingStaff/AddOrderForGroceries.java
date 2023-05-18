package lhe.marketingStaff;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.marketingStaff.MarketingStaffHomePageObject;
import pageObjects.marketingStaff.MarketingStaffLoginPageObject;
import pageObjects.marketingStaff.order.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

import static commons.GlobalConstants.MARKETING_STAFF_LOGIN;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AddOrderForGroceries extends BaseTest {
    WebDriver driver;

    private String browserName;

    private MarketingStaffLoginPageObject marketingStaffLoginPage;
    private MarketingStaffHomePageObject marketingStaffHomePage;
    private OrderHomePageObject orderHomePage;
    private AddOrderForGroceriesPageObject addOrderForGroceriesPage;
    private ListGroceriesPageObject listGroceriesPage;
    private ChooseOneGroceryPageObject chooseOneGroceryPage;
    private PreviewDetailOrderPageObject previewDetailOrderPage;
    private DetailOrderPageObject detailOrderPage;

    private String note, product, numberOfBoxes, numberOfBags, productEdit;

    @BeforeClass
    public void beforeClass() {
        browserName = "chrome";
        driver = getBrowserDriver(browserName, MARKETING_STAFF_LOGIN);
        marketingStaffLoginPage = new MarketingStaffLoginPageObject(driver);
        marketingStaffHomePage = marketingStaffLoginPage.goToMarketingStaffHomePage(driver);

        product = "Thạch rau câu phong cách Nhật Bản Kimiko 990g";
        productEdit = "Thạch rau câu phong cách Nhật Bản Kimikoko hihi 450g";
        numberOfBoxes = "3";
        numberOfBags = "3";
        note = "LHETest";
    }

    public void goToMarketingStaffHomePage() {
        marketingStaffHomePage.openPageUrl(driver, MARKETING_STAFF_LOGIN);
    }

    @Test
    public void TC_01_Cancel_Order_Page(Method method) {
        ExtentTestManager.startTest(method.getName(), "Cancel Order Page");
        goToMarketingStaffHomePage();
        orderHomePage = marketingStaffHomePage.clickOrderButton();
        addOrderForGroceriesPage = orderHomePage.clickAddOrderForGroceries();
        listGroceriesPage = addOrderForGroceriesPage.clickAddOrderForGroceriesButton();
        chooseOneGroceryPage = listGroceriesPage.clickChooseOneGroceryButton();
        addOrderForGroceriesPage = chooseOneGroceryPage.clickCancelAddOrderButton();
        assertTrue(addOrderForGroceriesPage.isAddOrderTextDisplayed());
    }

    @Test
    public void TC_02_Add_Order_For_Groceries_Then_View_Order_Detail(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Order For Groceries Then View Order Detail");
        goToMarketingStaffHomePage();
        orderHomePage = marketingStaffHomePage.clickOrderButton();
        addOrderForGroceriesPage = orderHomePage.clickAddOrderForGroceries();
        listGroceriesPage = addOrderForGroceriesPage.clickAddOrderForGroceriesButton();
        chooseOneGroceryPage = listGroceriesPage.clickChooseOneGroceryButton();
        chooseOneGroceryPage.inputNoteArea(note);
        chooseOneGroceryPage.clickChooseProductToOrderButton();
        chooseOneGroceryPage.inputSearchProduct(product);
        chooseOneGroceryPage.dragAndDropIcon();
        chooseOneGroceryPage.clickTextboxChooseProduct();
        chooseOneGroceryPage.clickAddNewProductButton();
        chooseOneGroceryPage.clickAddUnitIcon();
        chooseOneGroceryPage.inputNumberOfBoxes(numberOfBoxes);
        chooseOneGroceryPage.inputNumberOfBags(numberOfBags);
        previewDetailOrderPage = chooseOneGroceryPage.clickConfirmButton();
        assertEquals(previewDetailOrderPage.getProductNameText(), product);
        previewDetailOrderPage.clickCompletedButton();
        detailOrderPage = previewDetailOrderPage.clickDetailOrderButton();
        assertEquals(detailOrderPage.getProductNameText(), product);
    }

    @Test
    public void TC_03_Add_Order_For_Groceries_Then_View_Order_List(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add Order For Groceries Then View Order List");
        goToMarketingStaffHomePage();
        orderHomePage = marketingStaffHomePage.clickOrderButton();
        addOrderForGroceriesPage = orderHomePage.clickAddOrderForGroceries();
        listGroceriesPage = addOrderForGroceriesPage.clickAddOrderForGroceriesButton();
        chooseOneGroceryPage = listGroceriesPage.clickChooseOneGroceryButton();
        chooseOneGroceryPage.inputNoteArea(note);
        chooseOneGroceryPage.clickChooseProductToOrderButton();
        chooseOneGroceryPage.inputSearchProduct(product);
        chooseOneGroceryPage.dragAndDropIcon();
        chooseOneGroceryPage.clickTextboxChooseProduct();
        chooseOneGroceryPage.clickAddNewProductButton();
        chooseOneGroceryPage.clickAddUnitIcon();
        chooseOneGroceryPage.inputNumberOfBoxes(numberOfBoxes);
        chooseOneGroceryPage.inputNumberOfBags(numberOfBags);
        previewDetailOrderPage = chooseOneGroceryPage.clickConfirmButton();
        assertEquals(previewDetailOrderPage.getProductNameText(), product);
        previewDetailOrderPage.clickCompletedButton();
        addOrderForGroceriesPage = previewDetailOrderPage.clickListOrderButton();
    }

//    @Test
//    public void TC_04_Edit_Order_For_Groceries(Method method) {
//        ExtentTestManager.startTest(method.getName(), "Edit Order For Groceries");
//        goToMarketingStaffHomePage();
//        orderHomePage = marketingStaffHomePage.clickOrderButton();
//        addOrderForGroceriesPage = orderHomePage.clickAddOrderForGroceries();
//        listGroceriesPage = addOrderForGroceriesPage.clickAddOrderForGroceriesButton();
//        chooseOneGroceryPage = listGroceriesPage.clickChooseOneGroceryButton();
//        chooseOneGroceryPage.inputNoteArea(note);
//        chooseOneGroceryPage.clickChooseProductToOrderButton();
//        chooseOneGroceryPage.inputSearchProduct(product);
//        chooseOneGroceryPage.dragAndDropIcon();
//        chooseOneGroceryPage.clickTextboxChooseProduct();
//        chooseOneGroceryPage.clickAddNewProductButton();
//        chooseOneGroceryPage.clickAddUnitIcon();
//        chooseOneGroceryPage.inputNumberOfBoxes(numberOfBoxes);
//        chooseOneGroceryPage.inputNumberOfBags(numberOfBags);
//        previewDetailOrderPage = chooseOneGroceryPage.clickConfirmButton();
//        assertEquals(previewDetailOrderPage.getProductNameText(), product);
//        chooseOneGroceryPage = previewDetailOrderPage.clickEditOrderButton();
//
//        chooseOneGroceryPage.clickEditChooseProductToOrderButton();
//        chooseOneGroceryPage.inputSearchProduct(productEdit);
//        chooseOneGroceryPage.clickTextboxChooseProduct();
//        chooseOneGroceryPage.clickAddNewProductButton();
//        chooseOneGroceryPage.clickAddUnitIcon();
//        chooseOneGroceryPage.inputNumberOfBoxes(numberOfBoxes);
//        chooseOneGroceryPage.inputNumberOfBags(numberOfBags);
//    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }
}
