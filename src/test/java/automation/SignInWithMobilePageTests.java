package automation;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom_files.SignIn_POM;

public class SignInWithMobilePageTests extends BaseTest {
	
	SignIn_POM app_opens;
	BaseTest baseTest = new BaseTest();
	
	@BeforeMethod
	public void goToAccountSetUpPage() throws MalformedURLException, InterruptedException {
		baseTest.launch_app();
		app_opens = new SignIn_POM();
		
		Assert.assertTrue(app_opens.navigateToSignInPageWithMobilePage(), "SignIn page not loaded.");
	}
	
	@Test
	public void verifyMobileFieldWithNoData() {
		app_opens.checkMobileFieldWithNoData();
		System.out.println("error message is displaying when mobile field empty");
	}
	
	@Test(dependsOnMethods = "verifyMobileFieldWithNoData", alwaysRun = true)
	public void mobileFieldWithInvalidNumber() {
		boolean invalidmobileNumber = app_opens.enterInvalidMobile();
		Assert.assertTrue(invalidmobileNumber, "error message is not displaying when enter invalid mobile");
		System.out.println("error message is displaying when enter invalid mobile");
	}
	
	@Test(dependsOnMethods = "mobileFieldWithInvalidNumber", alwaysRun = true)
	public void isConfirmationMessageDisplayed() {
		app_opens.enterMobileNumber("9449474884");
//		boolean confirmationMessageDisplayed = app_opens.checkConfirmationMessage();
//		Assert.assertTrue(confirmationMessageDisplayed, "confirmation message is not displaying");
//		System.out.println("confirmation message is displaying when enter valid mobile number");
		app_opens.checkConfirmationMessage();
		System.out.println("confirmation message is displaying");
	}
	
	@Parameters({"Enter_mobile_mumber"})
	@Test(dependsOnMethods = "isConfirmationMessageDisplayed", alwaysRun = true)
	public void verifyAccountSetupPageWhenEditButtonClicked(String mobileNumber) {
		app_opens.enterMobileNumber(mobileNumber);
		Assert.assertTrue(app_opens.clickPopUpEditButton(), "account setup page is not displaying when click pop up edit button");
		System.out.println("account setup page is displaying correctly when edit button is clicked on pop up");
	}
	
	@Test(dependsOnMethods = "verifyAccountSetupPageWhenEditButtonClicked", alwaysRun = true)
	public void verifyOTPScreen() {
		app_opens.enterMobileNumber("8373948849");
		Assert.assertTrue(app_opens.clickPOpUpOKButton(), "Otp page is not displaying when enter valid mobile number");
		System.out.println("otp page is displaying when enter valid mobile number and click pop up ok button");
	}
	
	@Test(dependsOnMethods = "verifyOTPScreen", alwaysRun = true)
	public void verifyOTPScreenWithNoData() {
		app_opens.enterMobileNumber("8373839398");
		Assert.assertTrue(app_opens.otpFieldWithNoData(), "error message is not displaying when otp field empty");
		System.out.println("error message is displaying when otp field empty");
	}
	
	@Parameters({"Enter_mobile_mumber"})
	@Test(dependsOnMethods = "verifyOTPScreenWithNoData", alwaysRun = true)
	public void verifyOTPScreenWithWrongOTP(String mobileNumber) {
		app_opens.enterMobileNumber(mobileNumber);
		Assert.assertTrue(app_opens.otpScreenWithWrongOTP(),"error message is not displaying when enter wrong otp");
		System.out.println("error message is displaying when enter wrong otp");
		
	}
	
	@Parameters({"Enter_mobile_mumber"})
	@Test(dependsOnMethods = "verifyOTPScreenWithWrongOTP", alwaysRun = true)
	//@Test
	public void isLoginSuccessWithValidCredentials(String mobileNumber) {
		app_opens.enterMobileNumber(mobileNumber);
		Assert.assertTrue(app_opens.enterOTPAndValidateChatPage(), "chat tab is not displayed when enter valid credentials");
		System.out.println("chat tab displayed when enter valid credentials");
	}
	
	@AfterMethod
	public void closeApp() throws InterruptedException {
//		if (driver != null) {
//          driver.quit();
//          System.out.println("Driver quit successfully.");
//      }
		driver.quit();
		System.out.println("driver quit successfully");
	}
	
	
	
//	@Test
//	public void checkSignUpPage() throws InterruptedException {
//		boolean res = app_opens.GoToSignInPage();
//		if(res) {
//			System.out.println("sign up page is showing correctly");
//		}else {
//			System.out.println("sign up page is not working properly");
//		}
//		assertTrue(res);
//	}
//	
//	@Parameters({"Enter_mobile_mumber", "Enter_otp"})
//	@Test(dependsOnMethods = "checkSignUpPage")
//	public void loginWithMobileNumberAndOTP(String mobileNumber, String OTP) throws InterruptedException {
//		boolean ismobileButtonClickable = app_opens.clickMobileAndCheck_mobileNumberPage();
//		assertTrue(ismobileButtonClickable);
//		//Thread.sleep(3000);
//		
//		app_opens.enterMobileNumber(mobileNumber);
//		Thread.sleep(3000);
//		
//		boolean isContinueButtonClickable = app_opens.clickContinueButton();
//		assertTrue(isContinueButtonClickable);
//		Thread.sleep(30000);
//		
//		app_opens.enterOTP(OTP);
//		
//		//app_opens.enterotp();
//		
//		app_opens.clickNextButtonOnOtpPage();
//		Thread.sleep(2000);
//		
//		boolean isloginsuccess = app_opens.isLoginSuccessful();
//		assertTrue(isloginsuccess, "login was not successfull");
//	}

}
