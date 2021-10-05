create table hw_jdbc.PRODUCTS
(
    name        varchar(100) primary key not null,
    customer_id bigint unsigned default null,
    foreign key (customer_id)
        references hw_jdbc.CUSTOMERS (id)
);