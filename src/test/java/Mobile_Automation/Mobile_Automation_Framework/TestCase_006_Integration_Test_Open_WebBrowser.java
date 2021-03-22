package Mobile_Automation.Mobile_Automation_Framework;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.Cart_Checkout_Page;
import pageObjects.FormPage;
import pageObjects.Products_Page;

public class TestCase_006_Integration_Test_Open_WebBrowser extends TestBase {

	@Test
	public void Total_Sum_Validation() throws InterruptedException, IOException {

		AndroidDriver<AndroidElement> driver = Capabilities("APPLICATION_UNDER_TEST");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		FormPage formPage = new FormPage(driver);
		Products_Page productspage = new Products_Page(driver);
		Cart_Checkout_Page CartCheckoutPage = new Cart_Checkout_Page(driver);

		formPage.getNameField().sendKeys("hello");
		driver.hideKeyboard();

		formPage.femaleOption.click();

		formPage.getcountrySelection().click();
		Utilities u = new Utilities(driver);
		u.scrollToText("Argentina");

		formPage.selectcountry().click();

		u.WaitforPageLoad();

		formPage.getLetsShopField().click();

		u.WaitforPageLoad();

		productspage.getAdd_To_Cart().click();

		u.WaitforPageLoad();

		productspage.getAdd_To_Cart().click();
		u.WaitforPageLoad();

		productspage.getApp_Cart().click();

		u.WaitforPageLoad();

		TouchAction t = new TouchAction(driver);
		
		u.WaitforPageLoad();

		t.tap(tapOptions().withElement(element(CartCheckoutPage.getwidgetCheckBox()))).perform();

		u.WaitforPageLoad();
		
		WebElement tc = CartCheckoutPage.getpleasereadlink();

		u.WaitforPageLoad();
		
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();

		u.WaitforPageLoad();
		
		CartCheckoutPage.getCloseButton().click();

		u.WaitforPageLoad();
		
		CartCheckoutPage.getProceedButton().click();

	}
	
}
