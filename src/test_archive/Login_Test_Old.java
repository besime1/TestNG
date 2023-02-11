package test_archive;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ConfigsReader;

/**
 * US 16457: As an Admin User, I should not be able to login to the application using invalid credentials.    <== High Level explanation of the feature.
 */

public class Login_Test_Old extends BaseClass {
    @Test
    public void validAdminLogin() {
        loginPage.loginToWebsite("username", "password");
        String expectedText = "Welcome Admin";
        String actualText = dashboardPage.welcome.getText();
        Assert.assertEquals(actualText, expectedText, "'Welcome Admin' text is incorrect");
    }

    @Test
    public void validUserInvalidPassword() {
        String invalidPassword = "Pass1234";
        String expectedErrorMessage = "Invalid credentials";
        sendText(loginPage.username, ConfigsReader.getProperties("username"));    // Valid Username
        sendText(loginPage.password, invalidPassword);                                // Invalid Password
        click(loginPage.loginBtn);
        Assert.assertEquals(loginPage.loginErrorMessage.getText(), expectedErrorMessage, "Error message is incorrect");
    }

    @Test
    public void validUserEmptyPassword() {
        String expectedErrorMessage = "Password cannot be empty";
        sendText(loginPage.username, ConfigsReader.getProperties("username"));   // Valid Username, Password empty (skipped).
        click(loginPage.loginBtn);
        Assert.assertEquals(loginPage.loginErrorMessage.getText(), expectedErrorMessage, "Error message is incorrect");
    }
}
