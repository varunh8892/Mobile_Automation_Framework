package Mobile_Automation.Mobile_Automation_Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {

	public static AndroidDriver<AndroidElement> driver;

	public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\varun\\OneDrive\\Desktop\\Appium\\Mobile_Automation_Framework\\src\\main\\java\\Global.properties");
		Properties prop = new Properties();
		prop.load(fis);

		File appDir = new File("src");
		File app = new File(appDir, (String) prop.get(appName));

		DesiredCapabilities cap = new DesiredCapabilities();
		String device = (String) prop.get("DEVICE_NAME");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 24);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		driver = new AndroidDriver<>(new URL("http:/127.0.0.1:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void getScreenshot(String s) throws IOException {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "\\" + s + ".png"));

	}

}
