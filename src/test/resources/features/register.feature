Feature: Register functionality

Scenario: User creates an account only with mandetory fields
Given User navigates to register account page
When User enters below detail into the field
|firstName|Karan                 |
|lastName |Pachunde              |
|email    |kpachunde333@gmail.com|
|telephone|1234567800            |
|password |admin12345            |
And User selects privacy policy checkbox
And User clicks on continue button
Then Account should get successfully created

Scenario: User creates an account with all fields
Given User navigates to register account page
When User enters below detail into the field
|firstName|Karan                 |
|lastName |Pachunde              |
|email    |kpachunde333@gmail.com|
|telephone|1234567800            |
|password |admin12345            |
And User selects yes for Newsletter
And User selects privacy policy checkbox
And User clicks on continue button
Then Account should get successfully created

Scenario: User creates a duplicate account
Given User navigates to register account page
When User enters below detail into the field
|firstName|Karan                     |
|lastName |Pachunde                  |
|email    |karanpachunde334@gmail.com|
|telephone|1234567800                |
|password |admin12345                |
And User selects yes for Newsletter
And User selects privacy policy checkbox
And User clicks on continue button
Then Account should get a proper warning about duplicate email

Scenario: User creates an account wothout filling any details
Given User navigates to register account page
When User dont enteres any details into field
And User clicks on continue button
Then User should get a proper warning message for every mandetory field
