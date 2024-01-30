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

public class APIDemosSpinnerPage extends AndroidActions {
    AndroidDriver driver;

    public APIDemosSpinnerPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath="//android.widget.Spinner[@resource-id=\"io.appium.android.apis:id/spinner1\"]")
    private WebElement ColorDropDown;
    @AndroidFindBy(xpath="//android.widget.Spinner[@resource-id=\"io.appium.android.apis:id/spinner2\"]")
    private WebElement PlanetDropDown;

    //****************************************************************************
    @Step("Step: Select Drop Down list Scenario: Validate the Select Drop Down In Spinner Page")
    @Severity(SeverityLevel.NORMAL)
    public void SelectDropDownListSpinner(String Color, String Planet) throws InterruptedException {
        Allure.step("Spinner Drop Down Selection Select Color And Planet");

//        Select ColorDropDownSpinner = new Select(ColorDropDown);
//        ColorDropDownSpinner.selectByVisibleText(Color);

        ColorDropDown.click();
        WebElement ColorSelectionModal = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\""+Color+"\"]"));
        ColorSelectionModal.click();
        String ActualSelectedColorXpath = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\""+Color+"\"]";
        WebElement TargetColorActual = driver.findElement(By.xpath(ActualSelectedColorXpath));
        Assert.assertEquals(TargetColorActual.getText(),Color,"Mismatch Selcted to Actual Output");

        PlanetDropDown.click();
        WebElement PlanetSelectionModal = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\""+Planet+"\"]"));
        PlanetSelectionModal.click();
        String ActualSelectedPlanet = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\""+Planet+"\"]";
        WebElement TargetPlanetActual = driver.findElement(By.xpath(ActualSelectedPlanet));
        Assert.assertEquals(TargetPlanetActual.getText(),Planet,"Mismatch Selcted to Actual Output");


        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check DropDown" ,"Actual Color And Planet: "+TargetColorActual.getText()+" And "+TargetPlanetActual.getText());


    }
}
