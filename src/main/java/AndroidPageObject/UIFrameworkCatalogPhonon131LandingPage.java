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

    @AndroidFindBy(xpath = "")
    private WebElement PopoversBtn;

    //***************************************************************************************************
    @Step("Step: Click CheckBox Button Of Landing Page In The Phonon 1.3.1 Framework")
    @Severity(SeverityLevel.NORMAL)
    public  void Phonon131Popovers(){
        Allure.step("Popovers Button Clicked");
        PopoversBtn.click();
        Assert.assertTrue(PopoversBtn.isSelected(), "Popovers is not selected after click");
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Button Is Clicked.");

    }


}
