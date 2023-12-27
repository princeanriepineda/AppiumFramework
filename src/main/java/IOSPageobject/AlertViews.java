package IOSPageobject;

import Actions.IOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertViews extends IOSActions {

    IOSDriver driver;

    public AlertViews(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]")
    private WebElement textEntryMenu;

    @iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
    private  WebElement confirmPopup;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private WebElement textBox;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement acceptPopup;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"A message should be a short, complete sentence.\"")
    private  WebElement confirmMessage;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Confirm\"")
    private WebElement submit;

    public void fillTextLabel(String name){
        textEntryMenu.click();
        textBox.sendKeys(name);
        acceptPopup.click();
    }

    public String getConfirmedMessege(){
        confirmPopup.click();
        return confirmMessage.getText();
    }

}
