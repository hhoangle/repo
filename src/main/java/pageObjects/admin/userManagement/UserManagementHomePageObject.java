package pageObjects.admin.userManagement;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.admin.distributorManagement.DetailUserPageObject;
import pageUIs.admin.AdminHomePageUI;

public class UserManagementHomePageObject extends BasePage {
	private WebDriver driver;

	public UserManagementHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public CreateUserManagementPageObject clickAddUserManagementButton() {
		waitForElementClickable(driver, AdminHomePageUI.ADD_NEW_USER_MANAGEMENT_BUTTON);
		clickToElement(driver, AdminHomePageUI.ADD_NEW_USER_MANAGEMENT_BUTTON);
		return new CreateUserManagementPageObject(driver);
	}

	public boolean representativeDisplayed(String representative) {
		waitForElementVisible(driver, AdminHomePageUI.REPRESENTATIVE, representative);
		return isElementDisplay(driver, AdminHomePageUI.REPRESENTATIVE, representative);
	}

    public void clickViewDetailAllDistributor() {
		waitForElementClickable(driver, AdminHomePageUI.VIEW_DETAIL_ALL_DISTRIBUTOR_DIV);
		clickToElement(driver, AdminHomePageUI.VIEW_DETAIL_ALL_DISTRIBUTOR_DIV);
    }

	public DetailUserPageObject clickViewDetailNewDistributor() {
		waitForLoadingItemInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.VIEW_DETAIL_NEW_DISTRIBUTOR);
		clickToElement(driver, AdminHomePageUI.VIEW_DETAIL_NEW_DISTRIBUTOR);
		return new DetailUserPageObject(driver);
	}

    public void clickViewDetailAllAccountant() {
		waitForElementClickable(driver, AdminHomePageUI.VIEW_DETAIL_ALL_ACCOUNTANT_DIV);
		clickToElement(driver, AdminHomePageUI.VIEW_DETAIL_ALL_ACCOUNTANT_DIV);
    }

	public DetailUserPageObject clickViewDetailNewAccountant() {
		waitForLoadingIconInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.VIEW_DETAIL_NEW_ACCOUNTANT);
		clickToElement(driver, AdminHomePageUI.VIEW_DETAIL_NEW_ACCOUNTANT);
		return new DetailUserPageObject(driver);
	}

	public void clickViewDetailAllAdmin() {
		waitForElementClickable(driver, AdminHomePageUI.VIEW_DETAIL_ALL_ADMIN_DIV);
		clickToElement(driver, AdminHomePageUI.VIEW_DETAIL_ALL_ADMIN_DIV);
	}

	public DetailUserPageObject clickViewDetailNewAdmin() {
		waitForLoadingIconInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.VIEW_DETAIL_NEW_ADMIN);
		clickToElement(driver, AdminHomePageUI.VIEW_DETAIL_NEW_ADMIN);
		return new DetailUserPageObject(driver);
	}

	public void clickViewDetailAllMarketingStaff() {
		waitForElementClickable(driver, AdminHomePageUI.VIEW_DETAIL_ALL_MARKETING_STAFF_DIV);
		clickToElement(driver, AdminHomePageUI.VIEW_DETAIL_ALL_MARKETING_STAFF_DIV);
	}

	public DetailUserPageObject clickViewDetailNewMarketingStaff() {
		waitForLoadingIconInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.VIEW_DETAIL_NEW_MARKETING_STAFF);
		clickToElement(driver, AdminHomePageUI.VIEW_DETAIL_NEW_MARKETING_STAFF);
		return new DetailUserPageObject(driver);
	}

    public void clickViewDetailAllWarehouse() {
		waitForElementClickable(driver, AdminHomePageUI.VIEW_DETAIL_ALL_WAREHOUSE_DIV);
		clickToElement(driver, AdminHomePageUI.VIEW_DETAIL_ALL_WAREHOUSE_DIV);
    }

	public DetailUserPageObject clickViewDetailNewWarehouse() {
		waitForLoadingIconInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.VIEW_DETAIL_NEW_WAREHOUSE);
		clickToElement(driver, AdminHomePageUI.VIEW_DETAIL_NEW_WAREHOUSE);
		return new DetailUserPageObject(driver);
	}
}
