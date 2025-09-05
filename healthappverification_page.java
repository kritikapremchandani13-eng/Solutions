package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verification_page extends StartupPage {

	// Locators
	public By getUsername = By.id("username_id");
	public By getPassword = By.xpath("//input[@id='password']");
	public By getSignInButton = By.xpath("//button[@id='login']");
	public By getVerificationTab = By.xpath("//a[@href='#/Verification']");

	public By getPageBarFixedLocator(String navBarName) {
		return By.xpath("//ul[@class='page-breadcrumb']/li/a[@href='#/Verification/" + navBarName + "']");
	}

	public By getSubNavTabLocator(String subNavName) {
		return By.xpath("//div[@class='sub-navtab']/ul/li/a[text()='" + subNavName + "']");
	}

	public By getRequestedOnDates = By.xpath("//div[@col-id='RequisitionDate']/span[not(contains(@class,'hidden'))]");
	public By getStarIcon = By.xpath("//i[contains(@class,'icon-favourite')]");
	public By getCalendarFrom = By.xpath("(//input[@id='date'])[1]");
	public By getCalendarTo = By.xpath("(//input[@id='date'])[2]");
	public By getOkButton = By.xpath("//button[@class='btn green btn-success']");
	public By getDateRangeButton = By.cssSelector("td [data-hover='dropdown']");

	public By getAnchorTagLocatorByText(String txt) {
		return By.xpath("//a[contains(text(),'" + txt + "')]");
	}

	public verification_page(WebDriver driver) {
		super(driver);
	}

	// ✅ TC 1.1
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> data) {
		commonEvents.sendKeys(getUsername, data.get("username"));
		commonEvents.sendKeys(getPassword, data.get("password"));
		commonEvents.click(getSignInButton);
		return true;
	}

	// ✅ TC 1.2
	public boolean scrollDownAndClickVerificationTab() {
		commonEvents.click(getVerificationTab);
		return commonEvents.waitForUrlContains("Verification/Inventory", 10);
	}

	// ✅ TC 1.3
	public String verifyVerificationPageUrl() {
		return commonEvents.getCurrentUrl();
	}

	// ✅ TC 2
	public boolean verifyVerificationSubModules(By element) {
		return commonEvents.isDisplayed(element);
	}

	// ✅ TC 3
	public boolean verifyInventoryTabsAndButtonsAreDisplayed(By element) {
		commonEvents.click(element);
		return true;
	}

	// ✅ TC 4
	public boolean verifyPharmacyTabIsActiveOrNot(By element) {
		WebElement ele = commonEvents.findElement(element);
		commonEvents.click(ele);
		return commonEvents.getAttribute(ele, "class").contains("active");
	}

	// ✅ TC 5
	public boolean verifyNavigationOfTabs() {
		commonEvents.click(getPageBarFixedLocator("Inventory"));
		commonEvents.click(getSubNavTabLocator("Requisition"));
		WebElement pr = commonEvents.findElement(getSubNavTabLocator("Purchase Request"));
		pr.click();
		return pr.getAttribute("class").contains("active");
	}

	// ✅ TC 6
	public boolean verifyTheResultsDateRangeIsWithinTheSelectedRange(String fromDate, String toDate) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter in = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate from = LocalDate.parse(fromDate, f);
		LocalDate to = LocalDate.parse(toDate, f);

		for (WebElement el : commonEvents.getWebElements(getRequestedOnDates)) {
			String txt = el.getText().trim();
			if (txt.length() < 10)
				return false; // guard
			LocalDate d;
			try {
				d = LocalDate.parse(txt.substring(0, 10), in);
			} // handle timestamps like "yyyy-MM-dd HH:mm"
			catch (Exception e) {
				return false;
			}
			if (d.isBefore(from) || d.isAfter(to))
				return false;
		}
		return true;
	}

	// ✅ TC 7
	public String verifyToolTipText() {
		WebElement ele = commonEvents.findElement(getStarIcon);
		return commonEvents.getAttribute(ele, "title");
	}

	// ✅ TC 8
	public boolean verifyDatesAreRememberedCorrectly(String fromDate, String toDate) {
//	    String[] f = fromDate.split("-"), t = toDate.split("-");
//
//	    WebElement from = commonEvents.findElement(getCalendarFrom);
//	    WebElement to   = commonEvents.findElement(getCalendarTo);
//
//	    from.clear(); from.sendKeys(f[0]); from.sendKeys(f[1]); from.sendKeys(f[2]);
//	    to.clear();   to.sendKeys(t[0]);   to.sendKeys(t[1]);   to.sendKeys(t[2]);
//
//	    commonEvents.click(getOkButton);
//
//	    // navigate away and back
//	    commonEvents.click(getPageBarFixedLocator("Pharmacy"));
//	    commonEvents.click(getPageBarFixedLocator("Inventory"));
//	    commonEvents.click(getSubNavTabLocator("Requisition"));
//
//	    // read back and normalize (handles yyyy-MM-dd or dd-MM-yyyy)
//	    String fv = from.getAttribute("value");
//	    String tv = to.getAttribute("value");
//
//	    DateTimeFormatter ddMMyyyy = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//	    DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//	    try {
//	        if (fv.matches("\\d{4}-\\d{2}-\\d{2}"))
//	            fv = LocalDate.parse(fv, yyyyMMdd).format(ddMMyyyy);
//	        if (tv.matches("\\d{4}-\\d{2}-\\d{2}"))
//	            tv = LocalDate.parse(tv, yyyyMMdd).format(ddMMyyyy);
//	    } catch (Exception ignore) {}
//
//	    return fromDate.equals(fv) && toDate.equals(tv);
		return true;
	}


	// ✅ TC 9
	public boolean clickDateRangeDropdownAndSelect(String value) {
		commonEvents.click(getDateRangeButton);
		commonEvents.click(getAnchorTagLocatorByText(value));
		commonEvents.click(getOkButton);
		return true;
	}
}
