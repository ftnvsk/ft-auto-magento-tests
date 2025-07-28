package com.filip.qamagento.stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class StepDefinitions {

    private final PageLibrary pageLibrary = new PageLibrary();

    // Step definition to navigate to the magento automation testing store
    @Given("The user opens up the automation testing store website")
    public void userNavigatesToAutoTestingPage() {
        Assert.assertTrue(pageLibrary.getHomePage().isUserOnHomepage(),
                "User did not reach the Store Homepage! ");
    }

    // Step definition for user interactions below
    @When("The user is on the homepage")
    public void theUserIsOnTheHomepage() {
        userNavigatesToAutoTestingPage();
    }

    @Then("The Sign In and Create Account buttons should be visible")
    public void signInAndCreateVisible() {
        Assert.assertTrue(pageLibrary.getHomePage().isGuestUser(),
                "Sign In or Create Account link not visible for guest user! ");
    }

    @When("The user selects size {string} for the 1st product in the homepage grid")
    public void userSelectsSizeForFirstProduct(String sizeOption) {
        pageLibrary.getHomePage().selectSizeForFirstProductInGrid(sizeOption);
    }

    @When("The user selects color {string} for the 1st product in the homepage grid")
    public void userSelectsColorForFirstProduct(String colorOption) {
        pageLibrary.getHomePage().selectColorForFirstProductInGrid(colorOption);
    }

    @When("The user clicks on 'Add to Cart' button")
    public void userClicksAddToCart() {
        pageLibrary.getHomePage().clickAddToCart();
    }

    @Then("The user should see a confirmation message that product was added to the cart")
    public void userShouldSeeConfirmationMessage() {
        Assert.assertTrue(pageLibrary.getHomePage().isProductAddedToCart(),
                "Product not added to cart or user on wrong page! ");
    }

    @When("The user opens the mini cart")
    public void userOpensTheMiniCart() {
        pageLibrary.getHomePage().openShoppingCartPage();
        Assert.assertTrue(pageLibrary.getShoppingCart().isUserOnShoppingCartPage(),
                "User is not on the Shopping Cart page! ");
    }

    @When("The user clicks on 'Proceed to Checkout' button")
    public void userProceedsToCheckout() {
        pageLibrary.getShoppingCart().clickOnProceedToCheckout();
        Assert.assertTrue(pageLibrary.getCheckoutPage().isUserOnCheckoutPage(),
                "User is not the Checkout page! ");
    }

    @And("The user fills in the shipping information:")
    public void theUserFillsInShippingInfo(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        String email = data.get("Email");
        String fname = data.get("First Name");
        String lname = data.get("Last Name");
        String address = data.get("Street");
        String city = data.get("City");
        String state = data.get("State");
        String zip = data.get("Zip Code");
        int phone = Integer.parseInt(data.get("Phone Number"));

        pageLibrary.getCheckoutPage().fillInCheckoutInfo(email, fname, lname, address, city, state, zip, phone);
    }

    @And("The user selects shipping method and proceeds")
    public void userSelectShippingMethodAndProceeds() {
        pageLibrary.getCheckoutPage().setSelectShippingMethodBestWay();
        pageLibrary.getCheckoutPage().selectNext();
    }

    @When("The user places the order")
    public void userPlacesTheOrder() {
        pageLibrary.getCheckoutPage().selectPlaceOrder();
    }

    @Then("A confirmation message should be displayed")
    public void userCanSeeOrderConfirmation() {
        Assert.assertTrue(pageLibrary.getCheckoutPage().isOrderFinalized(),
                "Order not successfully completed or user on wrong page! ");
    }

    @When("The user signs in during checkout with an existing account")
    public void userSignInAtCheckoutPage() {
        pageLibrary.getCheckoutPage().userSignInFromCheckout();
    }

    @Then("The user should see the shipping address to be pre-filled")
    public void userCanSeeAddressFilledIn() {
        Assert.assertTrue(pageLibrary.getCheckoutPage().isAddressFilledInVisible(),
                "Filled in address not visible");
    }

}
