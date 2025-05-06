package automation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom_files.SignUp_POM;


public class SignUp_without_mobile extends BaseTest {
	
	SignUp_POM app_open;
	BaseTest basetest = new BaseTest();
	
//	public static void updateXrayTestResult(String executionKey, String testKey, String status) throws IOException {
//        //String jiraUrl = "String jiraUrl = \"https://akhilgunthoju123.atlassian.net/rest/raven/1.0/api/test/\" + testKey + \"/status\";\r\n" + executionKey + "/AAT-169/" + testKey + "/status";
//        //String jiraUrl = "https://akhilgunthoju123.atlassian.net/rest/raven/1.0/api/test/" + testKey + "/status";
//        String jiraUrl = "https://akhilgunthoju123.atlassian.net/rest/raven/1.0/api/test/{testKey}/status\r\n"
//        		+ "";
//        String username = "akhilgunthoju123@gmail.com";
//
//        String jsonPayload = "{ \"status\": \"" + status + "\" }";
//
//        CloseableHttpClient client = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(jiraUrl);
//        httpPost.setHeader("Authorization", "Basic " +
//                java.util.Base64.getEncoder().encodeToString((username + ":" + apiToken).getBytes()));
//        httpPost.setHeader("Content-Type", "application/json");
//
//        httpPost.setEntity(new StringEntity(jsonPayload));
//        CloseableHttpResponse response = client.execute(httpPost);
//
//        System.out.println("Xray Test Result Updated: " + response.getStatusLine().getStatusCode());
//        client.close();
//    }
	
	//@BeforeTest
	@BeforeMethod
	public void gotoSignUpPage() throws InterruptedException, MalformedURLException {
		if (driver == null) {
	        basetest.launch_app(); // Relaunch the app
	        app_open = new SignUp_POM(driver); // Reinitialize page objects
	    } 
		else {
			System.out.println("driver session is active, continue...");
		}
		basetest.launch_app();
		//Thread.sleep(2000);
		app_open = new SignUp_POM(driver);
		//System.out.println(driver);
		Assert.assertTrue(app_open.navigateToSignUpPage(), "SignUp page not loaded.");
	    
		
	}
	
//	public void updateTestStatus(String testCase_Id, boolean passed) {
//		String testResults = passed ? "Pass" : "Fail";
//		ZephyrScale.updateTestExecutionStatus(testCase_Id, testResults);
// 	}
	
	
//	@Test
//	public void testNavigatetoSignUpPage() throws InterruptedException {
//		app_open = new SignUp_POM(driver);
//		System.out.println(driver);
//		assertTrue(app_open.navigateToSignUpPage(), "SignUp page not loaded.");
//	}
	
//Verify name field is present or not
	
	//@Test(dependsOnMethods = "testNavigatetoSignUpPage", alwaysRun = true)
	@Test()
	public void isPresentNameField() throws InterruptedException, IOException {
		
		//Assert.assertTrue(app_open.checkNameFieldPresence(), "name field is not present on the screen\n");
		boolean res = app_open.checkNameFieldPresence();
//		Assert.assertTrue(res, "Name field is not present on the signup screen");
		String status = res ? "PASSED" : "FAILED";
		Assert.assertTrue(res, "name field is not present on the screen");
		System.out.println("name field is present on the sign up screen\n");
		//passing the results
		ZephyrScale.updateTestExecutionStatus("AAT-T138", "Pass");
//		updateXrayTestResult("AAT-169", "AAT-168", status);
		
		//checking surname field present
		Assert.assertTrue(app_open.checkSurnameFieldPresence(), "surname field is not present on the screen\n");
		System.out.println("surname field is present on the sign up screen\n");
		ZephyrScale.updateTestExecutionStatus("AAT-T148", "Pass");
		
		//checking username field present
		Assert.assertTrue(app_open.checkUsernameField(), "Username field is not present on the screen\n");
		System.out.println("Username field is present on the sign up screen\n");
		
		//Checking gender field presence
		Assert.assertTrue(app_open.checkGenderfieldPresence(), "Gender field is not present on the screen\n");
		System.out.println("Gender field is present on the sign up screen\n");
		
		//checking DOB field presence
		Assert.assertTrue(app_open.checkDOBFieldPresence(), "Dob field is not present on the screen\n");
		System.out.println("Dob field is present on the sign up screen\n");
		
		//checking guardian number field presence
		Assert.assertTrue(app_open.checkGuardianNumberPresence(), "guardian mobile number field is not present on the screen\n");
		System.out.println("guardian mobile number field is present on the screen\n");
	}
	
//Verify name field with no data
	
