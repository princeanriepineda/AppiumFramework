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

    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"Framework7 Material 1.4.0\"]")
    private WebElement Framework7Material140Btn;

    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"Framework7 iOS 1.4.0\"]")
    private WebElement Framework7iOS140Btn;

    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"OnsenUI 2.0.0 beta5\"]")
    private WebElement OnsenUI200Btn;

    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"OnsenUI 1.3.14\"]")
    private WebElement OnsenUI1314Btn;

    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"Phonon 1.3.1\"]")
    private WebElement Phonon131Btn;

    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"jQuery Mobile 1.4.5\"]")
    private WebElement jQueryMobile145Btn;

    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"App.js Android 3.0.5\"]")
    private WebElement AppJsAndroid305Btn;

    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"App.js iOS 3.0.5\"]")
    private WebElement AppJsIOS305Btn;

    @Step("Step: Framework Selection In Landing Page")
    @Severity(SeverityLevel.NORMAL)
    public void SelectFramework(String framework) throws InterruptedException {
        Allure.step("Clicked Framework Selection");
        if(framework.equalsIgnoreCase("Framework7 Material 1.4.0")){
            String FrameworkText = Framework7Material140Btn.getAttribute("content-desc");
            Framework7Material140Btn.click();
            Thread.sleep(1000);
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"Framework7 Material 1.4.0","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }

        //********************************************************************************************************
        else if(framework.equalsIgnoreCase("Framework7 iOS 1.4.0")){
            String FrameworkText = Framework7iOS140Btn.getAttribute("content-desc");
            Framework7iOS140Btn.click();
            Thread.sleep(1000);
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"Framework7 iOS 1.4.0","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }

        //********************************************************************************************************
        else if(framework.equalsIgnoreCase("OnsenUI 2.0.0 beta5")){
            String FrameworkText = OnsenUI200Btn.getAttribute("content-desc");
            OnsenUI200Btn.click();
            Thread.sleep(1000);
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"OnsenUI 2.0.0 beta5","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }

        //********************************************************************************************************
        else if(framework.equalsIgnoreCase("OnsenUI 1.3.14")){
            String FrameworkText = OnsenUI1314Btn.getAttribute("content-desc");
            OnsenUI1314Btn.click();
            Thread.sleep(1000);
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"OnsenUI 1.3.14","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }

        //********************************************************************************************************
        else if(framework.equalsIgnoreCase("Phonon 1.3.1")){
            String FrameworkText = Phonon131Btn.getAttribute("content-desc");
            Phonon131Btn.click();
            Thread.sleep(1000);
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"Phonon 1.3.1","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }

        //********************************************************************************************************
        else if(framework.equalsIgnoreCase("jQuery Mobile 1.4.5")){
            String FrameworkText = jQueryMobile145Btn.getAttribute("content-desc");
            jQueryMobile145Btn.click();
            Thread.sleep(1000);
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"jQuery Mobile 1.4.5","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }

        //********************************************************************************************************
        else if(framework.equalsIgnoreCase("App.js Android 3.0.5")){
            String FrameworkText = AppJsAndroid305Btn.getAttribute("content-desc");
            AppJsAndroid305Btn.click();
            Thread.sleep(1000);
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"App.js Android 3.0.5","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }

        //********************************************************************************************************
        else if(framework.equalsIgnoreCase("App.js iOS 3.0.5")){
            String FrameworkText = AppJsIOS305Btn.getAttribute("content-desc");
            AppJsIOS305Btn.click();
            Thread.sleep(1000);
            AndroidActions.screenshot(driver);
            Assert.assertEquals(FrameworkText,"App.js iOS 3.0.5","Failed in Assertion Check Values Or Synchronization!");
            Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",FrameworkText);
        }


    }


}
