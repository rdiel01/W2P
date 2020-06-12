package OrderForge.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Search {

    private static WebElement element = null;

    public static WebElement txtbx_Search(WebDriver driver) {

        element = driver.findElement(By.id("searchQuery"));

        return element;
    }

    public static WebElement btn_Search(WebDriver driver) {

        element = driver.findElement(By.id("searchTrigger"));

        return element;
    }

    public static WebElement lnk_View_Product (WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/section/div[3]/table/tbody/tr/td[6]/a[1]"));

        return element;
    }
}
