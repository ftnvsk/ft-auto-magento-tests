## FT-Auto-Magento-Tests

This project contains automated UI tests for the Magento Demo Store, using Java, Selenium WebDriver, Cucumber, and TestNG.
🧪 Overview

The tests cover guest and registered user scenarios on the Magento storefront:

    Adding a product to cart

    Completing a full guest checkout

    Signing in during checkout

    Validating shipping address auto-fill and order confirmation

## 🛠️ Tech Stack

    Java 17

    Selenium WebDriver

    Cucumber (BDD)

    TestNG

    Maven

    WebDriverManager

## 📁 Project Structure

 - src
   - main
     - java
       - helperMethods (Custom utility methods (e.g., waits, actions))
       - pages (Page Object Model (POM) classes)
   - test
     - java
       - tests (Step definitions and runners)
     - resources
       - features (Cucumber feature files)


## ▶️ Running the Tests

`mvn clean test`

Tests are configured via testng.xml.

## ✅ Tags

You can run specific test categories using Cucumber tags:

    @RegressionTest

    @FilipFirstTests

🧑‍💻 Author

Filip Tanevski