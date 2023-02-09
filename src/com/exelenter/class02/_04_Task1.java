package com.exelenter.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

public class _04_Task1 extends BaseClass {
    /**
     * Task: Dashboard Logo Validation
     *       1. Using TestNG, login to ExelenterSdet.com website,
     *       2. Verify dashboard logo is displayed.
     */

    @BeforeMethod
    void openBrowser() {
        setUp();
    }

    @AfterMethod
    void quitBrowser() {
        tearDown();
    }
    @Test
    void dashboardLogoValidation() {
        var login = new LoginPage();
        sendText(login.username, ConfigsReader.getProperties("username"));
        sendText(login.password, ConfigsReader.getProperties("password"));
        clickButWaitForClickability(login.loginBtn);

        var dashboard = new DashboardPage();
        Assert.assertTrue(dashboard.dashboardLogo.isDisplayed(), "Dashboard Logo is not displayed");
    }
}
