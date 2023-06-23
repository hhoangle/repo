package NPT.NptPageObjects.NptPageUIs;

public class NptProductPageUI {
    public static final String MANAGE_PRODUCT = "//p[text()='Quản lý sản phẩm']";

    public static final String CREATE_PRODUCT_BUTTON = "//button[contains(text(),'Tạo sản phẩm')]";
    public static final String BARCODE_FIELD = "//input[@placeholder='Nhập hoặc quét mã vạch']";
    public static final String PRODUCT_NAME_FIELD = "//input[@placeholder='Nhập tên sản phẩm']";
    public static final String SELLING_PRICE_FIELD = "//input[@placeholder='Nhập giá bán']";
    public static final String IMPORT_PRICE_FIELD = "//input[@placeholder='Nhập giá nhập']";
    public static final String QUANTITY_FIELD = "//input[@placeholder='Nhập số lượng']";
    public static final String QUANTITY_TITLE = "//label[contains(text(),'Số lượng')]";
    public static final String SELECT_BRAND_DROPDOWN_LIST_PARENT = "//input[@placeholder='Chọn thương hiệu']";
    public static final String BRAND_NAME = "//div[@class='w-full bg-white overflow-y-auto max-h-[300px] border border-gray-light rounded-lg']/div[1]";
    public static final String SELECT_PRODUCT_CATEGORY_LIST_PARENT = "//input[@placeholder='Chọn ngành hàng']";
    public static final String SELECT_PRODUCT_GROUP_LIST_PARENT = "//input[@placeholder='Chọn nhóm sản phẩm']";
    public static final String ENABLE_STATUS_BUTTON = "//div[@class='flex items-center']";
    public static final String SELL_ONLINE_BUTTON = "//p[text()='Bán online']/../div/label/div";
    public static final String PRODUCT_DESCRIPTION_FIELD = "//input[@placeholder='Nhập mô tả']";
    public static final String SAVE_BUTTON = "//button[text()='Lưu']";

    public static final String PRODUCT_CATEGORY_NAME = "//div[@class='w-full bg-white overflow-y-auto max-h-[300px] border border-gray-light rounded-lg']/div[2]";
    public static final String PRODUCT_GROUP_NAME = "//div[@class='w-full bg-white overflow-y-auto max-h-[300px] border border-gray-light rounded-lg']/div[1]";
    public static final String PRODUCT_IMAGE = "//input[@type='file']";
}
