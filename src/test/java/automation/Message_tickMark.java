package automation;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom_files.Message_TickMark_POM;

public class Message_tickMark extends BaseTest{
	
	BaseTest basetest = new BaseTest();
	Message_TickMark_POM messagePage;

	@Parameters({"username", "password"})
	@BeforeTest
	public void goToChatScreen(String username, String password) throws MalformedURLException, InterruptedException {
		
		 // Ensuring driver is reinitialized for every test
	    if (driver != null) {
	        driver.quit();  // Quit if an old session exists
	    }
	    
		basetest.launch_app();
		//launch_app();
		messagePage = new Message_TickMark_POM();
		
		Assert.assertTrue(messagePage.navigateToChatScreen(username , password));
	}
	
	@Test
	public void verifySingleTickMark() throws InterruptedException {
		messagePage.clickChat();
		messagePage.sendMessage("Hello");
		Thread.sleep(3000);
		boolean isdisplayesTickMark = messagePage.isSingleTickDisplayed();
		//Assert.assertTrue(messagePage.isSingleTickDisplayed(), "❌ Single tick mark is not displaying when we send message");
		Assert.assertTrue(isdisplayesTickMark, "single tick is not displaying when we send message");
		System.out.println("✅ single tick mark is displaying when we send message");
	}
	
	@Test(dependsOnMethods = "verifySingleTickMark", alwaysRun = true)
	public void verifyDoubleTick() {
		Assert.assertTrue(messagePage.isDoubleTickDisplayed(), "❌ Double tick mark is not displaying when the user receive the message");
		System.out.println("✅ Double tick mark is displaying when the user receive the message");
	}
	
	@Test(dependsOnMethods = "verifyDoubleTick", alwaysRun = true)
	public void verifyDoubleTickWithOrange() {
		Assert.assertTrue(messagePage.isdoubleTickWithOrangeDisplayed(), "❌ Double tick with orange is not displaying when the user seen the message");
		System.out.println("✅ doubel tick with orange is displaying when the user seen the message");
	}
	
//	@AfterMethod
//	public void closeApp() throws InterruptedException {
////		if (driver != null) {
////            driver.quit();
////            Thread.sleep(1000);
////            System.out.println("✅ Driver quit successfully.");
////        } else {
////            System.out.println("⚠️ Driver was null, skipping quit.");
////        }
//		driver.quit();
//		System.out.println("driver quit successfully");
//	}
	
	//@AfterMethod
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
