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

public class UIFrameworkCatalogPhonon131FormsPage extends AndroidActions {
    AndroidDriver driver;

    public UIFrameworkCatalogPhonon131FormsPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Full name\"]")
    private WebElement FullNameTxtBx;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"First Name\"]")
    private WebElement FirsNameTxtBox;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Checkbox1\"]")
    private WebElement CheckBox1;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Checkbox2\"]")
    private WebElement CheckBox2;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Radio1\"]")
    private WebElement Radio1Btn;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Checkbox2\"]")
    private WebElement Radio2Btn;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"SUBMIT\"]")
    private WebElement SubmitBtn;

    //***************************************************************************************************
    @Step("Step: Ajax Form Submit Scenario : Validate the Ajax Form Submit By Filling Up The Form in the Phonon 1.3.1 Forms Page")
    @Severity(SeverityLevel.NORMAL)
    public  void Phonon131FormsInputDetails(String FullName, String Radio) throws InterruptedException {
        Allure.step("Phonon 1.3.1 Fill Up Forms");
        Assert.assertTrue(FullNameTxtBx.isEnabled(),"Full Name Txt Box is not enabled");
        FullNameTxtBx.sendKeys(FullName);

        Assert.assertTrue(FirsNameTxtBox.isEnabled(),"First Name Txt Box is not enabled");
        FirsNameTxtBox.click();

        //FirsNameTxtBox.sendKeys("pedro@hotmail.com");

        Assert.assertTrue(CheckBox1.isEnabled(),"Check Box Button 1 is not enabled");
        CheckBox1.click();

        Thread.sleep(1000);
        Assert.assertTrue(CheckBox2.isEnabled(),"Check Box Button 2 is not enabled");
        CheckBox2.click();

        if(Radio.equalsIgnoreCase("Radio1")){
            Assert.assertTrue(Radio1Btn.isEnabled(),"Radio Button 1 is not enabled");
            Radio1Btn.click();
        }else if(Radio.equalsIgnoreCase("Radio2")){
            Assert.assertTrue(Radio2Btn.isEnabled(),"Radio Button 2 is not enabled");
            Radio2Btn.click();
        }

        AndroidActions.screenshot(driver);

        Assert.assertTrue(SubmitBtn.isEnabled(),"Submit Button is not enabled");
        SubmitBtn.click();
        Allure.addAttachment("Validation Passed! Check The Dropdown","Fill Up Is Done.");

    }

}
