import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import posya.com.pageobject.page.FavoritePage;
import posya.com.pageobject.page.HoodiePage;
import posya.com.pageobject.page.MainPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ShoppingTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() throws MalformedURLException {
        this.driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
//        String username = "dannildtannk";
//        String accessKey = "cRfJtPD1w7KU2aVsiEdWvyGczlqPoWwmhtq6l5kr0p8BkwKvyq";
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "Chrome");
//        capabilities.setCapability("version", "92.0");
//        capabilities.setCapability("platform", "Windows 10");
//        capabilities.setCapability("resolution","1920x1080");
//        capabilities.setCapability("build", "First Test");
//        capabilities.setCapability("name", "Sample Test");
//        capabilities.setCapability("network", true); // To enable network logs
//        capabilities.setCapability("visual", true); // To enable step by step screenshot
//        capabilities.setCapability("video", true); // To enable video recording
//        capabilities.setCapability("console", true); // To capture console logs
//        driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
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
