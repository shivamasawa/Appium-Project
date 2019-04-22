package tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventMetaModifier;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Base;
import pages.Scrolling;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

import static io.appium.java_client.android.nativekey.AndroidKey.*;

public class SignupTest extends Base {
    public AndroidDriver driver;
    Scrolling scroll;
    @BeforeClass
    public void setup() throws IOException {
        driver = initializeDriver();
        scroll = new Scrolling(driver);
    }
    /*@Test
    public void signUp() {
        driver.findElementById("com.bt.bms:id/btnLogin").click();
        driver.findElementById("com.bt.bms:id/btnSignUp").click();
        List<WebElement> list = driver.findElementsByClassName("android.widget.EditText");
        list.get(0).sendKeys("Appium");
        list.get(1).sendKeys("User");
        list.get(2).sendKeys("appiumuser@gmail.com");
        list.get(3).sendKeys("Appium123");
        driver.findElementById("com.bt.bms:id/action_icon").click();
    }*/
    @Test
    public void DemoFunc() {
        List<WebElement> list = driver.findElementsById("android:id/text1");
        list.get(2).click();

        //AndroidElement list2 = (AndroidElement) driver.findElementById("android:id/list");
        //MobileElement selDemo = list2.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
        //+ "new UiSelector().text(\"Voice Recognition\"))"));
        //MobileElement selDemo = (MobileElement)driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
        //+".resourceId(\"android:id/list\")).scrollIntoView(new UiSelector().textContains(\"Service\"));");
        //selDemo.click();
        MobileElement selDemo = (MobileElement) driver.findElementById("android:id/list");
        scroll.scrollDown(selDemo, "Voice Recognition").click();


        //TouchAction action = new TouchAction(driver);
        //action.tap()
        // MobileElement me = (MobileElement) driver.findElementByClassName("");

        //driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Service\")").click();

        List<WebElement> ServiceList = driver.findElementsById("android:id/text1");
        System.out.println(ServiceList.size());
        //System.out.println(ServiceList.get(1).getText());
        for(int i=0; i<ServiceList.size(); i++) {
            System.out.println(ServiceList.get(i).getText());
        }
        //driver.pressKeyCode(AndroidKeyCode.HOME);
        driver.pressKeyCode(AndroidKeyCode.BACK);

    }
    @Test
    public void DemoMedia() throws InterruptedException {
        driver.findElementByAndroidUIAutomator(("new UiSelector().text(\"Media\")")).click();
        driver.findElementByXPath("//android.widget.TextView[@text='AudioFx']").click();
        Thread.sleep(3000);
        List<WebElement>maxLimit=driver.findElementsByXPath("//android.widget.TextView[@index='2']");
        System.out.println(maxLimit.size());
        for (int i=1; i<maxLimit.size();i++) {
            System.out.println(maxLimit.get(i).getText());
        }
    }
    @Test
    public void DemoAnimation() {
        driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Animation\")").click();
        driver.findElementById("View Flip").click();
        List<WebElement> ViewFlipEl = driver.findElementsById("android:id/text1");
        ArrayList<String> ViewFlip = new ArrayList<>();
        for(int i=0;i<ViewFlipEl.size();i++) {
            ViewFlip.add(ViewFlipEl.get(i).getText());
        }
        System.out.println(ViewFlip);
        driver.findElementById("Flip").click();
        ArrayList<String> ViewFlip2 = new ArrayList<>();
        for(int i=0;i<ViewFlipEl.size();i++) {
            ViewFlip2.add(ViewFlipEl.get(i).getText());
        }
        System.out.println(ViewFlip2);
        // Comparing ViewFlip and ViewFlip2
        Collections.sort(ViewFlip);
        Collections.sort(ViewFlip2);
        System.out.println(ViewFlip);
        System.out.println(ViewFlip2);
        boolean isEqual = ViewFlip.equals(ViewFlip2);
        System.out.println(isEqual);
    }
    @Test
    void LoaderDemo() {
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"App\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Loader\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Custom\")").click();
        List<WebElement> el = driver.findElementsById("io.appium.android.apis:id/text");
        ArrayList<String> custom = new ArrayList<>();
        for(int i=0;i<el.size();i++) {
            custom.add(el.get(i).getText());
        }
        //WebElement ele = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"YouTube\")");
        while(! el.get(el.size()-1).getText().startsWith("Y")) {
            scroll.swipe(driver, Scrolling.DIRECTION.DOWN,1);
            for(int i=0;i<el.size();i++) {
                custom.add(el.get(i).getText());
            }
        }
        //System.out.println(custom.size());
        //System.out.println(custom);
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(custom);
        ArrayList<String> customWithoutDuplicates = new ArrayList<>(hashSet);
        System.out.println(customWithoutDuplicates.size());
        //System.out.println(customWithoutDuplicates);
//        ListIterator<String> listItr = customWithoutDuplicates.listIterator();
//        while(listItr.hasNext())
//        {
//            System.out.println(listItr.next());
//        }
        for(int i=1;i<=customWithoutDuplicates.size();i++) {
            System.out.println(i+" :- "+customWithoutDuplicates.get(i-1));
        }
    }




}
