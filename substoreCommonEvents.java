package coreUtilities.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CommonEvents {
    WebDriver driver;
    public CommonEvents(WebDriver d) { this.driver = d; }

    // find element
    public WebElement findElement(By loc) { 
        return driver.findElement(loc); 
    }

    // click
    public void click(By loc) { 
        driver.findElement(loc).click(); 
    }

    // sendKeys
    public void sendKeys(By loc, String val) { 
        driver.findElement(loc).sendKeys(val); 
    }

    // get multiple elements
    public List<WebElement> getWebElements(By loc) { 
        return driver.findElements(loc); 
    }

    // get current URL
    public String getCurrentUrl() { 
        return driver.getCurrentUrl(); 
    }

    // wait for URL
    public boolean waitForUrlContains(String part, int sec) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(sec))
                    .until(ExpectedConditions.urlContains(part));
        } catch (Exception e) {
            return false;
        }
    }

	public void navigateTo(String url) {
		driver.get(url);
	}
}

















