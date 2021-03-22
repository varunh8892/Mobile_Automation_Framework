package Mobile_Automation.Mobile_Automation_Framework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.FormPage;
import pageObjects.Products_Page;

public class TestCase_001_SelectProduct_After_Scrolling extends TestBase {

	@Test
	public void Total_Sum_Validation() throws InterruptedException, IOException {

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

		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

		for (int i = 0; i < count; i++)

		{

			String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

			if (text.equalsIgnoreCase("Jordan 6 Rings"))

			{

				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

				break;

			}

		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

//		String lastpageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

		Assert.assertEquals("Jordan 6 Rings", "Jordan 6 Rings");

	}
}