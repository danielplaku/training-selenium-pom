package com.basis.webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

public class MyFirstTest {

    //test data parametrization
    private String URL = "https://www.seleniumeasy.com/test/";
    private String inputFieldValue = "My first selenium scenario.";
    private String messageInput = "My first selenium scenario.";
    private String driverType = "chrome";
    private String chosenDay = "Wednesday";

    //pages elements parametrization
    private By shownPopupCloseButtonElement = By.id("at-cv-lightbox-close");
    private By inputFormsElement = By.xpath("//ul[@id='treemenu']//a[contains(text(),'Input Forms')]");
    private By simpleFormDemo = By.xpath("//ul[@id='treemenu']//a[contains(text(),'Simple Form Demo')]");
    private By selectDropdownListElement = By.cssSelector("#treemenu > li > a + ul > li:nth-child(1) > ul > li:nth-child(4) a");
    private By selectElement = By.id("select-demo");
    private By daySelectedTextElement = By.className("selected-value");
    private By enterMessageInputFieldElement = By.id("user-message");
    private By showMessageButtonElement = By.xpath("//button[contains(text(), 'Show Message')]");
    private By displayedText = By.id("display");

    static WebDriver driver;
    WebDriverWait driverWait;

    @Test
    public void test1() {

        driver.get(URL);
        driver.manage().window().maximize();

        sleepInSeconds(3);

        //this piece of code close the popup when we first open the pages if it is shown
        if (driver.findElement(shownPopupCloseButtonElement).isDisplayed()) {
            driver.findElement(shownPopupCloseButtonElement).click();
        }

        //klikojme Input Forms
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(inputFormsElement));
        driver.findElement(inputFormsElement).click();

        sleepInSeconds(1);

        //klikojme simple form demo
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(simpleFormDemo));
        driver.findElement(simpleFormDemo).click();

        sleepInSeconds(3);

        //vendosim tekst tek Enter Message input field
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(enterMessageInputFieldElement));
        driver.findElement(enterMessageInputFieldElement).sendKeys(inputFieldValue);

        //klikojme butonin show message
        driver.findElement(showMessageButtonElement).click();

        //marrim tekstin e shfaqur
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(displayedText));
        String teksti = driver.findElement(displayedText).getText();

        //vertetojme qe na shfaqet teksti qe vendosem tek forma
        Assert.assertEquals(messageInput, teksti);
        System.out.println("Test executed successfully!");
        sleepInSeconds(3);
    }

    @Test
    public void test2() {
        driver.get(URL);
        driver.manage().window().maximize();

        sleepInSeconds(3);

        //this piece of code close the popup when we first open the pages if it is shown
        if (driver.findElement(shownPopupCloseButtonElement).isDisplayed()) {
            driver.findElement(shownPopupCloseButtonElement).click();
        }

        sleepInSeconds(3);

        //klikojme Input Forms
        driver.findElement(inputFormsElement).click();

        sleepInSeconds(1);

        //klikojme Select Dropdown List element
        driver.findElement(selectDropdownListElement).click();

        sleepInSeconds(3);

        //perzgjedhim nje vlere nga dropdown
        WebElement dropdownElement = driver.findElement(selectElement);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(chosenDay);

        sleepInSeconds(1);

        //vertetoj qe dita e perzgjedhur shfaqet poshte tij
        String dropdownValue = driver.findElement(daySelectedTextElement).getText();
        Assert.assertEquals("Vlerat nuk jane te barabarta!!!", "Day selected :- "+ chosenDay,dropdownValue);
    }

    @Before
    public void before(){
        System.out.println("executed before test case start");
        driver = DriverFactory.getDriver(driverType);
        driverWait = new WebDriverWait(driver, 3);
    }

    @After
    public void after(){
        System.out.println("executed after test case start");
        driver.close();
    }

    private static void sleepInSeconds(int numberOfSeconds) {
        try {
            Thread.sleep(numberOfSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
