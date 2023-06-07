package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    By search = By.xpath("//input[@type='search']");
    By productName = By.xpath("//h4[@class='product-name']");
    By topDeals = By.xpath("//a[@href='#/offers']");
    By incrementButton = By.xpath("//a[@class='increment']");
    By addToCart = By.xpath("//button[text()='ADD TO CART']");
    By cartIcon = By.xpath("//img[@alt='Cart']");
    By proceedToCheckoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
//    By proceedToCheckoutButton = By.linkText("PROCEED TO CHECKOUT");


    public void searchItem(String name) {
        driver.findElement(search).sendKeys(name);
    }

    public void getSearchText() {
        driver.findElement(search).getText();
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    // how would this work?
    public void splitAndTrimProductName() {
        getProductName().split("-")[0].trim();
    }

    public void selectTopDealsPage() {
        driver.findElement(topDeals).click();
    }

    public void clickIncrementButtonThreeTimes() {
        for(int i = 0; i < 3; i++) {
            driver.findElement(incrementButton).click();
        }
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCart).click();
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }

    public void clickProceedToCheckoutButton() {
        driver.findElement(proceedToCheckoutButton).click();
    }


}
