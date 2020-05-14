package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.SelectDropdownListPage;
import utils.DriverFactory;

public class SelectDropdownListTest {

    @Test
    public void testDropDown() {

        WebDriver driver = DriverFactory.getDriver("chrome");
        WebDriverWait wait = DriverFactory.waitDriver(driver, 5);
        driver.get("https://www.seleniumeasy.com/test/");

        //main page
        MainPage mainPage = new MainPage(driver);
        mainPage.clickInputForms();
        mainPage.clickDropDownList();

        //select dropdown list (selectDropdown Page)
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);
        selectDropdownListPage.selectElementFromDropdown("Monday");
        //wait.until(ExpectedConditions.textToBe(By.className("selected-value"), "Saturday"));
        String actualText = selectDropdownListPage.getElementText();

        //assert
        Assert.assertEquals("Monday", actualText);
    }
}
