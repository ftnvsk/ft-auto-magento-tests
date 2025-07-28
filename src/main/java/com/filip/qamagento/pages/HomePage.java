package com.filip.qamagento.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.fc-dialog-overlay")
    private WebElement overlayLocator;

    @FindBy(xpath = "//button[@aria-label='Consent']")
    private WebElement consentButton;

    @FindBy(css = "span.base")
    private WebElement homePageTitle;

    @FindBy(linkText = "Create an Account")
    private WebElement createAccountLink;

    @FindBy(partialLinkText = "Sign In")
    private WebElement signInLink;

    @FindBy(css = ".products-grid")
    private WebElement productsGrid;

    @FindBy(css = ".products-grid .product-item")
    private List<WebElement> productItems;

    @FindBy(xpath = "//div[contains(@id, 'option-label-size-')]")
    private List<WebElement> sizesSelector;

    @FindBy(xpath = "//div[contains(@id, 'option-label-color-')]")
    private List<WebElement> colorsSelector;

    @FindBy(xpath = "//button[@title='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[contains(text(), 'You added')]")
    private WebElement addedToCartConfirmationMessage;

    @FindBy(css = "a.action.showcart")
    private WebElement openMiniCartButton;

    @FindBy(css = "a.action.viewcart")
    private WebElement goToCartButton;

    private boolean isConsentOverlayDisplayed() {
        try {
            return elementMethods.isElementVisible(overlayLocator);
        } catch (NoSuchElementException | TimeoutException e) {
            return false; // Elementul nu e prezent sau vizibil, deci nu trebuie inchis
        }
    }

    private void dismissConsentOverlay() {
        if (isConsentOverlayDisplayed()) {
            try {
                elementMethods.clickElement(consentButton);
            } catch (Exception e) {
                System.out.println("Consent button could not be clicked: " + e.getMessage());
            }
        }
    }
    private boolean isSignInLinkVisible() {
        return elementMethods.isElementVisible(signInLink);
    }

    private boolean isCreateAccountLinkVisible() {
        return elementMethods.isElementVisible(createAccountLink);
    }

    public boolean isUserOnHomepage() {
        dismissConsentOverlay();
        return elementMethods.isElementVisible(homePageTitle);
    }

    public boolean isGuestUser() {
        return isSignInLinkVisible() && isCreateAccountLinkVisible();
    }

    private void hoverOverFirstProductInGrid() {
        elementMethods.scrollToElementJS(productsGrid);
        WebElement product = productItems.stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No products found in the grid! "));
        elementMethods.moveToElement(product);
    }

    public void selectSizeForFirstProductInGrid(String size) {
        hoverOverFirstProductInGrid();
        for (WebElement option : sizesSelector) {
            if (option.getAttribute("option-label").equalsIgnoreCase(size)) {
                elementMethods.moveToElement(option);
                option.click();
                return;
            }
        }
        throw new RuntimeException("Wanted to select size '" + size + "', but it was not found among available options.");
    }


    public void selectColorForFirstProductInGrid(String color) {
        hoverOverFirstProductInGrid();
        for (WebElement option : colorsSelector) {
            if (option.getAttribute("option-label").equalsIgnoreCase(color)) {
                elementMethods.moveToElement(option);
                option.click();
                return;
            }
        }
        throw new RuntimeException("Wanted to select color '" + color + "', but it was not found among available options.");
    }

    public void clickAddToCart() {
        hoverOverFirstProductInGrid();
        elementMethods.clickElement(addToCartButton);
    }

    public boolean isProductAddedToCart() {
        return elementMethods.isElementVisible(addedToCartConfirmationMessage);
    }

    public void openShoppingCartPage() {
        elementMethods.clickElement(openMiniCartButton);
        elementMethods.clickElement(goToCartButton);
    }

}
