package OrderForge.automation.tools;

import org.openqa.selenium.WebDriver;
import OrderForge.pageObjects.Login_Page;

import java.util.Scanner;

public class User {

    private static String url = "https://orderforge.foundrycommerce.com/";

    private static String user_login = "";

    private static String user_pw = "";

    private static Scanner user_input = new Scanner(System.in);

    public static void login(WebDriver driver) {

        //TODO check it URL is up
        driver.get(url);

        System.out.println("Enter OrderForge username:");

        user_login = user_input.nextLine();

        Login_Page.txtbx_UserName(driver).sendKeys(user_login);

        System.out.println("Enter password for "+user_login+":");

        user_pw = user_input.nextLine();

        Login_Page.txtbx_Password(driver).sendKeys(user_pw);

        Login_Page.btn_LogIn(driver).click();

        System.out.println(String.format("Logged into OrderForge as %s", user_login));
    }

}
