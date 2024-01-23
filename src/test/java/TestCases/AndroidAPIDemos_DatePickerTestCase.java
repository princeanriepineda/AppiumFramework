package TestCases;


import Base.AndroidBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class AndroidAPIDemos_DatePickerTestCase extends AndroidBaseTest {

    @Test(priority = 1)
    @Story("Story: Date Picker Scenario")
    @Description("Description: Validation of Date Picker: Select Dynamic Date On Your Birth Date Field ")
    @Epic("Epic: User Management")
    @Feature("Feature: Date Picker Android")
    public void Test1DatePicker() throws InterruptedException {
        System.out.println("Appium Started!!!");

        //****************************************************************************
        APIDLP.ClickViews();
        APIDViewsP.ClickDateWidget();
        APIDDateWidgetsP.ClickDialog();
        //Note: Add O Value If Single Digit In Day
        APIDDialogP.SelectDynamicDateOnYourBirthDatefield("2024","February","15","");

    }

    @Test(priority = 2)
    @Story("Story: Date Picker Scenario")
    @Description("Description: Validation of Date Picker: Select Next Week Date(7days) On Custom Date Format Field ")
    @Epic("Epic: User Management")
    @Feature("Feature: Date Picker Android")
    public void Test2DatePicker() throws InterruptedException {
        System.out.println("Appium Started!!!");

        //****************************************************************************
        APIDLP.ClickViews();
        APIDViewsP.ClickDateWidget();
        APIDDateWidgetsP.ClickDialog();
        APIDDialogP.NextWeekDate7daysoncustomdateformatfield();

    }

    @Test(priority = 3)
    @Story("Story: Date Picker Scenario")
    @Description("Description: Validation of Date Picker: Select Dynamic Date Range On Range Picker Field ")
    @Epic("Epic: User Management")
    @Feature("Feature: Date Picker Android")
    public void Test3DatePicker() throws InterruptedException {
        System.out.println("Appium Started!!!");

        //****************************************************************************
        APIDLP.ClickViews();
        APIDViewsP.ClickDateWidget();
        APIDDateWidgetsP.ClickDialog();
        //Note: Add O Value If Single Digit In Day
        APIDDialogP.SelectDynamicDateRangeOnRangePickerField("2024","January","1","0");
        //Note: Add O Value If Single Digit In Day
        APIDDialogP.SelectDynamicDateRangeOnRangePickerField("2024","January","31","");

    }

}
