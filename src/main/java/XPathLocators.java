import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class XPathLocators extends BaseClass{

    @BeforeMethod
    public void openDoodlesSite() {
        driver.get("https://www.google.com/doodles/");
    }

    @Test
    public void findXPathLocators() {
        System.out.println("\"Find XPath locators\" test is running.");

        //по значению атрибута
        By latesTitleLink = By.xpath("//a[@id='latest-title']");
        WebElement latestTitle = driver.findElement(latesTitleLink);
        String titleValue = latestTitle.getText();
        System.out.println("Lates title on page is \"" + titleValue + "\"");

        //дочерний элемент любого уровня
        By searchInput = By.xpath("//form//input");
        driver.findElement(searchInput).sendKeys(titleValue);

        //дочерний элемент
        By searchIncon = By.xpath("//form/div/div");
        driver.findElement(searchIncon).click();

        //поиск по тексту
        By foundTitle = By.xpath("//a[contains(text(),\"" + titleValue + "\")]");
        boolean isFound = driver.findElement(foundTitle).isDisplayed();
        System.out.println("Title is found: " + isFound);
    }

}
