package test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;
public class AddEmployeeTest extends BaseClass {
    @Test
    public void addEmployeeTest() {
        loginPage.loginToWebsite("username", "password");
        pimPage.navigateToAddEmployee();
        System.out.println("New Employee ID: " + addEmployeePage.employeeId.getAttribute("value"));
        addEmployeePage.addEmployee("empFirstname", "empLastname", "filePath"); // This method will add a new employee
    }
}
