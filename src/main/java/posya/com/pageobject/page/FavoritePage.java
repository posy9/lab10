package posya.com.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FavoritePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public FavoritePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class*='ProductTitle-module']")
    WebElement clothName;

    public String findClothName(){
      // wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class*='ProductLink']")));
        return clothName.getAccessibleName();
    }
}
