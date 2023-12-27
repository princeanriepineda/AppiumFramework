package TestCases;

import Base.IOSBaseTest;
import IOSPageobject.AlertViews;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSBasics extends IOSBaseTest {

    @Test
    public void IOSBasicsTest(){
        System.out.println("appium started");

        AlertViews alertViews = homePage.selectAlertViews();
        alertViews.fillTextLabel("hello world");
        String actualMessege = alertViews.getConfirmedMessege();
        Assert.assertEquals(actualMessege,"A message should be a short, complete sentence.");




    }
}
