package automation;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Antnele_libraries.LaunchingPage;
import AppUtils.Utils;
import pom_files.SignIn_POM;

public class SignInWithoutMobile extends BaseTest {
	
	 SignIn_POM app_opens;
	 BaseTest baseTest = new BaseTest();
	
	@BeforeClass
	public void goToAccountSetUpPage() throws MalformedURLException, InterruptedException {
		baseTest.launch_app();
		app_opens = new SignIn_POM();
		
		Assert.assertTrue(app_opens.navigateToSignInPageWithMobilePage(), "SignIn page not loaded.");
	}
	 
//	 @Test
//	public void checkSignInwithoutMobile() throws InterruptedException {
//		
//		try {
//		boolean res = app_opens.GoToSignInPage();
////		if(res) {
////			System.out.println("Signin is page is showing correctly after click skip button");
////		}
////		else {
////			System.out.println("sign in page is not showing after click skip button");
////		}
//		assertTrue(res, "sign in page is not showing after click skip button");
//		System.out.println("sign in page is showing correctly after click skip button");
//		
//		boolean res1 = app_opens.clickWithoutMobileAnd_CheckMobileNumberPage();
////		if(res) {
////			System.out.println("without mobile button is clickable");
////		}
////		else {
////			System.out.println("without mobile button is not clickable");
////		}
//		assertTrue(res1, "without mobile button is not clickable");
//		System.out.println("without mobile button is clickable");
//		} 
//		
//		catch (Exception e) {
//            System.out.println("Error encountered: " + e.getMessage());
//            throw e; // Re-throw exception to fail the test
//        }
//		
//		Thread.sleep(3000);		
//	}
	
	public void verifyMobileFieldWithNoData() {
		app_opens.checkMobileFieldWithNoData();
		System.out.println("error message is displaying when name field empty");
	}
	
	//public void verify
	
	@Parameters({"username", "password"})
	@Test(dependsOnMethods = "checkSignInwithoutMobile", alwaysRun = true)
	public void isLoginSuccess( String Username, String Password) throws InterruptedException  {
		app_opens.enterUsernameAndPassword(Username, Password);
		System.out.println("attempting login username: " +Username);
		System.out.println("attempting password: " + Password);
		
		app_opens.isSignInButtonClickable();
		
		boolean Islogin = app_opens.IsloginSuccess();
		System.out.println("login success results:" +Islogin);
		assertTrue(Islogin, "Login was not successfull");
		
	}

}
