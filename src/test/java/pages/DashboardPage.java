package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage {
    private WebDriver driver;
    private By TITLE_DASHBOARD = By.xpath("//h1[contains(text(), 'Dashboard')]");
    private By SALES_OVERVIEW_SUMMARY = By.xpath("//div[contains(text(), 'Sales overview & summary')]");

    public DashboardPage (WebDriver driver) {
        this.driver = driver;
    }

    public void verifyLoginPhpTravelAdmin () {
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement eleTitleDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_DASHBOARD));
        WebElement eleSaleOverviewSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(SALES_OVERVIEW_SUMMARY));
        Assert.assertTrue(eleTitleDashboard.isDisplayed());
        Assert.assertTrue(eleSaleOverviewSummary.isDisplayed());
    }
}
