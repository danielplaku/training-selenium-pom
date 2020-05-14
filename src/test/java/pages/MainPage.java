package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //main page objects (WebElements)
    @FindBy(xpath = "//ul[@id='treemenu']//a[contains(text(),'Input Forms')]")
    WebElement inputForms;

    @FindBy(xpath = "//ul[@id='treemenu']//a[contains(text(),'Simple Form Demo')]")
    WebElement simpleFormDemo;

    @FindBy(css = "#treemenu > li > a + ul > li:nth-child(1) > ul > li:nth-child(4) a")
    WebElement selectDropdownList;


    //actions with main page objects
    public void clickInputForms() {
        inputForms.click();
    }

    public void clickSimpleFormDemo() {
        simpleFormDemo.click();
    }

    public void clickDropDownList(){
        selectDropdownList.click();
    }


    //functionality

    //if complexity is low, there is no need to create these methods in page class level, but instead call them directly in test class level
    //if complexity is high, here below we composite different actions in one single method and use it in where we want

    public void navigateToSimpleFormDemo() {
        clickInputForms();
        clickSimpleFormDemo();
    }

    public void navigateToSelectDropdownList() {
        clickInputForms();
        clickDropDownList();
    }

}
