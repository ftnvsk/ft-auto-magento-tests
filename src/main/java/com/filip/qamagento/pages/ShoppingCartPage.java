package com.filip.qamagento.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.action.update")
    private WebElement updateShoppingCartButton;

    @FindBy(xpath = "//button[@data-role='proceed-to-checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//tr[@class='grand totals']//span[@class='price']")
    private WebElement orderTotalAmmount;

    @FindBy(xpath = "//td[@data-th='Price']//span[@class='price']")
    private WebElement pricePerItem;

    @FindBy(xpath = "//input[@title='Qty']")
    private WebElement quantityOfItems;

    public boolean isUserOnShoppingCartPage() {
        return elementMethods.isElementVisible(updateShoppingCartButton) && elementMethods.isElementVisible(proceedToCheckoutButton);
    }

    public void clickOnProceedToCheckout() {
        elementMethods.scrollToElementJS(proceedToCheckoutButton);
        elementMethods.clickElement(proceedToCheckoutButton);
    }

}
