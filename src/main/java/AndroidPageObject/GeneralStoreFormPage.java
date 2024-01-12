package AndroidPageObject;

import Actions.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GeneralStoreFormPage extends AndroidActions {

    AndroidDriver driver;

    public GeneralStoreFormPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    @AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id=\"com.androidsample.generalstore:id/spinnerCountry\"]")
    private  WebElement listView;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]")
    private WebElement LetsShopBtn;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")
    private WebElement NameTextField;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")
    private WebElement GenderBtn;


        @Step("General Store Fill Up The Landing Page: Set Country Selection")
        @Severity(SeverityLevel.NORMAL)
        public void setCountrySelection(String countryName) throws InterruptedException {
            Thread.sleep(5000);
            listView.click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+countryName+"\"))"));
            String itemXPath = "//android.widget.TextView[@resource-id='android:id/text1' and @text='"+countryName+"']";
            WebElement listItem = driver.findElement(By.xpath(itemXPath));
            listItem.click();
        }
        //********************************************************************************************************************************************************
        @Step("General Store Fill Up The Landing Page: Error Login Assertion")
        @Severity(SeverityLevel.NORMAL)
        public void ErrorLoginAssertion() throws InterruptedException {
            LetsShopBtn.click();
            Thread.sleep(2000);
            AndroidActions.screenshot(driver);
            WebElement ErrorMessegeLogin = driver.findElement(By.xpath("(//android.widget.Toast)[1]"));
            Assert.assertEquals(ErrorMessegeLogin.getText(),"Please enter your name","Failed Of Asertion!");
            Allure.addAttachment("Step Verification Logs: Blank Name Then Direct Click To The Lets Shop Button.","Actual Error Exist Which Is Expected To Be: "+ErrorMessegeLogin.getText());
        }

        //********************************************************************************************************************************************************
        @Step("General Store Fill Up The Landing Page: Set Name Field")
        @Severity(SeverityLevel.NORMAL)
        public void setNameField(String name){
            NameTextField.sendKeys(name);
        }

        //********************************************************************************************************************************************************
        @Step("General Store Fill Up The Landing Page: Set Gender")
        @Severity(SeverityLevel.NORMAL)
        public void setGender(String gender){
            if(gender.contains("Female")){
                GenderBtn.click();
            }else {
                System.out.println("It Should Be Female!");
            }
        }

        //********************************************************************************************************************************************************
        @Step("General Store Fill Up The Landing Page: Submit Button")
        @Severity(SeverityLevel.NORMAL)
        public GeneralStoreProductPage submitForm(){
            LetsShopBtn.click();
            return new GeneralStoreProductPage(driver);
        }

}
