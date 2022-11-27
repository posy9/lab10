import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import posya.com.pageobject.page.MainPage;

import java.util.List;
import java.util.stream.Collectors;

public class SortByAscendingPriceTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void testSortByAscendingPrice() {
        driver.manage().window().setSize(new Dimension(1600, 1000));
        driver.get("https://www2.hm.com/en_us/men/new-arrivals/clothes.html?sort=ascPrice&image-size=small&image=model&offset=0&page-size=36");
        MainPage mainPage = new MainPage(driver);
        mainPage.acceptAllCookies();
        List<Double> priceAscendingList = mainPage.findPriceList();
        Assert.assertEquals(priceAscendingList,priceAscendingList.stream().sorted().collect(Collectors.toList()));
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
//        driver.quit();
//        driver = null;
    }

}



