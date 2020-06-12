package OrderForge.automation.framework;

import OrderForge.automation.tools.*;

import OrderForge.pageObjects.Home_Page;
import OrderForge.pageObjects.ProdCat_ListProd;
import OrderForge.pageObjects.Search;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.util.ServiceConfigurationError;
import java.util.concurrent.TimeUnit;

public class Large_PriceTable_Update {

    private static WebDriver driver = null;

    private static WebElement element = null;

    private static String unit_break = null;

    public static void main (String[] args) throws InterruptedException {

        //updates a price table with a large amount of changes

        System.setProperty("webdriver.chrome.driver", "/Users/ryandiel/RBO Creative Tech Dropbox/Creative Technologies/WORKPLACE/#Ryan/File Cabinet/Dev/Java/JARs/chromedriver/chromedriver");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        User.login(driver);

        Home_Page.lnk_ListProducts(driver).click();

        Search.txtbx_Search(driver).sendKeys("WK-PST-V-1117-4");

        Search.btn_Search(driver).click();

        Search.lnk_View_Product(driver).click();

        ProdCat_ListProd.btn_PriceTable(driver).click();

        ProdCat_ListProd.btn_PriceTable_Edit(driver).click();

        for (Integer i = 2; i <= 100; i++) {

            unit_break = i.toString();

            TimeUnit.SECONDS.sleep(2);

            PriceTable.btn_add_unit_break(driver).click();

            PriceTable.txtbx_add_unit_break(driver).sendKeys(unit_break);

            PriceTable.btn_submit_add_unit_break(driver).click();

        }
    }

}
