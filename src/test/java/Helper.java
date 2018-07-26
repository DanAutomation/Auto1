import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Helper extends WebDriverSettings {

    public void selectValueDropdown(String locator, String selectValue) {
        Select select = new Select(driver.findElement(By.cssSelector(locator)));
        select.selectByVisibleText(selectValue);
    }

    public void scrollDown() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void checkCarsPriceSorting(ArrayList<Float> carsListPrice) {
        for (int i = 0; i < carsListPrice.size() - 2; i++) {
            Assert.assertTrue(carsListPrice.get(i) >= carsListPrice.get(i + 1), String.format("Cars price is not correct for %s", carsListPrice.get(i)));
        }
    }

    public void checkYearRegistration(List<String> yearsList, int year) {
        for (String years : yearsList) {
            Assert.assertTrue(Integer.parseInt(years.replaceAll("•\\n", "")) >= year, "error");
        }
    }
}
