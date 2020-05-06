package com.basis.webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utils.DriverFactory;

public class MyFirstTest {

    //test data parametrization
    String URL = "https://www.seleniumeasy.com/test/";
    String inputFieldValue = "My first selenium scenario.";
    String messageInput = "My first selenium scenario.";
    String driverType = "chrome";

    //page elements parametrization
    By inputFormsElement = By.xpath("//ul[@id='treemenu']//a[contains(text(),'Input Forms')]");
    By simpleFormDemo = By.xpath("//ul[@id='treemenu']//a[contains(text(),'Input Forms')]");
    By enterMessageInputFieldElement = By.id("user-message");
    By showMessageButtonElement = By.xpath("//button[contains(text(), 'Show Message')]");
    By displayedText = By.id("display");

    WebDriver driver;

    @Test
    public void test1() {

        driver = DriverFactory.getDriver(driverType);

        driver.get(URL);

        sleepInSeconds(3);

        //klikojme Input Forms
        driver.findElement(inputFormsElement).click();

        sleepInSeconds(1);

        //klikojme simple form demo
        driver.findElement(simpleFormDemo).click();

        sleepInSeconds(2);

        //vendosim tekst tek Enter Message input field
        driver.findElement(enterMessageInputFieldElement).sendKeys(inputFieldValue);

        //klikojme butonin show message
        driver.findElement(showMessageButtonElement).click();

        //marrim tekstin e shfaqur
        String teksti = driver.findElement(displayedText).getText();

        //vertetojme qe na shfaqet teksti qe vendosem tek forma
        Assert.assertEquals(messageInput, teksti);
        System.out.println("Test executed successfully!");

        driver.close();

        driver.quit();

    }

    @Before
    public void before(){
        System.out.println("executed before test case start");
        driver = DriverFactory.getDriver(driverType);
    }

    @After
    public void after(){
        System.out.println("executed after test case start");
        driver.close();
        driver.quit();
    }

    @Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\U183700\\Selenim Training POM\\src\\main\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.seleniumeasy.com/test/");

        sleepInSeconds(3);

        //klikojme Input Forms
        driver.findElement(By.xpath("//ul[@id='treemenu']//a[contains(text(),'Input Forms')]")).click();

        sleepInSeconds(1);

        //klikojme select dropdown list element
        driver.findElement(By.cssSelector("#treemenu > li > a + ul > li:nth-child(1) >ul >li:nth-child(4) a")).click();

        sleepInSeconds(3);

        //perzgjedhim nje vlere nga dropdowni (wednesday)
        WebElement dropdownElement = driver.findElement(By.id("select-demo"));
        Select select = new Select(dropdownElement);
        select.selectByVisibleText("Wednesday");

        sleepInSeconds(1);

        //vertetoj qe dita e perzgjedhur shfaqet poshte tij
        String dropdownValue = driver.findElement(By.className("selected-value")).getText();
        Assert.assertEquals("vlerat uk jane te barabarta!!!", "Day sel :- Wednesday",dropdownValue);

    }

    private static void sleepInSeconds(int numberOfSeconds) {
        try {
            Thread.sleep(numberOfSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
