package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String PATH_TO_DRIVER = "src\\main\\resources\\chromedriver.exe";
    private static WebDriver driver = null;

    static {
        System.setProperty(CHROME_DRIVER, PATH_TO_DRIVER);
    }

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void removeDriver() {
        driver.quit();
    }
}