package pageObjects.admin.distributorManagement;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminHomePageUI;

import static commons.GlobalConstants.SHORT_TIMEOUT;

public class CreateInformationDistributorPageObject extends BasePage {
	private WebDriver driver;

	public CreateInformationDistributorPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public DistributorManagementPageObject clickCancelButton() {
		waitForElementClickable(driver, AdminHomePageUI.CANCEL_BUTTON);
		clickToElement(driver, AdminHomePageUI.CANCEL_BUTTON);
		return new DistributorManagementPageObject(driver);
	}

	public boolean isPersonalInformationTextDisplayed() {
		waitForElementVisible(driver, AdminHomePageUI.PERSONAL_INFORMATION_TEXT);
		return isElementDisplay(driver, AdminHomePageUI.PERSONAL_INFORMATION_TEXT);
	}

	public void inputToIdCard(String idCard) {
		waitForElementVisible(driver, AdminHomePageUI.ID_CARD_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.ID_CARD_INPUT_TEXT, idCard);
	}

	public CreateAccountDistributorPageObject clickNextButton() {
		waitForElementClickable(driver, AdminHomePageUI.NEXT_BUTTON);
		clickToElement(driver, AdminHomePageUI.NEXT_BUTTON);
		return new CreateAccountDistributorPageObject(driver);
	}

	public String getErrorMessageInvalidRepresentative() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_INVALID_REPRESENTATIVE);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_INVALID_REPRESENTATIVE);
	}

	public String getErrorMessageInvalidPhone() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_INVALID_PHONE);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_INVALID_PHONE);
	}

	public String getErrorInvalidMessageIdCard() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_INVALID_ID_CARD);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_INVALID_ID_CARD);
	}

	public void clickToLabor() {
		waitForElementClickable(driver, AdminHomePageUI.LABOR_INPUT);
		clickToElement(driver, AdminHomePageUI.LABOR_INPUT);
	}

	public String getErrorMessageRepresentative() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_REPRESENTATIVE);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_REPRESENTATIVE);
	}

	public String getErrorMessagePhone() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_PHONE);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_PHONE);
	}

	public String getErrorMessageTaxCode() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_TAX_CODE);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_TAX_CODE);
	}

	public String getErrorMessageIdCard() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_ID_CARD);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_ID_CARD);
	}

	public String getErrorMessageDateRange() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_DATE_RANGE);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_DATE_RANGE);
	}

	public String getErrorMessageIssuedBy() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_ISSUE_BY);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_ISSUE_BY);
	}

	public String getErrorMessageSelectAddress() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_SELECT_ADDRESS);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_SELECT_ADDRESS);
	}

	public String getErrorMessageAddress() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_ADDRESS);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_ADDRESS);
	}

	public String getErrorMessageWarehouseArea() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_WAREHOUSE_AREA);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_WAREHOUSE_AREA);
	}

	public String getErrorMessageLabor() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_LABOR);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_LABOR);
	}

	public String getErrorMessageTimeIn() {
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_TIME_IN);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_EMPTY_TIME_IN);
	}

	public void inputToTaxCode(String taxCode) {
		waitForElementVisible(driver, AdminHomePageUI.TAX_CODE_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.TAX_CODE_INPUT_TEXT, taxCode);
	}

	public void clickToSelectAddress() {
		waitForLoadingItemInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.SELECT_ADDRESS_INPUT);
		clickToElement(driver, AdminHomePageUI.SELECT_ADDRESS_INPUT);
	}

	public void clickToSelectCity() {
		waitForLoadingItemInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.SELECT_CITY);
		clickToElement(driver, AdminHomePageUI.SELECT_CITY);
	}

	public void clickToSelectDistrict() {
		waitForLoadingItemInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.SELECT_DISTRICT);
		clickToElement(driver, AdminHomePageUI.SELECT_DISTRICT);
	}

	public void clickToSelectWard() {
		waitForLoadingItemInvisible(driver);
		waitForElementClickable(driver, AdminHomePageUI.SELECT_WARD);
		clickToElement(driver, AdminHomePageUI.SELECT_WARD);
	}

	public void inputToWarehouseArea(String idCard) {
		waitForElementVisible(driver, AdminHomePageUI.WAREHOUSE_AREA_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.WAREHOUSE_AREA_INPUT_TEXT, idCard);
	}

	public void inputToLabor(String idCard) {
		waitForElementVisible(driver, AdminHomePageUI.LABOR_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.LABOR_INPUT_TEXT, idCard);
	}

	public void clickToInputRegion() {
		waitForElementVisible(driver, AdminHomePageUI.REGION_INPUT_TEXT);
		clickToElement(driver, AdminHomePageUI.REGION_INPUT_TEXT);
		waitForElementClickable(driver, AdminHomePageUI.REGION_VALUE);
	}

	public void clickToInputArea() {
		waitForElementVisible(driver, AdminHomePageUI.AREA_INPUT_TEXT);
		clickToElement(driver, AdminHomePageUI.AREA_INPUT_TEXT);
	}
}
