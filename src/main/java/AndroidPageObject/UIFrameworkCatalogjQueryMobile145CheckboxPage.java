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

public class UIFrameworkCatalogjQueryMobile145CheckboxPage extends AndroidActions {


    AndroidDriver driver;

    public UIFrameworkCatalogjQueryMobile145CheckboxPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath="")
    private WebElement VerticalOneCheckBox;

    @AndroidFindBy(xpath="")
    private WebElement VerticalTwoCheckBox;

    @AndroidFindBy(xpath="")
    private WebElement VerticalThreeCheckBox;

    @AndroidFindBy(xpath="")
    private WebElement HorizontalOneCheckBox;

    @AndroidFindBy(xpath="")
    private WebElement HorizontalTwoCheckBox;

    @AndroidFindBy(xpath="")
    private WebElement HorizontalThreeCheckBox;

    //***************************************************************************************************
    @Step("Step: CheckBoxes Scenario: Validate the Vertical CheckBoxes From 1 to 3 in the jQuery Mobile 1.4.5 Check Boxes Page")
    @Severity(SeverityLevel.NORMAL)
    public void jQueryMobile145CheckBoxesVertical(){
        Allure.step("Vertical Check Boxes Clicked");

        VerticalOneCheckBox.click();
        Assert.assertTrue(VerticalOneCheckBox.isSelected(), "Checkbox is not selected after click");
        Allure.addAttachment("Validation Passed! Check The Dropdown","CheckBox Is Clicked.");

        VerticalTwoCheckBox.click();
        Assert.assertTrue(VerticalTwoCheckBox.isSelected(), "Checkbox is not selected after click");
        Allure.addAttachment("Validation Passed! Check The Dropdown","CheckBox Is Clicked.");

        VerticalThreeCheckBox.click();
        Assert.assertTrue(VerticalThreeCheckBox.isSelected(), "Checkbox is not selected after click");
        Allure.addAttachment("Validation Passed! Check The Dropdown","CheckBox Is Clicked.");

        AndroidActions.screenshot(driver);

    }

    //***************************************************************************************************
    @Step("Step: CheckBoxes Scenario: Validate the Horizontal CheckBoxes From 1 to 3 in the jQuery Mobile 1.4.5 Check Boxes Page")
    @Severity(SeverityLevel.NORMAL)
    public void jQueryMobile145CheckBoxesHorizontal(){
        Allure.step("Horizontal Check Boxes Clicked");

        HorizontalOneCheckBox.click();
        Assert.assertTrue(HorizontalOneCheckBox.isSelected(), "Checkbox is not selected after click");
        Allure.addAttachment("Validation Passed! Check The Dropdown","CheckBox Is Clicked.");

        HorizontalTwoCheckBox.click();
        Assert.assertTrue(HorizontalTwoCheckBox.isSelected(), "Checkbox is not selected after click");
        Allure.addAttachment("Validation Passed! Check The Dropdown","CheckBox Is Clicked.");

        HorizontalThreeCheckBox.click();
        Assert.assertTrue(HorizontalThreeCheckBox.isSelected(), "Checkbox is not selected after click");
        Allure.addAttachment("Validation Passed! Check The Dropdown","CheckBox Is Clicked.");

        AndroidActions.screenshot(driver);
    }


}
