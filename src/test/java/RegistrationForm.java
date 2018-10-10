import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationForm extends WebDriverSettings{

    @DataProvider(name = "Authorization")

    public static Object[][] credentials() {
        return new Object[][] { { "userBen", "Test@123" }, { "userAnn", "Test@123" }};
    }

    @Test(dataProvider = "Authorization")
    public void test(String sUsername, String sPassword) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.store.demoqa.com");
        driver.findElement(By.cssSelector("#account a")).click();
        driver.findElement(By.id("log")).sendKeys(sUsername);
        driver.findElement(By.id("pwd")).sendKeys(sPassword);
        driver.findElement(By.id("login")).click();
        driver.findElement(By.cssSelector("#account_logout a")).click();
    }

}
