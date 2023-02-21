package com.exelenter.class05;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ExcelUtility;

/**
 * US 12567: As an Invalid User, I should not be able to login using invalid login credentials, and if I try, I should see an error message.
 * Acceptance Criteria:
 * 1. When User enters a valid username and an invalid password
 * An 'Invalid credentials' error message is presented.
 * 2. When a User enters an invalid username and a valid password
 * An 'Invalid credentials' error message is presented.
 * 3. When a User enters invalid username and invalid password
 * An 'Invalid credentials' error message is presented.
 * 4. When a User enters valid username and an empty password
 * A 'Password cannot be empty' error message is displayed.
 * 5. When a User enters an invalid username and an empty password
 * A 'Password cannot be empty' error message is displayed.
 * 6. When a User enters an empty username and a valid password
 * A 'Username cannot be empty' error message is presented.
 * 7. When a User enters an empty username and an invalid password
 * A 'Username cannot be empty' error message is presented.
 * 8. When a User enters an empty username and an empty password
 * A 'Username cannot be empty' error message is presented.
 * <p>
 * Do it using both local data & from Excel.
 */
public class _03_HW_LoginTestNegative extends BaseClass {
    // Retrieve data using both local DataProvider OR from Excel by changing the name for dataProvider attribute.
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

