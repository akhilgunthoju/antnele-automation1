package pom_files;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Scanner;

import javax.security.auth.login.AccountNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import automation.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignIn_POM extends BaseTest{
	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Skip\"]")
	private WebElement skipButtonElement;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Sign Up\"]")
	private WebElement signUpPageElement;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Without Mobile\"]")
	private WebElement withoutMobileButtonElement;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Sign In\"]")
	private WebElement signInPageHeaderElement;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Mobile\"]")
	private WebElement withMobileButtonElemnt;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Account Setup\"]")
	private WebElement accountSetUpPage;
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.antnele:id/edtPhoneNumber\"]")
	private WebElement mobileNumberField;
	
	@FindBy(xpath="//android.widget.Button[@text=\"AGREE\"]")
	private WebElement agreeButton;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement clickOkButtonforAllPOPUpWindows;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Error\"]")
	private WebElement errorMessageForAll;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button2\"]")
	private WebElement popUpEditButton;
	
	@FindBy(xpath="//android.widget.Button[@text=\"OK\"]")
	private WebElement popUpOKButton;
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.antnele:id/otp_view\"]")
	private WebElement otpScreen;
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.antnele:id/otp_view\"]")
	private WebElement otpField;
	
	@FindBy(xpath="//android.widget.Button[@text=\"NEXT\"]")
	private WebElement otpPageNextButton;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Confirmation\"]")
	private WebElement confirmationMessageElement;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Chat\"]")
	private WebElement chatTab;
	
	@FindBy(xpath="//android.widget.Button[@text=\"Allow\"]")
	private WebElement allowpermission;
	
	@FindBy(xpath="//android.widget.EditText[@text=\"Username\"]")
	private WebElement userNameField;
	
	@FindBy(xpath="//android.widget.EditText[@text=\"Password\"]")
	private WebElement passwordField;
	
	@FindBy(xpath="//android.widget.Button[@text=\"SIGN IN\"]")
	private WebElement signInButton;
	
	
	public SignIn_POM() {
		PageFactory.initElements(driver, this);
    }
	
	public void navigateToSignInWithoutMobilePage() throws InterruptedException {
//		By spinnerLocator = By.xpath("//android.widget.ProgressBar");
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerLocator));
		
		if (!driver.findElements(By.xpath("//android.widget.ProgressBar")).isEmpty()) {
		    System.out.println("Spinner detected, waiting...");
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.ProgressBar")));
		}

		wait.until(ExpectedConditions.elementToBeClickable(skipButtonElement));
		skipButtonElement.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(signUpPageElement));
		withoutMobileButtonElement.click();
		wait.until(ExpectedConditions.visibilityOf(signInPageHeaderElement));
		//Thread.sleep(1000);
	}
	
	public boolean navigateToSignInPageWithMobilePage() {
		skipButtonElement.click();
		wait.until(ExpectedConditions.elementToBeClickable(withMobileButtonElemnt));
		
		withMobileButtonElemnt.click();
		wait.until(ExpectedConditions.visibilityOf(accountSetUpPage));
		
		return accountSetUpPage.isDisplayed();
	}
	
	
	public void checkMobileFieldWithNoData() {
		mobileNumberField.clear();
		agreeButton.click();
		
		String actualErrorMessage = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]")).getText();
		String expectedErrorMessage = "Please enter your mobile number";
		
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "error message is not displaying as expected");
		wait.until(ExpectedConditions.visibilityOf(clickOkButtonforAllPOPUpWindows));
		clickOkButtonforAllPOPUpWindows.click();
	}
	
	public void enterMobileNumber(String mobileNumber) {
		mobileNumberField.sendKeys(mobileNumber);
		wait.until(ExpectedConditions.elementToBeClickable(agreeButton));
		agreeButton.click();
	}
	
	public boolean enterInvalidMobile() {
		enterMobileNumber("3448558558");
		//popUpOKButton.click();
		wait.until(ExpectedConditions.visibilityOf(errorMessageForAll));
		return errorMessageForAll.isDisplayed();
	}
	
	public void checkConfirmationMessage() {
		//Assert.assertFalse(errorMessageForAll.isDisplayed(), "Confirmation message is not displaying");
		Assert.assertTrue(confirmationMessageElement.isDisplayed());
//		wait.until(ExpectedConditions.visibilityOf(confirmationMessageElement));
//		return confirmationMessageElement.isDisplayed();
	}
	
	public boolean clickPopUpEditButton() {
		popUpEditButton.click();
		wait.until(ExpectedConditions.visibilityOf(accountSetUpPage));
		return accountSetUpPage.isDisplayed();
	}
	
	public boolean clickPOpUpOKButton() {
//		agreeButton.click();
		popUpOKButton.click();
		wait.until(ExpectedConditions.visibilityOf(otpScreen));
		return otpScreen.isDisplayed();
	}
	
	public boolean otpFieldWithNoData() {
		popUpOKButton.click();
		otpPageNextButton.click();
		wait.until(ExpectedConditions.visibilityOf(errorMessageForAll));
		return errorMessageForAll.isDisplayed();
	}
	
	public boolean otpScreenWithWrongOTP() {
		popUpOKButton.click();
		otpField.sendKeys("123456");
		otpPageNextButton.click();
		wait.until(ExpectedConditions.visibilityOf(errorMessageForAll));
		return errorMessageForAll.isDisplayed();
	}
	
	public boolean enterOTPAndValidateChatPage() {
		popUpOKButton.click();
		System.out.println("Enter OTP manually in the app and press ENTER to continue...");
        Scanner scanner = new Scanner(System.in);
        String OTP1 = scanner.nextLine();
		otpField.sendKeys(OTP1);
		otpPageNextButton.click();
		assertFalse(errorMessageForAll.isDisplayed(), "entered otp is correct");
		System.out.println("enter otp is not correct");
		wait.until(ExpectedConditions.elementToBeClickable(allowpermission));
		allowpermission.click();
		wait.until(ExpectedConditions.visibilityOf(chatTab));
		return chatTab.isDisplayed();
	}
	
	public boolean waitForElementToDisappear(By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
	    try {
	        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public boolean enterUsernameAndPassword(String username, String password) {
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		signInButton.click();
		allowpermission.click();
//		if(driver.findElement(By.xpath("//android.widget.ProgressBar[@resource-id=\"com.antnele:id/progress\"]")).isDisplayed()) {
//			System.out.println("Buffering detected. Waiting for upload to complete...");
//			
//			boolean beffercleared = waitForElementToDisappear(By.xpath("//android.widget.ProgressBar[@resource-id=\"com.antnele:id/progress\"]"), 20);
//			if(beffercleared) {
//				allowpermission.click();
//				Assert.assertTrue(chatTab.isDisplayed(), "login was not successfull with valid credentials");
//				System.out.println("login was successfull");
//			}
//			else {
//				System.out.println("Beffering for login");
//				return false;
//			}
//		}
//		else {
//			wait.until(ExpectedConditions.elementToBeClickable(allowpermission));
//			allowpermission.click();
//			Assert.assertTrue(chatTab.isDisplayed(), "login was not successfull with valid credentials");
//			System.out.println("login was successfull");
//		}
		Assert.assertTrue(chatTab.isDisplayed(), "login was not successfull with valid credentials");
		System.out.println("login was successfull");
		return false;
	}
	
	
}
