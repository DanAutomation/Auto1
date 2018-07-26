import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckCarTest extends WebDriverSettings {

    Helper helper = new Helper();

    @Test
    public void testSortingPriceAndYear() throws InterruptedException {
        driver.get("https://www.autohero.com/de/search/");
        driver.findElement(By.xpath("//*[contains(text(),\'Erstzulassung\')]")).click();
        helper.selectValueDropdown("[name='yearRange.min']", "2015");
        helper.selectValueDropdown("[name='sort']", "Höchster Preis");

        Thread.sleep(1000);

        ArrayList<Float> carsListPrice = new ArrayList<Float>();

        WebElement clickNext;

        do{
            List<WebElement> getListelements = driver.findElements(By.cssSelector("[data-qa-selector='price']"));
            List<String> yearsList = driver.findElements(By.cssSelector("[data-qa-selector='spec-list'] li:nth-child(1)"))
                    .stream().map(WebElement::getText).collect(Collectors.toList());
            for(WebElement actualPrice : getListelements){
                    carsListPrice.add(Float.valueOf(actualPrice.getText().substring(0,6).trim()));

                }
            helper.checkCarsPriceSorting(carsListPrice);
            helper.checkYearRegistration(yearsList, 2015);
            clickNext = driver.findElement(By.xpath(".//span[@aria-label='Next']/ancestor::a"));
            clickNext.click();
           helper.scrollDown();
        }

        while(!clickNext.getAttribute("class").contains("disabled"));
    }
}
