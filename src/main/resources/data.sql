insert into tbl_address (add_id, country, city, street) values
(105, 'Canada', 'Oshawa', '2718 Toy Avenue'),
(274, 'Canada', 'Toronto', '2255 Adelaide St'),
(421, 'USA', 'New York', '4561 Small Street');

insert into tbl_employee (emp_id, name, addr_id) values
(103, 'Jhon Doe', 105),
(104, 'Jane Smith', 274),
(105, 'Tom Jones', 421);