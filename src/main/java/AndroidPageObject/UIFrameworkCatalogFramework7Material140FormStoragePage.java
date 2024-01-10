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
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UIFrameworkCatalogFramework7Material140FormStoragePage extends AndroidActions {
    AndroidDriver driver;

    public UIFrameworkCatalogFramework7Material140FormStoragePage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "")
    private WebElement NameTextBox;
    @AndroidFindBy(xpath = "")
    private WebElement EmailTextBox;
    @AndroidFindBy(xpath = "")
    private WebElement URLTextBox;
    @AndroidFindBy(xpath = "")
    private WebElement PasswordTextBox;
    @AndroidFindBy(xpath = "")
    private WebElement PhoneTextBox;
    @AndroidFindBy(xpath = "")
    private WebElement GenderModal;
    @AndroidFindBy(xpath = "")
    private WebElement BirthDateModal;
    @AndroidFindBy(xpath = "")
    private WebElement BirthDateSetModal;
    @AndroidFindBy(xpath = "")
    private WebElement SwitchBtn;
    @AndroidFindBy(xpath = "")
    private WebElement SliderBar;
    @AndroidFindBy(xpath = "")
    private WebElement AboutMeTextBox;
    @AndroidFindBy(xpath = "")
    private WebElement BooksCheckBox;
    @AndroidFindBy(xpath = "")
    private WebElement MoviesCheckBox;
    @AndroidFindBy(xpath = "")
    private WebElement FoodCheckBox;
    @AndroidFindBy(xpath = "")
    private WebElement DrinksCheckBox;

    //***************************************************************************************************
    @Step("Step: Ajax Form Submit Scenario : Validate the Ajax Form Submit By Filling Up The Form in the Framework7Material 1.4.0 Forms Storage Page")
    @Severity(SeverityLevel.NORMAL)
    public void Framework7Material140InputDetailsFormStorage
    (String Name, String Email, String URL, String Password, String Phone, String AboutMe,
     String Gender, Integer BirthDate, String CheckBox) {
        Allure.step("Framework 7 Material 1.4.0 Fiil Up Forms Storage");

        NameTextBox.sendKeys(Name);
        Assert.assertEquals(NameTextBox.getAttribute("value"), Name, "Name input does not match");

        EmailTextBox.sendKeys(Email);
        Assert.assertEquals(EmailTextBox.getAttribute("value"), Email, "Email input does not match");

        URLTextBox.sendKeys(URL);
        Assert.assertEquals(URLTextBox.getAttribute("value"), URL, "URL input does not match");

        PasswordTextBox.sendKeys(Password);
        Assert.assertEquals(PasswordTextBox.getAttribute("value"), Password, "Password input does not match");

        PhoneTextBox.sendKeys(Phone);
        Assert.assertEquals(PhoneTextBox.getAttribute("value"), Phone, "Phone input does not match");

        GenderModal.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+Gender+"\"))"));
        String itemXPath = "//android.widget.TextView[@resource-id='android:id/text1' and @text='"+Gender+"']";
        WebElement listItem = driver.findElement(By.xpath(itemXPath));
        listItem.click();
        Assert.assertEquals(GenderModal.getAttribute("value"),Gender,"Gender input does not match");

        BirthDateModal.click();
        String itemdateXPath = "//android.widget.TextView[@resource-id='android:id/text1' and @text='"+BirthDate+"']";
        WebElement dateItem = driver.findElement(By.xpath(itemdateXPath));
        dateItem.click();
        Assert.assertEquals(dateItem.getAttribute("value"),BirthDate,"BirthDate input does not match");
        BirthDateSetModal.click();


        SwitchBtn.click();
        Assert.assertTrue(SwitchBtn.isSelected(), "Switch Btn is not selected after click");

        Point initialPosition = SliderBar.getLocation();
        swipeAction(SliderBar,"left");
        Point finalPosition = SliderBar.getLocation();
        Assert.assertTrue(isSwipeActionOccurring(initialPosition, finalPosition), "Swipe action did not occur on the SliderBar");

        AboutMeTextBox.sendKeys(AboutMe);
        if(CheckBox.equalsIgnoreCase("Books")){
            BooksCheckBox.click();
            Assert.assertTrue(BooksCheckBox.isSelected(), "Books CheckBox is not selected after click");

        } else if (CheckBox.equalsIgnoreCase("Movies")) {
            MoviesCheckBox.click();
            Assert.assertTrue(MoviesCheckBox.isSelected(), "Movies CheckBox is not selected after click");

        }else if (CheckBox.equalsIgnoreCase("Food")) {
            FoodCheckBox.click();
            Assert.assertTrue(FoodCheckBox.isSelected(), "Food CheckBox is not selected after click");

        }else if (CheckBox.equalsIgnoreCase("Drinks")) {
            DrinksCheckBox.click();
            Assert.assertTrue(DrinksCheckBox.isSelected(), "Drinks CheckBox is not selected after click");

        }

        Allure.addAttachment("Validation Passed!","Refer for the ScreenShots");
        AndroidActions.screenshot(driver);


    }

}
