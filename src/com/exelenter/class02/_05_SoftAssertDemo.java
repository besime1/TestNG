package com.exelenter.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

public class _05_SoftAssertDemo extends BaseClass {
    @BeforeMethod
    void openBrowser() {
        setUp();
    }

    @AfterMethod
    void quitBrowser() {
        tearDown();
    }

    @Test
    void softAssertionTest() {
        // First: Verify logo is displayed
        LoginPage login = new LoginPage();
        boolean logoDisplayed = login.homepageLogo.isDisplayed();
        logoDisplayed = false;
//        Assert.assertTrue(logoDisplayed, "Login logo is not displayed.");   // Validating logo   <== Hard Assert, if fails, following steps will not continue

        // Soft Assert (if soft assert fails, remaining test steps will continue)
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(logoDisplayed, "Login logo is not displayed.");     // <== Soft Assert, if fails, following steps will continue.

        // Second: Login to the website
        sendText(login.username, ConfigsReader.getProperties("username"));
        sendText(login.password, ConfigsReader.getProperties("password"));
        clickButWaitForClickability(login.loginBtn);
        DashboardPage dashboard = new DashboardPage();
        Assert.assertEquals(dashboard.welcome.getText(), "Welcome Admin", "'Welcome Admin' text is incorrect");  // Validating login
        System.out.println("Using Hard Assert if previous test assertion fails, this line will not print.");

        // assertAll() method must be used at the end of soft-assert test. This will check ALL assertions, if one fails all test fails.
        // but if you forget it, if one passes, entire @Test passes.
        softAssert.assertAll();
        System.out.println("After assertAll(), this line will not be executed if any test fails.");
        System.out.println("ALL Tests passed.");
    }


    /**
     *   Test Case: Login Validation
     *
     *   SoftAssert
     *     Step 1
     *     Step 2 <-- failed here
     *     Step 3 <-- Continue
     *     Step 4 <-- Continue
     *
     *   Assert (Recommended)
     *     Step 1
     *     Step 2 <-- failed here, stops right here.
     *     Step 3 <-- Skip
     *     Step 4 <-- Skip
     */

}
