package Antnele_libraries;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import automation.BaseTest;
import automation.SwipeUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LaunchingPage extends BaseTest{
	
	//private static String enter_username;
	static String enter_username;
	static String enter_name;
	static String enter_surname;
	//static WebDriverWait wait = new WebDriverWait(driver, 10);
	

	public boolean verifyAppOpen() {
		// TODO Auto-generated method stub
		//check hierarchy page
		if(driver.findElement(By.id("com.antnele:id/txtTitle")).isDisplayed()) {
			return true;
		}else {
			return false;
		}

	}
//Hierarchy page image checking
	public boolean get_hierarchyPageImage() 
	{
		WebElement img = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"com.antnele:id/imgLogo\"]"));
		try {
			if(img.isDisplayed()) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("excepton error occured + " + e);
		}
		return false;
	}
	
//Check multiple module page background image
	public boolean get_multipleRolesImage() {
		WebElement img = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"com.antnele:id/imgLogo\"]"));
		try {
			if(img.isDisplayed()) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception error occured=" + e);
		}return false;
	}
	
//Hierarchy page title checking
	public String get_hierarchy_page_title()
	{
		String hierarchy_page_title = driver.findElement(By.id("com.antnele:id/txtTitle")).getText();
		
		return hierarchy_page_title;
	}
	
//Get multiple roles page title
	public String get_multipleRoles_page_title(){
		String multipleroles_page_title = driver.findElement(By.xpath("//android.widget.TextView[@text=\"MULTIPLE ROLES\"]")).getText();
		
		return multipleroles_page_title;
		
//		if(multipleroles_page_title.equals("MULTIPLE ROLES")) {
//			return true;
//		}else {
//			return false;
//		}
	}
	
//Get secured communications page title
	public String get_securedCommunication_page_title() {
		String securedCommunication_title = driver.findElement(By.xpath("//android.widget.TextView[@text=\"SECURED COMMUNICATION\"]")).getText();
		
		return securedCommunication_title;
	}
	
//Get notification and time table
	public String get_notification_and_timeTablePageTitle() {
		String notification_and_timetableTitle = driver.findElement(By.xpath("//android.widget.TextView[@text=\"ALERTS & TIME TABLE\"]")).getText();
		
		return notification_and_timetableTitle;
	}
	
	
//Getting hiearchy page subtitle
	
	public boolean get_hierarchyPage_subtitle(String write_Hierarchy_content) 
	{
		String Hierarchy_content = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/txtSubTitle\"]")).getText();
		if(Hierarchy_content.equals(write_Hierarchy_content)) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
//getting Multiple roles page content
	public boolean get_multipleRolePage_subTitle(String write_Multiplerole_content) {
		String multipleRole_content = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/txtSubTitle\"]")).getText();
		if(multipleRole_content.equals(write_Multiplerole_content)) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
//getting communication page subtitle
	public String getSecuredCommunication_subtitle() {
		String secured_communications_subTitle = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/txtSubTitle\"]")).getText();
		return secured_communications_subTitle;
	}
	
//Getting notification and time table title
	public String getNotificationAndTimeTable_subtitle() {
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/txtTitle\"]")).click();
		String notificationAndTimeTable_subtitle = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/txtSubTitle\"]")).getText();
		
		return notificationAndTimeTable_subtitle;
	}
	

//click next button and check multiple roles page
	public boolean click_nextButtonAndCheck_multipleRolesPage() {
		driver.findElement(By.xpath("//android.widget.Button[@text=\"NEXT\"]")).click();
		boolean multiple_role_page = driver.findElement(By.xpath("//android.widget.TextView[@text=\"MULTIPLE ROLES\"]")).isDisplayed();
		if(multiple_role_page) {
			return true;
		}else {
			return false;
		}
	}
	
//Click next button and check secured communications page
	public boolean clickNextButtonAnd_checkSecuredCommunicationPage() {
		driver.findElement(By.xpath("//android.widget.Button[@text=\"NEXT\"]")).click();
		boolean securedCommunicationPage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"SECURED COMMUNICATION\"]")).isDisplayed();
		try {
			if(securedCommunicationPage) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	
//Getting click functionality on secured communication page for check notification and time table page
	public boolean clickNextButtonAnd_checkNotificationAndTimeTablePage() {
		driver.findElement(By.xpath("//android.widget.Button[@text=\"NEXT\"]")).click();
		
		boolean notificationTimeTablePage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"ALERTS & TIME TABLE\"]")).isDisplayed();
		
		try {
			if(notificationTimeTablePage) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
//check start button text
	
	public boolean getStartButtonText() {
		String startText = driver.findElement(By.xpath("//android.widget.Button[@text=\"START\"]")).getText();
		if(startText.equals("START")) {
			return true;
		}else {
			return false;
		}
	}
	
//click start button and check it is notigating to sign up page
	public boolean clickStartButtonAnd_CheckSignUpPage() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.Button[@text=\"START\"]")).click();
		Thread.sleep(2000);
		boolean signupPage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Sign Up\"]")).isDisplayed();
		try {
			if(signupPage) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		//Thread.sleep(2000);
		return false;
	}

