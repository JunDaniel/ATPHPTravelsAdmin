package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseSetup {
    static final String PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\windows\\chromedriver.exe";
    static final String DRIVER = "webdriver.chrome.driver";
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType, String url) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(url);
                break;
        }
    }

    private static WebDriver initChromeDriver(String url) {
        System.setProperty(DRIVER, PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        return driver;
    }

    @Parameters({ "browserType", "url" })
    @BeforeClass
    public void initTestBaseSetup(String browserType, String url) {
        try {
            setDriver(browserType, url);
        } catch (Exception e) {
            System.out.println("Error " + e.getStackTrace());
        }
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
