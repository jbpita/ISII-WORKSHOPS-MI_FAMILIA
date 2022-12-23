Feature: Calculate the insurance price for a customer

  Scenario: The customer is over the accepted age
    Given he is over eighty years old
    When compute the premium
    Then show -1
     
  Scenario: The customer is under 80 years old and over 18 years old
    Given his age is between eighteen and eighty years old
    When compute the premium
    Then show 200
    
  Scenario: The customer is under age
    Given his age is under eighteen years old
    When compute the premium
    Then show -1