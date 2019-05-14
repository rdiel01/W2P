package MarketFlux.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Search {

    private static WebElement element = null;

    public static WebElement txtbx_Search(WebDriver driver) {

        element = driver.findElement(By.id("search_query_top"));

        return element;
    }

    public static WebElement btn_Search(WebDriver driver) {

        element = driver.findElement(By.id("submit_searchbox"));

        return element;
    }

    public static WebElement btn_View_Product (WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[2]/div/ul/li/div/product-container/div/div[2]/div[3]/a"));

        return element;
    }

    /* This xpath is incorrect and from the OF backend. Need update.
        Also, this is only for when the search result yields one product
    public static WebElement lnk_View_Product (WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/section/div[3]/table/tbody/tr/td[6]/a[1]"));

        return element;
    }
    */
}
