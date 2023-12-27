package Base;

import AndroidPageObject.GeneralStoreFormPage;
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
        options.setApp("/Users/princeanriepineda/IdeaProjects/AppiumTrainingHybridFramework/src/main/java/ResourcesAPK/General-Store.apk");
        options.setCapability("appium:chromedriverEnableAsyncDownload", true);
        driver = new AndroidDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        GSFormPage = new GeneralStoreFormPage(driver);

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
