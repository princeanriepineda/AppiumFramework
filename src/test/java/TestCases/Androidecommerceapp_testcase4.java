package TestCases;


import Base.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Androidecommerceapp_testcase4 extends AndroidBaseTest {

    @Test(dataProvider = "getData", groups = {"Smoke"})
    public void FillForm(HashMap<String,String> input) throws InterruptedException {
        System.out.println("Appium Started!");

        WebElement listView = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]"));
        listView.click();

        String itemText = input.get("country");
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+itemText+"\"))"));
        String itemXPath = "//android.widget.TextView[@resource-id='android:id/text1' and @text='"+itemText+"']";
        WebElement listItem = driver.findElement(By.xpath(itemXPath));
        listItem.click();

        WebElement NameTextField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]"));
        NameTextField.sendKeys(input.get("name"));

        WebElement GenderBtn = driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]"));
        GenderBtn.click();

        WebElement LetsShopBtn = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]"));
        LetsShopBtn.click();

        List<String> targetProductNames = Arrays.asList("Nike Blazer Mid '77", "Jordan 6 Rings");
        for (int i=0; i<targetProductNames.size();i++) {
            String targetProductName = targetProductNames.get(i);
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + targetProductName + "\"))"));
            Thread.sleep(1000);

                //String itemShoesText = "Jordan 6 Rings";
                //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+itemShoesText+"\"))"));

                int productCount = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.androidsample.generalstore:id/rvProductList\"]")).size();
            //String productName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();


            for (int j = 0; j < productCount; j++) {
                    String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(j).getText();
                    //String productName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

                if (productName.equalsIgnoreCase(targetProductName)) {
                    driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(j).click();
                    //.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
                }
            }
        }

        WebElement CartBtn = driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]"));
        CartBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // 10 seconds timeout
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]")),"text","Cart"));

        WebElement CartPageTitle = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]"));
        Assert.assertEquals(CartPageTitle.getText(),"Cart");

        int itemCount = 2;
        for (int i = 1; i <= itemCount; i++) {
            WebElement productItem = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\"])[" + i + "]"));
            String printedProductName = productItem.getText();
            System.out.println(printedProductName);
            Assert.assertTrue(targetProductNames.contains(printedProductName), "Product name doesn't match any target name.");
        }

        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = productPrices.size();
        double sum =0;
        for(int i=0;i<count;i++){
            String amountString = productPrices.get(i).getText();
            Double price = getFormattedAmount(amountString);
            sum =sum+price;
        }

        String DisplaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayformattedsum = getFormattedAmount(DisplaySum);
        Assert.assertEquals(sum,displayformattedsum);

        WebElement CheckBoxSendMeEmails =  driver.findElement(By.xpath("//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]"));
        CheckBoxSendMeEmails.click();

        WebElement elementToLongPress = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/termsButton\"]"));
        // Perform long press using TouchAction
        new TouchAction<>(driver)
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(elementToLongPress))
                        .withDuration(Duration.ofSeconds(2)))
                .release()
                .perform();

        Thread.sleep(1000);
        WebElement TermsAndConditions =  driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]"));
        String MessegeToBeExpect = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
        Assert.assertEquals(TermsAndConditions.getText(),MessegeToBeExpect);

        WebElement CloseBtnModdal = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
        CloseBtnModdal.click();



    }

    @DataProvider
    public Object[][]getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/main/java/TestData/eCommerce.json");
        return  new Object[][] {{data.get(0)},{data.get(1)}};
    }



}

