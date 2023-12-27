Feature: Add an item to the cart

 //@test
  Scenario: Check that an item is exist
    Given User is navigated to the automation practice website
    When User is scroll down to choose the desired item
    Then The "Thinking in HTML" book is displayed along with its price
