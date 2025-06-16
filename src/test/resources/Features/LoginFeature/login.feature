
@smoke
Feature: Login functionality on SauceDemo
  As a SauceDemo user,
  I want to login with the valid user credentials
  So that I will access the web-site, products and continue my shopping successfully.
  
  @smoke
  Scenario: Successful login with valid credentials
    Given User launches the login page
    Then User should land on the login page as expected
    When user should able to enter the valid username and password on the login page
    And clicks on the login button
    Then user should see the homepage of SauceDemo
    
    @smoke
    Scenario: Failed login with invalid credentials
    Given User launches the login page
    Then User should land on the login page as expected
    When user enters the invalid username "admin123" and password "password_invalid" on the login page
    And clicks on the login button
    Then user should see the error message of SauceDemo