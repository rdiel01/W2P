package MarketFlux.automation.tools;

import MarketFlux.pageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private static String url = "https://marketflux.foundrycommerce.com/";

    private static String user_login = "";

    private static String user_pw = "";

    private static String user_selection = null;

    private static Scanner user_input = new Scanner(System.in);

    private static List<WebElement> elements = new ArrayList<WebElement>();

    private static WebElement element = null;

    public static void login(WebDriver driver) {

        //TODO check it URL is up
        driver.get(url);

        System.out.println("Enter Marketflux username:");

        user_login = user_input.nextLine();

        Login_Page.txtbx_UserName(driver).sendKeys(user_login);

        System.out.println("Enter password for "+user_login+":");

        user_pw = user_input.nextLine();

        Login_Page.txtbx_Password(driver).sendKeys(user_pw);

        Login_Page.btn_LogIn(driver).click();

        System.out.println(String.format("Logged into Marketflux as %s", user_login));
    }

    public static void category_selector(WebDriver driver) {
        //TODO I want this to have a method as a parameter to allow for more versatility

        while (SideNav.Category_check(driver)) {
            elements = SideNav.Categories_Array(driver);

            for (WebElement element : elements) {
                System.out.println(elements.indexOf(element) + " - " + element.getText());
            }
            System.out.println("Make a selection or return nothing to stop:");
            user_selection = user_input.nextLine();

            //user_selection of "" currently is not stopping the loop correctly
            if (user_selection != "") {
                int foo = Integer.parseInt(user_selection);
                element = elements.get(foo);
                element.click();
            } else {
                System.out.println("User has select to not go further.");
            }

        }
    }

}
