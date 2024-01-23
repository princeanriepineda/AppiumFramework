package TestCases;

import Base.AndroidBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class AndroidAPIDemos_SelectDropDownTestCase extends AndroidBaseTest {
    @Test(priority = 1)
    @Story("Story: SelectDropDown Scenario")
    @Description("Description: Validation of Select Drop Down ")
    @Epic("Epic: User Management")
    @Feature("Feature: Select Drop Down Android")
    public void Test1SelectDropDown() throws InterruptedException {
        System.out.println("Appium Started!!!");

        //****************************************************************************
        APIDLP.ClickViews();
        APIDViewsP.ClickSpinner();
        APIDSpinnerP.SelectDropDownListSpinner("blue","Uranus");
    }
}
