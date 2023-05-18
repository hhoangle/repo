package pageUIs.npp;

public class NppLoginPageUI {

    public static final String NPP_ACCOUNT_TEXTBOX = "//input[@placeholder='Nhập số điện thoại']";
    public static final String NPP_PASSWORD_TEXTBOX = "//input[@placeholder='Nhập mật khẩu']";
    public static final String ACCOUNT_EMPTY_ERROR_MESSAGE = "//span[text()='Số điện thoại ']/parent::label/following-sibling::p";
    public static final String PASS_EMPTY_ERROR_MESSAGE = "//span[text()='Mật khẩu ']/parent::label/following-sibling::p";
    public static final String MODAL_TEXT = "//div[@class='modal']//p[text()='Sai tên hoặc sai mật khẩu']";
    public static final String CLOSE_POPUP_BUTTON = "//button[@class='btn btn__color--default btn__size--default']";
    public static final String EYE_ICON = "//i[@class='v-icon eye-slash']";
    public static final String LOGIN_BUTTON = "//button[@class='btn btn__color--primary btn__size--default']";
    public static final String LOGIN_SUCCESS_MARK = "//p[text()='Biểu đồ']";
    public static final String PROFIT_TEXT = "//div[@seriesname='Lợixnhuận']";
}
