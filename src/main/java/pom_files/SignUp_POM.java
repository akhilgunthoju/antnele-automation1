package pom_files;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.remote.RemoteWebElement;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import automation.BaseTest;
import automation.SwipeUtils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;


public class SignUp_POM extends BaseTest {
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.antnele:id/edtName\"]")
	private WebElement Namefield;
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.antnele:id/edtSurname\"]")
	private WebElement Surnamefield;
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.antnele:id/edtUserName\"]")
	private WebElement Usernamefield;
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.antnele:id/edtGender\"]")
	private WebElement gender;
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.antnele:id/edtDate\"]")
	private WebElement dateOfBirth;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement okButton;
	
	@FindBy(xpath="//android.widget.EditText[@resource-id='com.antnele:id/edtMobileNumber']")
	private WebElement gaurdianMobileNumber;
	
	@FindBy(xpath="//android.widget.EditText[@resource-id=\"com.antnele:id/edtPassword\"]")
	private WebElement password;
	
	@FindBy(id="com.antnele:id/edtConfirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//android.widget.Button[@text=\"AGREE AND CONTINUE\"]")
	private WebElement signUpButton;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/message\"]")
	private WebElement erroMessageText;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.antnele:id/txt\" and @text=\"MALE\"]")
	private WebElement maleGender;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/date_picker_header_year\"]")
	private WebElement yearPicker;
	
	@FindBy(xpath="//android.view.View[@content-desc=\"05 May 1999\"]")
	private WebElement selectDate;
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement clickOkButtonforAllPOPUpWindows;
	
	@FindBy(xpath="//android.widget.ImageButton[@content-desc=\"Previous month\"]")
	private WebElement previousMonth;
	
	@FindBy(xpath="//android.widget.ImageButton[@content-desc=\"Next month\"]")
	private WebElement nextMonth;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Error\"]")
	private WebElement errorMessageForAll;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Success\"]")
	private WebElement successPopUpWindow;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Congratulations\"]")
	private WebElement congratulationPopUpWindow;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.antnele:id/txtSignUp\"]")
	private WebElement signUpButtonElement;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Sign Up\"]")
	private WebElement signUpHeaderElement;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Confirmation\"]")
	private WebElement confirmationMessageElement;
	
	@FindBy(xpath="//android.widget.Button[@text=\"EDIT\"]")
	private WebElement editButton;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Congratulations\"]")
	private WebElement congratulationsMessage;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Join Group\"]")
	private WebElement joinGroupPage;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Skip\"]")
	private WebElement skipButtonElement;
	
	@FindBy(xpath="//android.widget.Button[@text=\"Allow\"]")
	private WebElement allowButton;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Chat\"]")
	private WebElement chatTab;
	
	@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.antnele:id/navigation_bar_item_icon_view\"])[4]")
	private WebElement accountTab;
	
	@FindBy(id="com.antnele:id/txtName")
	private WebElement nameInAccountPage;
	
	
	public SignUp_POM(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }
	
	public boolean navigateToSignUpPage() throws InterruptedException {
		SignIn_POM signInPage = new SignIn_POM();
		signInPage.navigateToSignInWithoutMobilePage();
		
//		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(signUpButtonElement));
		wait.until(ExpectedConditions.elementToBeClickable(signUpButtonElement));
		
		signUpButtonElement.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(signUpHeaderElement));
		return signUpHeaderElement.isDisplayed();
	}
	
	public static void scrollToYear(AppiumDriver driver2, int year) throws InterruptedException {
        boolean yearFound = false;
        SwipeUtils swipeUtils = new SwipeUtils();
        while (!yearFound) {
            try {
                driver2.findElement(By.xpath("//android.widget.TextView[@text='" + year + "']")).click();
                yearFound = true;
                System.out.println("year not found on try block");
                return;
            } catch (Exception e) {
                // If year not found, swipe up to scroll
            	System.out.println("Year not found, scrolling up...");
                //swipeUp(driver);
                swipeUtils.swipeDown(driver2);
                Thread.sleep(3000);
//                WebDriverWait wait = new WebDriverWait(driver2, 10);
//                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.ListView[@resource-id=\"android:id/date_picker_year_picker\"]")));
            }
        }
    }
	
