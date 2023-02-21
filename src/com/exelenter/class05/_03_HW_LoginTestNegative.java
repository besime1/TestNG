package com.exelenter.class05;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ExcelUtility;

public class _03_HW_LoginTestNegative extends BaseClass {
    @Test(dataProvider = "getData")
    public void userLogin(String username, String password,String expectedErrorMessage ){
        loginPage.loginToWebsite(username, password);
        Assert.assertEquals(loginPage.loginErrorMessage.getText(), expectedErrorMessage, "Error message is incorrect");
    }

    @DataProvider(name = "negativeLoginExcel")
    public Object[][] loginData(){
        String filePath = ExcelUtility.projectPath+"/testData/ExelenterEmployeesList.xlsx";
        return ExcelUtility.readFromExcel(filePath,"NegativeLoginTests");
    }

    @DataProvider
    Object[][] getData() {
        return new Object[][]{
                {"Admin", "invalidPass", "Invalid credentials"},           // valid user     invalid password
                {"admi123", "Exelent2022Sdet!", "Invalid credentials"},    // invalid user   valid password
                {"admi123", "invalidPass", "Invalid credentials"},         // invalid user   invalid password
                {"Admin", "", "Password cannot be empty"},                 // valid user     empty password
                {"Admi123", "", "Password cannot be empty"},               // invalid        empty
                {"", "Exelent2022Sdet!", "Username cannot be empty"},      // empty          valid
                {"", "invalidPass", "Username cannot be empty"},           // empty          invalid
                {"", "", "Username cannot be empty"}                       // empty          empty
        };
    }
}

