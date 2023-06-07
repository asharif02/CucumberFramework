package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

    TestContextSetup testContextSetup;
    public CheckoutPage checkoutPage;

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.checkoutPage;
    }

    @Then("User is navigated to the checkout page")
    public void user_is_navigated_to_the_checkout_page() {
        // Write code here that turns the phrase above into concrete actions
//        CheckoutPage checkoutPage = testContextSetup.pageObjectManager.checkoutPage;
    }

    @Then("User validates if product name matches product in the cart")
    public void user_validates_if_product_name_matches_product_in_the_cart() {
        // Write code here that turns the phrase above into concrete actions
//        CheckoutPage checkoutPage = testContextSetup.pageObjectManager.checkoutPage;
        testContextSetup.checkoutPageProduct = checkoutPage.getProductName().split("-")[0].trim();

        System.out.println(testContextSetup.checkoutPageProduct + " was found on checkout page");

        Assert.assertEquals(testContextSetup.homepageProduct, testContextSetup.checkoutPageProduct);
    }
}
