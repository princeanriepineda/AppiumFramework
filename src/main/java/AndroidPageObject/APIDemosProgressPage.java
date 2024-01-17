package AndroidPageObject;

import Actions.AndroidActions;
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

public class APIDemosProgressPage extends AndroidActions {
    AndroidDriver driver;

    public APIDemosProgressPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"1. Incremental\"]")
    private WebElement IncrementalBtn;

    //****************************************************************************
    @Step("Step: Click Incremental Btn In Incremental Page")
    @Severity(SeverityLevel.NORMAL)
    public void ClickIncremental() throws InterruptedException {
        Allure.step("Clicked Incremental Button");
        Assert.assertTrue(IncrementalBtn.isEnabled(),"Incremental Button is not enabled");
        IncrementalBtn.click();
        Thread.sleep(1000);
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check DropDown" ,"Button Clicked");


    }
}
