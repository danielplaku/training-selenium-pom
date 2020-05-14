package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {

    private static final WebDriver driver = DriverFactory.getDriver("chrome");

    public static final WebDriverWait waitDriver = new WebDriverWait(driver, 7);

    public static WebDriverWait waitDriver(WebDriver driver, int seconds) {
        return new WebDriverWait(driver, seconds);
    }

    public static void clickElement(WebElement element) {
        //TBD
    }

}
