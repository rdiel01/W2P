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

        //trying to get list/array of li elements from ul at home page. So far the element is empty
        System.out.println(driver.findElements(By.xpath("//*[@class='tree']*//li")));

        System.out.println(elements);

        return elements;
    }

}
