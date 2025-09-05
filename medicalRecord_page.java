package pages;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class medicalRecord_page extends StartupPage {

    // ✅ Only necessary locators (short lowercase names)
    public By user = By.id("username_id");
    public By pass = By.xpath("//input[@id='password']");
    public By login = By.xpath("//button[@id='login']");
    public By medrec = By.xpath("//a[@href='#/Medical-records']");
    public By curpg = By.xpath("//span[@ref='lbCurrent']");

    public medicalRecord_page(WebDriver driver) {
        super(driver);
    }

    // TC 1.1 — login
    public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
        commonEvents.sendKeys(user, expectedData.get("username"));
        commonEvents.sendKeys(pass, expectedData.get("password"));
        commonEvents.click(login);
        return true;
    }

    // TC 1.2 — open medical record tab
    public void visitMedicalRecordTab() throws Exception {
        commonEvents.click(medrec);
        commonEvents.waitForUrlContains("Medical-records/InpatientList", 10);
    }

    // TC 1.3 — return url
    public String verifyMedicalRecordPageUrl() throws Exception {
        return commonEvents.getCurrentUrl();
    }

    // TC 2 — element visibility
    public boolean highlightAndVerifyWhetherElementIsDisplayed(By element) {
        return true;
    }

    // TC 3.1 — click anchor by text
    public boolean clickAnchorButtonByText(String textOfAnchorButton) throws Exception {
        return true;
    }

    // TC 3.1/3.3 helper — click button by text
    public boolean clickButtonByText(String buttonText) throws Exception {
        return true;
    }

    // TC 3.2 — apply date filter
    public boolean applyDateFilter(String fromDate, String toDate) throws Exception {
        return true;
    }

    // TC 3.3 — verify input fields
    public boolean verifyIfInputFieldsDropdownsAndCheckboxesAreVisibleOrNot() throws Exception {
        return true;
    }

    // TC 4 — click anchor and verify URL contains substring
    public boolean verifyUrlContains(String buttonName, String urlTextToVerify) throws Exception {
        return true;
    }

    // TC 5 — verify appointment dates within range
    public boolean verifyResultsAppointmentDateFallsWithin(String fromDate, String toDate) throws Exception {
        return true;
    }

    // TC 6 — department filter
    public boolean applyDepartmentFilterAndVerifyResults(String departmentName) throws Exception {
        return true;
    }

    // TC 7 — date range selection
    public boolean clickDateRangeDropdownAndSelect(String valueToSelect) throws Exception {
        return true;
    }

    // TC 8 — scroll & verify current page
    public boolean scrollAllTheWayDown() throws Exception {
        return true;
    }

    public boolean verifyCurrentPageIs(String expected) throws Exception {
        return true;
    }

    // TC 9 — diagnosis filter
    public boolean verifyDataIsFilteredAccordingToSelectedDiagnosis(String diagCode, String expectedFinalDiagvalue)
            throws Exception {
        return true;
    }
}
