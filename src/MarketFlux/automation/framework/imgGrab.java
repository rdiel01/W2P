package MarketFlux.automation.framework;

import MarketFlux.automation.tools.User;
import MarketFlux.pageObjects.Category_Nav;
import MarketFlux.pageObjects.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class imgGrab {

    private static WebDriver driver = null;

    private static WebElement element = null;

    private static String image_src = null;

    private static BufferedImage image = null;

    private static ArrayList<String> prod_IDs = new ArrayList<String>();

    private static ArrayList<String> category_titles = new ArrayList<String>(Category_Nav.Category_Options());

    private static HashMap<String, ArrayList<String>> categories_subcategories = new HashMap<String, ArrayList<String>>(Category_Nav.Subcategory_options());

    public static void main(String[] args) {

        //set correct version of chromedriver. Chromedriver will need to be updated in Chrome is updated
        //TODO This should be a public variable so it can be updated in one place instead of every instance
        System.setProperty("webdriver.chrome.driver","/Users/ryandiel/RBO Creative Tech Dropbox/Creative Technologies/WORKPLACE/#Ryan/File Cabinet/Dev/Java/JARs/chromedriver/chromedriver");


        prod_IDs.add("BC-DOC");
        prod_IDs.add("BRC-C");
        prod_IDs.add("BRC-DR");
        prod_IDs.add("BRC-DE");
        prod_IDs.add("BRC-F&F");
        prod_IDs.add("BRC-GL");
        prod_IDs.add("BRC-MD");
        prod_IDs.add("BRC-P");
        prod_IDs.add("BRC-PATIENT");
        prod_IDs.add("BRC-DTR");
        prod_IDs.add("BRC-GEN-CEC");
        prod_IDs.add("ENV-10R");
        prod_IDs.add("ENV-10R");
        prod_IDs.add("LH-CEC-VAR");
        prod_IDs.add("CRD-PARR-CEC");
        prod_IDs.add("CRD-VET-CEC");
        prod_IDs.add("SIGN-VET-CECOH");
        prod_IDs.add("CRD-SAFETY-OH");
        prod_IDs.add("CRD-COMPUTER-CECOH");
        prod_IDs.add("BK-CEC-LB");
        prod_IDs.add("BK-CEC-EDLB");
        prod_IDs.add("BK-COVER-CEC");
        prod_IDs.add("DM-CEC-40");
        prod_IDs.add("DM-CEC-EPP");
        prod_IDs.add("DM-CEC-CELP");
        prod_IDs.add("DM-CEC-GOLP");
        prod_IDs.add("DM-CEC-KLP");
        prod_IDs.add("DM-CEC-EDLP");
        prod_IDs.add("POS-CEC-CELP");
        prod_IDs.add("POS-CEC-GOLP");
        prod_IDs.add("POS-CEC-KLP");
        prod_IDs.add("POS-CEC-EDLP");
        prod_IDs.add("FLY-HF-CON");
        prod_IDs.add("FLY-HF-FAM");
        prod_IDs.add("FLY-HF-MAT");
        prod_IDs.add("FLY-HF-YP");
        prod_IDs.add("FLY-SS");
        prod_IDs.add("FLY-VS");
        prod_IDs.add("SIGN-DOC");
        prod_IDs.add("CRD-QUES-CEC");
        prod_IDs.add("LC-CEC");
        prod_IDs.add("WBA-TB09BL");
        prod_IDs.add("MAG-SUN-CEC");
        prod_IDs.add("PEN-CONGO-CEC");
        prod_IDs.add("POUCH-EG-CEC");
        prod_IDs.add("FLY-GEN");
        prod_IDs.add("FLY-DOC-STK");
        prod_IDs.add("FLY-DOC-COL");
        prod_IDs.add("SIGN-SERV");
        prod_IDs.add("INV-GO");
        prod_IDs.add("FLY-GOO");
        prod_IDs.add("SIGN-GO");
        prod_IDs.add("INV-GRO");
        prod_IDs.add("FLY-OFFER");


        System.setProperty("http.proxyHost", "proxy.mydomain.com");
        System.setProperty("http.proxyPort", "8080");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        User.login(driver);

        //TODO change seach word


        for (String prod_ID:prod_IDs) {

            Search.txtbx_Search(driver).sendKeys(prod_ID);

            Search.btn_Search(driver).click();

            element = Search.get_imgSrc(driver);

            image_src = element.getAttribute("src");

            try {
                URL url = new URL(image_src);
                image = ImageIO.read(url);
                ImageIO.write(image, "jpg", new File("/Users/ryandiel/Desktop/image_grab/"+prod_ID));
            } catch (MalformedURLException ex) {
                System.out.println("that URL is shite");
            } catch (IOException e) {
                System.out.println("I can't read that");
            }
        }
    }

}
