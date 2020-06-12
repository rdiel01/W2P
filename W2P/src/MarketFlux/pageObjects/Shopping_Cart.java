package MarketFlux.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Shopping_Cart {

    private static WebElement element = null;

    public static WebElement txtbx_Order_Quantity(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div/div[2]/div[1]/div[1]/table/tbody/tr/td[5]/div/div/div[1]/input"));

        return element;
    }

    public static WebElement btn_Proceed_to_Checkout(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div/div[2]/p[3]/a[1]"));

        return element;
    }

}
