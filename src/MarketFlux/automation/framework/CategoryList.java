
//INCOMPLETE
package MarketFlux.automation.framework;

import MarketFlux.automation.tools.User;
import MarketFlux.pageObjects.SideNav;
import org.openqa.selenium.By;
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
        //TODO This should be a public variable so it can be updated in one place instead of every instance
        System.setProperty("webdriver.chrome.driver", "/Users/ryandiel/RBO Creative Tech Dropbox/Creative Technologies/WORKPLACE/#Ryan/File Cabinet/Dev/Java/JARs/chromedriver/chromedriver");

        driver = new ChromeDriver();

        User.login(driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        User.category_selector(driver);
    }

}