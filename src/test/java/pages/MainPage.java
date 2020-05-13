package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickInputForms() {
        driver.findElement(By.xpath("//ul[@id='treemenu']//a[contains(text(),'Input Forms')]")).click();
    }

    public void clickSimpleFormDemo() {
        driver.findElement(By.xpath("//ul[@id='treemenu']//a[contains(text(),'Simple Form Demo')]")).click();
    }


}
