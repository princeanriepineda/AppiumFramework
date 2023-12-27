package Actions;

import Utils.AppiumUtils;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class IOSActions extends AppiumUtils{
    IOSDriver driver;
    public IOSActions(IOSDriver driver){
        this.driver=driver;}
    public void swipeAction(WebElement ele, String direction){
        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),
                "direction", "left",
                "percent", 0.75
        ));
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
        Map<String,Object> params=new HashMap<>();
        params.put("element",((RemoteWebElement)ele).getId());
        params.put("duration",5);

        driver.executeScript("mobile:touchAndHold",params);
    }
    public void Scroll(WebElement element) throws InterruptedException {

        int startX = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int startY = element.getLocation().getY() + element.getSize().getHeight() / 2;

        int endX = startX;
        int endY = element.getLocation().getY() - element.getSize().getHeight() / 2;

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
        Thread.sleep(2000);
    }



    @Attachment(type = "image/png")
    public static byte[] screenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }



}
