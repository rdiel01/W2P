package OrderForge.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdCat_ListProd {

    private static WebElement element = null;

    public static WebElement lnk_Specifications(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/section/div[2]/ul/li[6]"));

        return element;
    }

    public static WebElement btn_CreateProdSpec(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/section/div[2]/div[6]/div[2]/a[1]"));

        return element;
    }

    public static WebElement txtbx_CreateProdSpec_Key(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/form/fieldset/section[1]/div[2]/input"));

        return element;
    }

    public static WebElement txtbx_CreateProdSpec_Label(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/form/fieldset/section[2]/div[2]/input"));

        return element;
    }

    public static WebElement drpdwn_CreateProdSpec_TypeConstant(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/form/fieldset/section[5]/div[2]/div/select/option[8]"));

        return element;
    }

    public static WebElement drpdwn_CreateProdSpec_NeverVisibile(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/form/fieldset/section[6]/div/div/select/option[3]"));

        return element;
    }

    public static WebElement txtbx_CreateProdSpec_DefaultValue(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/form/fieldset/section[21]/div/input[3]"));

        return element;
    }

    public static WebElement btn_CreateProdSpec_Save(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/form/div/button[1]"));

        return element;
    }

    public static WebElement btn_PriceTable(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/section/div[2]/ul/li[8]"));

        return element;
    }

    public static WebElement btn_PriceTable_Edit(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/section/div[2]/div[8]/div[1]/div/table/tbody/tr/td[2]/a[2]"));

        return element;
    }



}
