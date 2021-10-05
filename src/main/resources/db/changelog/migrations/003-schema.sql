alter table hw_jdbc.ORDERS
    add constraint fk_product_name foreign key (product_name)
        references hw_jdbc.PRODUCTS (name);