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

public class UIFrameworkCatalogjQueryMobileFormsPage extends AndroidActions {

    AndroidDriver driver;

    public UIFrameworkCatalogjQueryMobileFormsPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "")
    private WebElement NativeSelectDrpDwn;

    @Step("Step: Select Drop Down Scenario list: Validate the Native Select Drop Down in the jQuery Mobile 1.4.5 Forms Page")
    @Severity(SeverityLevel.NORMAL)
    public void jQueryMobile145NativeSelectDrpdwn(String NativeSelect) {
        Allure.step("Native Select Drop Down List Selected");
        NativeSelectDrpDwn.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+NativeSelect+"\"))"));
        String itemXPath = "//android.widget.TextView[@resource-id='android:id/text1' and @text='"+NativeSelect+"']";
        WebElement listItem = driver.findElement(By.xpath(itemXPath));
        listItem.click();
        String ActualSelectedItem = listItem.getText();
        Assert.assertEquals(ActualSelectedItem,NativeSelect,"Failed in Assertion Check Values Or Synchronization!");
        Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",ActualSelectedItem);
        AndroidActions.screenshot(driver);


    }

}
