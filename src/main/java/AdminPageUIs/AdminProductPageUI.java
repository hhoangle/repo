package AdminPageUIs;

public class AdminProductPageUI {
    public static final String CREATE_PRODUCT_BUTTON = "//p[text()='Tạo sản phẩm mới']";
    public static final String MANAGE_PRODUCT = "//a[text()='Sản phẩm']";
    public static final String SAVE_PRODUCT = "//button[contains(text(),'Lưu lại')]";
    public static final String WARNING_MESSAGE = "//p[contains(text(),'Tạo sản phẩm không thành công')]";
    public static final String CLOSE_POPUP_BUTTON = "//p[contains(text(),'Đóng')]";
    public static final String PRODUCT_NAME_FIELD = "//input[@placeholder='Nhập tên sản phẩm']";
    public static final String BARCODE_FIELD = "//input[@placeholder='Nhập mã vạch']";
    public static final String PRODUCT_IMAGE = "//div[@class='bg-white rounded-lg p-5 mb-4']//input[@type='file']";
    public static final String SELLING_PRICE_FIELD = "//input[@placeholder='Nhập giá bán']";
    public static final String IMPORT_PRICE_FIELD = "//input[@placeholder='Nhập giá nhập']";
    public static final String QUANTITY_FIELD = "//input[@placeholder='Nhập tồn']";
    public static final String PRODUCT_DESCRIPTION_FIELD = "//textarea[@placeholder='Nhập mô tả']";
    public static final String SELLING_PRICE_TEXT = "//p[contains(text(),'Giá bán')]//following-sibling::p";
    public static final String IMPORT_PRICE_TEXT = "//p[contains(text(),'Giá nhập')]//following-sibling::p";
    public static final String BRAND_NAME_TEXT_IN_DETAIL_PAGE = "//p[contains(text(),'Thương hiệu')]//following-sibling::p";
    public static final String PRODUCT_NAME_TEXT = "//p[contains(text(),'Tên sản phẩm')]/following-sibling::p";
    public static final String TRADEMARK_INPUT = "//p[text()='Thương hiệu']/following-sibling::div";
    public static final String BRAND_NAME = "//p[text()='Thương hiệu']/following-sibling::div[1]//li[@id='null-0']";
    public static final String ADD_INFO_TEXT = "//div[contains(text(),'Thông tin thêm')]";
    public static final String BRAND_NAME_TEXT = "//p[text()='Thương hiệu']/following-sibling::div/div[2]//span";

}
