#username and password hardcoded
#Feature: Free CRM Login feature
#Scenario: Free CRM login Test Scenario
#Given User is already on login Page
#When Title of the login page is Free CRM
#Then User enters Username and Password
#Then User clicks on Login Button
#And User is on Home Page
#Then close the browser

#Data driven testing without using Examples keywords
#Feature: Free CRM Login feature
#Scenario: Free CRM login Test Scenario
#Given User is already on login Page
#When Title of the login page is Free CRM
#Then User enters "rakeshit0913@gmail.com" and "Qualix2019"
#Then User clicks on Login Button
#And User is on Home Page
#Then close the browser


#Data driven testing with using Examples keywords
Feature: Free CRM Login feature
Scenario Outline: Free CRM login Test Scenario
Given User is already on login Page
When Title of the login page is Free CRM
Then User enters "<username>" and "<password>"
Then User clicks on Login Button
And User is on Home Page
Then close the browser

Examples: 
| username|| password|

| rakeshit0913@gmail.com|| Qualix2019|
| jharakesh1.1990@gmail.com|| Qualix2019|
