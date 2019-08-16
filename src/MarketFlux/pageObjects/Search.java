package MarketFlux.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Search {

    //only useful for single search results that provide one product. Not meant for search results that provide a list
    private static WebElement element = null;

    public static WebElement txtbx_Search(WebDriver driver) {

        element = driver.findElement(By.id("search_query_top"));

        return element;
    }

    public static WebElement btn_Search(WebDriver driver) {

        element = driver.findElement(By.id("submit_searchbox"));

        return element;
    }

    public static WebElement btn_View_Product(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[2]/div/ul/li/div/product-container/div/div[2]/div[3]/a"));

        return element;
    }

    public static WebElement get_imgSrc(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[2]/div/ul/li/div/product-container/div/div[1]/a/img"));

        return element;
    }
        /* This xpath is incorrect and from the OF backend. Need update.
        Also, this is only for when the search result yields one product
    public static WebElement lnk_View_Product (WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/section/div[3]/table/tbody/tr/td[6]/a[1]"));

        return element;
    }
    */

    public static WebElement result_parse_productID (WebDriver driver) {
        //parses product ID from list of search results. Currently only pulls from BC cards on demo.ct.demo.
        element = driver.findElement(By.className("product-external-id"));

        return element;
    }

    public static List<WebElement> all_results(WebDriver driver) {

       // return driver.findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[2]/div/ul/li")); this worked for the AS image grab for some reason
        return driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[2]/ul/li"));
    }

    public static void view_all_results(WebDriver driver) {
        new Select(driver.findElement(By.xpath("//*[@id=\"productsSortFormTop\"]/div/select[2]"))).selectByVisibleText("All");

    }

    public static void log_all_results(WebDriver driver) {

        for (WebElement anElement : all_results(driver)) {

            String prodName = anElement.findElement(By.className("s_title_block")).getText();
            String prodId = anElement.findElement(By.className("product-external-id")).getText();

            System.out.println(prodName+" - "+prodId);
        }

}
