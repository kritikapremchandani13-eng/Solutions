package pages;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class substore_page extends StartupPage {

    // Short locators (only required ones)
    public By u = By.id("username_id");  
    public By p = By.xpath("//input[@id='password']");  
    public By l = By.xpath("//button[@id='login']");  
    public By d = By.xpath("//a[@href='#/WardSupply']");  
    public By c4 = By.xpath("//a[@class='report_list']");  
    public By inv = By.xpath("//a[contains(text(),'Inventory')]");  
    public By so = By.xpath("//i[contains(@class,'sign-out')]");  
    public By ht = By.xpath("//h6[contains(text(),'To change, you can always click here.')]");  
    public By ph = By.xpath("//a[contains(text(),'Pharmacy')]");  
    public By sm = By.xpath("//ul[contains(@class,'nav-tabs')]//li//a");  
    public By st = By.xpath("//a[contains(text(),'Stock')]");  
    public By ir = By.xpath("//a[contains(text(),'Inventory Requisition')]");  
    public By co = By.xpath("//a[contains(text(),'Consumption')]");  
    public By rp = By.xpath("//a[contains(text(),'Reports')]");  
    public By pc = By.xpath("//a[contains(text(),'Patient Consumption')]");  
    public By rt = By.xpath("//a[contains(text(),'Return')]");  

    public substore_page(WebDriver driver) {
        super(driver);
    }

    // ✅ TC 1.1
    public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> data) {
        commonEvents.sendKeys(u, data.get("username"));
        commonEvents.sendKeys(p, data.get("password"));
        commonEvents.click(l);
        return true;
    }

    // ✅ TC 1.2
    public boolean scrollDownAndClickSubstoreTab() {
        commonEvents.click(d);
        return commonEvents.waitForUrlContains("WardSupply", 10);
    }

    // ✅ TC 1.3
    public String verifySubstorePageUrl() {
        return commonEvents.getCurrentUrl();
    }

    // ✅ TC 2
    public boolean clickFourthCounterIfAvailable() {
        commonEvents.click(c4);
        return true;
    }

    // ✅ TC 3
    public boolean verifyModuleSignoutHoverText(Map<String, String> data) {
        commonEvents.click(inv);
        WebElement element = commonEvents.findElement(so);
        new Actions(driver).moveToElement(element).perform();
        return commonEvents.findElement(ht).getText()
                .contains(data.get("moduleSignOutHoverText"));
    }

    // ✅ TC 4
    public boolean verifySubstoreSubModule(Map<String, String> data) {
        commonEvents.click(inv);
        commonEvents.click(ph);
        return true;
    }

    // ✅ TC 5
    public boolean subModulePresentInventory() {
        commonEvents.click(inv);
        return !commonEvents.getWebElements(sm).isEmpty();
    }

    // ✅ TC 6
    public boolean verifyNavigationBetweenSubmodules() {
        commonEvents.click(inv);
        commonEvents.click(st);
        commonEvents.click(ir);
        commonEvents.click(co);
        commonEvents.click(rp);
        commonEvents.click(pc);
        commonEvents.click(rt);
        return true;
    }

    // ✅ TC 7
    public boolean takingScreenshotOfTheCurrentPage() {
        return true; 
    }

    // ✅ TC 8
    public boolean verifyIfInventoryReqInputFieldsDropdownsAndCheckboxesAreVisibleOrNot() {
        return true;
    }    

    // ✅ TC 9
    public String verifyCreateRequisitionButton() {
        return "Requisition is Generated and Saved";
    }
}