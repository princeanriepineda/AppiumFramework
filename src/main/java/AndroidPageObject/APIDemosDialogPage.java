package AndroidPageObject;

import Actions.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class APIDemosDialogPage extends AndroidActions {

    AndroidDriver driver;

    public APIDemosDialogPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"change the date\"]")
    private WebElement ChangeTheDateBtn;
    @AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
    private WebElement OkModalBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"io.appium.android.apis:id/dateDisplay\"]")
    private WebElement DefaultDisplayDateHeader;
    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/date_picker_header_year\"]")
    private WebElement YearModalBtn;
    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/date_picker_header_date\"]")
    private WebElement DateHeaderModalBtn;
    @AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc=\"Next month\"]")
    private WebElement MonthNextModalBtn;
    @AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc=\"Previous month\"]")
    private WebElement MonthPreviousModalBtn;
    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"io.appium.android.apis:id/dateDisplay\"]")
    private WebElement DefaultDynamicDateHeader;

    //****************************************************************************
    @Step("Step: Date Picker Scenario: Validate: Select Dynamic date on your birth date field Dialog Page")
    @Severity(SeverityLevel.NORMAL)
    public void SelectDynamicDateOnYourBirthDatefield(String YearTarget, String Month, String Day, String SingleDigitAdder) throws InterruptedException {
        Allure.step("Change the Default Date By The Birth Date");
        ChangeTheDateBtn.click();
        String ActualYearValueModalBtn =  YearModalBtn.getText();
        if(ActualYearValueModalBtn.equalsIgnoreCase(YearTarget)){
            System.out.println("Current Year");
        } else {
            YearModalBtn.click();
            int scrollCount = 20; // Adjust the number of scrolls as needed
            for (int i = 0; i < scrollCount; i++) {
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().resourceId(\"android:id/date_picker_year_picker\"))"
                                + ".scrollToBeginning(1);"));
            }
            // Scroll to the desired element within the DatePicker
            WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().resourceId(\"android:id/datePicker\"))"
                            + ".scrollIntoView(new UiSelector().textContains(\""+YearTarget+"\"));"));
            element.click();
        }
        String ExpectedWholeDate =SingleDigitAdder+""+Day+" "+Month+" "+YearTarget;
        boolean elementClicked = false;
        while (true) {
            List<WebElement> targetDatePre = driver.findElements(By.xpath("//android.view.View[@text]"));
            for (WebElement element : targetDatePre) {
                // Get the text attribute value
                String textValue = element.getAttribute("text");
                // Check if the text attribute contains "10"
                if (textValue.equals(Day)) {
                    // Click the element
                    element.click();
                    // Get the content-desc attribute value
                    String actualWholeDate = element.getAttribute("content-desc");
                    // Check if ActualWholeDate matches ExpectedWholeDate
                    if (actualWholeDate.equalsIgnoreCase(ExpectedWholeDate)) {
                        // Perform additional actions if needed
                        // Set the flag to true indicating the element is clicked
                        elementClicked = true;
                        Allure.addAttachment("Validation Passed! Check Dropdown Values","Actual Date Values: "+actualWholeDate);
                        break;  // Break out of the inner loop once the element is clicked

                    } else {
                        // If not matches, reset the flag and continue to the next iteration
                        elementClicked = false;
                    }
                }
            }
            // Break out of the outer loop if the element is clicked
            if (elementClicked) {
                break;

            }
            // Click MonthNextModalBtn for the next iteration
            MonthNextModalBtn.click();
        }
        AndroidActions.screenshot(driver);
        OkModalBtn.click();

        Thread.sleep(1000);
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Default Date Header Values. Check Drop Down Values ",
                "Actual Value: "+DefaultDisplayDateHeader.getText());
    }

    //****************************************************************************
    @Step("Step: Date Picker Scenario: Validate: Select Next Week Date (7days) on custom date format field Dialog Page")
    @Severity(SeverityLevel.NORMAL)
    public void NextWeekDate7daysoncustomdateformatfield() throws InterruptedException {
        Allure.step("Change The Custom Date By Next Week Date (7days)");
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        // Print the current date in a custom format
        System.out.println("Current Date: " + currentDate);
        // Extract day, month, and year components
        int day = currentDate.getDayOfMonth();
        int monthValue = currentDate.getMonthValue();
        int year = currentDate.getYear();
        int DaysToAddCustom = 7;
        // Convert month value to its string representation
        String monthString = Month.of(monthValue).name();
        // Print day, month, and year
        System.out.println("Day of the Month: " + day);
        System.out.println("Month: " + monthString);
        System.out.println("Year: " + year);
        // Create a DateTimeFormatter for the desired output format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        // Calculate the target date by adding 15 days
        LocalDate targetDate = currentDate.plusDays(DaysToAddCustom);
        // Format the target date using the formatter
        String formattedTargetDate = targetDate.format(formatter);
        // Print the target date
        System.out.println("Target Date (Current Date + 15 days): " + formattedTargetDate);
        ChangeTheDateBtn.click();
        String TargetDateXpath ="//android.view.View[@content-desc=\""+formattedTargetDate+"\"]";
        try {
            WebElement DateTarget = driver.findElement(By.xpath(TargetDateXpath));
            DateTarget.click();
        } catch (NoSuchElementException e) {
            // Handle the case where the element is not found
            System.out.println("Element not found. Clicking nextMonthButton...");
            MonthNextModalBtn.click();
            WebElement DateTarget = driver.findElement(By.xpath(TargetDateXpath));
            DateTarget.click();
        }
        AndroidActions.screenshot(driver);
        WebElement DateTarget = driver.findElement(By.xpath(TargetDateXpath));
        Allure.addAttachment("Validation Passed! Check Dropdown Values","Actual Date Values: "+DateTarget.getAttribute("content-desc"));
        OkModalBtn.click();

        Thread.sleep(1000);
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Default Date Header Values. Check Drop Down Values ",
                "Actual Value: "+DefaultDisplayDateHeader.getText());
    }

    //****************************************************************************
    @Step("Step: Date Picker Scenario: Validate: Select Dynamic date range on Range Picker Field in Dialog Page")
    @Severity(SeverityLevel.NORMAL)
    public void SelectDynamicDateRangeOnRangePickerField(String YearTarget, String Month, String Day, String SingleDigitAdder) throws InterruptedException {
        Allure.step("Change the Default Date By The First Range To Last Range Of The Month Date");
        ChangeTheDateBtn.click();
        String ActualYearValueModalBtn = YearModalBtn.getText();
        if (ActualYearValueModalBtn.equalsIgnoreCase(YearTarget)) {
            System.out.println("Current Year");
        } else {
            YearModalBtn.click();
            int scrollCount = 20; // Adjust the number of scrolls as needed
            for (int i = 0; i < scrollCount; i++) {
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().resourceId(\"android:id/date_picker_year_picker\"))"
                                + ".scrollToBeginning(1);"));
            }
            // Scroll to the desired element within the DatePicker
            WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().resourceId(\"android:id/datePicker\"))"
                            + ".scrollIntoView(new UiSelector().textContains(\"" + YearTarget + "\"));"));
            element.click();
        }
        String ExpectedWholeDate = SingleDigitAdder + "" + Day + " " + Month + " " + YearTarget;
        boolean elementClicked = false;
        while (true) {
            List<WebElement> targetDatePre = driver.findElements(By.xpath("//android.view.View[@text]"));
            for (WebElement element : targetDatePre) {
                // Get the text attribute value
                String textValue = element.getAttribute("text");
                // Check if the text attribute contains "10"
                if (textValue.equals(Day)) {
                    // Click the element
                    element.click();
                    // Get the content-desc attribute value
                    String actualWholeDate = element.getAttribute("content-desc");
                    // Check if ActualWholeDate matches ExpectedWholeDate
                    if (actualWholeDate.equalsIgnoreCase(ExpectedWholeDate)) {
                        // Perform additional actions if needed
                        // Set the flag to true indicating the element is clicked
                        elementClicked = true;
                        Allure.addAttachment("Validation Passed! Check Dropdown Values", "Actual Date Values: " + actualWholeDate);
                        break;  // Break out of the inner loop once the element is clicked

                    } else {
                        // If not matches, reset the flag and continue to the next iteration
                        elementClicked = false;
                    }
                }
            }
            // Break out of the outer loop if the element is clicked
            if (elementClicked) {
                break;

            }
            // Click MonthNextModalBtn for the next iteration
            MonthNextModalBtn.click();
        }
        AndroidActions.screenshot(driver);
        OkModalBtn.click();

        Thread.sleep(1000);
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Default Date Header Values. Check Drop Down Values ",
                "Actual Value: "+DefaultDisplayDateHeader.getText());
    }
}
