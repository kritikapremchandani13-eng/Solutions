package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class socialService_Pages extends StartupPage {

	//	Locators for TC-1
	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By registeredPatientTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");	
	//	Locators for TC-2
	By socialServiceModule = By.xpath("//span[.='SocialService']");	
	//	Locators for TC-3
	By registerNewSSUPatientButton = By.xpath("//a[.=' Register New SSU Patient']");	
	By newSSUPatientRegistrationFormNameElement = By.xpath("//strong[contains(text(), 'New SSU Patient Registration')]");
	//	Locators for TC-4
	By registrationButtonOfNewSSUPatientRegistrationForms = By.xpath("//button[contains(text(), 'Register')]");
	By errorMeesageInLastNameTextFieldElement = By.xpath("//span[contains(text(), 'Last Name is required')]");
	//	Locators for TC-5
	By firstNameTextField = By.id("regPatFirstName");
	By middelNameTextField = By.id("MiddleName");
	By lastNameTextField = By.id("LastName");
	//	Locators for TC-6
	By registerButtonOfNewSSUPatientRegistrationForms = By.xpath(" //button[contains(text(), 'Register')]");
	By closeButtonOfNewSsuPatientRegistrationByElement = By.xpath("//button[.=' Close ']");
	//	Locators for TC-7
	By warningMessage = By.xpath("(//span[.='Membership Scheme(s) is Mandatory. '])[2]");
	//	Locators for TC-8
	By hasTG_certificateDropdown = By.id("hasTG_certificate");
	By targetGroupCertificateTypeTextbox = By.xpath("//input[@id='TG_CertificateType']");
	By certificateNoTextbox = By.xpath("//input[@id='TG_CertificateNo']");
	//	Locators for TC-9
	By addressTextField = By.id("address");

	public socialService_Pages(WebDriver driver) {
		super(driver);
	}

	// ✅ TC 1.1
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		Boolean textIsDisplayed = false;
		try {
			commonEvents.sendKeys(usernameTextbox, expectedData.get("username"));
			commonEvents.sendKeys(passwordTextbox, expectedData.get("password"));
			commonEvents.click(signInButton);
			textIsDisplayed = commonEvents.isDisplayed(registeredPatientTextElement);
		} catch (Exception e) {
			throw e;
		}
		return textIsDisplayed;
	}

	// ✅ TC 1.2
	public String verifyTitleOfThePage() throws Exception {
		return commonEvents.getTitle();
	}

	// ✅ TC 1.3
	public String verifyURLOfThePage() throws Exception {
		return commonEvents.getCurrentUrl();
	}

	// ✅ TC 2
	public Boolean verifySocialServiceModuleisPresentAndGoToSocialServiceTab() throws Exception {
		boolean isDisplayed = false;
		try {
			if (commonEvents.isDisplayed(socialServiceModule)) {
				commonEvents.click(socialServiceModule);
				Thread.sleep(1000);
				isDisplayed = true;
			}
		} catch (Exception e) {
			throw e;
		}
		return isDisplayed;
	}

	// ✅ TC 3  <-- fixed (robust click + wait + return text)
	public String verifyRegisterNewSSUPatientButtonisPresentAndValidateFormName() throws Exception {
		String newSSUPatientRegistrationFormName = "";
		try {
			if (commonEvents.isDisplayed(registerNewSSUPatientButton)) {
				// ensure visible then click
				commonEvents.jsScrollPageTillElementVisible(registerNewSSUPatientButton);
				commonEvents.click(registerNewSSUPatientButton);

				// wait for the form title to appear (short)
				commonEvents.waitForElementVisible(newSSUPatientRegistrationFormNameElement, 5);
				newSSUPatientRegistrationFormName = commonEvents.getText(newSSUPatientRegistrationFormNameElement);
			}
		} catch (Exception e) {
			throw e;
		}
		return newSSUPatientRegistrationFormName;
	}

	// ✅ TC 4
	public String validateErrorMessageInLastNameTextfield() throws Exception {
		String errorMessageText = "";
		try {
			if (commonEvents.isDisplayed(registrationButtonOfNewSSUPatientRegistrationForms)) {
				commonEvents.click(registrationButtonOfNewSSUPatientRegistrationForms);
				commonEvents.waitForElementVisible(errorMeesageInLastNameTextFieldElement, 5);
				errorMessageText = commonEvents.getText(errorMeesageInLastNameTextFieldElement);
			}
		} catch (Exception e) {
			throw e;
		}
		return errorMessageText;
	}

	// ✅ TC 5
	public String fillDataInTextfieldsAndVerifyEnteredData(Map<String, String> expectedData) throws Exception {
		String firstNameTextfieldValue = "";
		try {
			if (commonEvents.isDisplayed(firstNameTextField) &&
				commonEvents.isDisplayed(middelNameTextField) &&
				commonEvents.isDisplayed(lastNameTextField)) {

				commonEvents.sendKeys(firstNameTextField, expectedData.get("firstName"));
				commonEvents.sendKeys(middelNameTextField, expectedData.get("middleName"));
				commonEvents.sendKeys(lastNameTextField, expectedData.get("lastName"));

				firstNameTextfieldValue = commonEvents.getAttribute(firstNameTextField, "value");
			}
		} catch (Exception e) {
			throw e;
		}
		return firstNameTextfieldValue;
	}

	// ✅ TC 6
	public Boolean scrollToButtomOfThePageAndVerifyCloseButtonIsPresent() throws Exception {
		boolean closeButtoIsDisplayed = false;
		try {
			commonEvents.jsScrollPageTillElementVisible(registerButtonOfNewSSUPatientRegistrationForms);
			if (commonEvents.isDisplayed(closeButtonOfNewSsuPatientRegistrationByElement) &&
				commonEvents.isDisplayed(registerButtonOfNewSSUPatientRegistrationForms)) {

				commonEvents.highlightElementAfterAction(commonEvents.findElement(closeButtonOfNewSsuPatientRegistrationByElement));
				commonEvents.highlightElementAfterAction(commonEvents.findElement(registerButtonOfNewSSUPatientRegistrationForms));
				closeButtoIsDisplayed = true;
			}
		} catch (Exception e) {
			throw e;
		}
		return closeButtoIsDisplayed;
	}

	// ✅ TC 7  <-- fixed: trigger + wait + return
	public String validateWarnningMessageOfNewSSUPatientRegistrationForms(Map<String, String> expectedData) throws Exception {
		String warningMessageValue = "";
		try {
			// click register to ensure warning appears, then wait and read it
			if (commonEvents.isDisplayed(registrationButtonOfNewSSUPatientRegistrationForms)) {
				commonEvents.click(registrationButtonOfNewSSUPatientRegistrationForms);
				commonEvents.waitForElementVisible(warningMessage, 5);
				if (commonEvents.isDisplayed(warningMessage)) {
					warningMessageValue = commonEvents.getText(warningMessage);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return warningMessageValue;
	}

	// ✅ TC 8
	public String verifyTextboxIsPresentBySelectingYesFromHasTargetGroupCertificateDropdown(Map<String, String> expectedData) throws Exception {
		String HasTargetGroupCertificateDropdownValue = "";
		try {
			if (commonEvents.isDisplayed(hasTG_certificateDropdown)) {
				commonEvents.selectByVisibleText(hasTG_certificateDropdown, expectedData.get("HasTargetGroupCertificate?Yes"));
				HasTargetGroupCertificateDropdownValue = commonEvents.getFirstSelectedOptionFromDropdown(hasTG_certificateDropdown);
				commonEvents.sendKeys(targetGroupCertificateTypeTextbox, expectedData.get("targetGroupCertificateType"));
				commonEvents.sendKeys(certificateNoTextbox, expectedData.get("certificateNo"));
			}
		} catch (Exception e) {
			throw e;
		}
		return HasTargetGroupCertificateDropdownValue;
	}

	// ✅ TC 9  <-- fixed: wait + read placeholder (no unnecessary click)
	public String getPlaceHolderNameVerifyPlaceHolderNameOfAddress(Map<String, String> expectedData) throws Exception {
		String placeHolderValue = "";
		try {
			commonEvents.waitForElementVisible(addressTextField, 5);
			placeHolderValue = commonEvents.getAttribute(addressTextField, "placeholder");
		} catch (Exception e) {
			throw e;
		}
		return placeHolderValue;
	}
}
