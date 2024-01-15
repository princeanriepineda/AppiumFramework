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

public class UIFrameworkCatalogFramework7Material140LandingPage extends AndroidActions {
    AndroidDriver driver;

    public UIFrameworkCatalogFramework7Material140LandingPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Login Screen \"]")
    private WebElement LoginScreenBtn;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Forms \"]")
    private WebElement FormsBtn;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Popover \"]")
    private WebElement PopoverBtn;

    //***************************************************************************************************
    @Step("Step: Click Login Screen Button Of Landing Page In The UIFramework 7 Material 1.4.0 Landing Page")
    @Severity(SeverityLevel.NORMAL)
    public  void UIFramework7Material140LoginScreen() throws InterruptedException {
        Allure.step("Login Screen Button Clicked");
        Assert.assertTrue(LoginScreenBtn.isEnabled(), "Login Screen is not enabled");
        LoginScreenBtn.click();
        Thread.sleep(1000);
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Button Is Clicked.");

    }

    //***************************************************************************************************
    @Step("Step: Click Forms Button Of Landing Page In The UIFramework 7 Material 1.4.0 Landing Page")
    @Severity(SeverityLevel.NORMAL)
    public  void UIFramework7Material140Forms(){
        Allure.step("Forms Button Clicked");
        Assert.assertTrue(FormsBtn.isEnabled(), "Forms is not enabled");
        FormsBtn.click();
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Button Is Clicked.");

    }

    //***************************************************************************************************
    @Step("Step: Click Forms Button Of Landing Page In The UIFramework 7 Material 1.4.0 Landing Page")
    @Severity(SeverityLevel.NORMAL)
    public  void UIFramework7Material140Popover(){
        Allure.step("Popover Button Clicked");
        Assert.assertTrue(PopoverBtn.isEnabled(), "Popover is not enabled");
        PopoverBtn.click();
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Button Is Clicked.");

    }
}
