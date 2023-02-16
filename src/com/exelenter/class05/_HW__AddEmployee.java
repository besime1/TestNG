package com.exelenter.class05;
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

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;

import static org.testng.Assert.assertEquals;

public class _HW__AddEmployee extends BaseClass {
    @Test(dataProvider  ="addEmployee")
    public  void  addEmployeeTest(String firstName,String lastName,String userName,String password){
        loginPage.loginToWebsite("username","password");
        pimPage.navigateToAddEmployee();
        wait(1);
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.lastName, lastName);
        String expectedEmployeeId=addEmployeePage.employeeId.getAttribute("value");
        System.out.println("expectedEmployeeId:"+expectedEmployeeId);
        click(addEmployeePage.createLoginDetailsCheckbox);
        wait(1);
        sendText(addEmployeePage.username, userName);
        sendText(addEmployeePage.password, password);
        sendText(addEmployeePage.confirmPassword, password);
        System.out.println("userName:"+userName);
        System.out.println("password:"+password);
        wait(1);
        click(addEmployeePage.saveButton);

        //Validation
        waitForVisibility(personalDetailsPage.personalDetailsHeader);//wait for personal
        String  actualEmployeeId= personalDetailsPage.employeeId.getAttribute("value");
       assertEquals(actualEmployeeId,expectedEmployeeId,"Employee ID does not match");
       takeScreenshot(firstName+"_"+ lastName);
        System.out.println("The new employee is added successfully");
    }
    @DataProvider
    public  Object[][] addEmployees(){
        return  new Object[][]{
                { "Sophia", "Patel" ,"sophiapatel",randomStrongPassWord()},
                { "Jackson","Chen","jacksonchen",randomStrongPassWord()},
                {"Isabella","Rodriguez","irodriguez",randomStrongPassWord()},

        };
    }

}
