package OrderForge.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {

    private static WebElement element = null;

    public static WebElement txtbx_UserName(WebDriver driver) {

        element = driver.findElement(By.id("UserName"));

        return element;
    }

    public static WebElement txtbx_Password(WebDriver driver) {

        element = driver.findElement(By.id("Password"));

        return element;
    }

    public static WebElement btn_LogIn(WebDriver driver) {

        element = driver.findElement(By.xpath("/html/body/section/form/div/fieldset/section[3]/button"));

        return element;
    }
}
