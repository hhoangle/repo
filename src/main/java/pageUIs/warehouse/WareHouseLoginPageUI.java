package pageUIs.warehouse;

public class WareHouseLoginPageUI {
    public static final String WAREHOUSE_ACCOUNT_TEXTBOX = "//input[@placeholder='Nhập tên tài khoản']";
    public static final String WAREHOUSE_PASSWORD_TEXTBOX = "//input[@placeholder='Nhập mật khẩu']";
    public static final String ACCOUNT_EMPTY_ERROR_MESSAGE = "//span[text()='Tên tài khoản ']/parent::label/following-sibling::p";
    public static final String PASS_EMPTY_ERROR_MESSAGE = "//span[text()='Mật khẩu ']/parent::label/following-sibling::p";
    public static final String MODAL_TEXT = "//div[@class='modal']//span[text()='Sai tên hoặc sai mật khẩu']";
    public static final String CLOSE_POPUP_BUTTON = "//button[@class='btn btn__color--default btn__size--default']";
    public static final String EYE_ICON = "//i[@class='v-icon eye-slash']";
    public static final String LOGIN_BUTTON = "//button[@class='btn btn__color--primary btn__size--default']";
    public static final String LOGIN_SUCCESS_MARK = "//p[contains(text(),'Phiếu giao dịch')]" ;
}
