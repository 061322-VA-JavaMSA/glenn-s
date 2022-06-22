CREATE table roles (
id SERIAL  PRIMARY KEY,
role_name varchar(30)  not null
);

CREATE table users (
id SERIAL  PRIMARY KEY,
username varchar(30)  not null,
password varchar(30)  not null,
role_id integer references roles(id)
);

CREATE table products (
id SERIAL  PRIMARY KEY,
product_name varchar(100)  not null,
price decimal DEFAULT 0,
offer_price decimal DEFAULT 0,
paid decimal  DEFAULT 0,
user_id integer references users(id)
);

CREATE table offer (
id SERIAL  PRIMARY KEY,
offer_price decimal  DEFAULT 0,
status integer DEFAULT 0,
product_id integer references products(id),
user_id integer references users(id)
);