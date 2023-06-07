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
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class OffersPageStepDefinition {

    TestContextSetup testContextSetup;
    PageObjectManager pageObjectManager;

    public OffersPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("^User searches for (.+) on offers page to check if product exists$")
    public void user_searches_for_same_product_on_offers_page_to_check_if_product_exists(String string) throws InterruptedException {

        switchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();

//        Thread.sleep(2000);
//        OffersPage offersPage = new OffersPage(testContextSetup.driver);
        offersPage.searchItem(string);

        WebDriverWait wait = new WebDriverWait(testContextSetup.genericUtils.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[1]")));

        testContextSetup.offersPageProduct = offersPage.getProductName();
        System.out.println(testContextSetup.offersPageProduct + " is extracted from the OFFERS page");

    }

    public void switchToOffersPage() {

        // if statement that says if im already on offers page then ignore, if not switch to it

//        if (testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) {
//            // how do i skip? break and continue keywords are giving me an error
//        }

        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testContextSetup.genericUtils.switchWindowToChild();

        System.out.println(testContextSetup.testBase.driver.getCurrentUrl());

    }

    @And("Validate if product name in offers page matches with landing page")
    public void validate_if_product_name_in_offers_page_matches_with_landing_page() throws InterruptedException {
        Assert.assertEquals(testContextSetup.offersPageProduct, testContextSetup.homepageProduct);

//        Thread.sleep(3000);
//        testContextSetup.genericUtils.driver.quit();
    }

}
