Feature: Images of the products are loading fine on SauceDemo
  As a SauceDemo user,
  I want to validate the images of the products
  So that I can see the view of the products and continue my shopping successfully.

  Scenario: Sorting the products in the homepage
    Given User launches the login page
    Then User should land on the login page as expected
    When user should able to enter the valid username and password on the login page
    And clicks on the login button
    Then user should see the homepage of SauceDemo
    And User should see all product images loaded successfully
    