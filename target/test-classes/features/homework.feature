@web @regression @homework
Feature: Homework
#
   Background:
   Given I am using chrome browser
    And I am on facebook sign up page
#
#  @homework-1
  Scenario Outline: Verify invalid email address for multiple user
  When I enter Ridwana into Firstname And  Lastname text fields on home screen
  And I enter ridwana@@yahoo.com into email text fields on home screen
  And I click on NewPassWord button on the home screen
  Then verify Red Warning button on the home screen
  When I enter <email> into email text fields on home screen
  Then I verify that i have an invalid email address

  #  Scenario Outline: Verify invalid email address for multiple user
  Examples:
  | email                          |
  | #@%^%#$@#$@#.com               |
  | @example.com                   |
  | Joe Smith <email@example.com>  |
  | email.example.com              |
  | email@example@example.com      |
  | .email@example.com             |
  | email.@example.com             |
  | email..email@example.com       |
  | あいうえお@example.com          |
  | email@example.com (Joe Smith)  |
  | email@example                  |
  | email@-example.com             |
  | email@example.web              |
  | email@111.222.333.44444        |
  | email@example..com             |
  | Abc..123@example.com           |


  @homework-2
  Scenario: Verify current month
#    #Steps
#
#  @homework-3
#  Scenario:
#    #Steps

#  * Homework 1: Signup form should not accept any invalid email address
#        * 1. Enter Firstname
#        * 2. Enter Lastname
#        * 3. Enter Invalid Email
#        * 4. Click on New Password text field
#        * 5. Click on red warning button on email field
#        *
#        * 6. Verify Error Message “Please enter a valid mobile number or email address.”
#        */
#       /**
#        * List of Invalid Email Addresses
#        *
#        * plainaddress
#        * #@%^%#$@#$@#.com
#        * @example.com
#        * Joe Smith <email@example.com>
#        * email.example.com
#        * email@example@example.com
#        * .email@example.com
#        * email.@example.com
#        * email..email@example.com
#        * あいうえお@example.com
#        * email@example.com (Joe Smith)
#        * email@example
#        * email@-example.com
#        * email@example.web
#        * email@111.222.333.44444
#        * email@example..com
#        * Abc..123@example.com
#        */
#   /**
#   * Homework #2: Select the current month from month dropdown
#   */
#   /**
#   * Homework #3: Find out if dropdown contains duplicates, if yes fail
#     the test and print the duplicate values
#   */
#   /**
#  * Homework #4: Create basepage action for,public boolean isDisplayed(By locator), isSelected(By locator), isEnabled(By locator),
#  selectByText(By locator, String text), selectByIndex(By locator, int index), selectByValue(By locator, String value),
#  isDropDownContainsValue(By locator, String value), isDropdownHasDuplicates(By locator)