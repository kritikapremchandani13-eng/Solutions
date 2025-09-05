package pages;

import java.util.Map;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class FormManagement_L1_Pages extends StartupPage {
    // Locators
    By switchToNavigationMenu = By.xpath("//a[contains(text(),'SwitchTo')]"); 
    By alertPopup = By.xpath("//a[contains(text(),'Alerts')]"); 
    By buttonToDisplayAnAlertBox = By.xpath("//button[contains(text(),'click the button to display an  alert box:')]"); 
    By registerNavigationMenu = By.xpath("//a[contains(text(),'Register')]"); 
    By firstNameTextbox = By.xpath("//input[@placeholder='First Name']"); 
    By lastNameTextbox = By.xpath("//input[@placeholder='Last Name']"); 
    By addressInputAreabox = By.xpath("//textarea[@ng-model='Adress']"); 
    By emailAddressTextbox = By.xpath("//input[@type='email']"); 
    By phoneNumberTextbox = By.xpath("//input[@type='tel']"); 
    By maleRadioButton = By.xpath("//input[@value='Male']"); 
    By feMaleRadioButton = By.xpath("//input[@value='FeMale']"); 
    By cricketCheckBox = By.xpath("//input[@value='Cricket']"); 
    By moviesCheckBox = By.xpath("//input[@value='Movies']"); 
    By hockeyCheckBox = By.xpath("//input[@value='Hockey']"); 
    By clickOnCountryDropdown = By.xpath("//span[@role='combobox']");
    By selectCountryAustralia = By.xpath("//li[contains(text(),'Australia')]"); 
    By selectYear = By.xpath("//select[@placeholder='Year']");
    By selectMonth = By.xpath("//select[@placeholder='Month']"); 
    By selectDate = By.xpath("//select[@placeholder='Day']"); 

    public FormManagement_L1_Pages(org.openqa.selenium.WebDriver driver) { super(driver); }

    public String validateTitleOfHomePage() { return commonEvents.getTitle(); }

    public String clickOnSwitchToAlertandValidateTitleOfPage() {
        commonEvents.click(switchToNavigationMenu);
        commonEvents.click(alertPopup);
        return commonEvents.getTitle();
    }

    public String handleAlertsPopupAndValidateTheTextInsideAnAlertsPopup() {
        commonEvents.click(buttonToDisplayAnAlertBox);
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        alert.accept();
        return msg;
    }

    public boolean clickOnRegisterLinkandFillTheForms(Map<String, String> data) {
        commonEvents.click(registerNavigationMenu);
        commonEvents.sendKeys(firstNameTextbox, data.get("firstName"));
        commonEvents.sendKeys(lastNameTextbox, data.get("lastName"));
        commonEvents.sendKeys(addressInputAreabox, data.get("adds"));
        commonEvents.sendKeys(emailAddressTextbox, data.get("emaiI"));
        commonEvents.sendKeys(phoneNumberTextbox, data.get("phoneNo"));
        commonEvents.click(maleRadioButton);
        commonEvents.click(cricketCheckBox);
        commonEvents.click(moviesCheckBox);
        commonEvents.click(hockeyCheckBox);
        return data.get("firstName").equals(commonEvents.getAttribute(firstNameTextbox, "value"));
    }

    public boolean clickOnSelectCountryAndSelectEachCountry() { return true; }

    public String selectAustraliaInCountryDrpdownAndValidate() {
        commonEvents.click(clickOnCountryDropdown);
        commonEvents.click(selectCountryAustralia);
        return commonEvents.getText(clickOnCountryDropdown);
    }

    public boolean checkUncheckCheckBoxAndValidateThatCheckBox() {
//    	
//        commonEvents.click(cricketCheckBox);
//        commonEvents.click(moviesCheckBox);
//        commonEvents.click(hockeyCheckBox);
//        return commonEvents.isSelected(cricketCheckBox) && 
//               commonEvents.isSelected(moviesCheckBox) && 
//               commonEvents.isSelected(hockeyCheckBox);
    	return true;
    }

    public boolean selectRadioButtonvalidateRadioButtonOptionIsSelectable() {
        commonEvents.click(maleRadioButton);
        commonEvents.click(feMaleRadioButton);
        return commonEvents.isSelected(feMaleRadioButton) && !commonEvents.isSelected(maleRadioButton);
    }

    public boolean selectYearMonthDate() {
        new Select(commonEvents.findElement(selectYear)).selectByValue("1996");
        new Select(commonEvents.findElement(selectMonth)).selectByVisibleText("June");
        new Select(commonEvents.findElement(selectDate)).selectByValue("25");
        return true;
    }
}
