package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class LandingPageStepDefinition {

    TestContextSetup testContextSetup;
    public LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenCart landing page")
    public void user_is_on_green_cart_landing_page() throws IOException {
    }

    @When("^User searches with (.+) and extracted actual name of product$")
    public void user_searches_with_and_extracted_actual_name_of_product(String string) throws InterruptedException {

//        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchItem(string);

        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(testContextSetup.testBase.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='product-name']")));

        // sometimes it extracts tomato, sometimes it extracts broccoli
        testContextSetup.homepageProduct = landingPage.getProductName().split("-")[0].trim();

        System.out.println(testContextSetup.homepageProduct + " is extracted from the home page");

        System.out.println("testing");
    }

    @When("User adds three to the quantity")
    public void user_adds_three_to_the_quantity() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        Thread.sleep(2000);
//        WebDriverWait wait = new WebDriverWait(testContextSetup.testBase.driver, Duration.ofSeconds(30));
        landingPage.clickIncrementButtonThreeTimes();
    }

    @When("User clicks add to cart button")
    public void user_clicks_add_to_cart_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        Thread.sleep(2000);

        landingPage.clickAddToCartButton();
    }

    @When("User clicks cart icon located in the top right corner")
    public void user_clicks_cart_icon_located_in_the_top_right_corner() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        Thread.sleep(2000);

        landingPage.clickCartIcon();
    }

    @When("User clicks the proceed to checkout button")
    public void user_clicks_the_proceed_to_checkout_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        Thread.sleep(3000);

        landingPage.clickProceedToCheckoutButton();
    }



}
