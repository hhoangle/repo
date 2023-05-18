package pageObjects.admin.userManagement;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminHomePageUI;

import static commons.GlobalConstants.SHORT_TIMEOUT;
import static commons.GlobalConstants.THREE_SECONDS;

public class CreateMarketingStaffPageObject extends BasePage {
	private WebDriver driver;

	public CreateMarketingStaffPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public CreateUserManagementPageObject clickCancelMarketingStaffButton() {
		waitForElementClickable(driver, AdminHomePageUI.CANCEL_MARKETING_STAFF_BUTTON);
		clickToElement(driver, AdminHomePageUI.CANCEL_MARKETING_STAFF_BUTTON);
		return new CreateUserManagementPageObject(driver);
	}

	public void inputToIdCard(String idCard) {
		waitForElementVisible(driver, AdminHomePageUI.ID_CARD_INPUT_TEXT);
		sendKeyToElement(driver, AdminHomePageUI.ID_CARD_INPUT_TEXT, idCard);
	}

	public void inputToDateOfBirth(String dateOfBirth) {
		waitForElementVisible(driver, AdminHomePageUI.DATE_OF_BIRTH_IN_USER_MANAGEMENT_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.DATE_OF_BIRTH_IN_USER_MANAGEMENT_INPUT, dateOfBirth);
	}

	public void inputToName(String name) {
		waitForElementVisible(driver, AdminHomePageUI.NAME_IN_USER_MANAGEMENT_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.NAME_IN_USER_MANAGEMENT_INPUT, name);
	}

	public void inputToPhone(String phone) {
		waitForElementVisible(driver, AdminHomePageUI.PHONE_NUMBER_IN_USER_MANAGEMENT_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.PHONE_NUMBER_IN_USER_MANAGEMENT_INPUT, phone);
	}

	public void inputToDateRange(String dateRange) {
		waitForElementVisible(driver, AdminHomePageUI.DATE_RANGE_IN_USER_MANAGEMENT_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.DATE_RANGE_IN_USER_MANAGEMENT_INPUT, dateRange);
	}

	public void inputToIssuedBy(String issuedBy) {
		waitForElementVisible(driver, AdminHomePageUI.ISSUED_BY_IN_USER_MANAGEMENT_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.ISSUED_BY_IN_USER_MANAGEMENT_INPUT, issuedBy);
	}

	public void inputToAddress(String address) {
		waitForElementVisible(driver, AdminHomePageUI.ADDRESS_IN_USER_MANAGEMENT_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.ADDRESS_IN_USER_MANAGEMENT_INPUT, address);
	}

	public void inputToTimeIn(String timeIn) {
		scrollToElement(driver, AdminHomePageUI.TIME_IN_IN_USER_MANAGEMENT_INPUT);
		waitForElementVisible(driver, AdminHomePageUI.TIME_IN_IN_USER_MANAGEMENT_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.TIME_IN_IN_USER_MANAGEMENT_INPUT, timeIn);
	}

	public CreateAccountMarketingStaffPageObject clickNextMarketingStaffButton() {
		waitForElementClickable(driver, AdminHomePageUI.NEXT_IN_USER_MANAGEMENT_BUTTON);
		clickToElement(driver, AdminHomePageUI.NEXT_IN_USER_MANAGEMENT_BUTTON);
		return new CreateAccountMarketingStaffPageObject(driver);
	}

