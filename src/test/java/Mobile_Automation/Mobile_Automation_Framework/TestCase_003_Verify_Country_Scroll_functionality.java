package Mobile_Automation.Mobile_Automation_Framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.FormPage;

public class TestCase_003_Verify_Country_Scroll_functionality extends TestBase {
	
	
	@Test
	public void Country_Dynamic_Scroll_functionality() throws InterruptedException, IOException {

		AndroidDriver<AndroidElement> driver = Capabilities("APPLICATION_UNDER_TEST");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		FormPage formPage = new FormPage(driver);

		formPage.getNameField().sendKeys("hello");
		driver.hideKeyboard();

		formPage.femaleOption.click();

		formPage.getcountrySelection().click();
		Utilities u = new Utilities(driver);
		u.scrollToText("Canada");
	
	}	

}