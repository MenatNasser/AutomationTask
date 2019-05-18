# AutomationTask
This is to do automation task sent for adding new admin, editing his rules and adding new locations. 

Used Page object model design pattern to easiness the maintainability of the web elements used in the automation script. 

Test scenarios covered:
Existing Admin login- Successful login with accurate credentials 
Existing Admin login- Validating on not entering any wrong email/password
Existing Admin login-Validating on not entering invalid email
Existing Admin login- Validating on forget password link
Dashboard- Add admin- Validating on filling in blank form for new admin creation
Dashboard- Add admin- Validation on entering  short password
Dashboard- Add admin- Validation on entering invalid email
Dashboard- Add admin- Validating on entering repeated email
Dashboard- Add admin- Successful new admin add
Dashboard- Edit admin- Adding Permissions  of add/edit to the new admin. 
Dashboard- Add location- Successful add to new location by new admin created
Dashboard- Edit location- Successful to edit in the new location
Dashboard- Delete location- Validation on incapability of deleting new location by new admin