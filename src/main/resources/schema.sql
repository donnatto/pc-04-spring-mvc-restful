create table tbl_address (
    add_id int primary key,
    country varchar(100) not null,
    city varchar(100) not null,
    street varchar(100) not null
);

create table tbl_employee (
    emp_id int identity primary key,
    name varchar(100) not null,
    addr_id int not null
);

