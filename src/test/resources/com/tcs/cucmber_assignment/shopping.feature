@shopping
Feature: This feature file is for shopping scenarios
  Shopping related scenarios will be craeted here

#I have created as scenario outline instead of scenario so that we can use the same test for different product shopping.

  @shop
  Scenario Outline: shopping different product from shopclues website
    Given User on shopclues website homepage
    And User close the push notification pop up
    When User select "<ProductCategory>" from home page and select "<Product>" from menu and change the focus to result page
    And User click on the first result displayed and change the focus to productdetails page
    And User click on Add to Cart button
    Then Validate the success message

    Examples: 
      | ProductCategory | Product  |
      | Home&Kitchen    | Curtains |
