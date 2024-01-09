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
    public UIFrameworkCatalogLandingPage UIFCLP;
    public UIFrameworkCatalogjQueryMobile145LandingPage UIFCjQueryMobileLP;
    public UIFrameworkCatalogjQueryMobileCheckboxPage UIFCjQueryMobileCheckBoxP;
    public UIFrameworkCatalogjQueryMobileRadioButtonsPage UIFCjQueryMobileRadioButtonP;
    public UIFrameworkCatalogjQueryMobileFormsPage UIFCjQueryMobileFormsP;

    @Test(priority = 1)
    @Story("Input Forms Scenario")
    @Description("Validation of CheckBox, Radio Buttons and Select DropDown List")
    @Epic("User Management")
    @Feature("Input Actions Android")
    public void Test1InputForms() throws InterruptedException {
        System.out.println("Appium Started!!!");
        UIFCLP = new UIFrameworkCatalogLandingPage(driver);
        UIFCjQueryMobileLP = new UIFrameworkCatalogjQueryMobile145LandingPage(driver);
        UIFCjQueryMobileCheckBoxP = new UIFrameworkCatalogjQueryMobileCheckboxPage(driver);
        UIFCjQueryMobileRadioButtonP = new UIFrameworkCatalogjQueryMobileRadioButtonsPage(driver);
        UIFCjQueryMobileFormsP = new UIFrameworkCatalogjQueryMobileFormsPage(driver);

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
    }
}
