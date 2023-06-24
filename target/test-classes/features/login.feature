Feature: Login functionality

Scenario: Login with valid credentials
Given User navigates to login page
When User has enteres valid email address "karanpachunde334@gmail.com" into the email field
And User has enteres valid password "123456" into the password field
And User clicks on login button
Then User should get successfully logged in

Scenario: Login with invalid credentials
Given User navigates to login page
When User has enteres invalid email address "amoturi9@gmail.com" into the email field
And User has enteres invalid password "123456789" into the password field
And User clicks on login button
Then User should get a proper warning message about credential mismatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User has enteres valid email address "karanpachunde334@gmail.com" into the email field
And User has enteres invalid password "123456789" into the password field
And User clicks on login button
Then User should get a proper warning message about credential mismatch

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User has enteres invalid email address "amoturi9@gmail.com" into the email field
And User has enteres valid password "123456" into the password field
And User clicks on login button
Then User should get a proper warning message about credential mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When User do not entres email address into email field
And User do not enters password into password field
And User clicks on login button
Then User should get a proper warning message about credential mismatch