
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class WebDriverSettings {

    public static WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void runTest() {
        driver.quit();
    }
}
