package posya.com.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HoodiePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HoodiePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "hm-product-name")
    WebElement clothName;

    @FindBy(css = "hm-favourites-button")
    WebElement clothFavorite;

    public String findHoodieName() {
        return clothName.getText();
    }

    public HoodiePage addToFavorites(){
        clothFavorite = clothFavorite.findElement(By.tagName("button"));
        clothFavorite.click();
        return this;
    }
}
