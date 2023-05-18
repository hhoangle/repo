package pageObjects.admin.distributorManagement;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminHomePageUI;

public class EditInformationPageObject extends BasePage {
	private WebDriver driver;

	public EditInformationPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToIdCard(String idCard) {
		waitForElementVisible(driver, AdminHomePageUI.ID_CARD_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.ID_CARD_INPUT_TEXT, idCard);
	}

	public void inputToTaxCode(String taxCode) {
		waitForElementVisible(driver, AdminHomePageUI.TAX_CODE_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.TAX_CODE_INPUT_TEXT, taxCode);
	}

	public void clickToSelectAddress() {
		waitForElementClickable(driver, AdminHomePageUI.SELECT_ADDRESS_INPUT);
		clickToElement(driver, AdminHomePageUI.SELECT_ADDRESS_INPUT);
	}

	public void clickToSelectCity() {
		waitForElementClickable(driver, AdminHomePageUI.SELECT_CITY);
		clickToElement(driver, AdminHomePageUI.SELECT_CITY);
	}

	public void clickToSelectDistrict() {
		waitForElementClickable(driver, AdminHomePageUI.SELECT_DISTRICT);
		clickToElement(driver, AdminHomePageUI.SELECT_DISTRICT);
	}

	public void inputToWarehouseArea(String idCard) {
		waitForElementVisible(driver, AdminHomePageUI.WAREHOUSE_AREA_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.WAREHOUSE_AREA_INPUT_TEXT, idCard);
	}

	public void inputToLabor(String idCard) {
		waitForElementVisible(driver, AdminHomePageUI.LABOR_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.LABOR_INPUT_TEXT, idCard);
	}

	public ConfirmEditInformationPageObject clickSaveButton() {
		waitForElementVisible(driver, AdminHomePageUI.SAVE_DISTRIBUTOR_BUTTON);
		clickToElement(driver, AdminHomePageUI.SAVE_DISTRIBUTOR_BUTTON);
		return new ConfirmEditInformationPageObject(driver);
	}

	public void inputAvatarImage(String avatarImage) {
		uploadImage(driver, AdminHomePageUI.AVATAR_IMAGE, avatarImage);
	}
}
