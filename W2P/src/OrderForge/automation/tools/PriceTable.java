package OrderForge.automation.tools;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PriceTable {

    private static WebDriver driver = null;

    private static WebElement element = null;

    public static WebElement btn_add_unit_break(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div[1]/a[3]"));

        return element;
    }

    public static WebElement txtbx_add_unit_break(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/p[3]/input"));

        return element;
    }

    public static WebElement btn_submit_add_unit_break(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/p[4]/a[2]"));

        return element;
    }

}
