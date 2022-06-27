/*
select concat_ws(' ', street,city,state,zip )  as sales_location, 
concat_ws(' ', c.firstname,c.lastname  )  as customername, 
concat_ws( ' ' , e.firstname, e.lastname  ) as sales_representative 
from salesoffice s 
left join  salesoffice_customer sc  on  sc.salesofficeid = s.id
left join customer c  on sc.customerid = c.id
left join  employee_customer  ec on ec.customerid = c.id
left join  employee  e on ec.employeeid = e.id
where c.id IS NOT null order by  s.id;


*/

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
employeeid integer references employee{id),
customerid integer references customer{id),
PRIMARY KEY (employeeid, customerid)
);

CREATE table salesoffice_customer (
salesofficeid integer references salesoffice(id),
customerid integer references customer(id),
PRIMARY KEY (salesofficeid, customerid)
);
