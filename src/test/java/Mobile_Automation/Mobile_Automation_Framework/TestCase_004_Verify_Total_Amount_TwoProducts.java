package Mobile_Automation.Mobile_Automation_Framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import pageObjects.Cart_Checkout_Page;
import pageObjects.FormPage;
import pageObjects.Products_Page;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;


public class TestCase_004_Verify_Total_Amount_TwoProducts extends TestBase {

	@Test
	public void Total_Amount_Validation_TwoProducts() throws InterruptedException, IOException {

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

		int Number_of_Products = CartCheckoutPage.getProductList().size();

		double sum = 0;

		for (int i = 0; i < Number_of_Products; i++)

		{

			String amount1 = CartCheckoutPage.getProductList().get(i).getText();

			double amount = getAmount(amount1);

			sum = sum + amount; // 280.97+116.97

		}

		System.out.println(sum + "sum of products");

		String total = CartCheckoutPage.totalAmount.getText();

		total = total.substring(1);

		double totalValue = Double.parseDouble(total);

		System.out.println(totalValue + "Total value of products");

		Assert.assertEquals(sum, totalValue);

	}

	public static double getAmount(String value)

	{

		value = value.substring(1);

		double amount2value = Double.parseDouble(value);

		return amount2value;

	}

}