//	public static void scrollToYear(AppiumDriver driver2, int nextYear) throws InterruptedException {
//	    boolean yearFound = false;
//	    int maxScrollAttempts = 15;
//	    int scrollCount = 0;
//	    SwipeUtils swipeUtils = new SwipeUtils();
//
//	    while (!yearFound && scrollCount < maxScrollAttempts) {
//	        try {
//	            WebElement targetYear = driver2.findElement(By.xpath("//android.widget.TextView[@text='" + nextYear + "']"));
//
//	            WebDriverWait wait = new WebDriverWait(driver2, 10);
//	            wait.until(ExpectedConditions.visibilityOf(targetYear));
//
//	            if (targetYear.isDisplayed()) {
//	                Thread.sleep(500);
//	                targetYear.click();
//	                System.out.println("✅ Year " + nextYear + " found and clicked.");
//	                yearFound = true;
//	                return;
//	            }
//	        } catch (Exception e) {
//	            System.out.println("🔁 Scroll attempt " + (scrollCount + 1) + ": Year " + nextYear + " not found.");
//	            System.out.println("⛔ Exception: " + e.getClass().getName() + " - " + e.getMessage());
//	            swipeUtils.swipeDown(driver2); // <-- Make sure this method works
//	            Thread.sleep(1000);
//	            scrollCount++;
//	        }
//	    }
//
//	    if (!yearFound) {
//	        System.out.println("❌ Year " + nextYear + " not found after " + scrollCount + " scrolls.");
//	        throw new NoSuchElementException("Year " + nextYear + " not found after " + scrollCount + " scrolls.");
//	    }
//	}

//	public static void scrollToYear(AppiumDriver driver, int year) throws InterruptedException {
//	    String yearText = String.valueOf(year);
//	    int maxScrolls = 20;
//	    boolean yearFound = false;
//
//	    for (int i = 0; i < maxScrolls; i++) {
//	        try {
//	            // Check if year element is visible
//	            WebElement yearElement = driver.findElement(
//	                By.xpath("//android.widget.TextView[@text='" + yearText + "']")
//	            );
//
//	            if (yearElement.isDisplayed()) {
//	                yearElement.click();
//	                System.out.println("✅ Year " + yearText + " found and clicked.");
//	                yearFound = true;
//	                break;
//	            }
//
//	        } catch (Exception e) {
//	            System.out.println("🔁 Year " + yearText + " not visible yet. Scroll attempt: " + (i + 1));
//
//	            try {
//	                // Scroll one page down (scroll backward)
////	                String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
////	                               + ".scrollBackward()";
////	                driver.findElement(MobileBy.AndroidUIAutomator(command));
//	            	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView"+ "(new UiSelector().textContains(\"1999\").instance(0)).scrollBackward(10)"));
//	                
//	                // Wait to let UI settle
//	                Thread.sleep(1500);
//	            } catch (Exception scrollEx) {
//	                System.out.println("⚠️ Scroll failed: " + scrollEx.getMessage());
//	                // Try next attempt or break if unrecoverable
//	            }
//	        }
//	    }
//
//	    if (!yearFound) {
//	        throw new NoSuchElementException("❌ Year " + yearText + " not found after " + maxScrolls + " scrolls.");
//	    }
//	}
	

//	public static void scrollToYear(AppiumDriver driver, int year) {
//	    try {
//	        String uiSelector = "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
//	                          + ".scrollIntoView(new UiSelector().text(\"" + year + "\"))";
//	        driver.findElement(MobileBy.AndroidUIAutomator(uiSelector)).click();
//	        System.out.println("✅ Scrolled to year and clicked: " + year);
//	        try {
//	            WebElement yearElement = driver.findElement(By.xpath("//android.widget.TextView[@text='" + year + "']"));
//	            yearElement.click();
//	        } catch (Exception e) {
//	            System.out.println("⚠️ Could not find/click year, retrying...");
//	        }
//
//	    } catch (Exception e) {
//	        System.out.println("❌ Failed to scroll to year: " + year);
//	        throw new RuntimeException(e);
//	    }
//	}
	
