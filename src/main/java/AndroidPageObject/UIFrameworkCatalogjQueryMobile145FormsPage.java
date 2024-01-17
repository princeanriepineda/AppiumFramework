package AndroidPageObject;

import Actions.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class UIFrameworkCatalogjQueryMobile145FormsPage extends AndroidActions {

    AndroidDriver driver;

    public UIFrameworkCatalogjQueryMobile145FormsPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"select-native-2-button\"]")
    private WebElement NativeSelectDrpDwn;
    @AndroidFindBy(xpath = "//android.widget.SeekBar[@content-desc=\"Slider: 50\"]")
    private WebElement SeekBar;

    //***************************************************************************************************
    @Step("Step: jQuery Select Drop Down Scenario list: Validate the jQuery Native Select Drop Down in the jQuery Mobile 1.4.5 Forms Page")
    @Severity(SeverityLevel.NORMAL)
    public void jQueryMobile145NativeSelectDrpdwn(String NativeSelect) {
        Allure.step("jQuery Native Select Drop Down List Selected");
        NativeSelectDrpDwn.click();
        AndroidActions.screenshot(driver);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+NativeSelect+"\"))"));
        String itemXPath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\""+NativeSelect+"\"]";
        WebElement listItem = driver.findElement(By.xpath(itemXPath));
        listItem.click();
        String ActualSelectedItemXpath = "//android.view.View[@content-desc=\""+NativeSelect+"\"]";
        WebElement ActualSelectedItemText = driver.findElement(By.xpath(ActualSelectedItemXpath));
        String ActualSelectedItem = ActualSelectedItemText.getAttribute("content-desc");
        Assert.assertEquals(ActualSelectedItem,NativeSelect,"Failed in Assertion Check Values Or Synchronization!");
        Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",ActualSelectedItem);
        AndroidActions.screenshot(driver);


    }

    //***************************************************************************************************
    @Step("Step: jQuery Slider Scenario : Validate the jQuery Slider Bar in the jQuery Mobile 1.4.5 Forms Page")
    @Severity(SeverityLevel.NORMAL)
    public void jQueryMobile145SliderBar(int Xcoordinate, int Ycoordinate, int FinalPositionValue) throws InterruptedException {
        Allure.step("jQuery Slider Bar Moved");
        String contentDesc = SeekBar.getAttribute("content-desc");
        String numericValueString = contentDesc.replaceAll("\\D+", "");
        int InitialPositionInteger = Integer.parseInt(numericValueString);

        Thread.sleep(1000);
        DragAndDrop(SeekBar,Xcoordinate,Ycoordinate);
        AndroidActions.screenshot(driver);

        List<WebElement> seekBarsFinalPosition = driver.findElements(By.xpath("//android.widget.SeekBar[starts-with(@content-desc, 'Slider:')]"));
        for (WebElement seekBar : seekBarsFinalPosition) {
            String contentDescFinal = seekBar.getAttribute("content-desc");
            System.out.println("Final value: " + contentDescFinal);
            System.out.println("Initial Value: Slider: " + InitialPositionInteger);
            Assert.assertNotEquals(contentDescFinal,"Slider: "+InitialPositionInteger,"Value Matched! Failed! Check Final Value Allocated");
            Allure.addAttachment("Validation Passed! Slider Is Movable",
                    "Initial Position: "+InitialPositionInteger+"\n"+"Final Position: "+contentDescFinal);

        }



    }

}
