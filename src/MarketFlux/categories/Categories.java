package MarketFlux.categories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Categories {
    Category category;

    public Categories(Category category) {
        this.category = category;
    }

    private static List<WebElement> elements = null;

    private static WebElement element = null;

    public WebElement link(WebDriver driver) {

        elements = driver.findElements(By.xpath("//*[@id='st_advanced_menu_2']"));

        switch (category) {
            case HOME:
                element = driver.findElement(By.xpath("//*[@id='st_advanced_menu_1']"));
                break;

            case STATIONERY:
                element = elements.get(0);
                break;

            case MARKETING:
                element = elements.get(1);
                break;

            case PROMOTIONAL:
                element = elements.get(2);
                break;

            case LABELS:
                element = elements.get(3);
                break;

            case CLIENTS:
                element = elements.get(4);
                break;

            default:
                System.out.println("Enum switch cases failed");
                break;

        }
        return element;
    }

}

