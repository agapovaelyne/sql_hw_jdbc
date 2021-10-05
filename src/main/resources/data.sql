insert into hw_jdbc.CUSTOMERS(name, surname, age)
values ("Alexey", "B", 34),
       ("Danil", "K", 25),
       ("Anna", "S", 27),
       ("Oleg", "P", 44);

insert into hw_jdbc.ORDERS(customer_id, product_name, amount)
values (1, "product1Alexeys", 4555),
       (1, "product2Alexeys", 5000),
       (3, "product3Annas", 3674),
       (4, "product4Olegs", 3789);
