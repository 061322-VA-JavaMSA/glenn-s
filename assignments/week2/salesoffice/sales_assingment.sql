CREATE table salesoffice (
id SERIAL  PRIMARY KEY,
street varchar(30)  not null,
city varchar(30)  not null,
state varchar(30)  not null,
zip INTEGER not null
);

CREATE table employee (
id SERIAL  PRIMARY KEY,
firstname varchar(30)  not null,
lastname varchar(30)  not null,
dob date not null,
salesofficeid integer references salesoffice(id)
);

CREATE table customer (
id SERIAL  PRIMARY KEY,
firstname varchar(30)  not null,
lastname varchar(30)  not null
);


CREATE table employee_customer (
employeeid integer,
customerid integer,
PRIMARY KEY (employeeid, customerid)
);

CREATE table salesoffice_customer (
salesofficeid integer references salesoffice(id),
customerid integer references customer(id),
PRIMARY KEY (salesofficeid, customerid)
);
