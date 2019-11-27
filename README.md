# pc04-spring-mvc-restful-donnatto
>PC-04 Business Application Development II - Edwin Donato Dominguez Oliva


## Notes

- Address embedded in the Employee class
- Rest functionality for both employee and addresses (must insert address in the body of the employee to add one)
- Address id is the foreign key and identifier of the address in the Employee class
- MVC functionality to register, edit and delete an employee (includes the address as well)
- When registering, editing or updating an employee, it separates the logic for each service and repository (employee and address) so the employee table takes the name and the address id, and the address table takes the address id, country, city and street.
- h2 console enabled to test the correct functionality of the app. user: donnatto | password: password
