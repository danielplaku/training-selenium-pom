package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FunctionUtils {

    public static void clickElement(WebElement element) {
        //TBD
    }

    public static void clickWebElement(WebElement element) {
        DriverUtils.waitDriver.until(ExpectedConditions.visibilityOf(element));
        DriverUtils.waitDriver.until(ExpectedConditions.elementToBeClickable(element));
        DriverUtils.clickElement(element);
    }
}
