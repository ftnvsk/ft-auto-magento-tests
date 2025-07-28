package helperMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.function.Function;

import java.time.Duration;

public class ElementMethods {

    public WebDriver driver;
    private final Actions elementAction;
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);
    private static final Duration DEFAULT_POLLING = Duration.ofMillis(500);

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
        this.elementAction = new Actions(driver);
    }

    // === GENERIC BOOLEAN FLUENT WAIT ===
    private void waitUntilTrue(Function<WebDriver, Boolean> condition) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .pollingEvery(DEFAULT_POLLING)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(condition);
    }

    private Function<WebDriver, Boolean> elementCanBeClicked(WebElement element) {
        return d -> {
            try {
                element.click();
                return true;
            } catch (ElementNotInteractableException e) {
                return false;
            }
        };
    }

    // === ELEMENT ACTIONS ===

    public void clickElement(WebElement element) {
        waitVisibleElement(element);
        waitUntilTrue(elementCanBeClicked(element));
    }

    public void waitVisibleElement(WebElement element) {
        waitUntilTrue(d -> {
            try {
                return element.isDisplayed();
            } catch (Exception e) {
                return false;
            }
        });
    }

    public void fillElement(WebElement element, String value) {
        waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void selectDropDownText(WebElement element, String text) {
        waitVisibleElement(element);
        Select elementSelect = new Select(element);
        elementSelect.selectByVisibleText(text);
    }

    public void selectDropValue(WebElement element, String value) {
        waitVisibleElement(element);
        Select elementSelect = new Select(element);
        elementSelect.selectByValue(value);
    }

    public void validateElementMessage(By by, String expMessage) {
        WebElement errElement =driver.findElement(by);
        String actualMessage = errElement.getText();
        Assert.assertEquals(actualMessage, expMessage);
    }

    public void validateElementMessage(WebElement element, String expMessage) {
        String actualMessage = element.getText();
        Assert.assertEquals(actualMessage, expMessage);
    }

    public void moveToElement(WebElement element) {
        waitVisibleElement(element);
        elementAction.moveToElement(element).perform();
    }

    public void scrollToElementJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitVisibleElement(element);
    }

    public void scrollToElement(WebElement element) {
        elementAction.scrollToElement(element).perform();
    }

    public boolean isElementVisible(WebElement element) {
        try {
            waitVisibleElement(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
