package com.exelenter.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;

public class _03_DataProviderDemo3 extends BaseClass {
    // Instead of repeating ourselves with many test methods (login1, login2, login3, etc.) instead we can use DataProvider
    @Test(dataProvider = "dataProviderMethod")
    public void loginTest(String username, String password) {
        sendText(loginPage.username, username);
        sendText(loginPage.password, password);
        click(loginPage.loginBtn);
        boolean welcomeDisplayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(welcomeDisplayed, "Welcome message is not displayed.");
    }

    @DataProvider
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {"Admin", "Exelent2022Sdet!"},
                {"johndoe", "k#G886@H"},
                {"EssUser", "Ess@2023"}
        };
    }
}