package pageObjects.admin.distributorManagement;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminHomePageUI;

public class DetailUserPageObject extends BasePage {
	private WebDriver driver;

	public DetailUserPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getUserNameText() {
		waitForElementVisible(driver, AdminHomePageUI.USER_NAME_TEXT);
		return getElementText(driver, AdminHomePageUI.USER_NAME_TEXT);
	}

	public String
	getInfoDistributorText(String info) {
		waitForElementVisible(driver, AdminHomePageUI.INFO_DISTRIBUTOR_TEXT, info);
		return getElementText(driver, AdminHomePageUI.INFO_DISTRIBUTOR_TEXT, info);
	}
}
