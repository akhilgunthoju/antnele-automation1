package automation;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	public static AppiumDriver<MobileElement> driver;
	private Properties config;

	//@BeforeTest
	@BeforeSuite
	public void launch_app() throws MalformedURLException, InterruptedException {
		config = ConfigReader.loadProperties("src/test/resources/config.properties");
		// TODO Auto-generated method stub
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, config.getProperty("platformName"));
		//caps.setCapability("platformName", "Android");

		caps.setCapability(MobileCapabilityType.DEVICE_NAME, config.getProperty("deviceName"));
		
		caps.setCapability(MobileCapabilityType.APP, config.getProperty("appPath"));
		
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, config.getProperty("automationName"));
		caps.setCapability("newCommandTimeout", 500); // Set to 5 minutes
		//caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getProperty("platformVersion"));
		//caps.setCapability(MobileCapabilityType.APPLICATION_NAME, "Calculator");
		//caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
		//caps.setCapability("newCommandTimeout", 300);
		URL url = URI.create(config.getProperty("appiumServer")).toURL();
		/*AndroidDriver*/ 
		driver = new AndroidDriver<MobileElement>(url, caps);
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
		Thread.sleep(7000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Application started");
		
	}
	
//	@AfterTest
//    public void close_app() {
//        if (driver != null) {
//            driver.quit();
//            System.out.println("Driver quit successfully.");
//        }
//    }
	
//	@AfterTest
//	public static void closeapp() {
//		//driver.quit();
//		if (driver != null) {
//            driver.quit();
//            System.out.println("Driver quit successfully.");
//        }
////		if (driver == null) {
////		    throw new IllegalStateException("Driver has not been initialized.");
////		}
//
//	}
}
