Feature: Checkout Flow
  As a SauceDemo user,
  I want to add products to my cart
  So that I can checkout and complete the purchase

  Scenario: Complete checkout flow with item verification
    Given User launches the login page
    Then User should land on the login page as expected
    When user should able to enter the valid username and password on the login page
    And clicks on the login button
    Then user should see the homepage of SauceDemo
    When the user add the product by clicking on add to cart button:
      | Sauce Labs Backpack |
    And User navigates to the cart
    Then The cart should contain the product "Sauce Labs Backpack"
    When User proceeds to checkout
    And User enters checkout information with first name "sabari", last name "JS", and postal code "12345"
    And User clicks on Continue
    Then The checkout overview should display the product "Sauce Labs Backpac"
    When User clicks on Finish
    Then The order confirmation message should be "Thank you for your order!"