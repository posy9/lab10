import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import posya.com.pageobject.page.FavoritePage;
import posya.com.pageobject.page.HoodiePage;
import posya.com.pageobject.page.MainPage;

import java.time.Duration;

public class ShoppingTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
    }


    @Test
    public void testNameInFavorites() {
        driver.manage().window().setSize(new Dimension(1600, 1000));
        driver.get("https://www2.hm.com/en_us/men/new-arrivals/clothes.html");
        MainPage mainPage = new MainPage(driver);
        mainPage.acceptAllCookies()
                .openFirstClothPage();
        HoodiePage hoodiePage = new HoodiePage(driver);
        String hoodieProductPageName = hoodiePage.findHoodieName();
        hoodiePage.addToFavorites();
        driver.get("https://www2.hm.com/en_us/favourites");
        FavoritePage favoritePage = new FavoritePage(driver);
        String nameOnFavorites = favoritePage.findClothName();
        Assert.assertEquals(hoodieProductPageName, nameOnFavorites);
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
//        driver.quit();
//        driver = null;
    }

}
