package posya.com.pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[data-index='0']")
    WebElement firstMenCloth;

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement cookieBanner;

    @FindBy(className = "item-price")
    List<WebElement> shirtPriceList;

    public MainPage acceptAllCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(cookieBanner));
        cookieBanner.click();
        return this;
    }

    public MainPage openFirstClothPage() {
        WebElement firstClothLink = firstMenCloth.findElement(By.className("image-container"))
                .findElement(By.tagName("a"));
        wait.until(ExpectedConditions.elementToBeClickable(firstClothLink));
        firstClothLink.click();
        return this;
    }

    public List<Double> findPriceList(){
        List<Double> priceListDouble = new ArrayList<>();
        for(var shirtPrice : shirtPriceList){
            priceListDouble.add(Double.valueOf(shirtPrice.getText().replaceAll("[^\\d.]", "")));
        }
        return priceListDouble;
    }


}
