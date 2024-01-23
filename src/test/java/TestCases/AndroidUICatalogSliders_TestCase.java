package TestCases;

import Base.AndroidBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class AndroidUICatalogSliders_TestCase extends AndroidBaseTest {
    @Test(priority = 1)
    @Story("Story: Slider Scenario")
    @Description("Description: Validation of Slider ")
    @Epic("Epic: User Management")
    @Feature("Feature: Progress Slider Android")
    public void Test1Sliders() throws InterruptedException {
        System.out.println("Appium Started!!!");

        //****************************************************************************
        UIFCLP.SelectFramework("jQuery Mobile 1.4.5");
        UIFCjQueryMobileLP.jQueryMobile145Forms();
        UIFCjQueryMobileFormsP.jQueryMobile145SliderBar(1030,1043,100);
        driver.navigate().back();
        driver.navigate().back();



    }
}
