Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field
And User clicks on login button
Then User should get successfully logged in
Examples:
|username                 |password    | 
|subhabosu151198@gmail.com|Qwerty@70752|

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into email field
And User enters invalid password "1234567890" into password field
And User clicks on login button
Then User should get a warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "subhabosu151198@gmail.com" into email field
And User enters invalid password "1234567890" into password field
And User clicks on login button
Then User should get a warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email address into email field
And User enters valid password "Qwerty@70752" into password field
And User clicks on login button
Then User should get a warning message about credentials mismatch

Scenario: Login without providing any credentails
Given User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on login button
Then User should get a warning message about credentials mismatch