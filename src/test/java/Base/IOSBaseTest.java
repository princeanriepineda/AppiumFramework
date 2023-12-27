package Base;

import IOSPageobject.HomePage;
import Utils.AppiumUtils;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class IOSBaseTest extends AppiumUtils {

    public IOSDriver driver;
    public AppiumDriverLocalService service;

    public HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void ConfigureAppium() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/ResourcesAPK/data.properties");
        prop.load(fis);
        String ipAddress = prop.getProperty("ipAddress");
        String port = prop.getProperty("port");
        service = startAppiumServer(ipAddress,Integer.parseInt(port));
        WebDriverManager.chromedriver().setup();
            XCUITestOptions options = new XCUITestOptions();
            options.setDeviceName(prop.getProperty("IOSDeviceName"));
            options.setApp("/Users/princeanriepineda/Library/Developer/Xcode/DerivedData/UIKitCatalog-bmuehukijjqfqfhkywvfxtnfiemd/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
            options.setPlatformVersion("17.2");
            options.setWdaLaunchTimeout(Duration.ofSeconds(60));

        driver = new IOSDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);

    }

    @AfterMethod
    public void tearDown() {
    //End Phase
    service.stop();
    driver.quit();
    }

}
