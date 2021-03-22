package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Cart_Checkout_Page {

	public Cart_Checkout_Page(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productList;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmount;

	@AndroidFindBy(className = "android.widget.CheckBox")
	public WebElement WC_widgetCheckBox;

	@AndroidFindBy(xpath = "//*[@text='Please read our terms of conditions']")
	public WebElement Please_read_Link;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement CloseButton;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	public WebElement ProceedButton;

	public List<WebElement> getProductList() {

		return productList;
	}

	public WebElement getwidgetCheckBox() {
		System.out.println("Clicking on CheckBox");
		return WC_widgetCheckBox;
	}

	public WebElement getpleasereadlink() {
		System.out.println("Clicking on Please_read_Link");
		return Please_read_Link;
	}

	public WebElement getCloseButton() {
		System.out.println("Clicking on Close Button");
		return CloseButton;
	}

	public WebElement getProceedButton() {
		System.out.println("Clicking on Proceed Button");
		return ProceedButton;
	}

}
