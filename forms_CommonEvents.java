package coreUtilities.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonEvents {
    private WebDriver driver;

    public CommonEvents(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void sendKeys(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getAttribute(By locator, String attr) {
        return driver.findElement(locator).getAttribute(attr);
    }

    public boolean isSelected(By locator) {
        return driver.findElement(locator).isSelected();
    }

    public boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
}
