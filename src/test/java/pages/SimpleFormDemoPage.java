package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleFormDemoPage {

    WebDriver driver;

    public SimpleFormDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "user-message")
    WebElement messageInputField;

    @FindBy(xpath = "//button[contains(text(), 'Show Message')]")
    WebElement showMessageButton;

    @FindBy(id = "display")
    WebElement displayedMessage;


    public void enterMessageToInputField(String message) {
        messageInputField.sendKeys(message);
    }

    public void clickShowMessageButton() {
        showMessageButton.click();
    }

    public String displayedConfirmationMessage() {
        return displayedMessage.getText();
    }
}