//swipe left on multiple roles page
	
	public boolean swipeleftOn_multipleRolesPage() {
		
		//SwipeUtils swipe = new SwipeUtils();
		//swipe.swipeleft(driver, 1000);
		
		SwipeUtils.swipeleft(driver, 1000);
	
		try {
			if(driver.findElement(By.xpath("//android.widget.TextView[@text=\"HIERARCHY NETWORK\"]")).isDisplayed()) {
				return true;
		}
		} catch (Exception e) {
		// TODO: handle exception
			return false;
		}
		return false;
	
	}
	
//Swipe left on secured communication page
	public boolean swipeleftOn_securedCommunicationPage() {
		SwipeUtils.swipeleft(driver, 1000);
		try {
			if(driver.findElement(By.xpath("//android.widget.TextView[@text=\"MULTIPLE ROLES\"]")).isDisplayed()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}return false;
	}
	
//swipe left on notification and time table page
	
	public boolean swipeleftOn_notificationAndTimeTablePage() {
		
		SwipeUtils.swipeleft(driver, 1000);
		
		try {
			if(driver.findElement(By.xpath("//android.widget.TextView[@text=\"SECURED COMMUNICATION\"]")).isDisplayed()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

//click skip button and check it is navigate to sign up page or not
	public boolean skip_button() throws InterruptedException {
		
		driver.findElement(By.id("com.antnele:id/btn_skip")).click();
		Thread.sleep(4000);
		try {
			if(driver.findElement(By.id("com.antnele:id/headerLayout")).isDisplayed()) {
				return true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
			
		}
		driver.close();
		return false;
		
		
	}
	
	public boolean navigate_to_multiple_roles_page() throws MalformedURLException, InterruptedException {
		driver.findElement(By.id("com.antnele:id/btn_next")).click();
		WebElement multipleModules = driver.findElement(By.xpath("//android.widget.TextView[@text=\"MULTIPLE ROLES\"]"));
		
		try {
			if(multipleModules.isDisplayed()) {
				return true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return false;
	}
	
	public String navigateToSecuredCommunication_Page() {
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.antnele:id/btn_next\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.antnele:id/btn_next\"]")).click();
		
		String Secure_communication_title = driver.findElement(By.xpath("//android.widget.TextView[@text=\"SECURED COMMUNICATION\"]")).getText();
		
		return Secure_communication_title;
	}
	
//Go to sign up page
	
	public boolean GoToSignInPage() throws InterruptedException {
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/btn_skip\"]")).click();
		Thread.sleep(2000);
		try {
			if(driver.findElement(By.xpath("//android.widget.TextView[@text=\"Sign Up\"]")).isDisplayed()) {
				return true;
			}
			else {
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.fail("Sign in fail");
		}
		return false;
		
	}
//Click mobile button and mobile account setup page
	public boolean clickMobileAndCheck_mobileNumberPage() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Mobile\"]")).click();
		Thread.sleep(2000);
		try {
			if(driver.findElement(By.xpath("//android.widget.TextView[@text=\"Account Setup\"]")).isDisplayed()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
//Enter mobile 
	public void enterMobileNumber(String enterMobilenumber) {
		WebElement mobile_number = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.antnele:id/edtPhoneNumber\"]"));
		mobile_number.sendKeys(enterMobilenumber);
	}
	
//Click continue button and check otp page
	
	public boolean clickContinueButton() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.antnele:id/btnDone\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text=\"OK\"]")).click();
		Thread.sleep(2000);
		try {
			return driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/txtTitle\"]")).isDisplayed();
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
	
//Enter otp and check islogin or not
	public void enterOTP(String EnterOtp) {
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//WebElement otp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@resource-id=\"com.antnele:id/edtOtp\"]"))); 
		WebElement otp = driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"com.antnele:id/edtOtp\"]/android.widget.TextView[1]"));
		otp.sendKeys(EnterOtp);
	}
	