//	public void selectYearInDatePicker() {
//	    // Open year selector
//	    driver.findElement(By.id("android:id/date_picker_header_year")).click();
//
//	    // Scroll to 2000
//	    driver.findElement(MobileBy.AndroidUIAutomator(
//	        "new UiScrollable(new UiSelector().resourceId(\"android:id/date_picker_year_picker\")).scrollIntoView(new UiSelector().text(\"2000\"))"
//	    ));
//
//	    // Click on 2000
//	    driver.findElement(By.xpath("//android.widget.TextView[@text='2000']")).click();
//
//	    // Confirm the date (optional step if there's an OK button)
//	    driver.findElement(By.id("android:id/button1")).click();
//	}
	
//	public void selectYearInDatePicker(int select_year) {
//	    // Open year selector
//	    driver.findElement(By.id("android:id/date_picker_header_year")).click();
//
//	    // Scroll down to find year 2000
//	    driver.findElement(MobileBy.AndroidUIAutomator(
//	        "new UiScrollable(new UiSelector().resourceId(\"android:id/date_picker_year_picker\")).scrollBackward(7).scrollIntoView(new UiSelector().text(\"" +select_year+"\"))"
//	    ));
//
//	    // Click on 2000
//	    driver.findElement(By.xpath("//android.widget.TextView[@text='"+select_year+"']")).click();
	    
//-----------------------------------------------------------------------------------------------------------------------------------

	    // Click OK to confirm
	    //driver.findElement(By.id("android:id/button1")).click();
		
//		boolean yearFound = false;
//		for (int i = 0; i < 10; i++) {
//		    try {
//		    	//driver.findElement(By.xpath("//android.widget.TextView[@text='2000']")).isDisplayed()) 
//		        driver.findElement(By.xpath("//android.widget.TextView[@text='2000']")).click();
//		        yearFound = true;
//		        break;
//		    } catch (Exception e) {
//		        driver.findElement(MobileBy.AndroidUIAutomator(
//		            "new UiScrollable(new UiSelector().resourceId(\"android:id/date_picker_year_picker\")).scrollBackward(1)"
//		        ));
//		    }
//		}
//
//		if (!yearFound) {
//		    System.out.println("Year 2000 not found after scrolling.");
//		}

//	}



	
	public boolean checkNameFieldPresence() {
		//Assert.assertTrue(Namefield.isDisplayed(), "name field is not present on the screen");
		return Namefield.isDisplayed();
	}
	
	public boolean checkSurnameFieldPresence() {
		return Surnamefield.isDisplayed();
	}
	
	public boolean checkUsernameField() {
		return Usernamefield.isDisplayed();
	}
	
	public boolean checkGenderfieldPresence() {
		return gender.isDisplayed();
	}
	
	public boolean checkDOBFieldPresence() {
		return dateOfBirth.isDisplayed();
	}
	
	public boolean checkGuardianNumberPresence() {
		return gaurdianMobileNumber.isDisplayed();
	}
	
	public void checknamewithNoData() throws InterruptedException {
		Namefield.clear();
		signUpButton.click();
		
		Thread.sleep(2000);
		
		String actualErrorMessage = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]")).getText();
		String expectedErrorMessage = "Please enter your First name";
		
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "error message not found");
		wait.until(ExpectedConditions.elementToBeClickable(clickOkButtonforAllPOPUpWindows));
		clickOkButtonforAllPOPUpWindows.click();
	}
	
	public void entername(String name) {
		Namefield.clear();
		Namefield.sendKeys(name);
	}
	
	public void entersurname(String surname) {
		Surnamefield.clear();
		Surnamefield.sendKeys(surname);
	}
	
	public String getNameFieldValue() {
		return Namefield.getText();
	}
	
	public String getsurnameFieldValue() {
		return Surnamefield.getText();
	}
	
