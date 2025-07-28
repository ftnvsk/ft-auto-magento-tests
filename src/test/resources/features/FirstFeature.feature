@FilipFirstTestsSuite
Feature: Filip Tests with Cucumber

  Background:
    Given The user opens up the automation testing store website

  @RegressionTest
  Scenario Outline: Guest user can add a product in the cart
    When The user is on the homepage
    And The user selects size "<Size Option>" for the 1st product in the homepage grid
    And The user selects color "<Color Option>" for the 1st product in the homepage grid
    And The user clicks on 'Add to Cart' button
    Then The user should see a confirmation message that product was added to the cart
    Examples:
      | Size Option | Color Option |
      | XS          | Purple       |

  @RegressionTest
  Scenario Outline: Guest user can place a full order
    When The user is on the homepage
    And The user selects size "<Size Option>" for the 1st product in the homepage grid
    And The user selects color "<Color Option>" for the 1st product in the homepage grid
    And The user clicks on 'Add to Cart' button
    Then The user should see a confirmation message that product was added to the cart
    When The user opens the mini cart
     And The user clicks on 'Proceed to Checkout' button
    And The user fills in the shipping information:
      | Email        | opaboba@opaboba.ro  |
      | First Name   | TestFirstName       |
      | Last Name    | TestLastName        |
      | Street       | Str. Test 123       |
      | City         | RandomCityTst       |
      | State        | Armed Forces Africa |
      | Zip Code     | 12345-6789          |
      | Phone Number | 0740123456          |
    And The user selects shipping method and proceeds
    And The user places the order
    Then A confirmation message should be displayed
    Examples:
      | Size Option | Color Option |
      | XS          | Orange       |

  @RegressionTest
  Scenario Outline: Existing user signs in at checkout and places an order
    When The user is on the homepage
    And The user selects size "<Size Option>" for the 1st product in the homepage grid
    And The user selects color "<Color Option>" for the 1st product in the homepage grid
    And The user clicks on 'Add to Cart' button
    Then The user should see a confirmation message that product was added to the cart
    When The user opens the mini cart
    And The user clicks on 'Proceed to Checkout' button
    And The user signs in during checkout with an existing account
    Then The user should see the shipping address to be pre-filled
    When The user selects shipping method and proceeds
    And The user places the order
    Then A confirmation message should be displayed
    Examples:
      | Size Option | Color Option |
      | M           | Purple       |
