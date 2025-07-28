package com.filip.qamagento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".action.action-auth-toggle")
    private WebElement singInLink;

    @FindBy(xpath = "//form[@data-role='login']//input[@id='login-email']")
    private WebElement formLoginEmailInput;

    @FindBy(xpath = "//form[@data-role='login']//input[@id='login-password']")
    private WebElement formLoginPasswordInput;

    @FindBy(xpath = "//form[@data-role='login']//button")
    private WebElement formSignInButton;

    @FindBy(xpath = "//div[@class='control _with-tooltip']//input[@id='customer-email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//div[@name='shippingAddress.firstname']//input")
    private WebElement firstNameInputField;

    @FindBy(xpath = "//div[@name='shippingAddress.lastname']//input")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//div[@name='shippingAddress.street.0']//input")
    private WebElement streetAddressInputField;

    @FindBy(xpath = "//div[@name='shippingAddress.city']//input")
    private WebElement cityInputField;

    @FindBy(xpath = "//div[@name='shippingAddress.region_id']//select")
    private WebElement stateDropdownField;

    @FindBy(xpath = "//div[@name='shippingAddress.postcode']//input")
    private WebElement zipCodeInputField;

    @FindBy(xpath = "//div[@name='shippingAddress.telephone']//input")
    private WebElement phoneNrInputField;

    @FindBy(xpath = "//div[@id='checkout-step-shipping_method']//td[contains(text(), 'Best')]")
    private WebElement selectShippingMethodBestWay;

    @FindBy(css = ".shipping-address-item.selected-item")
    private WebElement selectedShippingAddress;

    @FindBy(css = "button.action.continue.primary")
    private WebElement nextButton;

    @FindBy(css = "button.action.primary.checkout")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//span[text()='Thank you for your purchase!']")
    private WebElement thankYouTextField;

    @FindBy(xpath="//div[@class='checkout-success']")
    private WebElement checkOutSuccessField;

    public boolean isUserOnCheckoutPage() {
        return elementMethods.isElementVisible(emailInputField) && elementMethods.isElementVisible(firstNameInputField);
    }

    public void userSignInFromCheckout() {
        elementMethods.clickElement(singInLink);
        elementMethods.waitVisibleElement(formLoginEmailInput);
        elementMethods.clickElement(formLoginEmailInput);
        elementMethods.fillElement(formLoginEmailInput, propertiesFile.getValue("email"));
        elementMethods.clickElement(formLoginPasswordInput);
        elementMethods.fillElement(formLoginPasswordInput, propertiesFile.getValue("password"));
        elementMethods.clickElement(formSignInButton);

    }

    public void fillInCheckoutInfo(String email, String fname, String lname, String address, String city, String state, String postCode, int phoneNr) {
        elementMethods.clickElement(emailInputField);
        elementMethods.fillElement(emailInputField, email);
        elementMethods.clickElement(firstNameInputField);
        elementMethods.fillElement(firstNameInputField, fname);
        elementMethods.clickElement(lastNameInputField);
        elementMethods.fillElement(lastNameInputField, lname);
        elementMethods.scrollToElementJS(streetAddressInputField);
        elementMethods.clickElement(streetAddressInputField);
        elementMethods.fillElement(streetAddressInputField, address);
        elementMethods.clickElement(cityInputField);
        elementMethods.fillElement(cityInputField, city);
        elementMethods.selectDropDownText(stateDropdownField, state);
        elementMethods.clickElement(zipCodeInputField);
        elementMethods.fillElement(zipCodeInputField, postCode);
        elementMethods.clickElement(phoneNrInputField);
        elementMethods.fillElement(phoneNrInputField, String.valueOf(phoneNr));
    }

    public boolean isAddressFilledInVisible() {
        return elementMethods.isElementVisible(selectedShippingAddress);
    }

    public void setSelectShippingMethodBestWay() {
        elementMethods.clickElement(selectShippingMethodBestWay);
    }

    public void selectNext() {
        elementMethods.clickElement(nextButton);
    }

    public void selectPlaceOrder() {
        elementMethods.scrollToElementJS(placeOrderButton);
        elementMethods.clickElement(placeOrderButton);
    }

    public boolean isOrderFinalized() {
        return elementMethods.isElementVisible(thankYouTextField) && elementMethods.isElementVisible(checkOutSuccessField);
    }
}
