Feature: Login page feature

@Login
@severity=High
Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then the page title should be "My Store"

@Login
@severity=High
Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be dispalyed

@Login
@severity=Critical
Scenario: Login with correct credentails
Given user is on login page
When user enters username "testlogin@gmail.com"
And user enters password "Selenium@12345"
When  user clicks on Login button
Then user gets the title of the page
And the page title should be "My account - My Store"