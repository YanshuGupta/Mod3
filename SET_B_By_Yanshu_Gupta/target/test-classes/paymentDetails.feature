Feature: Conference Booking and Payments Feature 

Background:
User is Registered and fill the valid Conference booking page details 

Scenario: User will try to make payment for conference room booking with invalid set of information 

	Given User is on Payment page 
	Then The Title of the page must be "Payment Details"
	
	When User Click 'Make Payment' without entering 'Card holder name' 
	Then 'Please fill the Card holder name' message must be display 
	
	When User Click 'Make Payment' button without entering 'Debit card Number' 
	Then 'Please fill the Debit card Number' message must be display 
	
	When User Click 'Make Payment' button without entering 'Please fill the CVV Number' 
	Then 'Please fill the CVV' message must be display 
	
	When User Click 'Make Payment' button without entering 'Expiration month' 
	Then 'Please fill expiration month' message must be display 
	
	When User Click 'Make Payment' button without entering 'Expiration year' 
	Then 'Please fill the expiration year' message must be display 
	
Scenario: User will try to make payment for conference room booking with Valid set of information 
	Given User is on Payment page 
	When User Click 'Make Payment' button after entering valid 'payment details' 
	Then 'Conference Room Booking successfully done!!!' message should display 
	
	
 