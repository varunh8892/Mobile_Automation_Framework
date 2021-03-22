package Mobile_Automation.Mobile_Automation_Framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.FormPage;
import pageObjects.Products_Page;

public class TestCase_002_Verify_Product_Images extends TestBase {

	@Test
	public void Verify_Product_Images() throws InterruptedException, IOException {

		AndroidDriver<AndroidElement> driver = Capabilities("APPLICATION_UNDER_TEST");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		FormPage formPage = new FormPage(driver);
		Products_Page productspage = new Products_Page(driver);

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

		int Total_No_Products_On_Screen = productspage.productImages.size();

		System.out.println("Total Number of Product Images on the screen is " + Total_No_Products_On_Screen);

		Assert.assertEquals(2, Total_No_Products_On_Screen);

	}
}