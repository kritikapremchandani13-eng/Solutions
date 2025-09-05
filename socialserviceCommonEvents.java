package coreUtilities.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonEvents {

    WebDriver driver;

    public CommonEvents(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By loc) {
        return driver.findElement(loc);
    }

    public void click(By loc) {
        findElement(loc).click();
    }

    public void sendKeys(By loc, String val) {
        WebElement el = findElement(loc);
        try { el.clear(); } catch (Exception ignored) {}
        el.sendKeys(val);
    }

    public boolean isDisplayed(By loc) {
        try {
            return findElement(loc).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getText(By loc) {
        return findElement(loc).getText();
    }

    public String getAttribute(By loc, String attr) {
        return findElement(loc).getAttribute(attr);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<WebElement> getWebElements(By loc) {
        return driver.findElements(loc);
    }

    // scroll into view (very small helper)
    public void jsScrollPageTillElementVisible(By loc) {
        WebElement el = findElement(loc);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
    }

    // explicit wait for visibility (seconds)
    public void waitForElementVisible(By loc, int sec) {
        new WebDriverWait(driver, Duration.ofSeconds(Math.max(sec,1)))
                .until(ExpectedConditions.visibilityOfElementLocated(loc));
    }

    // dropdown helpers
    public void selectByVisibleText(By loc, String text) {
        new Select(findElement(loc)).selectByVisibleText(text);
    }

    public String getFirstSelectedOptionFromDropdown(By loc) {
        return new Select(findElement(loc)).getFirstSelectedOption().getText();
    }

    // small visual helper used in original code (safe no-op if not required)
    public void highlightElementAfterAction(WebElement el) {
        // keep short: no-op or tiny highlight if you want
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid orange'", el);
        } catch (Exception ignore) {}
    }

	public void navigateTo(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
	}
}
