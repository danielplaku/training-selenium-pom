package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SimpleFormDemoPage;
import utils.DriverFactory;
import utils.DriverUtils;

public class SimpleFormDemoTest {

    @Test
    public void simpleFormTest() {
        //initialize driver
        WebDriver driver = DriverFactory.getDriver("chrome");
        driver.get("https://www.seleniumeasy.com/test/");

        //click input forms and simple form demo elements (Main pages)
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateToSimpleFormDemo();

        //inside simple form demo pages (SimpleFormDemo pages)
        SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage(driver);

        simpleFormDemoPage.enterMessageToInputField("Here enter the text.");
        simpleFormDemoPage.clickShowMessageButton();
        String actualMessage = simpleFormDemoPage.displayedConfirmationMessage();
        Assert.assertEquals("Here enter the text.", actualMessage);

        //close the driver
        driver.close();
    }
}
