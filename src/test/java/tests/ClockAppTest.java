package tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class ClockAppTest extends Base {
    public AndroidDriver driver;
    @BeforeClass
    public void setUp() throws IOException {
        driver = initializeDriver();
    }
    @Test
    public void Alarm() throws InterruptedException {
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ALARM\")").click();
        //Thread.sleep(3000);
        //driver.findElementById("fab").click();
        //driver.findElementByAndroidUIAutomator("new UiSelector().description(\"3\")").click();
        //driver.findElementByAndroidUIAutomator("new UiSelector().description(\"45\")").click();
        //driver.findElementById("button1").click();

        //driver.findElementByAndroidUIAutomator("new UiSelector().instance(0)").click();

        List<WebElement> alarmToggle = driver.findElementsById("onoff");
        alarmToggle.get(0).click();
    }
    @Test
    public void Stopwatch() {
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"STOPWATCH\")").click();
        WebElement sec = driver.findElementById("stopwatch_time_text");
        WebElement miliSec = driver.findElementById("stopwatch_hundredths_text");
        WebElement playBtn = driver.findElementById("fab");
        playBtn.click();
        //playBtn.click();
        if(sec.getText().equals("9")) {
            playBtn.click();
        }
    }
}
