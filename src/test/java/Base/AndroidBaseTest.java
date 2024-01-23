package Base;

import AndroidPageObject.*;
import Utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class AndroidBaseTest extends AppiumUtils {
    public static AndroidDriver driver;
    public AppiumDriverLocalService service;
    public UiAutomator2Options options;
    public GeneralStoreFormPage GSFormPage;
    public Listener listener;
    public UIFrameworkCatalogLandingPage UIFCLP;
    public UIFrameworkCatalogjQueryMobile145LandingPage UIFCjQueryMobileLP;
    public UIFrameworkCatalogjQueryMobile145CheckboxPage UIFCjQueryMobileCheckBoxP;
    public UIFrameworkCatalogjQueryMobile145RadioButtonsPage UIFCjQueryMobileRadioButtonP;
    public UIFrameworkCatalogjQueryMobile145FormsPage UIFCjQueryMobileFormsP;
    public UIFrameworkCatalogPhonon131LandingPage UIFCPhononLP;
    public UIFrameworkCatalogPhonon131PopoversPage UIFCPhononPopoversP;
    public UIFrameworkCatalogFramework7Material140LandingPage UIFCFramework7MaterialLP;
    public UIFrameworkCatalogFramework7Material140LoginScreenPage UIFCFramework7MaterialLoginscreenP;
    public UIFrameworkCatalogFramework7Material140SignInPage UIFCFramework7MaterialSignInP;
    public UIFrameworkCatalogFramework7Material140FormsPage UIFCFramework7MaterialFormsP;
    public UIFrameworkCatalogFramework7Material140FormStoragePage UIFCFramework7MaterialFormsStorageP;
    public UIFrameworkCatalogOnsenUI200beta5LandingPage UIFCOnsenUIBeta5LP;
    public UIFrameworkCatalogOnsenUI200beta5ListPage UIFCOnsenUIBeta5ListP;
    public UIFrameworkCatalogPhonon131FormsPage UIFCPhononFormsP;
    public UIFrameworkCatalogPhonon131DialogsPage UIFCPhononDialogsP;
    public UIFrameworkCatalogFramework7Material140AutocompletePage UIFCFramework7MaterialAutocompleteP;
    public UIFrameworkCatalogFramework7Material140ContactsPage UIFCFramework7MaterialContactsP;
    public APIDemosLandingPage APIDLP;
    public APIDemosViewsPage APIDViewsP;
    public APIDemosProgressPage APIDProgressP;
    public APIDemosIncrementalPage APIDIncrementalP;
    public APIDemosDateWidgetPage APIDDateWidgetsP;
    public APIDemosDialogPage APIDDialogP;
    public APIDemosSpinnerPage APIDSpinnerP;


    @BeforeMethod(alwaysRun = true)
    public void ConfigureAppium() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/ResourcesAPK/data.properties");
        prop.load(fis);
        String ipAddress = prop.getProperty("ipAddress");
        String port = prop.getProperty("port");
        service = startAppiumServer(ipAddress,Integer.parseInt(port));
        WebDriverManager.chromedriver().setup();

        options = new UiAutomator2Options();
        options.setDeviceName(prop.getProperty("AndroidDeviceName"));
        //options.setApp("/Users/princeanriepineda/IdeaProjects/AppiumTrainingHybridFramework/src/main/java/ResourcesAPK/General-Store.apk");
        //options.setApp("/Users/princeanriepineda/GitAppium/AppiumTrainingHybridFramework/src/main/java/ResourcesAPK/UI Framework Catalog_0.3.0_Apkpure.apk");
        options.setApp(prop.getProperty("AndroidAppPathAPIDemos"));
        options.setCapability("appium:chromedriverEnableAsyncDownload", true);
        driver = new AndroidDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        //********************************************************************************************************************************
        GSFormPage = new GeneralStoreFormPage(driver);
        UIFCLP = new UIFrameworkCatalogLandingPage(driver);
        UIFCjQueryMobileLP = new UIFrameworkCatalogjQueryMobile145LandingPage(driver);
        UIFCjQueryMobileCheckBoxP = new UIFrameworkCatalogjQueryMobile145CheckboxPage(driver);
        UIFCjQueryMobileRadioButtonP = new UIFrameworkCatalogjQueryMobile145RadioButtonsPage(driver);
        UIFCjQueryMobileFormsP = new UIFrameworkCatalogjQueryMobile145FormsPage(driver);
        UIFCPhononLP = new UIFrameworkCatalogPhonon131LandingPage(driver);
        UIFCPhononPopoversP = new UIFrameworkCatalogPhonon131PopoversPage(driver);
        UIFCPhononFormsP = new UIFrameworkCatalogPhonon131FormsPage(driver);
        UIFCPhononDialogsP = new UIFrameworkCatalogPhonon131DialogsPage(driver);
        UIFCOnsenUIBeta5LP = new UIFrameworkCatalogOnsenUI200beta5LandingPage(driver);
        UIFCOnsenUIBeta5ListP = new UIFrameworkCatalogOnsenUI200beta5ListPage(driver);
        UIFCFramework7MaterialLP =  new UIFrameworkCatalogFramework7Material140LandingPage(driver);
        UIFCFramework7MaterialLoginscreenP = new UIFrameworkCatalogFramework7Material140LoginScreenPage(driver);
        UIFCFramework7MaterialSignInP = new UIFrameworkCatalogFramework7Material140SignInPage(driver);
        UIFCFramework7MaterialFormsP = new UIFrameworkCatalogFramework7Material140FormsPage(driver);
        UIFCFramework7MaterialFormsStorageP = new UIFrameworkCatalogFramework7Material140FormStoragePage(driver);
        UIFCFramework7MaterialAutocompleteP = new UIFrameworkCatalogFramework7Material140AutocompletePage(driver);
        UIFCFramework7MaterialContactsP = new UIFrameworkCatalogFramework7Material140ContactsPage(driver);
        APIDLP = new APIDemosLandingPage(driver);
        APIDViewsP = new APIDemosViewsPage(driver);
        APIDProgressP = new APIDemosProgressPage(driver);
        APIDIncrementalP = new APIDemosIncrementalPage(driver);
        APIDDateWidgetsP = new APIDemosDateWidgetPage(driver);
        APIDDialogP = new APIDemosDialogPage(driver);
        APIDSpinnerP = new APIDemosSpinnerPage(driver);

    }
    @AfterMethod
    public void EndTest(){
        service.stop();
        driver.quit();
    }
    public Double getFormattedAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }
}
