package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.SimpleFormDemoPage;
import utils.DriverFactory;

public class SimpleFormDemoTest {

    @Test
    public void simpleFormTest() {
        //initialize driver
        WebDriver driver = DriverFactory.getDriver("chrome");
        WebDriverWait wait = DriverFactory.waitDriver(driver, 5);
        driver.get("https://www.seleniumeasy.com/test/");

        //click input forms and simple form demo elements (Main pages)
        MainPage mainPage = new MainPage(driver);
        mainPage.clickInputForms();
        mainPage.clickSimpleFormDemo();

        //inside simple form demo pages (SimpleFormDemo pages)
        SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-message")));
        simpleFormDemoPage.enterMessageToInputField("Here I enter my text.");
        simpleFormDemoPage.clickShowMessageButton();
        String actualMessage = simpleFormDemoPage.displayedConfirmationMessage();
        Assert.assertEquals("Here I enter my text.", actualMessage);

        //close the driver
        driver.close();
    }
}
