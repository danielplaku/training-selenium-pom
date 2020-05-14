package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.SelectDropdownListPage;
import utils.DriverFactory;
import utils.DriverUtils;

public class SelectDropdownListTest {

    @Test
    public void testDropDown() {

        WebDriver driver = DriverFactory.getDriver("chrome");
        WebDriverWait wait = DriverUtils.waitDriver(driver, 5);
        driver.get("https://www.seleniumeasy.com/test/");

        //main page
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateToSelectDropdownList();

        //select dropdown list (selectDropdown Page)
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);
        selectDropdownListPage.selectElementFromDropdown("Monday");
        String actualText = selectDropdownListPage.getElementText();

        //assert
        Assert.assertEquals("Monday", actualText);
    }
}
