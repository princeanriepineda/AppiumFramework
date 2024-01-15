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

public class UIFrameworkCatalogOnsenUI200beta5LandingPage extends AndroidActions {
    AndroidDriver driver;

    public UIFrameworkCatalogOnsenUI200beta5LandingPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"List\"]")
    private WebElement ListBtn;

    //***************************************************************************************************
    @Step("Step: Click List Button Of Landing Page In The OnsenUI 2.0.0 beta5 Framework")
    @Severity(SeverityLevel.NORMAL)
    public  void OnsenUI200beta5List() throws InterruptedException {
        Allure.step("List Button Clicked");
        Assert.assertTrue(ListBtn.isEnabled(), "List is not enabled");
        ListBtn.click();
        Thread.sleep(2000);
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Button Is Clicked.");

    }


}