//	public void enterotp() throws InterruptedException {
//		driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"com.antnele:id/edtOtp\"]/android.widget.TextView[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"com.antnele:id/edtOtp\"]/android.widget.TextView[1]")).sendKeys("6");
//		
//		WebElement second = driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"com.antnele:id/edtOtp\"]/android.widget.TextView[2]"));
//		second.click();
//		Thread.sleep(2000);
//		second.sendKeys("3");
//		
//		WebElement third = driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"com.antnele:id/edtOtp\"]/android.widget.TextView[3]"));
//		third.click();
//		Thread.sleep(2000);
//		third.sendKeys("8");
//		
//		WebElement fourth = driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"com.antnele:id/edtOtp\"]/android.widget.TextView[4]"));
//		fourth.click();
//		Thread.sleep(2000);
//		fourth.sendKeys("9");
//		
//		WebElement fifth = driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"com.antnele:id/edtOtp\"]/android.widget.TextView[5]"));
//		fifth.click();
//		Thread.sleep(2000);
//		fifth.sendKeys("8");
//		
//		WebElement sixth = driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"com.antnele:id/edtOtp\"]/android.widget.TextView[6]"));
//		sixth.click();
//		Thread.sleep(2000);
//		sixth.sendKeys("1");
//		
//		
//		
//		
//	}
//	
//Click submit button on otp page
	public void clickNextButtonOnOtpPage() {
		driver.findElement(By.xpath("//android.widget.Button[@text=\"NEXT\"]")).click();
	}
	
//Check islogin or not
	public boolean isLoginSuccessful() {
		try {
			return driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/txtTitle\"]")).isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
//Navigate to sign in page when we clik without mobile
	public boolean clickWithoutMobileAnd_CheckMobileNumberPage() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Without Mobile\"]")).click();
		Thread.sleep(2000);
		try {
			if(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/txtTitle\"]")).isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return false;
	}
	
//Enter username and password
	public void enterUsernameAndPassword(String username, String enter_password) throws InterruptedException {
		
		enter_username = username;
		
		WebElement username1 = driver.findElement(By.xpath("//android.widget.EditText[@text=\"Username\"]"));
		username1.sendKeys(enter_username);
		
		Thread.sleep(2000);
		
		WebElement password = driver.findElement(By.xpath("//android.widget.EditText[@text=\"Password\"]"));
		password.sendKeys(enter_password);
	}
	
//Click sign in button
	
	public void isSignInButtonClickable() throws InterruptedException {
		//WebElement signInbutton = driver.findElement(By.xpath("//android.widget.Button[@text=\"SIGN IN\"]"));
		//signInbutton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement signinButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text=\"SIGN IN\"]")));
		signinButton.click();
		
		//Thread.sleep(3000);
		
		//WebElement allo_button = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]"));
		//allo_button.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		
		WebElement allow_button = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")));
		allow_button.click();
		
		Thread.sleep(2000);
	}
	
//is login success or not
	
	public boolean IsloginSuccess() throws InterruptedException {
		
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.antnele:id/navigation_bar_item_icon_view\"])[4]")).click();
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		
		//String Getusername = driver.findElement(By.xpath("//android.widget.TextView[@text=\"@delete.account23\"]")).getText();
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/txtUserName\"]")));
		
		String Getusername = element.getText();
		
		try {
			if(Getusername.equalsIgnoreCase("@"+enter_username)) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		System.out.println(Getusername+"="+enter_username);
		return false;
		
	}
	
	public boolean clickSignUpButtonAnd_checkSignUpPage() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/txtSignUp\"]")).click();
		Thread.sleep(1000);
		
		try {
			if(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/txtTitle\"]")).isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		return false;
		
	}

//Test case 1 for signUp
	public boolean checkNameFieldPresence() {
		WebElement namefield = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.antnele:id/edtName\"]"));
		try {
			if(namefield.isDisplayed()) {
				//System.out.println("name field is present on the sign up screen");
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println("name field is not present on the signup screen");
			return false;
		}
		return false;
	}
	
