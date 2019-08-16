
//INCOMPLETE
package MarketFlux.automation.framework;

import MarketFlux.automation.tools.User;
import MarketFlux.pageObjects.Search;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CategoryList {

    private static WebDriver driver = null;

    private static WebElement element = null;
    private static List<WebElement> elements = new ArrayList<WebElement>();

    public static void main(String[] args) {

        //set correct version of chromedriver. Chromedriver will need to be updated in Chrome is updated
        //TODO This should be a public variable so it can be updated in one place instead of every instance/framework.
        //todo try to see if this can be updated automatically through maven or github
        System.setProperty("webdriver.chrome.driver", "/Users/mountain-dedede/RBO Creative Tech Dropbox/Creative Technologies/WORKPLACE/#Ryan/File Cabinet/Dev/Java/JARs/chromedriver/chromedriver");

        driver = new ChromeDriver();

        User.login(driver);

        //TODO want to wait for page to load instead of implicitWait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        User.category_selectorMenu(driver);

        Search.view_all_results(driver);

        Search.log_all_results(driver);

        System.out.println("exited selector");
    }

}