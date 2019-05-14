package MarketFlux.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;

public class Category_Nav {

    private static WebElement element = null;

    private static ArrayList<String> category_titles = new ArrayList<String>();

    private static ArrayList<String> subcategories = new ArrayList<String>();

    private static HashMap<String,ArrayList<String>> Category_Subcategory = new HashMap<String, ArrayList<String>>();

    public static WebElement lnk_Category_Options(WebDriver driver, String category_title) {

            element = driver.findElement(new By.ByXPath("//a[contains(text(),'" + category_title + "')]"));

            return element;
        }

    public static WebElement lnk_Subcategories(WebDriver driver, Integer j) {
            element = driver.findElement(new By.ByXPath(".clearfix:nth-child("+j+") .replace-2x"));

            return element;
        }

    public static ArrayList<String> Category_Options() {

            category_titles.add("Stationery");
            category_titles.add("Marketing Materials");
            category_titles.add("Promotional Products");
            category_titles.add("Labels");
            category_titles.add("Clients");

            return category_titles;
        }

    private static ArrayList<String> Stationery_Categories() {
        subcategories.clear();
        subcategories.add("Envelopes");
        subcategories.add("Business Cards");

        return subcategories;
    }

    private static ArrayList<String> MarketingMaterials_Categories() {
        subcategories.clear();
        subcategories.add("Flyers");
        subcategories.add("Signage");
        subcategories.add("Brochures");
        subcategories.add("Kits");
        subcategories.add("Posters");
        subcategories.add("Postcards");

        return subcategories;
    }

    private static ArrayList<String> PromotionalProducts_Categories() {
        subcategories.clear();
        subcategories.add("Apparel");
        subcategories.add("Hard Goods");
        subcategories.add("Kit");

        return subcategories;
    }

    private static ArrayList<String> Labels_Categories() {
        subcategories.clear();
        subcategories.add("");

        return subcategories;
    }

    private static ArrayList<String> Clients_Categories() {
        subcategories.clear();
        subcategories.add("Autism Speaks");
        subcategories.add("Stifel");
        subcategories.add("Commerce Bank");
        subcategories.add("Daugherty");
        subcategories.add("Clarkson Eyecare");
        subcategories.add("Maryville University");

        return subcategories;
    }

    public static HashMap<String,ArrayList<String>> Subcategory_options() {

//        for (int i = 0; i < category_titles.size(); i++) {  //will use function pointers to set different category fuctions to variables. That way we can step through that Category list and call the correct subcategory function
//            String category = category_titles.get(i)+"_Categories";

            Category_Subcategory.put("Stationery", Stationery_Categories());
            Category_Subcategory.put("Marketing Materials", MarketingMaterials_Categories());
            Category_Subcategory.put("Promotional Products", PromotionalProducts_Categories());
            Category_Subcategory.put("Labels", Labels_Categories());
            Category_Subcategory.put("Clients", Clients_Categories());

            return Category_Subcategory;
        }

}
