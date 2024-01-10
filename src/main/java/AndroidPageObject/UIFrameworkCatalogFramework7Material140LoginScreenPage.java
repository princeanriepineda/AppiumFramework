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

public class UIFrameworkCatalogFramework7Material140LoginScreenPage extends AndroidActions {

    AndroidDriver driver;

    public UIFrameworkCatalogFramework7Material140LoginScreenPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "")
    private WebElement EmbeddedIntoPageBtn;

    //***************************************************************************************************
    @Step("Step: Click Emebedded Into Page Button Of Login Screen Page In The UIFramework 7 Material 1.4.0")
    @Severity(SeverityLevel.NORMAL)
    public  void UIFramework7Material140EmebeddedIntoPage(){
        Allure.step("Emebedded Into Page Button Clicked");
        EmbeddedIntoPageBtn.click();
        Assert.assertTrue(EmbeddedIntoPageBtn.isSelected(), "Emebedded Into Page is not selected after click");
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Button Is Clicked.");

    }
}
