package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public abstract class AppiumUtils {



    public AppiumDriverLocalService service;

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data =  mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});

        return data;
    }

    public Double getFormattedAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    public void waitForElementToAppear(WebElement ele, AndroidDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 10 seconds timeout
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]")),"text","Cart"));

    }

    public AppiumDriverLocalService startAppiumServer(String ipAddress, int port){
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress(ipAddress)
                .usingPort(port)
                .build();
        service.start();

        return service;
    }

}
