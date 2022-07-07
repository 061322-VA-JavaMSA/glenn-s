drop table if exists roles;
CREATE table if not exists  roles (
id SERIAL  PRIMARY KEY,
role_name varchar(30)  not null
);

drop table if exists users;
CREATE table if not exists  users (
id SERIAL  PRIMARY KEY,
username varchar(30)  not null,
password varchar(30)  not null,
status integer NULL DEFAULT 1,
role_id integer references roles(id)
);

drop table if exists products;
CREATE table if not exists  products (
id SERIAL  PRIMARY KEY,
product_name varchar(100)  not null,
price decimal DEFAULT 0,
paid_status integer NULL DEFAULT 0,
user_id integer references users(id)
);

drop table if exists offers;
CREATE table if not exists  offers (
id SERIAL  PRIMARY KEY,
offer_price decimal  DEFAULT 0,
status integer DEFAULT 0,
product_id integer references products(id),
created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
user_id integer references users(id)
);
 
drop table if exists payment_connection;
CREATE table if not exists  payment_connection (
id SERIAL  PRIMARY KEY,
transaction_no varchar(255) NULL,
offer_price decimal  DEFAULT 0,
payment_details varchar(255), 
active integer DEFAULT 0,
user_id integer references users(id),
product_id integer references products(id),
offers_id integer references offers(id),
);

drop table if exists payment; 
CREATE table if not exists  payment (
id SERIAL  PRIMARY KEY,
paid decimal  DEFAULT 0,
active integer DEFAULT 0,
primary_payment integer DEFAULT 0,
payment_connection_id integer references payment_connection(id),
created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP
); 
 