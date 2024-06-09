
@tag
Feature: Error Validation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on ecommerce page.
    When Logged in with with username <Username> and password <pwd>
    Then "Incorrect1 email or password." message is displayed.

    Examples: 
       | Username		        |	  pwd      | 
      | ss123@gmail.com			|		Test@2123 |