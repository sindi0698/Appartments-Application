# Appartments-Application

Write a web application that helps user search for available apartments to rent in different cities of Albania
Main page contains a form where user can input the surface area the rent amount and the city where he/she is looking for an apartment to rent. 

* After submitting the form, all available apartments get displayed in a table format.
* Have information about apartments stored and read from a text file
* Validate on backend the input received - if input is not valid (example rent amount is not typed correctly), a error is shown in the frontend.
* Customers can access the main page of the application if they login to the application - otherwise they get redirected to the login page where there's the form to input username and password.

* Implement a LoginServlet used for the login. Only allow login using these static credentials: admin / 12345678. After a successful login create user session (HttpSession) and set it to expire after 10 min of inactivity.
* Implement a servlet to handle requests of searching for apartments
* Implement a LoginFilter used to redirect users to login page if they are not logged-in or session has expired.
