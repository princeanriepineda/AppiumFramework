package Base;



import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersExtentReport extends AndroidBaseTest implements ITestListener  {

    ThreadLocal<Integer> retryAttempts = new ThreadLocal<>();

    private static ThreadLocal<String> actualValueThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<String> expectedValueThreadLocal = new ThreadLocal<>();

    public static void setActualAndExpectedValues(String actualValue, String expectedValue) {
        actualValueThreadLocal.set(actualValue);
        expectedValueThreadLocal.set(expectedValue);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO: Add your code here
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO: Add your code here
        System.out.println("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO: Add your code here
        saveScreenshot(AndroidBaseTest.driver);
        saveLogs(result.getMethod().getConstructorOrMethod().getName());
        System.out.println("Test failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO: Add your code here
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        int attempts = retryAttempts.get();
        if (attempts > 0) {
            // TODO: Add your code here
            System.out.println("Test failed but within success percentage: " + result.getName());
        }
        retryAttempts.set(attempts + 1);
    }

    @Override
    public void onStart(ITestContext context) {
        // TODO: Add your code here
        System.out.println("Test suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO: Add your code here
        System.out.println("Test suite finished: " + context.getName());
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static AndroidDriver saveScreenshot(AndroidDriver screenshot) {
        return screenshot;
    }

    @Attachment(value = "Stacktrace", type = "text/plain")
    public static String saveLogs(String message) {
        return message;
    }
}


