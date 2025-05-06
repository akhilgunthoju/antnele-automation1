package pom_files;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.BaseTest;
import io.appium.java_client.MobileElement;

public class Message_TickMark_POM extends BaseTest{

	//WebDriverWait wait = new WebDriverWait(driver, 15);
	private WebDriverWait wait;
	
	@FindBy(xpath="//android.widget.EditText[@text=\"Username\"]")
	private WebElement usernameField;
	
	@FindBy(xpath="//android.widget.EditText[@text=\"Password\"]")
	private WebElement passwordField;
	
	@FindBy(xpath="//android.widget.Button[@text=\"SIGN IN\"]")
	private WebElement submitButton;
	
	@FindBy(xpath="//android.widget.Button[@text=\"Allow\"]")
	private WebElement allowButton;
	
	@FindBy(xpath="//android.widget.Button[@text=\"Allow all\"]")
	private WebElement allowAllButton;
	
	@FindBy(xpath="//android.widget.Button[@text=\"While using the app\"]")
	private WebElement whileUsingAppButton;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Chat\"]")
	private WebElement chatTab;
	
	@FindBy(xpath="(//android.widget.LinearLayout[@resource-id=\"com.antnele:id/mainView\"])[1]/android.widget.RelativeLayout")
	private WebElement firstChat;
	
	@FindBy(xpath="//android.widget.EditText[@text=\"Type your message\"]")
	private WebElement messageTextBox;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.antnele:id/button_chatbox_send\"]")
	private WebElement sendButton;
	
	@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.antnele:id/deliveryStatus\"])")
	private WebElement singleTickMark;
	
	@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.antnele:id/deliveryStatus\"])[5]")
	private WebElement doubleTickMark;
	
	@FindBy(xpath="(//android.widget.ImageView[@resource-id=\"com.antnele:id/deliveryStatus\"])[4]")
	private WebElement doubleTickWithOrange;
	
//	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.antnele:id/deliveryStatus']")
//    private List<MobileElement> tickMarks;
	
	public Message_TickMark_POM() {
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 15);
	}
	
	public boolean navigateToChatScreen(String enter_username, String enter_password) throws InterruptedException {
		SignIn_POM signInPage = new SignIn_POM();
		signInPage.navigateToSignInWithoutMobilePage();
		
		usernameField.sendKeys(enter_username);
		passwordField.sendKeys(enter_password);
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();;
		//submitButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(allowButton)).click();;
		//allowButton.click();
		
		
		return chatTab.isDisplayed();
		
	}
	
	public void clickChat() {
		firstChat.click();
		if(whileUsingAppButton.isDisplayed()) 
		{
		whileUsingAppButton.click();
		allowButton.click();
		//allowAllButton.click();
		allowButton.click();
		}
	}
	
	public void sendMessage(String message) {
		messageTextBox.click();
		messageTextBox.sendKeys(message);
		wait.until(ExpectedConditions.elementToBeClickable(sendButton)).click();;
		//sendButton.click();
	}
	
	public boolean isSingleTickDisplayed() {
		
//		try {
//	        System.out.println("🔍 Fetching all tick mark elements...");
//
//	        // Find all tick marks
	        List<MobileElement> tickMarks = driver.findElements(By.xpath("//android.widget.ImageView[@resource-id='com.antnele:id/deliveryStatus']"));
//
//	        if (tickMarks.isEmpty()) {
//	            System.out.println("⚠️ No tick marks found!");
//	            return false;
//	        }
//
//	        // Get the last tick mark
//	        WebElement lastTickMark = tickMarks.get(tickMarks.size() - 1);
//	        System.out.println("🟢 Last tick mark found at index: " + (tickMarks.size() - 1));
//
//	        // Wait for visibility
//	        wait.until(ExpectedConditions.visibilityOf(lastTickMark));
//
//	        boolean isDisplayed = lastTickMark.isDisplayed();
//	        System.out.println("✅ Tick mark is displayed: " + isDisplayed);
//
//	        return isDisplayed;
//	    } catch (Exception e) {
//	        System.out.println("🚨 Error checking single tick mark: " + e.getMessage());
//	        e.printStackTrace();
//	    }
//	    return false;

		try {
            //wait.until(ExpectedConditions.visibilityOfAllElements(tickMarks));
			for (WebElement tickMark : tickMarks) {
			    wait.until(ExpectedConditions.visibilityOf(tickMark));
			}
            WebElement lastTick = tickMarks.get(tickMarks.size() - 1);
            return lastTick.isDisplayed();
        } catch (Exception e) {
            System.out.println("🚨 Error checking single tick: " + e.getMessage());
            return false;
        }
	}
	
	//Verifying double tick
	public boolean isDoubleTickDisplayed() {
//		wait.until(ExpectedConditions.visibilityOf(doubleTickMark));
//		return doubleTickMark.isDisplayed();
		List<MobileElement> tickMarks = driver.findElements(By.xpath("//android.widget.ImageView[@resource-id='com.antnele:id/deliveryStatus']"));
		try {
            //wait.until(ExpectedConditions.visibilityOfAllElements(tickMarks));
			for (WebElement tickMark : tickMarks) {
			    wait.until(ExpectedConditions.visibilityOf(tickMark));
			}
            WebElement lastTick = tickMarks.get(tickMarks.size() - 1);
            return lastTick.isDisplayed();
        } catch (Exception e) {
            System.out.println("🚨 Error checking double tick: " + e.getMessage());
            return false;
        }
	}
	
	public boolean isdoubleTickWithOrangeDisplayed() {
		List<MobileElement> tickMarks = driver.findElements(By.xpath("//android.widget.ImageView[@resource-id='com.antnele:id/deliveryStatus']"));
		try {
            //wait.until(ExpectedConditions.visibilityOfAllElements(tickMarks));
			for (WebElement tickMark : tickMarks) {
			    wait.until(ExpectedConditions.visibilityOf(tickMark));
			}
            WebElement lastTick = tickMarks.get(tickMarks.size() - 1);
            return lastTick.isDisplayed();
        } catch (Exception e) {
            System.out.println("🚨 Error checking orange double tick: " + e.getMessage());
            return false;
        }
	}
}
