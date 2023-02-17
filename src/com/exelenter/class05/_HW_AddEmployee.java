package com.exelenter.class05;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;

import static org.testng.Assert.assertEquals;

/*
  Task: HW: Add Employees using Data Provider Annotation
         1. Open the Chrome browser
         2. Go to https://exelentersdet.com
         3. Login into the application
         4. Navigate to Add Employee Page
         5. Add 5 different Employees and create login credentials by providing:
             - First Name
             - Last Name
             - Username
             - Password
         6. Verify Employee has been added successfully and take screenshots (you must have 5 different screenshots)
         7. Close the browser
    BONUS: Specify a group name for this test case, and execute from the XML file.
 */

public class _HW_AddEmployee extends BaseClass {
    @Test(dataProvider = "addEmployees")
    public void addEmployeeTest(String firstName, String lastName, String userName, String password) {
        loginPage.loginToWebsite("username", "password");
        wait(1);
        pimPage.navigateToAddEmployee();
        wait(1);
        sendText(addEmployeePage.firstName, firstName);         // Sophia
        sendText(addEmployeePage.lastName, lastName);           // Patel
        String expectedEmployeeId = addEmployeePage.employeeId.getAttribute("value");
        System.out.println("expectedEmployeeId: " + expectedEmployeeId);
        click(addEmployeePage.createLoginDetailsCheckbox);
        wait(1);
        sendText(addEmployeePage.username, userName);          // sophiapatel
        sendText(addEmployeePage.password, password);          // password generator will create password here
        sendText(addEmployeePage.confirmPassword, password);   // re-enters the same generated password again.
        System.out.println("userName: " + userName);
        System.out.println("password: " + password);
        wait(1);
        click(addEmployeePage.saveButton);

        // 1st Validation without Try-Catch (not handling the exception, if there is going be one).
//        waitForVisibility(personalDetailsPage.personalDetailsHeader);  // wait for the Personal Details Page Header to become visible
//        String actualEmployeeId = personalDetailsPage.employeeId.getAttribute("value");
//        assertEquals(actualEmployeeId, expectedEmployeeId, "Employee ID does not match");
//        takeScreenshot(firstName + "_" + lastName);
//        System.out.println("The new employee is added successfully");

        // 2nd Validation with Try-Catch
        try {
            boolean headerDisplayed = personalDetailsPage.personalDetailsHeader.isDisplayed();
            if (headerDisplayed) {
                String actualEmployeeId = personalDetailsPage.employeeId.getAttribute("value");
                assertEquals(actualEmployeeId, expectedEmployeeId, "Employee ID does not match");
                takeScreenshot(firstName + "_" + lastName);
                System.out.println("The new employee is added successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 1st way to fail your test
//            System.out.println("Employee is not added. Username or ID already exits.");
//            Assert.fail();
            // 2nd way to fail my test
            throw  new RuntimeException("Employee is not added. Username or ID already exits.");
        }

    }

    @DataProvider
    public Object[][] addEmployees() {
        return new Object[][]{
                {"Sophia", "Patel", "sophiapatel123456", randomStrongPassWord()},
                {"Jackson", "Chen", "jacksonchen123456", randomStrongPassWord()},
                {"Isabella", "Rodriguez", "irodriguez", randomStrongPassWord()},
                {"Caleb", "Thomson", "calebthomson123456", randomStrongPassWord()},
                {"Zoe", "Kim", "zoekim123456", randomStrongPassWord()}
        };
    }

    // 2nd way: How to read data from Excel


}
