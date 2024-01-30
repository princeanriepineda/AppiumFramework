package AndroidPageObject;

import Actions.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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
import java.time.LocalDateTime;
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
    @AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
    private WebElement TimeOkModalBtn;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"change the time (spinner)\"]")
    private WebElement ChangeTheTimeSpinnerBtn;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\"pm\"]")
    private  WebElement PMPicker;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\"am\"]")
    private  WebElement AMPicker;


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
                        Assert.assertEquals(actualWholeDate,ExpectedWholeDate,"Mismatch Selected Date");
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

        int MonthNumber = getMonthNumber(Month);
        String ExpectedWholeDate2 =MonthNumber+"-"+Day+"-"+YearTarget+" 01:02";
        Thread.sleep(1000);
        AndroidActions.screenshot(driver);
        Assert.assertEquals(DefaultDisplayDateHeader.getText(),ExpectedWholeDate2,"Mismatch Selected in Date Header");
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
            //place explicit
            // Handle the case where the element is not found
            System.out.println("Element not found. Clicking nextMonthButton...");
            MonthNextModalBtn.click();
            WebElement DateTarget = driver.findElement(By.xpath(TargetDateXpath));
            DateTarget.click();
        }
        AndroidActions.screenshot(driver);
        WebElement DateTarget = driver.findElement(By.xpath(TargetDateXpath));
        Allure.addAttachment("Validation Passed! Check Dropdown Values","Actual Date Values: "+DateTarget.getAttribute("content-desc"));
        String ContentDescExpected = DateTarget.getAttribute("content-desc");
        String numericValueStringExpected = ContentDescExpected.replaceAll("\\D+", "");
        OkModalBtn.click();

        Thread.sleep(1000);
        AndroidActions.screenshot(driver);
        String ExpectedOutputDateHeader=monthValue+""+numericValueStringExpected+"0102";
        String ContentDescActual = DefaultDisplayDateHeader.getAttribute("text");
        String numericValueStringActual = ContentDescActual.replaceAll("\\D+", "");
        String ActualOutputDateHeader = numericValueStringActual;

        Assert.assertEquals(ActualOutputDateHeader,ExpectedOutputDateHeader,"Mismatch Date Outputs");
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
                        Assert.assertEquals(actualWholeDate,ExpectedWholeDate,"Mismatch Selected Date");
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

        int MonthNumber = getMonthNumber(Month);
        String ExpectedWholeDate2 =MonthNumber+"-"+Day+"-"+YearTarget+" 01:02";
        Thread.sleep(1000);
        AndroidActions.screenshot(driver);
        Assert.assertEquals(DefaultDisplayDateHeader.getText(),ExpectedWholeDate2,"Mismatch Selected in Date Header");
        Allure.addAttachment("Default Date Header Values. Check Drop Down Values ",
                "Actual Value: "+DefaultDisplayDateHeader.getText());
    }

    //****************************************************************************
    @Step("Step: Time Picker Scenario: Validate: Select Dynamic Time on time picker field spinner in Dialog Page")
    @Severity(SeverityLevel.NORMAL)
    public void SelectDynamicTimeOnTimePickerFieldSpinner(int HourValue, int MinuteValue, String AMorPM) throws InterruptedException {
        Allure.step("Change the Default Time By The Specific Time");
        ChangeTheTimeSpinnerBtn.click();

        if (HourValue % 2 == 0) {
            WebElement targetDefault = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\"1\"]"));
            targetDefault.click();
            driver.pressKey(new KeyEvent(AndroidKey.DEL));
            targetDefault.sendKeys("2");
            // Press the Enter key on the keypad using AndroidKey enum
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            //DragAndDrop(targetDefault, 322, 986);
            //Thread.sleep(4000);
            WebElement Target = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                            + "new UiSelector().resourceId(\"android:id/numberpicker_input\").text(\""+HourValue+"\"));"));
            String ActualHourValue = Target.getText();
            int ActualConvertedIntegerValue = Integer.parseInt(ActualHourValue);
            Assert.assertEquals(ActualConvertedIntegerValue, HourValue, "Mismatch in Scroll");
        } else {
            WebElement targetDefault = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\"1\"]"));
            targetDefault.click();
            driver.pressKey(new KeyEvent(AndroidKey.DEL));
            targetDefault.sendKeys("3");
            // Press the Enter key on the keypad using AndroidKey enum
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            WebElement Target = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                            //+ "new UiSelector().resourceId(\"android:id/numberpicker_input\").text(\""+HourValue+"\"));"));
                            + "new UiSelector().text(\""+HourValue+"\"));"));
            String ActualHourValue = Target.getText();
            int ActualConvertedIntegerValue = Integer.parseInt(ActualHourValue);
            Assert.assertEquals(ActualConvertedIntegerValue, HourValue, "Mismatch in Scroll");
        }

        //*******************************************************************************************