//Test case 2 for sign up
	public boolean checknamewithNoData() throws InterruptedException {
		
		try {
		WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.antnele:id/edtName\"]"));
		nameField.clear();
		
		WebElement SignUpButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.antnele:id/btnSignUp\"]"));
		SignUpButton.click();
		Thread.sleep(2000);
		
		String ActualErrorMessage = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]")).getText();
		
		String expectedErrorMessage = "Please enter your First name";
		
		if(ActualErrorMessage.equals(expectedErrorMessage)) {
		
//		try {
//			if(ActualErrorMessage.equals(expectedErrorMessage)) {
//				return true;
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//			return false;
//		}
		
		WebElement okButton = driver.findElement(By.id("android:id/button1"));
		okButton.click();
		return true;
		}
	}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("error message not found"+ e.getMessage());
		}
		
		return false;
		
	}
	
	public void enterName(String name) throws InterruptedException {
		WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.antnele:id/edtName\"]"));
		nameField.clear();
		Thread.sleep(1000);
		nameField.sendKeys(name);
	}
	
	public String getNameFieldValue() {
		WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.antnele:id/edtName\"]"));
		return nameField.getText();
	}
	
	
	public boolean enterdetailsIn_SignUpPage(String name, String surname, String enter_password, String enter_confirm_password) throws InterruptedException {
		
		enter_name = name;
		enter_surname = surname;
		Thread.sleep(2000);
		
		WebElement name1 = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.antnele:id/edtName\"]"));
		name1.clear();
		name1.sendKeys(enter_name);
		
		WebElement surname1 = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.antnele:id/edtSurname\"]"));
		surname1.sendKeys(enter_surname);
		
		WebElement click_username = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.antnele:id/edtUserName\"]"));
		click_username.click();
		Thread.sleep(2000);
		
		String GetusernameInSignUpPage = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.antnele:id/edtUserName\"]")).getText();
		String usernameWithoutDigits = GetusernameInSignUpPage.replaceAll("\\d+$", "");
		
		try {
			if(usernameWithoutDigits.equalsIgnoreCase(enter_username+"."+enter_surname)) {
				System.out.println("entered username and given user name is showing same");
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		//return false;
		
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.antnele:id/edtGender\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/txt\" and @text=\"MALE\"]")).click();
		
//		List<WebElement> keyword = driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.antnele:id/linearLayout\"]")).findElements(By.xpath("//android.widget.ListView[@resource-id=\"com.antnele:id/listview\"]"));
//		//List<WebElement> keyword = driver.findElements(By.xpath("//android.widget.ListView[@resource-id=\"com.antnele:id/listview\"]"));
//		Thread.sleep(2000);
//		
//		for(WebElement element : keyword) {
//			String keywords = element.getText();
//			if(keywords.equalsIgnoreCase("MALE")) {
//				element.click();
//				break;
//			}
//		}
		
		WebElement dateOfBirth = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.antnele:id/edtDate\"]"));
		dateOfBirth.click();
		Thread.sleep(2000);
		
		WebElement yearPicker = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/date_picker_header_year\"]"));
		yearPicker.click();
		Thread.sleep(4000);// properly running this line
		
//		WebElement selectYear = driver.findElement(By.xpath("//android.widget.TextView[@text=\"1999\"]"));
//		selectYear.click();
//		
//		String year = selectYear.getText();
		
		String desiredYear = "1999";
		scrollToYear(driver, desiredYear);
		Thread.sleep(2000);
		
		
//		while(true) {
//			WebElement currentYearElement = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\\\"android:id/date_picker_header_year\\\"]"));
//			String currentYear = currentYearElement.getText();
//			if(currentYear.equals(desiredYear)) {
//				break;
//			}
//			else {
//				new TouchAction<>(driver)
//					.press(PointOption.point(500, 600))
//					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
//					.moveTo(PointOption.point(500, 1200))
//					.release()
//					.perform();
//				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()");
//			}
//		}
		//yearPicker.click();
		
		WebElement previousMonth = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Previous month\"]"));
		
		WebElement nextMonth = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Next month\"]"));
		//System.out.println(driver.findElement(By.xpath("//android.view.View[@resource-id=\"android:id/month_view\"]" + "This is calendar element" )).getText());
		
		//while(!driver.findElement(By.xpath("//android.view.View[@resource-id=\"android:id/month_view\"]")).getText().contains("May")) 
