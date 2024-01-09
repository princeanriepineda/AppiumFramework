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


public class UIFrameworkCatalogLandingPage extends AndroidActions {

    AndroidDriver driver;

    public UIFrameworkCatalogLandingPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath="")
    private WebElement Framework7Material140Btn;

    @AndroidFindBy(xpath="")
    private WebElement Framework7iOS140Btn;

    @AndroidFindBy(xpath="")
    private WebElement OnsenUI200Btn;

    @AndroidFindBy(xpath="")
    private WebElement OnsenUI1314Btn;

    @AndroidFindBy(xpath="")
    private WebElement Phonon131Btn;

    @AndroidFindBy(xpath="")
    private WebElement jQueryMobile145Btn;

    @AndroidFindBy(xpath="")
    private WebElement AppJsAndroid305Btn;

    @AndroidFindBy(xpath="")
    private WebElement AppJsIOS305Btn;

    @Step("Step: Framework Selection In Landing Page")
    @Severity(SeverityLevel.NORMAL)
    public void SelectFramework(String framework) throws InterruptedException {
        driver.wait(1000);
        Allure.step("Clicked Framework Selection");
        if(framework.equalsIgnoreCase("Framework7 Material 1.4.0")){
            String FrameworkText = Framework7Material140Btn.getText();
            Framework7Material140Btn.click();
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"Framework7 Material 1.4.0","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }

        //********************************************************************************************************
        else if(framework.equalsIgnoreCase("Framework7 iOS 1.4.0")){
            String FrameworkText = Framework7iOS140Btn.getText();
            Framework7iOS140Btn.click();
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"Framework7 iOS 1.4.0","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }

        //********************************************************************************************************
        else if(framework.equalsIgnoreCase("OnsenUI 2.0.0 beta5")){
            String FrameworkText = OnsenUI200Btn.getText();
            OnsenUI200Btn.click();
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"OnsenUI 2.0.0 beta5","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }

        //********************************************************************************************************
        else if(framework.equalsIgnoreCase("OnsenUI 1.3.14")){
            String FrameworkText = OnsenUI1314Btn.getText();
            OnsenUI1314Btn.click();
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"OnsenUI 1.3.14","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }

        //********************************************************************************************************
        else if(framework.equalsIgnoreCase("Phonon 1.3.1")){
            String FrameworkText = Phonon131Btn.getText();
            Phonon131Btn.click();
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"Phonon 1.3.1","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }

        //********************************************************************************************************
        else if(framework.equalsIgnoreCase("jQuery Mobile 1.4.5")){
            String FrameworkText = jQueryMobile145Btn.getText();
            jQueryMobile145Btn.click();
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"jQuery Mobile 1.4.5","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }

        //********************************************************************************************************
        else if(framework.equalsIgnoreCase("App.js Android 3.0.5")){
            String FrameworkText = AppJsAndroid305Btn.getText();
            AppJsAndroid305Btn.click();
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"App.js Android 3.0.5","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }

        //********************************************************************************************************
        else if(framework.equalsIgnoreCase("App.js iOS 3.0.5")){
            String FrameworkText = AppJsIOS305Btn.getText();
            AppJsIOS305Btn.click();
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"App.js iOS 3.0.5","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }


    }


}
