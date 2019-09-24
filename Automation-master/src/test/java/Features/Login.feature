Feature: Login and Logout Feature
  Verify if user is able to Login in to the site

Scenario: Login as a authenticated user
    Given user is on homepage which is "https://www.amazon.com"
    When user navigates to Login Page 
    And user enters "shaharpan8@yahoo.com" and "test123"
    Then success message is displayed
    And user go to logout button
    
    
