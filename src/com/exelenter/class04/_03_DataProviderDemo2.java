package com.exelenter.class04;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;

public class _03_DataProviderDemo2 extends BaseClass {
    // Instead of repeating ourselves with many test methods (login1, login2, login3, etc.) instead we can use DataProvider
    @Test(dependsOnMethods ="loginTest2")
    public void loginTest1() {
        sendText(loginPage.username, "Admin");
        sendText(loginPage.password, "Exelent2022Sdet!");
        click(loginPage.loginBtn);
        boolean welcomeDisplayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(welcomeDisplayed, "Welcome message is not displayed.");
    }

    @Test
    public void loginTest2() {
        sendText(loginPage.username, "johndoe"); // Stale
        sendText(loginPage.password, "k#G886@H");
        click(loginPage.loginBtn);
        boolean welcomeDisplayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(welcomeDisplayed, "Welcome message is not displayed.");
    }

    @Test
    public void loginTest3() {
        sendText(loginPage.username, "EssUser");
        sendText(loginPage.password, "Ess@2023");
        click(loginPage.loginBtn);
        boolean welcomeDisplayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(welcomeDisplayed, "Welcome message is not displayed.");
    }
}
