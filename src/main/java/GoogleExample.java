import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class GoogleExample extends BaseClass{

    @BeforeMethod
    public void openImages() {
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("banana" + Keys.ENTER);
        driver.findElement(By.linkText("Картинки")).click();
        driver.findElement(By.linkText("Инструменты")).click();
    }

    @Test
    public void usingSimpleLocators() {
        List<WebElement> filters = driver.findElements(By.className("hdtb-mn-hd"));

        Optional<WebElement> filterByType = filters.stream().filter(elem -> {
            String labelAttr = elem.getAttribute("aria-label");
            return labelAttr != null && labelAttr.equals("Тип");
        }).findFirst();

        if(!filterByType.isPresent())
            throw new NoSuchElementException("Filter element by Type is not found!");
        filterByType.get().click();

        WebElement selectedFilter = driver.findElement(By.id("itp_lineart"));
        selectedFilter.click();

        WebElement nameOfSelecteFilter = driver.findElement(By.className("hdtb-tsel"));
        Assert.assertEquals(nameOfSelecteFilter.getText(), "Ч/б рисунки");
    }

    @Test
    public void usingXpath() {
        By filterDropdown = By.xpath("//div[contains(@class, 'hdtb-mn-hd') and @aria-label='Тип']");
        waitForElement(filterDropdown);

        WebElement filterByType = driver.findElement(filterDropdown);
        filterByType.click();

        WebElement selectedFilter = driver.findElement(By.xpath("//li[@id='itp_lineart']"));
        selectedFilter.click();

        WebElement nameOfSelecteFilter = driver.findElement(By.xpath("//div[@class='hdtb-mn-hd hdtb-tsel']"));
        Assert.assertEquals(nameOfSelecteFilter.getText(), "Ч/б рисунки");
    }

    @Test
    public void usingCSS() {
        By filterDropdown = By.cssSelector(".hdtb-mn-hd[aria-label='Тип']");
        waitForElement(filterDropdown);

        WebElement filterByType = driver.findElement(filterDropdown);
        filterByType.click();

        WebElement selectedFilter = driver.findElement(By.cssSelector("#itp_lineart"));
        selectedFilter.click();

        WebElement nameOfSelecteFilter = driver.findElement(By.cssSelector(".hdtb-tsel"));
        Assert.assertEquals(nameOfSelecteFilter.getText(), "Ч/б рисунки");
    }

}
