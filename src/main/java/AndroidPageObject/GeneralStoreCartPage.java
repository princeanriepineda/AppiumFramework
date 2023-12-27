package AndroidPageObject;

import Actions.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class GeneralStoreCartPage extends AndroidActions {
    AndroidDriver driver;
    public GeneralStoreCartPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]")
    private WebElement CartPageTitle;

    @AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productList;

    @AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement DisplaySum;

    @AndroidFindBy(xpath="//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]")
    private WebElement CheckBoxSendMeEmails;

    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/termsButton\"]")
    private WebElement LongPressAcceptTerms;

    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/message\"]")
    private WebElement TermsAndConditions;

    @AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
    private WebElement CloseBtnModdal;

    @AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnProceed\"]")
    private WebElement VisitWebsiteBtn;

    //insideFunctions---------------------------------------------------------------------->
    public List<WebElement> getProductList(){
        return  productList;
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public double getProductSum(){
        int count = productList.size();
        double sum =0;
        for(int i=0;i<count;i++){
            String amountString = productList.get(i).getText();
            Double price = getFormattedAmount(amountString);
            sum =sum+price;
        }
        return sum;
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public Double getTotalAmountDisplayed(){
        return getFormattedAmount(DisplaySum.getText());
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //insideFunctions---------------------------------------------------------------------->


    @Step("General Store Validation Of The Cart Page: Cart Page Title Assertion")
    @Severity(SeverityLevel.NORMAL)
    public  void CartPageTitleAssertion() throws InterruptedException {
        waitForElementToAppear(CartPageTitle, driver);
        Assert.assertEquals(CartPageTitle.getText(),"Cart");
    }
    //********************************************************************************************************************************************************

    @Step("General Store Validation Of The Cart Page: Selected Items From The Product Page to Cart Page Assertion")
    @Severity(SeverityLevel.NORMAL)
    public void VerificationOfItemsInCart(Integer itemCount, String item1, String item2 ){
        List<String> targetProductNames = Arrays.asList(item1,item2);

        for (int i = 1; i <= itemCount; i++) {
            WebElement productItem = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\"])[" + i + "]"));
            String printedProductName = productItem.getText();
            System.out.println(printedProductName);
            Assert.assertTrue(targetProductNames.contains(printedProductName), "Product name doesn't match any target name.");
        }
    }
    //********************************************************************************************************************************************************

    @Step("General Store Validation Of The Cart Page: Summation Of Selected Item Prices Then Comparison To The Total Amount Display")
    @Severity(SeverityLevel.NORMAL)
    public void SummationOfProductPriceAndValidationToTheTotalSum(Double TotalSum, Double DisplayFormattedSum){
        Assert.assertEquals(TotalSum,DisplayFormattedSum);
    }
    //********************************************************************************************************************************************************

    @Step("General Store Validation Of The Cart Page: Check Box For Send Email And Long Press Of Terms Agreement")
    @Severity(SeverityLevel.NORMAL)
    public void AcceptTermsCondition(){
        CheckBoxSendMeEmails.click();
        LongPress(LongPressAcceptTerms);
    }
    //********************************************************************************************************************************************************

    @Step("General Store Validation Of The Cart Page: Terms Of Agreement Assertion")
    @Severity(SeverityLevel.NORMAL)
    public void ModalTermsOfAgreementAssertion() throws InterruptedException {
        Thread.sleep(1000);
        String MessegeToBeExpect = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
        Assert.assertEquals(TermsAndConditions.getText(),MessegeToBeExpect);
        CloseBtnModdal.click();
    }
    //********************************************************************************************************************************************************

    @Step("General Store Validation Of The Cart Page: Click Visit To Website Button")
    @Severity(SeverityLevel.NORMAL)
    public void VisitWebsiteBtn() throws InterruptedException {
        VisitWebsiteBtn.click();
        Thread.sleep(6000);
        Set<String> contexts = driver.getContextHandles();
        for(String contextName : contexts){
            System.out.println(contextName);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        WebElement GglTextField = driver.findElement(By.name("q"));
        GglTextField.sendKeys("rahul shetty academy");
        GglTextField.sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
    }


}
