package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By productName = By.xpath("//p[@class='product-name']");

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

}
