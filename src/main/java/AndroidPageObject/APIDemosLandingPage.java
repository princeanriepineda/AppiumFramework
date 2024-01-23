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

public class APIDemosLandingPage extends AndroidActions {
    AndroidDriver driver;

    public APIDemosLandingPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Views\"]")
    private WebElement ViewsBtn;


    //****************************************************************************
    @Step("Step: Click Views Btn In Landing Page")
    @Severity(SeverityLevel.NORMAL)
    public void ClickViews() throws InterruptedException {
        Allure.step("Clicked Views Button");
        Assert.assertTrue(ViewsBtn.isEnabled(),"Views Button is not enabled");
        ViewsBtn.click();
        Thread.sleep(1000);
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check DropDown" ,"Button Clicked");
    }



}
