Feature: Hotel Booking login 

Scenario: opening the login page 
	Given User open the login page 
	Then Title must be as "Hotel Booking Login" 
	
Scenario: Unsuccessful login 
	Given User open the login page 
	When User Enter Wrong credential User Name as "XYZ" and Password as "ZYX" 
	Then a alert is generated with message as "Invalid login! Please try again!" 
	
Scenario: Unsuccessful login, when username field is blank 
	Given User open the login page 
	When User Enter Wrong credential User Name as "" and Password as "ZYX" 
	Then a error is generated with message as "* Please enter userName." 
	
	
Scenario: Unsuccessful login, when password field is blank 
	Given User open the login page 
	When User Enter Wrong credential User Name as "XYZ" and Password as "" 
	Then a error is generated with message as "* Please enter password." 
	
Scenario: Successful login
	Given User open the login page 
	When User Enter Valid credential User Name as "capgemini" and Password as "capg1234" 
	Then Title must be as "Hotel Booking" 
	