//		while(!driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/date_picker_header_date']")).getText().contains("05 May 1999")) 
//		{
//			nextMonth.click();
//			Thread.sleep(1000);		//break;
//		}
		
		String desiredMonth = "May";
		 while (true) {
		        String currentMonthYear = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/date_picker_header_date\"]")).getText();
		        System.out.println("CurrentMonth-Year:" + currentMonthYear);
		        
		        //if (currentMonthYear.contains(desiredMonth + " " + desiredYear)) 
		        if (currentMonthYear.contains("Sat, May 1")) {
		        	WebElement date5 = driver.findElement(By.xpath("//android.view.View[@content-desc=\"05 May 1999\"]"));
		        	date5.click();
		            break;
		            
		        } else {
		            //WebElement nextMonth = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Next month\"]"));
		            previousMonth.click();
		            WebElement date1 = driver.findElement(By.className("android.view.View"));
		            date1.click();
		            Thread.sleep(2000);
		        }
		    }
		
		WebElement selectDate = driver.findElement(By.xpath("//android.view.View[@content-desc=\"05 May 1999\"]"));
		selectDate.click();
		String date = selectDate.getText();
		
		WebElement clickOkButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
		clickOkButton.click();
		Thread.sleep(2000);
		
		String getselectedDoB = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.antnele:id/edtDate\"]")).getText();
		
		String expectedDate = "05-05-1999";
		
		//if((desiredYear+"."+date).equalsIgnoreCase(getselectedDoB))	
//		if((expectedDate).equals(getselectedDoB))	
//		{
//			
//			//return true;
//			System.out.println("Expected date is showing after select the date");
//		}
//		else 
//		{
//			return false;
//		}
		
//		try {
//			if(expectedDate.equals(getselectedDoB)) {
//				System.out.println("expected date is showing after select the date");
//				return true;
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("expected date is not showing after select the date, an error message occured");
//			return false;
//		}
		Assert.assertEquals(getselectedDoB, expectedDate, "Date selection failed!");
		System.out.println("date selection pass");

		
		
		
//		WebElement guardianMobileNumber = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.antnele:id/edtMobileNumber\"]"));
//		//WebElement guardianMobileNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"com.antnele:id/edtMobileNumber\"]")));
//		guardianMobileNumber.sendKeys("8179760155");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement guardianMobileNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='com.antnele:id/edtMobileNumber']")));
		guardianMobileNumber.sendKeys("8179760155");
		
		String enteredText = guardianMobileNumber.getAttribute("text");
		if (!enteredText.equals("8179760155")) {
		    System.out.println("Failed to enter the mobile number!");
		}else {
			System.out.println("mobile number entered is showing correctly");
		}


		
		WebElement password = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.antnele:id/edtPassword\"]"));
		password.sendKeys(enter_password);
		String getPassword = password.getText();
		
		WebElement confirmPassword = driver.findElement(By.id("com.antnele:id/edtConfirmPassword"));
		confirmPassword.sendKeys(enter_confirm_password);
		Thread.sleep(2000);
		
		String getConfirmPassword = confirmPassword.getText();
		
		WebElement signUp = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.antnele:id/btnSignUp\"]"));
		signUp.click();
		Thread.sleep(4000);
		
		String errorMessage = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]")).getText();
		
//		if(getPassword.equals(getConfirmPassword)) {
//			return true;
//		}else {
//			System.out.println("error message is showing correctly when the password mismatch i.e:" + errorMessage);
//			return false;
//		}
		
		if(getPassword.equals(getConfirmPassword)) {
			return true;
		}else if (!getPassword.equals(getConfirmPassword)) {
			System.out.println("password mismatch, error message is displaying i.e: "+errorMessage);
			return false;
		}else {
			System.out.println("error message not found");
			return false;
		}
		
//		if(!getPassword.equals(getConfirmPassword)) {
//			try {
//				WebElement errorMessage = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]"));
//				if(errorMessage.isDisplayed()) {
//					System.out.println("Error message displayed: " + errorMessage.getText());
//					return false; // Passwords do not match, stay on the same page
//				}
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//				System.out.println("Error message not found.");
//	            return false; // Error message should be there, but isn't, so fail the test
//			}
//			
//		}
//		else {
//			//WebElement signUp = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.antnele:id/btnSignUp\"]"));
//			signUp.click();
//			
//			
//			//WebDriverWait wait = new WebDriverWait(driver, 10);
//			try {
//				//WebElement ConfirmationMessage = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/alertTitle\"]"));
//				WebElement ConfirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/alertTitle\"]")));
//				if(ConfirmationMessage.isDisplayed()) {
//					System.out.println("Successfully proceeded to the next page.");
//	                return true; // Successfully moved to the next page
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//				System.out.println("Did not proceed to the next page.");
//	            return false;
//			}
//		}
		
//Check confirmation pop up message
			
