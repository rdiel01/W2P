package MarketFlux.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

//for individual product pages
public class Product_List {

    private static WebElement element = null;

    private static List<WebElement> elements = new ArrayList<WebElement>();

    public static WebElement btn_Add_to_Cart(WebDriver driver) {

        element = driver.findElement(By.name("addToCart"));

        return element;
    }

    public static WebElement txtbx_Order_Quantity(WebDriver driver) {

        element = driver.findElement(By.name("qty"));

        return element;

    }

    public static WebElement popup_btn_Continue_Shopping(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/div[5]/div[3]/a[1]"));

        return element;
    }

}
