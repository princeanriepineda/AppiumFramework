package Base;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class Listener implements IInvokedMethodListener {

    private static AppiumDriver driver; // Use the appropriate driver type based on your setup

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            // Check if the test failed
            if (testResult.getStatus() == ITestResult.FAILURE) {
                captureScreenshot();
            }
            // Quit the driver after the test method
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @Attachment(value = "Page screenshot on failure", type = "image/png")
    private byte[] captureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Setter method to set the driver from your test class
    public static void setDriver(AppiumDriver driver) {
        Listener.driver = driver;
    }

    // Getter method to retrieve the driver from other classes
    public static AppiumDriver getDriver() {
        return driver;
    }
}
