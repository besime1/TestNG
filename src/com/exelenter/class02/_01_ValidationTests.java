package com.exelenter.class02;

import org.testng.annotations.*;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

public class _01_ValidationTests extends BaseClass {
    /**
     * Todo: We will copy from Selenium Project following folders & packages:
     *    1. utils package DONE
     *    2. page package DONE
     *    3. test package DONE
     *    4. Selenium JARs. DONE
     *    5. Drivers folder  DONE
     *    6. configs folder DONE
     */
    // We need to call WebDriver and also Quit WebDriver before and after EACH TEST.
    @BeforeMethod
    void openBrowser() {
        setUp();
    }

    @AfterMethod
    void afterMethod() {
        tearDown();
    }

    @Test
    void titleValidation() {
        String expectedTitle ="Exelenter Project";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle))
            System.out.println("Title does match. Test passed.");
        else
            System.out.println("Title does not match. Test failed.");
    }
    @Test
    void logoValidation() {
        LoginPage loginPage = new LoginPage();
        boolean logoDisplayed = loginPage.homepageLogo.isDisplayed();
        if (logoDisplayed)
            System.out.println("Logo is displayed. Test passed.");
        else
            System.out.println("Logo is not displayed. Test failed.");
    }
    @Test
    void validLoginTest() {
        LoginPage login = new LoginPage();
//        sendText(login.username, "Admin");  // <== This is hard coding, not recommended.
        sendText(login.username, ConfigsReader.getProperties("username"));
        sendText(login.password, ConfigsReader.getProperties("password"));
        click(login.loginBtn);

        DashboardPage dashboard = new DashboardPage();
        String expectedValue = "Welcome Admin";
        String actualValue = dashboard.welcome.getText();
        if (expectedValue.equals(actualValue))
            System.out.println("Login successful.");
        else
            System.out.println("Login failed.");
    }
}
