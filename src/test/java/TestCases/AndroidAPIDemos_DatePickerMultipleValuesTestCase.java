package TestCases;


import Base.AndroidBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class AndroidAPIDemos_DatePickerMultipleValuesTestCase extends AndroidBaseTest {

    @Test(priority = 1,dataProvider = "getData")
    @Story("Story: Date Picker Scenario")
    @Description("Description: Validation of Date Picker: Select Dynamic Date On Multiple Values field (include all months and year) ")
    @Epic("Epic: User Management")
    @Feature("Feature: Date Picker Android")
    public void Test1DatePickerMultipleValues(HashMap<String,String> input) throws InterruptedException {
        System.out.println("Appium Started!!!");

        //****************************************************************************
        APIDLP.ClickViews();
        APIDViewsP.ClickDateWidget();
        APIDDateWidgetsP.ClickDialog();
        //Note: Add O Value If Single Digit In Day
        APIDDialogP.SelectDynamicDateOnYourBirthDatefield(input.get("YearTarget"),
                input.get("Month"),input.get("Day"),input.get("SingleDigitAdder"));

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "/src/main/java/TestData/APIDemos.json");
        // Convert List<HashMap> to Object[][]
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i);
        }
        return dataArray;
    }




}
