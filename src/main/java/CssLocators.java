import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CssLocators extends BaseClass{

    @BeforeMethod
    public void openGoogleSite() {
        driver.get("https://www.google.com/");
    }

    @Test
    public void findCSSLocators() {
        System.out.println("\"Find CSS locators\" test is running.");

        //по ID элемента
        By singInButton = By.cssSelector("#gb_70");
        driver.findElement(singInButton).click();

        //дочерний элемент
        By titleOfForm = By.cssSelector("h1 > span");
        WebElement title = driver.findElement(titleOfForm);
        System.out.println("Form \"" + title.getText() + "\" is opened.");

        //по значению атрибута
        By emailInput = By.cssSelector("input[type='email']");
        driver.findElement(emailInput).sendKeys("&*^%*^*" + Keys.ENTER);

        //относительный путь
        By svgImages = By.cssSelector("svg");
        List<WebElement> images = driver.findElements(svgImages);
        System.out.println("Count of .svg images on page is " + images.size());

        //по классу
        By errorMessage = By.cssSelector(".o6cuMc");
        WebElement message = driver.findElement(errorMessage);
        System.out.println("\"" + message.getText() + "\" error message is shown.");
    }

}
