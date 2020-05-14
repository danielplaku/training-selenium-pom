package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownListPage {

    WebDriver driver;

    public SelectDropdownListPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "select-demo")
    WebElement dropdownElement;

    @FindBy(id = "selected-value")
    WebElement displayedText;

    public void selectElementFromDropdown(String optionByVisibleText) {
        dropdownElement.click();
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(optionByVisibleText);
    }

    public String getElementText() {
        return displayedText.getText();
    }

}
