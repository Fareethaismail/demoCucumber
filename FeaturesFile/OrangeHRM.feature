Feature: OrngHRM site feature

Scenario Outline: login feature
Given user is entering orngHRM page
When enter your "<userName>" and "<passWord>"
And click the login button
Then verify home page 

Examples: 
|userName	|passWord|
|Admin		|admin123|

Scenario Outline: login feature
Given user is entering leave page
When select the date 
And click the view button
Then verify leave page 

Scenario Outline: login feature
Given user is entering leave page first option
When enter your "<EmployeeName>" 
And click the view button one
Then verify the page 

Examples: 
|EmployeeName|
|Fiano Grace|

Scenario Outline: login feature
Given user is entering Assign leave page
When enter the "<EmployeeName>" 
And enter the "<fromdate>" and "<toDate>"
Then verify the assign leave page 

Examples: 
|EmployeeName||fromdate||toDate|
|Fiano Grace||2022-01-25||2022-01-26|


