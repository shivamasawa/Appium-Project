package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Base;
import pages.Scrolling;

import java.io.IOException;
import java.net.MalformedURLException;

public class DialerApp extends Base {
    public AndroidDriver driver;
    Scrolling scroll;
    @BeforeClass
    public void setUp() throws IOException {
        driver = initializeDriver();
        scroll = new Scrolling(driver);
    }
    @Test
    public void CreateContact() throws InterruptedException {
        scroll.swipe(driver, Scrolling.DIRECTION.RIGHT, 1);
        scroll.swipe(driver, Scrolling.DIRECTION.RIGHT, 1);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Create new contact\")").click();
        //driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"First\")").sendKeys(prop.getProperty("firstname"));
        //driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Last\")").sendKeys(prop.getProperty("lastname"));
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Phone\")").sendKeys(prop.getProperty("phone"));
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Email\")").sendKeys(prop.getProperty("email"));
        driver.findElementById("com.android.contacts:id/editor_menu_save_button").click();
    }
    @Test
    public void DialNumber() {
        driver.findElementById("floating_action_button").click();
        driver.findElementById("digits").sendKeys(prop.getProperty("number"));
        driver.findElementById("dialpad_floating_action_button").click();
    }
}
