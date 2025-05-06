package automation;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Antnele_libraries.LaunchingPage;
import AppUtils.Utils;

public class Apkdemo extends BaseTest {
	LaunchingPage open_app = new LaunchingPage();
	
	@Test
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
	
	@Parameters({"HierarchyTitle"})
	@Test
	public void hierarchy_tab (String Hierarchy_Title){
		String res = open_app.get_hierarchy_page_title();
		Assert.assertEquals(res, Hierarchy_Title, "Actual Title:"+res+"Expected Title:"+Hierarchy_Title);
	}
	
	@Test
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
	
	@Test
	public void checkMultipleRoleDisplayed() throws MalformedURLException, InterruptedException {
		//Utils.launch_app();
		LaunchingPage library = new LaunchingPage();
		boolean res = library.navigate_to_multiple_roles_page();
		if(res) {
			System.out.println("multiple role page is displaying corectly");
		}
		else {
			System.out.println("multiple roles page is not displaying correctly");
		}
	}
	
	@Test
	public void multipleRolePageSkip_click() throws InterruptedException {
		LaunchingPage skip = new LaunchingPage();
		boolean res = skip.skip_button();
		if(res) 
		{
			System.out.println("multiple roles page skip button is clickable properly");
		}
		else 
		{
			System.out.println("multiple roles page skip button is not clickable properly");
		}
		assertTrue(res);
	}
	
	

}
