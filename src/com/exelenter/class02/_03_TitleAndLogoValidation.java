package com.exelenter.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseClass;

public class _03_TitleAndLogoValidation extends BaseClass {
    @BeforeMethod
    void openBrowser() {
        setUp();
    }

    @AfterMethod
    void quitBrowser() {
        tearDown();
    }

    @Test
    void titleValidation() {
        String expectedTitle = "Exelenter Project!!!";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
    }

    @Test(dependsOnMethods = "titleValidation")
    void logoValidation() {
        LoginPage login = new LoginPage();
        boolean logoDisplayed = login.homepageLogo.isDisplayed();
        Assert.assertTrue(logoDisplayed, "Logo is not displayed");
    }

    // Note: If a test assertion fails, test will continue and quit the browser, because Assert has a built-in Try-Catch.
}
