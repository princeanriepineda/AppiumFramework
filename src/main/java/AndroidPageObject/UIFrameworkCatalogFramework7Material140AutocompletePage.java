package AndroidPageObject;


import Actions.AndroidActions;
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

public class UIFrameworkCatalogFramework7Material140AutocompletePage extends AndroidActions {
    AndroidDriver driver;

    public UIFrameworkCatalogFramework7Material140AutocompletePage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"autocomplete-dropdown-all\"]")
    private WebElement AllValuesDrpDown;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"autocomplete-dropdown\"]")
    private WebElement SimpleDrpDown;

    //***************************************************************************************************
    @Step("Step: Select Drop Down list Scenario: Validate the Select Drop Down In The UIFramework 7 Material 1.4.0 Autocomplete Page")
    @Severity(SeverityLevel.NORMAL)
    public  void UIFramework7Material140AutoCompleteDropDown(String Fruit){
        Allure.step("AutoComplete Drop Down ");
        Assert.assertTrue(AllValuesDrpDown.isEnabled(), "Autocomplete is not enabled");
        AllValuesDrpDown.sendKeys(Fruit);
        AllValuesDrpDown.click();
        String itemXpath = "//android.view.View[@content-desc=\""+Fruit+"\"]";
        WebElement DropDownTarget = driver.findElement(By.xpath(itemXpath));
        Assert.assertEquals(DropDownTarget.getAttribute("content-desc"),Fruit,"Mismatch in Assertion Check Values or Synchronization!");
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Search Drop Down: "+DropDownTarget.getAttribute("content-desc"));

    }

    //***************************************************************************************************
    @Step("Step: Search list Scenario: Validate the Search Drop Down In The UIFramework 7 Material 1.4.0 Autocomplete Page")
    @Severity(SeverityLevel.NORMAL)
    public  void UIFramework7Material140AutoCompleteSearch(String Fruit){
        Allure.step("AutoComplete Search Drop Down List");
        Assert.assertTrue(SimpleDrpDown.isEnabled(), "Autocomplete is not enabled");
        SimpleDrpDown.sendKeys(Fruit);
        SimpleDrpDown.click();
        String itemXpath = "//android.view.View[@content-desc=\""+Fruit+"\"]";
        WebElement DropDownTarget = driver.findElement(By.xpath(itemXpath));
        Assert.assertEquals(DropDownTarget.getAttribute("content-desc"),Fruit,"Mismatch in Assertion Check Values or Synchronization!");
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Search Drop Down: "+DropDownTarget.getAttribute("content-desc"));

    }
}
