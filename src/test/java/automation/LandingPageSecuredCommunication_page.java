package automation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Antnele_libraries.LaunchingPage;
import AppUtils.Utils;

public class LandingPageSecuredCommunication_page extends BaseTest{
	
	LaunchingPage open_app = new LaunchingPage();

//Launching Antnele app
	@Test
	public void launchApp() throws InterruptedException {
		
		Thread.sleep(3000);
		boolean res = open_app.verifyAppOpen();
		assertTrue(res);
		
	}
	
//Go to secured communication page
	@Test(dependsOnMethods = "launchApp")
	public void goToSecuredCommunication_page() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.antnele:id/btn_next\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.antnele:id/btn_next\"]")).click();
		Thread.sleep(2000);
	}
	
	
//Check secured page sub title
	@Parameters({"securedPageTitle"})
	@Test(dependsOnMethods = "goToSecuredCommunication_page")
	public void checkSecuredCommunication_title(String writeSecuredPageTitle) {
		String res = open_app.get_securedCommunication_page_title();
		Assert.assertEquals(writeSecuredPageTitle, res, "Actual title=" + res + "Expected title=" +writeSecuredPageTitle);
		System.out.println("secured communication page title is showing correctly");
	}
	
//checking secured communication page subtitle
	
	@Parameters({"sucuredPageSubtitle"})
	@Test(dependsOnMethods = "checkSecuredCommunication_title")
	public void checkSecuredPageSubtitle(String writeSecuredPageSubTitle) throws InterruptedException {
		String res = open_app.getSecuredCommunication_subtitle();
		Assert.assertEquals(writeSecuredPageSubTitle, res, "Actual sub title=" +res+ "expected sub title=" +writeSecuredPageSubTitle);
		System.out.println("secured communication page sub title is showing correctly");
		Thread.sleep(2000);
	}
	
//Clicking next button on secured communication page
	@Test(dependsOnMethods = "checkSecuredPageSubtitle")
	public void clickNextButtonOn_securedCommunication() throws InterruptedException {
		boolean res = open_app.clickNextButtonAnd_checkNotificationAndTimeTablePage();
		if(res) {
			System.out.println("next button is clickable and go to notification and time table page");
		}else {
			System.out.println("next button is not clickable and it is not go to notification and time table page");
		}
		assertTrue(res);
		Thread.sleep(2000);
	}
	
//swipe left on notification and time table and checking secured communication page
	
	@Test(dependsOnMethods = "clickNextButtonOn_securedCommunication")
	public void swipeleftAndCheckSecuredCommunicationPage() throws InterruptedException {
		boolean res = open_app.swipeleftOn_notificationAndTimeTablePage();
		if(res) {
			System.out.println("After swipe left on notification and time table page it is showing secured communication page");
		}else {
			System.out.println("after swipe left on notification and time table page, it is not showing secured communication page");
		}
		assertTrue(res);
		Thread.sleep(2000);
	}
	
//Click skip button on secured communication page
	@Test(dependsOnMethods = "swipeleftAndCheckSecuredCommunicationPage")
	public void checkSkipButton_onSecuredCommunication() throws InterruptedException {
		boolean res = open_app.skip_button();
		if(res) {
			System.out.println("skip button is clickable and it goes to sign up page");
		}else {
			System.out.println("skip button is not clickable and it is not navigate to sign up page");
		}
		assertTrue(res);
	}

}
