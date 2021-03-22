package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Products_Page {

	public Products_Page(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
	private WebElement WB_Add_To_Cart;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement WB_App_Cart;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productImage")
	public List<WebElement> productImages;

	public WebElement getAdd_To_Cart() {
		System.out.println("Clicking on Add_To_Cart");
		return WB_Add_To_Cart;
	}

	public WebElement getApp_Cart() {
		System.out.println("Clicking on App_Cart");
		return WB_App_Cart;
	}

	public List<WebElement> getproductImages() {

		return productImages;
	}

}
