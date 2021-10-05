create table hw_jdbc.CUSTOMERS
(
    id           serial primary key,
    name         varchar(300)                               not null,
    surname      varchar(300)                               not null,
    age          int check ( age >= 0 ) check ( age < 150 ) not null,
    phone_number varchar(50) default "Unknown"
);

insert into hw_jdbc.CUSTOMERS(name, surname, age)
values ("Alexey", "B", 34),
       ("Danil", "K", 25),
       ("Anna", "S", 27),
       ("Oleg", "P", 44);

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

insert into hw_jdbc.ORDERS(customer_id, product_name, amount)
values (1, "product1Alexeys", 4555),
       (1, "product2Alexeys", 5000),
       (3, "product3Annas", 3674),
       (4, "product4Olegs", 3789);

CREATE INDEX c_name ON CUSTOMERS (name);
