package pageUIs.accountant;

public class AccountantPageUI {
    // LOGIN PAGE
    public static final String ACCOUNTANT_ACCOUNT_TEXTBOX = "//input[@placeholder='Nhập tên tài khoản']";
    public static final String ACCOUNTANT_PASSWORD_TEXTBOX = "//input[@placeholder='Nhập mật khẩu']";
    public static final String ACCOUNT_EMPTY_ERROR_MESSAGE = "//div[@class='login__container']//div[1]//div[1]//p";
    public static final String PASS_EMPTY_ERROR_MESSAGE = "//body/div[@id='__nuxt']/div[@id='__layout']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/p[1]";
    public static final String MODAL_TEXT = "//div[@class='modal__content']//span[text()='Sai tên hoặc sai mật khẩu']";
    public static final String CLOSE_POPUP_BUTTON = "//button[@class='btn btn__color--default btn__size--default']";
    public static final String EYE_ICON = "//i[@class='v-icon eye-slash']";
    public static final String LOGIN_BUTTON = "//button[@class='btn btn__color--primary btn__size--default']";
    //DASHBOARD
    public static final String LOGIN_SUCCESS_MARK = "//div[contains(text(),'Dashboard')]" ;
    public static final String ORDER_BUTTON = "//div[contains(text(),'Đơn hàng')]";

    //ORDER PAGE
    public static final String ORDER_HEADER = "//div[@class='order__screen body-container']/div[1]" ;
    public static final String VIEW_ORDER_DETAIL_BUTTON = "//body/div[@id='__nuxt']/div[@id='__layout']/div[1]/div[2]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[9]/div[1]/a[1]";
    public static final String ORDER_DETAIL_HEADER = "//div[contains(text(), 'Chi tiết đơn hàng')]";
    public static final String ORDER_STATUS_DROPDOWN = "//div[contains(text(),'Trạng thái')]";
    public static final String ORDER_STATUS_VALUE = "//div[contains(text(),'Đang xử lý')]";

    public static final String FINISH_ORDER_BUTTON = "//div[text()='Hoàn thành đơn']";
    public static final String FINISH_ORDER_SUCCESS = "//span[contains(text(),'Duyệt đơn thành công.')]";
}
