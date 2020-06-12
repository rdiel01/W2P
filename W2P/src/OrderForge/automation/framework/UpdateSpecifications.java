package OrderForge.automation.framework;

import OrderForge.automation.tools.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import OrderForge.pageObjects.Home_Page;
import OrderForge.pageObjects.ProdCat_ListProd;
import OrderForge.pageObjects.Search;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class UpdateSpecifications {

    private static WebDriver driver = null;

    private static Actions action = null;

    private static ArrayList<String> prod_IDs = new ArrayList<String>();

    private static String var2 = "BAR";

    public static void main(String[] args) throws InterruptedException {

        //goes through products in OF and updates specifications

        prod_IDs.add("HC-10022");
        prod_IDs.add("HC-10023");
        prod_IDs.add("HC-10024");
        prod_IDs.add("HC-10025");
        prod_IDs.add("HC-10026");
        prod_IDs.add("HC-10027");
        prod_IDs.add("HC-10028");
        prod_IDs.add("HC-10035");
        prod_IDs.add("HC-10036");
        prod_IDs.add("HC-10038");
        prod_IDs.add("HC-10047");
        prod_IDs.add("HC-10051");
        prod_IDs.add("HC-10096");
        prod_IDs.add("HC-10103");
        prod_IDs.add("HC-10105");
        prod_IDs.add("HC-10108");
        prod_IDs.add("HC-10110");
        prod_IDs.add("HC-10111");
        prod_IDs.add("HC-10113");
        prod_IDs.add("HC-10114");
        prod_IDs.add("HC-10115");
        prod_IDs.add("HC-10116");
        prod_IDs.add("HC-10120");
        prod_IDs.add("HC-10123");
        prod_IDs.add("HC-10124");
        prod_IDs.add("HC-10125");
        prod_IDs.add("210001");
        prod_IDs.add("700015");
        prod_IDs.add("700106");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        action = new Actions(driver);

        User.login(driver);

        Home_Page.lnk_ProductsCategories(driver).click();

        for (String prod_ID:prod_IDs) {

            Home_Page.lnk_ListProducts(driver).click();

            Search.txtbx_Search(driver).sendKeys(prod_ID);

            Search.btn_Search(driver).click();

            Search.lnk_View_Product(driver).click();

            ProdCat_ListProd.lnk_Specifications(driver).click();

            ProdCat_ListProd.btn_CreateProdSpec(driver).click();

            ProdCat_ListProd.txtbx_CreateProdSpec_Key(driver).sendKeys("Destination Code");

            ProdCat_ListProd.txtbx_CreateProdSpec_Label(driver).sendKeys("Destination Code");

            ProdCat_ListProd.drpdwn_CreateProdSpec_TypeConstant(driver).click();

            ProdCat_ListProd.drpdwn_CreateProdSpec_NeverVisibile(driver).click();

            ProdCat_ListProd.txtbx_CreateProdSpec_DefaultValue(driver).sendKeys("BAR");

            ProdCat_ListProd.btn_CreateProdSpec_Save(driver).click();

            System.out.println("updated"+prod_ID);

            Thread.sleep(10000);

            System.out.println("Moving to next Product.");

        }
    }


}
