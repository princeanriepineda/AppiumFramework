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

public class UIFrameworkCatalogjQueryMobile145LandingPage extends AndroidActions {

    AndroidDriver driver;

    public UIFrameworkCatalogjQueryMobile145LandingPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"Checkbox \"]")
    private WebElement CheckBoxBtn;

    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"Radio buttons \"]")
    private WebElement RadioButtonsBtn;

    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"Forms \"]")
    private WebElement FormsBtn;

    //***************************************************************************************************
    @Step("Step: Click CheckBox Button Of Landing Page In The jQuery Mobile 1.4.5 Framework")
    @Severity(SeverityLevel.NORMAL)
    public  void jQueryMobile145CheckBox() throws InterruptedException {
        Allure.step("CheckBox Button Clicked");
        Assert.assertTrue(CheckBoxBtn.isEnabled(), "CheckBox is not Enabled");
        CheckBoxBtn.click();
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Button Is Clicked.");

    }

    //***************************************************************************************************
    @Step("Step: Click RadioButtons Button Of Landing Page In The jQuery Mobile 1.4.5 Framework")
    @Severity(SeverityLevel.NORMAL)
    public  void jQueryMobile145RadioButtons(){
        Allure.step("RadioButtons Button Clicked");
        Assert.assertTrue(RadioButtonsBtn.isEnabled(), "RadioButtons is not Enabled");
        RadioButtonsBtn.click();
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Button Is Clicked.");

    }

    //***************************************************************************************************
    @Step("Step: Click Forms Button Of Landing Page In The jQuery Mobile 1.4.5 Framework")
    @Severity(SeverityLevel.NORMAL)
    public  void jQueryMobile145Forms(){
        Allure.step("Forms Button Clicked");
        Assert.assertTrue(FormsBtn.isEnabled(), "Forms is not Enabled");
        FormsBtn.click();
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Button Is Clicked.");

    }

}
