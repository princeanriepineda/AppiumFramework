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

public class UIFrameworkCatalogjQueryMobile145RadioButtonsPage extends AndroidActions {

    AndroidDriver driver;

    public UIFrameworkCatalogjQueryMobile145RadioButtonsPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id=\"radio-choice-v-2a\"]")
    private WebElement VerticalOneRadioButton;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id=\"radio-choice-v-2b\"]")
    private WebElement VerticalTwoRadioButton;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id=\"radio-choice-v-2c\"]")
    private WebElement VerticalThreeRadioButton;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@content-desc=\"One\"]")
    private WebElement HorizontalOneRadioButton;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@content-desc=\"Two\"]")
    private WebElement HorizontalTwoRadioButton;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@content-desc=\"Three\"]")
    private WebElement HorizontalThreeRadioButton;

    //***************************************************************************************************
    @Step("Step: RadioButtons Scenario: Validate the Vertical RadioButtons From 1 to 3 in the jQuery Mobile 1.4.5 Radio Button Page")
    @Severity(SeverityLevel.NORMAL)
    public void jQueryMobile145RadioButtonsVertical(){
        Allure.step("Vertical Radio Buttons Clicked");

        VerticalThreeRadioButton.click();
        Assert.assertTrue(VerticalThreeRadioButton.isEnabled(), "RadioButton is not enabled after click");
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed For Vertical Three Radio Button! Check The Dropdown", "RadioButton Is Clicked.");

        VerticalTwoRadioButton.click();
        Assert.assertTrue(VerticalTwoRadioButton.isEnabled(), "RadioButton is not enabled after click");
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed For Vertical Two Radio Button! Check The Dropdown", "RadioButton Is Clicked.");

        VerticalOneRadioButton.click();
        Assert.assertTrue(VerticalOneRadioButton.isEnabled(), "RadioButton is not enabled after click");
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed For Vertical One Radio Button! Check The Dropdown", "RadioButton Is Clicked.");


    }

    //***************************************************************************************************
    @Step("Step: RadioButtons Scenario: Validate the Horizontal RadioButtons From 1 to 3 in the jQuery Mobile 1.4.5 Radio Button Page")
    @Severity(SeverityLevel.NORMAL)
    public void jQueryMobile145RadioButtonsHorizontal(){
        Allure.step("Horizontal Radio Buttons Clicked");

        HorizontalThreeRadioButton.click();
        Assert.assertTrue(HorizontalThreeRadioButton.isEnabled(), "RadioButton is not enabled after click");
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed For Horizontal Three Radio Button! Check The Dropdown", "RadioButton Is Clicked.");

        HorizontalTwoRadioButton.click();
        Assert.assertTrue(HorizontalTwoRadioButton.isEnabled(), "RadioButton is not enabled after click");
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed For Horizontal Two Radio Button! Check The Dropdown", "RadioButton Is Clicked.");

        HorizontalOneRadioButton.click();
        Assert.assertTrue(HorizontalOneRadioButton.isEnabled(), "RadioButton is not enabled after click");
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed For Horizontal One Radio Button! Check The Dropdown", "RadioButton Is Clicked.");


    }






}
