package Actions;

import Utils.AppiumUtils;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;



import java.time.Duration;

public class AndroidActions extends AppiumUtils{
    AndroidDriver driver;
    public AndroidActions(AndroidDriver driver){
        this.driver=driver;}
    public void swipeAction(WebElement ele, String direction) throws InterruptedException {
        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),
                "direction", direction,
                "percent", 1.0
        ));
        Thread.sleep(2000);
    }
    public boolean isSwipeActionOccurring(Point initialPosition, Point finalPosition) {
        // Validate whether the x-coordinate changes after the swipe
        return initialPosition.getX() != finalPosition.getX();
    }
    public  void DragAndDrop(WebElement ele, int directionX, int directionY) throws InterruptedException {
        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "endX", directionX,
                "endY", directionY
        ));
        Thread.sleep(6000);
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
    public int getMonthNumber(String monthString) {
        switch (monthString.toLowerCase()) {
            case "january":
                return 1;
            case "february":
                return 2;
            case "march":
                return 3;
            case "april":
                return 4;
            case "may":
                return 5;
            case "june":
                return 6;
            case "july":
                return 7;
            case "august":
                return 8;
            case "september":
                return 9;
            case "october":
                return 10;
            case "november":
                return 11;
            case "december":
                return 12;
            default:
                throw new IllegalArgumentException("Invalid month string: " + monthString);
        }
    }




    @Attachment(type = "image/png")
    public static byte[] screenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
