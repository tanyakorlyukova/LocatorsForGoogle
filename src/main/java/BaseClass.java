import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseClass {

    WebDriver driver;

    @BeforeClass
    public void initializeBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "drivers\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=ru");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    public void waitForElement(By element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