//        WebElement TargetDefaultPicker2 = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\"02\"]"));
//        DragAndDrop(TargetDefaultPicker2,544,907);

        String result;

        if (MinuteValue >= 0 && MinuteValue <= 9) {
            // Using String.format to add leading zero
            result = String.format("%02d", MinuteValue);

            WebElement targetDefault = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\"02\"]"));
            targetDefault.click();
            driver.pressKey(new KeyEvent(AndroidKey.DEL));
            targetDefault.sendKeys(result);
            // Press the Enter key on the keypad using AndroidKey enum
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));

            WebElement Target = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\""+result+"\"]"));

            String ActualMinuteValue = Target.getText();
            Assert.assertEquals(ActualMinuteValue, result, "Mismatch in Scroll");

            System.out.println("Result: " + result);
        } else {
            String strNumber = String.valueOf(MinuteValue);
            WebElement targetDefault = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\"02\"]"));
            targetDefault.click();
            driver.pressKey(new KeyEvent(AndroidKey.DEL));
            targetDefault.sendKeys(strNumber);
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));

            WebElement Target = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\""+strNumber+"\"]"));

            String ActualMinuteValue = Target.getText();
            int ActualConvertedIntegerValue = Integer.parseInt(ActualMinuteValue);
            Assert.assertEquals(ActualConvertedIntegerValue, MinuteValue, "Mismatch in Scroll");

            System.out.println("Number is not a single digit.");
        }

        //*******************************************************************************************

        if (HourValue % 2 == 0) {

            if (AMorPM.equals("PM")) {
                DragAndDrop(AMPicker, 763, 944);
                Assert.assertEquals(PMPicker.getText(), "pm");
                Allure.addAttachment("Validation Passed In PM", "Actual Values: " + PMPicker.getText());
            } else {
                //DragAndDrop(PMPicker, 767, 1283);
                Assert.assertEquals(AMPicker.getText(), "am");
                Allure.addAttachment("Validation Passed In AM", "Actual Values: " + AMPicker.getText());
            }
        }else {
            if (AMorPM.equals("PM")) {
                //DragAndDrop(PMPicker, 767, 1283);
                Assert.assertEquals(PMPicker.getText(), "pm");
                Allure.addAttachment("Validation Passed In PM", "Actual Values: " + PMPicker.getText());


//                Assert.assertEquals(AMPicker.getText(), "am");
//                Allure.addAttachment("Validation Passed In AM", "Actual Values: " + AMPicker.getText());
            } else {
                //DragAndDrop(AMPicker, 763, 944);
                DragAndDrop(PMPicker, 767, 1283);

                Assert.assertEquals(AMPicker.getText(), "am");
                Allure.addAttachment("Validation Passed In AM", "Actual Values: " + AMPicker.getText());


//                Assert.assertEquals(PMPicker.getText(), "pm");
//                Allure.addAttachment("Validation Passed In PM", "Actual Values: " + PMPicker.getText());
            }
        }

        TimeOkModalBtn.click();

        String ActualDateAfterChanging = DefaultDisplayDateHeader.getText();
        // Get the current local date and time
        LocalDateTime now = LocalDateTime.now();
        // Define the desired date and time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-dd-yyyy");
        // Format the LocalDateTime to a String
        String formattedDateTime = now.format(formatter);
        // Print the formatted date and time
        System.out.println("Formatted Date and Time: " + formattedDateTime);

        String HH, MM;

        // Format hour
        if (HourValue >= 0 && HourValue <= 9) {
            HH = String.format("%02d", HourValue);
        } else {
            HH = String.valueOf(HourValue);
        }

        // Format minute
        if (MinuteValue >= 0 && MinuteValue <= 9) {
            MM = String.format("%02d", MinuteValue);
        } else {
            MM = String.valueOf(MinuteValue);
        }

        // Convert to military time if PM
        if (AMorPM.equals("PM")) {
            if (HourValue != 12) {
                HH = String.valueOf(HourValue + 12);
            }
        }

        Assert.assertEquals(ActualDateAfterChanging,formattedDateTime+" "+HH+":"+MM);
        Allure.addAttachment("Validation Passed By Date And Time","Actualvalues: "+ActualDateAfterChanging);
    }




















    }


