Feature: Login and Logout Feature
  Verify if user is able to Login in to the site
  
  Background:
  Given user is on homepage which is "https://www.amazon.com"

	@SC01
  Scenario Outline: Login as a authenticated user
    When user navigates to Login Page
    And user enters "<Username>" and "<Password>"
    Then success message is displayed
    When User clicks on logout button
    Then User should be logged out successfully

    Examples: 
      | Username             | Password |
      | shaharpan8@yahoo.com | test123  |

		@SC02
    Scenario: Add Item in a cart
    When User search for an item "Headphone"
    And User select an item and add item in a cart
    Then User verify that item added in a cart successfully