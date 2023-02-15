package com.exelenter.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;

public class _04_DataProviderDemo3 extends BaseClass {

    // Instead of repeating ourselves with many test methods (login1, login2, login3, etc.) instead we can use DataProvider
    @Test(dataProvider = "loginTests")
    public void loginTest(String username, String password, int age) {
        System.out.println(username + " " + age);
        sendText(loginPage.username, username);
        sendText(loginPage.password, password);
        click(loginPage.loginBtn);
        boolean welcomeDisplayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(welcomeDisplayed, "Welcome message is not displayed.");
    }

    @DataProvider(name = "loginTests")
    public Object[][] dataProviderMethod() {
        Object[][] data = {
                {"Admin", "Exelent2022Sdet!", 25},
                {"johndoe", "k#G886@H", 35},
                {"EssUser", "Ess@2023", 45}
        };

        // 2nd way of declaring and initializing of 2D array.
//        Object[][] data2 = new Object[3][3];
//        data2[0][0] = "Admin";
//        data2[0][1] = "Exelent2022Sdet!";
//        data2[0][2] = 25;
//
//        data2[1][0] = "johndoe";
//        data2[1][1] = "k#G886@H";
//        data2[1][2] = 35;
//
//        data2[2][0] = "EssUser";
//        data2[2][1] = "Ess@2023";
//        data2[2][2] = 45;

        return data;
//        return data2;
    }
}