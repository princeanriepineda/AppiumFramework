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

public class UIFrameworkCatalogPhonon131LandingPage extends AndroidActions {
    AndroidDriver driver;

    public UIFrameworkCatalogPhonon131LandingPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Popovers\"]")
    private WebElement PopoversBtn;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Forms\"]")
    private WebElement FormsBtn;

    //***************************************************************************************************
    @Step("Step: Click Popovers Button Of Landing Page In The Phonon 1.3.1 Framework")
    @Severity(SeverityLevel.NORMAL)
    public  void Phonon131Popovers(){
        Allure.step("Popovers Button Clicked");
        Assert.assertTrue(PopoversBtn.isEnabled(), "Popovers is not enabled");
        PopoversBtn.click();
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Button Is Clicked.");

    }

    //***************************************************************************************************
    @Step("Step: Click Forms Button Of Landing Page In The Phonon 1.3.1 Framework")
    @Severity(SeverityLevel.NORMAL)
    public  void Phonon131Forms() throws InterruptedException {
        Allure.step("Forms Button Clicked");
        Assert.assertTrue(FormsBtn.isEnabled(), "Forms is not enabled");
        FormsBtn.click();
        Thread.sleep(2000);
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Button Is Clicked.");

    }


}
