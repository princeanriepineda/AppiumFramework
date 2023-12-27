package AndroidPageObject;

import Actions.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class GeneralStoreProductPage extends AndroidActions {

    AndroidDriver driver;
    public GeneralStoreProductPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]")
    private WebElement CartBtn;

    @Step("General Store Item Selection of Product Page: Add Multiple Item To The Cart")
    @Severity(SeverityLevel.NORMAL)
    public void addItemToCart(String Item1, String Item2) throws InterruptedException {
        List<String> targetProductNames = Arrays.asList(Item1,Item2);
        for (int i=0; i<targetProductNames.size();i++) {
            String targetProductName = targetProductNames.get(i);
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + targetProductName + "\"))"));
            Thread.sleep(2000);

            int productCount = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.androidsample.generalstore:id/rvProductList\"]")).size();
            for (int j = 0; j < productCount; j++) {
                String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(j).getText();
                if (productName.equalsIgnoreCase(targetProductName)) {
                    driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(j).click();
                    }
            }
        }
    }

    //********************************************************************************************************************************************************
    @Step("General Store Item Selection of Product Page: Click The Cart Button")
    @Severity(SeverityLevel.NORMAL)
    public GeneralStoreCartPage goToCartPage() throws InterruptedException {
        CartBtn.click();
        return new GeneralStoreCartPage(driver);
    }
}