//	public void checkNameFieldWithOnlySpaces() throws Exception {
//		String inputvalue = "     ";
//		Namefield.sendKeys(inputvalue);
//		
//		String actualValue = getNameFieldValue();
//		Assert.assertEquals(actualValue, inputvalue, "name field is accepting spaces");
//		enterDetails1(inputvalue, "Antnele", "Antnele@123", "Antnele@123", "05-05-1999");
//		clickOkButtonforAllPOPUpWindows.click();
////		Assert.assertTrue(errorMessageForAll.isDisplayed(), "error message is not displaying when enter only spaces in name field");
////		Assert.assertFalse(congratulationsMessage.isDisplayed());
//		try {
//	        Assert.assertTrue(errorMessageForAll.isDisplayed(), "Error message is not displaying when entering only spaces in the name field");
//	    } catch (NoSuchElementException e) {
//	        Assert.fail("Error message was expected but not found.");
//	    }
//
//	    try {
//	        Assert.assertFalse(congratulationsMessage.isDisplayed(), "Success message should not appear when entering only spaces.");
//	    } catch (NoSuchElementException e) {
//	        // Do nothing if the element is not found, as this means it didn't appear (which is expected)
//	    }
//	}

	
	public void enterDetails1(String name, String surname, String enter_password, String enter_confirm_password, String dateOfBirthString) throws Exception {
		
		Namefield.sendKeys(name);
		
		Surnamefield.sendKeys(surname);
		
		Usernamefield.click();
		//Thread.sleep(4000);
		
		wait.until(ExpectedConditions.visibilityOf(Usernamefield));
		
//		String GetusernameInSignUpPage = Usernamefield.getText();
//		String usernameWithoutDigits = GetusernameInSignUpPage.replaceAll("\\d+$", "");
//		String expectedUserName = name+"."+surname;
//		//assertEquals(expectedUserName.toLowerCase(), usernameWithoutDigits, "Username not matched.");
//		assertEquals(usernameWithoutDigits, expectedUserName.toLowerCase(), "Username not matched");
		// clicking gender
		gender.click();
		Thread.sleep(3000);
		maleGender.click();
		
		//TODO verify all the genders in dropdown
		
		
		//dateOfBirth.click();
		dateOfBirth.click();
		Thread.sleep(2000);
		
		yearPicker.click();
		Thread.sleep(3000);
		
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");

        // Parse the string into a Date object
        Date date = inputFormat.parse(dateOfBirthString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
		
		String desiredMonth = monthFormat.format(date);
		int desiredDay = calendar.get(Calendar.DAY_OF_MONTH);
		
		int desiredYear = calendar.get(Calendar.YEAR);
		int nextYear = desiredYear+1;
		scrollToYear(driver, nextYear);
		//selectYearInDatePicker(nextYear);
		//selectYearFromCalendar(nextYear);
		//Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(previousMonth));
		
		String desiredDate = "0"+desiredDay+" "+desiredMonth+" "+desiredYear;
//		 while (true) {
//		        String firstDate = driver.findElement(By.xpath("//android.view.View[@text=\"1\"]")).getAttribute("content-desc");
//		        System.out.println("firstDate:" + firstDate);
//		        System.out.println(desiredDate);
//		        
//		        //if (currentMonthYear.contains(desiredMonth + " " + desiredYear)) 
//		        if (firstDate.contains("01 "+desiredMonth+" "+desiredYear)) {
//		        	Thread.sleep(2000);
//		        	WebElement date5 = driver.findElement(By.xpath("//android.view.View[@content-desc=\""+desiredDate+"\"]"));
//		        	date5.click();
//		            break;
//		            
//		        } else {
//		            previousMonth.click();
//		            Thread.sleep(3000);
//		            
//		        }
//		    }
		
		int maxRetries = 20;
	    int retries = 0;
	    boolean dateSelected = false;

	    while (retries < maxRetries) {
	        try {
	            String firstDate = driver.findElement(By.xpath("//android.view.View[@text='1']")).getAttribute("content-desc");
	            System.out.println("firstDate: " + firstDate);
	            System.out.println("Target date: " + desiredDate);

	            if (firstDate.contains("01 " + desiredMonth + " " + desiredYear)) {
	                WebElement targetDate = driver.findElement(By.xpath("//android.view.View[@content-desc=\"" + desiredDate + "\"]"));
	                targetDate.click();
	                dateSelected = true;
	                break;
	            } else {
	            	WebDriverWait wait1 = new WebDriverWait(driver, 10);
	            	WebElement previousMonthButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc='Previous month']")));
	                //previousMonth.click();
	            	previousMonthButton.click();
	                Thread.sleep(2000); // Small delay to avoid UI racing
	                System.out.println("Clicked 'Previous Month'. Retrying...:"+retries);
	            }
	        }catch (StaleElementReferenceException e) {
	            System.out.println("StaleElementReferenceException occurred. Retrying...");
	            continue;
	        } 
	        catch (Exception e) {
	            System.out.println("Exception during month navigation: " + e.getMessage());
	            continue;
	        }
	        retries++;
	    }

	    if (!dateSelected) {
	        throw new Exception("Unable to select the date after " + retries + " attempts.");
	    }
		
		clickOkButtonforAllPOPUpWindows.click();
		Thread.sleep(2000);
		
		String getselectedDoB = dateOfBirth.getText();
		Assert.assertEquals(getselectedDoB, dateOfBirthString, "Date selection failed!");
		System.out.println("date selection pass");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(gaurdianMobileNumber));
		gaurdianMobileNumber.sendKeys("8179760155");
		
		password.sendKeys(enter_password);
		String getPassword = password.getText();
		
		confirmPassword.sendKeys(enter_confirm_password);
		Thread.sleep(2000);
		
		String getConfirmPassword = confirmPassword.getText();
		
		signUpButton.click();
		Thread.sleep(4000);
		
		clickOkButtonforAllPOPUpWindows.click();
		
	}
	
	public boolean checkNameFieldWithOnlySpaces() throws Exception {
		String inputvalue = "     ";
		Namefield.sendKeys(inputvalue);
		
		String actualValue = getNameFieldValue();
		Assert.assertEquals(actualValue, inputvalue, "name field is accepting spaces");
		enterDetails1(inputvalue, "Antnele", "Antnele@123", "Antnele@123", "05-05-1999");
		return errorMessageForAll.isDisplayed();
		//Assert.assertTrue(errorMessageForAll.isDisplayed(), "error message is not displaying when enter only spaces in name field");
		//return true;
		//Assert.assertFalse(congratulationsMessage.isDisplayed());
//		try {
//	        Assert.assertTrue(errorMessageForAll.isDisplayed(), "Error message is not displaying when entering only spaces in the name field");
//	    } catch (NoSuchElementException e) {
//	        Assert.fail("Error message was expected but not found.");
//	    }
//
//	    try {
//	        Assert.assertFalse(congratulationsMessage.isDisplayed(), "Success message should not appear when entering only spaces.");
//	    } catch (NoSuchElementException e) {
//	        // Do nothing if the element is not found, as this means it didn't appear (which is expected)
//	    }
	}
	
	public boolean checksurnameFieldMandatory() throws Exception {
		enterDetails1("Antnele", "", "Antnele@123", "Antnele@123", "05-05-1999");
		Thread.sleep(1000);
		return errorMessageForAll.isDisplayed();
	}
	
	public void checkSurnameFieldLeadingSpacesAreTrimmed() throws Exception{
		String name1 = "Antnele";
		String surname1 = "    Test";
		
		enterDetails1(name1, surname1, "Antnele@123", "Antnele@123", "05-05-1999");
		String expectedValue = name1+" "+surname1.replaceAll("   ", "");
		
		wait.until(ExpectedConditions.elementToBeClickable(clickOkButtonforAllPOPUpWindows));
		
		//congratulationPopUpWindow.click();
		clickOkButtonforAllPOPUpWindows.click();
		skipButtonElement.click();
		Thread.sleep(2000);
		accountTab.click();
		wait.until(ExpectedConditions.visibilityOf(nameInAccountPage));
		String getnameInAccountPage = nameInAccountPage.getText();
		Assert.assertEquals(getnameInAccountPage, expectedValue, "surname is not trimmed spaces");
		
	}
	
	public boolean checkSurnameFieldWithMixedCases() throws Exception {
		String name = "jOhN";
		String inputValue = "doE";
		enterDetails1(name, inputValue, "Antnele@123", "Antnele@123", "05-05-1999");
		String expectedValue1 = name+ " "+inputValue;
		String expectedValue = "John Doe";
		wait.until(ExpectedConditions.elementToBeClickable(clickOkButtonforAllPOPUpWindows));
		
		clickOkButtonforAllPOPUpWindows.click();
		skipButtonElement.click();
		Thread.sleep(2000);
		accountTab.click();
		String nameInAccountPage = driver
		        .findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/txtName\" and @text=\""
		        + expectedValue + "\"]"))
		        .getText();
		//wait.until(ExpectedConditions.visibilityOf(nameInAccountPage));
		//String getnameinaccountPage = nameInAccountPage.getText();
		Assert.assertEquals(nameInAccountPage, expectedValue1, "name is not showing as expected");
		return true;
	}
	
	public void checkSurnameFieldWithOnlySpaces() throws Exception {
		String inputvalue = "    ";
		
		Surnamefield.sendKeys(inputvalue);
		String actualSurname = getsurnameFieldValue();
		Assert.assertEquals(actualSurname, inputvalue, "surname field is not accepting spaces");
		System.out.println("surname field is accepting spaces");
		
		enterDetails1("john", inputvalue, "Antnele@123", "Antnele@123", "05-05-1999");
		Assert.assertTrue(errorMessageForAll.isDisplayed(), "error message is not displaying when enter only spaces");
		Assert.assertFalse(congratulationPopUpWindow.isDisplayed());
	}
	
	public boolean checkSurnameFieldCaseSensitive() throws Exception {
		String name = "JOHN";
		String inputValue = "ALEX";
		
		enterDetails1(name, inputValue, "Antnele@123", "Antnele@123", "05-05-1999");
		String expectedNameAndSurname = name+" "+inputValue;
		wait.until(ExpectedConditions.elementToBeClickable(clickOkButtonforAllPOPUpWindows));
		clickOkButtonforAllPOPUpWindows.click();
		wait.until(ExpectedConditions.elementToBeClickable(skipButtonElement));
		skipButtonElement.click();
		Thread.sleep(2000);
		accountTab.click();
		
		String getNameSurnameValue = driver
		        .findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.antnele:id/txtName\" and @text=\""
		        + expectedNameAndSurname + "\"]"))
		        .getText();
		
		Assert.assertEquals(getNameSurnameValue, expectedNameAndSurname, "name and surname did not march");
		return true;
	}
	
	public boolean checksurnameWithIntials() {
		String inputValue = "R. K. Singh";
		
		entersurname(inputValue);
		String actualValue = getsurnameFieldValue();
		
		//Assert.assertEquals(actualValue, inputValue, "surname field is not accepting intials");
		return inputValue.equals(actualValue);
		
	}
	
	public void checkSurnameFieldCharacterLimit() {
		String inputValue = "fsjdgfkfuthkgdhhbbvgbbbbvgghhdkalhjjjoiwhdhfjsbsbhfhfgshjfgsjdfsgjsdhhjfdjf";
		entersurname(inputValue);
		int expectedValue = 50;
		int actualValue = getsurnameFieldValue().length();
		
		Assert.assertEquals(actualValue, expectedValue, "there is no limit");
	}
	
	public boolean checkUsernamePresence() {
		return Usernamefield.isDisplayed();
	}
	
