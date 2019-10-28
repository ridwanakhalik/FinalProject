@web @regression @sprint
Feature: DarkSky Register Error Message
  Background:


   @sprint_1
  Scenario: Verify invalid signup error message
     Given I am on darksky.net
    When I click on Dark Sky API
     And I click on the SignUp button
    And I click on Register button
    Then I verify error message "please fill out this field"

  @sprint_2
  Scenario: Verify Current Temperature should not be greater or less than the temperature from daily timeline
    Given I am on darksky
  Then I verify current temp is not greater or less than temps from daily timeline

  @sprint_3
  Scenario: Verify individual day temp timeline
    Given I am on Darksky Home Page
    When I expand todays timeline
    Then I verify lowest and highest temp is displayed correctly
   @sprint_4
  Scenario: Verify timeline is displayed in correct format
    Given I am on DShome page
    Then I verify timeline is displayed with two hours incremented