package MarketFlux.automation.framework;

import MarketFlux.automation.tools.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import MarketFlux.pageObjects.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class cartCheck {

    private static WebDriver driver = null;

    private static ArrayList<String> category_titles = new ArrayList<String>(Category_Nav.Category_Options());

    private static HashMap<String, ArrayList<String>> categories_subcategories = new HashMap<String, ArrayList<String>>(Category_Nav.Subcategory_options());

    public static void main(String[] args) {

        //set correct version of chromedriver. Chromedriver will need to be updated in Chrome is updated
        //TODO This should be a public variable so it can be updated in one place instead of every instance
        System.setProperty("webdriver.chrome.driver","/Users/ryandiel/RBO Creative Tech Dropbox/Creative Technologies/WORKPLACE/#Ryan/File Cabinet/Dev/Java/JARs/chromedriver/chromedriver");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        User.login(driver);

        //TODO change seach word
        Search.txtbx_Search(driver).sendKeys("WBL-DEMO");

        Search.btn_Search(driver).click();

        Search.btn_View_Product(driver).click();

        Product.txtbx_Order_Quantity(driver).clear();

        Product.txtbx_Order_Quantity(driver).sendKeys("10");

        Product.btn_Add_to_Cart(driver).click();

        Product.popup_btn_Continue_Shopping(driver).click();

        Rightbar_Nav.btn_Cart(driver).click();

        Shopping_Cart.txtbx_Order_Quantity(driver).clear();

        Shopping_Cart.txtbx_Order_Quantity(driver).sendKeys("5");

        Shopping_Cart.btn_Proceed_to_Checkout(driver).click();

    }

}
