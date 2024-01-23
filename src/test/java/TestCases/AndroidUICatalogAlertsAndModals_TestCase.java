package TestCases;

import Base.AndroidBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class AndroidUICatalogAlertsAndModals_TestCase extends AndroidBaseTest {

    @Test(priority = 1)
    @Story("Story: Alerts & Modals Scenario")
    @Description("Description: Validation of Show Alert, Show Prompt And Show Confirm ")
    @Epic("Epic: User Management")
    @Feature("Feature: Alerts & Modals Android")
    public void Test1AlertAndModals() throws InterruptedException {
        System.out.println("Appium Started!!!");

        //****************************************************************************
        UIFCLP.SelectFramework("Phonon 1.3.1");
        UIFCPhononLP.Phonon131Dialogs();
        UIFCPhononDialogsP.Phonon131ShowAlertAndModal();
        UIFCPhononDialogsP.Phonon131ShowPromptAndModal("Pedro");
        UIFCPhononDialogsP.Phonon131ShowConfirmOKAndModal();
        UIFCPhononDialogsP.Phonon131ShowConfirmCancelAndModal();

    }
}
