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

public class UIFrameworkCatalogPhonon131DialogsPage extends AndroidActions {
    AndroidDriver driver;

    public UIFrameworkCatalogPhonon131DialogsPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"SHOW ALERT\"]")
    private WebElement ShowAlertBtn;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"SHOW PROMPT\"]")
    private WebElement ShowPromptBtn;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"SHOW CONFIRM\"]")
    private WebElement ShowConfimrBtn;

    //***************************************************************************************************
    @Step("Step: Alerts & Modals Scenario : Validate Show Alert Button & Modal in the Phonon 1.3.1 Dialogs Page")
    @Severity(SeverityLevel.NORMAL)
    public  void Phonon131ShowAlertAndModal() throws InterruptedException {
        Allure.step("Phonon 1.3.1 Click Show Alert Button And Validate The Alert Modal");
        Assert.assertTrue(ShowAlertBtn.isEnabled(), "Show Alert is not enabled");
        ShowAlertBtn.click();
        Thread.sleep(1000);
        AndroidActions.screenshot(driver);

        WebElement ShowAlertModalTxt = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Example\"]"));
        Assert.assertEquals(ShowAlertModalTxt.getAttribute("content-desc"),"Example","Mismatch in Assertion Check Values or Synchronization!");
        Thread.sleep(500);
        AndroidActions.screenshot(driver);

        WebElement ShowAlertModalOkBtn = driver.findElement(By.xpath("//android.view.View[@content-desc=\"OK\"]"));
        Allure.addAttachment("Validation Passed! Check The Dropdown","Actual Txt In Modal: "+ShowAlertModalTxt.getAttribute("content-desc"));
        ShowAlertModalOkBtn.click();
    }

    //***************************************************************************************************
    @Step("Step: Alerts & Modals Scenario : Validate Show Prompt Button & Modal in the Phonon 1.3.1 Dialogs Page")
    @Severity(SeverityLevel.NORMAL)
    public  void Phonon131ShowPromptAndModal(String Value) throws InterruptedException {
        Allure.step("Phonon 1.3.1 Click Show Prompt Button, Inject Value And Validate The Alert Modal");
        Assert.assertTrue(ShowPromptBtn.isEnabled(), "Show Prompt is not enabled");
        ShowPromptBtn.click();
        Thread.sleep(1000);
        AndroidActions.screenshot(driver);

        WebElement ShowPromptModalTxt = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Example\"]"));
        Assert.assertEquals(ShowPromptModalTxt.getAttribute("content-desc"),"Example","Mismatch in Assertion Check Values or Synchronization!");
        WebElement ValueTextBox = driver.findElement(By.xpath("//android.widget.EditText[@text=\"Value\"]"));
        ValueTextBox.sendKeys(Value);
        Thread.sleep(500);
        AndroidActions.screenshot(driver);
        WebElement ShowPromptModalOkBtn = driver.findElement(By.xpath("//android.view.View[@content-desc=\"OK\"]"));
        ShowPromptModalOkBtn.click();

        String ItemXpath = "//android.view.View[@content-desc=\""+Value+"\"]";
        WebElement ShowPromptInsertedValueModalTxt = driver.findElement(By.xpath(ItemXpath));
        Assert.assertEquals(ShowPromptInsertedValueModalTxt.getAttribute("content-desc"),Value,"Mismatch in Assertion Check Values or Synchronization!");
        WebElement ShowPromptInsertedValueModalOkBtn = driver.findElement(By.xpath("//android.view.View[@content-desc=\"OK\"]"));
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Actual Txt In Modal: "+ShowPromptInsertedValueModalTxt.getAttribute("content-desc"));
        ShowPromptInsertedValueModalOkBtn.click();
    }

    //***************************************************************************************************
    @Step("Step: Alerts & Modals Scenario : Validate Show Confirm Ok Button & Modal in the Phonon 1.3.1 Dialogs Page")
    @Severity(SeverityLevel.NORMAL)
    public  void Phonon131ShowConfirmOKAndModal() throws InterruptedException {
        Allure.step("Phonon 1.3.1 Click Show Confirm Button, Click OK And Validate The Alert Modal");
        Assert.assertTrue(ShowConfimrBtn.isEnabled(), "Show Confirm is not enabled");
        ShowConfimrBtn.click();
        Thread.sleep(1000);
        AndroidActions.screenshot(driver);

        WebElement ShowConfirmModalTxt = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Example\"]"));
        Assert.assertEquals(ShowConfirmModalTxt.getAttribute("content-desc"),"Example","Mismatch in Assertion Check Values or Synchronization!");
        Thread.sleep(500);
        AndroidActions.screenshot(driver);
        WebElement ShowConfirmModalOkBtn = driver.findElement(By.xpath("//android.view.View[@content-desc=\"OK\"]"));
        ShowConfirmModalOkBtn.click();

        WebElement ShowConfirmInsertedValueModalTxt = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Confirmed!\"]"));
        Assert.assertEquals(ShowConfirmInsertedValueModalTxt.getAttribute("content-desc"),"Confirmed!","Mismatch in Assertion Check Values or Synchronization!");
        WebElement ShowConfirmInsertedValueModalOkBtn = driver.findElement(By.xpath("//android.view.View[@content-desc=\"OK\"]"));
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Actual Txt In Modal: "+ShowConfirmInsertedValueModalTxt.getAttribute("content-desc"));
        ShowConfirmInsertedValueModalOkBtn.click();
    }

    //***************************************************************************************************
    @Step("Step: Alerts & Modals Scenario : Validate Show Confirm Cancel Button & Modal in the Phonon 1.3.1 Dialogs Page")
    @Severity(SeverityLevel.NORMAL)
    public  void Phonon131ShowConfirmCancelAndModal() throws InterruptedException {
        Allure.step("Phonon 1.3.1 Click Show Confirm Button, Click Cancel And Validate The Alert Modal");
        Assert.assertTrue(ShowConfimrBtn.isEnabled(), "Show Confirm is not enabled");
        ShowConfimrBtn.click();
        Thread.sleep(1000);
        AndroidActions.screenshot(driver);

        WebElement ShowConfirmModalTxt = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Example\"]"));
        Assert.assertEquals(ShowConfirmModalTxt.getAttribute("content-desc"),"Example","Mismatch in Assertion Check Values or Synchronization!");
        Thread.sleep(500);
        AndroidActions.screenshot(driver);
        WebElement ShowConfirmModalCancelBtn = driver.findElement(By.xpath("//android.view.View[@content-desc=\"CANCEL\"]"));
        ShowConfirmModalCancelBtn.click();

        WebElement ShowConfirmInsertedValueModalTxt = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Canceled!\"]"));
        Assert.assertEquals(ShowConfirmInsertedValueModalTxt.getAttribute("content-desc"),"Canceled!","Mismatch in Assertion Check Values or Synchronization!");
        WebElement ShowConfirmInsertedValueModalOkBtn = driver.findElement(By.xpath("//android.view.View[@content-desc=\"OK\"]"));
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed! Check The Dropdown","Actual Txt In Modal: "+ShowConfirmInsertedValueModalTxt.getAttribute("content-desc"));
        ShowConfirmInsertedValueModalOkBtn.click();
    }


}
