package automation;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import Antnele_libraries.LaunchingPage;
import AppUtils.Utils;


public class Multiple_modules extends BaseTest
{
	
	@Test
	public void check_moltiple_role() throws MalformedURLException, InterruptedException {
		//Utils.launch_app();
		LaunchingPage library = new LaunchingPage();
		boolean res = library.navigate_to_multiple_roles_page();
		if(res) {
			System.out.println("multiple roles is pass");
		}
		else {
			System.out.println("multiple roles is fail");
		}
	}
	
	@Test
	public void skip_test() throws InterruptedException {
		LaunchingPage skip = new LaunchingPage();
		boolean res = skip.skip_button();
		if(res) 
		{
			System.out.println("multiple page skip button is working properly");
		}
		else 
		{
			System.out.println("multiple page skip button is not working properly");
		}
		assertTrue(res);
	}

}
