package TestCases;

import Base.AndroidBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class AndroidAPIDemos_TimeSpinnerTestCase extends AndroidBaseTest {

    @Test(priority = 1)
    @Story("Story: Time Picker Scenario")
    @Description("Description: Validation of Time Picker: Select Dynamic Time In Picker Field ")
    @Epic("Epic: User Management")
    @Feature("Feature: Time Picker Android")
    public void Test3DatePicker() throws InterruptedException {
        System.out.println("Appium Started!!!");

        //****************************************************************************
        APIDLP.ClickViews();
        APIDViewsP.ClickDateWidget();
        APIDDateWidgetsP.ClickDialog();
        APIDDialogP.SelectDynamicTimeOnTimePickerFieldSpinner(5,8,"PM");

    }
}
