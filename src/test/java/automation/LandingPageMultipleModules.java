package automation;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Antnele_libraries.LaunchingPage;
import AppUtils.Utils;

public class LandingPageMultipleModules extends BaseTest {
	
	LaunchingPage open_app = new LaunchingPage();
	
	@Test(priority = 1)
	public void app_open() throws MalformedURLException, InterruptedException {
		
		Thread.sleep(5000);
		
		//open_app.appopen_properly();
		
		boolean res = open_app.verifyAppOpen();
		
		assertTrue(res);

	}
	
	@Test(priority = 2)
	public void click_next_button() {
		boolean res = open_app.click_nextButtonAndCheck_multipleRolesPage();
		if(res) {
			System.out.println("next button is clickable and go to multiple role page");
		}else {
			System.out.println("next button is not clickable and it is not go to multiple role page");
		}
		assertTrue(res);
	}
	
	@Test(priority = 3)
	public void CheckBackgroundImage() {
		boolean res = open_app.get_multipleRolesImage();
		if(res) {
			System.out.println("Multiple roles page background image is displayed correctly");
		}else {
			System.out.println("multiple rols page background image is not displaying correctly");
		}
		assertTrue(res);
	}
	
	@Parameters({"MultipleRolesPage_title"})
	@Test(priority = 4)
	public void checkMultipleRoleTitle(String MultipleRoles_title) {
		String res = open_app.get_multipleRoles_page_title();
		Assert.assertEquals(res, MultipleRoles_title, "Actual title=" +MultipleRoles_title+ "Expected title= "+res);
		System.out.println("Multiple roles page title is showing correctly");
	}
	
	@Parameters({"MultipleRolePage_subTitle"})
	@Test(priority = 5)
	public void CheckMultipleRolePage_Subtitle(String multiple_role_subtitle) {
		boolean res = open_app.get_multipleRolePage_subTitle(multiple_role_subtitle);
		if(res) {
			System.out.println("Multiple roles page sub title is showing correctly");
		}else {
			System.out.println("multiple roles page sub title is not showing correctly");
		}
		assertTrue(res);
	}
	
	@Test(priority = 6)
	public void clickNextButtonOn_MultipleRolePage() {
		boolean res = open_app.clickNextButtonAnd_checkSecuredCommunicationPage();
		if(res) {
			System.out.println("multiple roles page next button is clickable and navigate to secured communication page");
		}else {
			System.out.println("multiple roles page next button is not clickable");
		}
		assertTrue(res);
	}
	
	@Test(priority = 7)
	public void swipeLeftToMultiple_rope_page() {
		boolean res = open_app.swipeleftOn_securedCommunicationPage();
		if(res) {
			System.out.println("after swipe left on secure communication page, it is showing multipe roles page");
		}else {
			System.out.println("after swipe left on secure communication page, it is not showing multiple roles page");
		}
		assertTrue(res);
	}
	
	@Test(priority = 8)
	public void skipButtonTest() throws InterruptedException {
		boolean res = open_app.skip_button();
		if(res) {
			System.out.println("Skip button is clickable and it is showing sign up page");
		}else {
			System.out.println("skip button is not clickable and it is not showing sign up page");
		}
		assertTrue(res);
	}
	
}
	
