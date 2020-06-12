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

    private static List<WebElement> elements = new ArrayList<WebElement>();

    private static String image_src = null;

    private static BufferedImage image = null;

    private static ArrayList<String> prod_IDs = new ArrayList<String>();

    private static ArrayList<String> category_titles = new ArrayList<String>(Category_Nav.Category_Options());

    private static HashMap<String, ArrayList<String>> categories_subcategories = new HashMap<String, ArrayList<String>>(Category_Nav.Subcategory_options());

    public static void main(String[] args) {

        //set correct version of chromedriver. Chromedriver will need to be updated in Chrome is updated
        //TODO This should be a public variable so it can be updated in one place instead of every instance
        System.setProperty("webdriver.chrome.driver", "/Users/mountain-dedede/RBO Creative Tech Dropbox/Creative Technologies/WORKPLACE/#Ryan/File Cabinet/Dev/Java/JARs/chromedriver/chromedriver");

        /*
        Read from excel
         */

        prod_IDs.add("AS-ASUP-V-8511-4");
        prod_IDs.add("AS-MSC-H-7050-4");
        prod_IDs.add("AS-PCE-V-7050-1");
        prod_IDs.add("AS-WIAI-V-8511-4");
        prod_IDs.add("AS-OVBR-V-8511-4");
        prod_IDs.add("FS-IEPT-V-8511-4");
        prod_IDs.add("AS-RSC-V-5070-4");
        prod_IDs.add("AS-RSTH-V-5070-4");
        prod_IDs.add("WK-BRO-V-3758-4");
        prod_IDs.add("WK-VTHK-H-8511-4-DL");
        prod_IDs.add("WK-PCD-H-4256-4-M");
        prod_IDs.add("WK-TCG-V-8511-4");
        prod_IDs.add("TU-PMPM-H-1102-1");
        prod_IDs.add("AS-AIAL-V-8511-4");
        prod_IDs.add("AS-AIALA-V-8511-4");
        prod_IDs.add("AS-AICA-V-8511-4");
        prod_IDs.add("AS-AIAH-V-8511-4");
        prod_IDs.add("AS-AIID-V-8511-4");
        prod_IDs.add("AS-AIIN-V-8511-4");
        prod_IDs.add("AS-AIIOW-V-8511-4");
        prod_IDs.add("AS-AIKA-V-8511-4");
        prod_IDs.add("AS-AIKE-V-8511-4");
        prod_IDs.add("AS-AILA-V-8511-4");
        prod_IDs.add("AS-AIMAI-V-8511-4");
        prod_IDs.add("AS-AIMAD-V-8511-4");
        prod_IDs.add("AS-AIMIC-V-8511-4");
        prod_IDs.add("AS-AIMIN-V-8511-4");
        prod_IDs.add("AS-AIMIS-V-8511-4");
        prod_IDs.add("AS-AIAR-V-8511-4");
        prod_IDs.add("FS-1DSTK-V-8511-4");
        prod_IDs.add("WK-TEE-W-11730-4");
        prod_IDs.add("AS-10YB-V-4090-4");
        prod_IDs.add("AS-AIAZ-V-8511-4");
        prod_IDs.add("AS-AICO-V-8511-4");
        prod_IDs.add("AS-AICT-V-8511-4");
        prod_IDs.add("AS-AIDC-V-8511-4");
        prod_IDs.add("AS-AIFL-V-8511-4");
        prod_IDs.add("AS-AIGA-V-8511-4");
        prod_IDs.add("AS-AIIL-V-8511-4");
        prod_IDs.add("AS-AIMA-V-8511-4");
        prod_IDs.add("AS-AIMO-V-8511-4");
        prod_IDs.add("AS-AINC-V-8511-4");
        prod_IDs.add("AS-AINJ-V-8511-4");
        prod_IDs.add("AS-AINY-V-8511-4");
        prod_IDs.add("AS-AIOH-V-8511-4");
        prod_IDs.add("AS-AIPA-V-8511-4");
        prod_IDs.add("AS-AISC-V-8511-4");
        prod_IDs.add("AS-AITX-V-8511-4");
        prod_IDs.add("AS-AIVA-V-8511-4");
        prod_IDs.add("AS-APRC-H-8511-4");
        prod_IDs.add("AS-ASUBN-H-3060-2");
        prod_IDs.add("AS-ASUB-V-385-4");
        prod_IDs.add("AS-ASUG-V-8511-4");
        prod_IDs.add("AS-ASUHDTK-V-8511-4");
        prod_IDs.add("AS-ASUS-V-0103-1");
        prod_IDs.add("AS-AVB-V-8511-4");
        prod_IDs.add("AS-BCART-H-2035-4");
        prod_IDs.add("AS-BCD-H-2035-4");
        prod_IDs.add("AS-BID-V-1006-1");
        prod_IDs.add("AS-BMK-V-2065-4");
        prod_IDs.add("AS-BNR-H-2424-1");
        prod_IDs.add("AS-BRH-V-2689-4");
        prod_IDs.add("AS-CEDP-H-7050-4");
        prod_IDs.add("AS-CEDP-H-7050-4-DL");
        prod_IDs.add("AS-CHEC-V-1006-2");
        prod_IDs.add("AS-CHS-H-1711-4");
        prod_IDs.add("AS-CLR");
        prod_IDs.add("AS-DAB-V-3669-4-K-V");
        prod_IDs.add("AS-DAB-V-3669-4-T-V");
        prod_IDs.add("AS-DC-ENV-4195-2");
        prod_IDs.add("AS-DWS-V-1824-2");
        prod_IDs.add("AS-EN1-H-5257-2-IMP");
        prod_IDs.add("AS-ENV-H-3787-2");
        prod_IDs.add("AS-ENV-H-4195-2-IMP");
        prod_IDs.add("AS-ENV-V-1013-2-IMP");
        prod_IDs.add("AS-FLD-V-9012-4");
        prod_IDs.add("AS-FMC-H-7050-4");
        prod_IDs.add("AS-LH1-V-8511-4-IMP");
        prod_IDs.add("AS-MVEV-H-6034-1");
        prod_IDs.add("AS-NCD-H-5070-4");
        prod_IDs.add("AS-NP-0602-H-4");
        prod_IDs.add("AS-PGWBG-V-8511-4");
        prod_IDs.add("AS-RWBF-V-8511-4");
        prod_IDs.add("AS-SPCB2-V-3085-4");
        prod_IDs.add("AS-SPCB3-V-3085-4");
        prod_IDs.add("AS-SPCB-V-3085-4");
        prod_IDs.add("AS-SPCD-H-5070-2");
        prod_IDs.add("AS-SPRP-V-1080-2");
        prod_IDs.add("AS-STK-C-2525-4");
        prod_IDs.add("AS-STKD-V-2020-2");
        prod_IDs.add("AS-STK-V-3540-4");
        prod_IDs.add("AS-TC");
        prod_IDs.add("AS-TYADC-H-1185-4");
        prod_IDs.add("AS-TYAS-H-1185-4");
        prod_IDs.add("AS-TY-H-0507-4");
        prod_IDs.add("AS-TYTDC-H-1185-4");
        prod_IDs.add("AS-WEP-H-7050-4");
        prod_IDs.add("EA-BRO-V-3758-4");
        prod_IDs.add("FS-100DA-V-8511-4");
        prod_IDs.add("FS-100DY-V-8511-4");
        prod_IDs.add("FS-10WE-V-8511-4");
        prod_IDs.add("FS-7ST-V-8511-4");
        prod_IDs.add("FS-CBSA-V-8511-4");
        prod_IDs.add("FS-EAF-V-8511-4");
        prod_IDs.add("FS-FCAS-V-8511-4");
        prod_IDs.add("FS-FCTA-V-8511-4");
        prod_IDs.add("FS-FINP-V-8511-4");
        prod_IDs.add("FS-FSOF-V-8511-4");
        prod_IDs.add("FS-MTK-V-8511-4");
        prod_IDs.add("FS-NAL-V-8511-4");
        prod_IDs.add("FS-RFA-V-8511-4");
        prod_IDs.add("FS-RFSAC-V-8511-4");
        prod_IDs.add("FS-RFTTA-V-8511-4");
        prod_IDs.add("FS-RFYC-V-8511-4");
        prod_IDs.add("FS-SAI-V-8511-4");
        prod_IDs.add("FS-SLG-V-8511-4");
        prod_IDs.add("FS-SWP-V-8511-4");
        prod_IDs.add("FS-TKA-V-8511-4");
        prod_IDs.add("FS-TLKF-V-8511-4");
        prod_IDs.add("FS-TSQ-V-8511-4");
        prod_IDs.add("FS-TTK-V-8511-4");
        prod_IDs.add("FS-WEP-V-8511-4");
        prod_IDs.add("FS-WTP-V-8511-4");
        prod_IDs.add("KC-BOOK-V-5200-1");
        prod_IDs.add("KC-FLYER-V-5200-1");
        prod_IDs.add("KC-LAB-V-5200-1");
        prod_IDs.add("KC-POS-V-5200-1");
        prod_IDs.add("KC-SLJM-V-0409-4");
        prod_IDs.add("LB-BRO-V-3885-4");
        prod_IDs.add("LB-GCL-V-8511-2");
        prod_IDs.add("LB-POS-V-1117-4");
        prod_IDs.add("LB-POS-V-2436-4");
        prod_IDs.add("LB-POS-V-8511-4");
        prod_IDs.add("LB-SELA-H-8511-4");
        prod_IDs.add("LB-SEL-H-8511-4");
        prod_IDs.add("SC-BRO-V-3685-4");
        prod_IDs.add("SE-GAPHB-V-3685-4");
        prod_IDs.add("TU-BRO-V-3585-4");
        prod_IDs.add("TU-FLYR-V-8511-4");
        prod_IDs.add("TU-TUHB-V-8511-4");
        prod_IDs.add("WK-ARW-H-1058-1");
        prod_IDs.add("WK-BNRAD-H-3618-2");
        prod_IDs.add("WK-BUT-R-3500-2");
        prod_IDs.add("WK-BZ-0608-4");
        prod_IDs.add("WK-CNV-SML-1");
        prod_IDs.add("WK-CPTR-LRG-1");
        prod_IDs.add("WK-CRPV-1");
        prod_IDs.add("WK-DRSA-V-8511-4");
        prod_IDs.add("WK-DWS-V-1824-2");
        prod_IDs.add("WK-GCSBNR-V-0013-4");
        prod_IDs.add("WK-GDA-0810-4");
        prod_IDs.add("WK-HYDS-H-3612-2");
        prod_IDs.add("WK-KZSBNR-V-0013-4");
        prod_IDs.add("WK-MLS-H-1812-4");
        prod_IDs.add("WK-PKS-H-1824-4");
        prod_IDs.add("WK-PLA-0912-4");
        prod_IDs.add("WK-PUBN-V-3182-4");
        prod_IDs.add("WK-PVS-H-1824-4");
        prod_IDs.add("WK-RGE-V-7510-1");
        prod_IDs.add("WK-RRS-H-1824-4");
        prod_IDs.add("WK-RTS-H-3624-4");
        prod_IDs.add("WK-SLA-0706-4");
        prod_IDs.add("WK-SLBC-V-0314-4");
        prod_IDs.add("WK-SLBG-V-0314-4");
        prod_IDs.add("WK-SLBS-V-0314-4");
        prod_IDs.add("WK-TAT-0202-2");
        prod_IDs.add("WK-TCQS-V-8511-4");
        prod_IDs.add("WK-TRIB-H-7025-4");
        prod_IDs.add("WK-TRS-V-1010-2");
        prod_IDs.add("WK-TVSBNR-V-0013-4");
        prod_IDs.add("WK-VAPRC-H-8511-4");
        prod_IDs.add("WK-VBC-H-2035-4");
        prod_IDs.add("WK-VTHK-H-8511-4");
        prod_IDs.add("WK-VWB-H-1040-4");
        prod_IDs.add("WK-VWB-H-6040-4");
        prod_IDs.add("WK-VWB-H-8020-4");
        prod_IDs.add("WK-WKSP-V-8511-4");
        prod_IDs.add("WK-WNDF2-V-8511-4");
        prod_IDs.add("WK-ZDRF-V-8511-1");
        prod_IDs.add("WK-CMT-H-2000-1");
        prod_IDs.add("WK-VOL-C-2000-1");
        prod_IDs.add("WK-TMF-V-8511-4");
        prod_IDs.add("WK-PPHF-V-8511-4");
        prod_IDs.add("AS-SUK-V-8511-2");
        prod_IDs.add("FS-FSOS-V-8511-4");
        prod_IDs.add("WK-PST-V-1117-4");
        prod_IDs.add("AS-DBNR-H-1836-3");
        prod_IDs.add("AS-ALHP-V-8511-4");
        prod_IDs.add("WK-KCLR-H-1185-1");
        prod_IDs.add("WK-PST-V-8511-4");
        prod_IDs.add("FS-ABC-H-3520-2");
        prod_IDs.add("WK-TCSP-H-6040-4");
        prod_IDs.add("LB-DF-V-8511-4");
        prod_IDs.add("WK-GCF-V-8511-4");
        prod_IDs.add("WK-BCT-V-8511-4");
        prod_IDs.add("LB-FG-V-8511-4");
        prod_IDs.add("WK-BIB-H-6341-2");
        prod_IDs.add("WK-KC-V-8511-1");
        prod_IDs.add("WK-STD-H-6040-4");
        prod_IDs.add("WK-RESBNR-H-1002-4");
        prod_IDs.add("WK-ARTBNR-V-0705-4");
        prod_IDs.add("AS-PPED-V-1117-4");
        prod_IDs.add("WK-MISBNR-V-0305-4");
        prod_IDs.add("FS-CMT-V-85511-4");
        prod_IDs.add("FS-SARTF-V-8511-4");
        prod_IDs.add("WK-ECI-H-1020-4");
        prod_IDs.add("AS-THE-H-7050-4");
        prod_IDs.add("AS-FI-V-8511-4");
        prod_IDs.add("AS-FAFE-V-8511-4");
        prod_IDs.add("WK-PMPM-H-1102-1");
        prod_IDs.add("AS-ANR3-V-8511-4");
        prod_IDs.add("AS-THT-V-8511-4");
        prod_IDs.add("AS-AXiDPKT-V-8511-4");
        prod_IDs.add("WK-PGD-V-8511-4");
        prod_IDs.add("WK-TSIF-V-8511-4");
        prod_IDs.add("SE-GAPHO-V-8511-4");
        prod_IDs.add("AS-GCTCC-H-8511-4");
        prod_IDs.add("LB-SELAS-H-8511-4");
        prod_IDs.add("LB-SELT-H-8511-4");
        prod_IDs.add("AS-VTHK-H-8511-4");
        prod_IDs.add("LB-WAMFLYR-V-8511-4");
        prod_IDs.add("WK-10YRP-V-2020-4");
        prod_IDs.add("WK-15YRP-V-2020-4");
        prod_IDs.add("WK-PSTS-V-1117-4");
        prod_IDs.add("WK-PSTS-V-8511-4");
        prod_IDs.add("WK-BROS-V-3758-4");
        prod_IDs.add("WK-KOP-H-6040-4");
        prod_IDs.add("SC-FLY-V-8511-4");
        prod_IDs.add("AS-RSCD-V-50");
        prod_IDs.add("WK-LAP4-B-1818-3");
        prod_IDs.add("WK-TMD3-V-1050-3");
        prod_IDs.add("WK-TCP2-H-2007-4");
        prod_IDs.add("AS-NDTH-V-8511-4");
        prod_IDs.add("AS-THESC-V-8511-4");
        prod_IDs.add("AS-SRPR-V-2080-2");

        System.setProperty("http.proxyHost", "proxy.mydomain.com");
        System.setProperty("http.proxyPort", "8080");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        User.login(driver);

        //TODO change search word


        for (String prod_ID:prod_IDs) {

            Search.txtbx_Search(driver).sendKeys(prod_ID);

            Search.btn_Search(driver).click();

            elements = Search.all_results(driver);
//what do if search result is null? Need to catch this and Return no results to console
            for (WebElement anElement : elements) {
                int index = elements.indexOf(anElement)+1;

                WebElement li_Element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[2]/div/ul/li["+index+"]/div/product-container/div/div[2]/p[1]"));

                String li_prod_ID = li_Element.getText();

                if (prod_ID.equals(li_prod_ID)) {

                    element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[2]/div/ul/li["+index+"]/div/product-container/div/div[1]/a/img"));

                    image_src = element.getAttribute("src");

                    try {
                        URL url = new URL(image_src);
                        image = ImageIO.read(url);
                        ImageIO.write(image, "jpg", new File("/Users/mountain-dedede/Desktop/image_grab/"+prod_ID+".jpg"));
                        System.out.println(prod_ID+" SUCSESS");
                        break;
                    } catch (MalformedURLException ex) {
                        System.out.println(prod_ID+" failed - bad URL");
                        break;
                    } catch (IOException e) {
                        System.out.println(prod_ID+" failed - can't read");
                        break;
                    }
                }
            }
        }
    }

}
