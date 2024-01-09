package TestCases;

import AndroidPageObject.UIFrameworkCatalogLandingPage;
import AndroidPageObject.UIFrameworkCatalogjQueryMobile145LandingPage;
import AndroidPageObject.UIFrameworkCatalogjQueryMobileCheckboxPage;
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

        //****************************************************************************
        UIFCLP.SelectFramework("jQuery Mobile 1.4.5");
        UIFCjQueryMobileLP.jQueryMobile145CheckBox();
        UIFCjQueryMobileCheckBoxP.jQueryMobile145CheckBoxesVertical();
        UIFCjQueryMobileCheckBoxP.jQueryMobile145CheckBoxesHorizontal();

    }
}