//	public void enterDetails(String name, String surname, String enter_password, String enter_confirm_password, String dateOfBirthString) throws InterruptedException, ParseException {
//		
//		Namefield.sendKeys(name);
//		
//		Surnamefield.sendKeys(surname);
//		
//		Usernamefield.click();
//		//Thread.sleep(4000);
//		
//		wait.until(ExpectedConditions.visibilityOf(Usernamefield));
//		
//		String GetusernameInSignUpPage = Usernamefield.getText();
//		String usernameWithoutDigits = GetusernameInSignUpPage.replaceAll("\\d+$", "");
//		String expectedUserName = name+"."+surname;
//		//assertEquals(expectedUserName.toLowerCase(), usernameWithoutDigits, "Username not matched.");
//		assertEquals(usernameWithoutDigits, expectedUserName.toLowerCase(), "Username not matched");
//		// clicking gender
//		gender.click();
//		Thread.sleep(3000);
//		maleGender.click();
//		
//		//TODO verify all the genders in dropdown
//		
//		
//		//dateOfBirth.click();
//		dateOfBirth.click();
//		Thread.sleep(2000);
//		
//		yearPicker.click();
//		Thread.sleep(3000);
//		
//		SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
//        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
//
//        // Parse the string into a Date object
//        Date date = inputFormat.parse(dateOfBirthString);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//		
//		String desiredMonth = monthFormat.format(date);
//		int desiredDay = calendar.get(Calendar.DAY_OF_MONTH);
//		
//		int desiredYear = calendar.get(Calendar.YEAR);
//		int nextYear = desiredYear+1;
//		scrollToYear(driver, nextYear);
//		//Thread.sleep(2000);
//		
//		wait.until(ExpectedConditions.visibilityOf(previousMonth));
//		
//		String desiredDate = "0"+desiredDay+" "+desiredMonth+" "+desiredYear;
//		 while (true) {
//		        String firstDate = driver.findElement(By.xpath("//android.view.View[@text=\"1\"]")).getAttribute("content-desc");
//		        System.out.println("firstDate:" + firstDate);
//		        System.out.println(desiredDate);
//		        
//		        //if (currentMonthYear.contains(desiredMonth + " " + desiredYear)) 
//		        if (firstDate.contains("01 "+desiredMonth+" "+desiredYear)) {
//		        	Thread.sleep(2000);
//		        	WebElement date5 = driver.findElement(By.xpath("//android.view.View[@content-desc=\""+desiredDate+"\"]"));
//		        	date5.click();
//		            break;
//		            
//		        } else {
//		            previousMonth.click();
//		            Thread.sleep(2000);
//		            
//		        }
//		    }
//		
//		clickOkButtonforAllPOPUpWindows.click();
//		Thread.sleep(2000);
//		
//		String getselectedDoB = dateOfBirth.getText();
//		Assert.assertEquals(getselectedDoB, dateOfBirthString, "Date selection failed!");
//		System.out.println("date selection pass");
//		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(gaurdianMobileNumber));
//		gaurdianMobileNumber.sendKeys("8179760155");
//		
//		password.sendKeys(enter_password);
//		String getPassword = password.getText();
//		
//		confirmPassword.sendKeys(enter_confirm_password);
//		Thread.sleep(2000);
//		
//		String getConfirmPassword = confirmPassword.getText();
//		
//		signUpButton.click();
//		Thread.sleep(4000);
//		
//	}
	
	public void validatePasswordMismatchErrorMessage() {
		assertTrue(erroMessageText.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(erroMessageText));
		
		String actualErrorMessage = erroMessageText.getText();
		String expectedErrorMessage = "Password and confirm password must be same";
		assertEquals(expectedErrorMessage, actualErrorMessage, "Expected error message is matched with actual error message.");
	}
	
	public String checkConfirmationMessage() {
		assertFalse(errorMessageForAll.isDisplayed(), "login was not successfull");
		assertTrue(confirmationMessageElement.isDisplayed());
		return confirmationMessageElement.getText();
	}
	
	
	public boolean clickEditbuttonAndCheck_signUpPage() {
		editButton.click();
		return signUpHeaderElement.isDisplayed();
	}
	
	public void clickAgreeandContinueButton() {
		signUpButton.click();
	}
	
	public boolean validateCongratulationMessage() {
		clickOkButtonforAllPOPUpWindows.click();
		assertFalse(errorMessageForAll.isDisplayed(), "error message is displayed after click ok button on confirmation message");
//		Assert.assertTrue(congratulationsMessage.isDisplayed(), "sign up not success");
		return congratulationsMessage.isDisplayed();
	}
	
	public boolean clickOkButtonvalidateJoinGroupPage() {
		clickOkButtonforAllPOPUpWindows.click();
		assertFalse(errorMessageForAll.isDisplayed(), "error message is displayed after click ok button on congratulations message");
		return joinGroupPage.isDisplayed();
	}
	
	public boolean clickSkipButtonAndCheckChatTab() {
		skipButtonElement.click();
		allowButton.click();
		return chatTab.isDisplayed();
	}
}
	