	@Test(dependsOnMethods = "isPresentNameField", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	//@Test
	public void verifyNameFieldwithNoDate() throws InterruptedException {
		app_open.checknamewithNoData();
		System.out.println("error message is displaying when name field empty");
		ZephyrScale.updateTestExecutionStatus("AAT-T139", "Pass");
	}
	
	@Test(dependsOnMethods = "verifyNameFieldwithNoDate", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	//@Test
	public void verifyCharactersAreRejected() throws InterruptedException {
		String inputValue = "john!@#";
		app_open.entername(inputValue);
		
		Thread.sleep(2000);
		
		String actualValue = app_open.getNameFieldValue();
		
		Assert.assertNotEquals(inputValue, actualValue, "special characters are accepting");
		System.out.println("special characters are not accepting, they are rejecting");
		ZephyrScale.updateTestExecutionStatus("AAT-T141", "Pass");
	}
	
	@Test(dependsOnMethods = "verifyCharactersAreRejected", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	public void verifyNumbersAreRejected() throws InterruptedException {
		String inputvalue = "Antnele123";
		app_open.entername(inputvalue);
		
		Thread.sleep(2000);
		
		String actualvalue = app_open.getNameFieldValue();
		
		Assert.assertNotEquals(actualvalue, inputvalue, "Numbers are accepting in name field");
		System.out.println("numbers are not accepting they are rejecting");
	}
	
	
	@Test(dependsOnMethods = "verifyNumbersAreRejected", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	//@Test
	public void verifyNameFieldWithMultipleWords() {
		String inputvalue = "ram gopam varma";
		app_open.entername(inputvalue);
		
		String actualValue = app_open.getNameFieldValue();
		
		Assert.assertEquals(actualValue, inputvalue, "name field are not taking multiple words");
		System.out.println("name field are taking multiple words");
		//passing the resutls
		ZephyrScale.updateTestExecutionStatus("AAT-T143", "Pass");
	}
	
	@Test(dependsOnMethods = "verifyNameFieldWithMultipleWords", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	//@Test
	public void verifyNameFieldWith_Unicodes() {
		String inputvalue = "Jöhn Dœ jõhñ Ãlêx";
		app_open.entername(inputvalue);
		
		String actualValue = app_open.getNameFieldValue();
		
		Assert.assertNotEquals(actualValue, inputvalue, "name field is accepting unicode");
		System.out.println("app is not accepting unicodes");
		ZephyrScale.updateTestExecutionStatus("AAT-T144", "Pass");
	}
	
	@Test(dependsOnMethods = "verifyNameFieldWith_Unicodes", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	//@Test
	public void verifyNameFieldWith_MixedCases() {
		String inputValue = "jOhN dOE";
		
		app_open.entername(inputValue);
		
		String actualvalue = app_open.getNameFieldValue();
		Assert.assertEquals(actualvalue, inputValue, "name field is not accepting mixed cases");
		System.out.println("name field is accepting mixed cases");
		ZephyrScale.updateTestExecutionStatus("AAT-T145", "Pass");
	}
	
	@Test(dependsOnMethods = "verifyNameFieldWith_MixedCases", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	//@Test
	public void verifyNameFieldWithLeadingNumber() {
		String inputvalue = "1234Antnele";
		app_open.entername(inputvalue);
		String actualvalue = app_open.getNameFieldValue();
		try {
		Assert.assertNotEquals(actualvalue, inputvalue, "Name with leading number is accepting");
		System.out.println("name with leading number is not accepting");
		ZephyrScale.updateTestExecutionStatus("AAT-T146", "Pass");
		}catch (Exception e) {
			// TODO: handle exception
			ZephyrScale.updateTestExecutionStatus("AAT-T146", "Fail");
			throw e;
		} 
		catch (AssertionError e) {
			// TODO: handle exception
			ZephyrScale.updateTestExecutionStatus("AAT-T146", "Fail");
			throw e;
		}
		
	}
	
	@Test(dependsOnMethods = "verifyNameFieldWithLeadingNumber", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	//@Test
	public void verifyNameFieldWithOnlySPaces() throws Exception {
		try {
            //app_open.checkNameFieldWithOnlySpaces();
			Assert.assertTrue(app_open.checkNameFieldWithOnlySpaces(), "error message is not displaying when enter only spaces");
            ZephyrScale.updateTestExecutionStatus("AAT-T147", "Pass"); // If no assertion fails, mark as Pass
        } catch (AssertionError e) {
        	//Assert.assertFalse(app_open.checkNameFieldWithOnlySpaces(), "error message is showing when enter only spaces");
            System.out.println("Test failed due to assertion error: " + e.getMessage());
            ZephyrScale.updateTestExecutionStatus("AAT-T147", "Fail"); // Update Zephyr Scale as Fail
            throw e; // Rethrow to ensure TestNG marks the test as failed
        } catch (Exception e) {
            System.out.println("Test failed due to an unexpected error: " + e.getMessage());
            ZephyrScale.updateTestExecutionStatus("AAT-T147", "Fail"); // Update Zephyr Scale as Fail
            throw e; // Rethrow for visibility
        }
	}
	
	@Test(dependsOnMethods = "verifyNameFieldWithOnlySPaces", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	//@Test
	public void verifySurnameFieldMandatory() throws Exception {
		try {
			Assert.assertTrue(app_open.checksurnameFieldMandatory(), "surnmae field is not mandatory");
			System.out.println("surname field mandatory");
			ZephyrScale.updateTestExecutionStatus("AAT-T149", "Pass");
		}catch (AssertionError e) {
			Assert.assertFalse(app_open.checksurnameFieldMandatory());
			ZephyrScale.updateTestExecutionStatus("AAT-T149", "Fail");
		throw e;
		}catch (Exception e) {
			ZephyrScale.updateTestExecutionStatus("AAT-T149", "Fail");
			throw e;
		}
	}
	
	@Test(dependsOnMethods = "verifySurnameFieldMandatory", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	//@Test
	public void verifysurnameFieldAcceptedCharacters() {
		String inputvalue = "@#$*";
		app_open.entersurname(inputvalue);
		
		String actualValue = app_open.getsurnameFieldValue();
		Assert.assertNotEquals(actualValue, inputvalue, "surname field are accepting characters");
		System.out.println("surname field are not accepting characters");
		ZephyrScale.updateTestExecutionStatus("AAT-T150", "Pass");
		Assert.assertEquals(actualValue, inputvalue);
		ZephyrScale.updateTestExecutionStatus("AAT-T150", "Fail");
	}
	
	@Test(dependsOnMethods = "verifysurnameFieldAcceptedCharacters", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	//@Test
	public void verifyMaximumCharacterLimit() {
		try {
		String inputValue = "aksjsjdjsdkdjfkffkkkgfkksllsjdjfhfjgkglslsfhjdhsuvvhjskdjdjfhfjfkfkgjgkkffj";
		app_open.entersurname(inputValue);
		String actualValue = app_open.getsurnameFieldValue();
		
		Assert.assertNotEquals(actualValue, inputValue, "long input is accepting");
		System.out.println("long input is not accepting");
		ZephyrScale.updateTestExecutionStatus("AAT-T151", "Pass");
		} catch (AssertionError e) {
			// TODO: handle exception
			System.out.println("long input is accepting");
			ZephyrScale.updateTestExecutionStatus("AAT-T151", "Fail");
			throw e;
		}catch (Exception e) {
			// TODO: handle exception
			ZephyrScale.updateTestExecutionStatus("AAT-T151", "Fail");
			throw e;
		}
		
	}
	
	
	@Test(dependsOnMethods = "verifyMaximumCharacterLimit", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	//@Test
	public void verifyLeadingAndTrailingSPacesAreTrimmed() throws Exception {
		try {
		app_open.checkSurnameFieldLeadingSpacesAreTrimmed();
		//Assert.assertTrue(app_open.checkSurnameFieldLeadingSpacesAreTrimmed(), "surname field leading spaces are not trimmed");;
		ZephyrScale.updateTestExecutionStatus("AAT-T152", "Pass");
		} catch (AssertionError e) {
			//Assert.assertFalse(app_open.checkSurnameFieldLeadingSpacesAreTrimmed(), "surname field leading spaces are trimmed");
			System.out.println("leading and trailing spaces are not trimmed");
			ZephyrScale.updateTestExecutionStatus("AAT-T152", "Fail");
			throw e;
		} //catch (Exception e) {
//			ZephyrScale.updateTestExecutionStatus("AAT-T152", "Fail");
//		}
	}
	
	@Test(dependsOnMethods = "verifyLeadingAndTrailingSPacesAreTrimmed", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	//@Test
	public void verifySurnameFieldWithMultipleWords() {
		try {
		String inputvalue = "Singh Rajput";
		
		app_open.entersurname(inputvalue);
		
		String actualValue = app_open.getsurnameFieldValue();
		Assert.assertEquals(actualValue, inputvalue, "surname field is not accepting multiple word");
		System.out.println("surname field is accepting multiple words");
		ZephyrScale.updateTestExecutionStatus("AAT-T153", "Pass");
		} catch (AssertionError e) {
			// TODO: handle exception
			System.out.println("Assertion error "+e.getMessage());
			ZephyrScale.updateTestExecutionStatus("AAT-T153", "Fail");
		} catch (Exception e) {
			System.out.println("exception error "+ e.getMessage());
			ZephyrScale.updateTestExecutionStatus("AAT-T153", "Fail");
		}
	}
	
	@Test(dependsOnMethods = "verifySurnameFieldWithMultipleWords", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	//@Test
	public void verifySurnameFieldRejectingUnicodesCharacters(){
		String inputvalue = "jõhñ Ãlêx";
		
		app_open.entersurname(inputvalue);
		String actulaValue = app_open.getsurnameFieldValue();
		
		Assert.assertEquals(actulaValue, inputvalue, "surname field is not accepting unicode characters");
		System.out.println("surname field is accepting unicode characters");
		ZephyrScale.updateTestExecutionStatus("AAT-T154", "Pass");
		Assert.assertNotEquals(actulaValue, inputvalue);
		ZephyrScale.updateTestExecutionStatus("AAT-T154", "Fail");
	}
	
	@Test(dependsOnMethods = "verifySurnameFieldRejectingUnicodesCharacters", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	//@Test
	public void verifysurnameFieldWithMixedCases() throws Exception {
		try {
			Assert.assertTrue(app_open.checkSurnameFieldWithMixedCases(), "surname field is not accepting mixed cases");
			//app_open.checkSurnameFieldWithMixedCases();
			System.out.println("surname field is accepting mixed cases");
			ZephyrScale.updateTestExecutionStatus("AAT-T155", "Pass");
		} catch (AssertionError e) {
			Assert.assertFalse(app_open.checkSurnameFieldWithMixedCases());
			System.out.println("Assertion error "+e.getMessage());
			ZephyrScale.updateTestExecutionStatus("AAT-T155", "Fail");
		}
		catch (Exception e) {
			System.out.println("exception error "+ e.getMessage());
			ZephyrScale.updateTestExecutionStatus("AAT-T155", "Fail");
		}
	}
	
	@Test(dependsOnMethods = "verifysurnameFieldWithMixedCases", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	public void verifyNumbersInSurnameField() throws Exception {
		String inputvalue = "Alex123";
		
		app_open.entersurname(inputvalue);
		
		String actualValue = app_open.getsurnameFieldValue();
		Assert.assertNotEquals(actualValue, inputvalue, "surname field is accepting numbers");
		System.out.println("surname field is not accepting numbers");
		ZephyrScale.updateTestExecutionStatus("AAT-T156", "Pass");
		Assert.assertEquals(actualValue, inputvalue);
		ZephyrScale.updateTestExecutionStatus("AAT-T156", "Fail");
	}
	
	@Test(dependsOnMethods = "verifyNumbersInSurnameField", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	public void verifySurnameFieldWithOnlySpaces() {
		try {
			app_open.checkSurnameFieldWithOnlySpaces();
			ZephyrScale.updateTestExecutionStatus("AAT-T157", "Pass");
		} catch (AssertionError e) {
			// TODO: handle exception
			System.out.println("test fails due to assertion error"+ e.getMessage());
			ZephyrScale.updateTestExecutionStatus("AAT-T157", "Fail");
			throw e;
		}catch (Exception e) {
			System.out.println("test fail due to exception error"+ e.getMessage());
			ZephyrScale.updateTestExecutionStatus("AAT-T157", "Fail");
		}
	}
	
	@Test(dependsOnMethods = "verifySurnameFieldWithOnlySpaces", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	public void VerifySurnameFieldCaseInsensitivityfor_Uniqueness() {
		boolean passed = false; // Initialize the result flag

	    try {
	        passed = app_open.checkSurnameFieldCaseSensitive(); // Assign the test outcome
	        Assert.assertTrue(passed, "Surname field is not handling only spaces correctly.");
	        System.out.println("Surname field is handling only spaces correctly.");
	    } catch (AssertionError e) {
	        System.err.println("Test failed due to assertion error: " + e.getMessage());
	        passed = false; // Ensure the test is marked as failed
	        throw e; // Rethrow the error for visibility
	    } catch (Exception e) {
	        System.err.println("Test failed due to exception: " + e.getMessage());
	        passed = false; // Ensure the test is marked as failed
	    } finally {
	        // Use the passed flag to dynamically update test execution status
	        String testResult = passed ? "Pass" : "Fail";
	        ZephyrScale.updateTestExecutionStatus("AAT-T158", testResult);
	    }
	}
	
	@Test(dependsOnMethods = "VerifySurnameFieldCaseInsensitivityfor_Uniqueness", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	public void verifySurnameFieldwithSpacesBetweenCharacters() {
		boolean passed = false;
		try{
			String inputValue = "Veera venkata sathyanarayana chary";
		
			app_open.entersurname(inputValue);
			String actualValue = app_open.getsurnameFieldValue();
			Assert.assertEquals(actualValue, inputValue, "surname field is not accepting spaces between characters");
			System.out.println("surname field is accepting spaces between characters");
			passed = true;
		} catch (AssertionError e) {
			System.out.println("Test fail due to assertion error"+ e.getMessage());
			passed = false;
		}catch (Exception e) {
			System.out.println("Test fail due to excetion error" + e.getMessage());
			passed = false;
		}finally {
			String testResults = passed ? "Pass" : "Fail";
			ZephyrScale.updateTestExecutionStatus("AAT-T159", testResults);
			//updateTestStatus("AAT-T159", passed);
		}
		
	}
	
	@Test(dependsOnMethods = "verifySurnameFieldwithSpacesBetweenCharacters", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	public void verifySurnameFieldwithInitials() {
		try {
			Assert.assertTrue(app_open.checksurnameWithIntials(), "surname field is not accepting intials");
			System.out.println("surname field is accepting intials");
			ZephyrScale.updateTestExecutionStatus("AAT-T160", "Pass");
		} catch (AssertionError e) {
			System.out.println("test fail due to assertion error"+e.getMessage());
			ZephyrScale.updateTestExecutionStatus("AAT-T160", "Fail");
			//Assert.fail();
			throw e;
		}catch (Exception e) {
			System.out.println("test fail due to exception error "+e.getMessage());
			ZephyrScale.updateTestExecutionStatus("AAT-T160", "Fail");
			throw e;
		}
	}
	
	@Test(dependsOnMethods = "verifySurnameFieldwithInitials", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	public void verifyCharacterLimitInSurnameField() {
		try {
		app_open.checkSurnameFieldCharacterLimit();
		ZephyrScale.updateTestExecutionStatus("AAT-T162", "Pass");
		}
		catch (AssertionError e) {
            System.out.println("Test failed due to assertion error: " + e.getMessage());
            ZephyrScale.updateTestExecutionStatus("AAT-T162", "Fail"); // Update Zephyr Scale as Fail
            throw e; // Rethrow to ensure TestNG marks the test as failed
        } catch (Exception e) {
            System.out.println("Test failed due to an unexpected error: " + e.getMessage());
            ZephyrScale.updateTestExecutionStatus("AAT-T162", "Fail"); // Update Zephyr Scale as Fail
            throw e; // Rethrow for visibility
        }
	}
	
	@Test(dependsOnMethods = "verifyCharacterLimitInSurnameField", alwaysRun = true, retryAnalyzer = RetryFailedTest.class)
	public void verifyUsernameFieldPresence() {
		try {
		Assert.assertTrue(app_open.checkUsernamePresence(), "username is not present on the screen");
		System.out.println("username field is present on the screen");
		ZephyrScale.updateTestExecutionStatus("AAT-T163", "Pass");
		} catch (AssertionError e) {
		Assert.assertFalse(app_open.checkUsernamePresence());
		ZephyrScale.updateTestExecutionStatus("AAT-T163", "Fail");
		}catch (Exception e) {
			ZephyrScale.updateTestExecutionStatus("AAT-T163", "Fail");
		}
	}
	
	
//	@Parameters({"name", "surname", "password", "confirmPassword", "selectDOB"})
//	//@Test
//	@Test(dependsOnMethods = "verifyNumbersAreRejected", alwaysRun = true)
	public void isSignupSuccess(String enter_name, String enter_surname, String enter_password, String enter_confirmPassword, String selectDOB) throws InterruptedException, ParseException {
		
		//app_open.enterDetails(enter_name, enter_surname, enter_password, enter_confirmPassword, selectDOB);
		
		if(!enter_password.equals(enter_confirmPassword)) {
			app_open.validatePasswordMismatchErrorMessage();
		}
		else {
			
		String confirmationMessage = app_open.checkConfirmationMessage();
		String expectedConfirmationMessage = "To recover Username/password in future,name/surname/dob/mobile-number needs to be same as entered during sign-up";
		assertEquals(confirmationMessage, expectedConfirmationMessage, "Confrimation message did not match.");
		
		boolean signupPageHeaderDisplayed = app_open.clickEditbuttonAndCheck_signUpPage();
		assertTrue(signupPageHeaderDisplayed, "sign up page is not displaying after click edit button");
		System.out.println("sign up page is displaying after click edit button");
		
		app_open.clickAgreeandContinueButton();
		String confirmationMessage1 = app_open.checkConfirmationMessage();
		assertEquals(confirmationMessage1, "", "Confrimation message did not match.");
		
		boolean isCongratulationsMessageDisplayed = app_open.validateCongratulationMessage();
//		Assert.assertTrue(isCongratulationsMessageDisplayed, "congratulation message is not displayed after click ok button on confirmation message");
//		System.out.println("congratulation message is displayed after click ok button on confirmation message");
		Assert.assertTrue(isCongratulationsMessageDisplayed, "sign up is not success");
		System.out.println("sign up success");
		
		boolean isJoinGroupPageDisplayed = app_open.clickOkButtonvalidateJoinGroupPage();
		Assert.assertTrue(isJoinGroupPageDisplayed, "join group page is not displayed after click ok button on congratulations pop up window");
		System.out.println("join group page is displayed after click ok button on confirmation pop up window");
		
		boolean ischatTabDisplayed = app_open.clickSkipButtonAndCheckChatTab();
		Assert.assertTrue(ischatTabDisplayed, "chat tab is not displayed after click skip button on join group page");
		System.out.println("chat tab is dislayed after click skip button on join group page");
		}
	}
	
//	@AfterMethod
//    public void updateResult(java.lang.reflect.Method method) throws IOException {
//        String testKey = "AAT-169"; // Replace with actual Xray test key
//
//        // Determine test status
//        String status = "PASS";
//        if (!method.getAnnotation(Test.class).expectedExceptions().equals(null)) {
//            status = "FAIL";
//        }
//
//        // Send result to Xray
//        XrayIntegration.updateXrayTestResult(testKey, status);
//    }
	
	@AfterMethod
	public void closeApp() throws InterruptedException {
		if(driver != null) {
		driver.quit();
		//driver.resetApp(); // Resets app state without closing the session
		Thread.sleep(1000);
		System.out.println("driver quit successfully");
		driver = null;
		}
	}
	
//	@AfterTest
//	public void tearDown() {
//	    if (driver != null) {
//	        driver.quit();
//	        System.out.println("Driver session ended successfully.");
//	    }
//	}

}
