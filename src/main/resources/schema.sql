create table hw_jdbc.CUSTOMERS
(
    id           serial primary key,
    name         varchar(300)                               not null,
    surname      varchar(300)                               not null,
    age          int check ( age >= 0 ) check ( age < 150 ) not null,
    phone_number varchar(50) default "Unknown"
);

create table hw_jdbc.ORDERS
(
    id           serial primary key,
    date         datetime default now(),
    customer_id  bigint unsigned,
    product_name varchar(100)             not null,
    amount       int check ( amount > 0 ) not null,
    foreign key (customer_id)
        references CUSTOMERS (id)
);

CREATE INDEX c_name ON CUSTOMERS (name);
