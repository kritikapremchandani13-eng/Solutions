package coreUtilities.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CommonEvents {
    WebDriver driver;
    public CommonEvents(WebDriver d) { this.driver = d; }

    // find
    public WebElement findElement(By loc) { return driver.findElement(loc); }

    // click
    public void click(By loc) { driver.findElement(loc).click(); }
    public void click(WebElement ele) { ele.click(); }

    // sendKeys
    public void sendKeys(By loc, String val) { driver.findElement(loc).sendKeys(val); }

    // get multiple
    public List<WebElement> getWebElements(By loc) { return driver.findElements(loc); }

    // get url
    public String getCurrentUrl() { return driver.getCurrentUrl(); }

    // wait url
    public boolean waitForUrlContains(String part, int sec) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(sec))
                    .until(ExpectedConditions.urlContains(part));
        } catch (Exception e) { return false; }
    }

    // isDisplayed
    public boolean isDisplayed(By loc) {
        try { return driver.findElement(loc).isDisplayed(); }
        catch (Exception e) { return false; }
    }

    // getAttribute
    public String getAttribute(WebElement ele, String attr) {
        return ele.getAttribute(attr);
    }

	public void navigateTo(String url) {
		driver.get(url);
		
	}
}
