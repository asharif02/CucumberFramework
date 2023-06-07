package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

    public WebDriver driver;

    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    By search = By.xpath("//input[@type='search']");
    By productName = By.xpath("//tr/td[1]");

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
}
