package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;
    private By INPUT_EMAIL = By.xpath("//div[contains(text(), 'Administrator Users Only')]/parent::div/following-sibling::form//input[@name='email']");
    private By INPUT_PASSWORD = By.xpath("//div[contains(text(), 'Administrator Users Only')]/parent::div/following-sibling::form//input[@name='password']");
    private By CHK_REMEMBER_ME = By.xpath("//input[@name='remember']");
    private By LBL_REMEMBER_ME = By.xpath("//label[contains(@class, 'checkbox')]");
    private By BTN_LOGIN = By.xpath("//div[contains(text(), 'Administrator Users Only')]/parent::div/following-sibling::form//button");
    private By PLACEHOLDER_INPUT_EMAIL = By.xpath("//div[contains(text(), 'Administrator Users Only')]/parent::div/following-sibling::form//input[@name='email']/following-sibling::span");
    private By PLACEHOLDER_INPUT_PWD = By.xpath("//div[contains(text(), 'Administrator Users Only')]/parent::div/following-sibling::form//input[@name='password']/following-sibling::span");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillDataLogin (String inputEmail, String inputPwd) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement eleInputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_EMAIL));
        WebElement eleInputPwd = wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_PASSWORD));
        WebElement eleBtnLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(BTN_LOGIN));
        eleInputEmail.sendKeys(inputEmail);
        eleInputPwd.sendKeys(inputPwd);
        eleBtnLogin.click();
    }

    public void verifyDisplayPlaceholderInputs () {
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement elePlaceholderInputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(PLACEHOLDER_INPUT_EMAIL));
        WebElement elePlaceholderInputPwd = wait.until(ExpectedConditions.visibilityOfElementLocated(PLACEHOLDER_INPUT_PWD));
        String textEmailExpected = "Email";
        String textPwdExpected = "Password";
        Assert.assertTrue(elePlaceholderInputEmail.getText().equals(textEmailExpected));
        Assert.assertTrue(elePlaceholderInputPwd.getText().equals(textPwdExpected));
    }

    public void verifyClickCheckBoxRememberMe () {
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement eleLabelRememberMe = wait.until(ExpectedConditions.visibilityOfElementLocated(LBL_REMEMBER_ME));
        eleLabelRememberMe.click();
        WebElement eleChkRememberMe = wait.until(ExpectedConditions.presenceOfElementLocated(CHK_REMEMBER_ME));
        Assert.assertTrue(isClickCheckBox(eleChkRememberMe));
    }

    private boolean isClickCheckBox (WebElement eleCheckBox) {
        return eleCheckBox.isSelected();
    }
}
