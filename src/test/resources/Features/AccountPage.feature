Feature: Account Page Feature

Background:
Given user has already loggged in to the application
|username|password|
|testlogin@gmail.com|Selenium@12345|

@Accounts
@Severity=Minor
Scenario: Accounts Page title
Given user is on Accounts page
When user gets the title of the page
Then the page title should be "My account - My Store"

@Accounts
@Severity=High
Scenario: Account section count
Given user is on Accounts page
Then user gets account section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And account section count should be 6
