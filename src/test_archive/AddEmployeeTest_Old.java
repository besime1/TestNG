package test_archive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddEmployeePage;
import pages.LoginPage;
import pages.PIMPage;
import utils.BaseClass;
import utils.ConfigsReader;


public class AddEmployeeTest_Old extends BaseClass{
    @BeforeMethod
    void startBrowser() {
        setUp();
        initialize();      // We are creating an instance of a page object here

    }
    @AfterMethod
    void quitBrowser() {
        tearDown();
    }

    @Test
    public void addEmployeeTest() {
        LoginPage loginPage = new LoginPage();
        sendText(loginPage.username, ConfigsReader.getProperties("username"));       // Valid Username
        sendText(loginPage.password, ConfigsReader.getProperties("password"));       // Valid Password
        click(loginPage.loginBtn);

        PIMPage pimPage = new PIMPage();
        pimPage.navigateToAddEmployee();

        AddEmployeePage addEmployeePage = new AddEmployeePage();
        System.out.println("New Employee ID: " + addEmployeePage.employeeId.getAttribute("value"));
        sendText(addEmployeePage.firstName, ConfigsReader.getProperties("empFirstname"));
        sendText(addEmployeePage.lastName, ConfigsReader.getProperties("empLastname"));
        sendText(addEmployeePage.uploadPhoto, ConfigsReader.getProperties("filePath"));    // Retrieving photo location for uploading
        click(addEmployeePage.saveButton);
    }
}
