package com.exelenter.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PersonalDetailsPage;
import utils.BaseClass;

/*
  Task: Add Employees using Data Provider Annotation
         1. Open the Chrome browser
         2. Go to https://exelentersdet.com/
         3. Login into the application
         4. Navigate to Add Employee Page
         5. Add a new employee by providing
             - First Name
             - Last Name
         6. Click Save Button to save employee
         7. Close the browser
 */
public class _05_AddEmployee extends BaseClass {
    @Test(dataProvider = "testOne")
    public void addEmployeeTest(String firstname,String lastname){
        loginPage.loginToWebsite("username","password");
        wait(1);
        pimPage.navigateToAddEmployee();
        sendText(addEmployeePage.firstName, firstname);
        sendText(addEmployeePage.lastName, lastname);
        String expectedEmployeeId= addEmployeePage.employeeId.getAttribute("value");
        click(addEmployeePage.saveButton);
        // Validation
        waitForVisibility(personalDetailsPage.personalDetailsHeader);
        String actualEmployeeId = personalDetailsPage.employeeId.getAttribute("value");
        Assert.assertEquals(actualEmployeeId, expectedEmployeeId, "Employee Id doesn't match");
    }

    @DataProvider(name = "testOne")   // When calling DataProvider in your @Test, you can either use name of method OR alias name.
    public Object[][] addEmployees() {
        Object[][] employee = {
                {"John", "Doe"},
                {"Jack", "Sparrow"}
        };
        return employee;
    }

}
