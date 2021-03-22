package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	public FormPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@AndroidFindBy(xpath = "//*[@text='Female']")
	public WebElement femaleOption;

	@AndroidFindBy(id = "android:id/text1")
	private WebElement countrySelection;

	@AndroidFindBy(xpath = "//*[@text='Argentina']")
	public WebElement Argentina;

	@AndroidFindBy(xpath = "//android.widget.Toast[1]")
	public WebElement Blinking_Msg;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement WB_LetsShop;

	public WebElement getNameField() {
		System.out.println("trying to find the Name field");
		return nameField;
	}

	public WebElement getcountrySelection() {
		System.out.println("Selecting the option from dropdown");
		return countrySelection;
	}

	public WebElement selectcountry() {
		System.out.println("Selecting the country as Argentina");
		return Argentina;
	}

	public WebElement getLetsShopField() {
		System.out.println("Clicking on Lets Shop Button");
		return WB_LetsShop;
	}

	public WebElement Blinking_Msg() {
		System.out.println("Blinking Msg Displayed");
		return Blinking_Msg;
	}

}