    public String getErrorMessageName() {
		scrollToElement(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_NAME);
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_NAME);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_NAME);
    }

	public String getErrorMessagePhone() {
		scrollToElement(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_PHONE);
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_PHONE);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_PHONE);
	}

	public String getErrorMessageDateOfBirth() {
		scrollToElement(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_DATE_OF_BIRTH);
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_DATE_OF_BIRTH);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_DATE_OF_BIRTH);
	}

	public String getErrorMessageIdCard() {
		scrollToElement(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_ID_CARD);
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_ID_CARD);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_ID_CARD);
	}

	public String getErrorMessageDateRange() {
		scrollToElement(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_DATE_RANGE);
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_DATE_RANGE);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_DATE_RANGE);
	}

	public String getErrorMessageIssuedBy() {
		scrollToElement(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_ISSUE_BY);
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_ISSUE_BY);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_ISSUE_BY);
	}

	public String getErrorMessageAddress() {
		scrollToElement(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_SELECT_ADDRESS);
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_SELECT_ADDRESS);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_SELECT_ADDRESS);
	}

	public String getErrorMessageGender() {
		scrollToElement(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_GENDER);
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_GENDER);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_GENDER);
	}

	public void inputToGender(String gender) {
		scrollToElement(driver, AdminHomePageUI.GENDER_IN_USER_MANAGEMENT_INPUT);
		waitForElementClickable(driver, AdminHomePageUI.GENDER_IN_USER_MANAGEMENT_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.GENDER_IN_USER_MANAGEMENT_INPUT, gender);
	}

	public void clickToValueGender() {
		scrollToElement(driver, AdminHomePageUI.VALUE_GENDER_IN_USER_MANAGEMENT_INPUT);
		sleepInSecond(SHORT_TIMEOUT);
		waitForElementClickable(driver, AdminHomePageUI.VALUE_GENDER_IN_USER_MANAGEMENT_INPUT);
		clickToElement(driver, AdminHomePageUI.VALUE_GENDER_IN_USER_MANAGEMENT_INPUT);
	}

	public String getErrorMessageMaritalStatus() {
		scrollToElement(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_MARITAL_STATUS);
		waitForElementVisible(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_MARITAL_STATUS);
		return getElementText(driver, AdminHomePageUI.ERROR_MESSAGE_IN_USER_MANAGEMENT_EMPTY_MARITAL_STATUS);
	}

	public void inputToMaritalStatus(String maritalStatus) {
		scrollToElement(driver, AdminHomePageUI.MARITAL_STATUS_IN_USER_MANAGEMENT_INPUT);
		waitForElementClickable(driver, AdminHomePageUI.MARITAL_STATUS_IN_USER_MANAGEMENT_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.MARITAL_STATUS_IN_USER_MANAGEMENT_INPUT, maritalStatus);
	}

	public void clickToValueMaritalStatus() {
		scrollToElement(driver, AdminHomePageUI.VALUE_MARITAL_STATUS_IN_USER_MANAGEMENT_INPUT);
		sleepInSecond(SHORT_TIMEOUT);
		waitForElementClickable(driver, AdminHomePageUI.VALUE_MARITAL_STATUS_IN_USER_MANAGEMENT_INPUT);
		clickToElement(driver, AdminHomePageUI.VALUE_MARITAL_STATUS_IN_USER_MANAGEMENT_INPUT);
	}

	public void inputToPosition(String position) {
		scrollToElement(driver, AdminHomePageUI.POSITION_IN_USER_MANAGEMENT_INPUT);
		waitForElementClickable(driver, AdminHomePageUI.POSITION_IN_USER_MANAGEMENT_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.POSITION_IN_USER_MANAGEMENT_INPUT, position);
	}

	public void clickToValuePosition() {
		scrollToElement(driver, AdminHomePageUI.VALUE_POSITION_IN_USER_MANAGEMENT_INPUT);
		sleepInSecond(THREE_SECONDS);
		waitForElementClickable(driver, AdminHomePageUI.VALUE_POSITION_IN_USER_MANAGEMENT_INPUT);
		clickToElement(driver, AdminHomePageUI.VALUE_POSITION_IN_USER_MANAGEMENT_INPUT);
	}

	public void inputToNationality(String nationality) {
		scrollToElement(driver, AdminHomePageUI.NATIONALITY_IN_USER_MANAGEMENT_INPUT);
		waitForElementClickable(driver, AdminHomePageUI.NATIONALITY_IN_USER_MANAGEMENT_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.NATIONALITY_IN_USER_MANAGEMENT_INPUT, nationality);
	}

	public void clickToValueNationality() {
		scrollToElement(driver, AdminHomePageUI.VALUE_NATIONALITY_IN_USER_MANAGEMENT_INPUT);
		sleepInSecond(SHORT_TIMEOUT);
		waitForElementClickable(driver, AdminHomePageUI.VALUE_NATIONALITY_IN_USER_MANAGEMENT_INPUT);
		clickToElement(driver, AdminHomePageUI.VALUE_NATIONALITY_IN_USER_MANAGEMENT_INPUT);
	}

	public void inputToNation(String nation) {
		scrollToElement(driver, AdminHomePageUI.NATION_IN_USER_MANAGEMENT_INPUT);
		waitForElementClickable(driver, AdminHomePageUI.NATION_IN_USER_MANAGEMENT_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.NATION_IN_USER_MANAGEMENT_INPUT, nation);
	}

	public void clickToValueNation() {
		scrollToElement(driver, AdminHomePageUI.VALUE_NATION_IN_USER_MANAGEMENT_INPUT);
		sleepInSecond(SHORT_TIMEOUT);
		waitForElementClickable(driver, AdminHomePageUI.VALUE_NATION_IN_USER_MANAGEMENT_INPUT);
		clickToElement(driver, AdminHomePageUI.VALUE_NATION_IN_USER_MANAGEMENT_INPUT);
	}

	public void inputToRegion(String region) {
		scrollToElement(driver, AdminHomePageUI.REGION_IN_USER_MANAGEMENT_INPUT);
		waitForElementClickable(driver, AdminHomePageUI.REGION_IN_USER_MANAGEMENT_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.REGION_IN_USER_MANAGEMENT_INPUT, region);
	}

	public void clickToValueRegion() {
		scrollToElement(driver, AdminHomePageUI.VALUE_REGION_IN_USER_MANAGEMENT_INPUT);
		sleepInSecond(SHORT_TIMEOUT);
		waitForElementClickable(driver, AdminHomePageUI.VALUE_REGION_IN_USER_MANAGEMENT_INPUT);
		clickToElement(driver, AdminHomePageUI.VALUE_REGION_IN_USER_MANAGEMENT_INPUT);
	}

	public void inputToArea(String area) {
		scrollToElement(driver, AdminHomePageUI.AREA_IN_USER_MANAGEMENT_INPUT);
		waitForElementClickable(driver, AdminHomePageUI.AREA_IN_USER_MANAGEMENT_INPUT);
		sendKeyToElement(driver, AdminHomePageUI.AREA_IN_USER_MANAGEMENT_INPUT, area);
	}

	public void clickToValueArea() {
		scrollToElement(driver, AdminHomePageUI.VALUE_AREA_IN_USER_MANAGEMENT_INPUT);
		sleepInSecond(THREE_SECONDS);
		waitForElementClickable(driver, AdminHomePageUI.VALUE_AREA_IN_USER_MANAGEMENT_INPUT);
		clickToElement(driver, AdminHomePageUI.VALUE_AREA_IN_USER_MANAGEMENT_INPUT);
	}
}
