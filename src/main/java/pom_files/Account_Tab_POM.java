package pom_files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import automation.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Account_Tab_POM extends BaseTest {
	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	@FindBy(xpath="//android.widget.FrameLayout[@content-desc=\"Account\"]")
	private WebElement accountTab;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Account\"]")
	private WebElement accountPageHeader;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Profile\"]")
	private WebElement profileTab;
	
	@FindBy(xpath="//android.widget.Button[@text=\"While using the app\"]")
	private WebElement whileUsingApp;
	
	@FindBy(xpath="//android.widget.Button[@text=\"Allow\"]")
	private WebElement allowButton;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Profile\"]")
	private WebElement profilePage;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.antnele:id/imgCamera\"]" )
	private WebElement cameraICon;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Gallery\"]")
	private WebElement selectGallery;
	
	@FindBy(xpath="//android.widget.ImageButton[@content-desc=\"Show roots\"]")
	private WebElement threeLinesOnGallery;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Downloads\"]")
	private WebElement downloadOption;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.google.android.documentsui:id/icon_thumb\"]")
	private WebElement selectImage;
	
	@FindBy(xpath="//android.widget.Button[@text=\"DONE\"]")
	private WebElement doneButton;
	
	@FindBy(xpath="//android.widget.Button[@text=\"OK\"]")
	private WebElement oKButtonAfterUpdate;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.antnele:id/imgProfileThumbnail\"]")
	private WebElement currentProfilePic;
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id=\"com.antnele:id/imgProfileThumbnail\"]")
	private WebElement imageAfterUploading;

	public Account_Tab_POM(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 15);
	}
	
	public boolean clickAccountTabAndCheck_accountPage() {
		accountTab.click();
		return accountPageHeader.isDisplayed();
	}
	
	public boolean clickprofileTab_And_CheckProfilePage() {
		profileTab.click();
		whileUsingApp.click();
		allowButton.click();
		allowButton.click();
		return profilePage.isDisplayed();
	}
	
	public void isupdateProfilePicture() {
		String beforeuploadImegeElement = currentProfilePic.getAttribute("content-desc");
		System.out.println("Before upload image: "+ beforeuploadImegeElement);
		cameraICon.click();
		selectGallery.click();
		//threeLinesOnGallery.click();
		//downloadOption.click();
		selectImage.click();
		doneButton.click();
		oKButtonAfterUpdate.click();
		
		String afterUploadImage = imageAfterUploading.getAttribute("content-desc");
		System.out.println("after upload image: "+ afterUploadImage);
		Assert.assertEquals(beforeuploadImegeElement, afterUploadImage, "profile picture update successfully");
		System.out.println("profile picture update is failed");
	}
}
