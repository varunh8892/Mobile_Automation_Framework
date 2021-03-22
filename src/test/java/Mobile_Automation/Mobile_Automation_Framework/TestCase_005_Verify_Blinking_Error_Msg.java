package Mobile_Automation.Mobile_Automation_Framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.FormPage;

public class TestCase_005_Verify_Blinking_Error_Msg extends TestBase {

	@Test
	public void Verify_Blinking_Error_Msg() throws InterruptedException, IOException {

		AndroidDriver<AndroidElement> driver = Capabilities("APPLICATION_UNDER_TEST");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		FormPage formPage = new FormPage(driver);
		formPage.femaleOption.click();

		formPage.getcountrySelection().click();
		Utilities u = new Utilities(driver);
		u.scrollToText("Argentina");

		formPage.selectcountry().click();

		u.WaitforPageLoad();

		formPage.getLetsShopField().click();

		u.WaitforPageLoad();

		String toastMessage = formPage.Blinking_Msg().getAttribute("name");

		System.out.println(toastMessage);

		Assert.assertEquals("Please enter your name", toastMessage);

	}
}
