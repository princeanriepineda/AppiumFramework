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

public class UIFrameworkCatalogOnsenUI200beta5ListPage  extends AndroidActions {
    AndroidDriver driver;

    public UIFrameworkCatalogOnsenUI200beta5ListPage (AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.webkit.WebView[@content-desc=\"List Demo | Onsen UI\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[6]")
    private WebElement ListSwitchOneBtn;
    @AndroidFindBy(xpath = "//android.webkit.WebView[@content-desc=\"List Demo | Onsen UI\"]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[7]")
    private WebElement ListSwitchTwoBtn;

    //***************************************************************************************************
    @Step("Step: Select Drop Down list Scenario: Validate the Select Drop Down In The OnsenUI 2.0.0 beta5 Framework")
    @Severity(SeverityLevel.NORMAL)
    public  void OnsenUI200beta5ListScroll() throws InterruptedException {
        Allure.step("List Button Long Press One And Two Button And Scroll Up and Scrol Down");
        Assert.assertTrue(ListSwitchOneBtn.isEnabled(), "List 1 is not enabled");
        LongPress(ListSwitchOneBtn);
        Assert.assertTrue(ListSwitchTwoBtn.isEnabled(), "List 2  is not enabled");
        LongPress(ListSwitchTwoBtn);
        ScrollDown();
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Button Is Clicked.");

    }


}
