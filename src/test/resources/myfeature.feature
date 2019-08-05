@SmokeTest
Feature: Using user Form
  As a user,
  I want to register in the page,
  so I can be a user of this webpage
  
  Background:
   Given I open my DevOps practice web page

  Scenario: Verify that I can fill the user form
    When I enter my name "Carla"
    And I enter my password "awt03*"
    And I enter my age "50"
    And I click on Register button
    Then I see all my info registered

  Scenario: Verify that I can only type the user name in the form
    When I enter my name "Sandra"
    And I click on Register button
    Then I see my name registered  
    
  Scenario: Verify that I can only type the user password in the form
    And I enter my password "awt03*"
    And I click on Register button
    Then I see my password registered

  Scenario: Verify that I can only type the user age in the form
    When I enter my age "40"
    And I click on Register button
    Then I see my age registered          
        