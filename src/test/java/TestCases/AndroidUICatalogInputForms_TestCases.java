package TestCases;

import AndroidPageObject.*;
import Base.AndroidBaseTest;
import Base.Listener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class AndroidUICatalogInputForms_TestCases extends AndroidBaseTest {
//    public UIFrameworkCatalogLandingPage UIFCLP;
//    public UIFrameworkCatalogjQueryMobile145LandingPage UIFCjQueryMobileLP;
//    public UIFrameworkCatalogjQueryMobile145CheckboxPage UIFCjQueryMobileCheckBoxP;
//    public UIFrameworkCatalogjQueryMobile145RadioButtonsPage UIFCjQueryMobileRadioButtonP;
//    public UIFrameworkCatalogjQueryMobile145FormsPage UIFCjQueryMobileFormsP;
//    public UIFrameworkCatalogPhonon131LandingPage UIFCPhonon131LP;
//    public UIFrameworkCatalogPhonon131PopoversPage UIFCPhononPopoversP;
//    public UIFrameworkCatalogFramework7Material140LandingPage UIFCFramework7MaterialLP;
//    public UIFrameworkCatalogFramework7Material140LoginScreenPage UIFCFramework7MaterialLoginscreenP;
//    public UIFrameworkCatalogFramework7Material140SignInPage UIFCFramework7MaterialSignInP;
//    public UIFrameworkCatalogFramework7Material140FormsPage UIFCFramework7MaterialFormsP;
//    public UIFrameworkCatalogFramework7Material140FormStoragePage UIFCFramework7MaterialFormsStorageP;

    @Test(priority = 1)
    @Story("Input Forms Scenario")
    @Description("Validation of CheckBox, Radio Buttons, jQuery Select DropDown List, Select DropDown List ")
    @Epic("User Management")
    @Feature("Input Actions Android")
    public void Test1InputForms() throws InterruptedException {
        System.out.println("Appium Started!!!");
//        UIFCLP = new UIFrameworkCatalogLandingPage(driver);
//        UIFCjQueryMobileLP = new UIFrameworkCatalogjQueryMobile145LandingPage(driver);
//        UIFCjQueryMobileCheckBoxP = new UIFrameworkCatalogjQueryMobile145CheckboxPage(driver);
//        UIFCjQueryMobileRadioButtonP = new UIFrameworkCatalogjQueryMobile145RadioButtonsPage(driver);
//        UIFCjQueryMobileFormsP = new UIFrameworkCatalogjQueryMobile145FormsPage(driver);
//        UIFCPhononLP = new UIFrameworkCatalogPhonon131LandingPage(driver);
//        UIFCPhononPopoversP = new UIFrameworkCatalogPhonon131PopoversPage(driver);
//        UIFCFramework7MaterialLP =  new UIFrameworkCatalogFramework7Material140LandingPage(driver);
//        UIFCFramework7MaterialLoginscreenP = new UIFrameworkCatalogFramework7Material140LoginScreenPage(driver);
//        UIFCFramework7MaterialSignInP = new UIFrameworkCatalogFramework7Material140SignInPage(driver);
//        UIFCFramework7MaterialFormsP = new UIFrameworkCatalogFramework7Material140FormsPage(driver);
//        UIFCFramework7MaterialFormsStorageP = new UIFrameworkCatalogFramework7Material140FormStoragePage(driver);


        //****************************************************************************
        UIFCLP.SelectFramework("jQuery Mobile 1.4.5");
        UIFCjQueryMobileLP.jQueryMobile145CheckBox();
        UIFCjQueryMobileCheckBoxP.jQueryMobile145CheckBoxesVertical();
        UIFCjQueryMobileCheckBoxP.jQueryMobile145CheckBoxesHorizontal();
        driver.navigate().back();
        //*****************************************************************************
        UIFCjQueryMobileLP.jQueryMobile145RadioButtons();
        UIFCjQueryMobileRadioButtonP.jQueryMobile145RadioButtonsVertical();
        UIFCjQueryMobileRadioButtonP.jQueryMobile145RadioButtonsHorizontal();
        driver.navigate().back();
        //*****************************************************************************
        UIFCjQueryMobileLP.jQueryMobile145Forms();
        UIFCjQueryMobileFormsP.jQueryMobile145NativeSelectDrpdwn("Three");
        driver.navigate().back();
        driver.navigate().back();
        //******************************************************************************
        UIFCLP.SelectFramework("Phonon 1.3.1");
        UIFCPhononLP.Phonon131Popovers();
        UIFCPhononPopoversP.Phonon131SelectDrpdwn("Item 4");
        driver.navigate().back();
        driver.navigate().back();
        //*******************************************************************************
        UIFCLP.SelectFramework("Framework7 Material 1.4.0");
        UIFCFramework7MaterialLP.UIFramework7Material140LoginScreen();
        UIFCFramework7MaterialLoginscreenP.UIFramework7Material140EmebeddedIntoPage();
        UIFCFramework7MaterialSignInP.UIFramework7Material140InputSignInDetails("Pedro","123");
        driver.navigate().back();
        //*******************************************************************************
        UIFCLP.SelectFramework("Framework7 Material 1.4.0");
        UIFCFramework7MaterialLP.UIFramework7Material140Forms();
        UIFCFramework7MaterialFormsP.UIFramework7Material140FormsStorage();
        UIFCFramework7MaterialFormsStorageP.Framework7Material140InputDetailsFormStorage
                ("Pedro","Pedro@Hotmail.com","www.google.com","1234",
                        "091234567", "I'm fine! I'm Happy",
                        "Female",1,"Movies");
        driver.navigate().back();
    }
}
