package automation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Antnele_libraries.LaunchingPage;
import AppUtils.Utils;

public class LandingPageNotificationAndTimeTable extends BaseTest {
	
	LaunchingPage app_open = new LaunchingPage();
	
	@Test
	public void launchapp() throws InterruptedException {
		
		Thread.sleep(2000);
		boolean res = app_open.verifyAppOpen();
		assertTrue(res);
		driver.findElement(By.xpath("//android.widget.Button[@text=\"NEXT\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text=\"NEXT\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text=\"NEXT\"]")).click();
		//Thread.sleep(2000);
	}
	
//Checking notification and time table title
	
	@Parameters({"notificationpageTitle"})
	@Test(dependsOnMethods = "launchapp", alwaysRun = true)
	public void checkNotificationAndTimeTable_title(String notificationTitle) throws InterruptedException {
		String res = app_open.get_notification_and_timeTablePageTitle();
		Assert.assertEquals(notificationTitle , res, "Actual value="+res+ " expected value= "+notificationTitle);
		System.out.println("notification and time table title is showing correctly");
		Thread.sleep(3000);
	}
	
//check notification and time table sub title
	
	@Parameters({"notificationpageSubTitle"})
	@Test(dependsOnMethods = "checkNotificationAndTimeTable_title", alwaysRun = true)
	public void checkNotificationAndTimeTable_subtitle(String notification_SubTitle) {
		String res = app_open.getNotificationAndTimeTable_subtitle();
		Assert.assertEquals(notification_SubTitle, res, "expected value=" +notification_SubTitle+ "Actual value" +res);
		System.out.println("notification and time table page sub title is showing correctly");
	}

//Swipe left on alerts and time table page and check secured communication page
	
	@Test(dependsOnMethods = "checkNotificationAndTimeTable_subtitle", alwaysRun = true)
	public void swipeLeftToSecureCommunicationPage() {
		boolean res = app_open.swipeleftOn_notificationAndTimeTablePage();
		if(res) {
			System.out.println("After swipe left it is showing secured communication page correctly");
		}else {
			System.out.println("After swipe left it is not showing secured communication page");
		}
		assertTrue(res);
		driver.findElement(By.xpath("//android.widget.Button[@text=\"NEXT\"]")).click();
	}
	
//check notification and time table start button text
	
	@Test(dependsOnMethods = "swipeLeftToSecureCommunicationPage", alwaysRun = true)
	public void checkStartButtonText() {
		boolean res = app_open.getStartButtonText();
		if(res) {
			System.out.println("start button text is showing correctly");
		}else {
			System.out.println("start button text is not showing correctly");
		}
		assertTrue(res);
	}
	
	
	
//Check notification and time table button is clickable or not
	
	@Test(dependsOnMethods = "checkStartButtonText", alwaysRun = true)
	public void clickStartButton_AndSignUpPage() throws InterruptedException {
		//Thread.sleep(2000);
		boolean res = app_open.clickStartButtonAnd_CheckSignUpPage();
		if(res) {
			System.out.println("start button is clickable properly and navigate to sign up page");
		}else {
			System.out.println("start button is not clickable and it is not navigates to sign up page");
		}
		assertTrue(res);
	}
}
