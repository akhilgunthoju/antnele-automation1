package automation;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom_files.Account_Tab_POM;
import pom_files.SignIn_POM;

public class Account_Page_Testing extends BaseTest {

	BaseTest basetest = new BaseTest();
	Account_Tab_POM accountTab;
	
	@BeforeTest
	public void navigateToLoginPage() throws InterruptedException {
		SignIn_POM signIn =  new SignIn_POM();
		signIn.navigateToSignInWithoutMobilePage();
		signIn.enterUsernameAndPassword("bheemla.nayak", "Antnele@123");
	}
	
	@Test
	public void verifyAccountPage() {
		accountTab = new Account_Tab_POM(driver);
		
		Assert.assertTrue(accountTab.clickAccountTabAndCheck_accountPage(), "Account page is not displaying when click account tab");
		System.out.println("account page is displaying when click account tab");
	}
	
	@Test
	public void checkProfilePage_WhenClick_profileTab() {
		Assert.assertTrue(accountTab.clickprofileTab_And_CheckProfilePage(), "profile page is not displaying when click profile tab");
		System.out.println("profile page is displaying when we click profile tab");
	}
	
	@Test
	public void isUpdateDp() {
		accountTab.isupdateProfilePicture();
	}
	
	
	@AfterTest
	public void closeApp() throws InterruptedException {
		if (driver != null) {
	        System.out.println("✅ Quitting driver...");
	        driver.quit();
	        driver = null;  // Ensure it's reset for next test
	    } else {
	        System.out.println("⚠️ Driver was already null, skipping quit.");
	    }
	}
	
}
