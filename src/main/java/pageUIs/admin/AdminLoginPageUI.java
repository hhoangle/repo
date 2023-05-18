package pageUIs.admin;

public class AdminLoginPageUI {
	public static final String LOGIN_BUTTON = "//span[text()='Đăng nhập']";
	public static final String ICON_EYE = "//i[@class='v-icon eye-slash']";
	public static final String ACCOUNT_TEXTBOX = "//input[@placeholder='Nhập tên tài khoản']";
	public static final String PASSWORD_TEXTBOX = "//input[@placeholder='Nhập mật khẩu']";
	public static final String ACCOUNT_EMPTY_ERROR_MESSAGE = "//input[@placeholder='Nhập tên tài khoản']/parent::div[@class='input__content relative']/following-sibling::p";
	public static final String PASS_EMPTY_ERROR_MESSAGE = "//input[@placeholder='Nhập mật khẩu']/parent::div[@class='input__content relative']/following-sibling::p";
	public static final String MODAL_TEXT = "//div[@class='modal']//p[text()='Sai tên hoặc sai mật khẩu']";

}
