package TestCases;

import Base.AndroidBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


public class AndroidUICatalogInputForms_TestCase extends AndroidBaseTest {


    @Test(priority = 1)
    @Story("Story: Input Forms Scenario")
    @Description("Description: Validation of CheckBox, Radio Buttons, jQuery Select DropDown List, Select DropDown List, Input Form Submit, Ajax Form Submit ")
    @Epic("Epic: User Management")
    @Feature("Feature: Input Actions Android")
    public void Test1InputForms() throws InterruptedException {
        System.out.println("Appium Started!!!");

//        //****************************************************************************
//        UIFCLP.SelectFramework("jQuery Mobile 1.4.5");
//        UIFCjQueryMobileLP.jQueryMobile145CheckBox();
//        UIFCjQueryMobileCheckBoxP.jQueryMobile145CheckBoxesVertical();
//        UIFCjQueryMobileCheckBoxP.jQueryMobile145CheckBoxesHorizontal();
//        driver.navigate().back();
//        //*****************************************************************************
//        UIFCjQueryMobileLP.jQueryMobile145RadioButtons();
//        UIFCjQueryMobileRadioButtonP.jQueryMobile145RadioButtonsVertical();
//        UIFCjQueryMobileRadioButtonP.jQueryMobile145RadioButtonsHorizontal();
//        driver.navigate().back();
//        //*****************************************************************************
//        UIFCjQueryMobileLP.jQueryMobile145Forms();
//        UIFCjQueryMobileFormsP.jQueryMobile145NativeSelectDrpdwn("Three");
//        driver.navigate().back();
//        driver.navigate().back();
//        //******************************************************************************
//        UIFCLP.SelectFramework("Framework7 Material 1.4.0");
//        UIFCFramework7MaterialLP.UIFramework7Material140AutoComplete();
//        UIFCFramework7MaterialAutocompleteP.UIFramework7Material140AutoCompleteDropDown("Apple");
//        driver.navigate().back();
//        driver.navigate().back();
//        //*******************************************************************************
//        UIFCLP.SelectFramework("Framework7 Material 1.4.0");
//        UIFCFramework7MaterialLP.UIFramework7Material140LoginScreen();
//        UIFCFramework7MaterialLoginscreenP.UIFramework7Material140EmebeddedIntoPage();
//        UIFCFramework7MaterialSignInP.UIFramework7Material140InputSignInDetails("Pedro","123");
//        driver.navigate().back();
//        //*******************************************************************************
//        UIFCLP.SelectFramework("Phonon 1.3.1");
//        UIFCPhononLP.Phonon131Forms();
//        UIFCPhononFormsP.Phonon131FormsInputDetails("Pedro Calungsod","Radio1");
//        driver.navigate().back();
//        driver.navigate().back();
    }
}
