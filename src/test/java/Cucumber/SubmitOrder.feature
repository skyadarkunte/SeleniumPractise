#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Regression
Feature: Purchase the Order from Ecommerce Website
  I want to use this template for my feature file
Background:
Given I landed on ecommerce page.
 


  @tag2
  Scenario Outline: Positive Test of Submitting the Order
    Given Logged in with username <Username> and password <pwd> 
    When I add Product <productname> to Cart
    And Checkout <productname> and submit the order.
    Then "Thankyou for the order." message is displayed on confirmaton page.

    Examples: 
      | Username		        |	  pwd      | productname	|
      | ss123@gmail.com			|		Test@123 | ZARA COAT 3	|
      
