package MarketFlux.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Rightbar_Nav {

    private static WebElement element = null;

    public static WebElement btn_Cart(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id='rightbar-shopping_cart']"));

        return element;
    }

}
