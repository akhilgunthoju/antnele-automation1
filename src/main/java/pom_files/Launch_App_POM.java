package pom_files;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Launch_App_POM {
	
	private AppiumDriver driver;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.antnele:id/btn_skip\"]")
	private WebElement skipButtonElement;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Sign Up\"]")
	private WebElement signUpPageElement;
	
	public Launch_App_POM(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
	
	public void GoToSignInPage() throws InterruptedException {
		skipButtonElement.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(signUpPageElement));
		
		assertTrue(signUpPageElement.isDisplayed());
	}
}
