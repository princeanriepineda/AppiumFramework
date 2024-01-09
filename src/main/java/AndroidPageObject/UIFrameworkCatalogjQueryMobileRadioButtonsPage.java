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

public class UIFrameworkCatalogjQueryMobileRadioButtonsPage extends AndroidActions {

    AndroidDriver driver;

    public UIFrameworkCatalogjQueryMobileRadioButtonsPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "your vertical xpath for RadioButton 1")
    private WebElement VerticalOneRadioButton;

    @AndroidFindBy(xpath = "your vertical xpath for RadioButton 2")
    private WebElement VerticalTwoRadioButton;

    @AndroidFindBy(xpath = "your vertical xpath for RadioButton 3")
    private WebElement VerticalThreeRadioButton;

    @AndroidFindBy(xpath = "your horizontal xpath for RadioButton 1")
    private WebElement HorizontalOneRadioButton;

    @AndroidFindBy(xpath = "your horizontal xpath for RadioButton 2")
    private WebElement HorizontalTwoRadioButton;

    @AndroidFindBy(xpath = "your horizontal xpath for RadioButton 3")
    private WebElement HorizontalThreeRadioButton;

    //***************************************************************************************************
    @Step("Step: RadioButtons Scenario: Validate the Vertical RadioButtons From 1 to 3 in the jQuery Mobile 1.4.5 Radio Button Page")
    @Severity(SeverityLevel.NORMAL)
    public void jQueryMobile145RadioButtonsVertical(){
        Allure.step("Vertical Radio Buttons Clicked");

        VerticalOneRadioButton.click();
        Assert.assertTrue(VerticalOneRadioButton.isSelected(), "RadioButton is not selected after click");
        Allure.addAttachment("Validation Passed! Check The Dropdown", "RadioButton Is Clicked.");

        VerticalTwoRadioButton.click();
        Assert.assertTrue(VerticalTwoRadioButton.isSelected(), "RadioButton is not selected after click");
        Allure.addAttachment("Validation Passed! Check The Dropdown", "RadioButton Is Clicked.");

        VerticalThreeRadioButton.click();
        Assert.assertTrue(VerticalThreeRadioButton.isSelected(), "RadioButton is not selected after click");
        Allure.addAttachment("Validation Passed! Check The Dropdown", "RadioButton Is Clicked.");

        AndroidActions.screenshot(driver);
    }

    //***************************************************************************************************
    @Step("Step: RadioButtons Scenario: Validate the Horizontal RadioButtons From 1 to 3 in the jQuery Mobile 1.4.5 Radio Button Page")
    @Severity(SeverityLevel.NORMAL)
    public void jQueryMobile145RadioButtonsHorizontal(){
        Allure.step("Horizontal Radio Buttons Clicked");

        HorizontalOneRadioButton.click();
        Assert.assertTrue(HorizontalOneRadioButton.isSelected(), "RadioButton is not selected after click");
        Allure.addAttachment("Validation Passed! Check The Dropdown", "RadioButton Is Clicked.");

        HorizontalTwoRadioButton.click();
        Assert.assertTrue(HorizontalTwoRadioButton.isSelected(), "RadioButton is not selected after click");
        Allure.addAttachment("Validation Passed! Check The Dropdown", "RadioButton Is Clicked.");

        HorizontalThreeRadioButton.click();
        Assert.assertTrue(HorizontalThreeRadioButton.isSelected(), "RadioButton is not selected after click");
        Allure.addAttachment("Validation Passed! Check The Dropdown", "RadioButton Is Clicked.");

        AndroidActions.screenshot(driver);
    }






}
