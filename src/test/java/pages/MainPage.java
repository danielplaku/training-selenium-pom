package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    //krijohen objektet WebElements


    public void clickInputForms() {
        driver.findElement(By.xpath("//ul[@id='treemenu']//a[contains(text(),'Input Forms')]")).click();
    }

    public void clickSimpleFormDemo() {
        driver.findElement(By.xpath("//ul[@id='treemenu']//a[contains(text(),'Simple Form Demo')]")).click();
    }

    public void clickDropDownList(){
        driver.findElement(By.cssSelector("#treemenu > li > a + ul > li:nth-child(1) > ul > li:nth-child(4) a")).click();
    }



}
