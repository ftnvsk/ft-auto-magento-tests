package com.filip.qamagento.stepDefinitions;

import com.filip.qamagento.pages.*;
import com.filip.qamagento.utils.WebDriverInstance;

public class PageLibrary {
    // Here I do 'lazy' instantiation of the page objects
    private HomePage homePage;
    private ShoppingCartPage shoppingCartPage;
    private CheckoutPage checkoutPage;

    // Add more page objects as needed

    // Below I make sure that page objects are created as needed
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(WebDriverInstance.getDriver());
        }
        return homePage;
    }

    public ShoppingCartPage getShoppingCart() {
        if (shoppingCartPage == null) {
            shoppingCartPage = new ShoppingCartPage(WebDriverInstance.getDriver());
        }
        return shoppingCartPage;
    }

    public CheckoutPage getCheckoutPage() {
        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage(WebDriverInstance.getDriver());
        }
        return checkoutPage;
    }
}