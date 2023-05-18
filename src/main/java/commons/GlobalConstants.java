package commons;

import java.io.File;

public class GlobalConstants {
    public static final String ADMIN_LOGIN = "https://admin.longhaii.com/";
    public static final String NPP_LOGIN = "https://npp.longhaii.com/";
    public static final String WARE_HOUSE_LOGIN = "https://kho.thachlonghai.co/";
    public static final String ACCOUNTANT_LOGIN = "https://kt.longhaii.com/";
    public static final String MARKETING_STAFF_LOGIN = "https://nvtt.longhaii.com/";
    public static String ADMIN_ACCOUNT = "adminqc";
    public static String ADMIN_PASSWORD = "admin@11";
    public static String NPP_ACCOUNT ="npp.lhe";
    public static String NPP_PASSWORD ="lhe@1234";
    public static String WARE_HOUSE_ACCOUNT = "0966666666";
    public static String WARE_HOUSE_PASSWORD ="Longhai@2023";
    public static String ACCOUNTANT_ACCOUNT = "0955555555";
    public static String ACCOUNTANT_PASSWORD = "Longhai@2023";
    public static String MARKETING_STAFF_ACCOUNT = "nvtt.lhe";
    public static String MARKETING_STAFF_PASSWORD = "lhe@1234";
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String REPORT_NG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;
    public static final int SHORT_TIMEOUT = 1;
    public static final int THREE_SECONDS = 3;
    public static final long FIVE_SECONDS = 5;
    public static final long LONG_TIMEOUT = 20;
}
