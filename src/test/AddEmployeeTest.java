package test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;

public class AddEmployeeTest extends BaseClass {
    @BeforeMethod
    void startBrowser() {
        setUp();
        initialize();
    }
    @AfterMethod
    void quitBrowser() {

        tearDown();
    }
    @Test
    public void addEmployeeTest() {
//        LoginPage loginPage = new LoginPage();
        loginPage.loginToWebsite("username", "password");

//        PIMPage pimPage = new PIMPage();
        pimPage.navigateToAddEmployee();

//        AddEmployeePage addEmployeePage = new AddEmployeePage();
        System.out.println("New Employee ID: " + addEmployeePage.employeeId.getAttribute("value"));
//        sendText(addEmployeePage.firstName, ConfigsReader.getProperties("empFirstname"));
//        sendText(addEmployeePage.lastName, ConfigsReader.getProperties("empLastname"));
//        sendText(addEmployeePage.uploadPhoto, ConfigsReader.getProperties("filePath"));    // Retrieving photo location for uploading
//        click(addEmployeePage.saveButton);
        addEmployeePage.addEmployee("empFirstname", "empLastname", "filePath");      // This method will add a new employee, replace above 4 lines
    }

}
