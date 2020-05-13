package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleFormDemoPage {

    WebDriver driver;

    public SimpleFormDemoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterMessageToInputField(String message) {
        driver.findElement(By.id("user-message")).sendKeys(message);
    }

    public void clickShowMessageButton() {
        driver.findElement(By.xpath("//button[contains(text(), 'Show Message')]")).click();
    }

    public String displayedConfirmationMessage() {
        return driver.findElement(By.id("display")).getText();
    }
}
