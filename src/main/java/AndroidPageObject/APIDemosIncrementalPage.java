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

public class APIDemosIncrementalPage extends AndroidActions {

    AndroidDriver driver;

    public APIDemosIncrementalPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"io.appium.android.apis:id/increase\"]")
    private WebElement PlusBtn;
    @AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"io.appium.android.apis:id/decrease\"]")
    private WebElement MinusBtn;
    @AndroidFindBy(xpath="//android.widget.ProgressBar[@resource-id=\"io.appium.android.apis:id/progress_horizontal\"]")
    private WebElement ProgressBar;

    //****************************************************************************
    @Step("Step: Progress Bar Scenario: Validate The Progress Bar From The Plus And Minus Button In Incremental Page")
    @Severity(SeverityLevel.NORMAL)
    public void IncrementalPlusButtonProgressBar(int FinalPositionValue) throws InterruptedException {
        Allure.step("Validate Progress Bar By Clicking Plus And Minus Button");
        Assert.assertTrue(PlusBtn.isEnabled(),"Plus Button is not enabled");
        AndroidActions.screenshot(driver);
        String InitialPositionProgressBar = ProgressBar.getText();
        double doubleValue = Double.parseDouble(InitialPositionProgressBar);
        int referenceDefaultvalue = (int) doubleValue;

        if(FinalPositionValue>referenceDefaultvalue){
            for(int i=referenceDefaultvalue;FinalPositionValue>=i;i++){
                PlusBtn.click();
                Thread.sleep(1000);
                String FinalPositionProgressBar = ProgressBar.getText();
                AndroidActions.screenshot(driver);
                Assert.assertNotEquals(InitialPositionProgressBar,FinalPositionProgressBar,"Assertion Failed Match Check Values!");
                Allure.addAttachment("Validation Passed! Check First screen shot for initial position and Second screen shot for final position" ,
                        "Values of Initial and Final: "+InitialPositionProgressBar+" & "+FinalPositionProgressBar);
            }
        }else if(FinalPositionValue<referenceDefaultvalue){
            for (int i=referenceDefaultvalue;FinalPositionValue<=i;i--){
                MinusBtn.click();
                String FinalPositionProgressBar = ProgressBar.getText();
                AndroidActions.screenshot(driver);
                Assert.assertNotEquals(InitialPositionProgressBar,FinalPositionProgressBar,"Assertion Failed Match Check Values!");
                Allure.addAttachment("Validation Passed! Check First screen shot for initial position and Second screen shot for final position" ,
                        "Values of Initial and Final: "+InitialPositionProgressBar+" & "+FinalPositionProgressBar);
            }
        }else {
            System.out.println("No Action In Progress Bar By Same Input Of Default!");
        }



    }

    //****************************************************************************
    @Step("Step: Progress Bar Scenario: Validate The Progress Bar From The Minus Button In Incremental Page")
    @Severity(SeverityLevel.NORMAL)
    public void IncrementalMinusButtonProgressBar() throws InterruptedException {
        Allure.step("Validate Progress Bar By Clicking The Minus Button");
        Assert.assertTrue(PlusBtn.isEnabled(),"Minus Button is not enabled");
        AndroidActions.screenshot(driver);
        String InitialPositionProgressBar = ProgressBar.getText();
        MinusBtn.click();
        MinusBtn.click();
        MinusBtn.click();
        String FinalPositionProgressBar = ProgressBar.getText();
        AndroidActions.screenshot(driver);
        Assert.assertNotEquals(InitialPositionProgressBar,FinalPositionProgressBar,"Assertion Failed Match Check Values!");
        Allure.addAttachment("Validation Passed! Check First screen shot for initial position and Second screen shot for final position" ,
                "Values of Initial and Final: "+InitialPositionProgressBar+" & "+FinalPositionProgressBar);


    }
}
