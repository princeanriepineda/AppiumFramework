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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UIFrameworkCatalogPhonon131PopoversPage extends AndroidActions {

    AndroidDriver driver;

    public UIFrameworkCatalogPhonon131PopoversPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"SELECT\"]")
    private WebElement SelectDrpDwn;

    //***************************************************************************************************
    @Step("Step: Select Drop Down list Scenario: Validate the Select Drop Down in the Phonon 1.3.1 Popovers Page")
    @Severity(SeverityLevel.NORMAL)
    public void Phonon131SelectDrpdwn(String Select) {
        Allure.step("Phonon 1.3.1 Select Drop Down List Selected");
        SelectDrpDwn.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+Select+"\"))"));
        String itemXPath = "//android.widget.Button[@content-desc=\"ITEM 1\"]";
        WebElement listItem = driver.findElement(By.xpath(itemXPath));
        listItem.click();
        String ActualSelectedItem = listItem.getText();
        Assert.assertEquals(ActualSelectedItem,Select,"Failed in Assertion Check Values Or Synchronization!");
        Allure.addAttachment("Validation Passed! Click DropDown For Actual Value.",ActualSelectedItem);
        AndroidActions.screenshot(driver);


    }

}
