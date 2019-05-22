package MarketFlux.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SideNav {

    private static WebElement element = null;

    private static List<WebElement> elements = new ArrayList<WebElement>();

    public static List<WebElement> Categories_Array(WebDriver driver) {

        elements = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[1]/div/div/ul/li"));

        return elements;
    }

}
