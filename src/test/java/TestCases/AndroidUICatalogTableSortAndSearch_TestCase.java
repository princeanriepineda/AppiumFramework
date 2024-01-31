package TestCases;


import Base.AndroidBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class AndroidUICatalogTableSortAndSearch_TestCase extends AndroidBaseTest {
    @Test(priority = 1)
    @Story("Story: Table Sort & Search Scenario")
    @Description("Description: Validation of Sort And Search ")
    @Epic("Epic: User Management")
    @Feature("Feature: Sort & Search Android")
    public void Test1SortAndSearch() throws InterruptedException {
        System.out.println("Appium Started!!!");

        //****************************************************************************
        UIFCLP.SelectFramework("Framework7 Material 1.4.0");
        UIFCFramework7MaterialLP.UIFramework7Material140ContactList();
        UIFCFramework7MaterialContactsP.UIFramework7Material140Contact();
        driver.navigate().back();
//        //****************************************************************************
//        UIFCLP.SelectFramework("Framework7 Material 1.4.0");
//        UIFCFramework7MaterialLP.UIFramework7Material140AutoComplete();
//        UIFCFramework7MaterialAutocompleteP.UIFramework7Material140AutoCompleteSearch("Orange");
//        driver.navigate().back();
//        driver.navigate().back();
    }
}
