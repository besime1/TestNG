package com.exelenter.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

/**
 * TC 01: Login Validation Test (Happy Path)
 *   1. Open Chrome browser
 *   2. Go to https://exelentersdet.com
 *   3. Enter valid username and valid password
 *   4. Click on login button
 *   5. Verify login is successful
 *   6. Close the browser
 *
 * TC 02: Login Validation Test (Negative Test)
 *    1. Open Chrome browser
 *    2. Go to http://exelentersdet.com
 *    3. Enter valid username
 *    4. Leave password field empty
 *    5. Verify error message with text “Password cannot be empty” is displayed.
 */
public class _02_AssertDemo extends BaseClass {
    @BeforeMethod
    void openBrowser() {
        setUp();
    }

    @AfterMethod
    void quitBrowser() {
        tearDown();
    }

    @Test
    void validLoginTest() {
        LoginPage login = new LoginPage();
        sendText(login.username, ConfigsReader.getProperties("username"));
        sendText(login.password, ConfigsReader.getProperties("password"));
        clickButWaitForClickability(login.loginBtn);

        // validation
        DashboardPage dashboard = new DashboardPage();
        String expectedText = "Welcome Admin";
        String actualText = dashboard.welcome.getText();
        Assert.assertEquals(actualText, expectedText, "'Welcome Admin' text is incorrect");  // Message is optional and prints only if the test fails.

        // Assertion in one line
        //Assert.assertEquals(dashboard.welcome.getText(), "Welcome Admin", "'Welcome Admin' text is incorrect");
    }

    @Test
    void invalidLoginTest() {
        String expectedErrorMessage ="Password cannot be empty";
        LoginPage login = new LoginPage();
        sendText(login.username, ConfigsReader.getProperties("username"));
        clickButWaitForClickability(login.loginBtn);
        Assert.assertEquals(login.loginErrorMessage.getText(),expectedErrorMessage, "Message Error is incorrect.");
    }


}
