package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Base;
import pages.Scrolling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class YouTube extends Base {
    public AndroidDriver driver;
    Scrolling scroll;
    @BeforeClass
    public void setUp() throws IOException {
        driver = initializeDriver();
        scroll = new Scrolling(driver);
    }
    @Test
    public void searchYT() throws InterruptedException {
        Thread.sleep(3000);
        scroll.swipe(driver, Scrolling.DIRECTION.DOWN,1);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"YouTube\")").click();
        driver.findElementById("com.google.android.youtube:id/menu_search").click();
        //driver.findElementById("com.google.android.youtube:id/search_edit_text").sendKeys("mars mission");
        driver.getKeyboard().sendKeys("mars missio.");
        driver.pressKeyCode(67);
        driver.getKeyboard().sendKeys("mars mission");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    @Test
    public void titleName() throws InterruptedException {
        Thread.sleep(3000);
        scroll.swipe(driver, Scrolling.DIRECTION.DOWN,1);
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"YouTube\")").click();
        List<WebElement> title = driver.findElementsById("com.google.android.youtube:id/title");
        ArrayList<String> titleName = new ArrayList<>();
        for(int j=0;j<5;j++) {
            for(int i=0;i<title.size();i++) {
                titleName.add(title.get(i).getText());
            }
            scroll.swipe(driver, Scrolling.DIRECTION.DOWN,1);
        }
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(titleName);
        ArrayList<String> titleWithoutDuplicates = new ArrayList<>(hashSet);
        System.out.println(titleWithoutDuplicates.size());
        //System.out.println(titleWithoutDuplicates);
        for(String name : titleWithoutDuplicates) {
            System.out.println(name);
        }
    }
}
