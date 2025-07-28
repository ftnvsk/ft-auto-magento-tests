package com.filip.qamagento.Tests;

import com.filip.qamagento.utils.Hooks;

public class FirstTests extends Hooks {

//    @Test
//    public void endToEndTest() throws InterruptedException {

//        // creating an object of the automationtesting.co.uk webpage
//        HomePage homePg = new HomePage(driver);
//
//        // creating an object of the test store homepage
//        ShopHomePage shopHomepg = new ShopHomePage(driver);
//
//        // creating an object of the shop products page (when a product has been selected)
//        ShopProductsPage shopProdpg = new ShopProductsPage(driver);
//
//        // creating an object of the cart content panel (once an item was added)
//        ShopContentPanel shopContent = new ShopContentPanel(driver);
//
//        // creating an object of the shopping cart page (all items selected)
//        ShoppingCart shopCart = new ShoppingCart(driver);
//
//        // creating an object of the order personal information page
//        OrderFormPersInfo orderFormPersInfo = new OrderFormPersInfo(driver);
//
//        // creating an object of the order delivery info page
//        OrderFormDelivery orderFormDelivery = new OrderFormDelivery(driver);
//
//        // creating an object of the shipping method page
//        OrderFormShippingMethod orderFormShippingMethod = new OrderFormShippingMethod(driver);
//
//        // creating an object of the payment options page
//        OrderFormPayment orderFormPayment = new OrderFormPayment(driver);
//
//        //handles cookie prompt if appears
//        homePg.clickCookie();
//
//        // open the store
//        homePg.openTestStore();
//
//        // click on the 1st product
//        shopHomepg.clickProdOne();
//
//        // change the size option of the product
//        shopProdpg.selectSizeOption();
//        Thread.sleep(3000);
//
//        // increase product quantity by one
//        shopProdpg.increaseQuantitybyOne();
//        Thread.sleep(3000);
//
//        // add product to cart
//        shopProdpg.clickAddToCart();
//
//        // click on Checkout
//        shopContent.clickOnCheckout();
//        Thread.sleep(3000);
//
//        // add a 20% off promo code and proceed to checkout
//        shopCart.clickHavePromo();
//        shopCart.enterPromoCode();
//        Thread.sleep(3000);
//        shopCart.addPromoCode();
//        Thread.sleep(3000);
//        shopCart.proceedCheckout();
//
//        // fill in the Personal info for the order and click on 'Continue'
//        orderFormPersInfo.selectTitle("Mrs");
//        orderFormPersInfo.setFirstName();
//        orderFormPersInfo.setLastName();
//        orderFormPersInfo.setEmail();
//        orderFormPersInfo.selectTermsCheckbox();
//        Thread.sleep(7000);
//        orderFormPersInfo.clickContinue();
//        Thread.sleep(6000);
//        orderFormDelivery.enterOrderAddress();
//        Thread.sleep(3000);
//        orderFormDelivery.enterOrderCity();
//        Thread.sleep(3000);
//        orderFormDelivery.selectOrderState();
//        Thread.sleep(3000);
//        orderFormDelivery.enterOrderPostalCode();
//        Thread.sleep(3000);
//        orderFormDelivery.enterOrderPhoneNumber();
//        Thread.sleep(3000);
//        orderFormDelivery.clickContinueFromOrderAddress();
//        Thread.sleep(5000);
//        orderFormShippingMethod.clickOnDeliveryContinue();
//        Thread.sleep(3000);
//        orderFormPayment.selectPayByWire();
//        Thread.sleep(3000);
//        orderFormPayment.selectPayTerms();
//        Thread.sleep(3000);
//        orderFormPayment.clickOnOrderToFinalize();
//        Thread.sleep(10000);
//    }
//
//    @Test
//    public void TestContactUsForm() throws InterruptedException {
//
//        // creating an object of the automationtesting.co.uk webpage
//        HomePage homePg = new HomePage(driver);
//
//        // creating an object of the test store homepage
//        ShopHomePage shopHomepg = new ShopHomePage(driver);
//
//        // creating an object of the contact us page
//        ContactUsPage contactUsPage = new ContactUsPage(driver);
//
//        //handles cookie prompt if appears
//        homePg.clickCookie();
//
//        // open the store
//        homePg.openTestStore();
//        shopHomepg.clickOnContactUsForm();
//        Thread.sleep(2000);
//
//        contactUsPage.selectFormSubject();
//        contactUsPage.enterFormEmailAddress();
//        contactUsPage.enterContactUsMessage();
//        Thread.sleep(4000);
//        contactUsPage.clickOnSendButton();
//        Thread.sleep(5000);
//
//    }
//
//    @Test
//    public void TestSignupForm() throws InterruptedException {
//
//        // creating an object of the automationtesting.co.uk webpage
//        HomePage homePg = new HomePage(driver);
//
//        // creating an object of the test store homepage
//        ShopHomePage shopHomepg = new ShopHomePage(driver);
//
//        // creating an object of the registration page
//        RegistrationPage registrationPage = new RegistrationPage(driver);
//
//        //handles cookie prompt if appears
//        homePg.clickCookie();
//
//        // open the store
//        homePg.openTestStore();
//
//        shopHomepg.clickOnCreateNewAccount();
//        Thread.sleep(3000);
//        registrationPage.enterRegisterFirstName();
//        registrationPage.enterRegisterLasttName();
//        registrationPage.enterRegisterEmail();
//        registrationPage.enterRegisterPassword();
//        registrationPage.selectAgreeRegisterTerms();
//        Thread.sleep(5000);
//        registrationPage.clickOnRegisterSaveButton();
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void TestSignInForm() throws InterruptedException {
//
//        // creating an object of the automationtesting.co.uk webpage
//        HomePage homePg = new HomePage(driver);
//
//        // creating an object of the test store homepage
//        ShopHomePage shopHomepg = new ShopHomePage(driver);
//
//        // creating an object of the login page
//        LoginPage loginPage = new LoginPage(driver);
//
//        //handles cookie prompt if appears
//        homePg.clickCookie();
//
//        // open the store
//        homePg.openTestStore();
//
//        shopHomepg.clickOnSignInLink();
//        Thread.sleep(3000);
//        loginPage.enterLoginEmail();
//        loginPage.enterLoginPassword();
//        Thread.sleep(3000);
//        loginPage.clickOnSignInButton();
//        Thread.sleep(5000);
//    }


}
