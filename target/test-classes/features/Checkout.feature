Feature: Checkout Feature

 
  Scenario: Verify that product Details are displayed
    Given User is navigated to the automation practice website
    When User is scroll down to choose the desired item
    When User is adding "Thinking in HTML" book to the Shopping cart page
    Then User is validated that the selected item is added to cart with its details successfully
  #@test
  Scenario: Proceed To Checkout and veriy the Billing details Form
    Given User is navigated to the automation practice website
    When User is scroll down to choose the desired item
    When User is adding "Thinking in HTML" book to the Shopping cart page
    And  User is Proceed To checkout 
    Then The Billing details form is displayed successfully
