package AndroidPageObject;

import Actions.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class APIDemosViewsPage extends AndroidActions {
    AndroidDriver driver;

    public APIDemosViewsPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Progress Bar\"]")
    private WebElement ProgressBtn;

    //****************************************************************************
    @Step("Step: Click Progress Btn In Views Page")
    @Severity(SeverityLevel.NORMAL)
    public void ClickProgress() throws InterruptedException {
        Allure.step("Clicked Progress Button");
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Progress Bar\"))"));
        Assert.assertTrue(ProgressBtn.isEnabled(),"Progress Button is not enabled");
        ProgressBtn.click();
        Thread.sleep(1000);
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check DropDown" ,"Button Clicked");


    }
}
