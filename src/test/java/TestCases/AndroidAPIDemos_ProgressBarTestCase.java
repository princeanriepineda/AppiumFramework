package TestCases;

import Base.AndroidBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class AndroidAPIDemos_ProgressBarTestCase extends AndroidBaseTest {

    @Test(priority = 1)
    @Story("Story: Progress Bars Scenario")
    @Description("Description: Validation of Progress Bars ")
    @Epic("Epic: User Management")
    @Feature("Feature: Progress Bars Android")
    public void Test1InputForms() throws InterruptedException {
        System.out.println("Appium Started!!!");

        //****************************************************************************
        APIDLP.ClickViews();
        APIDViewsP.ClickProgress();
        APIDProgressP.ClickIncremental();
        APIDIncrementalP.IncrementalPlusButtonProgressBar();
        APIDIncrementalP.IncrementalMinusButtonProgressBar();




    }
}
