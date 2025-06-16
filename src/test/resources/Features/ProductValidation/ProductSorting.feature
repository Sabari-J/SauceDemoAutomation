Feature: Sorting the products functionality on SauceDemo
  As a SauceDemo user,
  I want to sort the products
  So that I can see the products in a desired way and continue my shopping successfully.

  Scenario: Sorting the products in the homepage
    Given User launches the login page
    Then User should land on the login page as expected
    When user should able to enter the valid username and password on the login page
    And clicks on the login button
    Then user should see the homepage of SauceDemo
    When User selects "Price (low to high)" from the sorting dropdown
    Then User should see products sorted in ascending price order
