package OrderForge.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {

    private static WebElement element = null;

    public static WebElement lnk_ProductsCategories(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/nav/ul/li[3]/a"));

        return element;
    }

    public static WebElement lnk_ListProducts(WebDriver driver) {

        driver.findElement(By.xpath("/html/body/nav/ul/li[3]/a")).click();

        element = driver.findElement(By.xpath("/html/body/nav/ul/li[3]/ul/li[1]/a"));

        return element;
    }


}

