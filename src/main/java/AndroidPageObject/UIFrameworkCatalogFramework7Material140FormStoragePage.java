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

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Your name\"]")
    private WebElement NameTextBox;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"E-mail\"]")
    private WebElement EmailTextBox;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"URL\"]")
    private WebElement URLTextBox;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Password\"]")
    private WebElement PasswordTextBox;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Phone\"]")
    private WebElement PhoneTextBox;
    @AndroidFindBy(xpath = "//android.widget.Spinner[@content-desc=\"Male\"]")
    private WebElement GenderModal;
    @AndroidFindBy(xpath = "//android.widget.Spinner[@content-desc=\"2014-04-30\"]")
    private WebElement BirthDateModal;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    private WebElement BirthDateSetModal;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"demoform-1\"]/android.widget.ListView/android.view.View[5]/android.view.View/android.view.View[2]/android.view.View")
    private WebElement SwitchBtn;
    @AndroidFindBy(className = "android.widget.SeekBar")
    private WebElement SliderBar;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"demoform-1\"]/android.widget.ListView/android.view.View[7]/android.view.View/android.view.View[2]/android.widget.EditText")
    private WebElement AboutMeTextBox;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"demoform-2\"]/android.widget.ListView/android.view.View[1]/android.view.View")
    private WebElement BooksCheckBox;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"demoform-2\"]/android.widget.ListView/android.view.View[2]/android.view.View")
    private WebElement MoviesCheckBox;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"demoform-2\"]/android.widget.ListView/android.view.View[3]/android.view.View")
    private WebElement FoodCheckBox;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"demoform-2\"]/android.widget.ListView/android.view.View[4]/android.view.View")
    private WebElement DrinksCheckBox;

    //***************************************************************************************************
    @Step("Step: Ajax Form Submit Scenario : Validate the Ajax Form Submit By Filling Up The Form in the Framework7Material 1.4.0 Forms Storage Page")
    @Severity(SeverityLevel.NORMAL)
    public void Framework7Material140InputDetailsFormStorage
    (String Name, String Email, String URL, String Password, String Phone, String AboutMe,
     String Gender, Integer BirthDate, String CheckBox) throws InterruptedException {
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
        String itemXPath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\""+Gender+"\"]";
        WebElement listItem = driver.findElement(By.xpath(itemXPath));
        listItem.click();
        Assert.assertEquals(GenderModal.getAttribute("text"),Gender,"Gender input does not match");

        ScrollDown();
        Thread.sleep(2000);
        ScrollDown();

        BirthDateModal.click();
        String itemdateXPath = "//android.view.View[@content-desc=\""+BirthDate+" April 2014\"]";
        WebElement dateItem = driver.findElement(By.xpath(itemdateXPath));
        dateItem.click();
        Assert.assertEquals(dateItem.getAttribute("text"),BirthDate,"BirthDate input does not match");
        BirthDateSetModal.click();


        SwitchBtn.click();
        Assert.assertTrue(SwitchBtn.isEnabled(), "Switch Btn is not enabled");

        Point initialPosition = SliderBar.getLocation();
        swipeAction(SliderBar,"left");
        Point finalPosition = SliderBar.getLocation();
        Assert.assertTrue(isSwipeActionOccurring(initialPosition, finalPosition), "Swipe action did not occur on the SliderBar");

        AboutMeTextBox.sendKeys(AboutMe);
        if(CheckBox.equalsIgnoreCase("Books")){
            Assert.assertTrue(BooksCheckBox.isEnabled(), "Books CheckBox is not enabled");
            BooksCheckBox.click();
        } else if (CheckBox.equalsIgnoreCase("Movies")) {
            Assert.assertTrue(MoviesCheckBox.isEnabled(), "Movies CheckBox is not enabled");
            MoviesCheckBox.click();
        }else if (CheckBox.equalsIgnoreCase("Food")) {
            Assert.assertTrue(FoodCheckBox.isEnabled(), "Food CheckBox is not enabled");
            FoodCheckBox.click();
        }else if (CheckBox.equalsIgnoreCase("Drinks")) {
            Assert.assertTrue(DrinksCheckBox.isEnabled(), "Drinks CheckBox is not enabled");
            DrinksCheckBox.click();
        }

        Allure.addAttachment("Validation Passed!","Refer for the ScreenShots");
        AndroidActions.screenshot(driver);


    }

}
