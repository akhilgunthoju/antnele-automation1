package automation;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Antnele_libraries.LaunchingPage;
import AppUtils.SwipeUtils;
import AppUtils.Utils;

public class LandingPageTestsHierarchy extends BaseTest {
	
LaunchingPage open_app = new LaunchingPage();
	
	@Test(priority = 1)
	public void app_open() throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		//Utils app = new Utils();
		//app.launch_app("C:\\Users\\akhil\\OneDrive\\Desktop\\Android Apk files\\80-Mar-2024_Antnele_23.1.24_debug.apk");
		//Utils.launch_app("C:\\Users\\akhil\\OneDrive\\Desktop\\Android Apk files\\80-Mar-2024_Antnele_23.1.24_debug.apk");
		
		Thread.sleep(5000);
		
		//open_app.appopen_properly();
		
		boolean res = open_app.verifyAppOpen();
		
//		if(res) {
//			System.out.println("app opened successfully");
//		}
//		else {
//			System.out.println("app is not open properly");
//		}
		assertTrue(res);
		
		//Utils.closeapp();

	}
//Checking hierarchy page background image
	
	@Test(priority = 2)
	public void checkBackgroundImage() 
	{
		boolean res = open_app.get_hierarchyPageImage();
		if(res) {
			System.out.println("Hierarchy page background image is showing correctly");
		}
		else {
			System.out.println("Hierarchy page background image is not showing correctly");
		}
		assertTrue(res);
	}

//CHeck hierarchy page title
	
	@Parameters({"HierarchyTitle"})
	@Test(priority = 3)
	public void hierarchy_tab (String Hierarchy_Title){
		String res = open_app.get_hierarchy_page_title();
		Assert.assertEquals(res, Hierarchy_Title, "Actual Title:"+res+"Expected Title:"+Hierarchy_Title);
		System.out.println("Hierarchy title is showing correctly");
	}
	
//Check hierarchy page content
	@Parameters({"Hierarchy_content"})
	@Test(priority = 4)
	public void checkHiearchy_page_content(String hierarchyContent) 
	{
		boolean res = open_app.get_hierarchyPage_subtitle(hierarchyContent);
		if(res) {
			System.out.println("Hierarchy page content is showing correctly");
		}
		else {
			System.out.println("Hierarchy page content is not showing correctly");
		}
		
		assertTrue(res);
	}
	
	@Test(priority = 5)
	public void nextButton_clickableOrNot() throws InterruptedException {
		Thread.sleep(2000);
		boolean res = open_app.click_nextButtonAndCheck_multipleRolesPage();
		if(res) {
			System.out.println("Next button is clickable successfully and open multiple module page");
		}
		else {
			System.out.println("Next button is not clickable and it is not open multiple roles page");
		}
		
	}
	
	@Test(priority = 6)
	public void SwipeleftToHierarchyPage() {
		boolean res = open_app.swipeleftOn_multipleRolesPage();
		if(res) {
			System.out.println("After swipe left it is showing hierarchy page correctly");
		}else {
			System.out.println("after swipe left it is not showing hierarchy page");
		}
	}
	
	
	@Test(priority = 7)
	public void skip_button_click_test() throws InterruptedException {
		boolean res = open_app.skip_button();
		
		if(res) 
		{
			System.out.println("skip button is clickable properly and navigate to signup page");
		}
		else 
		{
			System.out.println("skip button is not clickable properly and it is not navigate to sign up page");
		}
		assertTrue(res);
	}

}
