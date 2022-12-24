package TestProject.Tests;

import Framework.BaseTest.BaseTest;
import Framework.ConfigUtils.ConfigUtils;
import Framework.DriverUtils.Driver;
import TestProject.PageObjectModels.AlertsPage;
import TestProject.PageObjectModels.DemoQAMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQA1Test extends BaseTest {

    DemoQAMainPage demoQAMainPage;
    AlertsPage alertsPage;

    @Test
    public void demoQA1Test(){
        demoQAMainPage = new DemoQAMainPage();
        alertsPage = new AlertsPage();

        demoQAMainPage.openPage(ConfigUtils.getURL());
        Assert.assertTrue(demoQAMainPage.isPageOpened());

        demoQAMainPage.openAlerts();
        alertsPage.clickMenuItemButton();
        Assert.assertTrue(alertsPage.isAlertsFragmentOpened());

        alertsPage.clickAlertButton();
        String alertText = alertsPage.getAlertText();
        System.out.println(alertText);
        Assert.assertEquals(alertText,"You clicked a button");

        alertsPage.acceptAlert();
        Assert.assertFalse(alertsPage.isAlertOpened());


    }
}
