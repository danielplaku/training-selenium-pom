package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getDriver(String driverType){

        if (driverType.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\U183700\\Selenim Training POM\\src\\main\\resources\\chromedriver.exe");
            return new ChromeDriver();
        } else if (driverType.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\U183700\\Selenim Training POM\\src\\main\\resources\\geckodriver.exe");
            return new FirefoxDriver();
        } else {
            return null;
        }
    }
}
