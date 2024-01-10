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

public class UIFrameworkCatalogFramework7Material140SignInPage extends AndroidActions {

    AndroidDriver driver;

    public UIFrameworkCatalogFramework7Material140SignInPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "")
    private WebElement UsernameTextBox;
    @AndroidFindBy(xpath = "")
    private WebElement PasswordTextBox;
    @AndroidFindBy(xpath = "")
    private WebElement SignInBtn;
    @AndroidFindBy(xpath = "")
    private WebElement SignInTxtModal;
    @AndroidFindBy(xpath = "")
    private WebElement SignInOkBtnModal;

    //***************************************************************************************************
    @Step("Step: Input Form Scenario: Input Valid Username And Password And Validate Modal Messege Txt In Sign In Page Of The UIFramework 7 Material 1.4.0")
    @Severity(SeverityLevel.NORMAL)
    public  void UIFramework7Material140InputSignInDetails(String Username, String Password){
        Allure.step("Input Username And Password Details In Sign-In ");
        UsernameTextBox.sendKeys(Username);
        String ActualUsernameInput = UsernameTextBox.getAttribute("value");
        PasswordTextBox.sendKeys(Password);
        String ActualPasswordInput = PasswordTextBox.getAttribute("value");
        SignInBtn.click();
        String ActualSignInTxtmodal = SignInTxtModal.getText();
        AndroidActions.screenshot(driver);
        Assert.assertEquals(ActualSignInTxtmodal,"Username: "+Username+", password: "+Password);
        Allure.addAttachment("Username and Password Injected Check The Dropdown For Actual Values","Actual Username And Password: "+ActualUsernameInput+", "+ActualPasswordInput);

        //************************************************************************************************
        Allure.step("Click Ok Button Of The Modal");
        SignInOkBtnModal.click();

    }



}
