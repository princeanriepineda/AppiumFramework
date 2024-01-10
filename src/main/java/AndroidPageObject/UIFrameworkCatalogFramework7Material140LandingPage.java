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

    @AndroidFindBy(xpath = "")
    private WebElement LoginScreenBtn;
    @AndroidFindBy(xpath = "")
    private WebElement FormsBtn;

    //***************************************************************************************************
    @Step("Step: Click Login Screen Button Of Landing Page In The UIFramework 7 Material 1.4.0 Landing Page")
    @Severity(SeverityLevel.NORMAL)
    public  void UIFramework7Material140LoginScreen(){
        Allure.step("Login Screen Button Clicked");
        LoginScreenBtn.click();
        Assert.assertTrue(LoginScreenBtn.isSelected(), "Login Screen is not selected after click");
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Button Is Clicked.");

    }

    //***************************************************************************************************
    @Step("Step: Click Forms Button Of Landing Page In The UIFramework 7 Material 1.4.0 Landing Page")
    @Severity(SeverityLevel.NORMAL)
    public  void UIFramework7Material140Forms(){
        Allure.step("Forms Button Clicked");
        FormsBtn.click();
        Assert.assertTrue(FormsBtn.isSelected(), "Forms is not selected after click");
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Button Is Clicked.");

    }
}
