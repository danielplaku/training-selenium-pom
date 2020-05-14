package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownListPage {

    WebDriver driver;

    public SelectDropdownListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectElementFromDropdown(String optionByVisibleText) {
        WebElement dropdownElement = driver.findElement(By.id("select-demo"));
        dropdownElement.click();
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(optionByVisibleText);
    }

    public String getElementText() {
        return driver.findElement(By.className("selected-value")).getText();
    }

}
