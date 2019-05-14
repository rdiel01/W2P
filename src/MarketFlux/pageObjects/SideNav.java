package MarketFlux.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideNav {

    private static WebElement element = null;

    public static WebElement Categories_Array(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[1]/div/div/ul"));

        return element;
    }

}