//			String confirmationMessage_Content = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]")).getText();
//		
//			String expected_confrmation_message = driver.findElement(By.xpath("To recover Username/password in future, name/surname/dob/mobile-number needs to be same as entered during sign-up")).getText();
//		
//			Assert.assertEquals(confirmationMessage_Content, expected_confrmation_message, "expected actual confrimation message is not march");
//		
//		return false;
		
//--------------------------------------------------------------------------------------------------------------		
		
//		try {
//			if(getPassword.equals(getConfirmPassword)) {
//				return true;
//			}else if (!getConfirmPassword.equals(getConfirmPassword)) {
//				System.out.println(errorMessage);
//				
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("error message is not showing or not found in time");
//			return false;
//		}
//		return false;
		
		
		
		//return false;

	}
	
	
	
	public boolean clickSignUpButtonAndCheckConfirmationMessage() throws InterruptedException {
		String ActualConfirmationMessage_Content = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]")).getText();
		
		String expected_confrmation_message = "To recover Username/password in future, name/surname/dob/mobile-number needs to be same as entered during sign-up";
	
		Assert.assertEquals(ActualConfirmationMessage_Content, expected_confrmation_message, "expected actual confrimation is not march");
		Thread.sleep(3000);
	
	return true;
	
	
	}
	
	public boolean clickEditbuttonAndCheck_signUpPage() throws InterruptedException {
		WebElement editButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button2\"]"));
		editButton.click();
		Thread.sleep(2000);
		
		WebElement signUpPage = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/txtTitle\"]"));
		
		try {
			if(signUpPage.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return false;
	}
	
	public boolean clickOkButton_and_checkCongratulationsMessage() throws InterruptedException{
		WebElement signupButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.antnele:id/btnSignUp\"]"));
		signupButton.click();
		
		
		WebElement okButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
		okButton.click();
		
		Thread.sleep(2000);
		
		WebElement congratulationsMessage = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/alertTitle\"]"));
		
		try {
			if(congratulationsMessage.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return false;
	}
	
	public boolean clickCongratulationsMessageOKButton_and_checkJoinGroupScreen() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		Thread.sleep(2000);
		
		WebElement joinGroupScreen = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/btnAddRole\"]"));
		
		try {
			if(joinGroupScreen.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return false;
	}
	
//	public void scrollToYear(AndroidDriver<AndroidElement> driver, String desiredYear) {
//		WebElement yearView = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/date_picker_header_year']"));
//		yearView.click();
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"" + desiredYear + "\")");
//	}
	
	public static void scrollToYear(AndroidDriver<MobileElement> driver, String year) {
        boolean yearFound = false;
        while (!yearFound) {
            try {
                driver.findElement(By.xpath("//android.widget.TextView[@text='" + year + "']")).click();
                yearFound = true;
                System.out.println("year not found on try block");
                return;
            } catch (Exception e) {
                // If year not found, swipe up to scroll
            	System.out.println("Year not found, scrolling up...");
                //swipeUp(driver);
                LaunchingPage.swipeDown(driver);
            }
        }
		
    }
	

	
//	public static void swipeDown(AndroidDriver<MobileElement> driver) {
//	    try {
//	        Dimension dimension = driver.manage().window().getSize();
//	        int startX = dimension.width / 2;
//	        int startY = (int) (dimension.height * 0.4);
//	        int endY = (int) (dimension.height * 0.7);
//
//	        //System.out.println("Swiping from (" + startX + ", " + startY + ") to (" + startX + ", " + endY + ")");
//
//	        TouchAction action = new TouchAction(driver);
//	        action.press(PointOption.point(startX, startY))
//	              .waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
//	              .moveTo(PointOption.point(startX, endY))
//	              .release()
//	              .perform();
//
//	        System.out.println("Swipe action performed successfully.");
//	    } 
//	    catch (Exception e) {
//	        System.out.println("Error during swipe: " + e.getMessage());
//	    }
//	}
	
	public static void swipeDown(AndroidDriver<MobileElement> driver) {
        try {
            Dimension dimension = driver.manage().window().getSize();
            int startX = dimension.width / 2;
            int startY = (int) (dimension.height * 0.4); // Start closer to the bottom
            int endY = (int) (dimension.height * 0.7);  // End closer to the top

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(swipe));
            System.out.println("Swipe down performed successfully.");
        } catch (Exception e) {
            System.out.println("Error during swipe up: " + e.getMessage());
        }
    }

}
	
	
	
	//}
//}
