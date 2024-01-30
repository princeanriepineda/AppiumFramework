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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UIFrameworkCatalogFramework7Material140ContactsPage extends AndroidActions {
    AndroidDriver driver;

    public UIFrameworkCatalogFramework7Material140ContactsPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    //***************************************************************************************************
    @Step("Step: Table Sort Scenario: Validate the Sort Of Contact List Of A Values In The UIFramework 7 Material 1.4.0 Contact Page")
    @Severity(SeverityLevel.NORMAL)
    public  void UIFramework7Material140Contact() throws InterruptedException {
        Allure.step("Contact Sort List ");
        // Find elements using dynamic XPath for all elements with content description
        List<WebElement> allNameElements = driver.findElements(By.xpath("//android.view.View[@content-desc]"));
        // Extract actual names starting with the letter 'A' and store in a list
        List<String> actualNamesStartingWithA = new ArrayList<>();
        for (WebElement element : allNameElements) {
            String name = element.getAttribute("content-desc");
            if (name != null && name.startsWith("A")) {
                actualNamesStartingWithA.add(name);
            }
        }
        System.out.println("Extracted Names Starting with 'A':");
        for (String name : actualNamesStartingWithA) {
            System.out.println(name);
        }

        // Define specified values to be ignored during the check
        List<String> ignoredValues = Arrays.asList("Accordion", "Autocomplete", "A");
        // Check if the list is in alphabetical order (ignoring specified values)
        boolean isAlphabetical = true;
        for (int i = 1; i < actualNamesStartingWithA.size(); i++) {
            String prevName = actualNamesStartingWithA.get(i - 1);
            String currentName = actualNamesStartingWithA.get(i);

            // Compare names ignoring case and ignore specified values
            if (!ignoredValues.contains(prevName) && !ignoredValues.contains(currentName) &&
                    prevName.compareToIgnoreCase(currentName) > 0) {
                isAlphabetical = false;
                break;
            }
        }
        if (isAlphabetical) {
            System.out.println("The list is in alphabetical order (ignoring specified values).");

        } else {
            System.out.println("The list is NOT in alphabetical order (ignoring specified values).");
        }
        AndroidActions.screenshot(driver);
        Allure.addAttachment("Validation Passed!, Check Dropdown For The Sorted List",
                "Actual Sorted List Values(Note: Accordion, Autocomplete and A is Ignored): "+actualNamesStartingWithA);


//        // Find elements using dynamic XPath for all elements with content description
//        List<WebElement> allNameElements = driver.findElements(By.xpath("//android.view.View[@content-desc]"));
//
//        // Convert List<WebElement> to List<String> containing content-desc values starting with 'A'
//        List<String> actualNamesStartingWithA = allNameElements.stream()
//                .map(element -> element.getAttribute("content-desc"))
//                .filter(name -> name != null && name.startsWith("A"))
//                .collect(Collectors.toList());
//
//        // Sort the list alphabetically
//        Collections.sort(actualNamesStartingWithA);
//
//        // Print the extracted names in the desired format {"name1","name2"}
//        System.out.println("Extracted Names Starting with 'A' (Alphabetically Sorted):");
//        System.out.println("{" + String.join(",", actualNamesStartingWithA) + "}");






    }




}
