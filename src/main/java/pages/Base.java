package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    protected static AndroidDriver driver;
    protected Properties prop;
    public AndroidDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("D:\\AppiumProject\\src\\config\\configs.properties");
        prop.load(fis);

        DesiredCapabilities cap = new DesiredCapabilities();
        // For opening Emulator "Demo"
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"100");

        // For Opening Native Mobile App without apk file
//        cap.setCapability("appPackage", "com.google.android.deskclock");      //Clock App
//        cap.setCapability("appActivity", "com.android.deskclock.DeskClock");  //Clock App
//        cap.setCapability("appPackage", "com.google.android.dialer");      //Dialer App
//        cap.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");  //Dialer App
        cap.setCapability("appPackage", "com.google.android.apps.nexuslauncher");      //Launch Mobile
        cap.setCapability("appActivity", "com.google.android.apps.nexuslauncher.NexusLauncherActivity");  //Launch Mobile
        // For opening App
        //cap.setCapability(MobileCapabilityType.APP, "D:\\AppiumProject\\src\\ApiDemos-debug.apk");
        // For connecting to server
        //AndroidDriver<WebElement> driver;
        //driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wb/hub"),cap);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        return driver;
    }
}
