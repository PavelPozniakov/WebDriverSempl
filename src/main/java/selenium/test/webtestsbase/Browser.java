package selenium.test.webtestsbase;

/**
 * Created by pavelpozniakov on 14.06.17.
 */
public enum  Browser {
    FIREFOX("firefox"),
    CHROME("chrome"),
    SAFARI("safari");
    private String browserName;

    Browser(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserName() {
        return browserName;
    }

    /**
     * returns browser object by name
     * @param name name of browser
     * @return browser object
     */
    public static Browser getByName(String name){
        for(Browser browser : values()) {
            if(browser.getBrowserName().equalsIgnoreCase(name)) {
                return browser;
            }
        }
        return null;
    }

    private static String browser = "firefox";

    /**
     * getting browser object
     * @return browser object
     */
    public static Browser getBrowser() {
        Browser browserForTests = Browser.getByName(browser);
        if (browserForTests != null) {
            return browserForTests;
        } else {
            throw new IllegalStateException("Browser name '" + browser + "' is not valid");
        }
    }

}
