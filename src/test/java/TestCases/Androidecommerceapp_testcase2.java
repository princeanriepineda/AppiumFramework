package TestCases;


import Base.AndroidBaseTest;
import Base.Listener;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Listeners(Listener.class)
public class Androidecommerceapp_testcase2 extends AndroidBaseTest {


    @Test(priority = 1)
    @Story("Story: Positive Flow Scenrio In General Store App")
    @Description("Test Description: Fill The Form and Select Items")
    @Epic("test2")
    @Feature("Happy Path Testing")
    public void FillFormPostiveFlow() throws InterruptedException {
        System.out.println("Appium Started!");
        Thread.sleep(7000);
        WebElement listView = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
        listView.click();
        Thread.sleep(5000);

        String itemText = "Denmark";
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+itemText+"\"))"));
        String itemXPath = "//android.widget.TextView[@resource-id='android:id/text1' and @text='"+itemText+"']";
        WebElement listItem = driver.findElement(By.xpath(itemXPath));
        listItem.click();

        WebElement NameTextField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]"));
        NameTextField.sendKeys("Test Value");

        WebElement GenderBtn = driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]"));
        GenderBtn.click();

        WebElement LetsShopBtn = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]"));
        LetsShopBtn.click();

        List<String> targetProductNames = Arrays.asList("Jordan 6 Rings");
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
    }

    @Test(priority = 2)
    @Story("Story: Negative Flow Scenrio In General Store App")
    @Description("Test Description: Blank Text Field Then Submit Form is Expected To Fail")
    @Epic("test3")
    @Feature("Negative Testing - FillForm/Landing Page ")
    public void FillFormErrorScenario() throws InterruptedException {
        listener.setDriver(driver);
        System.out.println("Appium Started!");
        Thread.sleep(7000);
        WebElement listView = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
        listView.click();
        Thread.sleep(5000);

        String itemText = "Denmark";
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+itemText+"\"))"));
        String itemXPath = "//android.widget.TextView[@resource-id='android:id/text1' and @text='"+itemText+"']";
        WebElement listItem = driver.findElement(By.xpath(itemXPath));
        listItem.click();

        WebElement LetsShopBtn = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]"));
        LetsShopBtn.click();

        WebElement ErrorMessegeLogin = driver.findElement(By.xpath("(//android.widget.Toast)[1]"));
        Assert.assertEquals(ErrorMessegeLogin.getText(),"Please enter your name","Failed Of Asertion!");

    }


}

