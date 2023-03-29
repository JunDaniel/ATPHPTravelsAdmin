package testcases;

import base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseSetup {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Parameters({ "email", "pwd" })
    @Test()
    public void tc01_verifyLoginPHPTravelAdmin(String email, String pwd) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillDataLogin(email, pwd);
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyLoginPhpTravelAdmin();
    }

    @Test
    public void tc02_verifyDisplayPlaceholderInputs () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyDisplayPlaceholderInputs();
    }

    @Test
    public void tc03_verifyClickCheckboxRememberMe () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyClickCheckBoxRememberMe();
    }
}
