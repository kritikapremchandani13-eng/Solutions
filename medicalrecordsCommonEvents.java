package coreUtilities.utils;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonEvents {
    WebDriver d;
    WebDriverWait w;

    public CommonEvents(WebDriver d) {
        this.d = d;
        this.w = new WebDriverWait(d, Duration.ofSeconds(10));
    }

    public WebElement findElement(By loc) { 
        return w.until(ExpectedConditions.visibilityOfElementLocated(loc)); 
    }

    public List<WebElement> finds(By loc) { 
        return d.findElements(loc); 
    }

    public void click(By loc) { 
        findElement(loc).click(); 
    }

    public void sendKeys(By loc, String val) { 
        WebElement e = findElement(loc); 
        e.clear(); 
        e.sendKeys(val); 
    }

  
    public String getCurrentUrl() { 
        return d.getCurrentUrl(); 
    }

    public boolean waitForUrlContains(String t, int sec) {
        try { 
            new WebDriverWait(d, Duration.ofSeconds(sec))
                .until(ExpectedConditions.urlContains(t));
            return true;
        } catch (Exception e) { 
            return false; 
        }
    }

    public void navigateTo(String url) { 
        d.get(url); 
    }

}
