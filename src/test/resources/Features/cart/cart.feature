Feature: cart functionality on SauceDemo
  As a SauceDemo user,
  I want to add products to my cart
  So that I can review my selections before checkout

  Scenario: Add item to cart and verify cart count
    Given User launches the login page
    Then User should land on the login page as expected
    When user should able to enter the valid username and password on the login page
    And clicks on the login button
    Then user should see the homepage of SauceDemo
    When the user add the product by clicking on add to cart button:
      | Sauce Labs Backpack      |
      | Sauce Labs Onesie        |
      | Sauce Labs Fleece Jacket |
    Then the product count "3" should appear in the shopping cart container
