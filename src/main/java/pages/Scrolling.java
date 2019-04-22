package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class Scrolling {
    public AndroidDriver<MobileElement> driver;
    public Scrolling(AndroidDriver<MobileElement> driver){
        this.driver = driver;
    }
    public MobileElement scrollDown(MobileElement ele, String text) {
        return ((AndroidElement)ele).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                +").scrollIntoView(new UiSelector().text(\""+text+"\"));");
    }

//    public void scroll() {
//        Dimension dimension = driver.manage().window().getSize();
//        int startY = (int) (dimension.height / 2);
//        Double scrollHeightStart = dimension.getWidth() * 0.9;
//        int scrollStart = scrollHeightStart.intValue();
//
//        Double scrollHeightEnd = dimension.getWidth() * 0.05;
//        int scrollEnd = scrollHeightEnd.intValue();
//
//        new TouchAction((PerformsTouchActions)driver)
//                .press(PointOption.point(scrollStart,startY))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
//                .moveTo(PointOption.point(scrollEnd,startY))
//                .release().perform();
//    }
    public enum DIRECTION {
        UP, DOWN, LEFT, RIGHT;
}
    public static void swipe(AndroidDriver driver, DIRECTION direction, long duration) {
        Dimension size = driver.manage().window().getSize();

        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;

        switch (direction) {
            case RIGHT:
                startY = (int) (size.height / 2);
                startX = (int) (size.width * 0.9);
                endX = (int) (size.width * 0.05);
                new TouchAction((PerformsTouchActions)driver)
                        .press(PointOption.point(startX,startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
                        .moveTo(PointOption.point(endX,startY))
                        .release()
                        .perform();
                break;

            case LEFT:
                startY = (int) (size.height / 2);
                startX = (int) (size.width * 0.05);
                endX = (int) (size.width * 0.9);
                new TouchAction((PerformsTouchActions)driver)
                        .press(PointOption.point(startX,startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
                        .moveTo(PointOption.point(endX,startY))
                        .release()
                        .perform();
                break;

            case UP:
                endY = (int) (size.height * 0.8);
                startY = (int) (size.height * 0.2);
                startX = (size.width / 2);
                new TouchAction((PerformsTouchActions)driver)
                        .press(PointOption.point(startX,startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
                        .moveTo(PointOption.point(startX,endY))
                        .release()
                        .perform();
                break;

            case DOWN:
                startY = (int) (size.height * 0.8);
                endY = (int) (size.height * 0.2);
                startX = (size.width / 2);
                new TouchAction((PerformsTouchActions)driver)
                        .press(PointOption.point(startX,startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
                        .moveTo(PointOption.point(startX,endY))
                        .release()
                        .perform();
                break;
        }
    }
}
