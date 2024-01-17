package TestCases;

import Base.AndroidBaseTest;
import AndroidPageObject.GeneralStoreCartPage;
import AndroidPageObject.GeneralStoreProductPage;
import Utils.ExcelUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class AndroidGeneralStore_RegistrationTestcase extends AndroidBaseTest {

    @DataProvider(name = "testdata")
    public Object[][] testData(Method method) throws IOException {
        String sheetName=""; // No need to initialize

        // Determine the Excel sheet name based on the test method's name
        if (method.getName().equals("FillForm")) {
            sheetName = "generalstore";
        } //else if (method.getName().equals("FOP2_000_004")) {
            //sheetName = "FOP2_000_005";
        //}// Add more conditions for other test methods as needed

        return ExcelUtils.readExcel("C:\\Users\\Prince Pineda\\IdeaProjects\\AppiumTrainingHybridFramework\\src\\main\\java\\TestData\\TestDataMobile.xlsx",sheetName);
    }

    @Test(dataProvider = "testdata", priority = 1)
    @Story("Story: Positive Flow Scenrio In General Store App")
    @Description("Test Description: Fill The Form, Select Items, Validate Items, and SubmitForm")
    @Epic("test1")
    @Feature("Happy Path Testing - End To End")
    public void FillForm(String username, String country, String gender, String product1, String product2) throws InterruptedException {
        System.out.println("Appium Started!");
        GSFormPage.setCountrySelection(country);
        GSFormPage.ErrorLoginAssertion();
        GSFormPage.setNameField(username);
        GSFormPage.setGender(gender);
        GeneralStoreProductPage GSProductPage = GSFormPage.submitForm();
        //****************************************************************

        GSProductPage.addItemToCart(product1, product2);
        GeneralStoreCartPage GSCartPage = GSProductPage.goToCartPage();
        //****************************************************************

        GSCartPage.CartPageTitleAssertion();
        GSCartPage.VerificationOfItemsInCart(2,product1, product2);
        GSCartPage.SummationOfProductPriceAndValidationToTheTotalSum(GSCartPage.getProductSum(),GSCartPage.getTotalAmountDisplayed());
        GSCartPage.AcceptTermsCondition();
        GSCartPage.ModalTermsOfAgreementAssertion();
        GSCartPage.VisitWebsiteBtn();
        //****************************************************************
    }
}
