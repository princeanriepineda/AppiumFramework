package Actions;

import Utils.AppiumUtils;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class AndroidActions extends AppiumUtils{
    AndroidDriver driver;
    public AndroidActions(AndroidDriver driver){
        this.driver=driver;}
    public void swipeAction(WebElement ele, String direction){
        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),
                "direction", "left",
                "percent", 0.75
        ));
    }
    public boolean isSwipeActionOccurring(Point initialPosition, Point finalPosition) {
        // Validate whether the x-coordinate changes after the swipe
        return initialPosition.getX() != finalPosition.getX();
    }
    public  void DragAndDrop(WebElement ele, String directionX, String directionY) throws InterruptedException {
        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "endX", 626,
                "endY", 564
        ));
        Thread.sleep(3000);
    }
    public void LongPress(WebElement ele){
        new TouchAction<>(driver)
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(ele))
                        .withDuration(Duration.ofSeconds(2)))
                .release()
                .perform();
    }
    public void ScrollDown() throws InterruptedException {
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ele+"\"))"));
        boolean canScrollMore;
        do{
            canScrollMore = (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 8.0
            ));}
        while (canScrollMore);
        Thread.sleep(2000);
    }
    public void ScrollUp() throws InterruptedException {
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ele+"\"))"));
        boolean canScrollMore;
        do{
            canScrollMore = (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("mobile: scrollGesture", ImmutableMap.of(
                            "left", 100, "top", 100, "width", 200, "height", 200,
                            "direction", "up",
                            "percent", 8.0
                    ));}
        while (canScrollMore);
        Thread.sleep(2000);
    }



    @Attachment(type = "image/png")
    public static byte[] screenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }



}
